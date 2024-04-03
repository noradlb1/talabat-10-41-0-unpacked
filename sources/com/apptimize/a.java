package com.apptimize;

import com.apptimize.ApptimizeInstantUpdateOrWinnerInfo;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.utility.JavaConstant;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f41002a = true;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f41003b = "a";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Method f41004c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f41005d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f41006e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f41007f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Method f41008g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Method f41009h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Method f41010i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f41011j = "Unknown";

    /* renamed from: k  reason: collision with root package name */
    private b f41012k;

    /* renamed from: l  reason: collision with root package name */
    private final fo f41013l;

    /* renamed from: m  reason: collision with root package name */
    private int f41014m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final dt f41015n;

    public a(au auVar, dt dtVar) {
        this.f41015n = dtVar;
        this.f41013l = auVar.b().a((fi) new fi() {
            public void run() {
                a.this.e();
            }
        });
    }

    private void d() {
        int i11 = this.f41014m;
        if (i11 >= 5) {
            bo.k(f41003b, "Failed to configure Airship connections");
            return;
        }
        this.f41013l.a(Math.min(15000, Math.max(((long) Math.pow(2.0d, (double) i11)) * 1000, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS)));
        this.f41014m++;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x00ed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "com.urbanairship.UAirship"
            java.lang.Class r2 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r0 = "isFlying"
            r8 = 0
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r0, r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r3 = 0
            java.lang.Object r0 = r0.invoke(r3, r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            boolean r0 = r0.booleanValue()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            if (r0 != 0) goto L_0x0024
            r11.d()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            monitor-exit(r11)
            return
        L_0x0024:
            java.lang.String r0 = "shared"
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r0, r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r1 = "getVersion"
            java.lang.Class[] r4 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r1 = r2.getDeclaredMethod(r1, r4)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Object r3 = r0.invoke(r3, r4)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Object r1 = r1.invoke(r3, r4)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41011j = r1     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r1 = "com.urbanairship.channel.AirshipChannel"
            java.lang.Class r3 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r1 = "com.urbanairship.channel.TagGroupsEditor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r4 = "com.urbanairship.channel.AirshipChannelListener"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "getChannel"
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r2.getDeclaredMethod(r5, r6)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41005d = r5     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "addChannelListener"
            r6 = 1
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r7[r8] = r4     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r3.getDeclaredMethod(r5, r7)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41006e = r5     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "editTagGroups"
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r3.getDeclaredMethod(r5, r7)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41007f = r5     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "addTags"
            r7 = 2
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r9[r8] = r10     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Class<java.util.Set> r10 = java.util.Set.class
            r9[r6] = r10     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r1.getDeclaredMethod(r5, r9)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41008g = r5     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "setTags"
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r7[r8] = r9     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.Class<java.util.Set> r9 = java.util.Set.class
            r7[r6] = r9     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r1.getDeclaredMethod(r5, r7)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41009h = r5     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r5 = "apply"
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r5, r6)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41010i = r1     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41004c = r0     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.a((java.lang.Class<?>) r4)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            com.apptimize.b r0 = new com.apptimize.b     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r4 = r11.f41011j     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r5 = r11.f41004c     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.reflect.Method r6 = r11.f41005d     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            com.apptimize.a$2 r7 = new com.apptimize.a$2     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r7.<init>()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41012k = r0     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r0 = f41003b     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r2 = "Airship version "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r2 = r11.f41011j     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r2 = " found (supported version "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r2 = ">= 12.0.0 and < 17.0.0"
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r2 = "). Enrollment and participation tags will be exported to Airship."
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            com.apptimize.bo.h(r0, r1)     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.b()     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            r11.f41014m = r8     // Catch:{ ClassNotFoundException -> 0x010b, Exception -> 0x00ed }
            goto L_0x0128
        L_0x00eb:
            r0 = move-exception
            goto L_0x012a
        L_0x00ed:
            java.lang.String r0 = f41003b     // Catch:{ all -> 0x00eb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r1.<init>()     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "Airship methods not found. Expected version >= 12.0.0 and < 17.0.0 found version "
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = r11.f41011j     // Catch:{ all -> 0x00eb }
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "."
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00eb }
            com.apptimize.bo.g(r0, r1)     // Catch:{ all -> 0x00eb }
            goto L_0x0128
        L_0x010b:
            java.lang.String r0 = f41003b     // Catch:{ all -> 0x00eb }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00eb }
            r1.<init>()     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "Airship classes not found. Expected version >= 12.0.0 and < 17.0.0 found version "
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = r11.f41011j     // Catch:{ all -> 0x00eb }
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = ". Enrollment and participation tags will not be exported to Airship."
            r1.append(r2)     // Catch:{ all -> 0x00eb }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00eb }
            com.apptimize.bo.g(r0, r1)     // Catch:{ all -> 0x00eb }
        L_0x0128:
            monitor-exit(r11)
            return
        L_0x012a:
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.a.e():void");
    }

    /* access modifiers changed from: private */
    public synchronized Object f() {
        Method method = this.f41004c;
        if (method == null) {
            return null;
        }
        try {
            return this.f41007f.invoke(this.f41005d.invoke(method.invoke((Object) null, new Object[0]), new Object[0]), new Object[0]);
        } catch (Exception e11) {
            bo.e(f41003b, "Error invoking Airship -- Could not invoke tag group editor.", e11);
            return null;
        }
    }

    public synchronized void a() {
        this.f41013l.a();
    }

    public void b() {
        if (this.f41015n.a((cj) null)) {
            a(this.f41015n.s(), this.f41015n.t());
            b bVar = this.f41012k;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    private synchronized void a(Class<?> cls) {
        try {
            Object invoke = this.f41005d.invoke(this.f41004c.invoke((Object) null, new Object[0]), new Object[0]);
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    try {
                        if (!method.getName().equals("onChannelCreated")) {
                            if (!method.getName().equals("onChannelUpdated")) {
                                String c11 = a.f41003b;
                                bo.g(c11, "Unexpected method invoked on Airship Registration Listener: " + method.getName());
                                return null;
                            }
                        }
                        a.this.b();
                        return null;
                    } catch (Exception e11) {
                        bo.e(a.f41003b, "Unexpected error in Airship Registration Listener: ", e11);
                        return null;
                    }
                }
            });
            this.f41006e.invoke(invoke, new Object[]{cls.cast(newProxyInstance)});
        } catch (Exception e11) {
            bo.e(f41003b, "Error invoking Airship -- Could not register Airship RegistrationListener.", e11);
        }
        return;
    }

    public void b(final Set<String> set) {
        fg.f42428c.submit(new Runnable() {
            public void run() {
                Set set;
                Object c11 = a.this.f();
                if (c11 != null && (set = set) != null && !set.isEmpty()) {
                    try {
                        a.this.f41008g.invoke(c11, new Object[]{"ua_apptimize", set});
                        a.this.f41010i.invoke(c11, new Object[0]);
                        String c12 = a.f41003b;
                        bo.i(c12, "Added airship tags: " + c.a((Collection<String>) set, IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                    } catch (Exception e11) {
                        bo.e(a.f41003b, "Error invoking Airship -- Could not add Airship tags.", e11);
                    }
                }
            }
        });
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6 = str + JavaConstant.Dynamic.DEFAULT_NAME + str2 + JavaConstant.Dynamic.DEFAULT_NAME;
        if (str4 == null || str4.length() == 0) {
            str5 = "";
        } else {
            str5 = JavaConstant.Dynamic.DEFAULT_NAME + str4;
        }
        if (str6.length() + str3.length() + str5.length() > 127) {
            int i11 = 75;
            int i12 = 36;
            if (str3.length() < 75) {
                i12 = 36 + (75 - str3.length());
            }
            if (str5.length() < i12) {
                i11 = 75 + (i12 - str5.length());
            }
            str3 = str3.substring(0, Math.min(str3.length(), i11));
            str5 = str5.substring(0, Math.min(str5.length(), i12));
        }
        if (f41002a || str6.length() + str3.length() + str5.length() <= 127) {
            return str6 + str3 + str5;
        }
        throw new AssertionError();
    }

    public void a(final Set<String> set) {
        fg.f42428c.submit(new Runnable() {
            public void run() {
                Object c11 = a.this.f();
                if (c11 != null) {
                    try {
                        a.this.f41009h.invoke(c11, new Object[]{"ua_apptimize", set});
                        a.this.f41010i.invoke(c11, new Object[0]);
                        String c12 = a.f41003b;
                        bo.i(c12, "Set airship tags to: " + c.a((Collection<String>) set, IndicativeSentencesGeneration.DEFAULT_SEPARATOR));
                    } catch (Exception e11) {
                        bo.e(a.f41003b, "Error invoking Airship -- Could not set Airship tags.", e11);
                    }
                }
            }
        });
    }

    public void a(final Map<String, ApptimizeTestInfo> map, final Map<String, ApptimizeInstantUpdateOrWinnerInfo> map2) {
        fg.f42428c.submit(new Runnable() {
            public void run() {
                if (a.this.f41004c != null) {
                    try {
                        HashSet hashSet = new HashSet();
                        Map map = map;
                        if (map != null) {
                            for (Map.Entry value : map.entrySet()) {
                                ApptimizeTestInfo apptimizeTestInfo = (ApptimizeTestInfo) value.getValue();
                                if (apptimizeTestInfo.userHasParticipated()) {
                                    hashSet.add(a.a(apptimizeTestInfo, Boolean.TRUE));
                                }
                                hashSet.add(a.a(apptimizeTestInfo, Boolean.FALSE));
                            }
                        }
                        Map map2 = map2;
                        if (map2 != null) {
                            for (Map.Entry value2 : map2.entrySet()) {
                                hashSet.add(a.a((ApptimizeInstantUpdateOrWinnerInfo) value2.getValue()));
                            }
                        }
                        if (hashSet.size() > 0) {
                            a.this.a((Set<String>) hashSet);
                        }
                    } catch (Exception e11) {
                        bo.e(a.f41003b, "Error invoking Airship -- Could not synchronize Airship tags.", e11);
                    }
                }
            }
        });
    }

    public static String a(ApptimizeTestInfo apptimizeTestInfo, Boolean bool) {
        return a(bool.booleanValue() ? "Participated" : "Enrolled", apptimizeTestInfo.getApptimizeTestType() == ApptimizeTestType.FEATURE_FLAG ? "FF" : "AB", apptimizeTestInfo.getTestName(), apptimizeTestInfo.getEnrolledVariantName());
    }

    public static String a(ApptimizeInstantUpdateOrWinnerInfo apptimizeInstantUpdateOrWinnerInfo) {
        if (apptimizeInstantUpdateOrWinnerInfo.getType() == ApptimizeInstantUpdateOrWinnerInfo.Type.INSTANT_UPDATE) {
            return a("Enrolled", "IU", apptimizeInstantUpdateOrWinnerInfo.getInstantUpdateName(), (String) null);
        }
        return a("Enrolled", "WV", apptimizeInstantUpdateOrWinnerInfo.getWinningTestName(), apptimizeInstantUpdateOrWinnerInfo.getWinningVariantName());
    }
}
