package com.apptimize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class en implements ep {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42307a = "en";

    /* renamed from: b  reason: collision with root package name */
    private Method f42308b;

    /* renamed from: c  reason: collision with root package name */
    private Method f42309c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f42310d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|(1:15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.apptimize.bo.g(f42307a, "Localytics#tagEvent or Localytics#addProfileAttributesToSet method not found.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0067, code lost:
        r8.f42310d = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (r8.f42309c != null) goto L_0x005a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0049 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public en() {
        /*
            r8 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r8.<init>()
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.Class r1 = com.apptimize.em.a(r1)     // Catch:{ NoSuchMethodException -> 0x0049 }
            if (r1 == 0) goto L_0x0037
            java.lang.String r4 = "tagEvent"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0049 }
            r6[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            r6[r2] = r7     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.reflect.Method r4 = r1.getDeclaredMethod(r4, r6)     // Catch:{ NoSuchMethodException -> 0x0049 }
            r8.f42308b = r4     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.String r4 = "addProfileAttributesToSet"
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0049 }
            r5[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.Class<java.lang.String[]> r0 = java.lang.String[].class
            r5[r2] = r0     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x0049 }
            r8.f42309c = r0     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.String r0 = f42307a     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.String r1 = "Localytics found. Events will be exported to Localytics."
            com.apptimize.bo.h(r0, r1)     // Catch:{ NoSuchMethodException -> 0x0049 }
            goto L_0x003e
        L_0x0037:
            java.lang.String r0 = f42307a     // Catch:{ NoSuchMethodException -> 0x0049 }
            java.lang.String r1 = "Localytics not found. Experiment participation events will not be exported to Localytics."
            com.apptimize.bo.h(r0, r1)     // Catch:{ NoSuchMethodException -> 0x0049 }
        L_0x003e:
            java.lang.reflect.Method r0 = r8.f42308b
            if (r0 == 0) goto L_0x0059
            java.lang.reflect.Method r0 = r8.f42309c
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0047:
            r0 = move-exception
            goto L_0x005d
        L_0x0049:
            java.lang.String r0 = f42307a     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "Localytics#tagEvent or Localytics#addProfileAttributesToSet method not found."
            com.apptimize.bo.g(r0, r1)     // Catch:{ all -> 0x0047 }
            java.lang.reflect.Method r0 = r8.f42308b
            if (r0 == 0) goto L_0x0059
            java.lang.reflect.Method r0 = r8.f42309c
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r2 = r3
        L_0x005a:
            r8.f42310d = r2
            return
        L_0x005d:
            java.lang.reflect.Method r1 = r8.f42308b
            if (r1 == 0) goto L_0x0066
            java.lang.reflect.Method r1 = r8.f42309c
            if (r1 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r2 = r3
        L_0x0067:
            r8.f42310d = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.en.<init>():void");
    }

    public boolean a() {
        return this.f42310d;
    }

    public String b() {
        return "localytics";
    }

    public void a(String str, Map<String, String> map) {
        if (this.f42310d) {
            try {
                this.f42308b.invoke((Object) null, new Object[]{str, map});
            } catch (IllegalAccessException unused) {
                bo.g(f42307a, "Cannot access Localytics.");
            } catch (InvocationTargetException unused2) {
                bo.g(f42307a, "Cannot send Localytics events (wrong arguments or Localytics is not initialised).");
            }
        }
    }

    public void a(String str, String[] strArr) {
        if (this.f42310d) {
            try {
                this.f42309c.invoke((Object) null, new Object[]{str, strArr});
            } catch (IllegalAccessException unused) {
                bo.g(f42307a, "Cannot access Localytics.");
            } catch (InvocationTargetException unused2) {
                bo.g(f42307a, "Cannot send Localytics user profile attribures (wrong arguments).");
            }
        }
    }
}
