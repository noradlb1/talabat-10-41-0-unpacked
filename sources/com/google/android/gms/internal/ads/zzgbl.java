package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgbl extends zzfyi<zzgew> {
    public zzgbl() {
        super(zzgew.class, new zzgbj(zzfym.class));
    }

    public static final void zzl(zzgew zzgew) throws GeneralSecurityException {
        zzgii.zzb(zzgew.zza(), 0);
        if (zzgew.zzh().zzd() >= 16) {
            zzn(zzgew.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public static /* bridge */ /* synthetic */ zzfyf zzm(int i11, int i12, int i13, int i14) {
        zzgey zzc = zzgez.zzc();
        zzgfb zzc2 = zzgfc.zzc();
        zzc2.zzb(i13);
        zzc2.zza(i12);
        zzc.zzb((zzgfc) zzc2.zzah());
        zzc.zza(i11);
        return new zzfyf((zzgez) zzc.zzah(), i14);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzgfc zzgfc) throws GeneralSecurityException {
        if (zzgfc.zza() >= 10) {
            int zzg = zzgfc.zzg() - 2;
            if (zzg != 1) {
                if (zzg != 2) {
                    if (zzg != 3) {
                        if (zzg != 4) {
                            if (zzg != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzgfc.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzgfc.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzgfc.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzgfc.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzgfc.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzfyg<zzgez, zzgew> zza() {
        return new zzgbk(this, zzgez.class);
    }

    public final /* synthetic */ zzglv zzb(zzgjf zzgjf) throws zzgkx {
        return zzgew.zzf(zzgjf, zzgjx.zza());
    }

    public final String zzf() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zzh(zzglv zzglv) throws GeneralSecurityException {
        zzl((zzgew) zzglv);
    }

    public final int zzi() {
        return 2;
    }

    public final int zzj() {
        return 3;
    }
}
