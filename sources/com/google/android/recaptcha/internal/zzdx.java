package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public final class zzdx extends zzeb implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzdx(int i11) {
        if (i11 >= 0) {
            this.zzb = new ArrayDeque(i11);
            this.zza = i11;
            return;
        }
        throw new IllegalArgumentException(zzdu.zza("maxSize (%s) must >= 0", Integer.valueOf(i11)));
    }

    public static zzdx zza(int i11) {
        return new zzdx(i11);
    }

    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    public final boolean addAll(Collection collection) {
        boolean z11;
        int size = collection.size();
        if (size < this.zza) {
            return zzee.zza(this, collection.iterator());
        }
        clear();
        int i11 = size - this.zza;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdr.zzb(z11, "number to skip cannot be negative");
        return zzee.zza(this, new zzed(collection, i11).iterator());
    }

    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    public final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    public final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    public final Queue zzd() {
        return this.zzb;
    }
}
