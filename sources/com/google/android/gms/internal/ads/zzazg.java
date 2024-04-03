package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

public final class zzazg extends zzazb {
    private MessageDigest zzb;

    public final byte[] zzb(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int length = split.length;
        int i11 = 4;
        if (length == 1) {
            int zza = zzazf.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr = allocate.array();
        } else {
            if (length < 5) {
                bArr2 = new byte[(length + length)];
                for (int i12 = 0; i12 < split.length; i12++) {
                    int zza2 = zzazf.zza(split[i12]);
                    char c11 = (zza2 >> 16) ^ ((char) zza2);
                    byte b11 = (byte) c11;
                    byte[] bArr3 = {b11, (byte) (c11 >> 8)};
                    int i13 = i12 + i12;
                    bArr2[i13] = b11;
                    bArr2[i13 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[length];
                for (int i14 = 0; i14 < split.length; i14++) {
                    int zza3 = zzazf.zza(split[i14]);
                    bArr2[i14] = (byte) ((zza3 >> 24) ^ (((zza3 & 255) ^ ((zza3 >> 8) & 255)) ^ ((zza3 >> 16) & 255)));
                }
            }
            bArr = bArr2;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            messageDigest.reset();
            this.zzb.update(bArr);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i11 = length2;
            }
            byte[] bArr5 = new byte[i11];
            System.arraycopy(digest, 0, bArr5, 0, i11);
            return bArr5;
        }
    }
}
