package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import j$.util.DesugarCollections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

public final class zzb {
    /* access modifiers changed from: private */
    public final int zza = ((Integer) zzbgq.zzc().zzb(zzblj.zzfq)).intValue();
    private final long zzb = ((Long) zzbgq.zzc().zzb(zzblj.zzfr)).longValue();
    private final Map<String, Pair<Long, String>> zzc = DesugarCollections.synchronizedMap(new zza(this));

    private final void zze() {
        long currentTimeMillis = zzt.zzA().currentTimeMillis();
        try {
            Iterator<Map.Entry<String, Pair<Long, String>>> it = this.zzc.entrySet().iterator();
            while (it.hasNext() && currentTimeMillis - ((Long) ((Pair) it.next().getValue()).first).longValue() > this.zzb) {
                it.remove();
            }
        } catch (ConcurrentModificationException e11) {
            zzt.zzo().zzs(e11, "QueryJsonMap.removeExpiredEntries");
        }
    }

    @Nullable
    public final synchronized String zzb(String str) {
        Pair pair = this.zzc.get(str);
        if (pair == null) {
            return null;
        }
        String str2 = (String) pair.second;
        this.zzc.remove(str);
        return str2;
    }

    public final synchronized void zzc(String str, String str2) {
        this.zzc.put(str, new Pair(Long.valueOf(zzt.zzA().currentTimeMillis()), str2));
        zze();
    }

    public final synchronized void zzd(String str) {
        this.zzc.remove(str);
    }
}
