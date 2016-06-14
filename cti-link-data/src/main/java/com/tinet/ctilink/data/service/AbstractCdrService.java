package com.tinet.ctilink.data.service;

import com.tinet.ctilink.data.request.CdrGetRequest;
import com.tinet.ctilink.data.request.CdrQueryRequest;
import com.tinet.ctilink.data.response.ApiResult;

import java.util.List;
import java.util.Map;

/**
 * @author fengwei //
 * @date 16/6/14 17:39
 */
public abstract class AbstractCdrService {

    public ApiResult<Map<String, Object>> get(CdrGetRequest request) {
        return getCdrSupport().get(getTableName(), request);
    }

    public ApiResult<List<Map<String, Object>>> query(CdrQueryRequest request) {
        return getCdrSupport().query(getTableName(), request);
    }

    public abstract CdrSupport getCdrSupport();

    public abstract String getTableName();

}
