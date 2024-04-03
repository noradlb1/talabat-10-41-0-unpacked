package com.huawei.hms.support.api.entity.location.geocoder;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

public class GeocoderRequest extends LocationBaseRequest {
    @Packed
    private String country;
    @Packed
    private String language;
    @Packed
    private double latitude;
    @Packed
    private String locationName;
    @Packed
    private double longitude;
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

    public GeocoderRequest(Context context, double d11, double d12, int i11) {
        super(context);
        this.latitude = d11;
        this.longitude = d12;
        this.maxResults = i11;
    }

    public GeocoderRequest(Context context, String str, int i11) {
        super(context);
        this.locationName = str;
        this.maxResults = i11;
    }

    public String getCountry() {
        return this.country;
    }

    public String getLanguage() {
        return this.language;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public double getLongitude() {
        return this.longitude;
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

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLatitude(double d11) {
        this.latitude = d11;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(double d11) {
        this.longitude = d11;
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
