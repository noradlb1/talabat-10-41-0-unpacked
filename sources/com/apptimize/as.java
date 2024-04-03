package com.apptimize;

import android.content.Context;
import android.os.StrictMode;
import com.apptimize.Apptimize;
import com.apptimize.bd;
import com.apptimize.bq;
import com.apptimize.bt;
import com.apptimize.dl;
import com.apptimize.dp;
import com.apptimize.j;
import com.google.android.exoplayer2.C;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class as {

    /* renamed from: a  reason: collision with root package name */
    public static String f41212a = "pilot_targeting_id";

    /* renamed from: b  reason: collision with root package name */
    static final Set<String> f41213b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f41214c = "as";

    /* renamed from: d  reason: collision with root package name */
    private final ge f41215d;

    /* renamed from: e  reason: collision with root package name */
    private final dt f41216e;

    /* renamed from: f  reason: collision with root package name */
    private final au f41217f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f41218g;

    /* renamed from: h  reason: collision with root package name */
    private final String f41219h;

    /* renamed from: i  reason: collision with root package name */
    private final bd.a f41220i;

    /* renamed from: j  reason: collision with root package name */
    private final bd.a f41221j;

    /* renamed from: k  reason: collision with root package name */
    private final ApptimizeOptions f41222k;

    /* renamed from: l  reason: collision with root package name */
    private final Properties f41223l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f41224m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f41225n;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public enum b {
        PRODUCTION("BZcwxDPSFpPgnucXHNEwrwLE3dNZTz4"),
        STAGING("DcWRXdehUvkTgefxLBHLeubRh7yA7Ga");
        

        /* renamed from: c  reason: collision with root package name */
        private String f41229c;

        private b(String str) {
            this.f41229c = str;
        }

        public String a() {
            return this.f41229c;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("server");
        hashSet.add("web_socket_url");
        hashSet.add("meta_data_url");
        hashSet.add("pilot_groups_url_format");
        hashSet.add("production_token_url");
        hashSet.add("meta_data_period");
        hashSet.add("results_period");
        hashSet.add("use_local_public_key");
        hashSet.add("app_key");
        hashSet.add("server_region");
        hashSet.add("force_developer_mode");
        hashSet.add("enable_device_pairing");
        hashSet.add("enable_qa_logs");
        hashSet.add("variant_refresh_period");
        f41213b = Collections.unmodifiableSet(hashSet);
    }

    public as(dt dtVar, ge geVar, au auVar, Context context, String str, bd.a aVar, bd.a aVar2, ApptimizeOptions apptimizeOptions, Properties properties, boolean z11, boolean z12) {
        this.f41216e = dtVar;
        this.f41215d = geVar;
        this.f41217f = auVar;
        this.f41218g = context;
        this.f41219h = str;
        this.f41220i = aVar;
        this.f41221j = aVar2;
        this.f41222k = apptimizeOptions;
        this.f41223l = properties;
        this.f41224m = z11;
        this.f41225n = z12;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|(2:15|16)(2:17|(2:19|20)(1:21))|(4:23|24|25|(5:29|30|31|32|33))|26|(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r7.contains("variant") != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = r7.replace("variant", "variation");
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r7.contains("variation") != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r2 = r7.replace("variation", "variant");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r10 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r10 = r7;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r2 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r7 = r2;
        r2 = r16.getClass().getMethod(r2, new java.lang.Class[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        if (r2 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.apptimize.bo.g(f41214c, "Method " + r10 + "() of code block " + r1 + " isn't implemented.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r16.baseline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f9, code lost:
        if ((r0.getCause() instanceof java.lang.RuntimeException) != false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00fb, code lost:
        com.apptimize.bo.e(f41214c, "Method " + r7 + "() of code block " + r1 + " threw a runtime exception.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011e, code lost:
        return (java.lang.RuntimeException) r0.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011f, code lost:
        com.apptimize.bo.e(f41214c, "Method " + r7 + "() of code block " + r1 + " threw a non-runtime exception; this should be impossible.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0140, code lost:
        r8 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0080 A[SYNTHETIC, Splitter:B:35:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab A[Catch:{ RuntimeException -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f2 A[ExcHandler: InvocationTargetException (r0v4 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:51:0x00e8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.RuntimeException a(com.apptimize.ApptimizeTest r16, com.apptimize.bt.a r17, java.lang.String r18, com.apptimize.dt r19) {
        /*
            r1 = r18
            r0 = r19
            java.lang.String r2 = "variant"
            java.lang.String r3 = " threw a runtime exception."
            java.lang.String r4 = "() of code block "
            java.lang.String r5 = "Method "
            java.lang.String r6 = "baseline"
            if (r17 == 0) goto L_0x0019
            java.lang.String r7 = r17.g()     // Catch:{ RuntimeException -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r0 = move-exception
            goto L_0x0165
        L_0x0019:
            r7 = r6
        L_0x001a:
            r8 = 0
            r9 = 0
            java.lang.Class r10 = r16.getClass()     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ NoSuchMethodException -> 0x002b }
            java.lang.reflect.Method r2 = r10.getMethod(r7, r11)     // Catch:{ NoSuchMethodException -> 0x002b }
            goto L_0x007e
        L_0x0027:
            r0 = move-exception
            r6 = r7
            goto L_0x0165
        L_0x002b:
            boolean r10 = r7.contains(r2)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r11 = "variation"
            if (r10 == 0) goto L_0x003a
            java.lang.String r2 = r7.replace(r2, r11)     // Catch:{ RuntimeException -> 0x0027 }
            r10 = r7
            goto L_0x0048
        L_0x003a:
            boolean r10 = r7.contains(r11)     // Catch:{ RuntimeException -> 0x0027 }
            if (r10 == 0) goto L_0x0046
            java.lang.String r2 = r7.replace(r11, r2)     // Catch:{ RuntimeException -> 0x0027 }
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r7
            r2 = r9
        L_0x0048:
            if (r2 == 0) goto L_0x0058
            java.lang.Class r11 = r16.getClass()     // Catch:{ NoSuchMethodException -> 0x0058 }
            java.lang.Class[] r12 = new java.lang.Class[r8]     // Catch:{ NoSuchMethodException -> 0x0058 }
            java.lang.reflect.Method r7 = r11.getMethod(r2, r12)     // Catch:{ NoSuchMethodException -> 0x0058 }
            r15 = r7
            r7 = r2
            r2 = r15
            goto L_0x0059
        L_0x0058:
            r2 = r9
        L_0x0059:
            if (r2 != 0) goto L_0x007e
            java.lang.String r0 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r2.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r5)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r10)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r8 = " isn't implemented."
            r2.append(r8)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r2 = r2.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.g(r0, r2)     // Catch:{ RuntimeException -> 0x0027 }
            r16.baseline()     // Catch:{ RuntimeException -> 0x0016 }
            return r9
        L_0x007e:
            if (r17 == 0) goto L_0x00a3
            java.lang.String r10 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r11.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r12 = "Code block '"
            r11.append(r12)     // Catch:{ RuntimeException -> 0x0027 }
            r11.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r12 = "' is running "
            r11.append(r12)     // Catch:{ RuntimeException -> 0x0027 }
            r11.append(r7)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r12 = "()"
            r11.append(r12)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r11 = r11.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.h(r10, r11)     // Catch:{ RuntimeException -> 0x0027 }
        L_0x00a3:
            java.lang.Class[] r10 = r2.getExceptionTypes()     // Catch:{ RuntimeException -> 0x0027 }
            int r11 = r10.length     // Catch:{ RuntimeException -> 0x0027 }
            r12 = r8
        L_0x00a9:
            if (r12 >= r11) goto L_0x00db
            r13 = r10[r12]     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.Class<java.lang.RuntimeException> r14 = java.lang.RuntimeException.class
            boolean r13 = r14.isAssignableFrom(r13)     // Catch:{ RuntimeException -> 0x0027 }
            if (r13 != 0) goto L_0x00d8
            java.lang.String r0 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r2.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r5)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r7)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x0027 }
            r2.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r8 = " declares non-runtime exceptions that may be thrown; running the baseline instead."
            r2.append(r8)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r2 = r2.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.g(r0, r2)     // Catch:{ RuntimeException -> 0x0027 }
            r16.baseline()     // Catch:{ RuntimeException -> 0x0016 }
            return r9
        L_0x00d8:
            int r12 = r12 + 1
            goto L_0x00a9
        L_0x00db:
            if (r17 == 0) goto L_0x00e8
            if (r0 == 0) goto L_0x00e8
            java.lang.String r10 = "block"
            java.lang.String r10 = com.apptimize.bt.a(r10, r9, r1)     // Catch:{ RuntimeException -> 0x0027 }
            r0.c((java.lang.String) r10)     // Catch:{ RuntimeException -> 0x0027 }
        L_0x00e8:
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ IllegalAccessException -> 0x013f, InvocationTargetException -> 0x00f2 }
            r8 = r16
            r2.invoke(r8, r0)     // Catch:{ IllegalAccessException -> 0x00f0, InvocationTargetException -> 0x00f2 }
            return r9
        L_0x00f0:
            r0 = move-exception
            goto L_0x0142
        L_0x00f2:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ RuntimeException -> 0x0027 }
            boolean r2 = r2 instanceof java.lang.RuntimeException     // Catch:{ RuntimeException -> 0x0027 }
            if (r2 == 0) goto L_0x011f
            java.lang.String r2 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r6.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r5)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r4)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r3)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.e(r2, r6, r0)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.Throwable r0 = r0.getCause()     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch:{ RuntimeException -> 0x0027 }
            return r0
        L_0x011f:
            java.lang.String r2 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r6.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r5)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r4)     // Catch:{ RuntimeException -> 0x0027 }
            r6.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r8 = " threw a non-runtime exception; this should be impossible."
            r6.append(r8)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.e(r2, r6, r0)     // Catch:{ RuntimeException -> 0x0027 }
            return r9
        L_0x013f:
            r0 = move-exception
            r8 = r16
        L_0x0142:
            java.lang.String r2 = f41214c     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0027 }
            r10.<init>()     // Catch:{ RuntimeException -> 0x0027 }
            r10.append(r5)     // Catch:{ RuntimeException -> 0x0027 }
            r10.append(r7)     // Catch:{ RuntimeException -> 0x0027 }
            r10.append(r4)     // Catch:{ RuntimeException -> 0x0027 }
            r10.append(r1)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r11 = " isn't public."
            r10.append(r11)     // Catch:{ RuntimeException -> 0x0027 }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x0027 }
            com.apptimize.bo.e(r2, r10, r0)     // Catch:{ RuntimeException -> 0x0027 }
            r16.baseline()     // Catch:{ RuntimeException -> 0x0016 }
            return r9
        L_0x0165:
            java.lang.String r2 = f41214c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r7.append(r6)
            r7.append(r4)
            r7.append(r1)
            r7.append(r3)
            java.lang.String r1 = r7.toString()
            com.apptimize.bo.e(r2, r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.as.a(com.apptimize.ApptimizeTest, com.apptimize.bt$a, java.lang.String, com.apptimize.dt):java.lang.RuntimeException");
    }

    public static String k(Properties properties) {
        return properties.getProperty("app_key");
    }

    public static Boolean l(Properties properties) {
        String property = properties.getProperty("enable_device_pairing");
        if (property != null) {
            return Boolean.valueOf(property);
        }
        return null;
    }

    public static j.b m(Properties properties) throws a {
        if (!properties.containsKey("server_region")) {
            return null;
        }
        String property = properties.getProperty("server_region");
        String lowerCase = property.toLowerCase();
        lowerCase.hashCode();
        char c11 = 65535;
        switch (lowerCase.hashCode()) {
            case 102164:
                if (lowerCase.equals("gcp")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3124512:
                if (lowerCase.equals("eucs")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1544803905:
                if (lowerCase.equals("default")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return j.b.GCP;
            case 1:
                return j.b.EUCS;
            case 2:
                return j.b.DEFAULT;
            default:
                throw new a("Unrecognized value for server region: " + property);
        }
    }

    public static boolean n(Properties properties) {
        String property = properties.getProperty("force_developer_mode");
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    public static boolean o(Properties properties) {
        String property = properties.getProperty("enable_qa_logs");
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    public ge b() {
        return this.f41215d;
    }

    public ak c() {
        return this.f41217f.d();
    }

    public Map<String, ApptimizeTestInfo> d() {
        return this.f41216e.s();
    }

    public Map<String, ApptimizeInstantUpdateOrWinnerInfo> e() {
        return this.f41216e.t();
    }

    public Map<Long, Map<String, Object>> f() {
        return this.f41216e.u();
    }

    public String g() {
        return this.f41216e.v();
    }

    public String h() {
        return this.f41216e.w();
    }

    public EnumSet<Apptimize.ApptimizeMetadataStateFlags> i() {
        return this.f41216e.i();
    }

    public Integer j() {
        ed y11 = this.f41216e.y();
        if (y11 == null) {
            return 0;
        }
        return Integer.valueOf(y11.b());
    }

    public boolean p() {
        return this.f41224m;
    }

    public boolean q() {
        return this.f41225n;
    }

    public static Integer d(Properties properties) throws a {
        String property = properties.getProperty("variant_refresh_period");
        if (property == null) {
            return null;
        }
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt(property));
            if (valueOf == null) {
                return null;
            }
            if (valueOf.longValue() >= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                return valueOf;
            }
            bo.j(f41214c, "variant_refresh_period cannot be less than 3000");
            return 3000;
        } catch (NumberFormatException unused) {
            throw new a("Could not parse value for meta_data_period as a Long");
        }
    }

    public static String e(Properties properties) throws a {
        if (properties.containsKey("web_socket_url")) {
            return properties.getProperty("web_socket_url");
        }
        return a(j.c.WEB_SOCKET, properties);
    }

    public static String f(Properties properties) throws a {
        if (properties.containsKey("meta_data_url")) {
            return properties.getProperty("meta_data_url");
        }
        return a(j.c.LOW_LATENCY_METADATA, properties);
    }

    public static String g(Properties properties) throws a {
        if (properties.containsKey("pilot_groups_url_format")) {
            return properties.getProperty("pilot_groups_url_format");
        }
        return a(j.c.PILOT_GROUPS, properties);
    }

    public static Long h(Properties properties) throws a {
        String property;
        if (f(properties) == null || (property = properties.getProperty("meta_data_period")) == null) {
            return null;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(property));
            if (valueOf == null) {
                return null;
            }
            if (valueOf.longValue() >= 5000) {
                return valueOf;
            }
            bo.j(f41214c, "meta_data_period cannot be less than 5000");
            return 5000L;
        } catch (NumberFormatException unused) {
            throw new a("Could not parse value for meta_data_period as a Long");
        }
    }

    public static Long i(Properties properties) throws a {
        String property;
        if (f(properties) == null || (property = properties.getProperty("results_period")) == null) {
            return null;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(property));
            if (valueOf == null) {
                return null;
            }
            if (valueOf.longValue() >= 5000) {
                return valueOf;
            }
            bo.j(f41214c, "results_period cannot be less than 5000");
            return 5000L;
        } catch (NumberFormatException unused) {
            throw new a("Could not parse value for results_period as a Long");
        }
    }

    public void b(String str, double d11) {
        this.f41216e.a(str, d11);
    }

    public void c(String str) {
        bs.a("setUserId ", (Object) str);
        c.a(this.f41218g, str);
        this.f41216e.f(str);
    }

    public void k() {
        a(this.f41220i, this.f41221j, this.f41218g, this.f41217f);
    }

    public Map<String, Object> b(dl.b bVar) {
        return this.f41216e.b(bVar);
    }

    public Context l() {
        return this.f41218g;
    }

    public ApptimizeOptions n() {
        return this.f41222k;
    }

    public Properties o() {
        return this.f41223l;
    }

    public static Boolean j(Properties properties) {
        String property = properties.getProperty("use_local_public_key");
        if (property != null) {
            return Boolean.valueOf(property);
        }
        return null;
    }

    public Object b(String str) {
        return a(dl.b.UserAttribute, str);
    }

    public static String c(Properties properties) throws a {
        String property = properties.getProperty("server");
        if (property == null) {
            return b.PRODUCTION.a();
        }
        String lowerCase = property.toLowerCase();
        lowerCase.hashCode();
        if (lowerCase.equals("staging")) {
            return b.STAGING.a();
        }
        if (lowerCase.equals("prod")) {
            return b.PRODUCTION.a();
        }
        throw new a("Unrecognized value for server environment: " + property);
    }

    public void b(Apptimize.OnExperimentsProcessedListener onExperimentsProcessedListener) {
        this.f41216e.b(onExperimentsProcessedListener);
    }

    public void b(Apptimize.MetadataStateChangedListener metadataStateChangedListener) {
        this.f41216e.b(metadataStateChangedListener);
    }

    public static String b(Properties properties) throws a {
        if (properties.containsKey("production_token_url")) {
            return properties.getProperty("production_token_url");
        }
        return a(j.c.PAIRING_TOKEN, properties);
    }

    public String m() {
        return this.f41219h;
    }

    public RuntimeException a(String str, ApptimizeTest apptimizeTest) {
        bt.a aVar = null;
        try {
            bt.f b11 = this.f41216e.b(bt.a("block", (String) null, str));
            if (b11 == null) {
                String str2 = f41214c;
                bo.f(str2, "Code block '" + str + "' is not currently affected by any of this device's enrolled experiments");
            } else if (b11 instanceof bt.a) {
                aVar = (bt.a) b11;
            } else {
                String str3 = f41214c;
                bo.h(str3, "Attempted to run code block with the name of an ApptimizeVar '" + str + "'; running baseline.");
            }
            return a(apptimizeTest, aVar, str, this.f41216e);
        } catch (Exception e11) {
            bo.d(f41214c, "Apptimize threw an exception which wasn't caught; this should not have happened; running the baseline to be safe.", e11);
            try {
                apptimizeTest.baseline();
                return null;
            } catch (RuntimeException e12) {
                return e12;
            }
        }
    }

    public dt a() {
        return this.f41216e;
    }

    public void a(String str) {
        this.f41216e.d(str);
    }

    public void a(String str, double d11) {
        this.f41216e.b(str, d11);
    }

    public void a(String str, dp.k kVar, Map<String, Object> map) {
        this.f41216e.a(str, kVar, (Map<String, Object>) new HashMap(map));
    }

    public <T> T a(ApptimizeVar<T> apptimizeVar) {
        T a11 = k.a(apptimizeVar);
        String e11 = k.e(apptimizeVar);
        bt.f b11 = this.f41216e.b(e11);
        if (b11 == null) {
            String str = f41214c;
            bo.f(str, "ApptimizeVar " + bt.a(e11) + " is not currently affected by any of this device's enrolled experiments");
            return a11;
        } else if (!b11.a().equals(k.c(apptimizeVar))) {
            String str2 = f41214c;
            bo.g(str2, "Tried to set ApptimizeVar " + bt.a(e11) + " with a value of type " + b11.a() + "; returning default value.");
            this.f41217f.a().a(bq.b.VariableHasWrongType);
            return a11;
        } else {
            String d11 = k.d(apptimizeVar);
            if (d11 != null) {
                if (!(b11 instanceof bt.h)) {
                    String str3 = f41214c;
                    bo.g(str3, "Tried to set ApptimizeVar " + bt.a(e11) + " with a non-nested type; returning default value.");
                    this.f41217f.a().a(bq.b.VariableHasWrongType);
                    return a11;
                }
                String h11 = ((bt.h) b11).h();
                if (!d11.equals(h11)) {
                    String str4 = f41214c;
                    bo.g(str4, "Tried to set ApptimizeVar " + bt.a(e11) + " with a value with nested type " + h11 + "; returning default value.");
                    this.f41217f.a().a(bq.b.VariableHasWrongType);
                    return a11;
                }
            }
            this.f41216e.c(e11);
            if (!b11.k()) {
                a11 = b11.i();
            }
            String str5 = f41214c;
            bo.h(str5, "ApptimizeVar " + bt.a(e11) + " has value '" + a11 + "'");
            return a11;
        }
    }

    public void a(boolean z11, Map<String, Object> map) {
        this.f41216e.a(z11, map);
        ge b11 = b();
        if (b11 != null) {
            b11.i();
        }
    }

    public void a(dl.b bVar, String str, Object obj) {
        this.f41216e.a(bVar, str, obj);
        ge b11 = b();
        if (b11 != null) {
            b11.i();
        }
    }

    public void a(dl.b bVar, Map<String, Object> map) {
        this.f41216e.a(bVar, false, map);
        ge b11 = b();
        if (b11 != null) {
            b11.i();
        }
    }

    public void a(dl.b bVar) {
        this.f41216e.a(bVar);
        ge b11 = b();
        if (b11 != null) {
            b11.i();
        }
    }

    public Object a(dl.b bVar, String str) {
        return this.f41216e.a(bVar, str);
    }

    public void a(Apptimize.OnExperimentRunListener onExperimentRunListener) {
        this.f41216e.a(onExperimentRunListener);
    }

    public void a(Apptimize.OnTestRunListener onTestRunListener) {
        this.f41216e.a(onTestRunListener);
    }

    public void a(Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener) {
        this.f41216e.a(onTestEnrollmentChangedListener);
    }

    public void a(Apptimize.OnExperimentsProcessedListener onExperimentsProcessedListener) {
        this.f41216e.a(onExperimentsProcessedListener);
    }

    public void a(Apptimize.MetadataStateChangedListener metadataStateChangedListener) {
        this.f41216e.a(metadataStateChangedListener);
    }

    public static void a(Properties properties) throws a {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            String property = properties.getProperty(str);
            if (property == null || !f41213b.contains(str)) {
                throw new a("Unrecognized key in properties file: " + str);
            }
            properties.setProperty(str, property.trim());
        }
    }

    private static String a(j.c cVar, Properties properties) throws a {
        j.a aVar;
        if (properties.containsKey("server")) {
            String property = properties.getProperty("server");
            String lowerCase = property.toLowerCase();
            lowerCase.hashCode();
            if (lowerCase.equals("staging")) {
                aVar = j.a.STAGING;
            } else if (lowerCase.equals("prod")) {
                aVar = j.a.PROD;
            } else {
                throw new a("Unrecognized value for server environment: " + property);
            }
        } else {
            aVar = null;
        }
        j.b m11 = m(properties);
        if (m11 == null && aVar == null) {
            return null;
        }
        if (aVar == null) {
            aVar = j.a.PROD;
        }
        if (m11 != null) {
            return j.a(cVar, aVar, m11);
        }
        return j.a(cVar, aVar);
    }

    public static void a(bd.a aVar, bd.a aVar2, Context context, au auVar) {
        a(aVar, aVar2);
        i.a().a(context);
        g.a(context, auVar);
        fx.a(ig.a(context));
    }

    public static void a(bd.a aVar, bd.a aVar2) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            aVar.b().a();
            aVar2.b().a();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public RuntimeException a(ApptimizeTest apptimizeTest, String str, String str2) {
        return a(apptimizeTest, new bt.a(str, str2, false, (bv) null, (cf) null), str, this.f41216e);
    }
}
