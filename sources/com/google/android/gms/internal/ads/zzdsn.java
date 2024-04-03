package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdsn implements Callable {
    public final /* synthetic */ zzdso zza;
    public final /* synthetic */ zzfxa zzb;
    public final /* synthetic */ zzfxa zzc;
    public final /* synthetic */ zzfxa zzd;
    public final /* synthetic */ zzfxa zze;
    public final /* synthetic */ zzfxa zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ zzfxa zzh;
    public final /* synthetic */ zzfxa zzi;
    public final /* synthetic */ zzfxa zzj;
    public final /* synthetic */ zzfxa zzk;

    public /* synthetic */ zzdsn(zzdso zzdso, zzfxa zzfxa, zzfxa zzfxa2, zzfxa zzfxa3, zzfxa zzfxa4, zzfxa zzfxa5, JSONObject jSONObject, zzfxa zzfxa6, zzfxa zzfxa7, zzfxa zzfxa8, zzfxa zzfxa9) {
        this.zza = zzdso;
        this.zzb = zzfxa;
        this.zzc = zzfxa2;
        this.zzd = zzfxa3;
        this.zze = zzfxa4;
        this.zzf = zzfxa5;
        this.zzg = jSONObject;
        this.zzh = zzfxa6;
        this.zzi = zzfxa7;
        this.zzj = zzfxa8;
        this.zzk = zzfxa9;
    }

    public final Object call() {
        zzfxa zzfxa = this.zzb;
        zzfxa zzfxa2 = this.zzc;
        zzfxa zzfxa3 = this.zzd;
        zzfxa zzfxa4 = this.zze;
        zzfxa zzfxa5 = this.zzf;
        JSONObject jSONObject = this.zzg;
        zzfxa zzfxa6 = this.zzh;
        zzfxa zzfxa7 = this.zzi;
        zzfxa zzfxa8 = this.zzj;
        zzfxa zzfxa9 = this.zzk;
        zzdqc zzdqc = (zzdqc) zzfxa.get();
        zzdqc.zzN((List) zzfxa2.get());
        zzdqc.zzK((zzboi) zzfxa3.get());
        zzdqc.zzO((zzboi) zzfxa4.get());
        zzdqc.zzH((zzboa) zzfxa5.get());
        zzdqc.zzQ(zzdtb.zzj(jSONObject));
        zzdqc.zzJ(zzdtb.zzi(jSONObject));
        zzcop zzcop = (zzcop) zzfxa6.get();
        if (zzcop != null) {
            zzdqc.zzY(zzcop);
            zzdqc.zzX(zzcop.zzH());
            zzdqc.zzW(zzcop.zzs());
        }
        zzcop zzcop2 = (zzcop) zzfxa7.get();
        if (zzcop2 != null) {
            zzdqc.zzM(zzcop2);
            zzdqc.zzZ(zzcop2.zzH());
        }
        zzcop zzcop3 = (zzcop) zzfxa8.get();
        if (zzcop3 != null) {
            zzdqc.zzR(zzcop3);
        }
        for (zzdtf zzdtf : (List) zzfxa9.get()) {
            if (zzdtf.zza != 1) {
                zzdqc.zzL(zzdtf.zzb, zzdtf.zzd);
            } else {
                zzdqc.zzU(zzdtf.zzb, zzdtf.zzc);
            }
        }
        return zzdqc;
    }
}
