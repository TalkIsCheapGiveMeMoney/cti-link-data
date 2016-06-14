package com.tinet.ctilink.data.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.tinet.ctilink.data.inc.DataMacro;
import com.tinet.ctilink.data.service.AbstractCdrService;
import com.tinet.ctilink.data.service.CdrSupport;
import com.tinet.ctilink.data.service.CtiLinkCdrObCustomerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fengwei //
 * @date 16/6/14 17:36
 */
@Service
public class CdrObCustomerServiceImp extends AbstractCdrService implements CtiLinkCdrObCustomerService {

    @Autowired
    private CdrSupport cdrSupport;

    @Override
    public CdrSupport getCdrSupport() {
        return cdrSupport;
    }

    @Override
    public String getTableName() {
        return DataMacro.CDR_OB_CUSTOMER_TABLE_NAME;
    }
}
