package com.apptimize;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.apptimize.ApptimizeOptions;
import com.apptimize.as;
import com.apptimize.aw;
import com.apptimize.bd;
import com.apptimize.bj;
import com.apptimize.bq;
import com.apptimize.bt;
import com.apptimize.dl;
import com.apptimize.h;
import com.apptimize.j;
import com.apptimize.t;
import com.facebook.appevents.UserDataStore;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Apptimize {
    /* access modifiers changed from: private */
    public static OnTestEnrollmentChangedListener A = null;
    /* access modifiers changed from: private */
    public static OnApptimizeInitializedListener B = null;
    /* access modifiers changed from: private */
    public static List<OnExperimentsProcessedListener> C = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public static List<MetadataStateChangedListener> D = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public static boolean E = false;
    /* access modifiers changed from: private */
    public static Map<String, String> F = new HashMap();
    /* access modifiers changed from: private */
    public static Map<ApptimizeVar, Object> G = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f40768a = "Apptimize";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40769b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static as f40770c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static x f40771d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static z f40772e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static y f40773f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static gr f40774g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static Boolean f40775h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static g f40776i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static dk f40777j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static eb f40778k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static d f40779l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static r f40780m;

    /* renamed from: n  reason: collision with root package name */
    private static AtomicLong f40781n = new AtomicLong(0);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static ApptimizeOptions f40782o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static a f40783p = new a();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static a f40784q = new a();
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static a f40785r = new a();
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static AtomicBoolean f40786s = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static AtomicBoolean f40787t = new AtomicBoolean(false);

    /* renamed from: u  reason: collision with root package name */
    private static AtomicBoolean f40788u = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static au f40789v = ((au) fe.a(f40768a, null, new fk<au>() {
        /* renamed from: a */
        public au b() {
            bq bqVar = new bq();
            au auVar = new au(bqVar, new fv(), new ak(bqVar));
            bp.a(auVar.e());
            i.a(auVar);
            return auVar;
        }
    }));
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static b f40790w = new b();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static v f40791x = new v(f40789v);
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static OnExperimentRunListener f40792y = null;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public static OnTestRunListener f40793z = null;

    /* renamed from: com.apptimize.Apptimize$52  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass52 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f40920a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.apptimize.ApptimizeOptions$ServerRegion[] r0 = com.apptimize.ApptimizeOptions.ServerRegion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40920a = r0
                com.apptimize.ApptimizeOptions$ServerRegion r1 = com.apptimize.ApptimizeOptions.ServerRegion.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40920a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.ApptimizeOptions$ServerRegion r1 = com.apptimize.ApptimizeOptions.ServerRegion.EUCS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.Apptimize.AnonymousClass52.<clinit>():void");
        }
    }

    public enum ApptimizeMetadataStateFlags {
        AVAILABLE,
        UP_TO_DATE,
        REFRESHING
    }

    public enum IsFirstTestRun {
        YES,
        NO
    }

    public interface LogMonitor {
        void log(ApptimizeOptions.LogLevel logLevel, String str, String str2, Throwable th2);
    }

    public interface MetadataStateChangedListener {
        void onApptimizeForegrounded(boolean z11);

        void onMetadataStateChanged(EnumSet<ApptimizeMetadataStateFlags> enumSet);
    }

    public interface OnApptimizeInitializedListener {
        void onApptimizeInitialized();
    }

    public interface OnExperimentRunListener {
        void onExperimentRun(String str, String str2, boolean z11);
    }

    public interface OnExperimentsProcessedListener {
        void onExperimentsProcessed();
    }

    public interface OnTestEnrollmentChangedListener {
        void onEnrolledInTest(ApptimizeTestInfo apptimizeTestInfo);

        void onUnenrolledInTest(ApptimizeTestInfo apptimizeTestInfo, UnenrollmentReason unenrollmentReason);
    }

    public interface OnTestRunListener {
        void onTestRun(ApptimizeTestInfo apptimizeTestInfo, IsFirstTestRun isFirstTestRun);
    }

    public enum UnenrollmentReason {
        EXPERIMENT_STOPPED,
        EXPERIMENT_WINNER_SELECTED,
        VARIANT_CHANGED,
        CUSTOMER_USER_ID_CHANGED,
        OTHER,
        REASON_UNKNOWN
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f40937a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, Object> f40938b;

        private a() {
            this.f40937a = false;
            this.f40938b = new HashMap();
        }

        public synchronized boolean a() {
            return this.f40937a;
        }

        public synchronized Map<String, Object> b() {
            return this.f40938b;
        }

        public synchronized void c() {
            this.f40937a = true;
            this.f40938b.clear();
        }

        public synchronized void a(String str, Object obj) {
            this.f40938b.put(str, obj);
        }

        public synchronized void a(boolean z11, Map<String, Object> map) {
            if (z11) {
                this.f40937a = true;
                this.f40938b.clear();
            }
            this.f40938b.putAll(map);
        }

        public synchronized boolean a(Map<String, Object> map) {
            boolean z11;
            z11 = this.f40937a;
            if (z11) {
                map.clear();
            }
            map.putAll(this.f40938b);
            this.f40937a = false;
            this.f40938b.clear();
            return z11;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f40939a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f40940b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f40941c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Long f40942d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Boolean f40943e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Boolean f40944f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f40945g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public long f40946h;

        private b() {
            this.f40939a = false;
            this.f40945g = false;
        }

        public synchronized void a(long j11, Long l11, boolean z11, boolean z12) {
            bs.a("setup: " + j11 + "ms, isNewInstall:" + z11 + ", isNewApplicationCode:" + z12);
            this.f40940b = c.a();
            this.f40941c = j11;
            this.f40942d = l11;
            this.f40943e = Boolean.valueOf(z11);
            this.f40944f = Boolean.valueOf(z12);
            this.f40939a = true;
            a();
        }

        public synchronized void a(long j11) {
            bs.a("setupInternal: " + j11 + "ms");
            this.f40946h = j11;
            this.f40945g = true;
            a();
        }

        private synchronized void a() {
            String str;
            if (this.f40939a && this.f40945g) {
                Apptimize.f40789v.c();
                if (h.f42873a == h.a.CURRENT_THREAD) {
                    str = UserDataStore.CITY;
                } else {
                    str = h.f42873a == h.a.NON_BLOCKING_THREAD ? "bg" : "mx";
                }
                Apptimize.f40789v.a().a(bq.b.SetupTiming, (Map<String, Object>) new HashMap<String, Object>(str) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ String f40947a;

                    {
                        this.f40947a = r4;
                        put("mt", Boolean.valueOf(b.this.f40940b));
                        put("sm", Long.valueOf(b.this.f40941c));
                        put("si", Long.valueOf(b.this.f40946h));
                        put("wm", b.this.f40942d);
                        put("tm", r4);
                        put("ni", b.this.f40943e);
                        put("nc", b.this.f40944f);
                        put("vs", gn.b());
                    }
                });
            }
        }
    }

    public enum c {
        RunTest("Running test before metadata finished downloading; defaulting to baseline. Consider using ApptimizeOptions#setUpdateMetadataTimeout with a higher value."),
        Setup("Continuing Apptimize setup without waiting for metadata to download. To ensure all visual tests run, consider using ApptimizeOptions#setUpdateMetadataTimeout with a higher value"),
        TestInfo("Getting Apptimize test info before metadata finished downloading. Information may not be current. Consider using ApptimizeOptions#setUpdateMetadataTimeout with a higher value."),
        AllVariants("Getting all launched variants info before metadata finished downloading. Information may not be current. Consider using ApptimizeOptions#setUpdateMetadataTimeout with a higher value.");
        

        /* renamed from: e  reason: collision with root package name */
        private String f40954e;

        private c(String str) {
            this.f40954e = str;
        }

        public String a() {
            return this.f40954e;
        }
    }

    private Apptimize() {
    }

    /* access modifiers changed from: private */
    public static void H() {
        f40789v.c().b((fi) new fi() {
            public void run() {
                HashMap hashMap = new HashMap();
                boolean a11 = Apptimize.f40785r.a(hashMap);
                if ((!a11 && hashMap.isEmpty()) || Apptimize.g("Not changing user attribute.")) {
                    return;
                }
                if (Apptimize.f40770c != null) {
                    Apptimize.f40770c.a(a11, (Map<String, Object>) hashMap);
                } else if (Apptimize.f40783p != null) {
                    Apptimize.f40783p.a(a11, (Map<String, Object>) hashMap);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void I() {
        final OnApptimizeInitializedListener onApptimizeInitializedListener;
        if (!f40786s.get() || !f40787t.get() || f40788u.get()) {
            String str = f40768a;
            bo.k(str, "notifyIfInitializationComplete metadata:" + f40786s.get() + " setup:" + f40787t.get() + " notified:" + f40788u.get());
            return;
        }
        bo.k(f40768a, "notifyIfInitializationComplete true");
        synchronized (Apptimize.class) {
            onApptimizeInitializedListener = B;
        }
        if (onApptimizeInitializedListener != null) {
            bo.f(f40768a, "onApptimizeInitializedListener");
            f40788u.set(true);
            c.a((fi) new fi() {
                public void run() {
                    bs.b("notifyOnApptimizeInitialized");
                    OnApptimizeInitializedListener.this.onApptimizeInitialized();
                }
            });
        }
        if (!av.f41245h) {
            f40791x.b();
        }
    }

    /* access modifiers changed from: private */
    public static boolean J() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        f40789v.c().d(new fi() {
            public void run() {
                if (!gn.d() || ((Apptimize.f40776i != null && !Apptimize.f40776i.d()) || gn.c())) {
                    atomicBoolean.set(false);
                }
            }
        });
        String str = f40768a;
        bo.k(str, "enableVisualChangesAndThirdPartyEventImport:" + atomicBoolean.get());
        return atomicBoolean.get();
    }

    private static ApptimizeOptions K() {
        ApptimizeOptions apptimizeOptions = new ApptimizeOptions();
        long a11 = f40789v.e().a();
        if (a11 < f40781n.get()) {
            apptimizeOptions.setUpdateMetadataTimeout(f40781n.get() - a11);
            apptimizeOptions.setIsRefreshingMetadataOnSetup(true);
        }
        return apptimizeOptions;
    }

    public static void addMetadataStateChangedListener(final MetadataStateChangedListener metadataStateChangedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Apptimize is disabled; not adding MetadataStateChangedListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(MetadataStateChangedListener.this);
                            }
                            Apptimize.D.add(MetadataStateChangedListener.this);
                        }
                    }
                });
            }
        });
    }

    public static void addOnExperimentsProcessedListener(final OnExperimentsProcessedListener onExperimentsProcessedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Apptimize is disabled; not adding OnExperimentsProcessedListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(OnExperimentsProcessedListener.this);
                            }
                            Apptimize.C.add(OnExperimentsProcessedListener.this);
                        }
                    }
                });
            }
        });
    }

    public static void addToMetric(final String str, final double d11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not adding to metric.") && Apptimize.h("addToMetric")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.addToMetric with a non-null metric name");
                                return;
                            }
                            as f11 = Apptimize.f40770c;
                            AnonymousClass22 r12 = AnonymousClass22.this;
                            f11.b(str, d11);
                        }
                    }
                });
            }
        });
    }

    public static void clearAllForcedVariants() {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring clear all forced variants call.") && Apptimize.h("clearAllForcedVariants")) {
                            Apptimize.f40770c.a().l();
                        }
                    }
                });
            }
        });
    }

    public static void clearAllUserAttributes() {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40785r.c();
                Apptimize.H();
            }
        });
    }

    public static void clearForcedVariant(final Long l11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring clear forced variant call.") && Apptimize.h("clearForcedVariant")) {
                            Apptimize.f40770c.a().b(l11);
                        }
                    }
                });
            }
        });
    }

    public static void clearUserAttribute(String str) {
        a(str, (Object) null);
    }

    public static void disable() {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.f40769b || Apptimize.f40776i == null) {
                            bo.c(Apptimize.f40768a, "Apptimize.setup not run yet; ignoring disable call.");
                        } else if (!Apptimize.f40776i.b()) {
                            Apptimize.f40776i.a(true);
                            Apptimize.a();
                        }
                    }
                });
            }
        });
    }

    public static double doubleForTest(final String str, final double d11, final ApptimizeOptions apptimizeOptions) {
        return ((Double) fe.a(f40768a, Double.valueOf(d11), new fk<Double>() {
            /* renamed from: a */
            public Double b() {
                final AtomicReference atomicReference = new AtomicReference(Double.valueOf(d11));
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not running test.")) {
                            AnonymousClass15 r02 = AnonymousClass15.this;
                            Double d11 = (Double) Apptimize.a(ApptimizeVar.createDouble(str, Double.valueOf(d11)), apptimizeOptions);
                            if (d11 == null) {
                                Apptimize.f40789v.a().a(bq.b.NullValueTest);
                            } else {
                                atomicReference.set(d11);
                            }
                        }
                    }
                });
                return (Double) atomicReference.get();
            }
        })).doubleValue();
    }

    public static void event(String str) {
        track(str);
    }

    public static void forceVariant(final Long l11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring force variant call.") && Apptimize.h("forceVariant")) {
                            Apptimize.f40770c.a().a(l11);
                        }
                    }
                });
            }
        });
    }

    public static String getApptimizeAnonUserId() {
        return (String) fe.a(f40768a, "", new fk<String>() {
            /* renamed from: a */
            public String b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.g("Returning an empty user ID.") || !Apptimize.h("getApptimizeAnonUserId")) {
                            atomicReference.set("");
                        } else {
                            atomicReference.set(Apptimize.f40770c.h());
                        }
                    }
                });
                return (String) atomicReference.get();
            }
        });
    }

    public static ApptimizeOptions getApptimizeOptions() {
        return f40782o;
    }

    public static String getCustomerUserId() {
        return (String) fe.a(f40768a, "", new fk<String>() {
            /* renamed from: a */
            public String b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Returning a null user ID.") && Apptimize.h("getCustomerUserId")) {
                            atomicReference.set(Apptimize.f40770c.g());
                        }
                    }
                });
                return (String) atomicReference.get();
            }
        });
    }

    @Deprecated
    public static String getExperimentString(String str, String str2) {
        return stringForTest(str, str2);
    }

    public static Map<String, ApptimizeInstantUpdateOrWinnerInfo> getInstantUpdateOrWinnerInfo() {
        return getInstantUpdateOrWinnerInfo(K());
    }

    public static int getMetadataSequenceNumber() {
        return ((Integer) fe.a(f40768a, 0, new fk<Integer>() {
            /* renamed from: a */
            public Integer b() {
                final AtomicReference atomicReference = new AtomicReference(0);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.h("getMetadataSequenceNumber")) {
                            atomicReference.set(Apptimize.f40770c.j());
                        }
                    }
                });
                return (Integer) atomicReference.get();
            }
        })).intValue();
    }

    public static EnumSet<ApptimizeMetadataStateFlags> getMetadataState() {
        return (EnumSet) fe.a(f40768a, EnumSet.noneOf(ApptimizeMetadataStateFlags.class), new fk<EnumSet<ApptimizeMetadataStateFlags>>() {
            /* renamed from: a */
            public EnumSet<ApptimizeMetadataStateFlags> b() {
                final AtomicReference atomicReference = new AtomicReference(EnumSet.noneOf(ApptimizeMetadataStateFlags.class));
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Returning the empty set of ApptimizeMetadataStateFlags.") && Apptimize.h("getMetadataState")) {
                            atomicReference.set(Apptimize.f40770c.i());
                        }
                    }
                });
                return (EnumSet) atomicReference.get();
            }
        });
    }

    public static String getPilotTargetingId() {
        return (String) fe.a(f40768a, null, new fk<String>() {
            /* renamed from: a */
            public String b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Returning null for pilot targeting id.")) {
                            if (Apptimize.f40770c != null) {
                                atomicReference.set((String) Apptimize.f40770c.b(dl.b.LocalAttribute).get(as.f41212a));
                            } else {
                                bo.j(Apptimize.f40768a, "Attempted to retrieve pilot targeting id before setup called.  Returning null");
                            }
                        }
                    }
                });
                return (String) atomicReference.get();
            }
        });
    }

    public static Map<String, ApptimizeTestInfo> getTestInfo() {
        return getTestInfo(K());
    }

    public static Boolean getUserAttributeBoolean(String str) {
        Object d11 = d(str);
        if (d11 instanceof Boolean) {
            return (Boolean) d11;
        }
        return null;
    }

    public static Double getUserAttributeDouble(String str) {
        Object d11 = d(str);
        if (d11 instanceof Double) {
            return (Double) d11;
        }
        return null;
    }

    public static Integer getUserAttributeInteger(String str) {
        Object d11 = d(str);
        if (d11 instanceof Integer) {
            return (Integer) d11;
        }
        return null;
    }

    public static String getUserAttributeString(String str) {
        Object d11 = d(str);
        if (d11 instanceof String) {
            return (String) d11;
        }
        return null;
    }

    public static String getUserId() {
        return getApptimizeAnonUserId();
    }

    public static Map<Long, Map<String, Object>> getVariants() {
        return getVariants(K());
    }

    public static String getVersion() {
        return fx.a();
    }

    public static void goalAchieved(final String str) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not registering metric.") && Apptimize.h("goalAchieved")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.goalAchieved with a non-null goal name");
                            } else {
                                Apptimize.f40770c.a(str);
                            }
                        }
                    }
                });
            }
        });
    }

    public static int integerForTest(final String str, final int i11, final ApptimizeOptions apptimizeOptions) {
        return ((Integer) fe.a(f40768a, Integer.valueOf(i11), new fk<Integer>() {
            /* renamed from: a */
            public Integer b() {
                final AtomicInteger atomicInteger = new AtomicInteger(i11);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not running test.")) {
                            AnonymousClass16 r02 = AnonymousClass16.this;
                            Integer num = (Integer) Apptimize.a(ApptimizeVar.createInteger(str, Integer.valueOf(i11)), apptimizeOptions);
                            if (num == null) {
                                Apptimize.f40789v.a().a(bq.b.NullValueTest);
                            } else {
                                atomicInteger.set(num.intValue());
                            }
                        }
                    }
                });
                return Integer.valueOf(atomicInteger.get());
            }
        })).intValue();
    }

    public static boolean isFeatureFlagOn(String str) {
        return isFeatureFlagOn(str, K());
    }

    public static boolean isOffline() {
        eb ebVar;
        g gVar = f40776i;
        if ((gVar == null || !gVar.b()) && (ebVar = f40778k) != null) {
            return ebVar.f();
        }
        return true;
    }

    public static void metricAchieved(final String str) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not registering metric.") && Apptimize.h("metricAchieved")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.metricAchieved with a non-null metric name");
                            } else {
                                Apptimize.f40770c.a(str);
                            }
                        }
                    }
                });
            }
        });
    }

    public static void removeMetadataStateChangedListener(final MetadataStateChangedListener metadataStateChangedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Apptimize is disabled; not removing MetadataStateChangedListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.b(MetadataStateChangedListener.this);
                            }
                            Apptimize.D.remove(MetadataStateChangedListener.this);
                        }
                    }
                });
            }
        });
    }

    public static void removeOnExperimentsProcessedListener(final OnExperimentsProcessedListener onExperimentsProcessedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Apptimize is disabled; not removing OnExperimentsProcessedListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.b(OnExperimentsProcessedListener.this);
                            }
                            Apptimize.C.remove(OnExperimentsProcessedListener.this);
                        }
                    }
                });
            }
        });
    }

    public static void reset() {
        reset(true);
    }

    public static void runExperiment(String str, ApptimizeExperiment apptimizeExperiment) {
        runTest(str, apptimizeExperiment);
    }

    public static void runTest(final String str, final ApptimizeTest apptimizeTest, final ApptimizeOptions apptimizeOptions) {
        RuntimeException runtimeException = (RuntimeException) fe.a(f40768a, null, new fk<RuntimeException>() {
            /* renamed from: a */
            public RuntimeException b() {
                final AtomicReference atomicReference = new AtomicReference();
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.g("Not running test.")) {
                            AtomicReference atomicReference = atomicReference;
                            AnonymousClass13 r22 = AnonymousClass13.this;
                            atomicReference.set(as.a(ApptimizeTest.this, (bt.a) null, str, (dt) null));
                        } else if (Apptimize.E) {
                            if (Apptimize.F.get(str) == null) {
                                String g11 = Apptimize.f40768a;
                                bo.c(g11, "Test mode is active, but no active code block is set for the experiment " + str);
                                AtomicReference atomicReference2 = atomicReference;
                                AnonymousClass13 r23 = AnonymousClass13.this;
                                atomicReference2.set(as.a(ApptimizeTest.this, (bt.a) null, str, (dt) null));
                                return;
                            }
                            AtomicReference atomicReference3 = atomicReference;
                            as f11 = Apptimize.f40770c;
                            AnonymousClass13 r24 = AnonymousClass13.this;
                            atomicReference3.set(f11.a(ApptimizeTest.this, str, (String) Apptimize.F.get(str)));
                        } else if (Apptimize.f40770c == null) {
                            boolean unused = Apptimize.h("runTest");
                            AtomicReference atomicReference4 = atomicReference;
                            AnonymousClass13 r25 = AnonymousClass13.this;
                            atomicReference4.set(as.a(ApptimizeTest.this, (bt.a) null, str, (dt) null));
                        } else {
                            Apptimize.b(apptimizeOptions, c.RunTest);
                            as f12 = Apptimize.f40770c;
                            AnonymousClass13 r12 = AnonymousClass13.this;
                            atomicReference.set(f12.a(str, ApptimizeTest.this));
                        }
                    }
                });
                return (RuntimeException) atomicReference.get();
            }
        });
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public static void setActiveCodeBlockForExperiment(final String str, final String str2) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring set active code block for experiment call.")) {
                            Map r11 = Apptimize.F;
                            AnonymousClass47 r12 = AnonymousClass47.this;
                            r11.put(str, str2);
                        }
                    }
                });
            }
        });
    }

    public static <T> void setActiveValueForDynamicVariable(final ApptimizeVar<T> apptimizeVar, final T t11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring set active value for dynamic variable call.")) {
                            Map q11 = Apptimize.G;
                            AnonymousClass48 r12 = AnonymousClass48.this;
                            q11.put(ApptimizeVar.this, t11);
                        }
                    }
                });
            }
        });
    }

    public static void setCustomerUserId(final String str) {
        if (str != null && str.replaceAll("\\s+", "").length() == 0) {
            bo.j(f40768a, "customerUserId cannot be the empty string, using null instead");
            str = null;
        }
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Cannot set the user ID.") && Apptimize.h("setCustomerUserId")) {
                            Apptimize.f40770c.c(str);
                        }
                    }
                });
            }
        });
    }

    public static void setLogMonitor(boolean z11, LogMonitor logMonitor) {
        bo.a(logMonitor, z11);
    }

    public static void setMetric(final String str, final double d11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting metric.") && Apptimize.h("setMetric")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.setMetric with a non-null metric name");
                                return;
                            }
                            as f11 = Apptimize.f40770c;
                            AnonymousClass21 r12 = AnonymousClass21.this;
                            f11.a(str, d11);
                        }
                    }
                });
            }
        });
    }

    @Deprecated
    public static void setMixpanelIdentity(String str) {
        f(str);
    }

    public static void setOffline(final boolean z11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        ge b11;
                        if (!Apptimize.g("Setting offline mode is unnecessary because Apptimize performs no communication when disabled.")) {
                            if (z11) {
                                bo.h(Apptimize.f40768a, "Apptimize is being set to offline mode.");
                            } else {
                                bo.h(Apptimize.f40768a, "Apptimize is being set to online mode.");
                            }
                            if (Apptimize.f40778k != null) {
                                Apptimize.f40778k.a(z11);
                            } else {
                                Boolean unused = Apptimize.f40775h = Boolean.valueOf(z11);
                            }
                            if (Apptimize.f40770c != null && (b11 = Apptimize.f40770c.b()) != null) {
                                b11.b(z11);
                            }
                        }
                    }
                });
            }
        });
    }

    public static void setOnApptimizeInitializedListener(final OnApptimizeInitializedListener onApptimizeInitializedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting OnApptimizeInitializedListener.")) {
                            synchronized (Apptimize.class) {
                                OnApptimizeInitializedListener unused = Apptimize.B = OnApptimizeInitializedListener.this;
                            }
                            Apptimize.I();
                        }
                    }
                });
            }
        });
    }

    public static void setOnExperimentRunListener(final OnExperimentRunListener onExperimentRunListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting OnExperimentRunListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(OnExperimentRunListener.this);
                            }
                            OnExperimentRunListener unused = Apptimize.f40792y = OnExperimentRunListener.this;
                        }
                    }
                });
            }
        });
    }

    public static void setOnTestEnrollmentChangedListener(final OnTestEnrollmentChangedListener onTestEnrollmentChangedListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting OnTestEnrollmentChangedListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(OnTestEnrollmentChangedListener.this);
                            }
                            OnTestEnrollmentChangedListener unused = Apptimize.A = OnTestEnrollmentChangedListener.this;
                        }
                    }
                });
            }
        });
    }

    public static void setOnTestRunListener(final OnTestRunListener onTestRunListener) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting OnTestRunListener.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(OnTestRunListener.this);
                            }
                            OnTestRunListener unused = Apptimize.f40793z = OnTestRunListener.this;
                        }
                    }
                });
            }
        });
    }

    public static void setPilotTargetingId(String str) {
        e(str);
    }

    public static void setTestmodeActive(final boolean z11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Ignoring set test mode active call.")) {
                            if (!z11) {
                                Map unused = Apptimize.G = new HashMap();
                                Map unused2 = Apptimize.F = new HashMap();
                            }
                            boolean unused3 = Apptimize.E = z11;
                        }
                    }
                });
            }
        });
    }

    public static void setUserAttribute(String str, boolean z11) {
        a(str, (Object) Boolean.valueOf(z11));
    }

    public static void setup(Context context, String str) {
        setup(context, str, new ApptimizeOptions());
    }

    public static String stringForTest(final String str, final String str2, final ApptimizeOptions apptimizeOptions) {
        return (String) fe.a(f40768a, str2, new fk<String>() {
            /* renamed from: a */
            public String b() {
                final AtomicReference atomicReference = new AtomicReference(str2);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Not running test.")) {
                            AnonymousClass14 r02 = AnonymousClass14.this;
                            atomicReference.set(Apptimize.a(ApptimizeVar.createString(str, str2), apptimizeOptions));
                        }
                    }
                });
                return (String) atomicReference.get();
            }
        });
    }

    public static void track(final String str) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not registering event: " + str) && Apptimize.h("track")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.track with a non-null event name");
                            } else {
                                Apptimize.f40770c.a(str);
                            }
                        }
                    }
                });
            }
        });
    }

    private static Object d(final String str) {
        return fe.a(f40768a, null, new fk<Object>() {
            public Object b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Returning null for requested user attribute.")) {
                            if (Apptimize.f40770c != null) {
                                atomicReference.set(Apptimize.f40770c.b(str));
                                return;
                            }
                            bo.j(Apptimize.f40768a, "Attempted to retrieve user attribute value before setup called. Returning null.");
                        }
                    }
                });
                return atomicReference.get();
            }
        });
    }

    public static double doubleForTest(String str, double d11) {
        return doubleForTest(str, d11, K());
    }

    private static void e(final String str) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting pilot targeting id.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(dl.b.LocalAttribute, as.f41212a, (Object) str);
                            } else {
                                Apptimize.f40784q.a(as.f41212a, (Object) str);
                            }
                        }
                    }
                });
            }
        });
    }

    public static void event(String str, double d11) {
        track(str, d11);
    }

    private static void f(final String str) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not setting mixpanel identity.")) {
                            if (Apptimize.f40770c != null) {
                                Apptimize.f40770c.a(dl.b.MixpanelSuperProperty, "_identity", (Object) str);
                            } else {
                                bo.j(Apptimize.f40768a, "Called setMixpanelIdentity before setup, ignoring.");
                            }
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean g(String str) {
        g gVar = f40776i;
        return gVar != null && gVar.a(ApptimizeOptions.LogLevel.VERBOSE, f40768a, str);
    }

    public static Map<String, ApptimizeInstantUpdateOrWinnerInfo> getInstantUpdateOrWinnerInfo(final ApptimizeOptions apptimizeOptions) {
        return (Map) fe.a(f40768a, new HashMap(), new fk<Map<String, ApptimizeInstantUpdateOrWinnerInfo>>() {
            /* renamed from: a */
            public Map<String, ApptimizeInstantUpdateOrWinnerInfo> b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.g("Returning empty Map of ApptimizeInstantUpdateOrWinnerInfo.")) {
                            atomicReference.set(new HashMap());
                        } else if (Apptimize.h("getInstantUpdateOrWinnerInfo")) {
                            Apptimize.b(ApptimizeOptions.this, c.TestInfo);
                            atomicReference.set(Apptimize.f40770c.e());
                        }
                    }
                });
                return (Map) atomicReference.get();
            }
        });
    }

    public static Map<String, ApptimizeTestInfo> getTestInfo(final ApptimizeOptions apptimizeOptions) {
        return (Map) fe.a(f40768a, new HashMap(), new fk<Map<String, ApptimizeTestInfo>>() {
            /* renamed from: a */
            public Map<String, ApptimizeTestInfo> b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.g("Returning empty Map of ApptimizeTestInfo.")) {
                            atomicReference.set(new HashMap());
                        } else if (Apptimize.h("getTestInfo")) {
                            Apptimize.b(ApptimizeOptions.this, c.TestInfo);
                            atomicReference.set(Apptimize.f40770c.d());
                        }
                    }
                });
                return (Map) atomicReference.get();
            }
        });
    }

    public static Map<Long, Map<String, Object>> getVariants(final ApptimizeOptions apptimizeOptions) {
        return (Map) fe.a(f40768a, new HashMap(), new fk<Map<Long, Map<String, Object>>>() {
            /* renamed from: a */
            public Map<Long, Map<String, Object>> b() {
                final AtomicReference atomicReference = new AtomicReference((Object) null);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.g("Returning empty Map.")) {
                            atomicReference.set(new HashMap());
                        } else if (Apptimize.h("getVariants")) {
                            Apptimize.b(ApptimizeOptions.this, c.AllVariants);
                            atomicReference.set(Apptimize.f40770c.f());
                        }
                    }
                });
                return (Map) atomicReference.get();
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean h(String str) {
        boolean z11 = true;
        if (f40770c != null) {
            return true;
        }
        synchronized (Apptimize.class) {
            if (B == null) {
                z11 = false;
            }
        }
        if (!f40789v.h()) {
            bo.j(f40768a, "Apptimize." + str + " -- you must call Apptimize.setup(context, appKey) before anything else");
        } else if (!z11) {
            bo.j(f40768a, "Apptimize." + str + " -- setup has not completed. Use Apptimize.setOnApptimizeInitializedListener to issue this call after setup completes");
        } else {
            bo.j(f40768a, "Apptimize." + str + " -- setup has not completed. Call this in your onApptimizeInitializedListener, or afterwards");
        }
        return false;
    }

    public static int integerForTest(String str, int i11) {
        return integerForTest(str, i11, K());
    }

    public static boolean isFeatureFlagOn(final String str, final ApptimizeOptions apptimizeOptions) {
        String str2 = f40768a;
        bo.k(str2, "isFeatureFlagOn " + str);
        return ((Boolean) fe.a(f40768a, Boolean.FALSE, new fk<Boolean>() {
            /* renamed from: a */
            public Boolean b() {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (!Apptimize.g("Returning false for Feature Flag.")) {
                            String str = str;
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "Feature flag name must not be null.  Returning false.");
                            } else if ("".compareTo(str) == 0) {
                                bo.j(Apptimize.f40768a, "Feature flag name must not be empty.  Returning false");
                            } else if (Apptimize.f40770c == null) {
                                bo.h(Apptimize.f40768a, "Feature flag checked before setup called.  Returning false");
                            } else {
                                Boolean bool = (Boolean) new ApptimizeVar(str, TypedValues.Custom.S_BOOLEAN, (String) null, Boolean.FALSE).value(apptimizeOptions);
                                if (bool == null) {
                                    bo.b(Apptimize.f40768a, "Returned null for feature flag!  Returning false.");
                                } else {
                                    atomicBoolean.set(bool.booleanValue());
                                }
                            }
                        }
                    }
                });
                String g11 = Apptimize.f40768a;
                bo.k(g11, "isFeatureFlagOn " + str + " result:" + atomicBoolean.get());
                return Boolean.valueOf(atomicBoolean.get());
            }
        })).booleanValue();
    }

    public static void reset(final boolean z11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        String g11 = Apptimize.f40768a;
                        bo.k(g11, "reset with setupAgain:" + z11);
                        cd cdVar = null;
                        Boolean unused = Apptimize.f40775h = null;
                        if (Apptimize.f40770c != null) {
                            Context l11 = Apptimize.f40770c.l();
                            String m11 = Apptimize.f40770c.m();
                            Apptimize.f40770c.k();
                            if (z11) {
                                try {
                                    Properties o11 = Apptimize.f40770c.o();
                                    String a11 = c.a(l11, Apptimize.f40789v);
                                    fq a12 = Apptimize.c(o11);
                                    eg egVar = new eg(Apptimize.f40789v, as.g(o11));
                                    aw.d dVar = new aw.d(c.g(), c.h());
                                    String c11 = as.c(o11);
                                    aw awVar = new aw(a12, new SecureRandom(), dVar, m11, Apptimize.f40789v, Apptimize.f40778k);
                                    fq fqVar = a12;
                                    aw awVar2 = new aw(fqVar, new SecureRandom(), dVar, c11, Apptimize.f40789v, Apptimize.f40778k);
                                    Context context = l11;
                                    fb fbVar = new fb(context, Apptimize.f40789v, Apptimize.d(o11), a11, m11, awVar, Apptimize.f40770c.p(), Apptimize.f40770c.q());
                                    if (Apptimize.f40789v.f() != null) {
                                        cdVar = Apptimize.f40789v.f().j();
                                    }
                                    u uVar = r3;
                                    u uVar2 = new u(m11, a11, l11, awVar2, cdVar, s.a(l11, Apptimize.f40789v), egVar, Apptimize.f40789v, o11);
                                    uVar.a(Apptimize.f40772e);
                                    Apptimize.b(l11, uVar.d(), a11, fbVar.b());
                                    ApptimizeOptions n11 = Apptimize.f40770c.n();
                                    Apptimize.b(l11, m11, a11, awVar, fbVar, uVar, n11, o11, egVar);
                                    uVar.b();
                                } catch (as.a e11) {
                                    Log.e(Apptimize.f40768a, "Error in apptimize.properties", e11);
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    public static void setUserAttribute(String str, double d11) {
        a(str, (Object) Double.valueOf(d11));
    }

    public static void setup(final Context context, final String str, final ApptimizeOptions apptimizeOptions) {
        f40782o = apptimizeOptions;
        fe.a(f40768a, new fi() {
            public void run() {
                bo.a(ApptimizeOptions.this.getLogLevel());
                long d11 = Apptimize.f40789v.e().d();
                if (ApptimizeOptions.this.isPerformanceLoggingEnabled() || av.f41242e) {
                    bs.f41454a = bs.a(context);
                } else {
                    bs.f41454a = null;
                }
                Apptimize.f40789v.c().a(ApptimizeOptions.this.isSetupInBackground());
                bs.a("setupInBackground: " + ApptimizeOptions.this.isSetupInBackground());
                Apptimize.f40791x.a();
                AnonymousClass1 r22 = new fi() {
                    public void run() {
                        long d11 = Apptimize.f40789v.e().d();
                        AnonymousClass12 r22 = AnonymousClass12.this;
                        Apptimize.b(context, str, ApptimizeOptions.this);
                        Apptimize.f40790w.a(Apptimize.f40789v.e().a(d11));
                    }
                };
                if (h.f42873a == h.a.CURRENT_THREAD) {
                    Apptimize.f40789v.c().d(r22);
                } else if (h.f42873a == h.a.NON_BLOCKING_THREAD) {
                    Apptimize.f40789v.c().b((fi) r22);
                } else {
                    Apptimize.f40789v.c().a((fi) r22, 3);
                }
                if (Apptimize.f40770c != null) {
                    Apptimize.b(ApptimizeOptions.this, c.Setup);
                }
                Apptimize.f40790w.a(Apptimize.f40789v.e().a(d11), ApptimizeOptions.this.getUpdateMetaDataTimeout(), c.b(context, Apptimize.f40789v), c.c(context, Apptimize.f40789v));
                bo.k(Apptimize.f40768a, "setup returning to caller");
            }
        });
    }

    public static String stringForTest(String str, String str2) {
        return stringForTest(str, str2, K());
    }

    public static void track(final String str, final double d11) {
        fe.a(f40768a, new fi() {
            public void run() {
                Apptimize.f40789v.c().b((fi) new fi() {
                    public void run() {
                        if (!Apptimize.g("Not registering event: " + str + " with value: " + d11) && Apptimize.h("track")) {
                            if (str == null) {
                                bo.j(Apptimize.f40768a, "You must call Apptimize.track with a non-null event name");
                                return;
                            }
                            as f11 = Apptimize.f40770c;
                            AnonymousClass18 r12 = AnonymousClass18.this;
                            f11.b(str, d11);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static fq c(Properties properties) {
        Boolean j11 = as.j(properties);
        if (j11 == null) {
            j11 = Boolean.valueOf(av.f41262y);
        }
        if (!j11.booleanValue()) {
            return new fq();
        }
        if (av.A == null) {
            av.a();
        }
        return new fq(av.A);
    }

    /* access modifiers changed from: private */
    public static String d(Properties properties) throws as.a {
        String b11 = j.b();
        String b12 = as.b(properties);
        if (b12 != null) {
            b11 = b12;
        }
        String str = av.f41260w;
        return str != null ? str : b11;
    }

    public static void runTest(String str, ApptimizeTest apptimizeTest) {
        runTest(str, apptimizeTest, K());
    }

    public static void setUserAttribute(String str, int i11) {
        a(str, (Object) Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    public static void b(Context context, t.b bVar, String str, final boolean z11) {
        t.a(context, bVar, str, new t.a() {
            public boolean a() {
                return gn.l();
            }

            public boolean b() {
                return z11;
            }
        });
    }

    public static void setUserAttribute(String str, String str2) {
        a(str, (Object) str2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0204, code lost:
        if (com.apptimize.gn.a(com.apptimize.gn.b.f42668f) == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x021a, code lost:
        if (com.apptimize.gn.a(com.apptimize.gn.b.f42668f) != false) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x021c, code lost:
        com.apptimize.t.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x021f, code lost:
        f40789v.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0224, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r19, java.lang.String r20, com.apptimize.ApptimizeOptions r21) {
        /*
            r0 = r19
            r11 = r21
            boolean r1 = f40769b
            if (r1 == 0) goto L_0x0010
            java.lang.String r0 = f40768a
            java.lang.String r1 = "Apptimize.setup already run; ignoring setup call."
            com.apptimize.bo.a((java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x0010:
            boolean r1 = r21.isRefreshingMetadataOnSetup()
            if (r1 == 0) goto L_0x0034
            java.lang.Long r1 = r21.getUpdateMetaDataTimeout()
            if (r1 == 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicLong r1 = f40781n
            com.apptimize.au r2 = f40789v
            com.apptimize.eu r2 = r2.e()
            long r2 = r2.a()
            java.lang.Long r4 = r21.getUpdateMetaDataTimeout()
            long r4 = r4.longValue()
            long r2 = r2 + r4
            r1.set(r2)
        L_0x0034:
            boolean r1 = r21.isMultiprocessModeEnabled()
            if (r1 == 0) goto L_0x004b
            boolean r1 = com.apptimize.c.e(r19)
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = f40768a
            java.lang.String r2 = "Multiprocess mode is enabled but ApptimizeService not found. Get more info at https://sdk.apptimize.com/android/javadocs/javadoc-3.9.5/reference/com/apptimize/ApptimizeOptions.html#setMultiprocessMode(boolean)"
            com.apptimize.bo.g(r1, r2)
            r1 = 0
            r11.setMultiprocessMode(r1)
        L_0x004b:
            boolean r1 = r21.isMultiprocessModeEnabled()
            if (r1 == 0) goto L_0x0058
            com.apptimize.i r1 = com.apptimize.i.a()
            r1.b(r0)
        L_0x0058:
            boolean r1 = com.apptimize.c.d(r19)
            com.apptimize.g r2 = f40776i
            if (r2 != 0) goto L_0x006d
            com.apptimize.g r2 = new com.apptimize.g
            com.apptimize.au r3 = f40789v
            boolean r4 = r21.isMultiprocessModeEnabled()
            r2.<init>(r0, r3, r4, r1)
            f40776i = r2
        L_0x006d:
            com.apptimize.g r2 = f40776i
            com.apptimize.ApptimizeOptions$LogLevel r3 = com.apptimize.ApptimizeOptions.LogLevel.INFO
            java.lang.String r4 = f40768a
            java.lang.String r5 = "Preventing Apptimize setup."
            boolean r2 = r2.a(r3, r4, r5)
            if (r2 == 0) goto L_0x007c
            return
        L_0x007c:
            boolean r2 = r21.isMultiprocessModeEnabled()
            if (r2 == 0) goto L_0x008c
            com.apptimize.au r1 = f40789v
            com.apptimize.ak r1 = r1.d()
            r1.a((android.content.Context) r0)
            goto L_0x0096
        L_0x008c:
            if (r1 != 0) goto L_0x0096
            java.lang.String r0 = f40768a
            java.lang.String r1 = "Running outside main application process. Apptimize will not be initialized in this process."
            com.apptimize.bo.j(r0, r1)
            return
        L_0x0096:
            java.lang.String r1 = f40768a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Version "
            r2.append(r3)
            java.lang.String r3 = com.apptimize.fx.a()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r1, r2)
            r12 = 1
            f40769b = r12
            com.apptimize.au r1 = f40789v
            r1.g()
            boolean r1 = r21.isVisualChangesEnabled()     // Catch:{ a -> 0x0209 }
            com.apptimize.gn.a((boolean) r1)     // Catch:{ a -> 0x0209 }
            boolean r1 = r21.isThirdPartyEventImportingEnabled()     // Catch:{ a -> 0x0209 }
            com.apptimize.gn.b((boolean) r1)     // Catch:{ a -> 0x0209 }
            com.apptimize.g r1 = f40776i     // Catch:{ a -> 0x0209 }
            if (r1 == 0) goto L_0x01fb
            java.util.Properties r13 = a((android.content.Context) r19)     // Catch:{ a -> 0x0209 }
            com.apptimize.as.a((java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.fq r8 = c((java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.aw$d r9 = new com.apptimize.aw$d     // Catch:{ a -> 0x0209 }
            java.lang.String r1 = com.apptimize.c.g()     // Catch:{ a -> 0x0209 }
            java.lang.String r2 = com.apptimize.c.h()     // Catch:{ a -> 0x0209 }
            r9.<init>(r1, r2)     // Catch:{ a -> 0x0209 }
            r1 = r20
            java.lang.String r14 = a((java.lang.String) r1, (java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.j$b r1 = a((com.apptimize.ApptimizeOptions) r11, (java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.j.a(r1)     // Catch:{ a -> 0x0209 }
            java.lang.String r10 = com.apptimize.as.c((java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.eb r1 = new com.apptimize.eb     // Catch:{ a -> 0x0209 }
            java.lang.Boolean r2 = f40775h     // Catch:{ a -> 0x0209 }
            com.apptimize.au r3 = f40789v     // Catch:{ a -> 0x0209 }
            r1.<init>(r0, r2, r3)     // Catch:{ a -> 0x0209 }
            f40778k = r1     // Catch:{ a -> 0x0209 }
            com.apptimize.eg r15 = new com.apptimize.eg     // Catch:{ a -> 0x0209 }
            com.apptimize.au r1 = f40789v     // Catch:{ a -> 0x0209 }
            java.lang.String r2 = com.apptimize.as.g(r13)     // Catch:{ a -> 0x0209 }
            r15.<init>(r1, r2)     // Catch:{ a -> 0x0209 }
            com.apptimize.aw r7 = new com.apptimize.aw     // Catch:{ a -> 0x0209 }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ a -> 0x0209 }
            r3.<init>()     // Catch:{ a -> 0x0209 }
            com.apptimize.au r6 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.eb r16 = f40778k     // Catch:{ a -> 0x0209 }
            r1 = r7
            r2 = r8
            r4 = r9
            r5 = r14
            r20 = r7
            r7 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x0209 }
            com.apptimize.aw r16 = new com.apptimize.aw     // Catch:{ a -> 0x0209 }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ a -> 0x0209 }
            r3.<init>()     // Catch:{ a -> 0x0209 }
            com.apptimize.au r6 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.eb r7 = f40778k     // Catch:{ a -> 0x0209 }
            r1 = r16
            r2 = r8
            r4 = r9
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x0209 }
            com.apptimize.au r1 = f40789v     // Catch:{ a -> 0x0209 }
            java.lang.String r10 = com.apptimize.c.a((android.content.Context) r0, (com.apptimize.au) r1)     // Catch:{ a -> 0x0209 }
            java.lang.String r17 = d((java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            com.apptimize.u r9 = new com.apptimize.u     // Catch:{ a -> 0x0209 }
            com.apptimize.au r1 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.bz r1 = r1.f()     // Catch:{ a -> 0x0209 }
            if (r1 == 0) goto L_0x0151
            com.apptimize.au r1 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.bz r1 = r1.f()     // Catch:{ a -> 0x0209 }
            com.apptimize.cd r1 = r1.j()     // Catch:{ a -> 0x0209 }
            goto L_0x0152
        L_0x0151:
            r1 = 0
        L_0x0152:
            r6 = r1
            com.apptimize.au r1 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.s r7 = com.apptimize.s.a((android.content.Context) r0, (com.apptimize.au) r1)     // Catch:{ a -> 0x0209 }
            com.apptimize.au r18 = f40789v     // Catch:{ a -> 0x0209 }
            r1 = r9
            r2 = r14
            r3 = r10
            r4 = r19
            r5 = r16
            r8 = r15
            r11 = r9
            r9 = r18
            r16 = r10
            r10 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ a -> 0x0209 }
            com.apptimize.fb r10 = new com.apptimize.fb     // Catch:{ a -> 0x0209 }
            com.apptimize.au r3 = f40789v     // Catch:{ a -> 0x0209 }
            r1 = r10
            r2 = r19
            r4 = r17
            r5 = r16
            r6 = r14
            r7 = r20
            r8 = r21
            r9 = r13
            r1.<init>((android.content.Context) r2, (com.apptimize.au) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (com.apptimize.aw) r7, (com.apptimize.ApptimizeOptions) r8, (java.util.Properties) r9)     // Catch:{ a -> 0x0209 }
            com.apptimize.ApptimizeOptions r1 = f40782o     // Catch:{ a -> 0x0209 }
            boolean r2 = r10.c()     // Catch:{ a -> 0x0209 }
            r1.setIsDevicePairingEnabled(r2)     // Catch:{ a -> 0x0209 }
            boolean r1 = r10.b()     // Catch:{ a -> 0x0209 }
            com.apptimize.cj r2 = r15.f()     // Catch:{ a -> 0x0209 }
            java.util.List r1 = a((java.util.Properties) r13, (boolean) r1, (com.apptimize.cj) r2)     // Catch:{ a -> 0x0209 }
            com.apptimize.au r2 = f40789v     // Catch:{ a -> 0x0209 }
            boolean r2 = com.apptimize.c.b((android.content.Context) r0, (com.apptimize.au) r2)     // Catch:{ a -> 0x0209 }
            if (r2 == 0) goto L_0x01c9
            boolean r2 = r10.b()     // Catch:{ a -> 0x0209 }
            com.apptimize.cj r3 = r15.f()     // Catch:{ a -> 0x0209 }
            java.lang.String r2 = b((java.util.Properties) r13, (boolean) r2, (com.apptimize.cj) r3)     // Catch:{ a -> 0x0209 }
            com.apptimize.au r3 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.bz r3 = r3.f()     // Catch:{ a -> 0x0209 }
            if (r3 == 0) goto L_0x01c3
            com.apptimize.au r3 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.bz r3 = r3.f()     // Catch:{ a -> 0x0209 }
            com.apptimize.au r4 = f40789v     // Catch:{ a -> 0x0209 }
            com.apptimize.eu r4 = r4.e()     // Catch:{ a -> 0x0209 }
            r5 = r20
            r3.a((com.apptimize.aw) r5, (java.util.List<java.lang.String>) r1, (java.lang.String) r2, (com.apptimize.eu) r4)     // Catch:{ a -> 0x0209 }
            goto L_0x01c5
        L_0x01c3:
            r5 = r20
        L_0x01c5:
            r11.a((boolean) r12, (java.util.List<java.lang.String>) r1)     // Catch:{ a -> 0x0209 }
            goto L_0x01d4
        L_0x01c9:
            r5 = r20
            boolean r2 = r11.c()     // Catch:{ a -> 0x0209 }
            if (r2 != 0) goto L_0x01d4
            r11.a((boolean) r12, (java.util.List<java.lang.String>) r1)     // Catch:{ a -> 0x0209 }
        L_0x01d4:
            com.apptimize.t$b r1 = r11.d()     // Catch:{ a -> 0x0209 }
            boolean r2 = r10.a()     // Catch:{ a -> 0x0209 }
            r3 = r16
            b(r0, r1, r3, r2)     // Catch:{ a -> 0x0209 }
            android.content.Context r1 = r19.getApplicationContext()     // Catch:{ a -> 0x0209 }
            a((android.content.Context) r1, (java.util.Properties) r13)     // Catch:{ a -> 0x0209 }
            android.content.Context r0 = r19.getApplicationContext()     // Catch:{ a -> 0x0209 }
            r1 = r14
            r2 = r3
            r3 = r5
            r4 = r10
            r5 = r11
            r6 = r21
            r7 = r13
            r8 = r15
            b(r0, r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ a -> 0x0209 }
            r11.b()     // Catch:{ a -> 0x0209 }
        L_0x01fb:
            com.apptimize.gn.a()
            com.apptimize.gn$b r0 = com.apptimize.gn.b.f42668f
            boolean r0 = com.apptimize.gn.a((com.apptimize.gn.b) r0)
            if (r0 != 0) goto L_0x021f
            goto L_0x021c
        L_0x0207:
            r0 = move-exception
            goto L_0x0225
        L_0x0209:
            r0 = move-exception
            java.lang.String r1 = f40768a     // Catch:{ all -> 0x0207 }
            java.lang.String r2 = "Error in apptimize.properties"
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0207 }
            com.apptimize.gn.a()
            com.apptimize.gn$b r0 = com.apptimize.gn.b.f42668f
            boolean r0 = com.apptimize.gn.a((com.apptimize.gn.b) r0)
            if (r0 != 0) goto L_0x021f
        L_0x021c:
            com.apptimize.t.a()
        L_0x021f:
            com.apptimize.au r0 = f40789v
            r0.i()
            return
        L_0x0225:
            com.apptimize.gn.a()
            com.apptimize.gn$b r1 = com.apptimize.gn.b.f42668f
            boolean r1 = com.apptimize.gn.a((com.apptimize.gn.b) r1)
            if (r1 != 0) goto L_0x0233
            com.apptimize.t.a()
        L_0x0233:
            com.apptimize.au r1 = f40789v
            r1.i()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.Apptimize.b(android.content.Context, java.lang.String, com.apptimize.ApptimizeOptions):void");
    }

    private static List<String> a(Properties properties, boolean z11, cj cjVar) throws as.a {
        String a11 = f40789v.f() != null ? f40789v.f().a(properties) : null;
        if (a11 != null) {
            return Arrays.asList(new String[]{a11});
        } else if (z11) {
            return cjVar.l();
        } else {
            return cjVar.i();
        }
    }

    private static String a(String str, Properties properties) {
        String k11 = as.k(properties);
        return k11 != null ? k11 : str;
    }

    private static j.b a(ApptimizeOptions apptimizeOptions, Properties properties) throws as.a {
        j.b m11 = as.m(properties);
        if (m11 != null) {
            return m11;
        }
        int i11 = AnonymousClass52.f40920a[apptimizeOptions.getServerRegion().ordinal()];
        if (i11 == 1) {
            return j.b.DEFAULT;
        }
        if (i11 != 2) {
            return j.b.DEFAULT;
        }
        return j.b.EUCS;
    }

    private static void a(final String str, final Object obj) {
        fe.a(f40768a, new fi() {
            public void run() {
                if (str == null) {
                    Log.w(Apptimize.f40768a, "Attribute name cannot be null.");
                    return;
                }
                Apptimize.f40785r.a(str, obj);
                Apptimize.H();
            }
        });
    }

    public static <T> ApptimizeVar<T> a(String str, String str2, String str3, T t11) {
        final ApptimizeVar apptimizeVar = new ApptimizeVar(str, str2, str3, t11);
        return (ApptimizeVar) fe.a(f40768a, apptimizeVar, new fk<ApptimizeVar<T>>() {
            /* renamed from: a */
            public ApptimizeVar<T> b() {
                final AtomicReference atomicReference = new AtomicReference();
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        ge b11;
                        if (Apptimize.g("Not registering ApptimizeVar.")) {
                            atomicReference.set(ApptimizeVar.this);
                            return;
                        }
                        ApptimizeVar a11 = ej.a(ApptimizeVar.this);
                        if (!(Apptimize.f40770c == null || (b11 = Apptimize.f40770c.b()) == null)) {
                            b11.j();
                        }
                        atomicReference.set(a11);
                    }
                });
                return (ApptimizeVar) atomicReference.get();
            }
        });
    }

    public static <T> T a(final ApptimizeVar<T> apptimizeVar, final ApptimizeOptions apptimizeOptions) {
        final T a11 = k.a(apptimizeVar);
        return fe.a(f40768a, a11, new fk<T>() {
            public T b() {
                final AtomicReference atomicReference = new AtomicReference(a11);
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        if (Apptimize.E) {
                            if (Apptimize.G.get(apptimizeVar) == null) {
                                String g11 = Apptimize.f40768a;
                                bo.c(g11, "Test mode is active, but no user defined value set for the dynamic variable " + apptimizeVar.f40998a);
                                return;
                            }
                            atomicReference.set(Apptimize.G.get(apptimizeVar));
                        } else if (!Apptimize.g("Using default value for ApptimizeVar.") && Apptimize.h("valueForTest")) {
                            Apptimize.b(apptimizeOptions, c.RunTest);
                            atomicReference.set(Apptimize.f40770c.a(apptimizeVar));
                            bs.b("getExperimentValue " + apptimizeVar.f40998a + "=" + atomicReference.get());
                        }
                    }
                });
                return atomicReference.get();
            }
        });
    }

    private static void a(final Context context, final Properties properties) {
        fe.a(f40768a, new fi() {
            public void run() {
                long d11 = Apptimize.f40789v.e().d();
                Apptimize.f40789v.d().a((fi) new fi() {
                    public void run() {
                        final boolean z11;
                        if (av.f41258u || as.o(properties)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        Apptimize.f40789v.c().d(new fi() {
                            public void run() {
                                String str;
                                gn.a(Apptimize.f40776i.b(context));
                                if (!Apptimize.J()) {
                                    bs.b("Visual changes disabled");
                                    bo.j(Apptimize.f40768a, "Apptimize visual changes have been disabled on this device");
                                } else if (!Apptimize.f40776i.a("AN1015") || !gn.a(context, Apptimize.f40789v, z11, Apptimize.f40776i.a(context), Apptimize.f40776i.b(context))) {
                                    t.a();
                                    if (gn.i() != null) {
                                        str = " (" + gn.i() + ")";
                                    } else {
                                        str = "";
                                    }
                                    bs.a("Visual changes error", (Object) str);
                                    bo.j(Apptimize.f40768a, "Apptimize encountered an error or incompatibility when initializing visual changes. Visual changes are thus currently unavailable" + str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                                } else {
                                    bs.b("Visual changes enabled");
                                }
                                gn.a();
                                Apptimize.f40776i.a(Apptimize.f40789v);
                                if (Apptimize.J()) {
                                    gn.a(Apptimize.f40789v, context, Apptimize.f40776i.a(context), Apptimize.f40776i.b(context));
                                } else {
                                    Apptimize.f40782o.setVisualChangesEnabled(false);
                                    Apptimize.f40782o.setThirdPartyEventExportingEnabled(false);
                                }
                                if (!gn.e()) {
                                    Apptimize.f40789v.a().a(bq.b.CrashReportingNotInitialized);
                                }
                                Apptimize.f40776i.c();
                                x unused = Apptimize.f40771d = ae.a(context, Apptimize.f40789v.c());
                                if (Apptimize.f40771d != null) {
                                    z unused2 = Apptimize.f40772e = new ad(Apptimize.f40771d, Apptimize.f40789v, Apptimize.f40776i);
                                    y unused3 = Apptimize.f40773f = new aa(Apptimize.f40771d, Apptimize.f40789v, Apptimize.f40776i);
                                }
                            }
                        });
                    }
                });
                bs.a("visualSetup: " + Apptimize.f40789v.e().a(d11) + "ms");
            }
        });
    }

    private static Properties a(final Context context) {
        final AtomicReference atomicReference = new AtomicReference();
        f40789v.c().d(new fi() {
            public void run() {
                AssetManager assets = context.getAssets();
                Properties properties = new Properties();
                try {
                    properties.load(assets.open("apptimize.properties"));
                } catch (FileNotFoundException unused) {
                } catch (IOException e11) {
                    bo.i(Apptimize.f40768a, "Exception when loading apptimize.properties", e11);
                    properties.clear();
                }
                atomicReference.set(properties);
            }
        });
        return (Properties) atomicReference.get();
    }

    public static void a() {
        a("Apptimize library is now disabled.");
    }

    public static void a(String str) {
        f40789v.c().d(new fi() {
            public void run() {
                if (Apptimize.f40789v.f() != null) {
                    Apptimize.f40789v.f().h();
                }
                if (Apptimize.f40770c != null) {
                    if (Apptimize.f40770c.a() != null) {
                        Apptimize.f40770c.a().p();
                    }
                    ge b11 = Apptimize.f40770c.b();
                    if (b11 != null) {
                        b11.f();
                    }
                    ak c11 = Apptimize.f40770c.c();
                    if (c11 != null) {
                        c11.i();
                    }
                }
            }
        });
        bo.h(f40768a, str);
    }

    private static String b(Properties properties, boolean z11, cj cjVar) throws as.a {
        if (f40789v.f() != null) {
            return f40789v.f().b(properties);
        }
        return cjVar.o();
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, aw awVar, fb fbVar, u uVar, ApptimizeOptions apptimizeOptions, Properties properties, eg egVar) {
        final String str3 = str;
        final Context context2 = context;
        final Properties properties2 = properties;
        final ApptimizeOptions apptimizeOptions2 = apptimizeOptions;
        final eg egVar2 = egVar;
        final aw awVar2 = awVar;
        final String str4 = str2;
        final fb fbVar2 = fbVar;
        final u uVar2 = uVar;
        fe.a(f40768a, (fi) new fi() {
            public void run() {
                Apptimize.f40789v.c().d(new fi() {
                    public void run() {
                        String str;
                        bg bgVar;
                        ge geVar;
                        boolean z11;
                        try {
                            String g11 = Apptimize.f40768a;
                            bo.h(g11, "Initializing Apptimize with appKey " + str3 + " .");
                            fz a11 = ga.a();
                            String a12 = c.a(context2);
                            String a13 = j.a();
                            String str2 = av.f41259v;
                            if (str2 != null) {
                                a13 = str2;
                            }
                            String e11 = as.e(properties2);
                            if (e11 != null) {
                                str = e11;
                            } else {
                                str = a13;
                            }
                            Context context = context2;
                            bd.b bVar = bd.b.OnFlash;
                            ThreadPoolExecutor threadPoolExecutor = fg.f42429d;
                            bd.a a14 = f.a(context, bVar, threadPoolExecutor);
                            bd.a a15 = f.a(context2, bd.b.Temporary, threadPoolExecutor);
                            dm dmVar = new dm(a14, Apptimize.f40789v);
                            dl.b bVar2 = dl.b.LocalAttribute;
                            Object obj = dt.a(dmVar, bVar2).get("app_key");
                            if (obj != null && (obj instanceof String) && !((String) obj).equals(str3)) {
                                as.a(a14, a15, context2, Apptimize.f40789v);
                                dmVar = new dm(a14, Apptimize.f40789v);
                            }
                            dm dmVar2 = dmVar;
                            if (apptimizeOptions2.isMultiprocessModeEnabled()) {
                                bo.h(Apptimize.f40768a, "Enabling multiprocess support");
                                if (!c.g(context2)) {
                                    bo.j(Apptimize.f40768a, "You enabled multiprocess support, but Apptimize only detected one process in this app. This will cause unnecessary performance penalties.");
                                }
                            } else if (c.f(context2)) {
                                bo.g(Apptimize.f40768a, "Apptimize has detected that your app has activities that run in multiple processes. Apptimize will not run in activities that run outside the main process. Contact Apptimize support for help.");
                                Apptimize.f40789v.a().a(bq.b.ActivitiesInMultipleProcesses);
                            }
                            ef efVar = new ef(a14, Apptimize.f40789v);
                            AnonymousClass39 r72 = AnonymousClass39.this;
                            dr drVar = new dr(context2, a14, dmVar2, egVar2, Apptimize.f40789v, ds.a(a14, Apptimize.f40789v, fg.f42427b), new ev(fg.f42428c));
                            drVar.a(a12);
                            drVar.b();
                            Cdo doVar = new Cdo(a14, Apptimize.f40789v);
                            dv dvVar = new dv(a14, Apptimize.f40789v, "permanent");
                            new dv(a15, Apptimize.f40789v, "temp").g();
                            ea eaVar = new ea(a14, Apptimize.f40789v);
                            et etVar = new et(a14, Apptimize.f40789v, "permanent");
                            gp gpVar = new gp();
                            bd.a aVar = a15;
                            et etVar2 = etVar;
                            bg iiVar = new ii(context2, threadPoolExecutor, Apptimize.f40778k, Apptimize.f40789v);
                            bg bgVar2 = iiVar;
                            dr drVar2 = drVar;
                            ef efVar2 = efVar;
                            dl.b bVar3 = bVar2;
                            eh ehVar = new eh(a14, Apptimize.f40789v, awVar2, gpVar, threadPoolExecutor);
                            if (!Apptimize.J()) {
                                bgVar = new ei();
                            } else {
                                bgVar = bgVar2;
                            }
                            AnonymousClass39 r73 = AnonymousClass39.this;
                            String str3 = str3;
                            String str4 = str4;
                            aw awVar = awVar2;
                            eg egVar = egVar2;
                            ay ayVar = new ay(str3, str4, awVar, egVar, properties2, Apptimize.f40789v);
                            Apptimize.C.add(new OnExperimentsProcessedListener() {
                                public void onExperimentsProcessed() {
                                    bo.f(Apptimize.f40768a, "onExperimentsProcessedListeners");
                                    Apptimize.f40786s.set(true);
                                    Apptimize.I();
                                }
                            });
                            Apptimize.f40789v.a(new fi() {
                                public void run() {
                                    bo.f(Apptimize.f40768a, "notifyOnSetupEnd");
                                    Apptimize.f40787t.set(true);
                                    Apptimize.I();
                                }
                            });
                            OnExperimentRunListener A = Apptimize.f40792y;
                            OnTestRunListener B = Apptimize.f40793z;
                            OnTestEnrollmentChangedListener C = Apptimize.A;
                            List t11 = Apptimize.C;
                            List u11 = Apptimize.D;
                            s a16 = s.a(context2, Apptimize.f40789v);
                            AnonymousClass39 r74 = AnonymousClass39.this;
                            String str5 = str3;
                            String str6 = str4;
                            boolean a17 = Apptimize.f40783p.a();
                            Map<String, Object> b11 = Apptimize.f40783p.b();
                            boolean a18 = Apptimize.f40784q.a();
                            Map<String, Object> b12 = Apptimize.f40784q.b();
                            au c11 = Apptimize.f40789v;
                            AnonymousClass39 r75 = AnonymousClass39.this;
                            eg egVar2 = egVar2;
                            bd.a aVar2 = aVar;
                            bd.a aVar3 = a14;
                            dv dvVar2 = dvVar;
                            dl.b bVar4 = bVar3;
                            eg egVar3 = egVar2;
                            String str7 = str6;
                            dm dmVar3 = dmVar2;
                            String str8 = str5;
                            ea eaVar2 = eaVar;
                            bd.a aVar4 = aVar3;
                            String str9 = "app_key";
                            dt dtVar = r5;
                            dt dtVar2 = new dt(dvVar2, etVar2, drVar2, efVar2, dmVar3, eaVar2, ehVar, doVar, A, B, C, t11, u11, a16, str8, str7, a12, a17, b11, a18, b12, bgVar, ayVar, c11, egVar3, apptimizeOptions2.isExplicitEnablingRequired(), apptimizeOptions2.isThirdPartyEventExportingEnabled(), apptimizeOptions2.doesForceVariantsShowWinnersAndInstantUpdates(), apptimizeOptions2.isRefreshingMetadataOnSetup());
                            a unused = Apptimize.f40783p = null;
                            Apptimize.f40789v.a().a(dtVar);
                            boolean b13 = fbVar2.b();
                            boolean c12 = fbVar2.c();
                            if (Apptimize.f40789v.f() != null) {
                                Apptimize.f40789v.f().a(awVar2, dtVar.r(), dtVar.j(), dtVar.k(), properties2, Apptimize.f40776i, Apptimize.f40773f, egVar2, Apptimize.f40789v, b13, apptimizeOptions2.isRefreshingMetadataOnSetup());
                            }
                            if (c12) {
                                AnonymousClass39 r42 = AnonymousClass39.this;
                                String a19 = c.a(apptimizeOptions2, str4);
                                Apptimize.f40782o.setDeviceName(a19);
                                AnonymousClass3 r12 = new bj.b() {
                                    public bj a(URI uri, bj.a aVar, List<Pair<String, String>> list) {
                                        return new go(uri, aVar, list);
                                    }
                                };
                                if (!c.f(context2) || apptimizeOptions2.isMultiprocessModeEnabled()) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                                AnonymousClass39 r62 = AnonymousClass39.this;
                                String str10 = str;
                                dt dtVar3 = dtVar;
                                geVar = new ge(str3, str4, a19, str10, r12, dtVar3, Apptimize.f40789v, Apptimize.f40778k.f(), b13, z11);
                            } else {
                                bo.h(Apptimize.f40768a, "This is not a developer build; test preview/dry-run disabled.");
                                geVar = null;
                            }
                            au c13 = Apptimize.f40789v;
                            AnonymousClass39 r76 = AnonymousClass39.this;
                            as unused2 = Apptimize.f40770c = new as(dtVar, geVar, c13, context2, str3, aVar4, aVar2, apptimizeOptions2, properties2, b13, c12);
                            fb fbVar = fbVar2;
                            if (!(fbVar == null || geVar == null)) {
                                fbVar.a(geVar);
                            }
                            if (Apptimize.f40772e != null) {
                                if (geVar != null) {
                                    geVar.a(Apptimize.f40772e);
                                }
                                fb fbVar2 = fbVar2;
                                if (fbVar2 != null) {
                                    fbVar2.a(Apptimize.f40772e);
                                }
                                dtVar.a(Apptimize.f40772e);
                                uVar2.a(Apptimize.f40772e);
                            }
                            gr unused3 = Apptimize.f40774g = new gr(context2.getClassLoader(), Apptimize.f40771d, geVar, Apptimize.f40789v, dtVar, gpVar, bgVar2, apptimizeOptions2.isExplicitEnablingRequired());
                            if (b13) {
                                br.a(Apptimize.f40789v, context2, dtVar, Apptimize.f40774g);
                            }
                            if (geVar != null) {
                                geVar.e();
                            }
                            a11.a();
                            if (Apptimize.f40776i.b()) {
                                Apptimize.a();
                            }
                            dk unused4 = Apptimize.f40777j = dk.a(context2, Apptimize.f40770c, Apptimize.f40789v);
                            if (apptimizeOptions2.isThirdPartyEventImportingEnabled()) {
                                Apptimize.f40777j.a(Apptimize.f40776i, Apptimize.f40789v);
                            }
                            drVar2.c();
                            if (Apptimize.f40789v.d().c()) {
                                dtVar.a(bVar4, str9, (Object) str3);
                            }
                            if (Apptimize.f40779l == null) {
                                d unused5 = Apptimize.f40779l = new d(Apptimize.f40789v, Apptimize.f40773f);
                            }
                            r unused6 = Apptimize.f40780m = new r(aVar4, Apptimize.f40789v);
                        } catch (as.a e12) {
                            Log.e(Apptimize.f40768a, "Error in apptimize.properties", e12);
                        }
                    }
                });
            }
        }, "Apptimize threw an exception which wasn't caught (in setup thread); this should not have happened.");
    }

    /* access modifiers changed from: private */
    public static void b(final ApptimizeOptions apptimizeOptions, final c cVar) {
        if (apptimizeOptions.getUpdateMetaDataTimeout() == null || (!(f40789v.f() == null || !f40789v.f().g() || f40770c.a().y() == null) || (f40789v.d().b() && c.a()))) {
            String str = f40768a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Don't waitForMetaData --  getUpdateMetaDataTimeout:");
            sb2.append(apptimizeOptions.getUpdateMetaDataTimeout());
            sb2.append(" env.getMetaDataDownloader().initialMetaDataHasArrived:");
            sb2.append(f40789v.f() != null ? Boolean.valueOf(f40789v.f().g()) : "none");
            sb2.append(" haveProcessedMetaData:");
            sb2.append(f40770c.a().y() != null);
            sb2.append(" env.getMultiprocessManager().isMultiprocessEnabled():");
            sb2.append(f40789v.d().b());
            sb2.append(" AndroidUtils.isMainThread():");
            sb2.append(c.a());
            bo.k(str, sb2.toString());
            return;
        }
        fe.a(f40768a, new fi() {
            public void run() {
                bo.k(Apptimize.f40768a, "Start waitForMetaData");
                final long d11 = Apptimize.f40789v.e().d();
                Apptimize.f40789v.c().e(new fi() {
                    public void run() {
                        if ((Apptimize.f40776i == null || !Apptimize.f40776i.b()) && Apptimize.h("waitForMetaData")) {
                            if (Apptimize.f40789v.d().c()) {
                                Long updateMetaDataTimeout = ApptimizeOptions.this.getUpdateMetaDataTimeout();
                                if (updateMetaDataTimeout == null || Apptimize.f40789v.f() == null) {
                                    bo.a(Apptimize.f40768a, "No wait for metadata option.");
                                } else {
                                    if (updateMetaDataTimeout.longValue() <= 0 || updateMetaDataTimeout.longValue() > 5000) {
                                        String g11 = Apptimize.f40768a;
                                        bo.h(g11, "The updateMetadataTimeout option in ApptimizeOptions has been set to " + updateMetaDataTimeout + ", but we will use the maximum value of " + 5000 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                                        updateMetaDataTimeout = 5000L;
                                    }
                                    Apptimize.f40782o.setUpdateMetadataTimeout(updateMetaDataTimeout.longValue());
                                    long nanoTime = System.nanoTime() + (updateMetaDataTimeout.longValue() * 1000000);
                                    String g12 = Apptimize.f40768a;
                                    bo.a(g12, "Starting waiting for metadata (will wait for up to " + updateMetaDataTimeout + " milliseconds) " + Apptimize.f40789v.e().b());
                                    Apptimize.f40789v.f().a(updateMetaDataTimeout.longValue());
                                    Apptimize.f40770c.a().a(nanoTime);
                                    String g13 = Apptimize.f40768a;
                                    bo.a(g13, "Finished waiting for metadata " + Apptimize.f40789v.e().b());
                                }
                                if (!Apptimize.f40789v.f().g()) {
                                    bo.j(Apptimize.f40768a, cVar.a());
                                }
                            } else if (ApptimizeOptions.this.getUpdateMetaDataTimeout() != null && Apptimize.f40789v.f() == null) {
                                bo.i(Apptimize.f40768a, "In multiprocess mode, ApptimizeOptions#setUpdateMetadataTimeout is only used on the main process, so will not be applied for this one.");
                            }
                            bs.a("waitForInitialMetaData: " + Apptimize.f40789v.e().a(d11) + "ms");
                        }
                    }
                });
                bo.k(Apptimize.f40768a, "Finish waitForMetaData");
            }
        });
    }

    public static ak b() {
        return f40789v.d();
    }
}
