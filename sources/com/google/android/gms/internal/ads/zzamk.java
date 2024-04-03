package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzamk extends zzakd<Integer, Object> {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    public zzamk() {
    }

    public final HashMap<Integer, Object> zzb() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zza);
        hashMap.put(1, this.zzb);
        hashMap.put(2, this.zzc);
        return hashMap;
    }

    public zzamk(String str) {
        HashMap zza2 = zzakd.zza(str);
        if (zza2 != null) {
            this.zza = (Long) zza2.get(0);
            this.zzb = (Boolean) zza2.get(1);
            this.zzc = (Boolean) zza2.get(2);
        }
    }
}
