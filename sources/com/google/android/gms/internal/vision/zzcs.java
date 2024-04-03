package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcs<T> extends zzcn<T> {
    private final T zzlh;

    public zzcs(T t11) {
        this.zzlh = t11;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzcs) {
            return this.zzlh.equals(((zzcs) obj).zzlh);
        }
        return false;
    }

    public final T get() {
        return this.zzlh;
    }

    public final int hashCode() {
        return this.zzlh.hashCode() + 1502476572;
    }

    public final boolean isPresent() {
        return true;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlh);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
        sb2.append("Optional.of(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
