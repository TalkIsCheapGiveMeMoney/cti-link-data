package com.tinet.ctilink.data.request;

/**
 * @author fengwei //
 * @date 16/6/14 17:18
 */
public class CdrGetRequest {
    private int enterpriseId;

    private String uniqueId;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
