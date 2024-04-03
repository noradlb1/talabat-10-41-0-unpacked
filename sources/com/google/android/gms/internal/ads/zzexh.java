package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzexh implements zzevm<JSONObject> {
    private final List<String> zza;

    public zzexh(List<String> list) {
        this.zza = list;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            ((JSONObject) obj).put("eid", (Object) TextUtils.join(",", this.zza));
        } catch (JSONException unused) {
            zze.zza("Failed putting experiment ids.");
        }
    }
}
