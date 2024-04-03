package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class GetFromLocationNameRequest implements IMessageEntity {
    @Packed
    private String locationName;
    @Packed
    private double lowerLeftLatitude;
    @Packed
    private double lowerLeftLongitude;
    @Packed
    private int maxResults;
    @Packed
    private double upperRightLatitude;
    @Packed
    private double upperRightLongitude;

    public GetFromLocationNameRequest(String str, int i11) {
        this.locationName = str;
        this.maxResults = i11;
    }

    public GetFromLocationNameRequest(String str, int i11, double d11, double d12, double d13, double d14) {
        this.locationName = str;
        this.maxResults = i11;
        this.lowerLeftLatitude = d11;
        this.lowerLeftLongitude = d12;
        this.upperRightLatitude = d13;
        this.upperRightLongitude = d14;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLowerLeftLatitude() {
        return this.lowerLeftLatitude;
    }

    public double getLowerLeftLongitude() {
        return this.lowerLeftLongitude;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public double getUpperRightLatitude() {
        return this.upperRightLatitude;
    }

    public double getUpperRightLongitude() {
        return this.upperRightLongitude;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLowerLeftLatitude(double d11) {
        this.lowerLeftLatitude = d11;
    }

    public void setLowerLeftLongitude(double d11) {
        this.lowerLeftLongitude = d11;
    }

    public void setMaxResults(int i11) {
        this.maxResults = i11;
    }

    public void setUpperRightLatitude(double d11) {
        this.upperRightLatitude = d11;
    }

    public void setUpperRightLongitude(double d11) {
        this.upperRightLongitude = d11;
    }
}
