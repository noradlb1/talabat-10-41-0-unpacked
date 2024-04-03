package com.google.android.libraries.places.internal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public final class zzbq {
    private final Gson zza = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public final <T> T zza(String str, Class<T> cls) throws zzao {
        try {
            Gson gson = this.zza;
            if (!(gson instanceof Gson)) {
                return gson.fromJson(str, cls);
            }
            return GsonInstrumentation.fromJson(gson, str, cls);
        } catch (JsonSyntaxException unused) {
            String name2 = cls.getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 55);
            sb2.append("Could not convert JSON string to ");
            sb2.append(name2);
            sb2.append(" due to syntax errors.");
            throw new zzao(sb2.toString());
        }
    }
}
