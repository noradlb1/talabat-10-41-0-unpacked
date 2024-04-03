package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfyj {
    private final zzgfq zza;

    private zzfyj(zzgfq zzgfq) {
        this.zza = zzgfq;
    }

    public static final zzfyj zza(zzgfq zzgfq) throws GeneralSecurityException {
        if (zzgfq != null && zzgfq.zza() > 0) {
            return new zzfyj(zzgfq);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzfzb.zza(this.zza).toString();
    }

    public final <P> P zzb(Class<P> cls) throws GeneralSecurityException {
        String str;
        Class<?> zze = zzfza.zze(cls);
        if (zze == null) {
            String name2 = cls.getName();
            if (name2.length() != 0) {
                str = "No wrapper found for ".concat(name2);
            } else {
                str = new String("No wrapper found for ");
            }
            throw new GeneralSecurityException(str);
        }
        zzfzb.zzb(this.zza);
        zzfyr<P> zzc = zzfyr.zzc(zze);
        for (zzgfp next : this.zza.zzf()) {
            if (next.zzf() == 3) {
                zzfyo<P> zza2 = zzc.zza(zzfza.zzf(next.zzc(), zze), next);
                if (next.zza() == this.zza.zzc()) {
                    zzc.zze(zza2);
                }
            }
        }
        return zzfza.zzi(zzc, cls);
    }
}
