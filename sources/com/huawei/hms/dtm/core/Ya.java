package com.huawei.hms.dtm.core;

import android.os.Bundle;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ya extends Y {
    private void a(Bundle bundle, Map<String, Object> map) {
        if (bundle != null && map != null) {
            SafeBundle safeBundle = new SafeBundle(bundle);
            for (String next : safeBundle.keySet()) {
                if (next != null && next.startsWith("$HA_")) {
                    map.put(next, safeBundle.get(next));
                }
            }
        }
    }

    private void b(Map<String, Object> map) {
        if (map != null) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next().getKey();
                if (str != null && str.startsWith("$DTM_VP_")) {
                    it.remove();
                }
            }
        }
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list.size() != 2 || !(list.get(0) instanceof Cc) || !(list.get(1) instanceof C0465yc)) {
            throw new V("__send2ha#params error");
        }
        Map value = ((C0465yc) list.get(1)).value();
        a(x11.b(), (Map<String, Object>) value);
        b(value);
        x11.onEventExecuted((String) ((Cc) list.get(0)).value(), C0343aa.a((Map<String, Object>) value));
        C0391jd.a().a(DynamicTagManager.getInstance().getConfigurationID()).e("HA").c("200").b();
        return Ec.f48288a;
    }

    public String a() {
        return "__send2ha";
    }
}
