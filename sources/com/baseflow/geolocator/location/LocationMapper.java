package com.baseflow.geolocator.location;

import android.location.Location;
import android.os.Build;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.HashMap;
import java.util.Map;

public class LocationMapper {
    private static boolean isMocked(Location location) {
        if (Build.VERSION.SDK_INT >= 31) {
            return location.isMock();
        }
        return location.isFromMockProvider();
    }

    public static Map<String, Object> toHashMap(Location location) {
        if (location == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", Double.valueOf(location.getLatitude()));
        hashMap.put("longitude", Double.valueOf(location.getLongitude()));
        hashMap.put("timestamp", Long.valueOf(location.getTime()));
        hashMap.put("is_mocked", Boolean.valueOf(isMocked(location)));
        if (location.hasAltitude()) {
            hashMap.put(Param.ALTITUDE, Double.valueOf(location.getAltitude()));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26 && location.hasVerticalAccuracy()) {
            hashMap.put("altitude_accuracy", Float.valueOf(location.getVerticalAccuracyMeters()));
        }
        if (location.hasAccuracy()) {
            hashMap.put("accuracy", Double.valueOf((double) location.getAccuracy()));
        }
        if (location.hasBearing()) {
            hashMap.put("heading", Double.valueOf((double) location.getBearing()));
        }
        if (i11 >= 26 && location.hasBearingAccuracy()) {
            hashMap.put("heading_accuracy", Float.valueOf(location.getBearingAccuracyDegrees()));
        }
        if (location.hasSpeed()) {
            hashMap.put("speed", Double.valueOf((double) location.getSpeed()));
        }
        if (i11 >= 26 && location.hasSpeedAccuracy()) {
            hashMap.put("speed_accuracy", Double.valueOf((double) location.getSpeedAccuracyMetersPerSecond()));
        }
        if (location.getExtras() != null && location.getExtras().containsKey(NmeaClient.NMEA_ALTITUDE_EXTRA)) {
            hashMap.put(Param.ALTITUDE, Double.valueOf(location.getExtras().getDouble(NmeaClient.NMEA_ALTITUDE_EXTRA)));
        }
        return hashMap;
    }
}
