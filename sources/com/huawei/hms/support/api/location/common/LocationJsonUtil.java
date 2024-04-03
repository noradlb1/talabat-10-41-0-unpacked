package com.huawei.hms.support.api.location.common;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationJsonUtil {
    private static final String TAG = "LocationJsonUtil";

    public static Location convertLocation(HWLocation hWLocation) {
        if (hWLocation == null) {
            return null;
        }
        Location location = new Location(hWLocation.getProvider());
        location.setTime(hWLocation.getTime());
        int i11 = Build.VERSION.SDK_INT;
        location.setElapsedRealtimeNanos(hWLocation.getElapsedRealtimeNanos());
        location.setLatitude(hWLocation.getLatitude());
        location.setLongitude(hWLocation.getLongitude());
        location.setAltitude(hWLocation.getAltitude());
        location.setSpeed(hWLocation.getSpeed());
        location.setBearing(hWLocation.getBearing());
        location.setAccuracy(hWLocation.getAccuracy());
        if (i11 >= 26) {
            location.setVerticalAccuracyMeters(hWLocation.getVerticalAccuracyMeters());
            location.setSpeedAccuracyMetersPerSecond(hWLocation.getSpeedAccuracyMetersPerSecond());
            location.setBearingAccuracyDegrees(hWLocation.getBearingAccuracyDegrees());
        }
        if (hWLocation.getExtraInfo() != null) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject((Map<?, ?>) hWLocation.getExtraInfo());
            for (Map.Entry next : hWLocation.getExtraInfo().entrySet()) {
                try {
                    String str = (String) next.getKey();
                    if (!((String) next.getKey()).startsWith("hw-address-")) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof Boolean) {
                            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof Integer) {
                            bundle.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(str, ((Float) obj).floatValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(str, ((Long) obj).longValue());
                        } else if (obj instanceof Short) {
                            bundle.putShort(str, ((Short) obj).shortValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(str, ((Double) obj).doubleValue());
                        } else {
                            bundle.putString(str, jSONObject.getString(str));
                        }
                    }
                } catch (JSONException unused) {
                    LogConsole.e(TAG, "convertLocation: JSONException");
                }
            }
            location.setExtras(bundle);
        }
        return location;
    }

    public static JSONObject createLocationJsonObject(Location location) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mProvider", (Object) location.getProvider());
        jSONObject.put("mAltitude", location.getAltitude());
        jSONObject.put("mBearing", (double) location.getBearing());
        int i11 = Build.VERSION.SDK_INT;
        jSONObject.put("mElapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        jSONObject.put("mHorizontalAccuracyMeters", (double) location.getAccuracy());
        jSONObject.put("mLatitude", location.getLatitude());
        jSONObject.put("mLongitude", location.getLongitude());
        jSONObject.put("mSpeed", (double) location.getSpeed());
        if (i11 >= 26) {
            jSONObject.put("mSpeedAccuracyMetersPerSecond", (double) location.getSpeedAccuracyMetersPerSecond());
            jSONObject.put("mVerticalAccuracyMeters", (double) location.getVerticalAccuracyMeters());
            jSONObject.put("mBearingAccuracyDegrees", (double) location.getBearingAccuracyDegrees());
        }
        jSONObject.put("mTime", location.getTime());
        return jSONObject;
    }

    private static void fillAddress(JSONObject jSONObject, HWLocation hWLocation) throws JSONException {
        JSONObject jSONObject2;
        if (jSONObject.has("address") && (jSONObject2 = jSONObject.getJSONObject("address")) != null) {
            hWLocation.setCountryCode(jSONObject2.optString("mCountryCode", ""));
            hWLocation.setCountryName(jSONObject2.optString("mCountryName", ""));
            hWLocation.setState(jSONObject2.optString("mState", ""));
            hWLocation.setCity(jSONObject2.optString("mCity", ""));
            hWLocation.setCounty(jSONObject2.optString("mCounty", ""));
            hWLocation.setStreet(jSONObject2.optString("mStreet", ""));
            hWLocation.setFeatureName(jSONObject2.optString("mFeatureName", ""));
            hWLocation.setPostalCode(jSONObject2.optString("mPostalCode", ""));
            hWLocation.setPhone(jSONObject2.optString("mPhone", ""));
            hWLocation.setUrl(jSONObject2.optString("mUrl", ""));
            if (jSONObject2.has("mExtraInfo")) {
                Object opt = jSONObject2.opt("mExtraInfo");
                JSONObject jSONObject3 = opt instanceof JSONObject ? (JSONObject) opt : null;
                if (jSONObject3 != null) {
                    Iterator<String> keys = jSONObject3.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject3.get(next));
                    }
                    hWLocation.setExtraInfo(hashMap);
                }
            }
        }
    }

    public static List<HWLocation> parseHwLocationsFromJsonObject(JSONObject jSONObject) throws JSONException, ApiException {
        JSONArray jSONArray = jSONObject.getJSONArray("geocoderResult");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            HWLocation parseLocationFromJsonObject = parseLocationFromJsonObject(jSONArray.getJSONObject(i11));
            if (parseLocationFromJsonObject != null) {
                arrayList.add(parseLocationFromJsonObject);
            }
        }
        return CollectionsUtil.isEmpty((Collection<?>) arrayList) ? Collections.emptyList() : arrayList;
    }

    public static LocationAvailability parseLocationAvailabilityFromString(String str) throws JSONException {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        if (!jSONObject2.has("locationAvailability") || (jSONObject = jSONObject2.getJSONObject("locationAvailability")) == null) {
            return null;
        }
        LocationAvailability locationAvailability = new LocationAvailability();
        locationAvailability.setCellStatus(jSONObject.optInt("cellStatus"));
        locationAvailability.setWifiStatus(jSONObject.optInt("wifiStatus"));
        locationAvailability.setElapsedRealtimeNs(jSONObject.optLong("elapsedRealtimeNs"));
        locationAvailability.setLocationStatus(jSONObject.optInt("locationStatus"));
        return locationAvailability;
    }

    public static HWLocation parseLocationFromJsonObject(JSONObject jSONObject) throws JSONException, ApiException {
        JSONObject jSONObject2;
        if (jSONObject == null || !jSONObject.has("location") || (jSONObject2 = jSONObject.getJSONObject("location")) == null) {
            return null;
        }
        if (jSONObject2.has("mProvider")) {
            String string = jSONObject2.getString("mProvider");
            HWLocation hWLocation = new HWLocation();
            hWLocation.setProvider(string);
            hWLocation.setAltitude(jSONObject2.optDouble("mAltitude", 0.0d));
            hWLocation.setBearing((float) jSONObject2.optDouble("mBearing", 0.0d));
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26) {
                hWLocation.setBearingAccuracyDegrees((float) jSONObject2.optDouble("mBearingAccuracyDegrees", 0.0d));
            }
            hWLocation.setElapsedRealtimeNanos(jSONObject2.optLong("mElapsedRealtimeNanos", 0));
            hWLocation.setAccuracy((float) jSONObject2.optDouble("mHorizontalAccuracyMeters", 0.0d));
            hWLocation.setLatitude(jSONObject2.optDouble("mLatitude", 0.0d));
            hWLocation.setLongitude(jSONObject2.optDouble("mLongitude", 0.0d));
            hWLocation.setSpeed((float) jSONObject2.optDouble("mSpeed", 0.0d));
            if (i11 >= 26) {
                hWLocation.setSpeedAccuracyMetersPerSecond((float) jSONObject2.optDouble("mSpeedAccuracyMetersPerSecond", 0.0d));
            }
            hWLocation.setTime(jSONObject2.optLong("mTime", 0));
            if (i11 >= 26) {
                hWLocation.setVerticalAccuracyMeters((float) jSONObject2.optDouble("mVerticalAccuracyMeters", 0.0d));
            }
            fillAddress(jSONObject, hWLocation);
            return hWLocation;
        }
        throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
    }

    public static LocationResult parseLocationResultFromJsonObject(JSONObject jSONObject) throws JSONException, ApiException {
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = jSONObject.getJSONObject("locationResult")) == null) {
            return null;
        }
        List<HWLocation> parseLocationsFromJsonObject = parseLocationsFromJsonObject(jSONObject2);
        if (CollectionsUtil.isEmpty((Collection<?>) parseLocationsFromJsonObject)) {
            return null;
        }
        return LocationResult.create(parseLocationsFromJsonObject);
    }

    public static List<HWLocation> parseLocationsFromJsonObject(JSONObject jSONObject) throws JSONException, ApiException {
        JSONArray jSONArray = jSONObject.getJSONArray("locations");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            HWLocation parseLocationFromJsonObject = parseLocationFromJsonObject(jSONArray.getJSONObject(i11));
            if (parseLocationFromJsonObject != null) {
                arrayList.add(parseLocationFromJsonObject);
            }
        }
        return CollectionsUtil.isEmpty((Collection<?>) arrayList) ? Collections.emptyList() : arrayList;
    }
}
