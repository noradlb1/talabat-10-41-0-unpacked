package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzevq<T> {
    private final Set<zzevn<? extends zzevm<T>>> zza;
    private final Executor zzb;

    public zzevq(Executor executor, Set<zzevn<? extends zzevm<T>>> set) {
        this.zzb = executor;
        this.zza = set;
    }

    public final zzfxa<T> zza(T t11) {
        ArrayList arrayList = new ArrayList(this.zza.size());
        for (zzevn next : this.zza) {
            zzfxa zzb2 = next.zzb();
            if (zzbmz.zza.zze().booleanValue()) {
                zzb2.zzc(new zzevo(next, zzt.zzA().elapsedRealtime()), zzcjm.zzf);
            }
            arrayList.add(zzb2);
        }
        return zzfwq.zzc(arrayList).zza(new zzevp(arrayList, t11), this.zzb);
    }
}
