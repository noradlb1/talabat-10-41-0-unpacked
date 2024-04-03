package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

abstract class zzgnr {
    public static final String zzd(ByteBuffer byteBuffer, int i11, int i12) throws zzgkx {
        if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) >= 0) {
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (r11 < i13) {
                byte b11 = byteBuffer.get(r11);
                if (!zzgnq.zzd(b11)) {
                    break;
                }
                i11 = r11 + 1;
                cArr[i14] = (char) b11;
                i14++;
            }
            int i15 = i14;
            while (r11 < i13) {
                int i16 = r11 + 1;
                byte b12 = byteBuffer.get(r11);
                if (zzgnq.zzd(b12)) {
                    int i17 = i15 + 1;
                    cArr[i15] = (char) b12;
                    r11 = i16;
                    while (true) {
                        i15 = i17;
                        if (r11 >= i13) {
                            break;
                        }
                        byte b13 = byteBuffer.get(r11);
                        if (!zzgnq.zzd(b13)) {
                            break;
                        }
                        r11++;
                        i17 = i15 + 1;
                        cArr[i15] = (char) b13;
                    }
                } else if (zzgnq.zzf(b12)) {
                    if (i16 < i13) {
                        zzgnq.zzc(b12, byteBuffer.get(i16), cArr, i15);
                        r11 = i16 + 1;
                        i15++;
                    } else {
                        throw zzgkx.zzd();
                    }
                } else if (zzgnq.zze(b12)) {
                    if (i16 < i13 - 1) {
                        int i18 = i16 + 1;
                        zzgnq.zzb(b12, byteBuffer.get(i16), byteBuffer.get(i18), cArr, i15);
                        r11 = i18 + 1;
                        i15++;
                    } else {
                        throw zzgkx.zzd();
                    }
                } else if (i16 < i13 - 2) {
                    int i19 = i16 + 1;
                    int i21 = i19 + 1;
                    zzgnq.zza(b12, byteBuffer.get(i16), byteBuffer.get(i19), byteBuffer.get(i21), cArr, i15);
                    i15 += 2;
                    r11 = i21 + 1;
                } else {
                    throw zzgkx.zzd();
                }
            }
            return new String(cArr, 0, i15);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public abstract int zza(int i11, byte[] bArr, int i12, int i13);

    public abstract String zzb(byte[] bArr, int i11, int i12) throws zzgkx;

    public final boolean zzc(byte[] bArr, int i11, int i12) {
        return zza(0, bArr, i11, i12) == 0;
    }
}
