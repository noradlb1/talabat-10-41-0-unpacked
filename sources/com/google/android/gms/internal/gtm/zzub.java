package com.google.android.gms.internal.gtm;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

abstract class zzub {
    public static void zzc(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i11;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i12 = 0;
        while (i12 < length) {
            try {
                char charAt = charSequence.charAt(i12);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i12, (byte) charAt);
                i12++;
            } catch (IndexOutOfBoundsException unused) {
                char charAt2 = charSequence.charAt(i12);
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1));
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
        }
        if (i12 == length) {
            byteBuffer.position(position + i12);
            return;
        }
        position += i12;
        while (i12 < length) {
            char charAt3 = charSequence.charAt(i12);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                i11 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i11, (byte) ((charAt3 & '?') | 128));
                    position = i11;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i11;
                    char charAt22 = charSequence.charAt(i12);
                    StringBuilder sb22 = new StringBuilder(37);
                    sb22.append("Failed writing ");
                    sb22.append(charAt22);
                    sb22.append(" at index ");
                    sb22.append(byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1));
                    throw new ArrayIndexOutOfBoundsException(sb22.toString());
                }
            } else if (charAt3 < 55296 || 57343 < charAt3) {
                i11 = position + 1;
                byteBuffer.put(position, (byte) ((charAt3 >>> 12) | 224));
                position = i11 + 1;
                byteBuffer.put(i11, (byte) (((charAt3 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
            } else {
                int i13 = i12 + 1;
                if (i13 != length) {
                    try {
                        char charAt4 = charSequence.charAt(i13);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            int i14 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                position = i14 + 1;
                                byteBuffer.put(i14, (byte) (((codePoint >>> 12) & 63) | 128));
                                i14 = position + 1;
                                byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i14, (byte) ((codePoint & 63) | 128));
                                position = i14;
                                i12 = i13;
                            } catch (IndexOutOfBoundsException unused3) {
                                position = i14;
                                i12 = i13;
                                char charAt222 = charSequence.charAt(i12);
                                StringBuilder sb222 = new StringBuilder(37);
                                sb222.append("Failed writing ");
                                sb222.append(charAt222);
                                sb222.append(" at index ");
                                sb222.append(byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1));
                                throw new ArrayIndexOutOfBoundsException(sb222.toString());
                            }
                        } else {
                            i12 = i13;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i12 = i13;
                        char charAt2222 = charSequence.charAt(i12);
                        StringBuilder sb2222 = new StringBuilder(37);
                        sb2222.append("Failed writing ");
                        sb2222.append(charAt2222);
                        sb2222.append(" at index ");
                        sb2222.append(byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1));
                        throw new ArrayIndexOutOfBoundsException(sb2222.toString());
                    }
                }
                throw new zzud(i12, length);
            }
            i12++;
            position++;
        }
        byteBuffer.position(position);
    }

    public abstract int zzb(int i11, byte[] bArr, int i12, int i13);

    public abstract int zzb(CharSequence charSequence, byte[] bArr, int i11, int i12);

    public abstract void zzb(CharSequence charSequence, ByteBuffer byteBuffer);

    public final boolean zzf(byte[] bArr, int i11, int i12) {
        return zzb(0, bArr, i11, i12) == 0;
    }

    public abstract String zzh(byte[] bArr, int i11, int i12) throws zzrk;
}
