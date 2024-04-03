package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzevp implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzevp(List list, Object obj) {
        this.zza = list;
        this.zzb = obj;
    }

    public final Object call() {
        List<zzfxa> list = this.zza;
        Object obj = this.zzb;
        for (zzfxa zzfxa : list) {
            zzevm zzevm = (zzevm) zzfxa.get();
            if (zzevm != null) {
                zzevm.zza(obj);
            }
        }
        return obj;
    }
}
