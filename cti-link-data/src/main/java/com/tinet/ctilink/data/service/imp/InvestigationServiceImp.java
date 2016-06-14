package com.tinet.ctilink.data.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.tinet.ctilink.aws.AwsDynamoDBService;
import com.tinet.ctilink.data.inc.DataConst;
import com.tinet.ctilink.data.inc.DataMacro;
import com.tinet.ctilink.data.request.InvestigationGetRequest;
import com.tinet.ctilink.data.request.InvestigationQueryRequest;
import com.tinet.ctilink.data.response.ApiResult;
import com.tinet.ctilink.data.service.CtiLinkInvestigationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author fengwei //
 * @date 16/6/14 13:55
 */
@Service
public class InvestigationServiceImp implements CtiLinkInvestigationService {

    @Autowired
    private AwsDynamoDBService awsDynamoDBService;

    @Override
    public ApiResult<Map<String, Object>> get(InvestigationGetRequest request) {
        Item item = awsDynamoDBService.getItem(DataMacro.INVESTIGATION_RECORD, DataConst.INVESTIGATION_RECORD_HASH_KEY_NAME, request.getEnterpriseId()
                , DataConst.INVESTIGATION_RECORD_RANGE_KEY_NAME, request.getMainUniqueId());
        if (item != null) {
            new ApiResult<>(item.asMap());
        }
        return new ApiResult<>(ApiResult.SUCCESS_RESULT);
    }

    @Override
    public ApiResult<List<Map<String, Object>>> query(InvestigationQueryRequest request) {
        int limit = request.getLimit();
        if (limit == 0) {
            limit = 10;
        }
        if (limit > 5000) {
            limit = 5000;
        }

        String keyConditionExpression = "enterpriseId = :enterpriseId and endTime between :fromTime and :toTime";
        ValueMap valueMap = new ValueMap();
        valueMap.withInt(":enterpriseId", request.getEnterpriseId());
        valueMap.withLong(":fromTime", request.getFromTime());
        valueMap.withLong(":toTime", request.getToTime());
        ItemCollection<QueryOutcome> items = awsDynamoDBService.query(DataMacro.INVESTIGATION_RECORD, DataConst.INVESTIGATION_RECORD_END_TIME_INDEX_NAME
                , keyConditionExpression, valueMap, limit);
        if (items != null) {
            List<Map<String, Object>> list = new ArrayList<>();
            for (Item item : items) {
                list.add(item.asMap());
            }

            return new ApiResult<>(list);
        }
        return new ApiResult<>(ApiResult.SUCCESS_RESULT);
    }
}
