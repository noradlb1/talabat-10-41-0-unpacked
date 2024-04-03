package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pc implements Qc<Wc<?>> {

    /* renamed from: a  reason: collision with root package name */
    private String f48382a;

    /* renamed from: b  reason: collision with root package name */
    private String f48383b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Wc<?>> f48384c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Wc<?>> f48385d = new HashMap();

    public C0435sc<?> a(X x11) throws V {
        if (!TextUtils.isEmpty(this.f48382a)) {
            C0348ba executable = DynamicTagManager.getInstance().getExecutable(this.f48382a);
            if (executable != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new C0465yc(this.f48384c));
                return executable.a(x11, arrayList);
            }
            throw new V("Function :" + this.f48382a + " not exist");
        }
        throw new V("Function :" + this.f48382a + " not exist");
    }

    public Map<String, Wc<?>> a() {
        return this.f48385d;
    }

    public void a(String str) {
        this.f48382a = str;
    }

    public void a(String str, Wc<?> wc2) {
        this.f48385d.put(str, wc2);
    }

    public void a(Map<String, Wc<?>> map) {
        this.f48384c.putAll(map);
    }

    public String b() {
        return this.f48382a;
    }

    public void b(String str) {
        this.f48383b = str;
    }

    public String getName() {
        return this.f48383b;
    }

    public Map<String, Wc<?>> getParams() {
        return this.f48384c;
    }
}
