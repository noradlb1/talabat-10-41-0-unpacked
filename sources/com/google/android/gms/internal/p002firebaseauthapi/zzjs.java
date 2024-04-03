package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjs  reason: invalid package */
public final class zzjs {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Object zzb = new Object();
    /* access modifiers changed from: private */
    public static final String zzc = "zzjs";
    private final zzca zzd;
    private final zzbd zze;
    @GuardedBy("this")
    private final zzbz zzf;

    public /* synthetic */ zzjs(zzjq zzjq, zzjr zzjr) {
        this.zzd = new zzjv(zzjq.zza, zzjq.zzb, zzjq.zzc);
        this.zze = zzjq.zze;
        this.zzf = zzjq.zzg;
    }

    public static /* bridge */ /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzby zza() throws GeneralSecurityException {
        return this.zzf.zzb();
    }
}
