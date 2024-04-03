package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.IOException;
import java.util.List;

public class Kb extends Y {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48328a = false;

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (x11 != null) {
            Context c11 = x11.c();
            if (c11 != null) {
                try {
                    this.f48328a = AdvertisingIdClient.getAdvertisingIdInfo(c11).isLimitAdTrackingEnabled();
                } catch (IOException e11) {
                    Logger.warn("DTM-Execute", "IfOaidTrackLimitExecutor#" + e11.getMessage());
                }
                return C0430rc.a(this.f48328a);
            }
            throw new V("oaidTrackLimit#appContext null");
        }
        throw new V("oaidTrackLimit#params error");
    }

    public String a() {
        return "oaidTrackLimit";
    }
}
