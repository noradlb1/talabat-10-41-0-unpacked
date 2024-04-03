package com.google.android.gms.internal.icing;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;

final class zzfr {
    private static final zzfo zza = new zzfp();

    static {
        if (zzfn.zza() && zzfn.zzb()) {
            int i11 = zzbu.zza;
        }
    }

    public static boolean zza(byte[] bArr) {
        return zza.zza(bArr, 0, bArr.length);
    }

    public static boolean zzb(byte[] bArr, int i11, int i12) {
        return zza.zza(bArr, 0, i12);
    }

    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && charSequence.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt < 2048) {
                i13 += (127 - charAt) >>> 31;
                i12++;
            } else {
                int length2 = charSequence.length();
                while (i12 < length2) {
                    char charAt2 = charSequence.charAt(i12);
                    if (charAt2 < 2048) {
                        i11 += (127 - charAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i12) >= 65536) {
                                i12++;
                            } else {
                                throw new zzfq(i12, length2);
                            }
                        }
                    }
                    i12++;
                }
                i13 += i11;
            }
        }
        if (i13 >= length) {
            return i13;
        }
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i13) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int zzd(CharSequence charSequence, byte[] bArr, int i11, int i12) {
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
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i18 <= i16 - 3) {
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
                throw new zzfq(i17 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i13 = i17 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i18);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzfq(i17, length);
            }
            i18 = i14;
            i17++;
        }
        return i18;
    }

    public static /* synthetic */ int zze(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 != 0) {
            if (i13 == 1) {
                byte b12 = bArr[i11];
                if (b11 <= -12 && b12 <= -65) {
                    return b11 ^ (b12 << 8);
                }
            } else if (i13 == 2) {
                byte b13 = bArr[i11];
                byte b14 = bArr[i11 + 1];
                if (b11 <= -12 && b13 <= -65 && b14 <= -65) {
                    return ((b13 << 8) ^ b11) ^ (b14 << Ascii.DLE);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b11 <= -12) {
            return b11;
        }
        return -1;
    }
}
