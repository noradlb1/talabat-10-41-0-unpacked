package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public final /* synthetic */ class zzeum implements Callable {
    public final /* synthetic */ List zza;

    public /* synthetic */ zzeum(List list) {
        this.zza = list;
    }

    public final Object call() {
        List<zzfxa> list = this.zza;
        JSONArray jSONArray = new JSONArray();
        for (zzfxa zzfxa : list) {
            if (((JSONObject) zzfxa.get()) != null) {
                jSONArray.put(zzfxa.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzeuo(JSONArrayInstrumentation.toString(jSONArray));
    }
}
