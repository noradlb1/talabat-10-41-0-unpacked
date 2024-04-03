package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

public class zzfta<K, V> extends zzfrq<K, V> implements Serializable {
    final transient zzfsw<K, ? extends zzfsn<V>> zzb;
    final transient int zzc;

    public zzfta(zzfsw<K, ? extends zzfsn<V>> zzfsw, int i11) {
        this.zzb = zzfsw;
        this.zzc = i11;
    }

    public final int zze() {
        throw null;
    }

    public final /* synthetic */ Collection zzf() {
        return new zzfsz(this);
    }

    public final Map<K, Collection<V>> zzj() {
        throw new AssertionError("should never be called");
    }

    public final Set<K> zzl() {
        throw new AssertionError("unreachable");
    }

    @Deprecated
    public final void zzp() {
        throw null;
    }

    @Deprecated
    public final boolean zzq(K k11, V v11) {
        throw null;
    }

    public final /* bridge */ /* synthetic */ Collection zzr() {
        throw null;
    }

    public final /* synthetic */ Map zzs() {
        return this.zzb;
    }

    public final boolean zzu(@CheckForNull Object obj) {
        return obj != null && super.zzu(obj);
    }
}
