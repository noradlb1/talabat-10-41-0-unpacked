package com.instabug.survey.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

public class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f52355a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f52356b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52357c;

    /* renamed from: d  reason: collision with root package name */
    private int f52358d = 10000;

    public static h b(String str) {
        h hVar = new h();
        hVar.a(str);
        return hVar;
    }

    public int a() {
        return this.f52358d;
    }

    public void a(int i11) {
        this.f52358d = i11;
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        c(jSONObject.optInt("trigger_type", 0));
        a(jSONObject.optInt("trigger_after", 10000));
        if (jSONObject.has("user_event")) {
            c(jSONObject.getString("user_event"));
        }
        if (jSONObject.has("trigger_status")) {
            b(jSONObject.getInt("trigger_status"));
        }
        if (jSONObject.has("trigger_after")) {
            a(jSONObject.getInt("trigger_after"));
        }
    }

    @NonNull
    public String b() {
        String str = this.f52357c;
        return str == null ? "" : str;
    }

    public void b(int i11) {
        this.f52355a = i11;
    }

    public JSONObject c() {
        return new JSONObject().put("user_event", (Object) this.f52357c).put("trigger_type", this.f52356b).put("trigger_after", this.f52358d).put("trigger_status", this.f52355a);
    }

    public void c(int i11) {
        this.f52356b = i11;
    }

    public void c(@Nullable String str) {
        this.f52357c = str;
    }
}
