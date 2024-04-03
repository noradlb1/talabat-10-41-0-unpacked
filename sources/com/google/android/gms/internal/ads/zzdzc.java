package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzdzc implements zzfif {
    private final Map<zzfhy, Long> zza = new HashMap();
    private final zzdyv zzb;
    private final Clock zzc;
    private final Map<zzfhy, zzdzb> zzd = new HashMap();

    public zzdzc(zzdyv zzdyv, Set<zzdzb> set, Clock clock) {
        this.zzb = zzdyv;
        for (zzdzb next : set) {
            this.zzd.put(next.zzc, next);
        }
        this.zzc = clock;
    }

    private final void zze(zzfhy zzfhy, boolean z11) {
        String str;
        String str2;
        String str3;
        zzfhy zzb2 = this.zzd.get(zzfhy).zzb;
        if (true != z11) {
            str = "f.";
        } else {
            str = "s.";
        }
        if (this.zza.containsKey(zzb2)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzb2).longValue();
            Map<String, String> zza2 = this.zzb.zza();
            String zzc2 = this.zzd.get(zzfhy).zza;
            if (zzc2.length() != 0) {
                str2 = "label.".concat(zzc2);
            } else {
                str2 = new String("label.");
            }
            String valueOf = String.valueOf(Long.toString(elapsedRealtime));
            if (valueOf.length() != 0) {
                str3 = str.concat(valueOf);
            } else {
                str3 = new String(str);
            }
            zza2.put(str2, str3);
        }
    }

    public final void zzb(zzfhy zzfhy, String str, Throwable th2) {
        String str2;
        String str3;
        if (this.zza.containsKey(zzfhy)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzfhy).longValue();
            Map<String, String> zza2 = this.zzb.zza();
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "task.".concat(valueOf);
            } else {
                str2 = new String("task.");
            }
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            if (valueOf2.length() != 0) {
                str3 = "f.".concat(valueOf2);
            } else {
                str3 = new String("f.");
            }
            zza2.put(str2, str3);
        }
        if (this.zzd.containsKey(zzfhy)) {
            zze(zzfhy, false);
        }
    }

    public final void zzbN(zzfhy zzfhy, String str) {
    }

    public final void zzbO(zzfhy zzfhy, String str) {
        String str2;
        String str3;
        if (this.zza.containsKey(zzfhy)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - this.zza.get(zzfhy).longValue();
            Map<String, String> zza2 = this.zzb.zza();
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "task.".concat(valueOf);
            } else {
                str2 = new String("task.");
            }
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            if (valueOf2.length() != 0) {
                str3 = "s.".concat(valueOf2);
            } else {
                str3 = new String("s.");
            }
            zza2.put(str2, str3);
        }
        if (this.zzd.containsKey(zzfhy)) {
            zze(zzfhy, true);
        }
    }

    public final void zzc(zzfhy zzfhy, String str) {
        this.zza.put(zzfhy, Long.valueOf(this.zzc.elapsedRealtime()));
    }
}
