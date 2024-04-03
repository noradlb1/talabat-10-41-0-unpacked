package com.huawei.hms.dtm.core.report;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.C0442u;
import com.huawei.hms.dtm.core.Q;
import com.huawei.hms.dtm.core.util.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

@Instrumented
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f48582a = Executors.newSingleThreadExecutor(new C0442u("DTM-Request"));

    /* renamed from: b  reason: collision with root package name */
    private a f48583b;

    public j(a aVar) {
        this.f48583b = aVar;
    }

    public final void a(String str) {
        Q q11 = new Q();
        q11.a(System.currentTimeMillis());
        q11.c("GET");
        q11.e(str);
        f48582a.execute(new k(this.f48583b, q11));
    }

    public final void a(String str, String str2) {
        Q q11 = new Q();
        q11.a(System.currentTimeMillis());
        q11.c("GET");
        q11.e(str);
        if (!TextUtils.isEmpty(str2)) {
            q11.d(str2);
        }
        f48582a.execute(new k(this.f48583b, q11));
    }

    public final void a(String str, String str2, String str3, Map<String, String> map, String str4) {
        Q q11 = new Q();
        q11.a(System.currentTimeMillis());
        q11.d(str3);
        q11.a(str4);
        q11.c(str2);
        if (map != null && map.size() > 0) {
            q11.b(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) map)));
        }
        q11.e(str);
        Logger.test("save request: " + MessageFormat.format("method:{0} url:{1} header:{2} body:{3}", new Object[]{str2, str, q11.d(), str4}));
        f48582a.execute(new k(this.f48583b, q11));
    }
}
