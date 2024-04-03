package com.uxcam.internals;

import com.checkout.logging.utils.LoggingAttributesKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class as {

    /* renamed from: a  reason: collision with root package name */
    public static final aa f13011a = new aa();

    public static class ab {
        public static JSONObject a() {
            JSONObject a11 = as.f13011a.a();
            boolean z11 = ho.f13585c;
            ep epVar = new ep(a11, z11);
            if (!z11) {
                return null;
            }
            if (!epVar.f13290b.has("totalCallCount")) {
                fz fzVar = new fz();
                fzVar.a("site_of_error", "PreUploadConditionChecker");
                fzVar.a("Key { totalCallCount } was not found in the data to be sent.").a(4);
                return epVar.f13290b;
            }
            int i11 = epVar.f13290b.getInt("totalCallCount");
            if (i11 == 0) {
                JSONObject jSONObject = new JSONObject();
                epVar.f13290b = jSONObject;
                jSONObject.put("totalCallCount", i11);
            }
            return epVar.f13290b;
        }
    }

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        int i11 = jSONObject.getInt(LoggingAttributesKt.HTTP_STATUS_CODE);
        String string = jSONObject.getString(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL);
        aa aaVar = f13011a;
        aaVar.f13015d++;
        aaVar.f13012a.add(jSONObject.getString(AnalyticsAttribute.REQUEST_URL_ATTRIBUTE));
        if (i11 != -1 || !string.isEmpty()) {
            aaVar.a(jSONObject.getLong("callDurationMs"), false);
        } else {
            aaVar.f13016e++;
            aaVar.a(jSONObject.getLong("callDurationMs"), true);
        }
        aaVar.f13014c.a(jSONObject.getLong("responseSizeBytes"));
        try {
            JSONObject a11 = aaVar.a();
            if (!(a11 instanceof JSONObject)) {
                a11.toString();
            } else {
                JSONObjectInstrumentation.toString(a11);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public final Set f13012a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public final ai f13013b = new ai(new int[]{10, 200, 500, 1000, 2000, 5000});

        /* renamed from: c  reason: collision with root package name */
        public final ai f13014c = new ai(new int[]{100, 500, 2000, 10000, 50000});

        /* renamed from: d  reason: collision with root package name */
        public int f13015d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13016e = 0;

        /* renamed from: f  reason: collision with root package name */
        public long f13017f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f13018g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f13019h = Long.MAX_VALUE;

        public void a(long j11, boolean z11) {
            this.f13017f += j11;
            if (j11 > this.f13018g && !z11) {
                this.f13018g = j11;
            }
            if (j11 < this.f13019h && !z11) {
                this.f13019h = j11;
            }
            this.f13013b.a(j11);
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("totalCallCount", this.f13015d);
            jSONObject.put("failedCallCount", this.f13016e);
            jSONObject.put("longestCallDurationMs", this.f13018g);
            long j11 = this.f13019h;
            if (j11 == Long.MAX_VALUE) {
                jSONObject.put("shortestCallDurationMs", 0);
            } else {
                jSONObject.put("shortestCallDurationMs", j11);
            }
            int i11 = this.f13015d;
            if (i11 > 0) {
                jSONObject.put("averageCallDurationMs", this.f13017f / ((long) i11));
            } else {
                jSONObject.put("averageCallDurationMs", this.f13017f);
            }
            jSONObject.put("durationData", (Object) this.f13013b.a());
            jSONObject.put("responseSizeData", (Object) this.f13014c.a());
            JSONArray jSONArray = new JSONArray();
            for (String put : this.f13012a) {
                jSONArray.put((Object) put);
            }
            jSONObject.put("uniqueHosts", (Object) jSONArray);
            return jSONObject;
        }
    }
}
