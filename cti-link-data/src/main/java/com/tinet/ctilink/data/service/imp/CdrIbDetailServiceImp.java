package com.tinet.ctilink.data.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.tinet.ctilink.data.inc.DataMacro;
import com.tinet.ctilink.data.service.AbstractCdrService;
import com.tinet.ctilink.data.service.CdrSupport;
import com.tinet.ctilink.data.service.CtiLinkCdrIbDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fengwei //
 * @date 16/6/14 13:57
 */
@Service
public class CdrIbDetailServiceImp extends AbstractCdrService implements CtiLinkCdrIbDetailService {

    @Autowired
    private CdrSupport cdrSupport;

    @Override
    public CdrSupport getCdrSupport() {
        return cdrSupport;
    }

    @Override
    public String getTableName() {
        return DataMacro.CDR_IB_DETAIL_TABLE_NAME;
    }
}
