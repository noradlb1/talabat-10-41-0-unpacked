package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final /* synthetic */ class zzsc implements Comparator {
    public static final /* synthetic */ zzsc zza = new zzsc();

    private /* synthetic */ zzsc() {
    }

    public final int compare(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        Integer num2 = (Integer) obj2;
        int i11 = zzsp.zza;
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }
}
