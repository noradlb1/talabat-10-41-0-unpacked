package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

final class zzaf extends zzag {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzag zzc;

    public zzaf(zzag zzag, int i11, int i12) {
        this.zzc = zzag;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzs.zza(i11, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final boolean zzf() {
        return true;
    }

    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzag zzh(int i11, int i12) {
        zzs.zzc(i11, i12, this.zzb);
        zzag zzag = this.zzc;
        int i13 = this.zza;
        return zzag.subList(i11 + i13, i12 + i13);
    }
}
