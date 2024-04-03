package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class zzbxc {
    public final List<zzbxb> zza;
    public final List<String> zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final List<String> zzf;
    public final String zzg;
    public final String zzh;

    public zzbxc(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        if (zzciz.zzm(2)) {
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString(2);
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject, 2);
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Mediation Response JSON: ".concat(valueOf);
            } else {
                str2 = new String("Mediation Response JSON: ");
            }
            zze.zza(str2);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i11 = -1;
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            try {
                zzbxb zzbxb = new zzbxb(jSONArray.getJSONObject(i12));
                "banner".equalsIgnoreCase(zzbxb.zzv);
                arrayList.add(zzbxb);
                if (i11 < 0) {
                    Iterator<String> it = zzbxb.zzc.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i11 = i12;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        this.zzg = jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzt.zzg();
            this.zzb = zzbxd.zza(optJSONObject, "click_urls");
            zzt.zzg();
            this.zzc = zzbxd.zza(optJSONObject, "imp_urls");
            zzt.zzg();
            this.zzd = zzbxd.zza(optJSONObject, "downloaded_imp_urls");
            zzt.zzg();
            this.zze = zzbxd.zza(optJSONObject, "nofill_urls");
            zzt.zzg();
            this.zzf = zzbxd.zza(optJSONObject, "remote_ping_urls");
            optJSONObject.optBoolean("render_in_browser", false);
            optJSONObject.optLong("refresh", -1);
            zzces zza2 = zzces.zza(optJSONObject.optJSONArray("rewards"));
            if (zza2 == null) {
                this.zzh = null;
            } else {
                this.zzh = zza2.zza;
            }
            optJSONObject.optBoolean("use_displayed_impression", false);
            optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzh = null;
    }
}
