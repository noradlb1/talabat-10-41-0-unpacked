package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziz  reason: invalid package */
final class zziz {
    private static final byte[] zza = new byte[0];
    private final zziy zzb;
    private final BigInteger zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    @GuardedBy("this")
    private BigInteger zzg = BigInteger.ZERO;

    private zziz(byte[] bArr, byte[] bArr2, byte[] bArr3, BigInteger bigInteger, zziy zziy) {
        this.zzf = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzc = bigInteger;
        this.zzb = zziy;
    }

    public static zziz zzb(byte[] bArr, byte[] bArr2, zzjc zzjc, zzix zzix, zziy zziy, byte[] bArr3) throws GeneralSecurityException {
        zzix zzix2 = zzix;
        byte[] zzb2 = zzjk.zzb(zzjc.zzb(), zzix.zzc(), zziy.zzb());
        byte[] bArr4 = zzjk.zzl;
        byte[] bArr5 = zza;
        byte[] zzb3 = zzuu.zzb(zzjk.zza, zzix2.zze(bArr4, bArr5, "psk_id_hash", zzb2), zzix2.zze(bArr4, bArr3, "info_hash", zzb2));
        zzix zzix3 = zzix;
        byte[] zze2 = zzix2.zze(bArr2, bArr5, "secret", zzb2);
        byte[] bArr6 = zzb3;
        byte[] bArr7 = zzb2;
        byte[] zzd2 = zzix3.zzd(zze2, bArr6, "key", bArr7, zziy.zza());
        byte[] zzd3 = zzix3.zzd(zze2, bArr6, "base_nonce", bArr7, 12);
        BigInteger bigInteger = BigInteger.ONE;
        return new zziz(bArr, zzd2, zzd3, bigInteger.shiftLeft(96).subtract(bigInteger), zziy);
    }

    private final synchronized byte[] zzc() throws GeneralSecurityException {
        byte[] zzc2;
        byte[] bArr = this.zze;
        BigInteger bigInteger = this.zzg;
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length != 12) {
                if (length > 13) {
                    throw new GeneralSecurityException("integer too large");
                } else if (length != 13) {
                    byte[] bArr2 = new byte[12];
                    System.arraycopy(byteArray, 0, bArr2, 12 - length, length);
                    byteArray = bArr2;
                } else if (byteArray[0] == 0) {
                    byteArray = Arrays.copyOfRange(byteArray, 1, 13);
                } else {
                    throw new GeneralSecurityException("integer too large");
                }
            }
            zzc2 = zzuu.zzc(bArr, byteArray);
            if (this.zzg.compareTo(this.zzc) < 0) {
                this.zzg = this.zzg.add(BigInteger.ONE);
            } else {
                throw new GeneralSecurityException("message limit reached");
            }
        } else {
            throw new IllegalArgumentException("integer must be nonnegative");
        }
        return zzc2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return this.zzb.zzc(this.zzd, zzc(), bArr, bArr2);
    }
}
