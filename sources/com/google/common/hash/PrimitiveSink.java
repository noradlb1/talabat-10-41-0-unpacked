package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Beta
public interface PrimitiveSink {
    @CanIgnoreReturnValue
    PrimitiveSink putBoolean(boolean z11);

    @CanIgnoreReturnValue
    PrimitiveSink putByte(byte b11);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr, int i11, int i12);

    @CanIgnoreReturnValue
    PrimitiveSink putChar(char c11);

    @CanIgnoreReturnValue
    PrimitiveSink putDouble(double d11);

    @CanIgnoreReturnValue
    PrimitiveSink putFloat(float f11);

    @CanIgnoreReturnValue
    PrimitiveSink putInt(int i11);

    @CanIgnoreReturnValue
    PrimitiveSink putLong(long j11);

    @CanIgnoreReturnValue
    PrimitiveSink putShort(short s11);

    @CanIgnoreReturnValue
    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
