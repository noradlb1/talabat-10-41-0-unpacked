package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzck<T> extends zzcn<T> {
    static final zzck<Object> zzlf = new zzck<>();

    private zzck() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
