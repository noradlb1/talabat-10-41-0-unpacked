package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.report.b;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wa extends Y {

    /* renamed from: a  reason: collision with root package name */
    private final b f48431a;

    public Wa(b bVar) {
        this.f48431a = bVar;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1) {
            throw new V("__request#params error");
        }
        Map hashMap = new HashMap();
        C0435sc scVar = list.get(0);
        if (scVar instanceof C0455wc) {
            for (C0435sc scVar2 : ((C0455wc) scVar).value()) {
                if (scVar2 instanceof C0465yc) {
                    hashMap = ((C0465yc) scVar2).d();
                }
            }
        }
        String str = hashMap.get("method") instanceof String ? (String) hashMap.get("method") : "";
        if (TextUtils.isEmpty(str)) {
            str = "POST";
        }
        this.f48431a.a((String) hashMap.get("url"), str, (String) null, (Map) hashMap.get(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS), (String) hashMap.get("body"));
        return new C0465yc(hashMap);
    }

    public String a() {
        return "__request";
    }
}
