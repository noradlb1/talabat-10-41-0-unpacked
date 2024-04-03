package com.huawei.hms.location;

import android.content.Intent;
import android.location.Location;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.List;

public class GeofenceData {
    public static final String KEY_ERROR_CODE = "hms_error_code";
    private static final String KEY_GEOFENCE_BUNDLE = "com.huawei.hms.location.geofence.geofence_list_bundle";
    public static final String KEY_GEOFENCE_LIST = "com.huawei.hms.location.geofence.geofence_list";
    public static final String KEY_LOCATION = "com.huawei.hms.location.geofence.location";
    public static final String KEY_TRANSITION = "com.huawei.hms.location.geofence.conversion";
    private final int conversion;
    private final List<Geofence> convertingGeofenceList;
    private final Location convertingLocation;
    private final int errorCode;

    private GeofenceData(int i11, int i12, List<Geofence> list, Location location) {
        this.errorCode = i11;
        this.conversion = i12;
        this.convertingGeofenceList = list;
        this.convertingLocation = location;
    }

    public static GeofenceData getDataFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        int i11 = -1;
        int intExtra = safeIntent.getIntExtra(KEY_ERROR_CODE, -1);
        int intExtra2 = safeIntent.getIntExtra(KEY_TRANSITION, -1);
        if (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4) {
            i11 = intExtra2;
        }
        Location location = (Location) safeIntent.getParcelableExtra(KEY_LOCATION);
        ArrayList arrayList = new ArrayList();
        ArrayList parcelableArrayList = new SafeBundle(safeIntent.getBundleExtra(KEY_GEOFENCE_BUNDLE)).getParcelableArrayList(KEY_GEOFENCE_LIST);
        if (parcelableArrayList == null) {
            parcelableArrayList = safeIntent.getParcelableArrayListExtra(KEY_GEOFENCE_LIST);
        }
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            arrayList.addAll(parcelableArrayList);
        }
        return new GeofenceData(intExtra, i11, arrayList, location);
    }

    public int getConversion() {
        return this.conversion;
    }

    public List<Geofence> getConvertingGeofenceList() {
        return this.convertingGeofenceList;
    }

    public Location getConvertingLocation() {
        return this.convertingLocation;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean isFailure() {
        return this.errorCode != -1;
    }

    public boolean isSuccess() {
        return this.errorCode == -1;
    }
}
