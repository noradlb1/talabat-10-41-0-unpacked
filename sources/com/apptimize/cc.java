package com.apptimize;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cc {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41624a = "cc";

    /* renamed from: b  reason: collision with root package name */
    private final String f41625b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41626c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41627d;

    /* renamed from: e  reason: collision with root package name */
    private final long f41628e;

    /* renamed from: f  reason: collision with root package name */
    private final long f41629f;

    /* renamed from: g  reason: collision with root package name */
    private final by f41630g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<Long> f41631h;

    /* renamed from: i  reason: collision with root package name */
    private final Set<Long> f41632i;

    /* renamed from: j  reason: collision with root package name */
    private final String f41633j;

    /* renamed from: k  reason: collision with root package name */
    private final Boolean f41634k;

    public cc(String str, String str2, String str3, long j11, long j12, by byVar, Set<Long> set, Set<Long> set2, String str4, Boolean bool) {
        this.f41625b = str;
        this.f41626c = str2;
        this.f41627d = str3;
        this.f41628e = j11;
        this.f41629f = j12;
        this.f41630g = byVar;
        this.f41631h = set == null ? new HashSet<>() : set;
        this.f41632i = set2 == null ? new HashSet<>() : set2;
        this.f41633j = str4;
        this.f41634k = bool;
    }

    public static cc a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        long j11;
        JSONObject jSONObject2 = jSONObject;
        by byVar = null;
        String string = (!jSONObject2.has("etag") || jSONObject2.isNull("etag")) ? null : jSONObject2.getString("etag");
        Long valueOf = Long.valueOf(jSONObject2.optLong("downloadedAt"));
        long optLong = jSONObject2.optLong("downloadedAtMonotonic");
        if (valueOf.longValue() != 0) {
            j11 = auVar.e().f();
        } else {
            j11 = auVar.e().a(optLong, jSONObject2.optLong("downloadedBootTime"));
        }
        long j12 = j11;
        if (jSONObject2.has("metaData")) {
            byVar = by.a(jSONObject2.getJSONObject("metaData"), auVar);
        } else {
            au auVar2 = auVar;
        }
        return new cc(jSONObject2.getString("appKey"), jSONObject2.optString("metaDataUrlHash"), string, j12, auVar.e().e(), byVar, a(jSONObject2, "activeVariants"), a(jSONObject2, "variantsForced"), jSONObject2.optString("processedSDKVersion", "legacy"), Boolean.FALSE);
    }

    public String b() {
        return this.f41625b;
    }

    public String c() {
        return this.f41626c;
    }

    public String d() {
        return this.f41627d;
    }

    public long e() {
        return this.f41628e;
    }

    public by f() {
        return this.f41630g;
    }

    public Set<Long> g() {
        return this.f41631h;
    }

    public Set<Long> h() {
        return this.f41632i;
    }

    public String i() {
        return this.f41633j;
    }

    public Boolean j() {
        return this.f41634k;
    }

    public cc a(long j11, long j12) {
        return new cc(this.f41625b, this.f41626c, this.f41627d, j11, j12, this.f41630g, this.f41631h, this.f41632i, this.f41633j, Boolean.TRUE);
    }

    public cc a(Set<Long> set) {
        return new cc(this.f41625b, this.f41626c, this.f41627d, this.f41628e, this.f41629f, this.f41630g, new HashSet(this.f41631h), new HashSet(set), this.f41633j, Boolean.FALSE);
    }

    public cc a(by byVar) {
        return new cc(this.f41625b, this.f41626c, this.f41627d, this.f41628e, this.f41629f, byVar, this.f41631h, this.f41632i, this.f41633j, Boolean.FALSE);
    }

    public JSONObject a() throws JSONException {
        return a(true);
    }

    public JSONObject a(boolean z11) throws JSONException {
        by byVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appKey", (Object) this.f41625b);
        jSONObject.put("metaDataUrlHash", (Object) this.f41626c);
        Object obj = this.f41627d;
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put("etag", obj);
        jSONObject.put("downloadedAtMonotonic", this.f41628e);
        jSONObject.put("downloadedBootTime", this.f41629f);
        if (z11 && (byVar = this.f41630g) != null) {
            jSONObject.put("metaData", (Object) byVar.a());
        }
        jSONObject.put("activeVariants", (Object) new JSONArray((Collection<?>) this.f41631h));
        jSONObject.put("variantsForced", (Object) new JSONArray((Collection<?>) this.f41632i));
        jSONObject.put("processedSDKVersion", (Object) this.f41633j);
        return jSONObject;
    }

    private static Set<Long> a(JSONObject jSONObject, String str) {
        try {
            HashSet hashSet = new HashSet();
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    hashSet.add(Long.valueOf(optJSONArray.getLong(i11)));
                }
            }
            return hashSet;
        } catch (JSONException e11) {
            String str2 = f41624a;
            bo.e(str2, "Couldn't parse variants forced from metametadata. Got exception " + e11.toString());
            return new HashSet();
        }
    }
}
