package com.tinet.ctilink.data.request;

/**
 * @author fengwei //
 * @date 16/6/14 15:00
 */
public class InvestigationQueryRequest {
    private int enterpriseId;

    private long fromTime;

    private long toTime;

    private int limit;

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public long getFromTime() {
        return fromTime;
    }

    public void setFromTime(long fromTime) {
        this.fromTime = fromTime;
    }

    public long getToTime() {
        return toTime;
    }

    public void setToTime(long toTime) {
        this.toTime = toTime;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
