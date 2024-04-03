package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzamn extends zzakd<Integer, Long> {
    public Long zza;
    public Long zzb;

    public zzamn() {
    }

    public final HashMap<Integer, Long> zzb() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        return hashMap;
    }

    public zzamn(String str) {
        HashMap zza2 = zzakd.zza(str);
        if (zza2 != null) {
            this.zza = (Long) zza2.get(0);
            this.zzb = (Long) zza2.get(1);
        }
    }
}
