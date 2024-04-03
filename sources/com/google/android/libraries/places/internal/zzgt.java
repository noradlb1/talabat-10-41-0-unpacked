package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzgt<K, V> extends zzgh<Map.Entry<K, V>> {
    private final transient zzgg<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzgt(zzgg<K, V> zzgg, Object[] objArr, int i11, int i12) {
        this.zza = zzgg;
        this.zzb = objArr;
        this.zzc = i12;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        return zzd().zza(objArr, 0);
    }

    public final zzha<Map.Entry<K, V>> zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzge<Map.Entry<K, V>> zzh() {
        return new zzgs(this);
    }
}
