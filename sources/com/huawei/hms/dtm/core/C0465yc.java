package com.huawei.hms.dtm.core;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

@Instrumented
/* renamed from: com.huawei.hms.dtm.core.yc  reason: case insensitive filesystem */
public class C0465yc implements C0435sc<Map<String, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f48637a;

    public C0465yc(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        this.f48637a = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public C0435sc<?> a(String str) {
        Map<String, Object> map = this.f48637a;
        if (map == null) {
            return C0470zc.f48641a;
        }
        Object obj = map.get(str);
        return obj instanceof C0435sc ? (C0435sc) obj : C0470zc.f48641a;
    }

    public String a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f48637a.entrySet()) {
            hashMap.put(next.getKey(), next.getValue() != null ? next.getValue() instanceof C0435sc ? ((C0435sc) next.getValue()).a() : String.valueOf(next.getValue()) : "");
        }
        return JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) hashMap));
    }

    public boolean b() {
        return true;
    }

    public Double c() {
        throw new V("map to double");
    }

    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f48637a.entrySet()) {
            if (next.getValue() instanceof C0435sc) {
                hashMap.put(next.getKey(), ((C0435sc) next.getValue()).d());
            } else {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return hashMap;
    }

    public String toString() {
        TreeMap treeMap = new TreeMap();
        for (String next : this.f48637a.keySet()) {
            C0435sc<?> a11 = a(String.valueOf(next));
            treeMap.put(String.valueOf(next), a11 == null ? "" : a11.toString());
        }
        return treeMap.toString();
    }

    public Map<String, Object> value() {
        return this.f48637a;
    }
}
