package com.apptimize;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class ha extends gu {

    /* renamed from: b  reason: collision with root package name */
    private static final String f42904b = "ha";

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<ViewGroup> f42905c;

    /* renamed from: d  reason: collision with root package name */
    private final hg f42906d;

    /* renamed from: e  reason: collision with root package name */
    private Method f42907e = null;

    public ha(ViewGroup viewGroup, he heVar, Integer num, hg hgVar) {
        super(viewGroup, heVar, num, hgVar);
        if (hb.a((View) viewGroup)) {
            this.f42905c = new WeakReference<>(viewGroup);
            this.f42906d = hgVar;
            return;
        }
        throw new IllegalArgumentException("Not a RecyclerView");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        com.apptimize.bo.g(f42904b, "Error accessing RecyclerView's children", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        com.apptimize.bo.g(f42904b, "Error accessing RecyclerView's children", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        com.apptimize.bo.j(f42904b, "Apptimize was unable to properly process a RecyclerView's children.The most likely cause is ProGuard. Consult the Apptimize docs  for information on how to adjust your ProGuard configuration.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d A[ExcHandler: InvocationTargetException (r7v3 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:7:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074 A[ExcHandler: IllegalAccessException (r7v2 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:7:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.apptimize.hf> a() {
        /*
            r12 = this;
            java.lang.Class<android.view.View> r0 = android.view.View.class
            java.lang.String r1 = "Error accessing RecyclerView's children"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.ref.WeakReference<android.view.ViewGroup> r3 = r12.f42905c
            java.lang.Object r3 = r3.get()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x0014
            return r2
        L_0x0014:
            int r4 = r3.getChildCount()
            r5 = 0
            r6 = r5
        L_0x001a:
            if (r6 >= r4) goto L_0x0085
            android.view.View r7 = r3.getChildAt(r6)
            com.apptimize.hg r8 = r12.f42906d
            boolean r8 = r8.a((android.view.View) r7)
            if (r8 != 0) goto L_0x0029
            goto L_0x0082
        L_0x0029:
            java.lang.reflect.Method r8 = r12.f42907e     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r9 = 1
            if (r8 != 0) goto L_0x004f
            java.lang.Class r8 = r3.getClass()     // Catch:{ NoSuchMethodException -> 0x003f, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.String r10 = "getChildAdapterPosition"
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ NoSuchMethodException -> 0x003f, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r11[r5] = r0     // Catch:{ NoSuchMethodException -> 0x003f, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.reflect.Method r8 = r8.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x003f, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r12.f42907e = r8     // Catch:{ NoSuchMethodException -> 0x003f, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            goto L_0x004f
        L_0x003f:
            java.lang.Class r8 = r3.getClass()     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.String r10 = "getChildPosition"
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r11[r5] = r0     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.reflect.Method r8 = r8.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r12.f42907e = r8     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
        L_0x004f:
            java.lang.reflect.Method r8 = r12.f42907e     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r9[r5] = r7     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.Object r8 = r8.invoke(r3, r9)     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            int r8 = r8.intValue()     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            com.apptimize.hg r9 = r12.f42906d     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            com.apptimize.hf r7 = r9.b(r7, r12, r8)     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            r2.add(r7)     // Catch:{ NoSuchMethodException -> 0x007b, IllegalAccessException -> 0x0074, InvocationTargetException -> 0x006d }
            goto L_0x0082
        L_0x006d:
            r7 = move-exception
            java.lang.String r8 = f42904b
            com.apptimize.bo.g(r8, r1, r7)
            goto L_0x0082
        L_0x0074:
            r7 = move-exception
            java.lang.String r8 = f42904b
            com.apptimize.bo.g(r8, r1, r7)
            goto L_0x0082
        L_0x007b:
            java.lang.String r7 = f42904b
            java.lang.String r8 = "Apptimize was unable to properly process a RecyclerView's children.The most likely cause is ProGuard. Consult the Apptimize docs  for information on how to adjust your ProGuard configuration."
            com.apptimize.bo.j(r7, r8)
        L_0x0082:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0085:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ha.a():java.util.List");
    }
}
