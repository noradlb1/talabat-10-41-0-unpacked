package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcy<T> implements zzcu<T>, Serializable {
    @NullableDecl
    private final T zzlk;

    public zzcy(@NullableDecl T t11) {
        this.zzlk = t11;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzcy) {
            return zzco.equal(this.zzlk, ((zzcy) obj).zzlk);
        }
        return false;
    }

    public final T get() {
        return this.zzlk;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzlk});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlk);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
        sb2.append("Suppliers.ofInstance(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
