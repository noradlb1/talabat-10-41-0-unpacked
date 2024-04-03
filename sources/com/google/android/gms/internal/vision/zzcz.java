package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcz<T> implements zzcu<T> {
    @NullableDecl
    private T value;
    private volatile zzcu<T> zzli;
    private volatile boolean zzlj;

    public zzcz(zzcu<T> zzcu) {
        this.zzli = (zzcu) zzct.checkNotNull(zzcu);
    }

    public final T get() {
        if (!this.zzlj) {
            synchronized (this) {
                if (!this.zzlj) {
                    T t11 = this.zzli.get();
                    this.value = t11;
                    this.zzlj = true;
                    this.zzli = null;
                    return t11;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzli;
        if (obj == null) {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf2);
        sb3.append(")");
        return sb3.toString();
    }
}
