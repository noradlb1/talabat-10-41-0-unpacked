package com.apptimize;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ey {

    /* renamed from: a  reason: collision with root package name */
    private static double f42373a = 1.0E-4d;

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return a((Number) obj, (Number) obj2);
        }
        if ((obj instanceof Map) && (obj2 instanceof Map)) {
            Map map = (Map) obj;
            Map map2 = (Map) obj2;
            HashSet hashSet = new HashSet();
            hashSet.addAll(map.keySet());
            hashSet.addAll(map2.keySet());
            for (Object next : hashSet) {
                if (!a(map.get(next), map2.get(next))) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof List) || !(obj2 instanceof List)) {
            return obj.equals(obj2);
        } else {
            List list = (List) obj;
            List list2 = (List) obj2;
            if (list.size() != list2.size()) {
                return false;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (!a(list.get(i11), list2.get(i11))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Map<String, Object> map, Map<String, Object> map2) {
        if (!map.keySet().equals(map2.keySet())) {
            return false;
        }
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            Object obj2 = map2.get(next);
            if (obj == null || obj2 == null) {
                if (obj != obj2) {
                    return false;
                }
            } else if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
                if (!obj.equals(obj2)) {
                    return false;
                }
            } else if (!a((Number) obj, (Number) obj2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Number number, Number number2) {
        return Math.abs(number.doubleValue() - number2.doubleValue()) < f42373a;
    }
}
