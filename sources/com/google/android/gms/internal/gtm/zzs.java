package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
public final class zzs extends zzi<zzs> {
    private Map<Integer, String> zzuh = new HashMap(4);

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zzuh.entrySet()) {
            String valueOf = String.valueOf(next.getKey());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 9);
            sb2.append("dimension");
            sb2.append(valueOf);
            hashMap.put(sb2.toString(), next.getValue());
        }
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        ((zzs) zzi).zzuh.putAll(this.zzuh);
    }

    public final Map<Integer, String> zzbk() {
        return Collections.unmodifiableMap(this.zzuh);
    }
}
