package com.instabug.featuresrequest.models;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import org.json.JSONObject;

@Instrumented
public class d implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private long f46540a = (System.currentTimeMillis() / 1000);

    /* renamed from: b  reason: collision with root package name */
    private String f46541b;

    /* renamed from: c  reason: collision with root package name */
    private String f46542c;

    /* renamed from: d  reason: collision with root package name */
    private b f46543d = b.Open;

    /* renamed from: e  reason: collision with root package name */
    private String f46544e;

    /* renamed from: f  reason: collision with root package name */
    private String f46545f;

    /* renamed from: g  reason: collision with root package name */
    private long f46546g;

    /* renamed from: h  reason: collision with root package name */
    private int f46547h;

    /* renamed from: i  reason: collision with root package name */
    private int f46548i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f46549j;

    /* renamed from: k  reason: collision with root package name */
    private String f46550k;

    /* renamed from: l  reason: collision with root package name */
    private String f46551l;

    /* renamed from: m  reason: collision with root package name */
    private String f46552m;

    /* renamed from: n  reason: collision with root package name */
    private c f46553n = c.NOTHING;

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
    public d(String str, String str2, String str3) {
        this.f46550k = str;
        this.f46551l = str2;
        this.f46552m = str3;
    }

    private void a(JSONObject jSONObject) {
        b bVar;
        if (jSONObject.has("status")) {
            int i11 = jSONObject.getInt("status");
            if (i11 == 0) {
                bVar = b.Open;
            } else if (i11 == 1) {
                bVar = b.Planned;
            } else if (i11 == 2) {
                bVar = b.InProgress;
            } else if (i11 == 3) {
                bVar = b.Completed;
            } else if (i11 == 4) {
                bVar = b.MaybeLater;
            } else {
                return;
            }
            a(bVar);
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED)) {
            int i11 = jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED);
            a(i11 != 1 ? i11 != 2 ? i11 != 3 ? c.NOTHING : c.USER_UN_VOTED : c.USER_VOTED_UP : c.UPLOADED);
        }
    }

    public String a() {
        return this.f46544e;
    }

    public void a(int i11) {
        this.f46548i = i11;
    }

    public void a(long j11) {
        this.f46546g = j11;
    }

    public void a(b bVar) {
        this.f46543d = bVar;
    }

    public void a(c cVar) {
        this.f46553n = cVar;
    }

    public void a(String str) {
        this.f46544e = str;
    }

    public void a(boolean z11) {
        this.f46549j = z11;
    }

    public int b() {
        return this.f46548i;
    }

    public void b(int i11) {
        this.f46547h = i11;
    }

    public void b(long j11) {
        this.f46540a = j11;
    }

    public void b(String str) {
        this.f46545f = str;
    }

    public String c() {
        return this.f46545f;
    }

    public void c(String str) {
        this.f46542c = str;
    }

    public long d() {
        return this.f46546g;
    }

    public void d(String str) {
        this.f46541b = str;
    }

    public String e() {
        return this.f46542c;
    }

    public String f() {
        return this.f46552m;
    }

    public void fromJson(String str) {
        InstabugSDKLogger.v("IBG-FR", "Parsing feature request: " + str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            b(jSONObject.getLong("id"));
        }
        if (jSONObject.has("title")) {
            d(jSONObject.getString("title"));
        }
        if (jSONObject.has("description")) {
            c(jSONObject.getString("description"));
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME)) {
            b(jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME));
        }
        a(jSONObject);
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE)) {
            a(jSONObject.getString(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE));
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT)) {
            b(jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT));
        }
        if (jSONObject.has("date")) {
            a(jSONObject.getLong("date"));
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT)) {
            a(jSONObject.getInt(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT));
        }
        if (jSONObject.has(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED)) {
            a(jSONObject.getBoolean(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED));
        }
        b(jSONObject);
    }

    public long g() {
        return this.f46540a;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", (Object) m()).put("description", (Object) e());
        return jSONObject;
    }

    public int i() {
        return this.f46547h;
    }

    public String j() {
        return this.f46551l;
    }

    public String k() {
        return this.f46550k;
    }

    public b l() {
        return this.f46543d;
    }

    public String m() {
        return this.f46541b;
    }

    public c n() {
        return this.f46553n;
    }

    public boolean o() {
        return l() == b.Completed;
    }

    public boolean p() {
        return this.f46549j;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", g()).put("title", (Object) m()).put("description", (Object) e()).put("status", l().a()).put("date", d()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_LIKES_COUNT, i()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_COMMENTS_COUNT, b()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_IS_LIKED, p()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_VOTE_UPDATED, n().a()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_COLOR_CODE, (Object) a()).put(InstabugDbContract.FeatureRequestEntry.COLUMN_CREATOR_NAME, (Object) c());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}
