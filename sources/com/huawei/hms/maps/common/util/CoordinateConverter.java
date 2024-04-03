package com.huawei.hms.maps.common.util;

import android.util.Log;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.utils.MapClientUtil;

public class CoordinateConverter {
    private LatLng a(double d11, double d12) {
        if (MapClientUtil.isOutOfChina(d11, d12)) {
            return new LatLng(d12, d11);
        }
        double[] b11 = b(d11, d12);
        return new LatLng(d12 + b11[1], d11 + b11[0]);
    }

    private double[] b(double d11, double d12) {
        double d13 = d11 - 105.0d;
        double d14 = d12 - 35.0d;
        double c11 = c(d13, d14);
        double d15 = d(d13, d14);
        double d16 = (d12 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d16);
        double d17 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d17);
        return new double[]{(c11 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d16)) * 3.141592653589793d), (d15 * 180.0d) / ((6335552.717000426d / (d17 * sqrt)) * 3.141592653589793d)};
    }

    private double c(double d11, double d12) {
        double d13 = d11 * 0.1d;
        return d11 + 300.0d + (d12 * 2.0d) + (d13 * d11) + (d13 * d12) + (Math.sqrt(Math.abs(d11)) * 0.1d) + ((((Math.sin((6.0d * d11) * 3.141592653589793d) * 20.0d) + (Math.sin((d11 * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d11 * 3.141592653589793d) * 20.0d) + (Math.sin((d11 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d11 / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    private double d(double d11, double d12) {
        double d13 = d11 * 2.0d;
        double d14 = d12 * 3.141592653589793d;
        return -100.0d + d13 + (d12 * 3.0d) + (d12 * 0.2d * d12) + (0.1d * d11 * d12) + (Math.sqrt(Math.abs(d11)) * 0.2d) + ((((Math.sin((6.0d * d11) * 3.141592653589793d) * 20.0d) + (Math.sin(d13 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d14) * 20.0d) + (Math.sin((d12 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d12 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d14 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public LatLng convert(LatLng latLng) {
        if (latLng != null) {
            return a(latLng.longitude, latLng.latitude);
        }
        Log.e("CoordinateConverter", "LatLng is null.");
        return null;
    }

    public LatLng[] convert(LatLng[] latLngArr) {
        String str;
        if (latLngArr == null) {
            str = "LatLng is null.";
        } else if (latLngArr.length > 512) {
            str = "The points of convert cannot exceed 512 points.";
        } else {
            for (int i11 = 0; i11 < latLngArr.length; i11++) {
                LatLng latLng = latLngArr[i11];
                latLngArr[i11] = a(latLng.longitude, latLng.latitude);
            }
            return latLngArr;
        }
        Log.e("CoordinateConverter", str);
        return null;
    }
}
