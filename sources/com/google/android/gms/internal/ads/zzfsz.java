package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzfsz<K, V> extends zzfsn<V> {
    private final transient zzfta<K, V> zza;

    public zzfsz(zzfta<K, V> zzfta) {
        this.zza = zzfta;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.zzu(obj);
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfsx(this.zza);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        zzfuv zzu = ((zzfss) this.zza.zzb.values()).listIterator(0);
        while (zzu.hasNext()) {
            i11 = ((zzfsn) zzu.next()).zza(objArr, i11);
        }
        return i11;
    }

    public final zzfuu<V> zze() {
        return new zzfsx(this.zza);
    }

    public final boolean zzf() {
        throw null;
    }
}
