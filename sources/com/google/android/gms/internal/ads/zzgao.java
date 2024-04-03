package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

public final class zzgao extends zzfyi<zzgdm> {
    public zzgao() {
        super(zzgdm.class, new zzgam(zzfxx.class));
    }

    public final zzfyg<zzgdp, zzgdm> zza() {
        return new zzgan(this, zzgdp.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgdm.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgdm zzgdm = (zzgdm) zzglv;
        zzgii.zzb(zzgdm.zza(), 0);
        if (zzgdm.zzf().zzd() != 64) {
            int zzd = zzgdm.zzf().zzd();
            StringBuilder sb2 = new StringBuilder(61);
            sb2.append("invalid key size: ");
            sb2.append(zzd);
            sb2.append(". Valid keys must have 64 bytes.");
            throw new InvalidKeyException(sb2.toString());
        }
    }

    public final int zzj() {
        return 3;
    }
}
