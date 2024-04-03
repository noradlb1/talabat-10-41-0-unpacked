package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.qb  reason: case insensitive filesystem */
public class C0424qb extends Y {

    /* renamed from: a  reason: collision with root package name */
    private String f48544a = "";

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                this.f48544a = HmsInstanceId.getInstance(c11).getId();
                Logger.info("DTM-Execute", "get aaid success");
                return new Cc(this.f48544a);
            }
            throw new V("aaid#appContext null");
        }
        throw new V("aaid#params error");
    }

    public String a() {
        return "aaid";
    }
}
