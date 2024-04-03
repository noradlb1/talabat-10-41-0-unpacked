package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdea;
import java.util.concurrent.Executor;

final class zzfay<R extends zzdea<? extends zzdav>> {
    private final zzffn zza;
    private final R zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzfax zzd;

    public zzfay(zzffn zzffn, R r11, Executor executor) {
        this.zza = zzffn;
        this.zzb = r11;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzffx zze() {
        zzfef zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final zzfxa<zzfax> zzc() {
        zzfxa<V> zzfxa;
        zzfax zzfax = this.zzd;
        if (zzfax != null) {
            return zzfwq.zzi(zzfax);
        }
        if (!zzbnc.zza.zze().booleanValue()) {
            zzfax zzfax2 = new zzfax((zzcdq) null, zze(), (zzfaw) null);
            this.zzd = zzfax2;
            zzfxa = zzfwq.zzi(zzfax2);
        } else {
            zzfxa = zzfwq.zzf(zzfwq.zzm(zzfwh.zzw(this.zzb.zzb().zze(this.zza.zza())), new zzfav(this), this.zzc), zzeeg.class, new zzfau(this), this.zzc);
        }
        return zzfwq.zzm(zzfxa, zzfat.zza, this.zzc);
    }
}
