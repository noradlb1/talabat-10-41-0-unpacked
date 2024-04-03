package org.apache.commons.lang3.mutable;

public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public MutableShort() {
    }

    public void add(short s11) {
        this.value = (short) (this.value + s11);
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.value != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public short shortValue() {
        return this.value;
    }

    public void subtract(short s11) {
        this.value = (short) (this.value - s11);
    }

    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableShort(short s11) {
        this.value = s11;
    }

    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    public int compareTo(MutableShort mutableShort) {
        short s11 = mutableShort.value;
        short s12 = this.value;
        if (s12 < s11) {
            return -1;
        }
        return s12 == s11 ? 0 : 1;
    }

    public Short getValue() {
        return Short.valueOf(this.value);
    }

    public void setValue(short s11) {
        this.value = s11;
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.value = Short.parseShort(str);
    }
}
