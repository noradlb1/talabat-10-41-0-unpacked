package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznk  reason: invalid package */
public final class zznk extends zzkl {
    private static final zzlk zza = zzlk.zzb(zznh.zza, zzng.class, zzmz.class);

    public zznk() {
        super(zzry.class, new zzni(zzcd.class));
    }

    public static void zzh(boolean z11) throws GeneralSecurityException {
        zzcq.zzg(new zznk(), true);
        int i11 = zznv.zza;
        zznv.zzc(zzky.zzc());
        zzkv.zza().zze(zza);
    }

    public static final void zzi(zzry zzry) throws GeneralSecurityException {
        zzwc.zzc(zzry.zza(), 0);
        if (zzry.zzg().zzd() >= 16) {
            zzo(zzry.zzf());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public static /* bridge */ /* synthetic */ zzkj zzn(int i11, int i12, int i13, int i14) {
        zzsa zzc = zzsb.zzc();
        zzsd zzb = zzse.zzb();
        zzb.zzb(i13);
        zzb.zza(i12);
        zzc.zzb((zzse) zzb.zzi());
        zzc.zza(i11);
        return new zzkj((zzsb) zzc.zzi(), i14);
    }

    /* access modifiers changed from: private */
    public static void zzo(zzse zzse) throws GeneralSecurityException {
        if (zzse.zza() >= 10) {
            int zzf = zzse.zzf() - 2;
            if (zzf != 1) {
                if (zzf != 2) {
                    if (zzf != 3) {
                        if (zzf != 4) {
                            if (zzf != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzse.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzse.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzse.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzse.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzse.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzkk zza() {
        return new zznj(this, zzsb.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzry.zze(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzi((zzry) zzaif);
    }

    public final int zzf() {
        return 2;
    }
}
