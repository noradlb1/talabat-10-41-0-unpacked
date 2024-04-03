package org.apache.commons.lang3.mutable;

public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public void add(long j11) {
        this.value += j11;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableLong) || this.value != ((MutableLong) obj).longValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        long j11 = this.value;
        return (int) (j11 ^ (j11 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public void subtract(long j11) {
        this.value -= j11;
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j11) {
        this.value = j11;
    }

    public void add(Number number) {
        this.value += number.longValue();
    }

    public int compareTo(MutableLong mutableLong) {
        long j11 = mutableLong.value;
        long j12 = this.value;
        if (j12 < j11) {
            return -1;
        }
        return j12 == j11 ? 0 : 1;
    }

    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public void setValue(long j11) {
        this.value = j11;
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public void setValue(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        this.value = Long.parseLong(str);
    }
}
