package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;

final class zztz {
    private static final zzub zzbfo;

    static {
        boolean z11;
        zzub zzub;
        if (!zztx.zzrm() || !zztx.zzrn()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || zzpp.zzna()) {
            zzub = new zzuc();
        } else {
            zzub = new zzue();
        }
        zzbfo = zzub;
    }

    public static int zza(CharSequence charSequence) {
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
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i12) >= 65536) {
                                i12++;
                            } else {
                                throw new zzud(i12, length2);
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

    /* access modifiers changed from: private */
    public static int zzbx(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static int zzc(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    public static boolean zzf(byte[] bArr, int i11, int i12) {
        return zzbfo.zzf(bArr, i11, i12);
    }

    /* access modifiers changed from: private */
    public static int zzg(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return zzbx(b11);
        }
        if (i13 == 1) {
            return zzr(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return zzc(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    public static String zzh(byte[] bArr, int i11, int i12) throws zzrk {
        return zzbfo.zzh(bArr, i11, i12);
    }

    public static boolean zzi(byte[] bArr) {
        return zzbfo.zzf(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int zzr(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    public static int zza(CharSequence charSequence, byte[] bArr, int i11, int i12) {
        return zzbfo.zzb(charSequence, bArr, i11, i12);
    }

    public static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzub zzub = zzbfo;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            zzub.zzb(charSequence, byteBuffer);
        } else {
            zzub.zzc(charSequence, byteBuffer);
        }
    }
}
