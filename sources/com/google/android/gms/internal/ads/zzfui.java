package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfui<K, V> extends zzftc<Map.Entry<K, V>> {
    private final transient zzfsw<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzfui(zzfsw<K, V> zzfsw, Object[] objArr, int i11, int i12) {
        this.zza = zzfsw;
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

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        return zzd().zza(objArr, i11);
    }

    public final zzfuu<Map.Entry<K, V>> zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzfss<Map.Entry<K, V>> zzi() {
        return new zzfuh(this);
    }
}
