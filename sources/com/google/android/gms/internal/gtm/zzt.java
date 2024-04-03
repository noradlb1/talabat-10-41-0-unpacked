package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
public final class zzt extends zzi<zzt> {
    private Map<Integer, Double> zzui = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zzui.entrySet()) {
            String valueOf = String.valueOf(next.getKey());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 6);
            sb2.append("metric");
            sb2.append(valueOf);
            hashMap.put(sb2.toString(), next.getValue());
        }
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        ((zzt) zzi).zzui.putAll(this.zzui);
    }

    public final Map<Integer, Double> zzbl() {
        return Collections.unmodifiableMap(this.zzui);
    }
}
