package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzazc implements Comparator<zzazi> {
    public zzazc(zzaze zzaze) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzazi zzazi = (zzazi) obj;
        zzazi zzazi2 = (zzazi) obj2;
        int i11 = zzazi.zzc - zzazi2.zzc;
        if (i11 != 0) {
            return i11;
        }
        return (int) (zzazi.zza - zzazi2.zza);
    }
}
