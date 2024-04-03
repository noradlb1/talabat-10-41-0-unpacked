package com.baseflow.geolocator.location;

import java.util.Map;

public class LocationOptions {
    private final LocationAccuracy accuracy;
    private final long distanceFilter;
    private final long timeInterval;
    private final boolean useMSLAltitude;

    private LocationOptions(LocationAccuracy locationAccuracy, long j11, long j12, boolean z11) {
        this.accuracy = locationAccuracy;
        this.distanceFilter = j11;
        this.timeInterval = j12;
        this.useMSLAltitude = z11;
    }

    public static LocationOptions parseArguments(Map<String, Object> map) {
        long j11;
        long j12;
        if (map == null) {
            return new LocationOptions(LocationAccuracy.best, 0, 5000, false);
        }
        Integer num = (Integer) map.get("accuracy");
        Integer num2 = (Integer) map.get("distanceFilter");
        Integer num3 = (Integer) map.get("timeInterval");
        Boolean bool = (Boolean) map.get("useMSLAltitude");
        LocationAccuracy locationAccuracy = LocationAccuracy.best;
        boolean z11 = true;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                locationAccuracy = LocationAccuracy.lowest;
            } else if (intValue == 1) {
                locationAccuracy = LocationAccuracy.low;
            } else if (intValue == 2) {
                locationAccuracy = LocationAccuracy.medium;
            } else if (intValue == 3) {
                locationAccuracy = LocationAccuracy.high;
            } else if (intValue == 5) {
                locationAccuracy = LocationAccuracy.bestForNavigation;
            }
        }
        LocationAccuracy locationAccuracy2 = locationAccuracy;
        if (num2 != null) {
            j11 = (long) num2.intValue();
        } else {
            j11 = 0;
        }
        if (num3 != null) {
            j12 = (long) num3.intValue();
        } else {
            j12 = 5000;
        }
        long j13 = j12;
        if (bool == null || !bool.booleanValue()) {
            z11 = false;
        }
        return new LocationOptions(locationAccuracy2, j11, j13, z11);
    }

    public LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public long getDistanceFilter() {
        return this.distanceFilter;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public boolean isUseMSLAltitude() {
        return this.useMSLAltitude;
    }
}
