package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import java.util.concurrent.Executor;

public final class zzfao<R extends zzdea<AdT>, AdT extends zzdav> implements zzfbc<R, zzfan<R, AdT>> {
    private final zzffn zza;
    private final Executor zzb;
    private final zzfwm<Void> zzc = new zzfam(this);

    public zzfao(zzffn zzffn, Executor executor) {
        this.zza = zzffn;
        this.zzb = executor;
    }

    public final /* synthetic */ zzfxa zza(zzdea zzdea, zzfax zzfax) throws Exception {
        zzffw<?, ?> zzffw;
        zzffx zzffx = zzfax.zzb;
        zzcdq zzcdq = zzfax.zza;
        if (zzffx != null) {
            zzffw = this.zza.zzb(zzffx);
        } else {
            zzffw = null;
        }
        if (zzffx == null) {
            return zzfwq.zzi(null);
        }
        if (!(zzffw == null || zzcdq == null)) {
            zzfwq.zzr(zzdea.zzb().zzg(zzcdq), this.zzc, this.zzb);
        }
        return zzfwq.zzi(new zzfan(zzffx, zzcdq, zzffw));
    }

    public final zzfxa<zzfan<R, AdT>> zzb(zzfbd zzfbd, zzfbb<R> zzfbb, R r11) {
        return zzfwq.zzf(zzfwq.zzn(zzfwh.zzw(new zzfay(this.zza, r11, this.zzb).zzc()), new zzfak(this, r11), this.zzb), Exception.class, new zzfal(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfxa zzc(zzfbd zzfbd, zzfbb zzfbb, Object obj) {
        return zzb(zzfbd, zzfbb, (zzdea) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
