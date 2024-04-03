package com.apptimize;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.apptimize.dl;
import com.apptimize.dp;
import com.apptimize.gn;
import com.facebook.internal.NativeProtocol;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dk {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f41778a = "dk";

    /* renamed from: b  reason: collision with root package name */
    private final Context f41779b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final as f41780c;

    /* renamed from: d  reason: collision with root package name */
    private final h f41781d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Map<Object, Map<String, String>> f41782e = new HashMap();

    public class a extends gk {
        private a() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            dk.this.f41780c.a(dl.b.MixpanelSuperProperty);
        }
    }

    public class b extends gk {
        private b() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            dk.this.f41780c.a(dl.b.MixpanelSuperProperty, "_identity", (Object) objArr[0]);
        }
    }

    public class c extends gk {
        private c() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            try {
                dk.this.f41780c.a(dl.b.MixpanelSuperProperty, (Map<String, Object>) fx.a(fh.a(objArr[0]), String.class));
            } catch (JSONException e11) {
                bo.c(dk.f41778a, "JSON error when importing Mixpanel properties", e11);
            }
        }
    }

    public class d extends gk {
        private d() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            try {
                Map<U, V> a11 = fx.a(fh.a(objArr[0]), String.class);
                Map<String, Object> b11 = dk.this.f41780c.b(dl.b.MixpanelSuperProperty);
                for (Map.Entry next : a11.entrySet()) {
                    if (!b11.containsKey(next.getKey())) {
                        dk.this.f41780c.a(dl.b.MixpanelSuperProperty, (String) next.getKey(), next.getValue());
                    }
                }
            } catch (JSONException e11) {
                bo.c(dk.f41778a, "JSON error when importing Mixpanel properties", e11);
            }
        }
    }

    public class e extends gk {
        private e() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            String str = objArr[0];
            JSONObject jSONObject = objArr[1];
            try {
                Map<U, V> hashMap = new HashMap<>();
                if (jSONObject != null) {
                    hashMap = fx.a(fh.a(jSONObject), String.class);
                }
                dk.this.f41780c.a(str, dp.k.Mixpanel, (Map<String, Object>) hashMap);
            } catch (JSONException e11) {
                bo.c(dk.f41778a, "JSON error when importing Mixpanel properties", e11);
            }
        }
    }

    public class f extends gk {
        private f() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            dk.this.f41780c.a(dl.b.MixpanelSuperProperty, objArr[0], (Object) null);
        }
    }

    public class g extends gk {
        private g() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            HashMap hashMap = new HashMap();
            hashMap.put("queryString", objArr[1]);
            dk.this.f41780c.a("track", dp.k.OmnitureV2, (Map<String, Object>) hashMap);
        }
    }

    public class h extends gk {
        private h() {
        }

        public void a(Method method, Object obj, Object[] objArr) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestString", objArr[0]);
            dk.this.f41780c.a("track", dp.k.OmnitureV3, (Map<String, Object>) hashMap);
        }
    }

    private dk(Context context, as asVar, au auVar) {
        this.f41779b = context.getApplicationContext();
        this.f41780c = asVar;
        this.f41781d = auVar.c();
    }

    private gk b(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                Map map = objArr[1];
                if (map == null) {
                    map = new HashMap();
                }
                dk.this.f41780c.a(str, kVar, (Map<String, Object>) map);
            }
        };
    }

    private gk c(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                Map hashMap = new HashMap();
                JSONObject jSONObject = objArr[1];
                if (jSONObject != null) {
                    try {
                        hashMap = fh.b(jSONObject);
                    } catch (JSONException e11) {
                        bo.c(dk.f41778a, "JSON error when importing event", e11);
                    }
                }
                dk.this.f41780c.a(str, kVar, (Map<String, Object>) hashMap);
            }
        };
    }

    private gk d(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                HashMap hashMap = new HashMap();
                String str = objArr[0];
                if (!TextUtils.isEmpty(str)) {
                    Bundle bundle = objArr[1];
                    if (bundle != null) {
                        Bundle bundle2 = bundle;
                        for (String next : bundle2.keySet()) {
                            hashMap.put(next, bundle2.get(next));
                        }
                    }
                    dk.this.f41780c.a(str, kVar, (Map<String, Object>) hashMap);
                }
            }
        };
    }

    private gk e(dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                if (!TextUtils.isEmpty(str)) {
                    dk.this.f41780c.a(dl.b.FirebaseProperty, "user_id", (Object) str);
                }
            }
        };
    }

    private gk f(dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                String str2 = objArr[1];
                if (!TextUtils.isEmpty(str) && !str.equals("user_id")) {
                    dk.this.f41780c.a(dl.b.FirebaseProperty, str, (Object) str2);
                }
            }
        };
    }

    private gk g(dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                Object obj2 = objArr[0];
                if (obj2 != null) {
                    try {
                        Field declaredField = obj2.getClass().getDeclaredField("userPropertiesOperations");
                        declaredField.setAccessible(true);
                        JSONObject jSONObject = (JSONObject) declaredField.get(objArr[0]);
                        Class<String> cls = String.class;
                        if (jSONObject.has("$set")) {
                            dk.this.f41780c.a(dl.b.AmplitudeProperty, (Map<String, Object>) fx.a(fh.a(jSONObject.getJSONObject("$set")), cls));
                        }
                        if (jSONObject.has("$unset")) {
                            Map<U, Object> a11 = fx.a(fh.a(jSONObject.getJSONObject("$unset")), cls);
                            for (U put : a11.keySet()) {
                                a11.put(put, (Object) null);
                            }
                            dk.this.f41780c.a(dl.b.AmplitudeProperty, (Map<String, Object>) a11);
                        }
                        if (jSONObject.has("$clearAll")) {
                            dk.this.f41780c.a(dl.b.AmplitudeProperty);
                        }
                    } catch (NoSuchFieldException e11) {
                        bo.c(dk.f41778a, "Error when importing properties", e11);
                    } catch (IllegalAccessException e12) {
                        bo.c(dk.f41778a, "Error when accessing properties", e12);
                    } catch (JSONException e13) {
                        bo.c(dk.f41778a, "Error when accessing json properties", e13);
                    }
                }
            }
        };
    }

    private gk h(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                String str2 = "revenue";
                if (str != null && str.length() > 0) {
                    str2 = str2 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str;
                }
                HashMap hashMap = new HashMap();
                Object obj2 = objArr[2];
                if (obj2 != null) {
                    hashMap.put("value", obj2);
                }
                dk.this.f41780c.a(str2, kVar, (Map<String, Object>) hashMap);
            }
        };
    }

    private gk i(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                if (objArr[0] != null) {
                    HashMap hashMap = new HashMap();
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        try {
                            Method declaredMethod = obj2.getClass().getDeclaredMethod("toJSONObject", new Class[0]);
                            declaredMethod.setAccessible(true);
                            JSONObject jSONObject = (JSONObject) declaredMethod.invoke(objArr[0], new Object[0]);
                            if (jSONObject != null) {
                                hashMap.put("revenue", fh.b(jSONObject));
                            }
                        } catch (NoSuchMethodException e11) {
                            bo.c(dk.f41778a, "Error when importing event", e11);
                        } catch (IllegalAccessException e12) {
                            bo.c(dk.f41778a, "Error when importing event", e12);
                        } catch (InvocationTargetException e13) {
                            bo.c(dk.f41778a, "Error when importing event", e13);
                        } catch (JSONException e14) {
                            bo.c(dk.f41778a, "JSON error when importing event", e14);
                        }
                    }
                    dk.this.f41780c.a("revenue", kVar, (Map<String, Object>) hashMap);
                }
            }
        };
    }

    private gk j(final dp.k kVar) {
        final Map<Object, Map<String, String>> map = this.f41782e;
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                if (!map.containsKey(obj)) {
                    map.put(obj, new HashMap());
                }
                HashMap hashMap = new HashMap();
                hashMap.putAll((Map) dk.this.f41782e.get(obj));
                hashMap.putAll(objArr[0]);
                dk.this.f41780c.a(dk.this.a(obj, (Map<String, String>) hashMap), kVar, (Map<String, Object>) hashMap);
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r6 = com.apptimize.dp.k.f41913f;
        r7 = c(r6);
        r8 = com.apptimize.gn.b.f42667e;
        r12 = java.lang.Boolean.TYPE;
        com.apptimize.gn.a(r7, r8, r5, "logEvent", (java.lang.Class<?>[]) new java.lang.Class[]{r3, r4, r12});
        com.apptimize.gn.a(c(r6), r8, r5, "logEventSync", (java.lang.Class<?>[]) new java.lang.Class[]{r3, r4, r12});
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x00b6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = "logEventSync"
            java.lang.String r2 = "logEvent"
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class<org.json.JSONObject> r4 = org.json.JSONObject.class
            android.content.Context r5 = r0.f41779b     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.String r6 = "com.amplitude.api.AmplitudeClient"
            java.lang.Class r5 = r5.loadClass(r6)     // Catch:{ ClassNotFoundException -> 0x0104 }
            r9 = 2
            r10 = 1
            r11 = 0
            android.content.Context r12 = r0.f41779b     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.ClassLoader r12 = r12.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.String r13 = "com.amplitude.api.Revenue"
            java.lang.Class r12 = r12.loadClass(r13)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            android.content.Context r13 = r0.f41779b     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.ClassLoader r13 = r13.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.String r14 = "com.amplitude.api.Identify"
            java.lang.Class r13 = r13.loadClass(r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.dp$k r14 = com.apptimize.dp.k.Amplitude     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gk r15 = r0.g((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gn$b r7 = com.apptimize.gn.b.f42667e     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.String r8 = "identify"
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r6[r11] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.Class r13 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r6[r10] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            boolean r6 = com.apptimize.gn.a((com.apptimize.gk) r15, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r8, (java.lang.Class<?>[]) r6)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            if (r6 != 0) goto L_0x0050
            java.lang.String r6 = f41778a     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.String r8 = "Failed to auto-import Amplitude identify"
            com.apptimize.bo.j(r6, r8)     // Catch:{ ClassNotFoundException -> 0x00b6 }
        L_0x0050:
            com.apptimize.gk r6 = r0.i((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.String r8 = "logRevenueV2"
            java.lang.Class[] r15 = new java.lang.Class[r10]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r15[r11] = r12     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gn.a((com.apptimize.gk) r6, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r8, (java.lang.Class<?>[]) r15)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gk r6 = r0.c((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 5
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r11] = r3     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r10] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r15 = 3
            r12[r15] = r8     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r15 = 4
            r12[r15] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            boolean r6 = com.apptimize.gn.a((com.apptimize.gk) r6, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r2, (java.lang.Class<?>[]) r12)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            if (r6 == 0) goto L_0x008f
            com.apptimize.gk r6 = r0.c((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12 = 5
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r14[r11] = r3     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r14[r10] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r14[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12 = 3
            r14[r12] = r8     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 4
            r14[r8] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gn.a((com.apptimize.gk) r6, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r1, (java.lang.Class<?>[]) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            goto L_0x00dc
        L_0x008f:
            com.apptimize.gk r6 = r0.c((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 4
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r11] = r3     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r10] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 3
            r12[r8] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gn.a((com.apptimize.gk) r6, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r2, (java.lang.Class<?>[]) r12)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gk r6 = r0.c((com.apptimize.dp.k) r14)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 4
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r11] = r3     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r10] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r12[r9] = r4     // Catch:{ ClassNotFoundException -> 0x00b6 }
            r8 = 3
            r12[r8] = r13     // Catch:{ ClassNotFoundException -> 0x00b6 }
            com.apptimize.gn.a((com.apptimize.gk) r6, (com.apptimize.gn.b) r7, (java.lang.Class<?>) r5, (java.lang.String) r1, (java.lang.Class<?>[]) r12)     // Catch:{ ClassNotFoundException -> 0x00b6 }
            goto L_0x00dc
        L_0x00b6:
            com.apptimize.dp$k r6 = com.apptimize.dp.k.Amplitude     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gk r7 = r0.c((com.apptimize.dp.k) r6)     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gn$b r8 = com.apptimize.gn.b.f42667e     // Catch:{ ClassNotFoundException -> 0x0104 }
            r12 = 3
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ ClassNotFoundException -> 0x0104 }
            r13[r11] = r3     // Catch:{ ClassNotFoundException -> 0x0104 }
            r13[r10] = r4     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.Class r12 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x0104 }
            r13[r9] = r12     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gn.a((com.apptimize.gk) r7, (com.apptimize.gn.b) r8, (java.lang.Class<?>) r5, (java.lang.String) r2, (java.lang.Class<?>[]) r13)     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gk r2 = r0.c((com.apptimize.dp.k) r6)     // Catch:{ ClassNotFoundException -> 0x0104 }
            r6 = 3
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0104 }
            r7[r11] = r3     // Catch:{ ClassNotFoundException -> 0x0104 }
            r7[r10] = r4     // Catch:{ ClassNotFoundException -> 0x0104 }
            r7[r9] = r12     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gn.a((com.apptimize.gk) r2, (com.apptimize.gn.b) r8, (java.lang.Class<?>) r5, (java.lang.String) r1, (java.lang.Class<?>[]) r7)     // Catch:{ ClassNotFoundException -> 0x0104 }
        L_0x00dc:
            com.apptimize.dp$k r1 = com.apptimize.dp.k.Amplitude     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gk r1 = r0.h((com.apptimize.dp.k) r1)     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gn$b r2 = com.apptimize.gn.b.f42667e     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.String r4 = "logRevenue"
            r6 = 5
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0104 }
            r6[r11] = r3     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0104 }
            r6[r10] = r7     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.Class r7 = java.lang.Double.TYPE     // Catch:{ ClassNotFoundException -> 0x0104 }
            r6[r9] = r7     // Catch:{ ClassNotFoundException -> 0x0104 }
            r7 = 3
            r6[r7] = r3     // Catch:{ ClassNotFoundException -> 0x0104 }
            r7 = 4
            r6[r7] = r3     // Catch:{ ClassNotFoundException -> 0x0104 }
            com.apptimize.gn.a((com.apptimize.gk) r1, (com.apptimize.gn.b) r2, (java.lang.Class<?>) r5, (java.lang.String) r4, (java.lang.Class<?>[]) r6)     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.String r1 = f41778a     // Catch:{ ClassNotFoundException -> 0x0104 }
            java.lang.String r2 = "Amplitude detected; now importing data"
            com.apptimize.bo.h(r1, r2)     // Catch:{ ClassNotFoundException -> 0x0104 }
            goto L_0x010b
        L_0x0104:
            java.lang.String r1 = f41778a
            java.lang.String r2 = "Apptimize did not detect Amplitude. If you are using Amplitude, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration."
            com.apptimize.bo.j(r1, r2)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dk.k():void");
    }

    /* access modifiers changed from: private */
    public void l() {
        Class<String> cls = String.class;
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            Class<?> loadClass2 = this.f41779b.getClassLoader().loadClass("android.os.Bundle");
            dp.k kVar = dp.k.Firebase;
            gk d11 = d(kVar);
            gn.b bVar = gn.b.f42667e;
            gn.a(d11, bVar, loadClass, "logEvent", (Class<?>[]) new Class[]{cls, loadClass2});
            gn.a(e(kVar), bVar, loadClass, "setUserId", (Class<?>[]) new Class[]{cls});
            gn.a(f(kVar), bVar, loadClass, "setUserProperty", (Class<?>[]) new Class[]{cls, cls});
            bo.h(f41778a, "Firebase detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Firebase. If you are using Firebase, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    private gk b(final dp.k kVar, final String str) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                HashMap hashMap = objArr[1];
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (objArr[2] != null) {
                    HashMap hashMap2 = new HashMap(hashMap);
                    hashMap2.put(str, objArr[2]);
                    hashMap = hashMap2;
                }
                dk.this.f41780c.a(str, kVar, (Map<String, Object>) hashMap);
            }
        };
    }

    /* access modifiers changed from: private */
    public void c() {
        Class<Map> cls = Map.class;
        Class<String> cls2 = String.class;
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.flurry.android.FlurryAgent");
            gk a11 = a(dl.b.FlurryProperty, "userId");
            gn.b bVar = gn.b.f42667e;
            gn.a(a11, bVar, loadClass, "setUserId", (Class<?>[]) new Class[]{cls2});
            dp.k kVar = dp.k.Flurry;
            gn.a(a(kVar), bVar, loadClass, "logEvent", (Class<?>[]) new Class[]{cls2});
            gn.a(a(kVar), bVar, loadClass, "endTimedEvent", (Class<?>[]) new Class[]{cls2});
            gn.a(a(kVar), bVar, loadClass, "onEvent", (Class<?>[]) new Class[]{cls2});
            gk a12 = a(kVar, "startTimedEvent");
            Class cls3 = Boolean.TYPE;
            gn.a(a12, bVar, loadClass, "logEvent", (Class<?>[]) new Class[]{cls2, cls3});
            gn.a(b(kVar), bVar, loadClass, "logEvent", (Class<?>[]) new Class[]{cls2, cls});
            gn.a(b(kVar), bVar, loadClass, "endTimedEvent", (Class<?>[]) new Class[]{cls2, cls});
            gn.a(b(kVar), bVar, loadClass, "onEvent", (Class<?>[]) new Class[]{cls2, cls});
            gn.a(b(kVar, "startTimedEvent"), bVar, loadClass, "logEvent", (Class<?>[]) new Class[]{cls2, cls, cls3});
            bo.h(f41778a, "Flurry detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Flurry. If you are using Flurry, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            a(this.f41779b.getClassLoader().loadClass("com.google.analytics.tracking.android.Tracker"), dp.k.GoogleAnalyticsV3);
            bo.h(f41778a, "Google Analytics V3 detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Google Analytics V3. If you are using Google Analytics V3, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            a(this.f41779b.getClassLoader().loadClass("com.google.android.gms.analytics.Tracker"), dp.k.GoogleAnalyticsV4);
            bo.h(f41778a, "Google Analytics V4 detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Google Analytics V4. If you are using Google Analytics V4, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Class<String> cls = String.class;
        Class<JSONObject> cls2 = JSONObject.class;
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.mixpanel.android.mpmetrics.MixpanelAPI");
            c cVar = new c();
            gn.b bVar = gn.b.f42667e;
            gn.a((gk) cVar, bVar, loadClass, "registerSuperProperties", (Class<?>[]) new Class[]{cls2});
            gn.a((gk) new d(), bVar, loadClass, "registerSuperPropertiesOnce", (Class<?>[]) new Class[]{cls2});
            gn.a((gk) new a(), bVar, loadClass, "clearSuperProperties", (Class<?>[]) new Class[0]);
            gn.a((gk) new f(), bVar, loadClass, "unregisterSuperProperty", (Class<?>[]) new Class[]{cls});
            gn.a((gk) new b(), bVar, loadClass, "identify", (Class<?>[]) new Class[]{cls});
            gn.a((gk) new e(), bVar, loadClass, "track", (Class<?>[]) new Class[]{cls, cls2});
            bo.h(f41778a, "Mixpanel detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Mixpanel. If you are using Mixpanel, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        Class<String> cls = String.class;
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.omniture.AppMeasurementBase");
            gn.a((gk) new g(), gn.b.f42667e, loadClass, "makeRequest", (Class<?>[]) new Class[]{cls, cls});
            bo.h(f41778a, "Omniture 2.x detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Omniture 2.x. If you are using Omniture 2.x, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.adobe.adms.measurement.ADMS_Measurement");
            gn.a((gk) new h(), gn.b.f42667e, loadClass, "sendRequest", (Class<?>[]) new Class[]{String.class});
            bo.h(f41778a, "Adobe AppMeasurement 3.x detected; now importing data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Adobe AppMeasurement 3.x. If you are using Adobe AppMeasurement 3.x, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        Class<Map> cls = Map.class;
        Class<String> cls2 = String.class;
        try {
            Class<?> loadClass = this.f41779b.getClassLoader().loadClass("com.adobe.mobile.Config");
            gn.a(a(dl.b.OmnitureProperty, "userId"), gn.b.f42667e, loadClass, "setUserIdentifier", (Class<?>[]) new Class[]{cls2});
            bo.h(f41778a, "Adobe Mobile 4.x Config detected; now importing config data");
        } catch (ClassNotFoundException unused) {
            bo.j(f41778a, "Apptimize did not detect Adobe Mobile 4.x Config class.");
        }
        try {
            Class<?> loadClass2 = this.f41779b.getClassLoader().loadClass("com.adobe.mobile.Analytics");
            gk a11 = a(NativeProtocol.WEB_DIALOG_ACTION);
            gn.b bVar = gn.b.f42667e;
            gn.a(a11, bVar, loadClass2, "trackAction", (Class<?>[]) new Class[]{cls2, cls});
            gn.a(a("state"), bVar, loadClass2, "trackState", (Class<?>[]) new Class[]{cls2, cls});
            bo.h(f41778a, "Adobe Mobile 4.x Analytics detected; now importing event data");
        } catch (ClassNotFoundException unused2) {
            bo.j(f41778a, "Apptimize did not detect Adobe Mobile 4.x Analytics and will not import its event data. If you are using Adobe Mobile 4.x, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
        }
    }

    private gk a(final dl.b bVar, final String str) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                dk.this.f41780c.a(bVar, str, objArr[0]);
            }
        };
    }

    private gk b() {
        final Map<Object, Map<String, String>> map = this.f41782e;
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                if (!map.containsKey(obj)) {
                    map.put(obj, new HashMap());
                }
                ((Map) map.get(obj)).put(objArr[0], objArr[1]);
            }
        };
    }

    /* access modifiers changed from: private */
    public void j() {
        Class<?> a11 = em.a(this.f41779b.getClassLoader());
        Class<?> b11 = em.b(this.f41779b.getClassLoader());
        if (a11 == null || b11 == null) {
            bo.j(f41778a, "Apptimize did not detect Localytics. If you are using Localytics, then the most likely cause is ProGuard. Please consult the Apptimize docs for how to adjust your ProGuard configuration.");
            return;
        }
        dp.k kVar = dp.k.Localytics;
        gk a12 = a(kVar);
        gn.b bVar = gn.b.f42667e;
        Class<String> cls = String.class;
        gn.a(a12, bVar, a11, "tagEvent", (Class<?>[]) new Class[]{cls});
        Class<Map> cls2 = Map.class;
        gn.a(b(kVar), bVar, a11, "tagEvent", (Class<?>[]) new Class[]{cls, cls2});
        gn.a(b(kVar, "value"), bVar, a11, "tagEvent", (Class<?>[]) new Class[]{cls, cls2, Long.TYPE});
        Class<Long> cls3 = Long.class;
        gn.a(a(kVar, "Localytics Purchased", new String[]{"Item Name", "Item ID", "Item Type", "Item Price"}), bVar, a11, "tagPurchased", (Class<?>[]) new Class[]{cls, cls, cls, cls3, cls2});
        gn.a(a(kVar, "Localytics Added To Cart", new String[]{"Item Name", "Item ID", "Item Type", "Item Price"}), bVar, a11, "tagAddedToCart", (Class<?>[]) new Class[]{cls, cls, cls, cls3, cls2});
        gn.a(a(kVar, "Localytics Started Checkout", new String[]{"Total Price", "Item Count"}), bVar, a11, "tagStartedCheckout", (Class<?>[]) new Class[]{cls3, cls3, cls2});
        gn.a(a(kVar, "Localytics Completed Checkout", new String[]{"Total Price", "Item Count"}), bVar, a11, "tagCompletedCheckout", (Class<?>[]) new Class[]{cls3, cls3, cls2});
        gn.a(a(kVar, "Localytics Content Viewed", new String[]{"Content Name", "Content ID", "Content Type"}), bVar, a11, "tagContentViewed", (Class<?>[]) new Class[]{cls, cls, cls, cls2});
        gn.a(a(kVar, "Localytics Searched", new String[]{"Search Query", "Content Type", "Search Result Count"}), bVar, a11, "tagSearched", (Class<?>[]) new Class[]{cls, cls, cls3, cls2});
        gn.a(a(kVar, "Localytics Shared", new String[]{"Content Name", "Content ID", "Content Type", "Method Name"}), bVar, a11, "tagShared", (Class<?>[]) new Class[]{cls, cls, cls, cls, cls2});
        gn.a(a(kVar, "Localytics Content Rated", new String[]{"Content Name", "Content ID", "Content Type", "Content Rating"}), bVar, a11, "tagContentRated", (Class<?>[]) new Class[]{cls, cls, cls, cls3, cls2});
        gn.a(a(kVar, "Localytics Registered", new String[]{null, "Method Name"}), bVar, a11, "tagCustomerRegistered", (Class<?>[]) new Class[]{b11, cls, cls2});
        gn.a(a(kVar, "Localytics Logged In", new String[]{null, "Method Name"}), bVar, a11, "tagCustomerLoggedIn", (Class<?>[]) new Class[]{b11, cls, cls2});
        gn.a(a(kVar, "Localytics Logged Out", new String[0]), bVar, a11, "tagCustomerLoggedOut", (Class<?>[]) new Class[]{cls2});
        gn.a(a(kVar, "Localytics Invited", new String[]{"Method Name"}), bVar, a11, "tagInvited", (Class<?>[]) new Class[]{cls, cls2});
        bo.h(f41778a, "Localytics detected; now importing data");
    }

    private gk a(final dp.k kVar) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                dk.this.f41780c.a(objArr[0], kVar, (Map<String, Object>) new HashMap());
            }
        };
    }

    private gk a(final dp.k kVar, final String str) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                HashMap hashMap = new HashMap();
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    hashMap.put(str, obj2);
                }
                dk.this.f41780c.a(str, kVar, (Map<String, Object>) hashMap);
            }
        };
    }

    private gk a(final dp.k kVar, final String str, final String[] strArr) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str;
                HashMap hashMap = new HashMap();
                int length = objArr.length;
                String[] strArr = strArr;
                if (length > strArr.length && objArr[strArr.length] != null) {
                    hashMap.putAll(objArr[strArr.length]);
                }
                int i11 = 0;
                while (true) {
                    String[] strArr2 = strArr;
                    if (i11 < strArr2.length) {
                        Object obj2 = objArr[i11];
                        if (!(obj2 == null || (str = strArr2[i11]) == null)) {
                            hashMap.put(str, obj2);
                        }
                        i11++;
                    } else {
                        dk.this.f41780c.a(str, kVar, (Map<String, Object>) hashMap);
                        return;
                    }
                }
            }
        };
    }

    private gk a(final String str) {
        return new gk() {
            public void a(Method method, Object obj, Object[] objArr) {
                String str = objArr[0];
                HashMap hashMap = objArr[1];
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (!hashMap.containsKey("&source")) {
                    HashMap hashMap2 = new HashMap(hashMap);
                    hashMap2.put("&source", str);
                    hashMap = hashMap2;
                }
                dk.this.f41780c.a(str, dp.k.OmnitureV4, (Map<String, Object>) hashMap);
            }
        };
    }

    public static dk a(Context context, as asVar, au auVar) {
        return new dk(context, asVar, auVar);
    }

    public void a(g gVar, au auVar) {
        if (gn.a(gn.b.f42667e)) {
            gVar.a("AN1016");
            if (av.f41248k) {
                gn.a(auVar);
            }
            try {
                this.f41781d.a((fi) new fi() {
                    public void run() {
                        dk.this.c();
                        dk.this.d();
                        dk.this.e();
                        dk.this.f();
                        dk.this.g();
                        dk.this.h();
                        dk.this.i();
                        dk.this.j();
                        dk.this.k();
                        dk.this.l();
                    }
                });
            } finally {
                gVar.c();
            }
        } else {
            bo.j(f41778a, "Apptimize encountered an error or incompatibility when initializing its third party analytics importing.  Third party analytics importing is thus currently unavailable.");
        }
    }

    private void a(Class<?> cls, dp.k kVar) {
        gk b11 = b();
        gn.b bVar = gn.b.f42667e;
        Class<String> cls2 = String.class;
        gn.a(b11, bVar, cls, "set", (Class<?>[]) new Class[]{cls2, cls2});
        gn.a(j(kVar), bVar, cls, "send", (Class<?>[]) new Class[]{Map.class});
    }

    /* access modifiers changed from: private */
    public String a(Object obj, Map<String, String> map) {
        try {
            String str = (String) obj.getClass().getMethod("get", new Class[]{String.class}).invoke(obj, new Object[]{"&tid"});
            if (str != null) {
                return str;
            }
        } catch (NoSuchMethodException unused) {
            bo.a(f41778a, "Could not find GA tracker get method");
        } catch (InvocationTargetException e11) {
            bo.a(f41778a, "Error invoking GA tracker get", e11);
        } catch (IllegalAccessException e12) {
            bo.a(f41778a, "Error invoking GA tracker get", e12);
        }
        if (map.containsKey("&tid")) {
            return map.get("&tid");
        }
        return map.containsKey("&t") ? map.get("&t") : "unnamedEvent";
    }
}
