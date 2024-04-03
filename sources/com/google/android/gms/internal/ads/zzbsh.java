package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@ParametersAreNonnullByDefault
public final class zzbsh implements zzbrt<Object> {
    private final Object zza = new Object();
    @GuardedBy("lock")
    private final Map<String, zzbsg> zzb = new HashMap();

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = map.get("id");
        String str6 = map.get("fail");
        String str7 = map.get("fail_reason");
        String str8 = map.get("fail_stack");
        String str9 = map.get("result");
        if (true == TextUtils.isEmpty(str8)) {
            str7 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str8)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str8);
            if (valueOf.length() != 0) {
                str = StringUtils.LF.concat(valueOf);
            } else {
                str = new String(StringUtils.LF);
            }
        }
        synchronized (this.zza) {
            zzbsg remove = this.zzb.remove(str5);
            if (remove == null) {
                String valueOf2 = String.valueOf(str5);
                if (valueOf2.length() != 0) {
                    str4 = "Received result for unexpected method invocation: ".concat(valueOf2);
                } else {
                    str4 = new String("Received result for unexpected method invocation: ");
                }
                zzciz.zzj(str4);
            } else if (!TextUtils.isEmpty(str6)) {
                String valueOf3 = String.valueOf(str7);
                String valueOf4 = String.valueOf(str);
                if (valueOf4.length() != 0) {
                    str3 = valueOf3.concat(valueOf4);
                } else {
                    str3 = new String(valueOf3);
                }
                remove.zza(str3);
            } else if (str9 == null) {
                remove.zzb((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str9);
                    if (zze.zzc()) {
                        String valueOf5 = String.valueOf(JSONObjectInstrumentation.toString(jSONObject, 2));
                        if (valueOf5.length() != 0) {
                            str2 = "Result GMSG: ".concat(valueOf5);
                        } else {
                            str2 = new String("Result GMSG: ");
                        }
                        zze.zza(str2);
                    }
                    remove.zzb(jSONObject);
                } catch (JSONException e11) {
                    remove.zza(e11.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzbux> zzfxa<JSONObject> zzb(EngineT enginet, String str, JSONObject jSONObject) {
        zzcjr zzcjr = new zzcjr();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzbsf(this, zzcjr));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", (Object) uuid);
            jSONObject2.put(StepData.ARGS, (Object) jSONObject);
            enginet.zzl(str, jSONObject2);
        } catch (Exception e11) {
            zzcjr.zze(e11);
        }
        return zzcjr;
    }

    public final void zzc(String str, zzbsg zzbsg) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbsg);
        }
    }
}
