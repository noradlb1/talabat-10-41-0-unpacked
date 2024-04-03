package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdj<E> extends zzdc<E> implements Set<E> {
    @NullableDecl
    private transient zzdf<E> zzlv;

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzdo.zza(this, obj);
    }

    public int hashCode() {
        return zzdo.zza(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzdf<E> zzcc() {
        zzdf<E> zzdf = this.zzlv;
        if (zzdf != null) {
            return zzdf;
        }
        zzdf<E> zzch = zzch();
        this.zzlv = zzch;
        return zzch;
    }

    public zzdf<E> zzch() {
        return zzdf.zza(toArray());
    }
}
