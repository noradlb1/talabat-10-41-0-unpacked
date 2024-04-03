package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzl extends zzfyi<zzgci> {
    public zzfzl() {
        super(zzgci.class, new zzfzj(zzghz.class));
    }

    public static final void zzl(zzgci zzgci) throws GeneralSecurityException {
        zzgii.zzb(zzgci.zza(), 0);
        zzgii.zza(zzgci.zzh().zzd());
        zzm(zzgci.zzg());
    }

    /* access modifiers changed from: private */
    public static final void zzm(zzgco zzgco) throws GeneralSecurityException {
        if (zzgco.zza() < 12 || zzgco.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final zzfyg<zzgcl, zzgci> zza() {
        return new zzfzk(this, zzgcl.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgci.zzf(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzl((zzgci) zzglv);
    }

    public final int zzj() {
        return 3;
    }
}
