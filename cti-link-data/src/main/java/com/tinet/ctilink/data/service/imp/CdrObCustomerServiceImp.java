package com.tinet.ctilink.data.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.tinet.ctilink.data.inc.DataMacro;
import com.tinet.ctilink.data.request.CdrGetRequest;
import com.tinet.ctilink.data.request.CdrQueryRequest;
import com.tinet.ctilink.data.response.ApiResult;
import com.tinet.ctilink.data.service.CtiLinkCdrObCustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author fengwei //
 * @date 16/6/14 17:36
 */
@Service
public class CdrObCustomerServiceImp implements CtiLinkCdrObCustomerService {

    @Autowired
    private CdrServiceImp cdrService;

    public ApiResult<Map<String, Object>> get(CdrGetRequest request) {
        return cdrService.get(DataMacro.CDR_OB_CUSTOMER_TABLE_NAME, request);
    }

    public ApiResult<List<Map<String, Object>>> query(CdrQueryRequest request) {
        return cdrService.query(DataMacro.CDR_OB_CUSTOMER_TABLE_NAME, request);
    }
}
