package org.apache.commons.lang3.mutable;

public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public void add(byte b11) {
        this.value = (byte) (this.value + b11);
    }

    public byte byteValue() {
        return this.value;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableByte) || this.value != ((MutableByte) obj).byteValue()) {
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
        this.value = (byte) (this.value + 1);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void subtract(byte b11) {
        this.value = (byte) (this.value - b11);
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableByte(byte b11) {
        this.value = b11;
    }

    public void add(Number number) {
        this.value = (byte) (this.value + number.byteValue());
    }

    public int compareTo(MutableByte mutableByte) {
        byte b11 = mutableByte.value;
        byte b12 = this.value;
        if (b12 < b11) {
            return -1;
        }
        return b12 == b11 ? 0 : 1;
    }

    public Byte getValue() {
        return Byte.valueOf(this.value);
    }

    public void setValue(byte b11) {
        this.value = b11;
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
        this.value = Byte.parseByte(str);
    }
}
