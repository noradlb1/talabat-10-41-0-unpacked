package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdm<K> extends zzdj<K> {
    private final transient zzdf<K> zzlm;
    private final transient zzdg<K, ?> zzlw;

    public zzdm(zzdg<K, ?> zzdg, zzdf<K> zzdf) {
        this.zzlw = zzdg;
        this.zzlm = zzdf;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzlw.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zzlw.size();
    }

    public final int zza(Object[] objArr, int i11) {
        return zzcc().zza(objArr, i11);
    }

    public final zzdr<K> zzby() {
        return (zzdr) zzcc().iterator();
    }

    public final zzdf<K> zzcc() {
        return this.zzlm;
    }
}
