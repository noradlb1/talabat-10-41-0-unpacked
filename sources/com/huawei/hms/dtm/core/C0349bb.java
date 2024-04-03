package com.huawei.hms.dtm.core;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.huawei.hms.dtm.core.bb  reason: case insensitive filesystem */
public class C0349bb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || x11 == null || list.size() != 1 || list.get(0) == null) {
            throw new V("__stringify#wrong params");
        }
        Object d11 = list.get(0).d();
        return d11 instanceof Map ? new Cc(JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) (Map) d11))) : d11 instanceof List ? new Cc(JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) (List) d11))) : d11 != null ? new Cc(d11.toString()) : C0470zc.f48641a;
    }

    public String a() {
        return "__stringify";
    }
}
