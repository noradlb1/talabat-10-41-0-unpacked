package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

public final class zzext implements zzgpr<zzevq<JSONObject>> {
    public static zzevq<JSONObject> zza(zzchz zzchz, zzcia zzcia, Object obj, zzewi zzewi, zzexg zzexg, zzgpl<zzewc> zzgpl, zzgpl<zzewl> zzgpl2, zzgpl<zzewr> zzgpl3, zzgpl<zzewv> zzgpl4, zzgpl<zzexc> zzgpl5, zzgpl<zzexj> zzgpl6, zzgpl<zzeya> zzgpl7, zzgpl<zzexw> zzgpl8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzewz) obj);
        hashSet.add(zzewi);
        hashSet.add(zzexg);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeg)).booleanValue()) {
            hashSet.add(zzgpl.zzb());
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeh)).booleanValue()) {
            hashSet.add(zzgpl2.zzb());
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzei)).booleanValue()) {
            hashSet.add(zzgpl3.zzb());
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzej)).booleanValue()) {
            hashSet.add(zzgpl4.zzb());
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzen)).booleanValue()) {
            hashSet.add(zzgpl6.zzb());
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeo)).booleanValue()) {
            hashSet.add(zzgpl7.zzb());
        }
        return new zzevq<>(executor, hashSet);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
