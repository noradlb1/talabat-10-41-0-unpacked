package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgau extends zzfyu<zzgej, zzgem> {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    public zzgau() {
        super(zzgej.class, zzgem.class, new zzgas(zzfxy.class));
    }

    public static /* bridge */ /* synthetic */ zzfyf zzl(int i11, int i12, int i13, zzfyd zzfyd, byte[] bArr, int i14) {
        zzgec zza2 = zzged.zza();
        zzgeo zza3 = zzgep.zza();
        int i15 = 4;
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzgjf.zzv(bArr));
        zzgep zzgep = (zzgep) zza3.zzah();
        zzgfh zza4 = zzgfi.zza();
        zza4.zza(zzfyd.zza());
        zza4.zzb(zzgjf.zzv(zzfyd.zzb()));
        int zzc = zzfyd.zzc() - 1;
        if (zzc == 0) {
            i15 = 3;
        } else if (zzc != 1) {
            if (zzc != 2) {
                i15 = 6;
            } else {
                i15 = 5;
            }
        }
        zza4.zzc(i15);
        zzgdz zza5 = zzgea.zza();
        zza5.zza((zzgfi) zza4.zzah());
        zzgef zzc2 = zzgeg.zzc();
        zzc2.zzb(zzgep);
        zzc2.zza((zzgea) zza5.zzah());
        zzc2.zzc(i13);
        zza2.zza((zzgeg) zzc2.zzah());
        return new zzfyf((zzged) zza2.zzah(), i14);
    }

    public final zzfyg<zzged, zzgej> zza() {
        return new zzgat(this, zzged.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgej.zze(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzgej zzgej = (zzgej) zzglv;
        if (!zzgej.zzg().zzD()) {
            zzgii.zzb(zzgej.zza(), 0);
            zzgbd.zza(zzgej.zzf().zzc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final int zzj() {
        return 4;
    }
}
