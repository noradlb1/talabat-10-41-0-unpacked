package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import java.util.concurrent.Executor;

public final class zzfad<R extends zzdea<AdT>, AdT extends zzdav> implements zzfbc<R, zzffw<R, AdT>> {
    private R zza;
    private final Executor zzb = zzfxh.zzb();

    public final R zza() {
        return this.zza;
    }

    public final zzfxa<zzffw<R, AdT>> zzb(zzfbd zzfbd, zzfbb<R> zzfbb, @Nullable R r11) {
        zzddz<R> zza2 = zzfbb.zza(zzfbd.zzb);
        zza2.zzb(new zzfbi(true));
        R r12 = (zzdea) zza2.zzh();
        this.zza = r12;
        zzdby zzb2 = r12.zzb();
        zzffw zzffw = new zzffw();
        return zzfwq.zzm(zzfwq.zzn(zzfwh.zzw(zzb2.zzi()), new zzfac(this, zzffw, zzb2), this.zzb), new zzfab(zzffw), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfxa zzc(zzfbd zzfbd, zzfbb zzfbb, @Nullable Object obj) {
        return zzb(zzfbd, zzfbb, (zzdea) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
