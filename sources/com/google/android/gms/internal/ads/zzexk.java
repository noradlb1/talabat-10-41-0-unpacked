package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzexk implements zzevm<JSONObject> {
    private final Bundle zza;

    public zzexk(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zza != null) {
            try {
                zzby.zzf(zzby.zzf(jSONObject, "device"), "play_store").put("parental_controls", (Object) zzt.zzp().zze(this.zza));
            } catch (JSONException unused) {
                zze.zza("Failed putting parental controls bundle.");
            }
        }
    }
}
