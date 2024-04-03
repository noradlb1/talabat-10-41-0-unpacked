package org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableObject<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.value.equals(((MutableObject) obj).value);
        }
        return false;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t11 = this.value;
        if (t11 == null) {
            return 0;
        }
        return t11.hashCode();
    }

    public void setValue(T t11) {
        this.value = t11;
    }

    public String toString() {
        T t11 = this.value;
        return t11 == null ? "null" : t11.toString();
    }

    public MutableObject(T t11) {
        this.value = t11;
    }
}
