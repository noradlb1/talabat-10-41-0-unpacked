package com.google.android.libraries.places.internal;

final class zzfv extends zzfz<Comparable<?>> {
    /* access modifiers changed from: private */
    public static final zzfv zzb = new zzfv();

    private zzfv() {
        super("");
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((zzfz) obj);
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "+∞";
    }

    public final int zza(zzfz<Comparable<?>> zzfz) {
        return zzfz == this ? 0 : 1;
    }

    public final void zzc(StringBuilder sb2) {
        throw new AssertionError();
    }

    public final void zzd(StringBuilder sb2) {
        sb2.append("+∞)");
    }

    public final boolean zze(Comparable<?> comparable) {
        return false;
    }
}
