package com.apptimize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ej {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42298a = "ej";

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, List<ApptimizeVar<?>>> f42299b = new HashMap();

    public static synchronized <T> ApptimizeVar<T> a(ApptimizeVar<T> apptimizeVar) {
        synchronized (ej.class) {
            String e11 = k.e(apptimizeVar);
            Map<String, List<ApptimizeVar<?>>> map = f42299b;
            if (map.containsKey(e11)) {
                String str = f42298a;
                bo.f(str, "Note that the same ApptimizeVar was created more than once: " + bt.a(e11));
            } else {
                map.put(e11, new ArrayList());
            }
            for (ApptimizeVar<T> apptimizeVar2 : map.get(e11)) {
                if (k.a(apptimizeVar) == null) {
                    if (k.a(apptimizeVar2) == null) {
                        return apptimizeVar2;
                    }
                } else if (k.a(apptimizeVar).equals(k.a(apptimizeVar2))) {
                    return apptimizeVar2;
                }
            }
            f42299b.get(e11).add(apptimizeVar);
            return apptimizeVar;
        }
    }

    public static synchronized Map<String, List<ApptimizeVar<?>>> a() {
        Map<String, List<ApptimizeVar<?>>> map;
        synchronized (ej.class) {
            map = f42299b;
        }
        return map;
    }
}
