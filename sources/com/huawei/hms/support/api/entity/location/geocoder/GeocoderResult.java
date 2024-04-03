package com.huawei.hms.support.api.entity.location.geocoder;

import com.huawei.hms.support.api.client.Result;

public class GeocoderResult extends Result {
    private GeocoderResponse geocoderResponse;

    public GeocoderResponse getGeocoderResponse() {
        return this.geocoderResponse;
    }

    public void setGeocoderResponse(GeocoderResponse geocoderResponse2) {
        this.geocoderResponse = geocoderResponse2;
    }
}
