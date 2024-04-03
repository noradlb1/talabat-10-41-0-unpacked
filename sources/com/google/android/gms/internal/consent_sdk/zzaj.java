package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public final class zzaj implements zzi {
    private final Application zza;
    private final zzal zzb;
    private final Executor zzc;

    public zzaj(Application application, zzal zzal, Executor executor) {
        this.zza = application;
        this.zzb = zzal;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    public final boolean zza(String str, JSONObject jSONObject) {
        str.hashCode();
        if (str.equals("clear")) {
            JSONArray optJSONArray = jSONObject.optJSONArray(UserMetadata.KEYDATA_FILENAME);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                String valueOf = String.valueOf(JSONObjectInstrumentation.toString(jSONObject));
                if (valueOf.length() != 0) {
                    "Action[clear]: wrong args.".concat(valueOf);
                }
            } else {
                HashSet hashSet = new HashSet();
                int length = optJSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    String optString = optJSONArray.optString(i11);
                    if (TextUtils.isEmpty(optString)) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Action[clear]: empty key at index: ");
                        sb2.append(i11);
                    } else {
                        hashSet.add(optString);
                    }
                }
                zzcc.zza((Context) this.zza, (Set<String>) hashSet);
            }
            return true;
        } else if (!str.equals("write")) {
            return false;
        } else {
            zzce zzce = new zzce(this.zza);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                String valueOf2 = String.valueOf(opt);
                StringBuilder sb3 = new StringBuilder(String.valueOf(next).length() + 23 + valueOf2.length());
                sb3.append("Writing to storage: [");
                sb3.append(next);
                sb3.append("] ");
                sb3.append(valueOf2);
                if (zzce.zza(next, opt)) {
                    this.zzb.zzd().add(next);
                } else {
                    String valueOf3 = String.valueOf(next);
                    if (valueOf3.length() != 0) {
                        "Failed writing key: ".concat(valueOf3);
                    }
                }
            }
            this.zzb.zze();
            zzce.zza();
            return true;
        }
    }
}
