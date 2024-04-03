package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class GetFromLocationRequest implements IMessageEntity {
    @Packed
    private double latitude;
    @Packed
    private double longitude;
    @Packed
    private int maxResults;

    public GetFromLocationRequest(double d11, double d12, int i11) {
        this.latitude = d11;
        this.longitude = d12;
        this.maxResults = i11;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setLatitude(double d11) {
        this.latitude = d11;
    }

    public void setLongitude(double d11) {
        this.longitude = d11;
    }

    public void setMaxResults(int i11) {
        this.maxResults = i11;
    }
}
