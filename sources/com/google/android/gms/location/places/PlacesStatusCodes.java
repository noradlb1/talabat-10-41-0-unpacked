package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.api.ConnectionResult;

@Deprecated
public class PlacesStatusCodes extends CommonStatusCodes {
    public static final int ACCESS_NOT_CONFIGURED = 9003;
    public static final int DEVICE_RATE_LIMIT_EXCEEDED = 9006;
    public static final int INVALID_APP = 9008;
    public static final int INVALID_ARGUMENT = 9004;
    public static final int KEY_EXPIRED = 9007;
    public static final int KEY_INVALID = 9002;
    public static final int RATE_LIMIT_EXCEEDED = 9005;
    public static final int USAGE_LIMIT_EXCEEDED = 9001;

    private PlacesStatusCodes() {
    }

    public static String getStatusCodeString(int i11) {
        if (i11 == 9051) {
            return "PLACE_ALIAS_NOT_FOUND";
        }
        if (i11 == 9150) {
            return "PLACEFENCING_NOT_AVAILABLE";
        }
        if (i11 == 9101) {
            return "PLACE_PROXIMITY_UNKNOWN";
        }
        if (i11 == 9102) {
            return "NEARBY_ALERTS_NOT_AVAILABLE";
        }
        if (i11 == 9201) {
            return "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED";
        }
        if (i11 == 9202) {
            return "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED";
        }
        switch (i11) {
            case ConnectionResult.NETWORK_ERROR /*9000*/:
                return "PLACES_API_QUOTA_FAILED";
            case 9001:
                return "PLACES_API_USAGE_LIMIT_EXCEEDED";
            case 9002:
                return "PLACES_API_KEY_INVALID";
            case 9003:
                return "PLACES_API_ACCESS_NOT_CONFIGURED";
            case 9004:
                return "PLACES_API_INVALID_ARGUMENT";
            case 9005:
                return "PLACES_API_RATE_LIMIT_EXCEEDED";
            case DEVICE_RATE_LIMIT_EXCEEDED /*9006*/:
                return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
            case KEY_EXPIRED /*9007*/:
                return "PLACES_API_KEY_EXPIRED";
            case INVALID_APP /*9008*/:
                return "PLACES_API_INVALID_APP";
            case 9009:
                return "INSUFFICIENT_LOCATION_PERMISSION_FOR_BACKGROUND_PLACES";
            default:
                return CommonStatusCodes.getStatusCodeString(i11);
        }
    }

    public static Status zzb(int i11) {
        String statusCodeString = getStatusCodeString(i11);
        Preconditions.checkNotNull(statusCodeString);
        return new Status(i11, statusCodeString);
    }
}
