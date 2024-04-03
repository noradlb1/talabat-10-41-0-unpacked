package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzby;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfds {
    @Nullable
    public final String zza;
    @Nullable
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzfds(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzh = zzby.zzh(jsonReader);
        this.zzd = zzh;
        this.zza = zzh.optString("ad_html", (String) null);
        this.zzb = zzh.optString("ad_base_url", (String) null);
        this.zzc = zzh.optJSONObject("ad_json");
    }
}
