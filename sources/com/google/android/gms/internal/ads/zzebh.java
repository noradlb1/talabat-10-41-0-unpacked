package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzebh implements zzdeu, zzdhm, zzdgj {
    private final zzebt zza;
    private final String zzb;
    private int zzc = 0;
    private zzebg zzd = zzebg.AD_REQUESTED;
    private zzdek zze;
    private zzbew zzf;

    public zzebh(zzebt zzebt, zzfef zzfef) {
        this.zza = zzebt;
        this.zzb = zzfef.zzf;
    }

    private static JSONObject zzf(zzbew zzbew) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("errorDomain", (Object) zzbew.zzc);
        jSONObject2.put("errorCode", zzbew.zza);
        jSONObject2.put("errorDescription", (Object) zzbew.zzb);
        zzbew zzbew2 = zzbew.zzd;
        if (zzbew2 == null) {
            jSONObject = null;
        } else {
            jSONObject = zzf(zzbew2);
        }
        jSONObject2.put("underlyingError", (Object) jSONObject);
        return jSONObject2;
    }

    private static JSONObject zzg(zzdek zzdek) throws JSONException {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", (Object) zzdek.zze());
        jSONObject2.put("responseSecsSinceEpoch", zzdek.zzc());
        jSONObject2.put("responseId", (Object) zzdek.zzf());
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgR)).booleanValue()) {
            String zzd2 = zzdek.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                String valueOf = String.valueOf(zzd2);
                if (valueOf.length() != 0) {
                    str = "Bidding data: ".concat(valueOf);
                } else {
                    str = new String("Bidding data: ");
                }
                zzciz.zze(str);
                jSONObject2.put("biddingData", (Object) new JSONObject(zzd2));
            }
        }
        JSONArray jSONArray = new JSONArray();
        List<zzbfm> zzg = zzdek.zzg();
        if (zzg != null) {
            for (zzbfm next : zzg) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("adapterClassName", (Object) next.zza);
                jSONObject3.put("latencyMillis", next.zzb);
                zzbew zzbew = next.zzc;
                if (zzbew == null) {
                    jSONObject = null;
                } else {
                    jSONObject = zzf(zzbew);
                }
                jSONObject3.put("error", (Object) jSONObject);
                jSONArray.put((Object) jSONObject3);
            }
        }
        jSONObject2.put("adNetworks", (Object) jSONArray);
        return jSONObject2;
    }

    public final void zza(zzbew zzbew) {
        this.zzd = zzebg.AD_LOAD_FAILED;
        this.zzf = zzbew;
    }

    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", (Object) this.zzd);
        jSONObject2.put("format", (Object) zzfdn.zza(this.zzc));
        zzdek zzdek = this.zze;
        if (zzdek != null) {
            jSONObject = zzg(zzdek);
        } else {
            zzbew zzbew = this.zzf;
            JSONObject jSONObject3 = null;
            if (!(zzbew == null || (iBinder = zzbew.zze) == null)) {
                zzdek zzdek2 = (zzdek) iBinder;
                jSONObject3 = zzg(zzdek2);
                List<zzbfm> zzg = zzdek2.zzg();
                if (zzg != null && zzg.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put((Object) zzf(this.zzf));
                    jSONObject3.put("errors", (Object) jSONArray);
                }
            }
            jSONObject = jSONObject3;
        }
        jSONObject2.put("responseInfo", (Object) jSONObject);
        return jSONObject2;
    }

    public final void zzbP(zzdav zzdav) {
        this.zze = zzdav.zzl();
        this.zzd = zzebg.AD_LOADED;
    }

    public final boolean zzc() {
        return this.zzd != zzebg.AD_REQUESTED;
    }

    public final void zzd(zzcdq zzcdq) {
        this.zza.zze(this.zzb, this);
    }

    public final void zze(zzfdz zzfdz) {
        if (!zzfdz.zzb.zza.isEmpty()) {
            this.zzc = zzfdz.zzb.zza.get(0).zzb;
        }
    }
}
