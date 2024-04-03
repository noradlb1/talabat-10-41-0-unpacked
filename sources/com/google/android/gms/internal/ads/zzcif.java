package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcif {
    private final List<String> zza = new ArrayList();
    private final List<String> zzb = new ArrayList();
    private final Map<String, zzbxc> zzc = new HashMap();
    private String zzd;
    private String zze;
    private long zzf;
    private JSONObject zzg;
    private boolean zzh = false;
    private final List<String> zzi = new ArrayList();
    private boolean zzj = false;

    public zzcif(String str, long j11) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject2;
        this.zze = str;
        this.zzf = j11;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzg = jSONObject;
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzh = false;
                    zzciz.zzj("App settings could not be fetched successfully.");
                    return;
                }
                this.zzh = true;
                this.zzd = this.zzg.optString("app_id");
                JSONArray optJSONArray2 = this.zzg.optJSONArray("ad_unit_id_settings");
                if (optJSONArray2 != null) {
                    for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i11);
                        String optString = jSONObject2.optString("format");
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzb.add(optString2);
                                } else if (("rewarded".equalsIgnoreCase(optString) || "rewarded_interstitial".equals(optString)) && (optJSONObject2 = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzc.put(optString2, new zzbxc(optJSONObject2));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = this.zzg.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray3 != null) {
                    for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                        this.zza.add(optJSONArray3.optString(i12));
                    }
                }
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfm)).booleanValue()) {
                    JSONObject optJSONObject3 = this.zzg.optJSONObject("common_settings");
                    if (!(optJSONObject3 == null || (optJSONArray = optJSONObject3.optJSONArray("loeid")) == null)) {
                        for (int i13 = 0; i13 < optJSONArray.length(); i13++) {
                            this.zzi.add(optJSONArray.get(i13).toString());
                        }
                    }
                }
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeK)).booleanValue() && (optJSONObject = this.zzg.optJSONObject("common_settings")) != null) {
                    this.zzj = optJSONObject.optBoolean("is_prefetching_enabled", false);
                }
            } catch (JSONException e11) {
                zzciz.zzk("Exception occurred while processing app setting json", e11);
                zzt.zzo().zzs(e11, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final List<String> zzd() {
        return this.zzi;
    }

    public final Map<String, zzbxc> zze() {
        return this.zzc;
    }

    public final JSONObject zzf() {
        return this.zzg;
    }

    public final void zzg(long j11) {
        this.zzf = j11;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzh;
    }
}
