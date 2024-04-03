package com.huawei.hms.dtm.core;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ra  reason: case insensitive filesystem */
public class C0428ra extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1) {
            throw new V("__decodeuri#wrong params");
        }
        C0435sc scVar = list.get(0);
        if (scVar instanceof Cc) {
            try {
                return new Cc(URLDecoder.decode(scVar.toString(), "utf-8"));
            } catch (UnsupportedEncodingException unused) {
                throw new V("__decodeuri#parse failure");
            }
        } else {
            throw new V("__decodeuri#param type error");
        }
    }

    public String a() {
        return "__decodeuri";
    }
}
