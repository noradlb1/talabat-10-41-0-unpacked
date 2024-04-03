package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;

public class Gb extends Y {
    private boolean a(List<C0435sc<?>> list) {
        return list == null || list.size() != 3 || list.get(0) == null || list.get(1) == null || list.get(2) == null;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (!a(list)) {
            String a11 = C0421pd.a(list.get(2).toString(), list.get(0).toString(), list.get(1).toString());
            return TextUtils.isEmpty(a11) ? Cc.f48270b : new Cc(a11);
        }
        throw new V("grsUrl#wrong params");
    }

    public String a() {
        return "grsUrl";
    }
}
