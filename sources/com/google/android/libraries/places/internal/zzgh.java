package com.google.android.libraries.places.internal;

import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzgh<E> extends zzgb<E> implements Set<E> {
    @CheckForNull
    private transient zzge<E> zza;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzgx.zza(this);
    }

    public zzge<E> zzd() {
        zzge<E> zzge = this.zza;
        if (zzge != null) {
            return zzge;
        }
        zzge<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzha<E> iterator();

    public zzge<E> zzh() {
        return zzge.zzi(toArray());
    }
}
