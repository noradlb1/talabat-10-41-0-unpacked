package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.Logger;
import java.util.List;

/* renamed from: com.huawei.hms.dtm.core.ac  reason: case insensitive filesystem */
public class C0345ac extends Y {
    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        String str;
        if (list != null && list.size() == 2) {
            boolean z11 = false;
            if (!(list.get(0) == null || list.get(1) == null)) {
                Double c11 = list.get(0).c();
                if (Double.isNaN(c11.doubleValue())) {
                    str = list.get(0).toString() + " can not to compare as a number.";
                } else {
                    Double c12 = list.get(1).c();
                    if (Double.isNaN(c12.doubleValue())) {
                        str = list.get(1).toString() + " can not to compare as a number.";
                    } else {
                        if (Double.compare(c11.doubleValue(), c12.doubleValue()) > 0) {
                            z11 = true;
                        }
                        return C0430rc.a(z11);
                    }
                }
                Logger.error("DTM-Execute", str);
                return C0430rc.a(false);
            }
        }
        throw new V("_gt#wrong params");
    }

    public String a() {
        return "_gt";
    }
}
