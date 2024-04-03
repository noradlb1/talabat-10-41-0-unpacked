package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import javax.annotation.Nullable;
import org.json.JSONObject;

@Instrumented
public final class zzerz implements zzevm<Bundle> {
    @Nullable
    private final JSONObject zza;
    @Nullable
    private final JSONObject zzb;

    public zzerz(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        this.zza = jSONObject;
        this.zzb = jSONObject2;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        JSONObject jSONObject = this.zza;
        if (jSONObject != null) {
            bundle.putString("fwd_cld", JSONObjectInstrumentation.toString(jSONObject));
        }
        JSONObject jSONObject2 = this.zzb;
        if (jSONObject2 != null) {
            bundle.putString("fwd_common_cld", JSONObjectInstrumentation.toString(jSONObject2));
        }
    }
}
