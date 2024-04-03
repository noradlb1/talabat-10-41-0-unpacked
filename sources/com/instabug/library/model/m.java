package com.instabug.library.model;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class m implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private n f51559a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51560b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f51561c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f51562d;

    public m() {
    }

    @Nullable
    public n a() {
        return this.f51559a;
    }

    @Nullable
    public String b() {
        return this.f51560b;
    }

    @Nullable
    public String c() {
        return this.f51561c;
    }

    @Nullable
    public String d() {
        return this.f51562d;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("event")) {
            String string = jSONObject.getString("event");
            string.hashCode();
            char c11 = 65535;
            switch (string.hashCode()) {
                case -1068318794:
                    if (string.equals("motion")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (string.equals("scroll")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 110749:
                    if (string.equals("pan")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 114595:
                    if (string.equals("tap")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3619493:
                    if (string.equals("view")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 106671290:
                    if (string.equals("pinch")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 109854522:
                    if (string.equals("swipe")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 779098677:
                    if (string.equals("double_tap")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1554253136:
                    if (string.equals(MimeTypes.BASE_TYPE_APPLICATION)) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    a(n.MOTION);
                    break;
                case 1:
                    a(n.SCROLL);
                    break;
                case 2:
                    a(n.LONG_PRESS);
                    break;
                case 3:
                    a(n.TAP);
                    break;
                case 4:
                    a(n.VIEW);
                    break;
                case 5:
                    a(n.PINCH);
                    break;
                case 6:
                    a(n.SWIPE);
                    break;
                case 7:
                    a(n.DOUBLE_TAP);
                    break;
                case 8:
                    a(n.APPLICATION);
                    break;
                default:
                    a(n.NOT_AVAILABLE);
                    break;
            }
        }
        if (jSONObject.has("class")) {
            b(jSONObject.getString("class"));
        }
        if (jSONObject.has("label")) {
            a(jSONObject.getString("label"));
        }
        if (jSONObject.has("view")) {
            c(jSONObject.getString("view"));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", (Object) a());
        jSONObject.put("label", (Object) b());
        jSONObject.put("class", (Object) c());
        jSONObject.put("view", (Object) d());
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public m(@Nullable n nVar, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        a(nVar);
        a(str);
        b(str2);
        c(str3);
    }

    public void a(@Nullable n nVar) {
        this.f51559a = nVar;
    }

    public void b(@Nullable String str) {
        this.f51561c = str;
    }

    public void c(@Nullable String str) {
        this.f51562d = str;
    }

    public void a(@Nullable String str) {
        this.f51560b = str;
    }
}
