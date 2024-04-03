package com.talabat.maputils;

import com.talabat.maps.domain.model.LatLng;
import java.util.List;

public class PolyUtil {
    private PolyUtil() {
    }

    public static boolean containsLocation(LatLng latLng, List<LatLng> list) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        double radians = Math.toRadians(latLng.getLatitude());
        double radians2 = Math.toRadians(latLng.getLongitude());
        LatLng latLng2 = list.get(size - 1);
        double radians3 = Math.toRadians(latLng2.getLatitude());
        double radians4 = Math.toRadians(latLng2.getLongitude());
        int i11 = 0;
        double d11 = radians3;
        for (LatLng next : list) {
            double e11 = MathUtil.e(radians2 - radians4, -3.141592653589793d, 3.141592653589793d);
            if (radians == d11 && e11 == 0.0d) {
                return true;
            }
            double radians5 = Math.toRadians(next.getLatitude());
            double radians6 = Math.toRadians(next.getLongitude());
            if (intersects(d11, radians5, MathUtil.e(radians6 - radians4, -3.141592653589793d, 3.141592653589793d), radians, e11)) {
                i11++;
            }
            d11 = radians5;
            radians4 = radians6;
        }
        if ((i11 & 1) != 0) {
            return true;
        }
        return false;
    }

    private static boolean intersects(double d11, double d12, double d13, double d14, double d15) {
        if ((d15 >= 0.0d && d15 >= d13) || ((d15 < 0.0d && d15 < d13) || d14 <= -1.5707963267948966d || d11 <= -1.5707963267948966d || d12 <= -1.5707963267948966d || d11 >= 1.5707963267948966d || d12 >= 1.5707963267948966d || d13 <= -3.141592653589793d)) {
            return false;
        }
        double d16 = (((d13 - d15) * d11) + (d12 * d15)) / d13;
        if (d11 >= 0.0d && d12 >= 0.0d && d14 < d16) {
            return false;
        }
        if ((d11 > 0.0d || d12 > 0.0d || d14 < d16) && d14 < 1.5707963267948966d) {
            return Math.tan(d14) >= tanLatGC(d11, d12, d13, d15);
        }
        return true;
    }

    private static double tanLatGC(double d11, double d12, double d13, double d14) {
        return ((Math.tan(d11) * Math.sin(d13 - d14)) + (Math.tan(d12) * Math.sin(d14))) / Math.sin(d13);
    }
}
