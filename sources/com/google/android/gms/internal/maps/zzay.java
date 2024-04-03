package com.google.android.gms.internal.maps;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    public zzay(zzaz zzaz, int i11, int i12) {
        this.zzc = zzaz;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzas.zza(i11, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i11 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i11, int i12) {
        return subList(i11, i12);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzaz zzf(int i11, int i12) {
        zzas.zzc(i11, i12, this.zzb);
        int i13 = this.zza;
        return this.zzc.subList(i11 + i13, i12 + i13);
    }
}
