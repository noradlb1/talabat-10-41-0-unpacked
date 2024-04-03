package com.google.android.gms.internal.places;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;

final class zzeb extends zzec {
    public final int zzc(int i11, byte[] bArr, int i12, int i13) {
        while (r9 < i13 && bArr[r9] >= 0) {
            i12 = r9 + 1;
        }
        if (r9 >= i13) {
            return 0;
        }
        while (r9 < i13) {
            int i14 = r9 + 1;
            byte b11 = bArr[r9];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i14 >= i13) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        r9 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                    return -1;
                } else if (b11 < -16) {
                    if (i14 >= i13 - 1) {
                        return zzea.zzg(bArr, i14, i13);
                    }
                    int i15 = i14 + 1;
                    byte b12 = bArr[i14];
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        r9 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                    return -1;
                } else if (i14 >= i13 - 2) {
                    return zzea.zzg(bArr, i14, i13);
                } else {
                    int i16 = i14 + 1;
                    byte b13 = bArr[i14];
                    if (b13 <= -65 && (((b11 << Ascii.FS) + (b13 + 112)) >> 30) == 0) {
                        int i17 = i16 + 1;
                        if (bArr[i16] <= -65) {
                            i14 = i17 + 1;
                            if (bArr[i17] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            r9 = i14;
        }
        return 0;
    }

    public final String zzh(byte[] bArr, int i11, int i12) throws zzbk {
        if ((i11 | i12 | ((bArr.length - i11) - i12)) >= 0) {
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (r13 < i13) {
                byte b11 = bArr[r13];
                if (!zzdz.zze(b11)) {
                    break;
                }
                i11 = r13 + 1;
                zzdz.zzb(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (r13 < i13) {
                int i16 = r13 + 1;
                byte b12 = bArr[r13];
                if (zzdz.zze(b12)) {
                    int i17 = i15 + 1;
                    zzdz.zzb(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = bArr[i16];
                        if (!zzdz.zze(b13)) {
                            break;
                        }
                        i16++;
                        zzdz.zzb(b13, cArr, i17);
                        i17++;
                    }
                    r13 = i16;
                    i15 = i17;
                } else if (zzdz.zzf(b12)) {
                    if (i16 < i13) {
                        zzdz.zzb(b12, bArr[i16], cArr, i15);
                        r13 = i16 + 1;
                        i15++;
                    } else {
                        throw zzbk.zzbu();
                    }
                } else if (zzdz.zzg(b12)) {
                    if (i16 < i13 - 1) {
                        int i18 = i16 + 1;
                        zzdz.zzb(b12, bArr[i16], bArr[i18], cArr, i15);
                        r13 = i18 + 1;
                        i15++;
                    } else {
                        throw zzbk.zzbu();
                    }
                } else if (i16 < i13 - 2) {
                    int i19 = i16 + 1;
                    byte b14 = bArr[i16];
                    int i21 = i19 + 1;
                    zzdz.zzb(b12, b14, bArr[i19], bArr[i21], cArr, i15);
                    r13 = i21 + 1;
                    i15 = i15 + 1 + 1;
                } else {
                    throw zzbk.zzbu();
                }
            }
            return new String(cArr, 0, i15);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public final int zzc(CharSequence charSequence, byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        char charAt;
        int length = charSequence.length();
        int i16 = i12 + i11;
        int i17 = 0;
        while (i17 < length && (i15 = i17 + i11) < i16 && (charAt = charSequence.charAt(i17)) < 128) {
            bArr[i15] = (byte) charAt;
            i17++;
        }
        if (i17 == length) {
            return i11 + length;
        }
        int i18 = i11 + i17;
        while (i17 < length) {
            char charAt2 = charSequence.charAt(i17);
            if (charAt2 < 128 && i18 < i16) {
                i14 = i18 + 1;
                bArr[i18] = (byte) charAt2;
            } else if (charAt2 < 2048 && i18 <= i16 - 2) {
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((charAt2 >>> 6) | 960);
                i18 = i19 + 1;
                bArr[i19] = (byte) ((charAt2 & '?') | 128);
                i17++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i18 <= i16 - 3) {
                int i21 = i18 + 1;
                bArr[i18] = (byte) ((charAt2 >>> 12) | 480);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i14 = i22 + 1;
                bArr[i22] = (byte) ((charAt2 & '?') | 128);
            } else if (i18 <= i16 - 4) {
                int i23 = i17 + 1;
                if (i23 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i23);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i24 = i18 + 1;
                        bArr[i18] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        int i25 = i24 + 1;
                        bArr[i24] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i26 = i25 + 1;
                        bArr[i25] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i18 = i26 + 1;
                        bArr[i26] = (byte) ((codePoint & 63) | 128);
                        i17 = i23;
                        i17++;
                    } else {
                        i17 = i23;
                    }
                }
                throw new zzee(i17 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i13 = i17 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i18);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzee(i17, length);
            }
            i18 = i14;
            i17++;
        }
        return i18;
    }
}
