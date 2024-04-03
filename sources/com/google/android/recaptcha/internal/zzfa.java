package com.google.android.recaptcha.internal;

import java.util.Comparator;

final class zzfa implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzfi zzfi = (zzfi) obj;
        zzfi zzfi2 = (zzfi) obj2;
        zzez zzez = new zzez(zzfi);
        zzez zzez2 = new zzez(zzfi2);
        while (zzez.hasNext() && zzez2.hasNext()) {
            int compareTo = Integer.valueOf(zzez.zza() & 255).compareTo(Integer.valueOf(zzez2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzfi.zzd()).compareTo(Integer.valueOf(zzfi2.zzd()));
    }
}
