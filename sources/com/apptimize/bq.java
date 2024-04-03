package com.apptimize;

import com.tekartik.sqflite.Constant;
import java.util.HashMap;
import java.util.Map;

public class bq {

    /* renamed from: a  reason: collision with root package name */
    private Map<b, Map<String, Object>> f41404a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private dt f41405b;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f41411a;

        private a() {
            this.f41411a = null;
        }

        public void a(String str, String str2) {
            if (str != null) {
                this.f41411a = str;
                String str3 = "";
                if (!str3.equals(str2)) {
                    str3 = fd.b(str2);
                }
                bq.this.a(b.A, (Map<String, Object>) new HashMap<String, Object>(str, str3) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ String f41413a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ String f41414b;

                    {
                        this.f41413a = r2;
                        this.f41414b = r3;
                        put(Constant.PARAM_ERROR_CODE, r2);
                        put("attr", r3);
                    }
                });
            }
        }
    }

    public enum b {
        UnknownNamedFilter("unknownNamedFilter"),
        FailedSerialization("failedSerialization"),
        FailedBehaviorFromJsonParse("failedBehaviorJsonParse"),
        ActivitiesInMultipleProcesses("activitiesInMultipleProcesses"),
        UnexpectedSignatureInDebugBuild("unexpectedSignatureInDebugBuild"),
        CouldNotFindViewPager("couldNotFindViewPager"),
        CouldNotFindRecyclerView("couldNotFindRecyclerView"),
        ZeroContentLength("zeroContentLength"),
        NullValueTest("nullValueTest"),
        MultipleValuesForVariable("multipleValuesForVariable"),
        VariableHasWrongType("variableHasWrongType"),
        ProguardProblemDetected("proguardProblemDetected"),
        Crash("crash"),
        CrashReportingNotInitialized("crashReportingNotInitialized"),
        UnexpectedException("unexpectedException"),
        MultiprocessChecksumMismatch("multiprocessChecksumMismatch"),
        MultiprocessIOError("multiprocessIOError"),
        ActionOffMainProcess("actionOffMainProcess"),
        JsonError("jsonError"),
        NestedAdapterViews("nestedAdapterViews"),
        SetupTiming("setupTiming"),
        SetupTimeout("setupTimeout"),
        problemInVisual("problemInVisual"),
        event1("event1"),
        earlyEvent2("earlyEvent2"),
        lateEvent2("lateEvent2");
        
        public static final b A = null;
        public static final b B = null;
        public static final b C = null;
        public static final b D = null;
        private String E;

        /* access modifiers changed from: public */
        static {
            b bVar;
            b bVar2;
            b bVar3;
            b bVar4;
            A = bVar;
            B = bVar2;
            C = bVar4;
            D = bVar3;
        }

        private b(String str) {
            this.E = str;
        }

        public String a() {
            return this.E;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0008, code lost:
        r0 = r3.f41404a.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r1 = r0.next();
        r4.a(((com.apptimize.bq.b) r1.getKey()).a(), (java.util.Map<java.lang.String, java.lang.Object>) (java.util.Map) r1.getValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.apptimize.dt r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.apptimize.dt r0 = r3.f41405b     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0033
            r3.f41405b = r4     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            java.util.Map<com.apptimize.bq$b, java.util.Map<java.lang.String, java.lang.Object>> r0 = r3.f41404a
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.apptimize.bq$b r2 = (com.apptimize.bq.b) r2
            java.lang.String r2 = r2.a()
            java.lang.Object r1 = r1.getValue()
            java.util.Map r1 = (java.util.Map) r1
            r4.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r1)
            goto L_0x0012
        L_0x0032:
            return
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.bq.a(com.apptimize.dt):void");
    }

    public void b(String str, String str2, String str3) {
        a(str, false, str2, str3);
    }

    public Object b() {
        return new a();
    }

    public void a(b bVar) {
        a(bVar, (Map<String, Object>) new HashMap());
    }

    public void a(b bVar, Exception exc) {
        a(bVar, (Map<String, Object>) new HashMap<String, Object>(exc) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f41406a;

            {
                this.f41406a = r2;
                put("attr", fd.b(fx.a(r2)));
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        r3 = r1.f41405b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r3.a(r2.a(), (java.util.Map<java.lang.String, java.lang.Object>) r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.apptimize.bq.b r2, java.util.Map<java.lang.String, java.lang.Object> r3) {
        /*
            r1 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r3)
            monitor-enter(r1)
            java.util.Map<com.apptimize.bq$b, java.util.Map<java.lang.String, java.lang.Object>> r3 = r1.f41404a     // Catch:{ all -> 0x0022 }
            boolean r3 = r3.containsKey(r2)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x0020
            java.util.Map<com.apptimize.bq$b, java.util.Map<java.lang.String, java.lang.Object>> r3 = r1.f41404a     // Catch:{ all -> 0x0022 }
            r3.put(r2, r0)     // Catch:{ all -> 0x0022 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            com.apptimize.dt r3 = r1.f41405b
            if (r3 == 0) goto L_0x001f
            java.lang.String r2 = r2.a()
            r3.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.Object>) r0)
        L_0x001f:
            return
        L_0x0020:
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.bq.a(com.apptimize.bq$b, java.util.Map):void");
    }

    public void a(String str, String str2, String str3) {
        a(str, true, str2, str3);
    }

    public void a(String str, boolean z11, String str2, String str3) {
        if (z11) {
            bo.j(str, "Internal error: " + str2);
        }
        if (av.f41239b) {
            bo.j(str, "Details: " + str3);
        }
        String str4 = "";
        if (!str4.equals(str3)) {
            str4 = fd.b(str3);
        }
        a(b.A, (Map<String, Object>) new HashMap<String, Object>(str2, str4) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f41408a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f41409b;

            {
                this.f41408a = r2;
                this.f41409b = r3;
                put(Constant.PARAM_ERROR_CODE, r2);
                put("attr", r3);
            }
        });
    }

    public String a(au auVar) {
        new a().a((String) null, "");
        return fn.a(auVar, (Class<?>) a.class);
    }

    public static String a() {
        return fn.a(a.class);
    }

    public String a(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).f41411a;
        }
        return null;
    }
}
