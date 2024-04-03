package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzdxb {
    private final Map<String, Map<String, JSONObject>> zza = new ConcurrentHashMap();
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;

    public zzdxb(Executor executor) {
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzg */
    public final synchronized void zzf() {
        JSONObject jSONObject;
        Map map;
        this.zzd = true;
        zzcif zzg = zzt.zzo().zzh().zzg();
        if (zzg != null) {
            JSONObject zzf = zzg.zzf();
            if (zzf != null) {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcC)).booleanValue()) {
                    jSONObject = zzf.optJSONObject("common_settings");
                } else {
                    jSONObject = null;
                }
                this.zzb = jSONObject;
                this.zze = zzf.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzf.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString("format");
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zza.containsKey(optString2)) {
                                    map = this.zza.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zza.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    @CheckForNull
    public final JSONObject zza() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzcC)).booleanValue()) {
            return null;
        }
        return this.zzb;
    }

    @CheckForNull
    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzcB)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzf();
        }
        Map map = this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza2 = zzdxd.zza(this.zze, str, str2);
        if (zza2 == null) {
            return null;
        }
        return (JSONObject) map.get(zza2);
    }

    public final void zzc() {
        zzt.zzo().zzh().zzo(new zzdwz(this));
        this.zzc.execute(new zzdxa(this));
    }

    public final /* synthetic */ void zze() {
        this.zzc.execute(new zzdwy(this));
    }
}
