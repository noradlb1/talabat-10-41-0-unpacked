package com.instabug.featuresrequest.models;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public class g extends i {

    /* renamed from: c  reason: collision with root package name */
    private b f46559c;

    /* renamed from: d  reason: collision with root package name */
    private b f46560d;

    /* renamed from: e  reason: collision with root package name */
    private String f46561e = "#000000";

    /* renamed from: f  reason: collision with root package name */
    private String f46562f = "#000000";

    public g() {
        b bVar = b.Open;
        this.f46559c = bVar;
        this.f46560d = bVar;
    }

    public void a(b bVar) {
        this.f46560d = bVar;
    }

    public void a(String str) {
        this.f46561e = str;
    }

    public void b(b bVar) {
        this.f46559c = bVar;
    }

    public void b(String str) {
        this.f46562f = str;
    }

    public b c() {
        return this.f46560d;
    }

    public String d() {
        return this.f46561e;
    }

    public b e() {
        return this.f46559c;
    }

    public String f() {
        return this.f46562f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fromJson(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "IBG-FR"
            com.instabug.library.util.InstabugSDKLogger.v(r0, r7)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>((java.lang.String) r7)
            java.lang.String r7 = "created_at"
            boolean r1 = r0.has(r7)
            if (r1 == 0) goto L_0x0019
            long r1 = r0.getLong(r7)
            r6.a((long) r1)
        L_0x0019:
            java.lang.String r7 = "type"
            boolean r1 = r0.has(r7)
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0055
            java.lang.String r7 = r0.getString(r7)
            int r1 = r7.hashCode()
            r4 = -144558306(0xfffffffff762371e, float:-4.5881914E33)
            if (r1 == r4) goto L_0x0040
            r4 = 950398559(0x38a5ee5f, float:7.912213E-5)
            if (r1 == r4) goto L_0x0036
            goto L_0x004a
        L_0x0036:
            java.lang.String r1 = "comment"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x004a
            r7 = r2
            goto L_0x004b
        L_0x0040:
            java.lang.String r1 = "state_change"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x004a
            r7 = r3
            goto L_0x004b
        L_0x004a:
            r7 = -1
        L_0x004b:
            if (r7 == r3) goto L_0x0050
            com.instabug.featuresrequest.models.h r7 = com.instabug.featuresrequest.models.h.COMMENT
            goto L_0x0052
        L_0x0050:
            com.instabug.featuresrequest.models.h r7 = com.instabug.featuresrequest.models.h.STATUS_CHANE
        L_0x0052:
            r6.a((com.instabug.featuresrequest.models.h) r7)
        L_0x0055:
            java.lang.String r7 = "old_status"
            boolean r1 = r0.has(r7)
            r4 = 4
            r5 = 3
            if (r1 == 0) goto L_0x007f
            int r7 = r0.getInt(r7)
            if (r7 == 0) goto L_0x007a
            if (r7 == r2) goto L_0x0077
            if (r7 == r3) goto L_0x0074
            if (r7 == r5) goto L_0x0071
            if (r7 == r4) goto L_0x006e
            goto L_0x007f
        L_0x006e:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.MaybeLater
            goto L_0x007c
        L_0x0071:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Completed
            goto L_0x007c
        L_0x0074:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.InProgress
            goto L_0x007c
        L_0x0077:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Planned
            goto L_0x007c
        L_0x007a:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Open
        L_0x007c:
            r6.b((com.instabug.featuresrequest.models.b) r7)
        L_0x007f:
            java.lang.String r7 = "new_status"
            boolean r1 = r0.has(r7)
            if (r1 == 0) goto L_0x00a7
            int r7 = r0.getInt(r7)
            if (r7 == 0) goto L_0x00a2
            if (r7 == r2) goto L_0x009f
            if (r7 == r3) goto L_0x009c
            if (r7 == r5) goto L_0x0099
            if (r7 == r4) goto L_0x0096
            goto L_0x00a7
        L_0x0096:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.MaybeLater
            goto L_0x00a4
        L_0x0099:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Completed
            goto L_0x00a4
        L_0x009c:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.InProgress
            goto L_0x00a4
        L_0x009f:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Planned
            goto L_0x00a4
        L_0x00a2:
            com.instabug.featuresrequest.models.b r7 = com.instabug.featuresrequest.models.b.Open
        L_0x00a4:
            r6.a((com.instabug.featuresrequest.models.b) r7)
        L_0x00a7:
            java.lang.String r7 = "new_status_color"
            boolean r1 = r0.has(r7)
            if (r1 == 0) goto L_0x00b6
            java.lang.String r7 = r0.getString(r7)
            r6.a((java.lang.String) r7)
        L_0x00b6:
            java.lang.String r7 = "old_status_color"
            boolean r1 = r0.has(r7)
            if (r1 == 0) goto L_0x00c5
            java.lang.String r7 = r0.getString(r7)
            r6.b((java.lang.String) r7)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.models.g.fromJson(java.lang.String):void");
    }

    public String toJson() {
        JSONObject put = new JSONObject().put("created_at", a()).put("type", (Object) b()).put("old_status", e().a()).put("new_status", c().a()).put("old_status_color", (Object) f()).put("new_status_color", (Object) d());
        return !(put instanceof JSONObject) ? put.toString() : JSONObjectInstrumentation.toString(put);
    }
}
