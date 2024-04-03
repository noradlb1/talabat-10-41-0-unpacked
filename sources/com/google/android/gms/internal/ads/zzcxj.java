package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzcxj implements zzgpr<zzaxw> {
    private final zzgqe<zzfdn> zza;
    private final zzgqe<zzcjf> zzb;
    private final zzgqe<JSONObject> zzc;
    private final zzgqe<String> zzd;

    public zzcxj(zzgqe<zzfdn> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<JSONObject> zzgqe3, zzgqe<String> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        ((zzdbl) this.zza).zza();
        String zzb2 = this.zzd.zzb();
        boolean equals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zzb2);
        zzt.zzp();
        return new zzaxw(UUID.randomUUID().toString(), ((zzcrb) this.zzb).zza(), zzb2, this.zzc.zzb(), false, equals);
    }
}
