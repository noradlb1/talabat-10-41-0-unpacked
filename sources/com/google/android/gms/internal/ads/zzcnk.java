package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzcnk {
    private final ArrayList<zzawa> zza = new ArrayList<>();
    private long zzb;

    public final long zza() {
        Iterator<zzawa> it = this.zza.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> zze = it.next().zze();
            if (zze != null) {
                for (Map.Entry next : zze.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzb;
    }

    public final void zzb(zzawa zzawa) {
        this.zza.add(zzawa);
    }
}
