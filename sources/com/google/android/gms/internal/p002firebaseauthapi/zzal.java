package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
final class zzal extends zzam {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzam zzc;

    public zzal(zzam zzam, int i11, int i12) {
        this.zzc = zzam;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzu.zza(i11, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzam zzf(int i11, int i12) {
        zzu.zzc(i11, i12, this.zzb);
        zzam zzam = this.zzc;
        int i13 = this.zza;
        return zzam.subList(i11 + i13, i12 + i13);
    }
}
