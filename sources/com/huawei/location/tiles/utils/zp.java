package com.huawei.location.tiles.utils;

import com.huawei.location.activity.model.Vw;
import com.huawei.location.lite.common.log.LogConsole;

public class zp {
    private Long Vw;

    /* renamed from: yn  reason: collision with root package name */
    private d2 f50266yn;

    public zp(Long l11, d2 d2Var) {
        this.Vw = l11;
        this.f50266yn = d2Var;
    }

    public Long[] yn() {
        double[] dArr;
        d2 yn2 = E5.yn(this.Vw.longValue());
        d2 d2Var = this.f50266yn;
        double d11 = yn2.Vw;
        double d12 = d2Var.Vw;
        double radians = Math.toRadians(yn2.f50265yn);
        double radians2 = Math.toRadians(d2Var.f50265yn);
        double radians3 = Math.toRadians(d12 - d11);
        double degrees = (Math.toDegrees(Math.atan2(Math.sin(radians3) * Math.cos(radians2), (Math.cos(radians) * Math.sin(radians2)) - ((Math.sin(radians) * Math.cos(radians2)) * Math.cos(radians3)))) + 360.0d) % 360.0d;
        double d13 = 0.0d;
        if (degrees < 0.0d || degrees > 360.0d) {
            LogConsole.i("TileIdPrediction", "illegal degree, return null");
            dArr = new double[0];
        } else if (0.0d <= degrees && degrees < 90.0d) {
            dArr = new double[]{0.0d, 45.0d, 90.0d};
        } else if (90.0d <= degrees && degrees < 180.0d) {
            dArr = new double[]{90.0d, 135.0d, 180.0d};
        } else if (180.0d > degrees || degrees >= 270.0d) {
            dArr = new double[]{270.0d, 315.0d, 360.0d};
        } else {
            dArr = new double[]{180.0d, 225.0d, 270.0d};
        }
        int length = dArr.length;
        d2[] d2VarArr = new d2[length];
        int i11 = 0;
        while (i11 < dArr.length) {
            double d14 = yn2.Vw;
            double d15 = yn2.f50265yn;
            double radians4 = Math.toRadians(dArr[i11]);
            double sin = Math.sin(radians4);
            double cos = Math.cos(radians4);
            double tan = Math.tan(Math.toRadians(d15)) * 0.996647189336d;
            double sqrt = 1.0d / Math.sqrt((tan * tan) + 1.0d);
            double d16 = tan * sqrt;
            double atan2 = Math.atan2(tan, cos);
            double d17 = sqrt * sin;
            double d18 = d17 * d17;
            double d19 = 1.0d - d18;
            double d21 = (2.723316066819453E11d * d19) / 4.0408299984087055E13d;
            double d22 = (d21 / 1024.0d) * ((d21 * (((74.0d - (47.0d * d21)) * d21) - 0.03125d)) + 256.0d);
            double d23 = 500.0d / ((((d21 / 16384.0d) * (((((320.0d - (175.0d * d21)) * d21) - 0.005859375d) * d21) + 4096.0d)) + 1.0d) * 6356752.3142d);
            double d24 = d13;
            double d25 = d24;
            double d26 = d25;
            double d27 = 6.283185307179586d;
            double d28 = d23;
            while (Math.abs(d28 - d27) > 1.0E-12d) {
                d26 = Math.cos((atan2 * 2.0d) + d28);
                d25 = Math.sin(d28);
                d24 = Math.cos(d28);
                d27 = d28;
                d28 = d23 + (d22 * d25 * (d26 + ((d22 / 4.0d) * (((((2.0d * d26) * d26) - 4.0d) * d24) - ((((d22 / 6.0d) * d26) * (((d25 * 4.0d) * d25) - 1.5d)) * (((4.0d * d26) * d26) - 1.5d))))));
            }
            double d29 = d16 * d25;
            double d31 = sqrt * d24;
            double d32 = d29 - (d31 * cos);
            double d33 = 2.095506665E-4d * d19 * (((4.0d - (d19 * 3.0d)) * 0.003352810664d) + 4.0d);
            d2VarArr[i11] = new d2(Math.toDegrees(Math.atan2((d16 * d24) + (sqrt * d25 * cos), Math.sqrt(d18 + (d32 * d32)) * 0.996647189336d)), d14 + Math.toDegrees(Math.atan2(d25 * sin, d31 - (d29 * cos)) - ((((1.0d - d33) * 0.003352810664d) * d17) * (d28 + ((d25 * d33) * (d26 + ((d33 * d24) * (((2.0d * d26) * d26) - 4.0d))))))));
            i11++;
            d13 = 0.0d;
        }
        Long[] lArr = new Long[length];
        for (int i12 = 0; i12 < length; i12++) {
            d2 d2Var2 = d2VarArr[i12];
            lArr[i12] = Long.valueOf(Vw.yn(d2Var2.Vw, d2Var2.f50265yn, 15));
        }
        return lArr;
    }
}
