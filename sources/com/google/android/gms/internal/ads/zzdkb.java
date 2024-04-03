package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class zzdkb<ListenerT> {
    @GuardedBy("this")
    protected final Map<ListenerT, Executor> zza = new HashMap();

    public zzdkb(Set<zzdlw<ListenerT>> set) {
        zzm(set);
    }

    public final synchronized void zzg(zzdlw<ListenerT> zzdlw) {
        zzj(zzdlw.zza, zzdlw.zzb);
    }

    public final synchronized void zzj(ListenerT listenert, Executor executor) {
        this.zza.put(listenert, executor);
    }

    public final synchronized void zzm(Set<zzdlw<ListenerT>> set) {
        for (zzdlw<ListenerT> zzg : set) {
            zzg(zzg);
        }
    }

    public final synchronized void zzo(zzdka<ListenerT> zzdka) {
        for (Map.Entry next : this.zza.entrySet()) {
            ((Executor) next.getValue()).execute(new zzdjz(zzdka, next.getKey()));
        }
    }
}
