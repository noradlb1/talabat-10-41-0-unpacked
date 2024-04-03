package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzfai<R extends zzdea<AdT>, AdT extends zzdav> implements zzfbc<R, AdT> {
    private final zzfbc<R, AdT> zza;
    private final zzfbc<R, zzfan<R, AdT>> zzb;
    private final zzfgj<R, AdT> zzc;
    private final String zzd;
    @GuardedBy("this")
    private R zze;
    private final Executor zzf;

    public zzfai(zzfbc<R, AdT> zzfbc, zzfbc<R, zzfan<R, AdT>> zzfbc2, zzfgj<R, AdT> zzfgj, String str, Executor executor) {
        this.zza = zzfbc;
        this.zzb = zzfbc2;
        this.zzc = zzfgj;
        this.zzd = str;
        this.zzf = executor;
    }

    private final zzfxa<AdT> zzg(zzffw<R, AdT> zzffw, zzfbd zzfbd) {
        R r11 = zzffw.zza;
        this.zze = r11;
        if (zzffw.zzc != null) {
            if (r11.zzf() != null) {
                zzffw.zzc.zzo().zzbT(zzffw.zza.zzf());
            }
            return zzfwq.zzi(zzffw.zzc);
        }
        r11.zzb().zzk(zzffw.zzb);
        return ((zzfas) this.zza).zzb(zzfbd, (zzfbb) null, zzffw.zza);
    }

    /* renamed from: zza */
    public final synchronized R zzd() {
        return this.zze;
    }

    public final /* synthetic */ zzfxa zzb(zzfbd zzfbd, zzfah zzfah, zzfbb zzfbb, zzdea zzdea, zzfan zzfan) throws Exception {
        if (zzfan != null) {
            zzfah zzfah2 = new zzfah(zzfah.zza, zzfah.zzb, zzfah.zzc, zzfah.zzd, zzfah.zze, zzfah.zzf, zzfan.zza);
            if (zzfan.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfah2);
                return zzg(zzfan.zzc, zzfbd);
            }
            zzfxa<zzfgg<R, AdT>> zza2 = this.zzc.zza(zzfah2);
            if (zza2 != null) {
                this.zze = null;
                return zzfwq.zzn(zza2, new zzfae(this), this.zzf);
            }
            this.zzc.zze(zzfah2);
            zzfbd = new zzfbd(zzfbd.zzb, zzfan.zzb);
        }
        zzfxa zzb2 = ((zzfas) this.zza).zzb(zzfbd, zzfbb, zzdea);
        this.zze = zzdea;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ zzfxa zzc(zzfbd zzfbd, zzfbb zzfbb, Object obj) {
        return zzf(zzfbd, zzfbb, (zzdea) null);
    }

    public final /* synthetic */ zzfxa zze(zzfgg zzfgg) throws Exception {
        zzfgi<U, A> zzfgi;
        if (zzfgg == null || zzfgg.zza == null || (zzfgi = zzfgg.zzb) == null) {
            throw new zzecd(1, "Empty prefetch");
        }
        zzbbl zza2 = zzbbr.zza();
        zzbbj zza3 = zzbbk.zza();
        zza3.zzd(2);
        zza3.zzb(zzbbo.zzd());
        zza2.zza(zza3);
        zzfgg.zza.zza.zzb().zzc().zzi((zzbbr) zza2.zzah());
        return zzg(zzfgg.zza, ((zzfah) zzfgi).zzb);
    }

    public final synchronized zzfxa<AdT> zzf(zzfbd zzfbd, zzfbb<R> zzfbb, R r11) {
        zzfbd zzfbd2 = zzfbd;
        zzfbb<R> zzfbb2 = zzfbb;
        synchronized (this) {
            zzddz<R> zza2 = zzfbb2.zza(zzfbd2.zzb);
            zza2.zza(new zzfaj(this.zzd));
            R r12 = (zzdea) zza2.zzh();
            r12.zzg();
            r12.zzg();
            zzbfd zzbfd = r12.zzg().zzd;
            if (zzbfd.zzs == null) {
                if (zzbfd.zzx == null) {
                    zzfef zzg = r12.zzg();
                    zzfbb<R> zzfbb3 = zzfbb;
                    zzfbd zzfbd3 = zzfbd;
                    zzfxa<AdT> zzn = zzfwq.zzn(zzfwh.zzw(((zzfao) this.zzb).zzb(zzfbd2, zzfbb2, r12)), new zzfaf(this, zzfbd, new zzfah(zzfbb3, zzfbd3, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, (zzffx) null), zzfbb, r12), this.zzf);
                    return zzn;
                }
            }
            this.zze = r12;
            zzfxa<AdT> zzb2 = ((zzfas) this.zza).zzb(zzfbd2, zzfbb2, r12);
            return zzb2;
        }
    }
}
