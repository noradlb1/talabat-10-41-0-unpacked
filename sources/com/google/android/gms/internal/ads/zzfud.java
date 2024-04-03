package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzfud extends zzfuf<Comparable<?>> implements Serializable {
    static final zzfud zza = new zzfud();

    private zzfud() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    public final <S extends Comparable> zzfuf<S> zza() {
        return zzfun.zza;
    }
}
