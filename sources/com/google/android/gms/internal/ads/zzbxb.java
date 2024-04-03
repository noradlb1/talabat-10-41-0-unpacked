package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@ParametersAreNonnullByDefault
public final class zzbxb {
    public final String zza;
    public final String zzb;
    public final List<String> zzc;
    public final String zzd;
    public final String zze;
    public final List<String> zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final List<String> zzl;
    public final List<String> zzm;
    public final List<String> zzn;
    public final String zzo;
    public final String zzp;
    @Nullable
    public final String zzq;
    @Nullable
    public final String zzr;
    public final String zzs;
    @Nullable
    public final List<String> zzt;
    public final String zzu;
    @Nullable
    public final String zzv;

    public zzbxb(JSONObject jSONObject) throws JSONException {
        List<String> list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        this.zzb = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(jSONArray.getString(i11));
        }
        this.zzc = Collections.unmodifiableList(arrayList);
        this.zzd = jSONObject.optString("allocation_id", (String) null);
        zzt.zzg();
        this.zzf = zzbxd.zza(jSONObject, "clickurl");
        zzt.zzg();
        this.zzg = zzbxd.zza(jSONObject, "imp_urls");
        zzt.zzg();
        this.zzh = zzbxd.zza(jSONObject, "downloaded_imp_urls");
        zzt.zzg();
        this.zzj = zzbxd.zza(jSONObject, "fill_urls");
        zzt.zzg();
        this.zzl = zzbxd.zza(jSONObject, "video_start_urls");
        zzt.zzg();
        this.zzn = zzbxd.zza(jSONObject, "video_complete_urls");
        zzt.zzg();
        this.zzm = zzbxd.zza(jSONObject, "video_reward_urls");
        this.zzo = jSONObject.optString("transaction_id");
        this.zzp = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzt.zzg();
            list = zzbxd.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzi = list;
        if (optJSONObject != null) {
            str = JSONObjectInstrumentation.toString(optJSONObject);
        } else {
            str = null;
        }
        this.zza = str;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            str2 = JSONObjectInstrumentation.toString(optJSONObject2);
        } else {
            str2 = null;
        }
        this.zzk = str2;
        if (optJSONObject2 != null) {
            str3 = optJSONObject2.optString("class_name");
        } else {
            str3 = null;
        }
        this.zze = str3;
        this.zzq = jSONObject.optString("html_template", (String) null);
        this.zzr = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        if (optJSONObject3 != null) {
            str4 = JSONObjectInstrumentation.toString(optJSONObject3);
        } else {
            str4 = null;
        }
        this.zzs = str4;
        zzt.zzg();
        this.zzt = zzbxd.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject4 != null) {
            str5 = JSONObjectInstrumentation.toString(optJSONObject4);
        } else {
            str5 = null;
        }
        this.zzu = str5;
        this.zzv = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, (String) null);
        jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
