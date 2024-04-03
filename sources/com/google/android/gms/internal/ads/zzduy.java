package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzduy {
    /* access modifiers changed from: private */
    public final zzdus zza = new zzdus((zzdur) null);
    private final zza zzb;
    private final zzcpb zzc;
    private final Context zzd;
    private final zzdyz zze;
    private final zzfio zzf;
    private final Executor zzg;
    private final zzalt zzh;
    private final zzcjf zzi;
    private final zzbsh zzj;
    private final zzehh zzk;
    private final zzfjs zzl;
    private zzfxa<zzcop> zzm;

    public zzduy(zzduv zzduv) {
        this.zzd = zzduv.zzc;
        this.zzg = zzduv.zzg;
        this.zzh = zzduv.zzh;
        this.zzi = zzduv.zzi;
        this.zzb = zzduv.zza;
        this.zzc = zzduv.zzb;
        this.zzj = new zzbsh();
        this.zzk = zzduv.zzf;
        this.zzl = zzduv.zzj;
        this.zze = zzduv.zzd;
        this.zzf = zzduv.zze;
    }

    public final /* synthetic */ zzcop zza(zzcop zzcop) {
        zzcop zzcop2 = zzcop;
        zzcop2.zzaf("/result", this.zzj);
        zzcqc zzP = zzcop.zzP();
        zzdus zzdus = this.zza;
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzd, (zzcgf) null, (zzcde) null);
        zzP.zzL((zzbes) null, zzdus, zzdus, zzdus, zzdus, false, (zzbrw) null, zzb2, (zzcar) null, (zzcgf) null, this.zzk, this.zzl, this.zze, this.zzf, (zzbru) null, (zzdmd) null);
        return zzcop2;
    }

    public final /* synthetic */ zzfxa zzc(String str, JSONObject jSONObject, zzcop zzcop) throws Exception {
        return this.zzj.zzb(zzcop, str, jSONObject);
    }

    public final synchronized zzfxa<JSONObject> zzd(String str, JSONObject jSONObject) {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa == null) {
            return zzfwq.zzi(null);
        }
        return zzfwq.zzn(zzfxa, new zzdul(this, str, jSONObject), this.zzg);
    }

    public final synchronized void zze(zzfdn zzfdn, zzfdq zzfdq) {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa != null) {
            zzfwq.zzr(zzfxa, new zzduq(this, zzfdn, zzfdq), this.zzg);
        }
    }

    public final synchronized void zzf() {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa != null) {
            zzfwq.zzr(zzfxa, new zzdum(this), this.zzg);
            this.zzm = null;
        }
    }

    public final synchronized void zzg(String str, Map<String, ?> map) {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa != null) {
            zzfwq.zzr(zzfxa, new zzdup(this, "sendMessageToNativeJs", map), this.zzg);
        }
    }

    public final synchronized void zzh() {
        Context context = this.zzd;
        zzcjf zzcjf = this.zzi;
        zzblb zzblb = zzblj.zzcp;
        zzfxa<zzcop> zzm2 = zzfwq.zzm(zzfwq.zzl(new zzcoz(context, this.zzh, zzcjf, this.zzb, (String) zzbgq.zzc().zzb(zzblb)), zzcjm.zze), new zzduk(this), this.zzg);
        this.zzm = zzm2;
        zzcjp.zza(zzm2, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbrt<Object> zzbrt) {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa != null) {
            zzfwq.zzr(zzfxa, new zzdun(this, str, zzbrt), this.zzg);
        }
    }

    public final <T> void zzj(WeakReference<T> weakReference, String str, zzbrt<T> zzbrt) {
        zzi(str, new zzdux(this, weakReference, str, zzbrt, (zzduw) null));
    }

    public final synchronized void zzk(String str, zzbrt<Object> zzbrt) {
        zzfxa<zzcop> zzfxa = this.zzm;
        if (zzfxa != null) {
            zzfwq.zzr(zzfxa, new zzduo(this, str, zzbrt), this.zzg);
        }
    }
}
