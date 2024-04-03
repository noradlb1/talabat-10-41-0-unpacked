package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.firebase.perf.FirebasePerformance;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcea extends zzceb {
    private final Object zza = new Object();
    private final Context zzb;
    @Nullable
    private SharedPreferences zzc;
    private final zzbvx<JSONObject, JSONObject> zzd;

    public zzcea(Context context, zzbvx<JSONObject, JSONObject> zzbvx) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbvx;
    }

    public static JSONObject zzc(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", (Object) zzcjf.zza().zza);
            jSONObject.put("mf", (Object) zzbmx.zza.zze());
            jSONObject.put("cl", (Object) "428884702");
            jSONObject.put("rapid_rc", (Object) "dev");
            jSONObject.put("rapid_rollup", (Object) FirebasePerformance.HttpMethod.HEAD);
            jSONObject.put("admob_module_version", (int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", (int) ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", (int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final zzfxa<Void> zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzt.zzA().currentTimeMillis() - this.zzc.getLong("js_last_update", 0) < zzbmx.zzb.zze().longValue()) {
            return zzfwq.zzi(null);
        }
        return zzfwq.zzm(this.zzd.zzb(zzc(this.zzb)), new zzcdz(this), zzcjm.zzf);
    }

    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzblj.zzd(this.zzb, 1, jSONObject);
        this.zzc.edit().putLong("js_last_update", zzt.zzA().currentTimeMillis()).apply();
        return null;
    }
}
