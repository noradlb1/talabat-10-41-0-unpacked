package com.apptimize;

import com.apptimize.dl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class eo implements ep {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42311a = "eo";

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f42312b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Method f42313c;

    /* renamed from: d  reason: collision with root package name */
    private Method f42314d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Method f42315e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Object f42316f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Object f42317g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42318h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42319i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a f42320j = new a();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final dt f42321k;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.apptimize.bo.h(f42311a, "Mixpanel not found. Experiment participation events will not be exported to Mixpanel.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r5.f42313c != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        if (r5.f42314d != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r5.f42318h = r6;
        r5.f42319i = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0043, code lost:
        if (r5.f42314d != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        com.apptimize.bo.g(f42311a, "Mixpanel#trackMap or Mixpanel#getPeople()#set method not found.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0048, B:14:0x0058] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0048 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:8:0x0048=Splitter:B:8:0x0048, B:14:0x0058=Splitter:B:14:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public eo(com.apptimize.dt r6) {
        /*
            r5 = this;
            r5.<init>()
            com.apptimize.eo$a r0 = new com.apptimize.eo$a
            r1 = 0
            r0.<init>()
            r5.f42320j = r0
            r5.f42321k = r6
            r6 = 1
            r0 = 0
            java.lang.String r1 = "com.mixpanel.android.mpmetrics.MixpanelAPI"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            r5.f42312b = r1     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.String r2 = "trackMap"
            r3 = 2
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r3[r0] = r4     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            r3[r6] = r4     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            r5.f42313c = r1     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.Class<?> r1 = r5.f42312b     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.String r2 = "getPeople"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            r5.f42314d = r1     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.String r1 = f42311a     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.String r2 = "Mixpanel found. Events will be exported to Mixpanel."
            com.apptimize.bo.h(r1, r2)     // Catch:{ ClassNotFoundException -> 0x0058, NoSuchMethodException -> 0x0048 }
            java.lang.reflect.Method r1 = r5.f42313c
            if (r1 == 0) goto L_0x0068
            java.lang.reflect.Method r1 = r5.f42314d
            if (r1 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0046:
            r1 = move-exception
            goto L_0x006e
        L_0x0048:
            java.lang.String r1 = f42311a     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "Mixpanel#trackMap or Mixpanel#getPeople()#set method not found."
            com.apptimize.bo.g(r1, r2)     // Catch:{ all -> 0x0046 }
            java.lang.reflect.Method r1 = r5.f42313c
            if (r1 == 0) goto L_0x0068
            java.lang.reflect.Method r1 = r5.f42314d
            if (r1 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0058:
            java.lang.String r1 = f42311a     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "Mixpanel not found. Experiment participation events will not be exported to Mixpanel."
            com.apptimize.bo.h(r1, r2)     // Catch:{ all -> 0x0046 }
            java.lang.reflect.Method r1 = r5.f42313c
            if (r1 == 0) goto L_0x0068
            java.lang.reflect.Method r1 = r5.f42314d
            if (r1 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r6 = r0
        L_0x0069:
            r5.f42318h = r6
            r5.f42319i = r0
            return
        L_0x006e:
            java.lang.reflect.Method r2 = r5.f42313c
            if (r2 == 0) goto L_0x0077
            java.lang.reflect.Method r2 = r5.f42314d
            if (r2 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r6 = r0
        L_0x0078:
            r5.f42318h = r6
            r5.f42319i = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.eo.<init>(com.apptimize.dt):void");
    }

    public String b() {
        return "mixpanel";
    }

    private Object d() throws NoSuchFieldException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        Field declaredField = this.f42312b.getDeclaredField("sInstanceMap");
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        for (Map values : ((Map) declaredField.get((Object) null)).values()) {
            for (Object add : values.values()) {
                arrayList.add(add);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList.get(0);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean e() {
        return a(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.Object r0 = r5.f42316f     // Catch:{ all -> 0x0053 }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r5)
            return r1
        L_0x0008:
            r0 = 0
            java.lang.Object r2 = r5.d()     // Catch:{ Exception -> 0x0023 }
            r5.f42316f = r2     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x0020
            java.lang.reflect.Method r3 = r5.f42314d     // Catch:{ Exception -> 0x0023 }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r2 = r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0023 }
            r5.f42317g = r2     // Catch:{ Exception -> 0x0023 }
            r5.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x0023 }
            r2 = 0
            goto L_0x0028
        L_0x0020:
            java.lang.String r2 = "No configured MixpanelAPI instance found, has MixpanelAPI.getInstance been called?"
            goto L_0x0028
        L_0x0023:
            r2 = move-exception
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0053 }
        L_0x0028:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0053 }
            if (r3 != 0) goto L_0x0045
            boolean r3 = r5.f42319i     // Catch:{ all -> 0x0053 }
            if (r3 != 0) goto L_0x0045
            if (r6 == 0) goto L_0x0045
            java.lang.String r6 = "Mixpanel is not loaded (%s)"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0053 }
            r3[r0] = r2     // Catch:{ all -> 0x0053 }
            java.lang.String r6 = java.lang.String.format(r6, r3)     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = f42311a     // Catch:{ all -> 0x0053 }
            com.apptimize.bo.g(r3, r6)     // Catch:{ all -> 0x0053 }
            r5.f42319i = r1     // Catch:{ all -> 0x0053 }
        L_0x0045:
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0050
            java.lang.Object r6 = r5.f42316f     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = r0
        L_0x0051:
            monitor-exit(r5)
            return r1
        L_0x0053:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.eo.a(boolean):boolean");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f42329a;

        /* renamed from: b  reason: collision with root package name */
        private String f42330b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f42331c;

        /* renamed from: d  reason: collision with root package name */
        private int f42332d;

        private a() {
            this.f42329a = null;
            this.f42330b = null;
            this.f42331c = false;
            this.f42332d = 0;
        }

        public boolean a(String str, String str2) {
            boolean z11;
            synchronized (this) {
                this.f42329a = str;
                this.f42330b = str2;
                z11 = this.f42331c;
                this.f42331c = true;
            }
            return z11;
        }

        public boolean b() {
            boolean z11 = true;
            int i11 = this.f42332d + 1;
            this.f42332d = i11;
            if (i11 <= 10) {
                z11 = false;
            }
            if (z11) {
                bo.g(eo.f42311a, "Still no MixpanelAPI instance after 10 tries, giving up. User will not be available for cohort targeting");
            } else {
                bo.j(eo.f42311a, "MixpanelAPI instance not found, waiting a bit.");
            }
            if (z11) {
                synchronized (this) {
                    this.f42332d = 0;
                    this.f42331c = false;
                }
            }
            return z11;
        }

        public String a() {
            StringBuilder sb2;
            String sb3;
            synchronized (this) {
                this.f42331c = false;
                this.f42332d = 0;
                if (this.f42329a == null) {
                    sb2 = new StringBuilder();
                    sb2.append("a_");
                    sb2.append(this.f42330b);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("i_");
                    sb2.append(this.f42329a);
                }
                sb3 = sb2.toString();
            }
            return sb3;
        }
    }

    private void a(Object obj) throws NoSuchMethodException {
        if (obj != null) {
            this.f42315e = obj.getClass().getDeclaredMethod("set", new Class[]{String.class, Object.class});
        }
    }

    public boolean a() {
        return this.f42318h;
    }

    public void a(final String str, final Map<String, String> map) {
        if (this.f42318h) {
            fg.f42428c.execute(new Runnable() {
                public void run() {
                    if (eo.this.e()) {
                        try {
                            eo.this.f42313c.invoke(eo.this.f42316f, new Object[]{str, map});
                        } catch (IllegalAccessException unused) {
                            bo.g(eo.f42311a, "Cannot access Mixpanel.");
                        } catch (InvocationTargetException unused2) {
                            bo.g(eo.f42311a, "Cannot send Mixpanel event (invalid signature).");
                        }
                    }
                }
            });
        }
    }

    public void a(final String str, final String[] strArr) {
        if (this.f42318h) {
            fg.f42428c.execute(new Runnable() {
                public void run() {
                    if (eo.this.e()) {
                        JSONArray jSONArray = new JSONArray();
                        for (String put : strArr) {
                            jSONArray.put((Object) put);
                        }
                        try {
                            eo.this.f42315e.invoke(eo.this.f42317g, new Object[]{str, jSONArray});
                        } catch (IllegalAccessException unused) {
                            bo.g(eo.f42311a, "Cannot access Mixpanel.");
                        } catch (InvocationTargetException unused2) {
                            bo.g(eo.f42311a, "Cannot send Mixpanel user attributes (invalid signature).");
                        }
                    }
                }
            });
        }
    }

    public void a(String str, String str2) {
        if (this.f42318h) {
            if (str == null && str2 == null) {
                if (!this.f42319i) {
                    bo.g(f42311a, "Cannot access valid id for Mixpanel.");
                    this.f42319i = true;
                }
            } else if (this.f42320j.a(str, str2)) {
                String str3 = f42311a;
                bo.h(str3, "Still trying to set Mixpanel cohort user ID, now to " + str + "/" + str2);
            } else {
                a(100);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11) {
        fg.f42427b.schedule(new Runnable() {
            public void run() {
                if (eo.this.a(false)) {
                    try {
                        String a11 = eo.this.f42320j.a();
                        eo.this.f42315e.invoke(eo.this.f42317g, new Object[]{"$apptimize_user_id", a11});
                        eo.this.f42321k.a(dl.b.MixpanelSuperProperty, "_cohort_id", (Object) a11);
                        String c11 = eo.f42311a;
                        bo.h(c11, "Mixpanel cohort user ID set to " + a11);
                    } catch (IllegalAccessException e11) {
                        bo.e(eo.f42311a, "Cannot access Mixpanel.", e11);
                    } catch (InvocationTargetException e12) {
                        bo.e(eo.f42311a, "Cannot send Mixpanel user id attribute(invalid signature).", e12);
                    }
                } else if (!eo.this.f42320j.b()) {
                    eo.this.a(2000);
                }
            }
        }, (long) i11, TimeUnit.MILLISECONDS);
    }
}
