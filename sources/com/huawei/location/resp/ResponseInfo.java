package com.huawei.location.resp;

import com.huawei.hms.core.aidl.IMessageEntity;

public class ResponseInfo implements IMessageEntity {
    private LocationAvailabilityInfo locationAvailability;
    private Vw locationResult;

    public LocationAvailabilityInfo getLocationAvailability() {
        return this.locationAvailability;
    }

    public Vw getLocationResult() {
        return this.locationResult;
    }

    public void setLocationAvailability(LocationAvailabilityInfo locationAvailabilityInfo) {
        this.locationAvailability = locationAvailabilityInfo;
    }

    public void setLocationResult(Vw vw2) {
        this.locationResult = vw2;
    }
}
