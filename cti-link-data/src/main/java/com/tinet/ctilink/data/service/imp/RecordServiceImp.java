package com.tinet.ctilink.data.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.tinet.ctilink.aws.AwsS3Service;
import com.tinet.ctilink.cache.RedisService;
import com.tinet.ctilink.data.inc.DataConst;
import com.tinet.ctilink.data.inc.DataMacro;
import com.tinet.ctilink.data.service.CtiLinkRecordService;
import com.tinet.ctilink.inc.Const;
import com.tinet.ctilink.util.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author fengwei //
 * @date 16/6/15 13:20
 */
@Service
public class RecordServiceImp implements CtiLinkRecordService {

    @Autowired
    private AwsS3Service awsS3Service;

    @Autowired
    private RedisService redisService;

    @Override
    public String getPresignedUrl(String recordType, String recordFile) {
        //格式 20160615/recordType/6000001/recordFile
        String[] temp = recordFile.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(temp[1].substring(0, 8)).append(DataConst.SEPARATOR).append(recordType).append(DataConst.SEPARATOR)
                .append(temp[0]).append(DataConst.SEPARATOR).append(recordFile).append(DataConst.CDR_RECORD_FILE_SUFFIX);

        String presignedUrl = null;
        if (DataMacro.PRESIGNED_URL_TYPE.equals(DataConst.PRESIGNED_URL_TYPE_S3)) {
            presignedUrl = awsS3Service.getAwsS3Url(DataMacro.AWS_S3_BUCKET_NAME, sb.toString()
                    , DataMacro.PRESIGNED_URL_EXPIRATION_MINUTE * 60 * 1000L);
        } else if (DataMacro.PRESIGNED_URL_TYPE.equals(DataConst.PRESIGNED_URL_TYPE_NFS)) {
            presignedUrl = getNFSUrl(sb.toString());
        }
        return presignedUrl;
    }

    private String getNFSUrl(String recordFile) {
        UUID uuid = UUID.randomUUID();
        String token = MD5Encoder.encode(uuid + recordFile);
        redisService.set(Const.REDIS_DB_SESSION_INDEX, token, token);
        redisService.expire(Const.REDIS_DB_SESSION_INDEX, token, DataMacro.PRESIGNED_URL_EXPIRATION_MINUTE, TimeUnit.MINUTES);

        return DataMacro.MODULE_DOWNLOAD_URL_PREFIX + DataConst.SEPARATOR + recordFile + "?token=" + token;
    }
}
