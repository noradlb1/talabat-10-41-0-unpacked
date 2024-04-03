package com.huawei.location.tiles.utils;

public class E5 {

    /* renamed from: yn  reason: collision with root package name */
    private static final int[] f50261yn = {16, 8, 4, 2, 1};

    public static d2 yn(long j11) {
        long j12 = j11 << 5;
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        int i11 = (((int) (j12 >>> 59)) * 2) + 1;
        boolean z11 = true;
        int i12 = 0;
        for (int i13 = 1; i13 < 13; i13++) {
            int i14 = (int) (j12 >>> 59);
            j12 <<= 5;
            for (int i15 = 0; i15 < 5; i15++) {
                int i16 = f50261yn[i15];
                if (z11) {
                    yn(dArr2, i14, i16);
                } else {
                    yn(dArr, i14, i16);
                }
                z11 = !z11;
                i12++;
                if (i12 >= i11) {
                    break;
                }
            }
            if (i12 >= i11) {
                break;
            }
        }
        return new d2((dArr[0] + dArr[1]) / 2.0d, (dArr2[0] + dArr2[1]) / 2.0d);
    }

    private static void yn(double[] dArr, int i11, int i12) {
        if ((i11 & i12) != 0) {
            dArr[0] = (dArr[0] + dArr[1]) / 2.0d;
        } else {
            dArr[1] = (dArr[0] + dArr[1]) / 2.0d;
        }
    }
}
