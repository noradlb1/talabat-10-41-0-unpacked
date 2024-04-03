package com.huawei.location.resp;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;

public class CheckLocationSettingsResp extends LocationBaseResponse {
    @Packed
    private LocationSettingsStates locationSettingsStates;
    @Packed
    private StatusCheck statusCheck;

    public LocationSettingsStates getLocationSettingsStates() {
        return this.locationSettingsStates;
    }

    public StatusCheck getStatusCheck() {
        return this.statusCheck;
    }

    public void setLocationSettingsStates(LocationSettingsStates locationSettingsStates2) {
        this.locationSettingsStates = locationSettingsStates2;
    }

    public void setStatusCheck(StatusCheck statusCheck2) {
        this.statusCheck = statusCheck2;
    }
}
