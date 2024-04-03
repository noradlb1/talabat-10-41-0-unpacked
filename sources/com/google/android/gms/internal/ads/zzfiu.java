package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzfiu {
    private final Clock zza;
    private final Map<String, List<String>> zzb = new HashMap();
    private final Map<String, Long> zzc = new HashMap();

    public zzfiu(Clock clock) {
        this.zza = clock;
    }

    private final void zzd(String str, String str2) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, new ArrayList());
        }
        this.zzb.get(str).add(str2);
    }

    public final List<zzfit> zza() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.zzb.entrySet()) {
            int i11 = 0;
            if (((List) next.getValue()).size() > 1) {
                for (String zzfit : (List) next.getValue()) {
                    String str = (String) next.getKey();
                    i11++;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
                    sb2.append(str);
                    sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                    sb2.append(i11);
                    arrayList.add(new zzfit(sb2.toString(), zzfit));
                }
            } else {
                arrayList.add(new zzfit((String) next.getKey(), (String) ((List) next.getValue()).get(0)));
            }
        }
        return arrayList;
    }

    public final void zzb(String str) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb2 = new StringBuilder(20);
            sb2.append(elapsedRealtime - longValue);
            zzd(str, sb2.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }

    public final void zzc(String str, String str2) {
        if (this.zzc.containsKey(str)) {
            long elapsedRealtime = this.zza.elapsedRealtime();
            long longValue = this.zzc.remove(str).longValue();
            StringBuilder sb2 = new StringBuilder(str2.length() + 20);
            sb2.append(str2);
            sb2.append(elapsedRealtime - longValue);
            zzd(str, sb2.toString());
            return;
        }
        this.zzc.put(str, Long.valueOf(this.zza.elapsedRealtime()));
    }
}
