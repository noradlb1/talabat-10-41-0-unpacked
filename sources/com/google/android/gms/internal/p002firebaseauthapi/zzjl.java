package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
final class zzjl implements zzjc {
    private final zzix zza;
    private final int zzb;

    private zzjl(zzix zzix, int i11) {
        this.zza = zzix;
        this.zzb = i11;
    }

    public static zzjl zzc(int i11) throws GeneralSecurityException {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return new zzjl(new zzix("HmacSha256"), 1);
        }
        if (i12 != 1) {
            return new zzjl(new zzix("HmacSha512"), 3);
        }
        return new zzjl(new zzix("HmacSha384"), 2);
    }

    public final byte[] zza(byte[] bArr, zzjd zzjd) throws GeneralSecurityException {
        byte[] zzf = zzvb.zzf(zzvb.zzg(this.zzb, zzjd.zza().zzc()), zzvb.zzh(zzvb.zzi(this.zzb), 1, bArr));
        byte[] zzb2 = zzuu.zzb(bArr, zzjd.zzb().zzc());
        byte[] zzd = zzjk.zzd(zzb());
        zzix zzix = this.zza;
        return zzix.zzb((byte[]) null, zzf, "eae_prk", zzb2, "shared_secret", zzd, zzix.zza());
    }

    public final byte[] zzb() throws GeneralSecurityException {
        int i11 = this.zzb - 1;
        if (i11 == 0) {
            return zzjk.zzc;
        }
        if (i11 != 1) {
            return zzjk.zze;
        }
        return zzjk.zzd;
    }
}
