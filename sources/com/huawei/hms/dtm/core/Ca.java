package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.util.List;

public class Ca extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1 || list.get(0) == null) {
            throw new V("__getup#wrong params");
        }
        String userProfile = x11.getUserProfile(list.get(0).toString());
        return TextUtils.isEmpty(userProfile) ? C0470zc.f48641a : new Cc(userProfile);
    }

    public String a() {
        return "__getup";
    }
}
