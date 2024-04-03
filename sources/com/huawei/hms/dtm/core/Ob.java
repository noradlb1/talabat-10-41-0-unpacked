package com.huawei.hms.dtm.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.IOException;
import java.util.List;

public class Ob extends Y {

    /* renamed from: a  reason: collision with root package name */
    private String f48377a = "";

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                try {
                    this.f48377a = AdvertisingIdClient.getAdvertisingIdInfo(c11).getId();
                } catch (IOException e11) {
                    Logger.warn("DTM-Execute", "OaidExecutor#" + e11.getMessage());
                }
                return TextUtils.isEmpty(this.f48377a) ? Cc.f48270b : new Cc(this.f48377a);
            }
            throw new V("oaid#appContext null");
        }
        throw new V("oaid#params error");
    }

    public String a() {
        return "oaid";
    }
}
