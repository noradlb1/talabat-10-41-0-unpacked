package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Map;

final class zzgs extends zzge<Map.Entry> {
    final /* synthetic */ zzgt zza;

    public zzgs(zzgt zzgt) {
        this.zza = zzgt;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzfm.zza(i11, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        int i12 = i11 + i11;
        Object obj = this.zza.zzb[i12];
        obj.getClass();
        Object obj2 = this.zza.zzb[i12 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
