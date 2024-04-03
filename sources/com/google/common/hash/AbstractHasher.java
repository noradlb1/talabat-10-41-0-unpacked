package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
abstract class AbstractHasher implements Hasher {
    public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b11) {
        return putByte(b11);
    }

    @CanIgnoreReturnValue
    public <T> Hasher putObject(@ParametricNullness T t11, Funnel<? super T> funnel) {
        funnel.funnel(t11, this);
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putBoolean(boolean z11) {
        return putByte(z11 ? (byte) 1 : 0);
    }

    @CanIgnoreReturnValue
    public Hasher putChar(char c11) {
        putByte((byte) c11);
        putByte((byte) (c11 >>> 8));
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher putDouble(double d11) {
        return putLong(Double.doubleToRawLongBits(d11));
    }

    @CanIgnoreReturnValue
    public final Hasher putFloat(float f11) {
        return putInt(Float.floatToRawIntBits(f11));
    }

    @CanIgnoreReturnValue
    public Hasher putInt(int i11) {
        putByte((byte) i11);
        putByte((byte) (i11 >>> 8));
        putByte((byte) (i11 >>> 16));
        putByte((byte) (i11 >>> 24));
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher putLong(long j11) {
        for (int i11 = 0; i11 < 64; i11 += 8) {
            putByte((byte) ((int) (j11 >>> i11)));
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher putShort(short s11) {
        putByte((byte) s11);
        putByte((byte) (s11 >>> 8));
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    @CanIgnoreReturnValue
    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            putChar(charSequence.charAt(i11));
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    @CanIgnoreReturnValue
    public Hasher putBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        for (int i13 = 0; i13 < i12; i13++) {
            putByte(bArr[i11 + i13]);
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }
}
