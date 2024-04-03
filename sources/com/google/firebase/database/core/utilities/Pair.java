package com.google.firebase.database.core.utilities;

public final class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T t11, U u11) {
        this.first = t11;
        this.second = u11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Pair.class != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        T t11 = this.first;
        if (t11 == null ? pair.first != null : !t11.equals(pair.first)) {
            return false;
        }
        U u11 = this.second;
        U u12 = pair.second;
        if (u11 == null ? u12 == null : u11.equals(u12)) {
            return true;
        }
        return false;
    }

    public T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    public int hashCode() {
        int i11;
        T t11 = this.first;
        int i12 = 0;
        if (t11 != null) {
            i11 = t11.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        U u11 = this.second;
        if (u11 != null) {
            i12 = u11.hashCode();
        }
        return i13 + i12;
    }

    public String toString() {
        return "Pair(" + this.first + "," + this.second + ")";
    }
}
