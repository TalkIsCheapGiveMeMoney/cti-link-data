package com.tinet.ctilink.data.request;

/**
 * @author fengwei //
 * @date 16/6/14 15:00
 */
public class InvestigationGetRequest {
    private int enterpriseId;

    private String mainUniqueId;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMainUniqueId() {
        return mainUniqueId;
    }

    public void setMainUniqueId(String mainUniqueId) {
        this.mainUniqueId = mainUniqueId;
    }
}
