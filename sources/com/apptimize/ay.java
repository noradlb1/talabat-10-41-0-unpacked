package com.apptimize;

import com.apptimize.ag;
import com.apptimize.as;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41288a = "ay";

    /* renamed from: b  reason: collision with root package name */
    private final au f41289b;

    /* renamed from: c  reason: collision with root package name */
    private final aw f41290c;

    /* renamed from: d  reason: collision with root package name */
    private final eg f41291d;

    /* renamed from: e  reason: collision with root package name */
    private ag f41292e;

    /* renamed from: f  reason: collision with root package name */
    private final fo f41293f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public dt f41294g = null;

    /* renamed from: h  reason: collision with root package name */
    private final String f41295h;

    /* renamed from: i  reason: collision with root package name */
    private final String f41296i;

    /* renamed from: j  reason: collision with root package name */
    private final fl f41297j = new fl();

    /* renamed from: k  reason: collision with root package name */
    private final Properties f41298k;

    public ay(String str, String str2, aw awVar, eg egVar, Properties properties, final au auVar) {
        Class<ay> cls = ay.class;
        this.f41295h = str;
        this.f41296i = str2;
        this.f41290c = awVar;
        this.f41291d = egVar;
        this.f41289b = auVar;
        this.f41298k = properties;
        try {
            this.f41292e = new ag.a(this).a("syncToNetwork", cls.getDeclaredMethod("b", new Class[0])).a("slowSchedulePost", cls.getDeclaredMethod(c.f41585a, new Class[0])).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f41288a, "Error binding", e11);
        }
        this.f41293f = auVar.b().a((fi) new fi() {
            public void run() {
                if (auVar.d().c() && ay.this.f41294g != null) {
                    ay.this.f41294g.o();
                }
            }
        });
    }

    private long d() {
        cj f11 = this.f41291d.f();
        this.f41297j.a(f11.g().longValue());
        long longValue = f11.f().longValue();
        try {
            Long i11 = as.i(this.f41298k);
            if (i11 != null) {
                longValue = i11.longValue();
            }
        } catch (as.a unused) {
        }
        return this.f41297j.b(longValue);
    }

    public void b() {
        this.f41297j.b();
        this.f41293f.a(d());
        this.f41292e.a("syncToNetwork", new Object[0]);
    }

    public void c() {
        this.f41293f.a(d());
        this.f41292e.a("slowSchedulePost", new Object[0]);
    }

    public void a(dt dtVar) {
        this.f41294g = dtVar;
    }

    public void a() {
        this.f41293f.b();
    }

    private static String a(List<JSONObject> list, String str, String str2, au auVar) throws JSONException {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < list.size(); i12 = i11) {
            String d11 = dp.d(list.get(i12));
            i11 = i12 + 1;
            while (i11 < list.size() && fx.a((Object) d11, (Object) dp.d(list.get(i11)))) {
                i11++;
            }
            List<JSONObject> subList = list.subList(i12, i11);
            a(subList);
            dp.a(subList);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "v4");
            jSONObject.put("schemaVersion", 4);
            jSONObject.put("a", (Object) str);
            jSONObject.put(c.f41585a, auVar.e().b());
            jSONObject.put("g", (Object) str2);
            if (d11 != null) {
                jSONObject.put("u", (Object) d11);
            }
            jSONObject.put("e", (Object) new JSONArray((Collection<?>) subList));
            jSONObject.put("v", (Object) "Android " + fx.a());
            sb2.append(JSONObjectInstrumentation.toString(jSONObject));
        }
        return sb2.toString();
    }

    public HttpURLConnection a(List<String> list, List<JSONObject> list2) {
        try {
            HttpURLConnection a11 = a(this.f41290c, list, a(list2, this.f41295h, this.f41296i, this.f41289b), this.f41297j);
            if (a11 != null) {
                return a11;
            }
            bo.j(f41288a, "Unable to post to server; will try again shortly.");
            this.f41293f.a(d());
            return null;
        } catch (JSONException e11) {
            bo.e(f41288a, "Unable to serialize post to server.", e11);
            return null;
        }
    }

    private static void a(List<JSONObject> list) throws JSONException {
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        JSONObject jSONObject3 = null;
        for (JSONObject next : list) {
            JSONObject optJSONObject = next.optJSONObject("dp");
            if (a(jSONObject, optJSONObject)) {
                next.put("dp", (Object) null);
            } else {
                jSONObject = optJSONObject;
            }
            JSONObject optJSONObject2 = next.optJSONObject("ua");
            if (a(jSONObject2, optJSONObject2)) {
                next.put("ua", (Object) null);
            } else {
                jSONObject2 = optJSONObject2;
            }
            JSONObject optJSONObject3 = next.optJSONObject("pa");
            if (a(jSONObject3, optJSONObject3)) {
                next.put("pa", (Object) null);
            } else {
                jSONObject3 = optJSONObject3;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            r0 = 1
            if (r5 != r6) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 == 0) goto L_0x0039
            if (r6 != 0) goto L_0x000a
            goto L_0x0039
        L_0x000a:
            int r2 = r5.length()
            int r3 = r6.length()
            if (r2 == r3) goto L_0x0015
            return r1
        L_0x0015:
            java.util.Iterator r2 = r5.keys()
        L_0x0019:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0038
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = r5.optString(r3)
            java.lang.String r3 = r6.optString(r3)
            if (r4 == 0) goto L_0x0037
            if (r3 == 0) goto L_0x0037
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0019
        L_0x0037:
            return r1
        L_0x0038:
            return r0
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ay.a(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    private static HttpURLConnection a(aw awVar, List<String> list, String str, fl flVar) {
        ArrayList<String> arrayList = new ArrayList<>(list);
        Collections.shuffle(arrayList);
        for (String str2 : arrayList) {
            String str3 = str2 + "v4/";
            String str4 = f41288a;
            bo.f(str4, "Starting post of results to server.");
            bo.f(str4, "Posting to " + str3 + ": " + str);
            HttpURLConnection a11 = awVar.a(str3, str, flVar);
            if (a11 != null) {
                bo.h(str4, "Successfully posted results to server.");
                return a11;
            }
            bo.h(str4, "Posting failed to " + str3);
        }
        bo.j(f41288a, "Unable to post results at this time.");
        return null;
    }
}
