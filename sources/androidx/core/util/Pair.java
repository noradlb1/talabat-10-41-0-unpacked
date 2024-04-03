package androidx.core.util;

import androidx.annotation.NonNull;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f11, S s11) {
        this.first = f11;
        this.second = s11;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a11, B b11) {
        return new Pair<>(a11, b11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f11 = this.first;
        int i11 = 0;
        int hashCode = f11 == null ? 0 : f11.hashCode();
        S s11 = this.second;
        if (s11 != null) {
            i11 = s11.hashCode();
        }
        return hashCode ^ i11;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
