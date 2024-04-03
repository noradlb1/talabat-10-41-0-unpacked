package com.google.android.libraries.places.internal;

import java.lang.Comparable;

final class zzfy<C extends Comparable> extends zzfz<C> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfy(C c11) {
        super(c11);
        c11.getClass();
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 2);
        sb2.append("\\");
        sb2.append(valueOf);
        sb2.append("/");
        return sb2.toString();
    }

    public final void zzc(StringBuilder sb2) {
        sb2.append('[');
        sb2.append(this.zza);
    }

    public final void zzd(StringBuilder sb2) {
        sb2.append(this.zza);
        sb2.append(')');
    }

    public final boolean zze(C c11) {
        return zzgp.zza(this.zza, c11) <= 0;
    }
}
