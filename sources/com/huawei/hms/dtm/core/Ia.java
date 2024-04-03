package com.huawei.hms.dtm.core;

import com.huawei.hms.dtm.core.util.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ia extends Y {
    private static String a(String str) {
        return g.a(str, "!'()*-._~");
    }

    private String a(List list, String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String obj = list.get(i11).toString();
            if (!z11) {
                obj = a(obj);
            }
            int size = list.size() - 1;
            sb2.append(obj);
            if (i11 < size) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    private List a(Map<String, ?> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(a((String) next.getKey()) + str + a(next.getValue().toString()));
        }
        return arrayList;
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        String str;
        if (list == null || list.size() == 0) {
            throw new V("__join#params error");
        }
        if (!(list.get(0) instanceof C0455wc)) {
            str = "";
        } else if (list.size() == 2) {
            str = a((List) list.get(0).value(), (String) list.get(1).value(), false);
        } else {
            throw new V("__join#params error");
        }
        if (list.get(0) instanceof C0465yc) {
            if (list.size() == 3) {
                str = a(a((Map<String, ?>) (Map) list.get(0).value(), (String) list.get(2).value()), (String) list.get(1).value(), true);
            } else {
                throw new V("__join#params error");
            }
        }
        return new Cc(str);
    }

    public String a() {
        return "__join";
    }
}
