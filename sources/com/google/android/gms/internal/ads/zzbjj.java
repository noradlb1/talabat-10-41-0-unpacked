package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzbjj implements InitializationStatus {
    public final /* synthetic */ zzbjq zza;

    public /* synthetic */ zzbjj(zzbjq zzbjq) {
        this.zza = zzbjq;
    }

    public final Map getAdapterStatusMap() {
        zzbjq zzbjq = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzbjl(zzbjq));
        return hashMap;
    }
}
