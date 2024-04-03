package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzja  reason: invalid package */
final class zzja implements zzbk {
    private static final byte[] zza = new byte[0];
    private final zzjd zzb;
    private final zzjc zzc;
    private final zziy zzd;
    private final int zze;
    private final zzix zzf;

    private zzja(zzjd zzjd, zzjc zzjc, zzix zzix, zziy zziy, int i11) {
        this.zzb = zzjd;
        this.zzc = zzjc;
        this.zzf = zzix;
        this.zzd = zziy;
        this.zze = i11;
    }

    public static zzja zzb(zzsp zzsp) throws GeneralSecurityException {
        int i11;
        zzjd zzjd;
        if (!zzsp.zzk()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        } else if (!zzsp.zze().zzl()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        } else if (!zzsp.zzf().zzp()) {
            zzsm zzb2 = zzsp.zze().zzb();
            zzjc zzb3 = zzje.zzb(zzb2);
            zzix zzc2 = zzje.zzc(zzb2);
            zziy zza2 = zzje.zza(zzb2);
            int zzf2 = zzb2.zzf();
            int i12 = zzf2 - 2;
            if (i12 == 1) {
                i11 = 32;
            } else if (i12 == 2) {
                i11 = 65;
            } else if (i12 == 3) {
                i11 = 97;
            } else if (i12 == 4) {
                i11 = Opcodes.I2L;
            } else {
                throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzsg.zza(zzf2)));
            }
            int zzf3 = zzsp.zze().zzb().zzf() - 2;
            if (zzf3 == 1) {
                zzjd = zzjo.zzc(zzsp.zzf().zzq());
            } else if (zzf3 == 2 || zzf3 == 3 || zzf3 == 4) {
                zzjd = zzjm.zzc(zzsp.zzf().zzq(), zzsp.zze().zzg().zzq(), zzjk.zzg(zzsp.zze().zzb().zzf()));
            } else {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            return new zzja(zzjd, zzb3, zzc2, zza2, i11);
        } else {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i11 = this.zze;
        if (length >= i11) {
            byte[] copyOf = Arrays.copyOf(bArr, i11);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zze, length);
            zzjd zzjd = this.zzb;
            zzjc zzjc = this.zzc;
            zzix zzix = this.zzf;
            zziy zziy = this.zzd;
            return zziz.zzb(copyOf, zzjc.zza(copyOf, zzjd), zzjc, zzix, zziy, new byte[0]).zza(copyOfRange, zza);
        }
        throw new GeneralSecurityException("Ciphertext is too short.");
    }
}
