package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzalz extends zzakd<Integer, Long> {
    public long zza = -1;
    public long zzb = -1;

    public zzalz() {
    }

    public final HashMap<Integer, Long> zzb() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zza));
        hashMap.put(1, Long.valueOf(this.zzb));
        return hashMap;
    }

    public zzalz(String str) {
        HashMap zza2 = zzakd.zza(str);
        if (zza2 != null) {
            this.zza = ((Long) zza2.get(0)).longValue();
            this.zzb = ((Long) zza2.get(1)).longValue();
        }
    }
}
