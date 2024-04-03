package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogConsole;

public class CoordinateUtil {
    private static final int GCJ02TO84 = 0;
    private static final int GPS84TO02 = 1;
    private static final int MAX_LAT = 90;
    private static final int MAX_LON = 180;
    private static final int MIN_LAT = -90;
    private static final int MIN_LON = -180;
    private static final String TAG = "CoordinateUtil";

    public static LatLon convertCoord(double d11, double d12, int i11) {
        if (i11 == 1) {
            return gps84ToGcj02(d11, d12);
        }
        LogConsole.e(TAG, "coordType is not 84");
        return null;
    }

    private static LatLon gps84ToGcj02(double d11, double d12) {
        return transform(d11, d12, 1);
    }

    private static boolean isValidCoordinates(double d11, double d12) {
        return d11 >= -90.0d && d11 <= 90.0d && d12 >= -180.0d && d12 <= 180.0d;
    }

    private static LatLon transform(double d11, double d12, int i11) {
        if (i11 != 1 || isValidCoordinates(d11, d12)) {
            return CoordinateTransform.convertCoord(d11, d12, 1);
        }
        LogConsole.e(TAG, "transform latLon is not Valid Coordinates");
        return null;
    }
}
