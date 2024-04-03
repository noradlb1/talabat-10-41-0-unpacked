package com.huawei.hms.dtm.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Md {

    /* renamed from: a  reason: collision with root package name */
    private String f48346a;

    /* renamed from: b  reason: collision with root package name */
    private String f48347b;

    /* renamed from: c  reason: collision with root package name */
    private String f48348c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f48349d;

    /* renamed from: e  reason: collision with root package name */
    private int f48350e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f48351f;

    /* renamed from: g  reason: collision with root package name */
    private String f48352g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f48353h;

    /* renamed from: i  reason: collision with root package name */
    private String f48354i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f48355j = "";

    /* renamed from: k  reason: collision with root package name */
    private boolean f48356k;

    /* renamed from: l  reason: collision with root package name */
    private a f48357l;

    /* renamed from: m  reason: collision with root package name */
    private int f48358m;

    /* renamed from: n  reason: collision with root package name */
    private List<Md> f48359n = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final float f48360a;

        /* renamed from: b  reason: collision with root package name */
        private int f48361b;

        /* renamed from: c  reason: collision with root package name */
        private int f48362c;

        /* renamed from: d  reason: collision with root package name */
        private int f48363d;

        /* renamed from: e  reason: collision with root package name */
        private int f48364e;

        public a(float f11) {
            this.f48360a = f11;
        }

        public a a(float f11) {
            this.f48364e = (int) (f11 * this.f48360a);
            return this;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Param.X, this.f48361b);
            jSONObject2.put(Param.Y, this.f48362c);
            jSONObject2.put("w", this.f48363d);
            jSONObject2.put("h", this.f48364e);
            jSONObject.put(TypedValues.AttributesType.S_FRAME, (Object) jSONObject2);
        }

        public a b(float f11) {
            this.f48363d = (int) (f11 * this.f48360a);
            return this;
        }

        public a c(float f11) {
            this.f48361b = (int) (f11 * this.f48360a);
            return this;
        }

        public a d(float f11) {
            this.f48362c = (int) (f11 * this.f48360a);
            return this;
        }
    }

    public int a() {
        return this.f48350e;
    }

    public Md a(int i11) {
        this.f48358m = i11;
        return this;
    }

    public Md a(a aVar) {
        this.f48357l = aVar;
        return this;
    }

    public Md a(Md md2) {
        this.f48359n.add(md2);
        return this;
    }

    public Md a(String str) {
        this.f48354i = str;
        return this;
    }

    public Md a(boolean z11) {
        this.f48349d = z11;
        return this;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", (Object) this.f48346a);
        jSONObject2.put("idList", (Object) this.f48347b);
        jSONObject2.put("idRange", (Object) this.f48348c);
        jSONObject2.put("ignoreIndex", this.f48349d);
        jSONObject2.put("ignoreLevel", this.f48350e);
        jSONObject2.put("url", (Object) this.f48352g);
        jSONObject2.put("isWebView", this.f48351f);
        jSONObject2.put("isEdit", this.f48353h);
        jSONObject2.put("content", (Object) this.f48354i);
        jSONObject2.put("tagName", (Object) this.f48355j);
        jSONObject2.put("isParam", this.f48356k);
        jSONObject2.put("alpha", this.f48358m);
        JSONArray jSONArray = new JSONArray();
        for (Md a11 : this.f48359n) {
            jSONArray.put((Object) a11.a(jSONObject2));
        }
        jSONObject2.put("child", (Object) jSONArray);
        a aVar = this.f48357l;
        if (aVar != null) {
            aVar.a(jSONObject2);
        }
        return jSONObject2;
    }

    public Md b(int i11) {
        this.f48350e = i11;
        return this;
    }

    public Md b(String str) {
        this.f48346a = str;
        return this;
    }

    public Md b(boolean z11) {
        this.f48353h = z11;
        return this;
    }

    public Md c(String str) {
        this.f48348c = str;
        return this;
    }

    public Md c(boolean z11) {
        this.f48356k = z11;
        return this;
    }

    public Md d(String str) {
        this.f48347b = str;
        return this;
    }

    public Md d(boolean z11) {
        this.f48351f = z11;
        return this;
    }

    public Md e(String str) {
        this.f48355j = str;
        return this;
    }

    public Md f(String str) {
        this.f48352g = str;
        return this;
    }
}
