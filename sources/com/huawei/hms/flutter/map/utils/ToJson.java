package com.huawei.hms.flutter.map.utils;

import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.maps.model.CameraPosition;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.LatLngBounds;
import com.huawei.hms.maps.model.PointOfInterest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ToJson {
    public static HashMap<String, Object> cameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.BEARING, Float.valueOf(cameraPosition.bearing));
        hashMap.put("target", latLng(cameraPosition.target));
        hashMap.put(Param.TILT, Float.valueOf(cameraPosition.tilt));
        hashMap.put(Param.ZOOM, Float.valueOf(cameraPosition.zoom));
        return hashMap;
    }

    public static HashMap<String, Object> circleId(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.CIRCLE_ID, str);
        return hashMap;
    }

    public static HashMap<String, Object> groundOverlayId(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.GROUND_OVERLAY_ID, str);
        return hashMap;
    }

    public static List<Double> latLng(LatLng latLng) {
        return Arrays.asList(new Double[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude)});
    }

    public static List<List<Double>> latLngList(LatLng[] latLngArr) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : latLngArr) {
            arrayList.add(latLng(latLng));
        }
        return arrayList;
    }

    public static HashMap<String, Object> latlngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.SOUTHWEST, latLng(latLngBounds.southwest));
        hashMap.put(Param.NORTHEAST, latLng(latLngBounds.northeast));
        return hashMap;
    }

    public static HashMap<String, Object> location(Location location) {
        if (location == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("latitude", Double.valueOf(location.getLatitude()));
        hashMap.put("longitude", Double.valueOf(location.getLongitude()));
        hashMap.put(Param.ALTITUDE, Double.valueOf(location.getAltitude()));
        hashMap.put("speed", Float.valueOf(location.getSpeed()));
        hashMap.put(Param.BEARING, Float.valueOf(location.getBearing()));
        hashMap.put("accuracy", Float.valueOf(location.getAccuracy()));
        if (Build.VERSION.SDK_INT >= 26) {
            hashMap.put(Param.VERTICAL_ACCURACY_METERS, Float.valueOf(location.getVerticalAccuracyMeters()));
            hashMap.put(Param.BEARING_ACCURACY_DEGREES, Float.valueOf(location.getBearingAccuracyDegrees()));
            hashMap.put(Param.SPEED_ACCURACY_METERS_PER_SECOND, Float.valueOf(location.getSpeedAccuracyMetersPerSecond()));
        } else {
            hashMap.put(Param.VERTICAL_ACCURACY_METERS, Double.valueOf(0.0d));
            hashMap.put(Param.BEARING_ACCURACY_DEGREES, Double.valueOf(0.0d));
            hashMap.put(Param.SPEED_ACCURACY_METERS_PER_SECOND, Double.valueOf(0.0d));
        }
        hashMap.put("time", Long.valueOf(location.getTime()));
        hashMap.put(Param.FROM_MOCK_PROVIDER, Boolean.valueOf(location.isFromMockProvider()));
        return hashMap;
    }

    public static HashMap<String, Integer> point(Point point) {
        if (point == null) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(Param.X, Integer.valueOf(point.x));
        hashMap.put(Param.Y, Integer.valueOf(point.y));
        return hashMap;
    }

    public static HashMap<String, Object> pointOfInterest(PointOfInterest pointOfInterest) {
        if (pointOfInterest == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.LAT_LNG, latLng(pointOfInterest.latLng));
        hashMap.put("name", pointOfInterest.f49531name);
        hashMap.put(Param.PLACE_ID, pointOfInterest.placeId);
        return hashMap;
    }

    public static HashMap<String, Object> polygonId(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.POLYGON_ID, str);
        return hashMap;
    }

    public static HashMap<String, Object> polylineId(String str) {
        if (str == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Param.POLYLINE_ID, str);
        return hashMap;
    }
}
