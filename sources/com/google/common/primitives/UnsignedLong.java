package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    private final long value;

    private UnsignedLong(long j11) {
        this.value = j11;
    }

    public static UnsignedLong fromLongBits(long j11) {
        return new UnsignedLong(j11);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j11) {
        Preconditions.checkArgument(j11 >= 0, "value (%s) is outside the range for an unsigned long value", j11);
        return fromLongBits(j11);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) {
            return valueOf.setBit(63);
        }
        return valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public double doubleValue() {
        long j11 = this.value;
        if (j11 >= 0) {
            return (double) j11;
        }
        return ((double) ((j11 & 1) | (j11 >>> 1))) * 2.0d;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof UnsignedLong) || this.value != ((UnsignedLong) obj).value) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        long j11 = this.value;
        if (j11 >= 0) {
            return (float) j11;
        }
        return ((float) ((j11 & 1) | (j11 >>> 1))) * 2.0f;
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public String toString(int i11) {
        return UnsignedLongs.toString(this.value, i11);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", (Object) bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i11) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i11));
    }
}
