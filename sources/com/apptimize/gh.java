package com.apptimize;

import java.lang.reflect.Method;
import java.util.HashMap;

public class gh {

    /* renamed from: a  reason: collision with root package name */
    private static String f42624a = "gh";

    /* renamed from: b  reason: collision with root package name */
    private au f42625b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Thread, StackTraceElement[]> f42626c = new HashMap<>();

    public gh(au auVar) {
        this.f42625b = auVar;
        auVar.a(new fi() {
            public void run() {
                synchronized (this) {
                    HashMap unused = gh.this.f42626c = null;
                }
            }
        });
    }

    public boolean a(Method method) {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] stackTraceElementArr = null;
        if (this.f42625b.h()) {
            synchronized (this) {
                HashMap<Thread, StackTraceElement[]> hashMap = this.f42626c;
                if (hashMap != null) {
                    StackTraceElement[] stackTraceElementArr2 = hashMap.get(currentThread);
                    if (stackTraceElementArr2 == null) {
                        stackTraceElementArr2 = currentThread.getStackTrace();
                        this.f42626c.put(currentThread, stackTraceElementArr2);
                    }
                    stackTraceElementArr = stackTraceElementArr2;
                }
            }
        }
        if (stackTraceElementArr == null) {
            stackTraceElementArr = currentThread.getStackTrace();
        }
        if (method.getName().equals("getStackTrace")) {
            return false;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (!stackTraceElement.getClassName().equals(gn.class.getName()) && stackTraceElement.getClassName().equals(method.getDeclaringClass().getName()) && stackTraceElement.getMethodName().equals(method.getName())) {
                return true;
            }
        }
        return false;
    }
}
