package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
public final class zzbz {
    @GuardedBy("this")
    private final zzth zza;

    private zzbz(zzth zzth) {
        this.zza = zzth;
    }

    public static zzbz zze() {
        return new zzbz(zztk.zzc());
    }

    public static zzbz zzf(zzby zzby) {
        return new zzbz((zzth) zzby.zzc().zzu());
    }

    private final synchronized int zzg() {
        int zza2;
        zza2 = zzmg.zza();
        while (zzj(zza2)) {
            zza2 = zzmg.zza();
        }
        return zza2;
    }

    private final synchronized zztj zzh(zzsx zzsx, zzud zzud) throws GeneralSecurityException {
        zzti zzc;
        int zzg = zzg();
        if (zzud != zzud.UNKNOWN_PREFIX) {
            zzc = zztj.zzc();
            zzc.zza(zzsx);
            zzc.zzb(zzg);
            zzc.zzd(3);
            zzc.zzc(zzud);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zztj) zzc.zzi();
    }

    private final synchronized zztj zzi(zztc zztc) throws GeneralSecurityException {
        return zzh(zzcq.zzb(zztc), zztc.zze());
    }

    private final synchronized boolean zzj(int i11) {
        for (zztj zza2 : this.zza.zze()) {
            if (zza2.zza() == i11) {
                return true;
            }
        }
        return false;
    }

    public final synchronized int zza(zztc zztc, boolean z11) throws GeneralSecurityException {
        zztj zzi;
        zzi = zzi(zztc);
        this.zza.zzb(zzi);
        return zzi.zza();
    }

    public final synchronized zzby zzb() throws GeneralSecurityException {
        return zzby.zza((zztk) this.zza.zzi());
    }

    public final synchronized zzbz zzc(zzbu zzbu) throws GeneralSecurityException {
        zza(zzbu.zzb(), false);
        return this;
    }

    public final synchronized zzbz zzd(int i11) throws GeneralSecurityException {
        int i12 = 0;
        while (i12 < this.zza.zza()) {
            zztj zzd = this.zza.zzd(i12);
            if (zzd.zza() != i11) {
                i12++;
            } else if (zzd.zzk() == 3) {
                this.zza.zzc(i11);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i11);
            }
        }
        throw new GeneralSecurityException("key not found: " + i11);
        return this;
    }
}
