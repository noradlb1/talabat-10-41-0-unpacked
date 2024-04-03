package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgbi extends zzfyi<zzgbt> {
    public zzgbi() {
        super(zzgbt.class, new zzgbg(zzfym.class));
    }

    /* access modifiers changed from: private */
    public static void zzm(zzgbz zzgbz) throws GeneralSecurityException {
        if (zzgbz.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzgbz.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzn(int i11) throws GeneralSecurityException {
        if (i11 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzfyg<zzgbw, zzgbt> zza() {
        return new zzgbh(this, zzgbw.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgbt.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgbt zzgbt = (zzgbt) zzglv;
        zzgii.zzb(zzgbt.zza(), 0);
        zzn(zzgbt.zzg().zzd());
        zzm(zzgbt.zzf());
    }

    public final int zzj() {
        return 3;
    }
}
