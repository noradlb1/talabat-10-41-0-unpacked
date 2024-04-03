package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbo  reason: invalid package */
class zzbo implements zzbn {
    private final zzkl zza;
    private final Class zzb;

    public zzbo(zzkl zzkl, Class cls) {
        if (zzkl.zzm().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzkl;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzkl.toString(), cls.getName()}));
    }

    public final zzsx zza(zzafv zzafv) throws GeneralSecurityException {
        try {
            zzkk zza2 = this.zza.zza();
            zzaif zzb2 = zza2.zzb(zzafv);
            zza2.zzd(zzb2);
            zzaif zza3 = zza2.zza(zzb2);
            zzsu zza4 = zzsx.zza();
            zza4.zzb(this.zza.zzd());
            zza4.zzc(zza3.zzo());
            zza4.zza(this.zza.zzb());
            return (zzsx) zza4.zzi();
        } catch (zzahi e11) {
            throw new GeneralSecurityException("Unexpected proto", e11);
        }
    }

    public final Object zzb(zzafv zzafv) throws GeneralSecurityException {
        try {
            zzaif zzc = this.zza.zzc(zzafv);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zze(zzc);
                return this.zza.zzl(zzc, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzahi e11) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(this.zza.zzk().getName()), e11);
        }
    }

    public final String zzc() {
        return this.zza.zzd();
    }
}
