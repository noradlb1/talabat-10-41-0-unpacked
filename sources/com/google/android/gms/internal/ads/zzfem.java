package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

public final /* synthetic */ class zzfem implements zzbrt {
    public final /* synthetic */ zzfjs zza;
    public final /* synthetic */ zzehh zzb;

    public /* synthetic */ zzfem(zzfjs zzfjs, zzehh zzehh) {
        this.zza = zzfjs;
        this.zzb = zzehh;
    }

    public final void zza(Object obj, Map map) {
        zzfjs zzfjs = this.zza;
        zzehh zzehh = this.zzb;
        zzcog zzcog = (zzcog) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzciz.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzcog.zzF().zzag) {
            zzfjs.zzb(str);
        } else {
            zzehh.zzd(new zzehj(zzt.zzA().currentTimeMillis(), ((zzcpm) zzcog).zzR().zzb, str, 2));
        }
    }
}
