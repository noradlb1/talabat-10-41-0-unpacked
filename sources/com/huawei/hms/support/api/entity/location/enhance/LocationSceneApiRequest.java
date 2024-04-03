package com.huawei.hms.support.api.entity.location.enhance;

import android.content.Context;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

public class LocationSceneApiRequest extends LocationBaseRequest {
    private LocationSceneRequest locationSceneRequest;

    public LocationSceneApiRequest(Context context) {
        super(context);
    }

    public LocationSceneRequest getLocationSceneRequest() {
        return this.locationSceneRequest;
    }

    public void setLocationSceneRequest(LocationSceneRequest locationSceneRequest2) {
        this.locationSceneRequest = locationSceneRequest2;
    }
}
