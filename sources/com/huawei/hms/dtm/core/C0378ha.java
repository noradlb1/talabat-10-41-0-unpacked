package com.huawei.hms.dtm.core;

import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ha  reason: case insensitive filesystem */
public class C0378ha extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        int i11;
        if (list.isEmpty()) {
            return Cc.f48270b;
        }
        if (!(list.get(0) instanceof Cc)) {
            return Cc.f48270b;
        }
        String str = (String) ((Cc) list.get(0)).value();
        if (list.size() == 1) {
            return new Cc(String.valueOf(str.charAt(0)));
        }
        if (list.get(1) instanceof C0450vc) {
            i11 = ((Integer) ((C0450vc) list.get(1)).value()).intValue();
        } else if (!(list.get(1) instanceof Cc)) {
            return Cc.f48270b;
        } else {
            try {
                i11 = Integer.parseInt((String) ((Cc) list.get(1)).value());
            } catch (NumberFormatException unused) {
                throw new V("__charat#wrong params index type");
            }
        }
        if (i11 < 0) {
            i11 += str.length();
        }
        return (i11 < 0 || i11 > str.length()) ? Cc.f48270b : new Cc(String.valueOf(str.charAt(i11)));
    }

    public String a() {
        return "__charat";
    }
}
