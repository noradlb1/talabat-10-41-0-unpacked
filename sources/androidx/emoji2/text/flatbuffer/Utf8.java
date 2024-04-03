package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public abstract class Utf8 {
    private static Utf8 DEFAULT;

    public static class DecodeUtil {
        public static void a(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) throws IllegalArgumentException {
            if (isNotTrailingByte(b12) || (((b11 << Ascii.FS) + (b12 + 112)) >> 30) != 0 || isNotTrailingByte(b13) || isNotTrailingByte(b14)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int trailingByteValue = ((b11 & 7) << Ascii.DC2) | (trailingByteValue(b12) << 12) | (trailingByteValue(b13) << 6) | trailingByteValue(b14);
            cArr[i11] = highSurrogate(trailingByteValue);
            cArr[i11 + 1] = lowSurrogate(trailingByteValue);
        }

        public static void b(byte b11, char[] cArr, int i11) {
            cArr[i11] = (char) b11;
        }

        public static void c(byte b11, byte b12, byte b13, char[] cArr, int i11) throws IllegalArgumentException {
            if (isNotTrailingByte(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || isNotTrailingByte(b13)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i11] = (char) (((b11 & Ascii.SI) << 12) | (trailingByteValue(b12) << 6) | trailingByteValue(b13));
        }

        public static void d(byte b11, byte b12, char[] cArr, int i11) throws IllegalArgumentException {
            if (b11 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            } else if (!isNotTrailingByte(b12)) {
                cArr[i11] = (char) (((b11 & Ascii.US) << 6) | trailingByteValue(b12));
            } else {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
        }

        public static boolean e(byte b11) {
            return b11 >= 0;
        }

        public static boolean f(byte b11) {
            return b11 < -16;
        }

        public static boolean g(byte b11) {
            return b11 < -32;
        }

        private static char highSurrogate(int i11) {
            return (char) ((i11 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b11) {
            return b11 > -65;
        }

        private static char lowSurrogate(int i11) {
            return (char) ((i11 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b11) {
            return b11 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i11, int i12);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
