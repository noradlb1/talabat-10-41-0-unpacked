package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

final class zziz<T> extends AbstractSet<T> {
    final int zza = -1;
    final /* synthetic */ zzja zzb;

    public zziz(zzja zzja, int i11) {
        this.zzb = zzja;
    }

    public final boolean contains(Object obj) {
        Comparator comparator;
        Object[] zzc = this.zzb.zzb;
        int zzb2 = zzb();
        int zza2 = zza();
        if (this.zza == -1) {
            comparator = zzja.zza;
        } else {
            comparator = zzjc.zza;
        }
        if (Arrays.binarySearch(zzc, zzb2, zza2, obj, comparator) >= 0) {
            return true;
        }
        return false;
    }

    public final Iterator<T> iterator() {
        return new zziy(this);
    }

    public final int size() {
        return zza() - zzb();
    }

    public final int zza() {
        return this.zzb.zzc[this.zza + 1];
    }

    public final int zzb() {
        if (this.zza == -1) {
            return 0;
        }
        return this.zzb.zzc[this.zza];
    }
}
