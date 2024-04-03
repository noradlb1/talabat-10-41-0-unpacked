package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

final class zzgd extends zzge {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzge zzc;

    public zzgd(zzge zzge, int i11, int i12) {
        this.zzc = zzge;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzfm.zza(i11, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzge zzh(int i11, int i12) {
        zzfm.zzg(i11, i12, this.zzb);
        zzge zzge = this.zzc;
        int i13 = this.zza;
        return zzge.subList(i11 + i13, i12 + i13);
    }
}
