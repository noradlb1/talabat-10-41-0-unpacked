package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcdq;
import com.google.android.gms.internal.ads.zzfvx;
import com.google.android.gms.internal.ads.zzfwq;
import com.google.android.gms.internal.ads.zzfxa;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzae implements zzfvx {
    public final /* synthetic */ zzcdq zza;

    public /* synthetic */ zzae(zzcdq zzcdq) {
        this.zza = zzcdq;
    }

    public final zzfxa zza(Object obj) {
        String str;
        zzcdq zzcdq = this.zza;
        zzah zzah = new zzah(new JsonReader(new InputStreamReader((InputStream) obj)));
        try {
            JSONObject zze = zzt.zzp().zze(zzcdq.zza);
            if (!(zze instanceof JSONObject)) {
                str = zze.toString();
            } else {
                str = JSONObjectInstrumentation.toString(zze);
            }
            zzah.zzb = str;
        } catch (JSONException unused) {
            zzah.zzb = "{}";
        }
        return zzfwq.zzi(zzah);
    }
}
