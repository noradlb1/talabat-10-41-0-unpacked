package com.google.android.gms.internal.ads;

public class zzfsu<K, V> extends zzfta<K, V> implements zzfth<K, V> {
    public zzfsu(zzfsw<K, zzfss<V>> zzfsw, int i11) {
        super(zzfsw, i11);
    }

    public final zzfss<V> zza(K k11) {
        zzfss<V> zzfss = (zzfss) this.zzb.get(k11);
        if (zzfss == null) {
            return zzfss.zzo();
        }
        return zzfss;
    }
}
