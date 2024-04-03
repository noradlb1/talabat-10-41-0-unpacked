package com.iab.omid.library.deliveryhero3.devicevolume;

public class a {
    public float a(int i11, int i12) {
        if (i12 <= 0 || i11 <= 0) {
            return 0.0f;
        }
        float f11 = ((float) i11) / ((float) i12);
        if (f11 > 1.0f) {
            return 1.0f;
        }
        return f11;
    }
}
