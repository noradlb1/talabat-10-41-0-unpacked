package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzfuj<K> extends zzftc<K> {
    private final transient zzfsw<K, ?> zza;
    private final transient zzfss<K> zzb;

    public zzfuj(zzfsw<K, ?> zzfsw, zzfss<K> zzfss) {
        this.zza = zzfsw;
        this.zzb = zzfss;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i11) {
        return this.zzb.zza(objArr, i11);
    }

    public final zzfss<K> zzd() {
        return this.zzb;
    }

    public final zzfuu<K> zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }
}
