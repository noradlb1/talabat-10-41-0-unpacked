package com.iab.omid.library.deliveryhero3.walking.async;

import com.iab.omid.library.deliveryhero3.adsession.a;
import com.iab.omid.library.deliveryhero3.internal.c;
import com.iab.omid.library.deliveryhero3.walking.async.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import org.json.JSONObject;

@Instrumented
public class e extends a {
    public e(b.C0053b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(bVar, hashSet, jSONObject, j11);
    }

    private void b(String str) {
        c c11 = c.c();
        if (c11 != null) {
            for (a next : c11.b()) {
                if (this.f45030c.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().a(str, this.f45032e);
                }
            }
        }
    }

    /* renamed from: c */
    public void onPostExecute(String str) {
        b(str);
        super.c(str);
    }

    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        JSONObject jSONObject = this.f45031d;
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }
}
