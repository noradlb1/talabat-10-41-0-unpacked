package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkv  reason: invalid package */
public final class zzkv {
    private static final zzkv zza = new zzkv();
    private final AtomicReference zzb = new AtomicReference(new zzlr(new zzln((zzlm) null), (zzlq) null));

    public static zzkv zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzlr) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzbm zzbm, Class cls) throws GeneralSecurityException {
        return ((zzlr) this.zzb.get()).zzb(zzbm, cls);
    }

    public final Object zzd(zzcl zzcl, Class cls) throws GeneralSecurityException {
        return ((zzlr) this.zzb.get()).zzc(zzcl, cls);
    }

    public final synchronized void zze(zzlk zzlk) throws GeneralSecurityException {
        zzln zzln = new zzln((zzlr) this.zzb.get(), (zzlm) null);
        zzln.zza(zzlk);
        this.zzb.set(new zzlr(zzln, (zzlq) null));
    }

    public final synchronized void zzf(zzcm zzcm) throws GeneralSecurityException {
        zzln zzln = new zzln((zzlr) this.zzb.get(), (zzlm) null);
        zzln.zzb(zzcm);
        this.zzb.set(new zzlr(zzln, (zzlq) null));
    }
}
