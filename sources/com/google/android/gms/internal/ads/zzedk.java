package com.google.android.gms.internal.ads;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzedk implements zzfvx {
    public final /* synthetic */ zzedm zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzedk(zzedm zzedm, String str, String str2) {
        this.zza = zzedm;
        this.zzb = str;
        this.zzc = str2;
    }

    public final zzfxa zza(Object obj) {
        String str;
        String str2 = this.zzb;
        String str3 = this.zzc;
        String str4 = (String) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, (Object) new JSONObject());
            jSONObject3.put("body", (Object) str2);
            jSONObject2.put("base_url", (Object) "");
            jSONObject2.put("signals", (Object) new JSONObject(str3));
            jSONObject.put("request", (Object) jSONObject2);
            jSONObject.put("response", (Object) jSONObject3);
            jSONObject.put("flags", (Object) new JSONObject());
            return zzfwq.zzi(jSONObject);
        } catch (JSONException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Preloaded loader: ".concat(valueOf);
            } else {
                str = new String("Preloaded loader: ");
            }
            throw new JSONException(str);
        }
    }
}
