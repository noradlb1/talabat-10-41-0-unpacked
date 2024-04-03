package com.google.android.gms.internal.location;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

final class zzdr extends zzds {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzds zzc;

    public zzdr(zzds zzds, int i11, int i12) {
        this.zzc = zzds;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzdm.zza(i11, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzds zzh(int i11, int i12) {
        zzdm.zzc(i11, i12, this.zzb);
        zzds zzds = this.zzc;
        int i13 = this.zza;
        return zzds.subList(i11 + i13, i12 + i13);
    }
}
