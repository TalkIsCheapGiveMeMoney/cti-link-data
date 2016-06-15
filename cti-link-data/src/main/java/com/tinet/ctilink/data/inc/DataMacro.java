package com.tinet.ctilink.data.inc;

import com.tinet.ctilink.cache.CacheKey;
import com.tinet.ctilink.cache.RedisService;
import com.tinet.ctilink.conf.model.SystemSetting;
import com.tinet.ctilink.inc.Const;
import com.tinet.ctilink.inc.SystemSettingConst;
import com.tinet.ctilink.util.ContextUtil;

import java.util.List;

/**
 * @author fengwei //
 * @date 16/6/14 15:06
 */
public class DataMacro {
    public static String CDR_IB_TABLE_NAME = "CdrIb";

    public static String CDR_IB_DETAIL_TABLE_NAME = "CdrIbDetail";

    public static String CDR_OB_AGENT_TABLE_NAME = "CdrObAgent";

    public static String CDR_OB_AGENT_DETAIL_TABLE_NAME = "CdrObAgentDetail";

    public static String CDR_OB_CUSTOMER_TABLE_NAME = "CdrObCustomer";

    public static String CDR_OB_CUSTOMER_DETAIL_TABLE_NAME = "CdrObCustomerDetail";

    public static String INVESTIGATION_RECORD_TABLE_NAME = "InvestigationRecord";

    public static String AWS_S3_BUCKET_NAME;

    public static int PRESIGNED_URL_EXPIRATION_MINUTE = 2;

    public static String PRESIGNED_URL_TYPE = "s3";

    public static String MODULE_DOWNLOAD_URL_PREFIX;

    public static void loadMacro() {
        RedisService redisService = ContextUtil.getBean(RedisService.class);
        List<SystemSetting> systemSettingList = redisService.getList(Const.REDIS_DB_CONF_INDEX, CacheKey.SYSTEM_SETTING
                , SystemSetting.class);

        for (SystemSetting systemSetting : systemSettingList) {
            switch (systemSetting.getName()) {
                case SystemSettingConst.SYSTEM_SETTING_NAME_AWS_S3_BUCKET_NAME:
                    AWS_S3_BUCKET_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_PRESIGNED_URL_EXPIRATION_TIME:
                    PRESIGNED_URL_EXPIRATION_MINUTE = Integer.parseInt(systemSetting.getValue());
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_PRESIGNED_URL_TYPE:
                    PRESIGNED_URL_TYPE = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_MODULE_DOWNLOAD_URL_PREFIX:
                    MODULE_DOWNLOAD_URL_PREFIX = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_IB_TABLE_NAME:
                    CDR_IB_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_IB_DETAIL_TABLE_NAME:
                    CDR_IB_DETAIL_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_OB_AGENT_TABLE_NAME:
                    CDR_OB_AGENT_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_OB_AGENT_DETAIL_TABLE_NAME:
                    CDR_OB_AGENT_DETAIL_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_OB_CUSTOMER_TABLE_NAME:
                    CDR_OB_CUSTOMER_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_CDR_OB_CUSTOMER_DETAIL_TABLE_NAME:
                    CDR_OB_CUSTOMER_DETAIL_TABLE_NAME = systemSetting.getValue();
                    break;
                case SystemSettingConst.SYSTEM_SETTING_NAME_INVESTIGATION_RECORD_TABLE_NAME:
                    INVESTIGATION_RECORD_TABLE_NAME = systemSetting.getValue();
                    break;
            }
        }
    }
}
