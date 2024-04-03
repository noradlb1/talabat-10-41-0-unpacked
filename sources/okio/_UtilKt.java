package okio;

import com.checkout.frames.utils.constants.CountryPickerScreenConstants;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.internal._ByteStringKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0015H\b\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0001H\b\u001a\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0015H\f\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\f\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0015*\u00020\u0015H\u0000\u001a\f\u0010!\u001a\u00020\"*\u00020\"H\u0000\u001a\u0015\u0010#\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\f\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\f\u001a\f\u0010&\u001a\u00020'*\u00020\u001bH\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0001H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0015H\u0000\u001a\u0015\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\f\"\u0014\u0010\u0000\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"DEFAULT__ByteString_size", "", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "arrayRangeEquals", "", "a", "", "aOffset", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "resolveDefaultParameter", "unsafeCursor", "and", "", "other", "leftRotate", "bitCount", "Lokio/ByteString;", "position", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _UtilKt {
    private static final int DEFAULT__ByteString_size = -1234567890;
    @NotNull
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();

    public static final int and(byte b11, int i11) {
        return b11 & i11;
    }

    public static final long and(byte b11, long j11) {
        return ((long) b11) & j11;
    }

    public static final long and(int i11, long j11) {
        return ((long) i11) & j11;
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] bArr, int i11, @NotNull byte[] bArr2, int i12, int i13) {
        Intrinsics.checkNotNullParameter(bArr, "a");
        Intrinsics.checkNotNullParameter(bArr2, "b");
        if (i13 <= 0) {
            return true;
        }
        int i14 = 0;
        while (true) {
            int i15 = i14 + 1;
            if (bArr[i14 + i11] != bArr2[i14 + i12]) {
                return false;
            }
            if (i15 >= i13) {
                return true;
            }
            i14 = i15;
        }
    }

    public static final void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException("size=" + j11 + " offset=" + j12 + " byteCount=" + j13);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    @NotNull
    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int i11, int i12) {
        return (i11 >>> (32 - i12)) | (i11 << i12);
    }

    public static final long minOf(long j11, int i11) {
        return Math.min(j11, (long) i11);
    }

    @NotNull
    public static final Buffer.UnsafeCursor resolveDefaultParameter(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int reverseBytes(int i11) {
        return ((i11 & 255) << 24) | ((-16777216 & i11) >>> 24) | ((16711680 & i11) >>> 8) | ((65280 & i11) << 8);
    }

    public static final long reverseBytes(long j11) {
        return ((j11 & 255) << 56) | ((-72057594037927936L & j11) >>> 56) | ((71776119061217280L & j11) >>> 40) | ((280375465082880L & j11) >>> 24) | ((1095216660480L & j11) >>> 8) | ((CountryPickerScreenConstants.focusedBorderColor & j11) << 8) | ((16711680 & j11) << 24) | ((65280 & j11) << 40);
    }

    public static final short reverseBytes(short s11) {
        short s12 = s11 & UShort.MAX_VALUE;
        return (short) (((s12 & 255) << 8) | ((65280 & s12) >>> 8));
    }

    public static final long rightRotate(long j11, int i11) {
        return (j11 << (64 - i11)) | (j11 >>> i11);
    }

    public static final int shl(byte b11, int i11) {
        return b11 << i11;
    }

    public static final int shr(byte b11, int i11) {
        return b11 >> i11;
    }

    @NotNull
    public static final String toHexString(byte b11) {
        return StringsKt__StringsJVMKt.concatToString(new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[b11 & Ascii.SI]});
    }

    public static final byte xor(byte b11, byte b12) {
        return (byte) (b11 ^ b12);
    }

    public static final long minOf(int i11, long j11) {
        return Math.min((long) i11, j11);
    }

    public static final int resolveDefaultParameter(@NotNull ByteString byteString, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i11 == DEFAULT__ByteString_size ? byteString.size() : i11;
    }

    @NotNull
    public static final String toHexString(int i11) {
        if (i11 == 0) {
            return "0";
        }
        int i12 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 28) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 24) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 20) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 16) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 12) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 8) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[(i11 >> 4) & 15], _ByteStringKt.getHEX_DIGIT_CHARS()[i11 & 15]};
        while (i12 < 8 && cArr[i12] == '0') {
            i12++;
        }
        return StringsKt__StringsJVMKt.concatToString(cArr, i12, 8);
    }

    @NotNull
    public static final String toHexString(long j11) {
        if (j11 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {_ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 60) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 56) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 52) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 48) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 44) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 40) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 36) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 32) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 28) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 24) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 20) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 16) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 12) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 8) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j11 >> 4) & 15)], _ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j11 & 15)]};
        while (i11 < 16 && cArr[i11] == '0') {
            i11++;
        }
        return StringsKt__StringsJVMKt.concatToString(cArr, i11, 16);
    }
}
