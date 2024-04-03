package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdtt {
    private final zzfef zza;
    private final Executor zzb;
    private final zzdwj zzc;
    private final zzdve zzd;
    private final Context zze;
    private final zzdyz zzf;
    private final zzfio zzg;
    private final zzfjs zzh;
    private final zzehh zzi;

    public zzdtt(zzfef zzfef, Executor executor, zzdwj zzdwj, Context context, zzdyz zzdyz, zzfio zzfio, zzfjs zzfjs, zzehh zzehh, zzdve zzdve) {
        this.zza = zzfef;
        this.zzb = executor;
        this.zzc = zzdwj;
        this.zze = context;
        this.zzf = zzdyz;
        this.zzg = zzfio;
        this.zzh = zzfjs;
        this.zzi = zzehh;
        this.zzd = zzdve;
    }

    private final void zzh(zzcop zzcop) {
        zzi(zzcop);
        zzcop.zzaf("/video", zzbrs.zzl);
        zzcop.zzaf("/videoMeta", zzbrs.zzm);
        zzcop.zzaf("/precache", new zzcng());
        zzcop.zzaf("/delayPageLoaded", zzbrs.zzp);
        zzcop.zzaf("/instrument", zzbrs.zzn);
        zzcop.zzaf("/log", zzbrs.zzg);
        zzcop.zzaf("/click", zzbrs.zza((zzdmd) null));
        if (this.zza.zzb != null) {
            zzcop.zzP().zzC(true);
            zzcop.zzaf("/open", new zzbse((zzb) null, (zzcak) null, (zzehh) null, (zzdyz) null, (zzfio) null));
        } else {
            zzcop.zzP().zzC(false);
        }
        if (zzt.zzn().zzu(zzcop.getContext())) {
            zzcop.zzaf("/logScionEvent", new zzbrz(zzcop.getContext()));
        }
    }

    private static final void zzi(zzcop zzcop) {
        zzcop.zzaf("/videoClicked", zzbrs.zzh);
        zzcop.zzP().zzE(true);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcr)).booleanValue()) {
            zzcop.zzaf("/getNativeAdViewSignals", zzbrs.zzs);
        }
        zzcop.zzaf("/getNativeClickMeta", zzbrs.zzt);
    }

    public final zzfxa<zzcop> zza(JSONObject jSONObject) {
        return zzfwq.zzn(zzfwq.zzn(zzfwq.zzi(null), new zzdtl(this), this.zzb), new zzdtn(this, jSONObject), this.zzb);
    }

    public final zzfxa<zzcop> zzb(String str, String str2, zzfdn zzfdn, zzfdq zzfdq, zzbfi zzbfi) {
        return zzfwq.zzn(zzfwq.zzi(null), new zzdtm(this, zzbfi, zzfdn, zzfdq, str, str2), this.zzb);
    }

    public final /* synthetic */ zzfxa zzc(JSONObject jSONObject, zzcop zzcop) throws Exception {
        zzcjq zza2 = zzcjq.zza(zzcop);
        if (this.zza.zzb != null) {
            zzcop.zzai(zzcqe.zzd());
        } else {
            zzcop.zzai(zzcqe.zze());
        }
        zzcop.zzP().zzz(new zzdti(this, zzcop, zza2));
        zzcop.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    public final /* synthetic */ zzfxa zzd(zzbfi zzbfi, zzfdn zzfdn, zzfdq zzfdq, String str, String str2, Object obj) throws Exception {
        zzcop zza2 = this.zzc.zza(zzbfi, zzfdn, zzfdq);
        zzcjq zza3 = zzcjq.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzai(zzcqe.zzd());
        } else {
            zzdvb zzb2 = this.zzd.zzb();
            zzdvb zzdvb = zzb2;
            zzcqc zzP = zza2.zzP();
            zzb zzb3 = r3;
            zzb zzb4 = new zzb(this.zze, (zzcgf) null, (zzcde) null);
            zzP.zzL(zzb2, zzdvb, zzb2, zzb2, zzb2, false, (zzbrw) null, zzb3, (zzcar) null, (zzcgf) null, this.zzi, this.zzh, this.zzf, this.zzg, (zzbru) null, zzb2);
            zzi(zza2);
        }
        zza2.zzP().zzz(new zzdtj(this, zza2, zza3));
        zza2.zzad(str, str2, (String) null);
        return zza3;
    }

    public final /* synthetic */ zzfxa zze(Object obj) throws Exception {
        zzcop zza2 = this.zzc.zza(zzbfi.zzc(), (zzfdn) null, (zzfdq) null);
        zzcjq zza3 = zzcjq.zza(zza2);
        zzh(zza2);
        zza2.zzP().zzF(new zzdtk(zza3));
        zza2.loadUrl((String) zzbgq.zzc().zzb(zzblj.zzcq));
        return zza3;
    }

    public final /* synthetic */ void zzf(zzcop zzcop, zzcjq zzcjq, boolean z11) {
        if (!(this.zza.zza == null || zzcop.zzs() == null)) {
            zzcop.zzs().zzs(this.zza.zza);
        }
        zzcjq.zzb();
    }

    public final /* synthetic */ void zzg(zzcop zzcop, zzcjq zzcjq, boolean z11) {
        if (z11) {
            if (!(this.zza.zza == null || zzcop.zzs() == null)) {
                zzcop.zzs().zzs(this.zza.zza);
            }
            zzcjq.zzb();
            return;
        }
        zzcjq.zze(new zzelj(1, "Html video Web View failed to load."));
    }
}
