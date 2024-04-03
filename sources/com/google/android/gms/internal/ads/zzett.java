package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzt;
import java.util.Set;

public final class zzett implements zzevn<zzetu> {
    private final zzfxb zza;
    private final Context zzb;
    private final Set<String> zzc;

    public zzett(zzfxb zzfxb, Context context, Set<String> set) {
        this.zza = zzfxb;
        this.zzb = context;
        this.zzc = set;
    }

    public final /* synthetic */ zzetu zza() throws Exception {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
            Set<String> set = this.zzc;
            if (set.contains("rewarded") || set.contains("interstitial") || set.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE) || set.contains("banner")) {
                return new zzetu(zzt.zzh().zzc(this.zzb));
            }
        }
        return new zzetu((String) null);
    }

    public final zzfxa<zzetu> zzb() {
        return this.zza.zzb(new zzets(this));
    }
}
