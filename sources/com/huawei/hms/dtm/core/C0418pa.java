package com.huawei.hms.dtm.core;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.dtm.core.report.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.huawei.hms.dtm.core.pa  reason: case insensitive filesystem */
public class C0418pa extends Y {

    /* renamed from: a  reason: collision with root package name */
    private final b f48537a;

    public C0418pa(b bVar) {
        this.f48537a = bVar;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        String str;
        boolean z11 = true;
        Preconditions.checkArgument((list == null || list.size() <= 0 || list.get(0) == null) ? false : true, "customUrl#params error");
        C0435sc scVar = list.get(0);
        Preconditions.checkArgument(scVar instanceof Cc, "customUrl#params error");
        Uri.Builder buildUpon = Uri.parse(scVar.toString()).buildUpon();
        if (list.size() == 1) {
            this.f48537a.a(buildUpon.build().toString());
        } else {
            String scVar2 = list.get(1).toString();
            Object obj = list.size() > 2 ? list.get(2) : C0470zc.f48641a;
            String scVar3 = list.size() > 3 ? list.get(3).toString() : null;
            C0470zc zcVar = C0470zc.f48641a;
            if (obj != zcVar && !(obj instanceof C0465yc)) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "customUrl#params error");
            if (TextUtils.isEmpty(scVar2) || scVar2.toUpperCase(Locale.ENGLISH).equals("GET")) {
                if (obj != zcVar) {
                    for (Map.Entry entry : ((C0465yc) obj).value().entrySet()) {
                        buildUpon.appendQueryParameter((String) entry.getKey(), entry.getValue() == null ? "" : entry.getValue().toString());
                    }
                }
                this.f48537a.a(buildUpon.build().toString(), scVar3);
            } else if (scVar2.equals("POST")) {
                if (obj instanceof C0465yc) {
                    Map d11 = ((C0465yc) obj).d();
                    if (d11.size() != 0) {
                        str = JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) d11));
                        String uri = buildUpon.build().toString();
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        this.f48537a.a(uri, scVar2, scVar3, hashMap, str);
                    }
                }
                str = "";
                String uri2 = buildUpon.build().toString();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Content-Type", "application/json");
                this.f48537a.a(uri2, scVar2, scVar3, hashMap2, str);
            } else {
                throw new V("Illegal request method " + scVar2);
            }
        }
        return Ec.f48288a;
    }

    public String a() {
        return "customUrl";
    }
}
