package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class zzedm {
    private final zzcqm zza;
    private final Context zzb;
    private final zzcjf zzc;
    private final zzfef zzd;
    private final Executor zze;
    private final String zzf;
    /* access modifiers changed from: private */
    public final zzdhk zzg;
    /* access modifiers changed from: private */
    public final zzdho zzh;

    public zzedm(zzcqm zzcqm, Context context, zzcjf zzcjf, zzfef zzfef, Executor executor, String str, zzdhk zzdhk, zzdho zzdho) {
        this.zza = zzcqm;
        this.zzb = context;
        this.zzc = zzcjf;
        this.zzd = zzfef;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzdhk;
        this.zzh = zzdho;
    }

    private final zzfxa<zzfdz> zze(String str, String str2) {
        zzbwh zza2 = zzt.zzf().zza(this.zzb, this.zzc);
        zzbwb<JSONObject> zzbwb = zzbwe.zza;
        zzfxa<zzfdz> zzn = zzfwq.zzn(zzfwq.zzn(zzfwq.zzn(zzfwq.zzi(""), new zzedk(this, str, str2), this.zze), new zzedi(zza2.zza("google.afma.response.normalize", zzbwb, zzbwb)), this.zze), new zzedj(this), this.zze);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            zzfwq.zzr(zzn, new zzedl(this), zzcjm.zzf);
        }
        return zzn;
    }

    private final String zzf(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", (Object) new JSONArray().put((Object) this.zzf));
            }
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            zzciz.zzj("Failed to update the ad types for rendering. ".concat(e11.toString()));
            return str;
        }
    }

    private static final String zzg(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final zzfxa<zzfdz> zzc() {
        String str = this.zzd.zzd.zzx;
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfp)).booleanValue()) {
                String zzg2 = zzg(str);
                if (TextUtils.isEmpty(zzg2)) {
                    if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
                        this.zzh.zzbM(true);
                    }
                    return zzfwq.zzh(new zzelj(15, "Invalid ad string."));
                }
                String zzb2 = this.zza.zzp().zzb(zzg2);
                if (!TextUtils.isEmpty(zzb2)) {
                    return zze(str, zzf(zzb2));
                }
            }
        }
        zzbeu zzbeu = this.zzd.zzd.zzs;
        if (zzbeu != null) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfn)).booleanValue()) {
                String zzg3 = zzg(zzbeu.zza);
                String zzg4 = zzg(zzbeu.zzb);
                if (!TextUtils.isEmpty(zzg4) && zzg3.equals(zzg4)) {
                    this.zza.zzp().zzd(zzg3);
                }
            }
            return zze(zzbeu.zza, zzf(zzbeu.zzb));
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            this.zzh.zzbM(true);
        }
        return zzfwq.zzh(new zzelj(14, "Mismatch request IDs."));
    }

    public final /* synthetic */ zzfxa zzd(JSONObject jSONObject) throws Exception {
        String str;
        zzfdw zzfdw = new zzfdw(this.zzd);
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        return zzfwq.zzi(new zzfdz(zzfdw, zzfdy.zza(new StringReader(str))));
    }
}
