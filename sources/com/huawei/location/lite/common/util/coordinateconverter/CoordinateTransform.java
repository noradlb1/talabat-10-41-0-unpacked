package com.huawei.location.lite.common.util.coordinateconverter;

import com.huawei.location.lite.common.log.LogConsole;

public class CoordinateTransform {
    private static final int GCJ02TO84 = 0;
    private static final int GPS84TO02 = 1;
    private static final int ONE = 1;
    private static final String TAG = "CoordinateTransform";
    private static final int TWO = 2;
    private static final int ZERO = 0;

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

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.location.lite.common.util.coordinateconverter.LatLon transform(double r5, double r7, int r9) {
        /*
            com.huawei.location.lite.common.util.coordinateconverter.LatLon r0 = new com.huawei.location.lite.common.util.coordinateconverter.LatLon
            r0.<init>()
            r1 = 0
            double[] r2 = new double[r1]
            java.lang.String r3 = "CoordinateTransform"
            r4 = 1
            if (r9 != r4) goto L_0x0013
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.wgs84to02Native(r5, r7)     // Catch:{ Exception -> 0x001b, Error -> 0x0018 }
        L_0x0011:
            r2 = r5
            goto L_0x0020
        L_0x0013:
            double[] r5 = com.huawei.location.lite.common.util.coordinateconverter.Transform.gcj02to84Native(r5, r7)     // Catch:{ Exception -> 0x001b, Error -> 0x0018 }
            goto L_0x0011
        L_0x0018:
            java.lang.String r5 = "transform Native method error"
            goto L_0x001d
        L_0x001b:
            java.lang.String r5 = "transform Native method exception"
        L_0x001d:
            com.huawei.location.lite.common.log.LogConsole.e(r3, r5)
        L_0x0020:
            int r5 = r2.length
            r6 = 2
            if (r5 >= r6) goto L_0x002b
            java.lang.String r5 = "transform doubles length exception"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r5)
            r5 = 0
            return r5
        L_0x002b:
            r5 = r2[r1]
            r0.setLatitude(r5)
            r5 = r2[r4]
            r0.setLongitude(r5)
            java.lang.String r5 = "transform ok"
            com.huawei.location.lite.common.log.LogConsole.i(r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.coordinateconverter.CoordinateTransform.transform(double, double, int):com.huawei.location.lite.common.util.coordinateconverter.LatLon");
    }
}
