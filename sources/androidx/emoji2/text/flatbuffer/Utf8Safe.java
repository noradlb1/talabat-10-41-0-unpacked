package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i11, int i12) {
            super("Unpaired surrogate at index " + i11 + " of " + i12);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 < length) {
                char charAt = charSequence.charAt(i11);
                if (charAt >= 2048) {
                    i12 += encodedLengthGeneral(charSequence, i11);
                    break;
                }
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                break;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i12) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i11, int i12) {
        if ((i11 | i12 | ((bArr.length - i11) - i12)) >= 0) {
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (r12 < i13) {
                byte b11 = bArr[r12];
                if (!Utf8.DecodeUtil.e(b11)) {
                    break;
                }
                i11 = r12 + 1;
                Utf8.DecodeUtil.b(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (r12 < i13) {
                int i16 = r12 + 1;
                byte b12 = bArr[r12];
                if (Utf8.DecodeUtil.e(b12)) {
                    int i17 = i15 + 1;
                    Utf8.DecodeUtil.b(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = bArr[i16];
                        if (!Utf8.DecodeUtil.e(b13)) {
                            break;
                        }
                        i16++;
                        Utf8.DecodeUtil.b(b13, cArr, i17);
                        i17++;
                    }
                    r12 = i16;
                    i15 = i17;
                } else if (Utf8.DecodeUtil.g(b12)) {
                    if (i16 < i13) {
                        Utf8.DecodeUtil.d(b12, bArr[i16], cArr, i15);
                        r12 = i16 + 1;
                        i15++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.f(b12)) {
                    if (i16 < i13 - 1) {
                        int i18 = i16 + 1;
                        Utf8.DecodeUtil.c(b12, bArr[i16], bArr[i18], cArr, i15);
                        r12 = i18 + 1;
                        i15++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i16 < i13 - 2) {
                    int i19 = i16 + 1;
                    byte b14 = bArr[i16];
                    int i21 = i19 + 1;
                    Utf8.DecodeUtil.a(b12, b14, bArr[i19], bArr[i21], cArr, i15);
                    r12 = i21 + 1;
                    i15 = i15 + 1 + 1;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i15);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i11, int i12) {
        if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) >= 0) {
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (r12 < i13) {
                byte b11 = byteBuffer.get(r12);
                if (!Utf8.DecodeUtil.e(b11)) {
                    break;
                }
                i11 = r12 + 1;
                Utf8.DecodeUtil.b(b11, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (r12 < i13) {
                int i16 = r12 + 1;
                byte b12 = byteBuffer.get(r12);
                if (Utf8.DecodeUtil.e(b12)) {
                    int i17 = i15 + 1;
                    Utf8.DecodeUtil.b(b12, cArr, i15);
                    while (i16 < i13) {
                        byte b13 = byteBuffer.get(i16);
                        if (!Utf8.DecodeUtil.e(b13)) {
                            break;
                        }
                        i16++;
                        Utf8.DecodeUtil.b(b13, cArr, i17);
                        i17++;
                    }
                    r12 = i16;
                    i15 = i17;
                } else if (Utf8.DecodeUtil.g(b12)) {
                    if (i16 < i13) {
                        Utf8.DecodeUtil.d(b12, byteBuffer.get(i16), cArr, i15);
                        r12 = i16 + 1;
                        i15++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.f(b12)) {
                    if (i16 < i13 - 1) {
                        int i18 = i16 + 1;
                        Utf8.DecodeUtil.c(b12, byteBuffer.get(i16), byteBuffer.get(i18), cArr, i15);
                        r12 = i18 + 1;
                        i15++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i16 < i13 - 2) {
                    int i19 = i16 + 1;
                    byte b14 = byteBuffer.get(i16);
                    int i21 = i19 + 1;
                    Utf8.DecodeUtil.a(b12, b14, byteBuffer.get(i19), byteBuffer.get(i21), cArr, i15);
                    r12 = i21 + 1;
                    i15 = i15 + 1 + 1;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i15);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i11, int i12) {
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
                throw new UnpairedSurrogateException(i17 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i13 = i17 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i18);
            } else {
                throw new UnpairedSurrogateException(i17, length);
            }
            i18 = i14;
            i17++;
        }
        return i18;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
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
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i12 == length) {
            byteBuffer.position(position + i12);
            return;
        }
        position += i12;
        while (i12 < length) {
            char charAt2 = charSequence.charAt(i12);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                i11 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                    byteBuffer.put(i11, (byte) ((charAt2 & '?') | 128));
                    position = i11;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i11;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                i11 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                position = i11 + 1;
                byteBuffer.put(i11, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i13 = i12 + 1;
                if (i13 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i13);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
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
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i12 = i13;
                        }
                    } catch (IndexOutOfBoundsException unused4) {
                        i12 = i13;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i12) + " at index " + (byteBuffer.position() + Math.max(i12, (position - byteBuffer.position()) + 1)));
                    }
                }
                throw new UnpairedSurrogateException(i12, length);
            }
            i12++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
            } else {
                i12 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i11) >= 65536) {
                        i11++;
                    } else {
                        throw new UnpairedSurrogateException(i11, length);
                    }
                }
            }
            i11++;
        }
        return i12;
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
        }
        return decodeUtf8Buffer(byteBuffer, i11, i12);
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }

    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
