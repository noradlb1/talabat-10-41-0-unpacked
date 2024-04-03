package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzewd implements zzevm<JSONObject> {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;

    public zzewd(AdvertisingIdClient.Info info, String str) {
        this.zza = info;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject zzf = zzby.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                zzf.put("pdid", (Object) this.zzb);
                zzf.put("pdidtype", (Object) "ssaid");
                return;
            }
            zzf.put("rdid", (Object) this.zza.getId());
            zzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            zzf.put("idtype", (Object) "adid");
        } catch (JSONException e11) {
            zze.zzb("Failed putting Ad ID.", e11);
        }
    }
}
