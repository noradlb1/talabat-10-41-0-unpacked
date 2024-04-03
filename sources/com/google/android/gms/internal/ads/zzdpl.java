package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzdpl implements zzgpr<zzaxw> {
    private final zzgqe<zzcjf> zza;
    private final zzgqe<String> zzb;

    public zzdpl(zzgqe<zzcjf> zzgqe, zzgqe<String> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcjf zza2 = ((zzcrb) this.zza).zza();
        zzt.zzp();
        return new zzaxw(UUID.randomUUID().toString(), zza2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, new JSONObject(), false, true);
    }
}
