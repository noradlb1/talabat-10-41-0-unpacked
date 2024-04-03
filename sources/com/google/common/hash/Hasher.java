package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @CanIgnoreReturnValue
    Hasher putBoolean(boolean z11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z11);

    @CanIgnoreReturnValue
    Hasher putByte(byte b11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b11);

    @CanIgnoreReturnValue
    Hasher putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr, int i11, int i12);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i11, int i12);

    @CanIgnoreReturnValue
    Hasher putChar(char c11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c11);

    @CanIgnoreReturnValue
    Hasher putDouble(double d11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d11);

    @CanIgnoreReturnValue
    Hasher putFloat(float f11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f11);

    @CanIgnoreReturnValue
    Hasher putInt(int i11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i11);

    @CanIgnoreReturnValue
    Hasher putLong(long j11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j11);

    @CanIgnoreReturnValue
    <T> Hasher putObject(@ParametricNullness T t11, Funnel<? super T> funnel);

    @CanIgnoreReturnValue
    Hasher putShort(short s11);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s11);

    @CanIgnoreReturnValue
    Hasher putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    Hasher putUnencodedChars(CharSequence charSequence);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
