package com.huawei.hms.support.api.entity.location.enhance;

import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;

public class LocationSceneApiResponse extends LocationBaseResponse {
    private LocationSceneResponse locationSceneResponse;

    public LocationSceneResponse getLocationSceneResponse() {
        return this.locationSceneResponse;
    }

    public void setLocationSceneResponse(LocationSceneResponse locationSceneResponse2) {
        this.locationSceneResponse = locationSceneResponse2;
    }
}
