package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

@Deprecated
public final class zzfyn {
    @Deprecated
    public static final zzfyj zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzgfq zze = zzgfq.zze(bArr, zzgjx.zza());
            for (zzgfp next : zze.zzf()) {
                if (next.zzc().zzi() == 2 || next.zzc().zzi() == 3 || next.zzc().zzi() == 4) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzfyj.zza(zze);
        } catch (zzgkx unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
