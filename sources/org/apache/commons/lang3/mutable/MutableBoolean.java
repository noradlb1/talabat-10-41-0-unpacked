package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableBoolean implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean> {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public MutableBoolean() {
    }

    public boolean booleanValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoolean) || this.value != ((MutableBoolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.value ? Boolean.TRUE : Boolean.FALSE).hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        return this.value;
    }

    public void setFalse() {
        this.value = false;
    }

    public void setTrue() {
        this.value = true;
    }

    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableBoolean(boolean z11) {
        this.value = z11;
    }

    public int compareTo(MutableBoolean mutableBoolean) {
        boolean z11 = mutableBoolean.value;
        boolean z12 = this.value;
        if (z12 == z11) {
            return 0;
        }
        return z12 ? 1 : -1;
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    public void setValue(boolean z11) {
        this.value = z11;
    }

    public void setValue(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }
}
