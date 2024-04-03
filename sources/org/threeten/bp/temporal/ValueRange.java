package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long j11, long j12, long j13, long j14) {
        this.minSmallest = j11;
        this.minLargest = j12;
        this.maxSmallest = j13;
        this.maxLargest = j14;
    }

    public static ValueRange of(long j11, long j12) {
        if (j11 <= j12) {
            return new ValueRange(j11, j11, j12, j12);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long j11, TemporalField temporalField) {
        if (isValidIntValue(j11)) {
            return (int) j11;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j11);
    }

    public long checkValidValue(long j11, TemporalField temporalField) {
        if (isValidValue(j11)) {
            return j11;
        }
        if (temporalField != null) {
            throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j11);
        }
        throw new DateTimeException("Invalid value (valid values " + this + "): " + j11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        if (this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest) {
            return true;
        }
        return false;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public int hashCode() {
        long j11 = this.minSmallest;
        long j12 = this.minLargest;
        long j13 = (j11 + j12) << ((int) (j12 + 16));
        long j14 = this.maxSmallest;
        long j15 = (j13 >> ((int) (j14 + 48))) << ((int) (j14 + 32));
        long j16 = this.maxLargest;
        long j17 = ((j15 >> ((int) (32 + j16))) << ((int) (j16 + 48))) >> 16;
        return (int) (j17 ^ (j17 >>> 32));
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= 2147483647L;
    }

    public boolean isValidIntValue(long j11) {
        return isIntValue() && isValidValue(j11);
    }

    public boolean isValidValue(long j11) {
        return j11 >= getMinimum() && j11 <= getMaximum();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            sb2.append('/');
            sb2.append(this.minLargest);
        }
        sb2.append(" - ");
        sb2.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            sb2.append('/');
            sb2.append(this.maxLargest);
        }
        return sb2.toString();
    }

    public static ValueRange of(long j11, long j12, long j13) {
        return of(j11, j11, j12, j13);
    }

    public static ValueRange of(long j11, long j12, long j13, long j14) {
        if (j11 > j12) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j13 > j14) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j12 <= j14) {
            return new ValueRange(j11, j12, j13, j14);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }
}
