package com.huawei.hms.dtm.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Cb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null) {
            String valueOf = list.size() == 0 ? "ms" : String.valueOf(list.get(0));
            long currentTimeMillis = System.currentTimeMillis();
            if (!valueOf.equals("ms")) {
                if (valueOf.equals("s")) {
                    currentTimeMillis /= 1000;
                } else {
                    throw new V("deviceTime#unsupported unit");
                }
            }
            String valueOf2 = String.valueOf(currentTimeMillis);
            String scVar = (list.size() <= 1 || list.get(1) == null) ? null : list.get(1).toString();
            if (scVar != null && !"".equals(scVar)) {
                valueOf2 = new SimpleDateFormat(scVar).format(new Date(currentTimeMillis));
            }
            return new Cc(valueOf2);
        }
        throw new V("deviceTime#params error");
    }

    public String a() {
        return "deviceTime";
    }
}
