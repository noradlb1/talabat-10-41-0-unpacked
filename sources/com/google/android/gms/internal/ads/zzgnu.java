package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

final class zzgnu {
    private static final zzgnr zza = new zzgns();

    static {
        if (zzgnp.zzA() && zzgnp.zzB()) {
            int i11 = zzgip.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 != 0) {
            if (i13 == 1) {
                return zzk(b11, bArr[i11]);
            }
            if (i13 == 2) {
                return zzl(b11, bArr[i11], bArr[i11 + 1]);
            }
            throw new AssertionError();
        } else if (b11 > -12) {
            return -1;
        } else {
            return b11;
        }
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
                throw new zzgnt(i17 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i13 = i17 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i18);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzgnt(i17, length);
            }
            i18 = i14;
            i17++;
        }
        return i18;
    }

    public static int zze(CharSequence charSequence) {
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
                                throw new zzgnt(i12, length2);
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

    public static int zzf(int i11, byte[] bArr, int i12, int i13) {
        return zza.zza(i11, bArr, i12, i13);
    }

    public static String zzg(ByteBuffer byteBuffer, int i11, int i12) throws zzgkx {
        zzgnr zzgnr = zza;
        if (byteBuffer.hasArray()) {
            return zzgnr.zzb(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
        } else if (byteBuffer.isDirect()) {
            return zzgnr.zzd(byteBuffer, i11, i12);
        } else {
            return zzgnr.zzd(byteBuffer, i11, i12);
        }
    }

    public static String zzh(byte[] bArr, int i11, int i12) throws zzgkx {
        return zza.zzb(bArr, i11, i12);
    }

    public static boolean zzi(byte[] bArr) {
        return zza.zzc(bArr, 0, bArr.length);
    }

    public static boolean zzj(byte[] bArr, int i11, int i12) {
        return zza.zzc(bArr, i11, i12);
    }

    /* access modifiers changed from: private */
    public static int zzk(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    /* access modifiers changed from: private */
    public static int zzl(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }
}
