package com.google.android.libraries.places.internal;

import java.util.Arrays;

public final class zzgf<K, V> {
    Object[] zza = new Object[8];
    int zzb = 0;

    public final zzgf<K, V> zza(K k11, V v11) {
        int i11 = this.zzb + 1;
        int i12 = i11 + i11;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (i12 > length) {
            int i13 = length + (length >> 1) + 1;
            if (i13 < i12) {
                int highestOneBit = Integer.highestOneBit(i12 - 1);
                i13 = highestOneBit + highestOneBit;
            }
            if (i13 < 0) {
                i13 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i13);
        }
        zzft.zza(k11, v11);
        Object[] objArr2 = this.zza;
        int i14 = this.zzb;
        int i15 = i14 + i14;
        objArr2[i15] = k11;
        objArr2[i15 + 1] = v11;
        this.zzb = i14 + 1;
        return this;
    }

    public final zzgg<K, V> zzb() {
        return zzgw.zzf(this.zzb, this.zza);
    }
}
