package com.huawei.hms.locationSdk;

import com.huawei.hms.support.api.entity.location.coordinate.LonLat;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateTransform;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;

public class a {
    public static LonLat a(double d11, double d12, int i11) {
        if (i11 != 1) {
            LogConsole.e("ConvertCoord", "coordType is not 84");
            return null;
        } else if (!a(d11, d12)) {
            HMSLocationLog.e("ConvertCoord", "", "transform latLon is not Valid Coordinates");
            return null;
        } else {
            LatLon convertCoord = CoordinateTransform.convertCoord(d11, d12, i11);
            if (convertCoord == null) {
                return null;
            }
            LonLat lonLat = new LonLat();
            lonLat.setLatitude(convertCoord.getLatitude());
            lonLat.setLongitude(convertCoord.getLongitude());
            return lonLat;
        }
    }

    private static boolean a(double d11, double d12) {
        return d11 >= -90.0d && d11 <= 90.0d && d12 >= -180.0d && d12 <= 180.0d;
    }
}
