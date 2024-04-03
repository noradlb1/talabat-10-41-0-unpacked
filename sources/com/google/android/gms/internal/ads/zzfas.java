package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdea;
import javax.annotation.concurrent.GuardedBy;

public final class zzfas<RequestComponentT extends zzdea<AdT>, AdT> implements zzfbc<RequestComponentT, AdT> {
    private final zzfbc<RequestComponentT, AdT> zza;
    @GuardedBy("this")
    @Nullable
    private RequestComponentT zzb;

    public zzfas(zzfbc<RequestComponentT, AdT> zzfbc) {
        this.zza = zzfbc;
    }

    /* renamed from: zza */
    public final synchronized RequestComponentT zzd() {
        return this.zzb;
    }

    public final synchronized zzfxa<AdT> zzb(zzfbd zzfbd, zzfbb<RequestComponentT> zzfbb, @Nullable RequestComponentT requestcomponentt) {
        this.zzb = requestcomponentt;
        if (zzfbd.zza != null) {
            zzdby zzb2 = requestcomponentt.zzb();
            return zzb2.zzh(zzb2.zzj(zzfwq.zzi(zzfbd.zza)));
        }
        return ((zzfar) this.zza).zzb(zzfbd, zzfbb, requestcomponentt);
    }

    public final /* bridge */ /* synthetic */ zzfxa zzc(zzfbd zzfbd, zzfbb zzfbb, @Nullable Object obj) {
        return zzb(zzfbd, zzfbb, (zzdea) null);
    }
}
