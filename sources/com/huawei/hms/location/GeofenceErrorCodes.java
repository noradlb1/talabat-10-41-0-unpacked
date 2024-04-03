package com.huawei.hms.location;

import com.huawei.hms.common.api.CommonStatusCodes;

public final class GeofenceErrorCodes extends CommonStatusCodes {
    public static final int GEOFENCE_INSUFFICIENT_PERMISSION = 10204;
    public static final int GEOFENCE_NUMBER_OVER_LIMIT = 10201;
    public static final int GEOFENCE_PENDINGINTENT_OVER_LIMIT = 10202;
    public static final int GEOFENCE_REQUEST_TOO_OFTEN = 10205;
    public static final int GEOFENCE_UNAVAILABLE = 10200;

    private GeofenceErrorCodes() {
    }

    public static String getErrorMessage(int i11) {
        switch (i11) {
            case 10200:
                return "GEOFENCE_UNAVAILABLE";
            case 10201:
                return "GEOFENCE_NUMBER_OVER_LIMIT";
            case 10202:
                return "GEOFENCE_PENDINGINTENT_OVER_LIMIT";
            case 10204:
                return "GEOFENCE_INSUFFICIENT_PERMISSION";
            case 10205:
                return "GEOFENCE_REQUEST_TOO_OFTEN";
            default:
                return CommonStatusCodes.getStatusCodeString(i11);
        }
    }
}
