package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

public final class zzfgb {
    private final HashMap<zzffr, zzfga<?, ?>> zza = new HashMap<>();

    public final <R extends zzdea<AdT>, AdT extends zzdav> zzfga<R, AdT> zza(zzffr zzffr, Context context, zzffj zzffj, zzfgh<R, AdT> zzfgh) {
        zzfga<R, AdT> zzfga = this.zza.get(zzffr);
        if (zzfga != null) {
            return zzfga;
        }
        zzffo zzffo = new zzffo(zzffu.zza(zzffr, context));
        zzfga<R, AdT> zzfga2 = new zzfga<>(zzffo, new zzfgj(zzffo, zzffj, zzfgh));
        this.zza.put(zzffr, zzfga2);
        return zzfga2;
    }
}
