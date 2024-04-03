package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzr extends zzfyi<zzgda> {
    public zzfzr() {
        super(zzgda.class, new zzfzp(zzfxu.class));
    }

    public static /* bridge */ /* synthetic */ zzfyf zzk(int i11, int i12) {
        zzgdc zzc = zzgdd.zzc();
        zzc.zza(i11);
        return new zzfyf((zzgdd) zzc.zzah(), i12);
    }

    public final zzfyg<zzgdd, zzgda> zza() {
        return new zzfzq(this, zzgdd.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgda.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgda zzgda = (zzgda) zzglv;
        zzgii.zzb(zzgda.zza(), 0);
        zzgii.zza(zzgda.zzf().zzd());
    }

    public final int zzi() {
        return 2;
    }

    public final int zzj() {
        return 3;
    }
}
