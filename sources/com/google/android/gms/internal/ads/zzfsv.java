package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfsv<K, V> {
    Object[] zza;
    int zzb;

    public zzfsv() {
        this(4);
    }

    private final void zzd(int i11) {
        int i12 = i11 + i11;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i12 > length) {
            this.zza = Arrays.copyOf(objArr, zzfsm.zzd(length, i12));
        }
    }

    public final zzfsv<K, V> zza(K k11, V v11) {
        zzd(this.zzb + 1);
        zzfrr.zzb(k11, v11);
        Object[] objArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + i11;
        objArr[i12] = k11;
        objArr[i12 + 1] = v11;
        this.zzb = i11 + 1;
        return this;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable<? extends java.util.Map$Entry<? extends K, ? extends V>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfsv<K, V> zzb(java.lang.Iterable<? extends java.util.Map.Entry<? extends K, ? extends V>> r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 == 0) goto L_0x000e
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zzd(r0)
        L_0x000e:
            java.util.Iterator r3 = r3.iterator()
        L_0x0012:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r2.zza(r1, r0)
            goto L_0x0012
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfsv.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzfsv");
    }

    public final zzfsw<K, V> zzc() {
        return zzful.zzh(this.zzb, this.zza);
    }

    public zzfsv(int i11) {
        this.zza = new Object[(i11 + i11)];
        this.zzb = 0;
    }
}
