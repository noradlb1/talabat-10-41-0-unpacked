package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class zzefy implements zzfif {
    private final Map<zzfhy, String> zza = new HashMap();
    private final Map<zzfhy, String> zzb = new HashMap();
    private final zzfin zzc;

    public zzefy(Set<zzefx> set, zzfin zzfin) {
        this.zzc = zzfin;
        for (zzefx next : set) {
            this.zza.put(next.zzb, next.zza);
            this.zzb.put(next.zzc, next.zza);
        }
    }

    public final void zzb(zzfhy zzfhy, String str, Throwable th2) {
        String str2;
        String str3;
        zzfin zzfin = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfin.zze(str2, "f.");
        if (this.zzb.containsKey(zzfhy)) {
            zzfin zzfin2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzfhy));
            if (valueOf2.length() != 0) {
                str3 = "label.".concat(valueOf2);
            } else {
                str3 = new String("label.");
            }
            zzfin2.zze(str3, "f.");
        }
    }

    public final void zzbN(zzfhy zzfhy, String str) {
    }

    public final void zzbO(zzfhy zzfhy, String str) {
        String str2;
        String str3;
        zzfin zzfin = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfin.zze(str2, "s.");
        if (this.zzb.containsKey(zzfhy)) {
            zzfin zzfin2 = this.zzc;
            String valueOf2 = String.valueOf(this.zzb.get(zzfhy));
            if (valueOf2.length() != 0) {
                str3 = "label.".concat(valueOf2);
            } else {
                str3 = new String("label.");
            }
            zzfin2.zze(str3, "s.");
        }
    }

    public final void zzc(zzfhy zzfhy, String str) {
        String str2;
        String str3;
        zzfin zzfin = this.zzc;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "task.".concat(valueOf);
        } else {
            str2 = new String("task.");
        }
        zzfin.zzd(str2);
        if (this.zza.containsKey(zzfhy)) {
            zzfin zzfin2 = this.zzc;
            String valueOf2 = String.valueOf(this.zza.get(zzfhy));
            if (valueOf2.length() != 0) {
                str3 = "label.".concat(valueOf2);
            } else {
                str3 = new String("label.");
            }
            zzfin2.zzd(str3);
        }
    }
}
