package com.apptimize;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class hn {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42961a = "hn";

    private static boolean a(StackTraceElement stackTraceElement, Method method) {
        return stackTraceElement.getClassName().equals(method.getDeclaringClass().getName()) && stackTraceElement.getMethodName().equals(method.getName());
    }

    private static boolean a(List<Method> list) {
        for (Method next : list) {
            Iterator<Method> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    Method next2 = it.next();
                    if (!next.equals(next2) && next.getDeclaringClass().equals(next2.getDeclaringClass()) && next.getName().equals(next2.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, Method method) {
        HashSet hashSet = new HashSet();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (a(stackTraceElement, method)) {
                if (hashSet.contains(Integer.valueOf(stackTraceElement.getLineNumber()))) {
                    return true;
                }
                hashSet.add(Integer.valueOf(stackTraceElement.getLineNumber()));
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0041, code lost:
        if (a(java.lang.Thread.currentThread().getStackTrace(), r7) != false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.apptimize.hj r10, java.lang.reflect.Method r11) {
        /*
            java.util.List r0 = r10.d()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x000f:
            if (r4 >= r2) goto L_0x006e
            r5 = r1[r4]
            java.util.Iterator r6 = r0.iterator()
        L_0x0017:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x006b
            java.lang.Object r7 = r6.next()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            boolean r8 = a((java.lang.StackTraceElement) r5, (java.lang.reflect.Method) r7)
            if (r8 == 0) goto L_0x0017
            boolean r8 = a((java.lang.StackTraceElement) r5, (java.lang.reflect.Method) r11)
            if (r8 == 0) goto L_0x0043
            boolean r8 = a(r0)
            r8 = r8 ^ 1
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r9 = r9.getStackTrace()
            boolean r7 = a((java.lang.StackTraceElement[]) r9, (java.lang.reflect.Method) r7)
            if (r7 == 0) goto L_0x0044
        L_0x0043:
            r8 = r3
        L_0x0044:
            if (r8 != 0) goto L_0x0017
            java.lang.String r7 = f42961a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Possible redundancy detected in property "
            r8.append(r9)
            java.lang.String r9 = r10.a()
            r8.append(r9)
            java.lang.String r9 = "; may cause flashing"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>()
            com.apptimize.bo.b(r7, r8, r9)
            goto L_0x0017
        L_0x006b:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.hn.a(com.apptimize.hj, java.lang.reflect.Method):void");
    }
}
