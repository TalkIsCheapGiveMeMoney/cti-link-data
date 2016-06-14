package com.tinet.ctilink.data.request;

/**
 * @author fengwei //
 * @date 16/6/14 15:00
 */
public class InvestigationGetRequest {
    private Integer enterpriseId;

    private String mainUniqueId;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMainUniqueId() {
        return mainUniqueId;
    }

    public void setMainUniqueId(String mainUniqueId) {
        this.mainUniqueId = mainUniqueId;
    }
}
