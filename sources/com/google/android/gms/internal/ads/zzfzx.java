package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzx extends zzfyi<zzgds> {
    public zzfzx() {
        super(zzgds.class, new zzfzv(zzfxu.class));
    }

    public final zzfyg<zzgdv, zzgds> zza() {
        return new zzfzw(this, zzgdv.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgds.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgds zzgds = (zzgds) zzglv;
        zzgii.zzb(zzgds.zza(), 0);
        if (zzgds.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final int zzj() {
        return 3;
    }
}
