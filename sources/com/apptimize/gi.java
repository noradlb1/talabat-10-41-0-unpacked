package com.apptimize;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class gi {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42628a = "gi";

    public static class a implements gl {
        private a() {
        }

        public Object a(Method method, Object obj, Object obj2) {
            if (obj2 == null) {
                return obj2;
            }
            if (!(obj2 instanceof StackTraceElement[])) {
                String b11 = gi.f42628a;
                bo.e(b11, "Expected StackTraceElement[]; got " + obj2.getClass().getName());
                return obj2;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList((StackTraceElement[]) obj2));
            Iterator it = arrayList.iterator();
            StackTraceElement stackTraceElement = null;
            while (it.hasNext()) {
                StackTraceElement stackTraceElement2 = (StackTraceElement) it.next();
                if (stackTraceElement != null) {
                    if (!stackTraceElement.isNativeMethod() && stackTraceElement2.isNativeMethod() && stackTraceElement.getClassName().equals(stackTraceElement2.getClassName()) && stackTraceElement.getMethodName().equals(stackTraceElement2.getMethodName())) {
                        it.remove();
                    } else if (stackTraceElement.getClassName().startsWith("com.apptimize") && stackTraceElement2.isNativeMethod() && !stackTraceElement2.getClassName().startsWith("com.apptimize")) {
                        it.remove();
                    }
                }
                stackTraceElement = stackTraceElement2;
            }
            return arrayList.toArray(new StackTraceElement[arrayList.size()]);
        }
    }

    public static void a() {
        try {
            gn.a(gn.j(), (gl) new a());
        } catch (NoSuchMethodException unused) {
            bo.e(f42628a, "Cannot find stack method 1");
        }
        try {
            gn.a(Thread.class.getMethod("getStackTrace", new Class[0]), (gl) new a());
        } catch (NoSuchMethodException unused2) {
            bo.e(f42628a, "Cannot find stack method 2");
        }
    }
}
