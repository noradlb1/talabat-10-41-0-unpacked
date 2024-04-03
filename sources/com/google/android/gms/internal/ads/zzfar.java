package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdea;
import javax.annotation.concurrent.GuardedBy;

public final class zzfar<RequestComponentT extends zzdea<AdT>, AdT> implements zzfbc<RequestComponentT, AdT> {
    @GuardedBy("this")
    @Nullable
    private RequestComponentT zza;

    /* renamed from: zza */
    public final synchronized RequestComponentT zzd() {
        return this.zza;
    }

    public final synchronized zzfxa<AdT> zzb(zzfbd zzfbd, zzfbb<RequestComponentT> zzfbb, @Nullable RequestComponentT requestcomponentt) {
        zzdby zzb;
        if (requestcomponentt != null) {
            this.zza = requestcomponentt;
        } else {
            this.zza = (zzdea) zzfbb.zza(zzfbd.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzh(zzb.zzi());
    }

    public final /* bridge */ /* synthetic */ zzfxa zzc(zzfbd zzfbd, zzfbb zzfbb, @Nullable Object obj) {
        return zzb(zzfbd, zzfbb, (zzdea) null);
    }
}
