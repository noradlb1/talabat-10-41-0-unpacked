package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzamw extends zzakd<Integer, Long> {
    public Long zza;
    public Long zzb;
    public Long zzc;
    public Long zzd;

    public zzamw() {
    }

    public final HashMap<Integer, Long> zzb() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        hashMap.put(3, this.zzd);
        return hashMap;
    }

    public zzamw(String str) {
        HashMap zza2 = zzakd.zza(str);
        if (zza2 != null) {
            this.zza = (Long) zza2.get(0);
            this.zzb = (Long) zza2.get(1);
            this.zzc = (Long) zza2.get(2);
            this.zzd = (Long) zza2.get(3);
        }
    }
}
