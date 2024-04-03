package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzky  reason: invalid package */
public final class zzky {
    private static final zzky zza = ((zzky) zzmf.zza(zzkw.zza));
    private final AtomicReference zzb = new AtomicReference(new zzmd(new zzlx(), (zzmc) null));

    public static zzky zzc() {
        return zza;
    }

    public final zzbm zza(zzlt zzlt, @Nullable zzcr zzcr) throws GeneralSecurityException {
        if (!((zzmd) this.zzb.get()).zzh(zzlt)) {
            return new zzkn(zzlt, zzcr);
        }
        return ((zzmd) this.zzb.get()).zza(zzlt, zzcr);
    }

    public final zzce zzb(zzlw zzlw) throws GeneralSecurityException {
        return ((zzmd) this.zzb.get()).zzb(zzlw);
    }

    public final zzlw zzd(zzce zzce, Class cls) throws GeneralSecurityException {
        return ((zzmd) this.zzb.get()).zzc(zzce, cls);
    }

    public final synchronized void zze(zzke zzke) throws GeneralSecurityException {
        zzlx zzlx = new zzlx((zzmd) this.zzb.get());
        zzlx.zza(zzke);
        this.zzb.set(new zzmd(zzlx, (zzmc) null));
    }

    public final synchronized void zzf(zzki zzki) throws GeneralSecurityException {
        zzlx zzlx = new zzlx((zzmd) this.zzb.get());
        zzlx.zzb(zzki);
        this.zzb.set(new zzmd(zzlx, (zzmc) null));
    }

    public final synchronized void zzg(zzlc zzlc) throws GeneralSecurityException {
        zzlx zzlx = new zzlx((zzmd) this.zzb.get());
        zzlx.zzc(zzlc);
        this.zzb.set(new zzmd(zzlx, (zzmc) null));
    }

    public final synchronized void zzh(zzlg zzlg) throws GeneralSecurityException {
        zzlx zzlx = new zzlx((zzmd) this.zzb.get());
        zzlx.zzd(zzlg);
        this.zzb.set(new zzmd(zzlx, (zzmc) null));
    }

    public final boolean zzi(zzlw zzlw) {
        return ((zzmd) this.zzb.get()).zzi(zzlw);
    }
}
