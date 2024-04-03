package com.instabug.survey.common.models;

import java.io.Serializable;
import org.json.JSONObject;

public class d implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f52341a;

    /* renamed from: b  reason: collision with root package name */
    private int f52342b;

    /* renamed from: c  reason: collision with root package name */
    private int f52343c;

    public static d b(String str) {
        d dVar = new d();
        dVar.a(str);
        return dVar;
    }

    public int a() {
        if (this.f52343c <= 0) {
            this.f52343c = -1;
        }
        return Math.min(this.f52343c, this.f52342b);
    }

    public void a(int i11) {
        this.f52343c = i11;
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("frequency_type")) {
            c(jSONObject.getInt("frequency_type"));
        }
        b(jSONObject.optInt("showing_surveys_interval", 30));
        a(jSONObject.optInt("reshow_interval", -1));
    }

    public int b() {
        if (this.f52342b <= 0) {
            this.f52342b = 30;
        }
        return this.f52342b;
    }

    public void b(int i11) {
        this.f52342b = i11;
    }

    public int c() {
        return this.f52341a;
    }

    public void c(int i11) {
        this.f52341a = i11;
    }

    public boolean d() {
        return a() == -1;
    }

    public boolean e() {
        return c() == 2;
    }

    public boolean f() {
        return c() == 1;
    }

    public JSONObject g() {
        return new JSONObject().put("frequency_type", this.f52341a).put("showing_surveys_interval", this.f52342b).put("reshow_interval", this.f52343c);
    }
}
