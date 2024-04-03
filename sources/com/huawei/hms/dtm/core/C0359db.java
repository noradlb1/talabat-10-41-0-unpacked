package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.db  reason: case insensitive filesystem */
public class C0359db extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.size() == 0 || list.size() > 3) {
            throw new V("__substring#wrong params size");
        }
        int i11 = 0;
        if (list.get(0) instanceof Cc) {
            String str = (String) ((Cc) list.get(0)).value();
            if (TextUtils.isEmpty(str)) {
                return Cc.f48270b;
            }
            int length = str.length();
            if (list.size() <= 1 || list.get(1) == null || ((i11 = (int) list.get(1).c().doubleValue()) >= 0 && i11 < length)) {
                int length2 = str.length();
                if (list.size() > 2 && list.get(2) != null && ((length2 = (int) list.get(2).c().doubleValue()) < 0 || length2 > length)) {
                    throw new V("__substring#start index error");
                } else if (i11 <= length2) {
                    try {
                        return new Cc(str.substring(i11, length2));
                    } catch (StringIndexOutOfBoundsException unused) {
                        throw new V("__substring#start index out of bounds");
                    }
                } else {
                    throw new V("__substring#start index must less than end index");
                }
            } else {
                throw new V("__substring#start index error");
            }
        } else {
            throw new V("__substring#wrong params type");
        }
    }

    public String a() {
        return "__substring";
    }
}
