package com.huawei.hms.dtm.core;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

@Instrumented
/* renamed from: com.huawei.hms.dtm.core.wc  reason: case insensitive filesystem */
public class C0455wc implements C0435sc<List<C0435sc<?>>> {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0435sc<?>> f48629a;

    public C0455wc(List<C0435sc<?>> list) {
        ArrayList arrayList = new ArrayList();
        this.f48629a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public String a() {
        ArrayList arrayList = new ArrayList();
        Iterator<C0435sc<?>> it = this.f48629a.iterator();
        while (it.hasNext()) {
            C0435sc next = it.next();
            arrayList.add(next != null ? next.a() : "");
        }
        return JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) arrayList));
    }

    public boolean b() {
        return true;
    }

    public Double c() {
        return this.f48629a.isEmpty() ? Double.valueOf(0.0d) : (this.f48629a.size() != 1 || this.f48629a.get(0) == null) ? Double.valueOf(Double.NaN) : this.f48629a.get(0).c();
    }

    public List<Object> d() {
        ArrayList arrayList = new ArrayList();
        for (C0435sc<?> d11 : this.f48629a) {
            arrayList.add(d11.d());
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<C0435sc<?>> it = this.f48629a.iterator();
        while (it.hasNext()) {
            C0435sc next = it.next();
            if (sb2.length() != 0) {
                sb2.append(",");
            }
            sb2.append(next == null ? "" : next.toString());
        }
        return sb2.toString();
    }

    public List<C0435sc<?>> value() {
        return this.f48629a;
    }
}
