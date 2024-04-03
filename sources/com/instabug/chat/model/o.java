package com.instabug.chat.model;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public class o implements Cacheable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f46083a;

    /* renamed from: b  reason: collision with root package name */
    private long f46084b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46085c;

    @Nullable
    public String a() {
        return this.f46083a;
    }

    public void a(long j11) {
        this.f46084b = j11;
    }

    public void a(@Nullable String str) {
        this.f46083a = str;
    }

    @Nullable
    public String b() {
        return this.f46085c;
    }

    public void b(@Nullable String str) {
        this.f46085c = str;
    }

    public long c() {
        return this.f46084b;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return String.valueOf(oVar.a()).equals(String.valueOf(a())) && String.valueOf(oVar.b()).equals(String.valueOf(b())) && oVar.c() == c();
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("chat_number")) {
            a(jSONObject.getString("chat_number"));
        }
        if (jSONObject.has("message_id")) {
            b(jSONObject.getString("message_id"));
        }
        if (jSONObject.has("read_at")) {
            a(jSONObject.getLong("read_at"));
        }
    }

    public int hashCode() {
        String str = this.f46083a;
        return str != null ? str.hashCode() : super.hashCode();
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("read_at", c());
        if (a() != null) {
            jSONObject.put("chat_number", (Object) a());
        }
        if (b() != null) {
            jSONObject.put("message_id", (Object) b());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
