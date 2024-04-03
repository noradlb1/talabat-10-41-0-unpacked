package com.huawei.hms.dtm.core;

import android.os.Bundle;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.ya  reason: case insensitive filesystem */
public class C0463ya extends Y {
    private C0435sc<?> a(Object obj) {
        if (obj == null) {
            return C0470zc.f48641a;
        }
        if (obj instanceof Ac) {
            return a(((Ac) obj).value());
        }
        if (obj instanceof C0435sc) {
            return (C0435sc) obj;
        }
        if (obj instanceof Bundle) {
            return new Ac(obj);
        }
        if (obj instanceof String) {
            return new Cc((String) obj);
        }
        if (obj instanceof Boolean) {
            return C0430rc.a(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Double) {
            return new C0440tc((Double) obj);
        }
        if (obj instanceof Integer) {
            return new C0450vc((Integer) obj);
        }
        if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (true) {
                List list = (List) obj;
                if (i11 >= list.size()) {
                    return new C0455wc(arrayList);
                }
                arrayList.add(a(list.get(i11)));
                i11++;
            }
        } else if (!(obj instanceof Map)) {
            return new Ac(obj);
        } else {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
            return new C0465yc(hashMap);
        }
    }

    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        Object obj;
        if (list.size() == 2) {
            C0435sc scVar = list.get(1);
            if (scVar instanceof Cc) {
                C0435sc scVar2 = list.get(0);
                if (scVar2 instanceof C0465yc) {
                    Object obj2 = ((C0465yc) scVar2).value().get((String) ((Cc) scVar).value());
                    if (!(obj2 instanceof Wc)) {
                        return a(obj2);
                    }
                    obj = ((Wc) obj2).a(x11);
                } else if (scVar2 instanceof Ac) {
                    Ac ac2 = (Ac) scVar2;
                    if (ac2.value() instanceof Bundle) {
                        obj = new SafeBundle((Bundle) ac2.value()).get(scVar.toString());
                    } else {
                        throw new V("__getmap#not bundle");
                    }
                } else {
                    throw new V("__getmap#invalid type");
                }
                return a(obj);
            }
            throw new V("__getmap#key not string");
        }
        throw new V("__getmap#size not 2");
    }

    public String a() {
        return "__getmap";
    }
}
