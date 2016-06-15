package com.tinet.ctilink.data.service.imp;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.tinet.ctilink.aws.AwsDynamoDBService;
import com.tinet.ctilink.data.inc.DataConst;
import com.tinet.ctilink.data.request.CdrGetRequest;
import com.tinet.ctilink.data.request.CdrQueryRequest;
import com.tinet.ctilink.data.response.ApiResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fengwei //
 * @date 16/6/14 17:37
 */
@Service
public class CdrServiceImp {

    @Autowired
    private AwsDynamoDBService awsDynamoDBService;

    public ApiResult<Map<String, Object>> get(String tableName, CdrGetRequest request) {
        Item item = awsDynamoDBService.getItem(tableName, DataConst.CDR_HASH_KEY_NAME, request.getEnterpriseId()
                , DataConst.CDR_RANGE_KEY_NAME, request.getUniqueId());
        if (item != null) {
            new ApiResult<>(item.asMap());
        }
        return new ApiResult<>(ApiResult.SUCCESS_RESULT);
    }

    public ApiResult<List<Map<String, Object>>> query(String tableName, CdrQueryRequest request) {
        int limit = (request.getLimit() == 0) ? DataConst.CDR_LIMIT_DEFAULT
                : (request.getLimit() > DataConst.CDR_LIMIT_MAX ? DataConst.CDR_LIMIT_MAX : request.getLimit());

        String indexName;
        String keyConditionExpression;
        ValueMap valueMap = new ValueMap();
        if (StringUtils.isNotEmpty(request.getMainUniqueId())) {
            indexName = DataConst.CDR_MAIN_UNIQUE_ID_INDEX_NAME;
            keyConditionExpression = "cdr_enterprise_id = :enterpriseId and cdr_main_unique_id = :mainUniqueId";
            valueMap.withInt(":enterpriseId", request.getEnterpriseId());
            valueMap.withString(":mainUniqueId", request.getMainUniqueId());
        } else {
            indexName = DataConst.CDR_END_TIME_INDEX_NAME;
            keyConditionExpression = "cdr_enterprise_id = :enterpriseId and cdr_end_time between :fromTime and :toTime";
            valueMap.withInt(":enterpriseId", request.getEnterpriseId());
            valueMap.withLong(":fromTime", request.getFromTime());
            valueMap.withLong(":toTime", request.getToTime());
        }

        ItemCollection<QueryOutcome> itemCollection = awsDynamoDBService.query(tableName, indexName
                , keyConditionExpression, valueMap, limit);
        if (itemCollection != null) {
            List<Map<String, Object>> list = new ArrayList<>();
            for (Item item : itemCollection) {
                list.add(item.asMap());
            }
            return new ApiResult<>(list);
        }
        return new ApiResult<>(ApiResult.SUCCESS_RESULT);
    }

}
