package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzeyb implements zzevm<JSONObject> {
    private final Map<String, Object> zza;

    public zzeyb(Map<String, Object> map) {
        this.zza = map;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        String str;
        try {
            ((JSONObject) obj).put("video_decoders", (Object) zzt.zzp().zzf(this.zza));
        } catch (JSONException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Could not encode video decoder properties: ".concat(valueOf);
            } else {
                str = new String("Could not encode video decoder properties: ");
            }
            zze.zza(str);
        }
    }
}
