package org.apache.commons.lang3.mutable;

public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public MutableInt() {
    }

    public void add(int i11) {
        this.value += i11;
    }

    public void decrement() {
        this.value--;
    }

    public double doubleValue() {
        return (double) this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableInt) || this.value != ((MutableInt) obj).intValue()) {
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
        this.value++;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public void subtract(int i11) {
        this.value -= i11;
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i11) {
        this.value = i11;
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    public int compareTo(MutableInt mutableInt) {
        int i11 = mutableInt.value;
        int i12 = this.value;
        if (i12 < i11) {
            return -1;
        }
        return i12 == i11 ? 0 : 1;
    }

    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    public void setValue(int i11) {
        this.value = i11;
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }
}
