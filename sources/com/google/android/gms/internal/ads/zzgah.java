package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgah extends zzfyi<zzggp> {
    public zzgah() {
        super(zzggp.class, new zzgaf(zzfxu.class));
    }

    public final zzfyg<zzggs, zzggp> zza() {
        return new zzgag(this, zzggs.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzggp.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzggp zzggp = (zzggp) zzglv;
        zzgii.zzb(zzggp.zza(), 0);
        if (zzggp.zzf().zzd() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final int zzj() {
        return 3;
    }
}
