package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzefo implements zzfhh<zzefn, zzefj> {
    private final String zza;

    public zzefo(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzefn zzefn = (zzefn) obj;
        int optInt = zzefn.zza.optInt("http_timeout_millis", 60000);
        zzcdt zza2 = zzefn.zzb;
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzefn.zzb.zzh() && !TextUtils.isEmpty(this.zza)) {
                hashMap.put(HttpHeaders.COOKIE, this.zza);
            }
            String str = "";
            if (zzefn.zzb.zzi()) {
                JSONObject optJSONObject = zzefn.zza.optJSONObject("pii");
                if (optJSONObject != null) {
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos", str))) {
                        hashMap.put("x-afma-drt-cookie", optJSONObject.optString("doritos", str));
                    }
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", str))) {
                        hashMap.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", str));
                    }
                } else {
                    zze.zza("DSID signal does not exist.");
                }
            }
            if (zzefn.zzb != null && !TextUtils.isEmpty(zzefn.zzb.zzd())) {
                str = zzefn.zzb.zzd();
            }
            return new zzefj(zzefn.zzb.zze(), optInt, hashMap, str.getBytes(zzfpt.zzc), "");
        } else if (zza2.zza() == 1) {
            if (zza2.zzf() != null) {
                zzciz.zzg(TextUtils.join(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, zza2.zzf()));
            }
            throw new zzecd(2, "Error building request URL.");
        } else {
            throw new zzecd(1);
        }
    }
}
