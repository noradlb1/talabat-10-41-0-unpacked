package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class zzfzb {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzgfv zza(zzgfq zzgfq) {
        zzgfs zza2 = zzgfv.zza();
        zza2.zzb(zzgfq.zzc());
        for (zzgfp next : zzgfq.zzf()) {
            zzgft zza3 = zzgfu.zza();
            zza3.zzb(next.zzc().zzf());
            zza3.zzd(next.zzf());
            zza3.zzc(next.zzg());
            zza3.zza(next.zza());
            zza2.zza((zzgfu) zza3.zzah());
        }
        return (zzgfv) zza2.zzah();
    }

    public static void zzb(zzgfq zzgfq) throws GeneralSecurityException {
        boolean z11;
        int zzc = zzgfq.zzc();
        int i11 = 0;
        boolean z12 = false;
        boolean z13 = true;
        for (zzgfp next : zzgfq.zzf()) {
            if (next.zzf() == 3) {
                if (!next.zze()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzg() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zza())}));
                } else if (next.zzf() != 2) {
                    if (next.zza() == zzc) {
                        if (!z12) {
                            z12 = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzc().zzi() != 5) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    z13 &= z11;
                    i11++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zza())}));
                }
            }
        }
        if (i11 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z12 && !z13) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
