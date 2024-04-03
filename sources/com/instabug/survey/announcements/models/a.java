package com.instabug.survey.announcements.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.common.models.a;
import com.instabug.survey.common.models.b;
import com.instabug.survey.common.models.e;
import com.instabug.survey.common.models.f;
import com.instabug.survey.common.models.g;
import com.instabug.survey.common.models.i;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a implements Cacheable, Serializable, e {

    /* renamed from: a  reason: collision with root package name */
    private long f52239a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52240b;

    /* renamed from: c  reason: collision with root package name */
    private int f52241c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f52242d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52243e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f52244f = 0;

    /* renamed from: g  reason: collision with root package name */
    private b f52245g = new b();

    /* renamed from: h  reason: collision with root package name */
    private i f52246h = new i(1);

    public static List a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("published");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            a aVar = new a();
            aVar.fromJson(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private void c(int i11) {
        this.f52246h.c(i11);
    }

    private int r() {
        return this.f52246h.l();
    }

    public void a() {
        c(TimeUtils.currentTimeSeconds());
        this.f52246h.i().a().add(new com.instabug.survey.common.models.a(a.C0096a.SHOW, TimeUtils.currentTimeSeconds(), r()));
    }

    public void a(int i11) {
        this.f52244f = i11;
    }

    public void a(long j11) {
        this.f52246h.a(j11);
    }

    public void a(f fVar) {
        this.f52246h.a(fVar);
    }

    public void a(g gVar) {
        this.f52246h.a(gVar);
    }

    public void a(i iVar) {
        this.f52246h = iVar;
    }

    public void a(String str) {
        this.f52246h.i().b(str);
    }

    public void a(@Nullable ArrayList arrayList) {
        this.f52242d = arrayList;
    }

    public void a(boolean z11) {
        this.f52246h.a(z11);
    }

    public a b(long j11) {
        this.f52239a = j11;
        return this;
    }

    public ArrayList b() {
        return this.f52246h.i().a();
    }

    public void b(int i11) {
        this.f52246h.b(i11);
    }

    public void b(@Nullable String str) {
        this.f52240b = str;
    }

    public void b(boolean z11) {
        this.f52246h.b(z11);
    }

    @Nullable
    public ArrayList c() {
        return this.f52242d;
    }

    public void c(long j11) {
        this.f52246h.b(j11);
    }

    public void c(boolean z11) {
        this.f52246h.c(z11);
    }

    public f d() {
        return this.f52246h.h();
    }

    public void d(int i11) {
        this.f52241c = i11;
    }

    public void d(boolean z11) {
        this.f52243e = z11;
    }

    public int e() {
        return this.f52244f;
    }

    public boolean equals(@Nullable Object obj) {
        return obj != null && (obj instanceof a) && ((a) obj).i() == i();
    }

    public String f() {
        return this.f52246h.i().b();
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            b(jSONObject.getLong("id"));
        }
        if (jSONObject.has("type")) {
            d(jSONObject.getInt("type"));
        }
        if (jSONObject.has("title")) {
            b(jSONObject.getString("title"));
        }
        if (jSONObject.has("events")) {
            this.f52246h.i().a(com.instabug.survey.common.models.a.a(jSONObject.getJSONArray("events")));
        }
        a(jSONObject.has("announcement_items") ? c.a(jSONObject.getJSONArray("announcement_items")) : new ArrayList());
        if (jSONObject.has("target")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("target");
            this.f52246h.i().fromJson((!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).replace("\\", ""));
        }
        if (jSONObject.has("answered")) {
            b(jSONObject.getBoolean("answered"));
        }
        if (jSONObject.has("is_cancelled")) {
            c(jSONObject.getBoolean("is_cancelled"));
        }
        if (jSONObject.has("announcement_state")) {
            a(f.valueOf(jSONObject.getString("announcement_state")));
        }
        if (jSONObject.has("session_counter")) {
            c(jSONObject.getInt("session_counter"));
        }
        if (jSONObject.has("dismissed_at")) {
            a((long) jSONObject.getInt("dismissed_at"));
        }
        this.f52245g.a(jSONObject);
    }

    public long g() {
        return this.f52246h.c();
    }

    public long getSurveyId() {
        return this.f52239a;
    }

    public i getUserInteraction() {
        return this.f52246h;
    }

    public int h() {
        return this.f52246h.d();
    }

    public int hashCode() {
        return String.valueOf(i()).hashCode();
    }

    public long i() {
        return this.f52239a;
    }

    public b j() {
        return this.f52245g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long k() {
        /*
            r4 = this;
            com.instabug.survey.common.models.i r0 = r4.f52246h
            com.instabug.survey.common.models.g r0 = r0.i()
            java.util.ArrayList r1 = r0.a()
            if (r1 == 0) goto L_0x003f
            java.util.ArrayList r1 = r0.a()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x003f
            java.util.ArrayList r0 = r0.a()
            java.util.Iterator r0 = r0.iterator()
        L_0x001e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r0.next()
            com.instabug.survey.common.models.a r1 = (com.instabug.survey.common.models.a) r1
            com.instabug.survey.common.models.a$a r2 = r1.a()
            com.instabug.survey.common.models.a$a r3 = com.instabug.survey.common.models.a.C0096a.SUBMIT
            if (r2 == r3) goto L_0x003a
            com.instabug.survey.common.models.a$a r2 = r1.a()
            com.instabug.survey.common.models.a$a r3 = com.instabug.survey.common.models.a.C0096a.DISMISS
            if (r2 != r3) goto L_0x001e
        L_0x003a:
            long r0 = r1.c()
            return r0
        L_0x003f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.models.a.k():long");
    }

    public int l() {
        return this.f52246h.e();
    }

    public long m() {
        if (this.f52246h.f() == 0 && this.f52246h.c() != 0) {
            c(this.f52246h.c());
        }
        return this.f52246h.f();
    }

    public g n() {
        return this.f52246h.i();
    }

    @Nullable
    public String o() {
        return this.f52240b;
    }

    public int p() {
        return this.f52241c;
    }

    public String q() {
        int i11 = this.f52241c;
        return i11 != 100 ? i11 != 101 ? "" : "UpdateMessage" : "WhatsNew";
    }

    public boolean s() {
        return this.f52246h.n();
    }

    public boolean t() {
        return this.f52246h.o();
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f52239a).put("type", this.f52241c).put("title", (Object) this.f52240b).put("announcement_items", (Object) c.c(this.f52242d)).put("target", (Object) g.a(this.f52246h.i())).put("events", (Object) com.instabug.survey.common.models.a.a(this.f52246h.i().a())).put("answered", this.f52246h.o()).put("dismissed_at", g()).put("is_cancelled", this.f52246h.p()).put("announcement_state", (Object) d().toString()).put("should_show_again", z()).put("session_counter", l());
        this.f52245g.b(jSONObject);
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        try {
            return toJson();
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Error: " + e11.getMessage() + " while parsing announcement", e11);
            return super.toString();
        }
    }

    public boolean u() {
        return this.f52246h.p();
    }

    public boolean v() {
        return this.f52243e;
    }

    public void w() {
        g i11 = this.f52246h.i();
        i11.a(new ArrayList());
        i iVar = new i(0);
        this.f52246h = iVar;
        iVar.a(i11);
    }

    public void x() {
        a(f.READY_TO_SEND);
        this.f52246h.a(TimeUtils.currentTimeSeconds());
        b(true);
        c(true);
        a(true);
        g i11 = this.f52246h.i();
        if (i11.a().size() <= 0 || ((com.instabug.survey.common.models.a) i11.a().get(i11.a().size() - 1)).a() != a.C0096a.DISMISS) {
            i11.a().add(new com.instabug.survey.common.models.a(a.C0096a.DISMISS, this.f52246h.c(), h()));
        }
    }

    public void y() {
        c(false);
        b(true);
        a(true);
        a.C0096a aVar = a.C0096a.SUBMIT;
        com.instabug.survey.common.models.a aVar2 = new com.instabug.survey.common.models.a(aVar, TimeUtils.currentTimeSeconds(), 1);
        a(f.READY_TO_SEND);
        g i11 = this.f52246h.i();
        if (i11.a().size() <= 0 || ((com.instabug.survey.common.models.a) i11.a().get(i11.a().size() - 1)).a() != aVar || aVar2.a() != aVar) {
            i11.a().add(aVar2);
        }
    }

    public boolean z() {
        g i11 = this.f52246h.i();
        boolean e11 = i11.d().e();
        boolean z11 = !this.f52246h.n();
        boolean z12 = !i11.d().f();
        boolean z13 = com.instabug.survey.utils.a.b(m()) >= i11.d().b();
        if (e11 || z11) {
            return true;
        }
        return z12 && z13;
    }
}
