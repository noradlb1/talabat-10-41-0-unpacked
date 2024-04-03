package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import org.json.JSONException;
import org.json.JSONObject;

final class zzeff implements zzbwa<zzefg> {
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzefg zzefg = (zzefg) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", (Object) zzefg.zzd.zzb());
        jSONObject2.put("signals", (Object) zzefg.zzc);
        jSONObject3.put("body", (Object) zzefg.zzb.zzc);
        jSONObject3.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, (Object) zzt.zzp().zzf(zzefg.zzb.zzb));
        jSONObject3.put("response_code", zzefg.zzb.zza);
        jSONObject3.put("latency", zzefg.zzb.zzd);
        jSONObject.put("request", (Object) jSONObject2);
        jSONObject.put("response", (Object) jSONObject3);
        jSONObject.put("flags", (Object) zzefg.zzd.zzg());
        return jSONObject;
    }
}
