package com.google.android.gms.internal.ads;

import java.io.Serializable;

final class zzfun extends zzfuf<Comparable<?>> implements Serializable {
    static final zzfun zza = new zzfun();

    private zzfun() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final <S extends Comparable> zzfuf<S> zza() {
        return zzfud.zza;
    }
}
