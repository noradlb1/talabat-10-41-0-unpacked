package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MutablePair<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public T f40645a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public T f40646b;

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!objectsEqual(pair.first, this.f40645a) || !objectsEqual(pair.second, this.f40646b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t11 = this.f40645a;
        int i11 = 0;
        int hashCode = t11 == null ? 0 : t11.hashCode();
        T t12 = this.f40646b;
        if (t12 != null) {
            i11 = t12.hashCode();
        }
        return hashCode ^ i11;
    }

    public void set(T t11, T t12) {
        this.f40645a = t11;
        this.f40646b = t12;
    }

    public String toString() {
        return "Pair{" + this.f40645a + " " + this.f40646b + "}";
    }
}
