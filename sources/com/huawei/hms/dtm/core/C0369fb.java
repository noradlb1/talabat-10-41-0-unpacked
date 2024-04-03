package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.fb  reason: case insensitive filesystem */
public class C0369fb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.size() != 3) {
            throw new V("__switch#params size not 3");
        } else if (!(list.get(1) instanceof C0455wc) || !(list.get(2) instanceof C0455wc)) {
            throw new V("__switch#wrong params type");
        } else {
            List value = ((C0455wc) list.get(1)).value();
            List value2 = ((C0455wc) list.get(2)).value();
            if (value2.size() == value.size() || value2.size() == value.size() + 1) {
                int i11 = 0;
                C0435sc<?> a11 = C0343aa.a(x11, list.get(0));
                while (true) {
                    if (i11 >= value.size()) {
                        i11 = -1;
                        break;
                    } else if (C0353ca.a(a11, C0343aa.a(x11, (C0435sc<?>) (C0435sc) value.get(i11)))) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 == -1) {
                    i11 = value.size();
                }
                while (i11 < value2.size()) {
                    if (value2.get(i11) instanceof C0455wc) {
                        C0435sc<?> a12 = C0343aa.a(x11, (List<C0435sc<?>>) ((C0455wc) value2.get(i11)).value());
                        if (a12 instanceof C0445uc) {
                            if (((C0445uc) a12).e()) {
                                return a12;
                            }
                            if (a12 == C0445uc.f48607a) {
                                return Ec.f48288a;
                            }
                        }
                        i11++;
                    } else {
                        throw new V("__switch#wrong executor type");
                    }
                }
                return Ec.f48288a;
            }
            throw new V("__switch#case list error");
        }
    }

    public String a() {
        return "__switch";
    }
}
