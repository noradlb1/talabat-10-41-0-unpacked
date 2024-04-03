package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzo extends zzfyi<zzgcr> {
    public zzfzo() {
        super(zzgcr.class, new zzfzm(zzfxu.class));
    }

    public static /* bridge */ /* synthetic */ zzfyf zzk(int i11, int i12, int i13) {
        zzgct zzc = zzgcu.zzc();
        zzc.zza(i11);
        zzgcw zzc2 = zzgcx.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgcx) zzc2.zzah());
        return new zzfyf((zzgcu) zzc.zzah(), i13);
    }

    public final zzfyg<zzgcu, zzgcr> zza() {
        return new zzfzn(this, zzgcu.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgcr.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgcr zzgcr = (zzgcr) zzglv;
        zzgii.zzb(zzgcr.zza(), 0);
        zzgii.zza(zzgcr.zzg().zzd());
        if (zzgcr.zzf().zza() != 12 && zzgcr.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final int zzj() {
        return 3;
    }
}
