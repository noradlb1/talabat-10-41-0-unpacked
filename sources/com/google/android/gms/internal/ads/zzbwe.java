package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class zzbwe {
    public static final zzbwb<JSONObject> zza = new zzbwd();
    public static final zzbvz<InputStream> zzb = zzbwc.zza;
    private static final Charset zzc = Charset.forName("UTF-8");

    public static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(zzc));
    }
}
