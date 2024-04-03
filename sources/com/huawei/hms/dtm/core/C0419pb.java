package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.pb  reason: case insensitive filesystem */
public class C0419pb extends Y {

    /* renamed from: a  reason: collision with root package name */
    private String f48538a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f48539b;

    /* renamed from: c  reason: collision with root package name */
    private List<Bc> f48540c;

    public C0419pb(String str, List<String> list, List<Bc> list2) {
        this.f48538a = str;
        this.f48539b = list;
        this.f48540c = list2;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.size() >= this.f48539b.size()) {
            X a11 = x11.a();
            for (int i11 = 0; i11 < this.f48539b.size(); i11++) {
                a11.a(this.f48539b.get(i11), list.get(i11));
            }
            for (Bc a12 : this.f48540c) {
                C0435sc<?> a13 = C0343aa.a(a11, a12);
                if (a13 instanceof C0445uc) {
                    C0445uc ucVar = (C0445uc) a13;
                    if (ucVar.e()) {
                        return ucVar.value();
                    }
                }
            }
            return Ec.f48288a;
        }
        throw new V("Input params less than function params");
    }

    public String a() {
        return this.f48538a;
    }
}
