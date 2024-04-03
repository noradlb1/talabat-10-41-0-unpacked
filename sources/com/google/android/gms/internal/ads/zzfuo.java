package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

final class zzfuo<T> extends zzfuf<T> implements Serializable {
    final zzfuf<? super T> zza;

    public zzfuo(zzfuf<? super T> zzfuf) {
        this.zza = zzfuf;
    }

    public final int compare(T t11, T t12) {
        return this.zza.compare(t12, t11);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfuo) {
            return this.zza.equals(((zzfuo) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    public final <S extends T> zzfuf<S> zza() {
        return this.zza;
    }
}
