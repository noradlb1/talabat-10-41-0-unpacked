package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import java.util.ArrayDeque;
import javax.annotation.concurrent.GuardedBy;

public final class zzfgj<R extends zzdea<AdT>, AdT extends zzdav> {
    private final zzffn zza;
    private final zzfgh<R, AdT> zzb;
    private final zzffj zzc;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public final ArrayDeque<zzfgi<R, AdT>> zzd;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzfgp<R, AdT> zze;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzf = 1;

    public zzfgj(zzffn zzffn, zzffj zzffj, zzfgh<R, AdT> zzfgh) {
        this.zza = zzffn;
        this.zzc = zzffj;
        this.zzb = zzfgh;
        this.zzd = new ArrayDeque<>();
        zzffj.zzb(new zzfge(this));
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeK)).booleanValue()) {
            if (!zzt.zzo().zzh().zzg().zzh()) {
                this.zzd.clear();
                return;
            }
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzfgi pollFirst = this.zzd.pollFirst();
                if (pollFirst == null || (pollFirst.zza() != null && this.zza.zze(pollFirst.zza()))) {
                    zzfgp<R, AdT> zzfgp = new zzfgp<>(this.zza, this.zzb, pollFirst);
                    this.zze = zzfgp;
                    zzfgp.zzd(new zzfgf(this, pollFirst));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized zzfxa<zzfgg<R, AdT>> zza(zzfgi<R, AdT> zzfgi) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfgi);
    }

    public final synchronized void zze(zzfgi<R, AdT> zzfgi) {
        this.zzd.add(zzfgi);
    }

    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
