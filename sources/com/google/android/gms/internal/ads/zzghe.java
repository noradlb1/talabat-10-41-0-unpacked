package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import org.apache.commons.compress.archivers.tar.TarConstants;

abstract class zzghe implements zzghz {
    private static final int[] zzb = zzi(new byte[]{101, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 112, 97, 110, 100, 32, TarConstants.LF_CHR, TarConstants.LF_SYMLINK, 45, 98, 121, 116, 101, 32, 107});
    int[] zza;
    private final int zzc;

    public zzghe(byte[] bArr, int i11) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzi(bArr);
            this.zzc = i11;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public static void zzf(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = iArr[i11] + iArr[i12];
        iArr[i11] = i15;
        int i16 = i15 ^ iArr[i14];
        int i17 = (i16 >>> -16) | (i16 << 16);
        iArr[i14] = i17;
        int i18 = iArr[i13] + i17;
        iArr[i13] = i18;
        int i19 = iArr[i12] ^ i18;
        int i21 = (i19 >>> -12) | (i19 << 12);
        iArr[i12] = i21;
        int i22 = iArr[i11] + i21;
        iArr[i11] = i22;
        int i23 = iArr[i14] ^ i22;
        int i24 = (i23 >>> -8) | (i23 << 8);
        iArr[i14] = i24;
        int i25 = iArr[i13] + i24;
        iArr[i13] = i25;
        int i26 = iArr[i12] ^ i25;
        iArr[i12] = (i26 >>> -7) | (i26 << 7);
    }

    public static void zzg(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzb;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void zzh(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i11 = 0; i11 < 10; i11++) {
            zzf(iArr2, 0, 4, 8, 12);
            zzf(iArr2, 1, 5, 9, 13);
            zzf(iArr2, 2, 6, 10, 14);
            zzf(iArr2, 3, 7, 11, 15);
            zzf(iArr2, 0, 5, 10, 15);
            zzf(iArr2, 1, 6, 11, 12);
            zzf(iArr2, 2, 7, 8, 13);
            zzf(iArr2, 3, 4, 9, 14);
        }
    }

    public static int[] zzi(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= Integer.MAX_VALUE - zzb()) {
            ByteBuffer allocate = ByteBuffer.allocate(zzb() + length);
            zze(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract int zzb();

    public abstract int[] zzc(int[] iArr, int i11);

    public final ByteBuffer zzd(byte[] bArr, int i11) {
        int[] zzc2 = zzc(zzi(bArr), i11);
        int[] iArr = (int[]) zzc2.clone();
        zzh(iArr);
        for (int i12 = 0; i12 < 16; i12++) {
            zzc2[i12] = zzc2[i12] + iArr[i12];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzc2, 0, 16);
        return order;
    }

    public final void zze(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - zzb() >= bArr.length) {
            byte[] zza2 = zzgig.zza(zzb());
            byteBuffer.put(zza2);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i11 = (remaining / 64) + 1;
            for (int i12 = 0; i12 < i11; i12++) {
                ByteBuffer zzd = zzd(zza2, this.zzc + i12);
                if (i12 == i11 - 1) {
                    zzghc.zza(byteBuffer, wrap, zzd, remaining % 64);
                } else {
                    zzghc.zza(byteBuffer, wrap, zzd, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
