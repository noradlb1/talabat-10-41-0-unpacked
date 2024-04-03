package com.uxcam.internals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hc {

    /* renamed from: a  reason: collision with root package name */
    public static Set f13536a;

    static {
        HashSet hashSet = new HashSet();
        f13536a = hashSet;
        hashSet.add(String.class);
        f13536a.add(Byte.class);
        f13536a.add(Short.class);
        f13536a.add(Integer.class);
        f13536a.add(Long.class);
        f13536a.add(Float.class);
        f13536a.add(Double.class);
        f13536a.add(Character.class);
    }

    public static void a(Object obj, StringBuilder sb2, String... strArr) {
        boolean z11;
        sb2.append("{\n");
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        for (Method method : obj.getClass().getMethods()) {
            if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
                z11 = !Void.TYPE.equals(method.getReturnType());
            } else {
                z11 = false;
            }
            if (z11) {
                try {
                    String substring = method.getName().substring(3);
                    String str = substring.substring(0, 1).toLowerCase() + substring.substring(1);
                    if (strArr.length <= 0 || hashSet.contains(str)) {
                        Object invoke = method.invoke(obj, new Object[0]);
                        if (!invoke.getClass().isPrimitive()) {
                            if (!((HashSet) f13536a).contains(invoke.getClass()) && !(invoke instanceof Iterable)) {
                            }
                        }
                        sb2.append(str + ": ");
                        a(sb2, invoke);
                        sb2.append(",\n");
                    }
                } catch (Exception unused) {
                }
            }
        }
        sb2.append("}");
    }

    public static void a(StringBuilder sb2, Object obj) {
        if (obj == String.class) {
            sb2.append("'");
            sb2.append((String) obj);
            sb2.append("'");
        } else if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            sb2.append("[");
            while (it.hasNext()) {
                a(it.next(), sb2, new String[0]);
                if (it.hasNext()) {
                    sb2.append(",");
                }
            }
            sb2.append("]");
        } else {
            sb2.append(obj);
        }
    }
}
