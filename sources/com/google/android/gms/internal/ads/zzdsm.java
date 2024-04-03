package com.google.android.gms.internal.ads;

import buisnessmodels.FilterEngine;
import com.google.android.gms.ads.internal.zzt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final /* synthetic */ class zzdsm implements Callable {
    public final /* synthetic */ zzdso zza;
    public final /* synthetic */ zzfdz zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ JSONObject zzd;

    public /* synthetic */ zzdsm(zzdso zzdso, zzfdz zzfdz, zzfdn zzfdn, JSONObject jSONObject) {
        this.zza = zzdso;
        this.zzb = zzfdz;
        this.zzc = zzfdn;
        this.zzd = jSONObject;
    }

    public final Object call() {
        String str;
        zzfdz zzfdz = this.zzb;
        zzfdn zzfdn = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzdqc zzdqc = new zzdqc();
        zzdqc.zzV(jSONObject.optInt("template_id", -1));
        zzdqc.zzI(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        if (optJSONObject != null) {
            str = optJSONObject.optString("omid_partner_name");
        } else {
            str = null;
        }
        zzdqc.zzS(str);
        zzfef zzfef = zzfdz.zza.zza;
        if (zzfef.zzg.contains(Integer.toString(zzdqc.zzc()))) {
            if (zzdqc.zzc() == 3) {
                if (zzdqc.zzy() == null) {
                    throw new zzelj(1, "No custom template id for custom template ad response.");
                } else if (!zzfef.zzh.contains(zzdqc.zzy())) {
                    throw new zzelj(1, "Unexpected custom template id in the response.");
                }
            }
            zzdqc.zzT(jSONObject.optDouble(FilterEngine.DEEPLINKSORT.RATING, -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzfdn.zzJ) {
                zzt.zzp();
                String zzD = com.google.android.gms.ads.internal.util.zzt.zzD();
                StringBuilder sb2 = new StringBuilder(String.valueOf(zzD).length() + 3 + String.valueOf(optString).length());
                sb2.append(zzD);
                sb2.append(" : ");
                sb2.append(optString);
                optString = sb2.toString();
            }
            zzdqc.zzU("headline", optString);
            zzdqc.zzU("body", jSONObject.optString("body", (String) null));
            zzdqc.zzU("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdqc.zzU("store", jSONObject.optString("store", (String) null));
            zzdqc.zzU(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, (String) null));
            zzdqc.zzU("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdqc;
        }
        int zzc2 = zzdqc.zzc();
        StringBuilder sb3 = new StringBuilder(32);
        sb3.append("Invalid template ID: ");
        sb3.append(zzc2);
        throw new zzelj(1, sb3.toString());
    }
}
