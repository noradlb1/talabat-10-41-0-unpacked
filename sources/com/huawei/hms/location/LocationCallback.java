package com.huawei.hms.location;

import java.util.UUID;

public class LocationCallback {
    private final String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return this.uuid;
    }

    public void onLocationAvailability(LocationAvailability locationAvailability) {
    }

    public void onLocationResult(LocationResult locationResult) {
    }
}
