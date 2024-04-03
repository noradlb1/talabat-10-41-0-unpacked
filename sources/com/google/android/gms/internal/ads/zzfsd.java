package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

final class zzfsd<T> extends zzfuf<T> implements Serializable {
    final Comparator<T> zza;

    public zzfsd(Comparator<T> comparator) {
        comparator.getClass();
        this.zza = comparator;
    }

    public final int compare(T t11, T t12) {
        return this.zza.compare(t11, t12);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsd) {
            return this.zza.equals(((zzfsd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
