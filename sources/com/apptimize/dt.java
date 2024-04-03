package com.apptimize;

import android.app.Activity;
import com.apptimize.Apptimize;
import com.apptimize.ag;
import com.apptimize.ap;
import com.apptimize.bz;
import com.apptimize.dl;
import com.apptimize.dp;
import com.apptimize.du;
import com.apptimize.ed;
import com.apptimize.z;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public class dt implements ao {
    private static final ThreadLocal<Boolean> Y = new ThreadLocal<Boolean>() {
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42013a = "dt";
    private Set<Long> A;
    /* access modifiers changed from: private */
    public final ap B;
    private final AtomicBoolean C;
    private final a D;
    private final List<ep> E;
    /* access modifiers changed from: private */
    public final eo F;
    private final eg G;
    private final AtomicReference<Map<String, ApptimizeTestInfo>> H;
    private final AtomicReference<Map<String, ApptimizeInstantUpdateOrWinnerInfo>> I;
    private Set<dp.k> J;
    private final AtomicReference<EnumSet<Apptimize.ApptimizeMetadataStateFlags>> K;
    private final du L;
    private final du.f M;
    private final AtomicInteger N;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<Integer, Integer> O;
    private final Map<Integer, EnumSet<a>> P;
    /* access modifiers changed from: private */
    public final AtomicInteger Q;
    /* access modifiers changed from: private */
    public final AtomicInteger R;
    private final AtomicBoolean S;
    private final AtomicReference<c> T;
    private final AtomicBoolean U;
    private final AtomicInteger V;
    private final CopyOnWriteArrayList<CountDownLatch> W;
    /* access modifiers changed from: private */
    public final AtomicReference<EnumSet<bz.b>> X;
    private AtomicBoolean Z;

    /* renamed from: aa  reason: collision with root package name */
    private final Set<Long> f42014aa;

    /* renamed from: ab  reason: collision with root package name */
    private AtomicBoolean f42015ab;

    /* renamed from: b  reason: collision with root package name */
    private final fv f42016b;

    /* renamed from: c  reason: collision with root package name */
    private dv f42017c;

    /* renamed from: d  reason: collision with root package name */
    private final et f42018d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ay f42019e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final dr f42020f;

    /* renamed from: g  reason: collision with root package name */
    private final ef f42021g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final dm f42022h;

    /* renamed from: i  reason: collision with root package name */
    private final ea f42023i;

    /* renamed from: j  reason: collision with root package name */
    private final eh f42024j;

    /* renamed from: k  reason: collision with root package name */
    private final Cdo f42025k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final boolean f42026l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f42027m;

    /* renamed from: n  reason: collision with root package name */
    private final String f42028n;

    /* renamed from: o  reason: collision with root package name */
    private String f42029o;

    /* renamed from: p  reason: collision with root package name */
    private final be f42030p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final au f42031q;

    /* renamed from: r  reason: collision with root package name */
    private final ag f42032r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final AtomicBoolean f42033s = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private final AtomicReference<Apptimize.OnExperimentRunListener> f42034t;

    /* renamed from: u  reason: collision with root package name */
    private final AtomicReference<Apptimize.OnTestRunListener> f42035u;

    /* renamed from: v  reason: collision with root package name */
    private final AtomicReference<Apptimize.OnTestEnrollmentChangedListener> f42036v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final List<d> f42037w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final List<Apptimize.OnExperimentsProcessedListener> f42038x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final List<Apptimize.MetadataStateChangedListener> f42039y;

    /* renamed from: z  reason: collision with root package name */
    private final List<b> f42040z;

    public enum a {
        None,
        SetCustomAttributes,
        RemoveCustomAttributes,
        NotifyExperimentsProcessed,
        ProcessNewPermanentMetaDataComplete,
        CheckToSlowSchedulePost
    }

    public interface b {
        void a(long j11);

        void a(String str, dp.k kVar, Map<String, Object> map);
    }

    public interface d {
        void a();
    }

    public dt(dv dvVar, et etVar, dr drVar, ef efVar, dm dmVar, ea eaVar, eh ehVar, Cdo doVar, Apptimize.OnExperimentRunListener onExperimentRunListener, Apptimize.OnTestRunListener onTestRunListener, Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener, List<Apptimize.OnExperimentsProcessedListener> list, List<Apptimize.MetadataStateChangedListener> list2, be beVar, String str, String str2, String str3, boolean z11, Map<String, Object> map, boolean z12, Map<String, Object> map2, bg bgVar, ay ayVar, au auVar, eg egVar, boolean z13, boolean z14, boolean z15, boolean z16) {
        boolean z17;
        Map<String, Object> map3;
        Map<String, Object> map4;
        boolean z18;
        dr drVar2 = drVar;
        dm dmVar2 = dmVar;
        List<Apptimize.OnExperimentsProcessedListener> list3 = list;
        List<Apptimize.MetadataStateChangedListener> list4 = list2;
        boolean z19 = z11;
        Map<String, Object> map5 = map;
        boolean z21 = z12;
        Map<String, Object> map6 = map2;
        ay ayVar2 = ayVar;
        au auVar2 = auVar;
        eg egVar2 = egVar;
        AtomicReference<Apptimize.OnExperimentRunListener> atomicReference = new AtomicReference<>();
        this.f42034t = atomicReference;
        AtomicReference<Apptimize.OnTestRunListener> atomicReference2 = new AtomicReference<>();
        this.f42035u = atomicReference2;
        AtomicReference<Apptimize.OnTestEnrollmentChangedListener> atomicReference3 = new AtomicReference<>();
        this.f42036v = atomicReference3;
        this.f42037w = new CopyOnWriteArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f42038x = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.f42039y = copyOnWriteArrayList2;
        this.f42040z = new CopyOnWriteArrayList();
        this.A = new HashSet();
        CopyOnWriteArrayList copyOnWriteArrayList3 = copyOnWriteArrayList2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.C = atomicBoolean;
        this.H = new AtomicReference<>();
        this.I = new AtomicReference<>();
        this.J = null;
        AtomicBoolean atomicBoolean2 = atomicBoolean;
        this.K = new AtomicReference<>(EnumSet.noneOf(Apptimize.ApptimizeMetadataStateFlags.class));
        this.N = new AtomicInteger(0);
        this.O = new ConcurrentHashMap<>();
        this.P = new ConcurrentHashMap();
        this.Q = new AtomicInteger(0);
        this.R = new AtomicInteger(-1);
        this.S = new AtomicBoolean(false);
        this.T = new AtomicReference<>(new c());
        this.U = new AtomicBoolean(false);
        this.V = new AtomicInteger(0);
        this.W = new CopyOnWriteArrayList<>();
        this.X = new AtomicReference<>(EnumSet.noneOf(bz.b.class));
        this.Z = new AtomicBoolean(true);
        this.f42014aa = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f42015ab = new AtomicBoolean(false);
        this.f42032r = a(auVar2);
        this.f42016b = auVar.b();
        this.f42017c = dvVar;
        this.f42018d = etVar;
        this.f42020f = drVar2;
        this.f42021g = efVar;
        this.f42022h = dmVar2;
        this.f42023i = eaVar;
        this.f42024j = ehVar;
        this.f42025k = doVar;
        this.f42030p = beVar;
        this.f42028n = str2;
        this.f42029o = str3;
        this.f42019e = ayVar2;
        this.f42031q = auVar2;
        atomicReference.set(onExperimentRunListener);
        atomicReference2.set(onTestRunListener);
        atomicReference3.set(onTestEnrollmentChangedListener);
        if (list3 != null) {
            copyOnWriteArrayList.addAll(list3);
        }
        if (list4 != null) {
            copyOnWriteArrayList3.addAll(list4);
        }
        this.f42026l = z13;
        eg egVar3 = egVar;
        this.G = egVar3;
        this.f42027m = z14;
        atomicBoolean2.set(z15);
        this.F = new eo(this);
        this.E = new ArrayList<ep>() {
            {
                add(new en());
                add(dt.this.F);
            }
        };
        this.D = new a(auVar2, this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new eq(egVar3));
        arrayList.add(ehVar.e());
        arrayList.add(bgVar);
        if (auVar.d().c()) {
            eg egVar4 = egVar3;
            map4 = map2;
            ay ayVar3 = ayVar2;
            z18 = z12;
            map3 = map;
            z17 = false;
            du duVar = new du(auVar, this.f42017c, arrayList, egVar, eaVar, str2, str, ehVar.g());
            this.L = duVar;
            du.f F2 = F();
            this.M = F2;
            duVar.a(F2);
        } else {
            map3 = map;
            z18 = z12;
            map4 = map2;
            z17 = false;
            this.L = null;
            this.M = null;
        }
        boolean z22 = z11;
        boolean z23 = z17;
        boolean z24 = (dmVar2.a(dl.b.LocalAttribute, z18, map4) || dmVar2.a(dl.b.UserAttribute, z22, map3)) ? true : z23;
        if (z24) {
            LinkedList linkedList = new LinkedList();
            for (Long longValue : P()) {
                linkedList.add(e(longValue.longValue()));
            }
            drVar2.a(P(), (List<ek>) linkedList);
            N();
        }
        E();
        Map<String, Object> map7 = map3;
        ayVar.a(this);
        boolean z25 = z18;
        ed a11 = etVar.a(z23, true);
        cc h11 = this.f42017c.h();
        if (!auVar.d().c()) {
            this.Q.set(-1);
        } else if (a11 != null && a11.c() != null && a11.k() != null) {
            cc c11 = a11.c();
            this.T.set(new c(a11.k(), z23, c11.c(), c11.d()));
        } else if (!(h11 == null || h11.f() == null || !(h11.f() instanceof cb))) {
            this.T.set(new c((cb) h11.f(), z23, h11.c(), h11.d()));
        }
        AtomicReference<c> atomicReference4 = this.T;
        if (!(atomicReference4 == null || atomicReference4.get().f42101a == null || this.T.get().f42101a.m() == null)) {
            egVar.a(this.T.get().f42101a.m());
        }
        this.D.a();
        this.B = T();
        if (!z16) {
            b(z24);
        }
        Map<String, Object> map8 = map4;
        this.F.a(str3, str2);
        if (!auVar.d().c()) {
            a(dl.b.UserAttribute, z22, map7);
            a(dl.b.LocalAttribute, z25, map8);
            return;
        }
        this.f42017c.g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void E() {
        /*
            r3 = this;
            com.apptimize.et r0 = r3.f42018d
            r1 = 0
            com.apptimize.ed r0 = r0.a((boolean) r1, (boolean) r1)
            r2 = 1
            if (r0 == 0) goto L_0x0010
            java.util.Set r0 = r0.j()
        L_0x000e:
            r1 = r2
            goto L_0x0022
        L_0x0010:
            com.apptimize.dv r0 = r3.f42017c
            com.apptimize.cc r0 = r0.b((boolean) r1)
            if (r0 == 0) goto L_0x001d
            java.util.Set r0 = r0.h()
            goto L_0x000e
        L_0x001d:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
        L_0x0022:
            r3.A = r0
            if (r1 == 0) goto L_0x0042
            java.lang.String r0 = f42013a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Re-forcing persisted forced variants "
            r1.append(r2)
            java.util.Set<java.lang.Long> r2 = r3.A
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.apptimize.bo.h(r0, r1)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.E():void");
    }

    private du.f F() {
        return new du.f() {
            public void a(int i11, ee eeVar, ed edVar, Map<Integer, Integer> map) {
                final Map<Integer, Integer> map2;
                final boolean a11 = dt.this.a(edVar);
                dt.this.a(i11, eeVar, edVar);
                if (dt.this.f42031q.d().b() && dt.this.B != null) {
                    synchronized (this) {
                        if (!dt.this.I()) {
                            map = Collections.unmodifiableMap(dt.this.O);
                        }
                        map2 = map;
                    }
                    bo.k(dt.f42013a, "Send MD processed from main to clients");
                    final ee eeVar2 = eeVar;
                    final ed edVar2 = edVar;
                    dt.this.f42031q.d().c(new fi() {
                        public void run() {
                            String a11 = ee.a(eeVar2);
                            String a12 = ed.a(edVar2, a11);
                            String D = dt.f42013a;
                            bo.k(D, "MD From Main before broadcast: result = " + a11.length() + " PMD = " + a12.length() + " clients: " + map2.toString());
                            dt.this.B.b("metadataProcessedFromMain", a11, a12, map2);
                            bo.k(dt.f42013a, "MD Update sent");
                        }
                    });
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void G() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.apptimize.ed r0 = r3.y()     // Catch:{ all -> 0x0026 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0013
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.Z     // Catch:{ all -> 0x0026 }
            r0.set(r1)     // Catch:{ all -> 0x0026 }
            r3.c((boolean) r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r3)
            return
        L_0x0013:
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.Z     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.compareAndSet(r2, r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0021
            com.apptimize.dt$a r0 = com.apptimize.dt.a.NotifyExperimentsProcessed     // Catch:{ all -> 0x0026 }
            r3.a((com.apptimize.dt.a) r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0024
        L_0x0021:
            r3.c((boolean) r2)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r3)
            return
        L_0x0026:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.G():void");
    }

    private int H() {
        return this.f42031q.d().c() ? this.N.get() : this.N.incrementAndGet();
    }

    /* access modifiers changed from: private */
    public synchronized boolean I() {
        boolean z11;
        if ((this.f42031q.d().c() || this.S.get()) && this.Q.get() >= this.N.get()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return z11;
    }

    private void J() {
        this.f42019e.b();
    }

    private synchronized void K() {
        if (!I()) {
            Iterator<CountDownLatch> it = this.W.iterator();
            while (it.hasNext()) {
                it.next().countDown();
            }
            this.W.clear();
        }
    }

    private void L() {
        fg.f42429d.submit(new fi() {
            public void run() {
                fe.a(dt.f42013a, new fi() {
                    public void run() {
                        for (d a11 : dt.this.f42037w) {
                            a11.a();
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void M() {
        bo.f(f42013a, "notifyExperimentsProcessed");
        c.a((fi) new fi() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0092, code lost:
                if (r0.hasNext() == false) goto L_0x009e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0094, code lost:
                ((com.apptimize.Apptimize.OnExperimentsProcessedListener) r0.next()).onExperimentsProcessed();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x009e, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x007f, code lost:
                com.apptimize.bs.b("notifyExperimentsProcessed");
                r0 = com.apptimize.dt.j(r4.f42067a).iterator();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    monitor-enter(r4)
                    com.apptimize.dt r0 = com.apptimize.dt.this     // Catch:{ all -> 0x009f }
                    java.util.concurrent.atomic.AtomicInteger r0 = r0.Q     // Catch:{ all -> 0x009f }
                    int r0 = r0.get()     // Catch:{ all -> 0x009f }
                    com.apptimize.dt r1 = com.apptimize.dt.this     // Catch:{ all -> 0x009f }
                    java.util.concurrent.atomic.AtomicInteger r1 = r1.R     // Catch:{ all -> 0x009f }
                    int r1 = r1.get()     // Catch:{ all -> 0x009f }
                    if (r0 != r1) goto L_0x0047
                    java.lang.String r1 = com.apptimize.dt.f42013a     // Catch:{ all -> 0x009f }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
                    r2.<init>()     // Catch:{ all -> 0x009f }
                    java.lang.String r3 = "notifyExperimentsProcessed already done:"
                    r2.append(r3)     // Catch:{ all -> 0x009f }
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    java.lang.String r0 = " pid:"
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    com.apptimize.dt r0 = com.apptimize.dt.this     // Catch:{ all -> 0x009f }
                    com.apptimize.au r0 = r0.f42031q     // Catch:{ all -> 0x009f }
                    com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x009f }
                    int r0 = r0.h()     // Catch:{ all -> 0x009f }
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009f }
                    com.apptimize.bo.k(r1, r0)     // Catch:{ all -> 0x009f }
                    monitor-exit(r4)     // Catch:{ all -> 0x009f }
                    return
                L_0x0047:
                    com.apptimize.dt r1 = com.apptimize.dt.this     // Catch:{ all -> 0x009f }
                    java.util.concurrent.atomic.AtomicInteger r1 = r1.R     // Catch:{ all -> 0x009f }
                    r1.set(r0)     // Catch:{ all -> 0x009f }
                    java.lang.String r1 = com.apptimize.dt.f42013a     // Catch:{ all -> 0x009f }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
                    r2.<init>()     // Catch:{ all -> 0x009f }
                    java.lang.String r3 = "notifyExperimentsProcessed will be done:"
                    r2.append(r3)     // Catch:{ all -> 0x009f }
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    java.lang.String r0 = " pid:"
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    com.apptimize.dt r0 = com.apptimize.dt.this     // Catch:{ all -> 0x009f }
                    com.apptimize.au r0 = r0.f42031q     // Catch:{ all -> 0x009f }
                    com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x009f }
                    int r0 = r0.h()     // Catch:{ all -> 0x009f }
                    r2.append(r0)     // Catch:{ all -> 0x009f }
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009f }
                    com.apptimize.bo.k(r1, r0)     // Catch:{ all -> 0x009f }
                    monitor-exit(r4)     // Catch:{ all -> 0x009f }
                    java.lang.String r0 = "notifyExperimentsProcessed"
                    com.apptimize.bs.b((java.lang.String) r0)
                    com.apptimize.dt r0 = com.apptimize.dt.this
                    java.util.List r0 = r0.f42038x
                    java.util.Iterator r0 = r0.iterator()
                L_0x008e:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x009e
                    java.lang.Object r1 = r0.next()
                    com.apptimize.Apptimize$OnExperimentsProcessedListener r1 = (com.apptimize.Apptimize.OnExperimentsProcessedListener) r1
                    r1.onExperimentsProcessed()
                    goto L_0x008e
                L_0x009e:
                    return
                L_0x009f:
                    r0 = move-exception
                    monitor-exit(r4)     // Catch:{ all -> 0x009f }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.AnonymousClass20.run():void");
            }
        });
    }

    private void N() {
        if (this.f42031q.d().c()) {
            this.f42022h.c();
        }
    }

    private synchronized void O() {
        if (!I()) {
            bo.k(f42013a, "ensureClientSync will run");
            this.f42031q.d().c(new fi() {
                public void run() {
                    if (dt.this.f42031q.d().d()) {
                        dt.this.f42022h.e();
                    }
                    if (dt.this.B != null) {
                        dt.this.B.b("syncMetaDataProcessingFromMain", Collections.unmodifiableMap(dt.this.O));
                        String D = dt.f42013a;
                        bo.k(D, "ensureClientSync " + dt.this.O);
                    }
                }
            });
        } else {
            bo.k(f42013a, "ensureClientSync will not run, we are processing metadata");
        }
    }

    private Set<Long> P() {
        ed y11 = y();
        if (y11 != null) {
            return y11.i();
        }
        if (this.f42017c.h() != null) {
            return this.f42017c.h().g();
        }
        return Collections.EMPTY_SET;
    }

    private void Q() {
        bo.d(f42013a, "Invalidating cached TestInfo");
        this.H.set((Object) null);
        this.I.set((Object) null);
    }

    /* access modifiers changed from: private */
    public void R() {
        bo.k(f42013a, "applicationSleep");
        S();
        this.f42032r.b("applicationSleep", new Object[0]);
    }

    private void S() {
        if (this.f42031q.d().c() && this.U.get() && this.V.incrementAndGet() == 2) {
            f();
        }
    }

    private ap T() {
        Class<Map> cls = Map.class;
        Class<String> cls2 = String.class;
        Class<dt> cls3 = dt.class;
        try {
            ap.a a11 = new ap.a(this).a("metadataProcessedFromMain", cls3.getDeclaredMethod("a", new Class[]{cls2, cls2, cls})).a("syncMetaDataProcessingFromMain", cls3.getDeclaredMethod("a", new Class[]{cls})).a("setDownloaderMetadataStateFlagsFromMain", cls3.getDeclaredMethod("b", new Class[]{EnumSet.class}));
            Class cls4 = Boolean.TYPE;
            return a11.a("downloadManagerForegrounded", cls3.getDeclaredMethod("a", new Class[]{cls4})).a("downloadStateChanged", cls3.getDeclaredMethod("h", new Class[0])).a("scheduleNotifyExperimentsProcessed", cls3.getDeclaredMethod(c.f41585a, new Class[]{cls4})).a("startUsingWysiwygFromMain", cls3.getDeclaredMethod("e", new Class[0])).a("stopUsingWysiwygFromMain", cls3.getDeclaredMethod("g", new Class[0])).a(this.f42031q.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42013a, "Error binding", e11);
            return null;
        }
    }

    public Map<String, Object> A() {
        return this.f42022h.g();
    }

    public dy B() {
        return this.f42023i.e();
    }

    public Map<String, Set<String>> C() {
        return Collections.unmodifiableMap(this.f42024j.f());
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d9, code lost:
        r6 = r3.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        if (r3.h().booleanValue() == false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e9, code lost:
        r8 = com.apptimize.ApptimizeInstantUpdateOrWinnerInfo.Type.INSTANT_UPDATE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ec, code lost:
        r8 = com.apptimize.ApptimizeInstantUpdateOrWinnerInfo.Type.WINNER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f7, code lost:
        if (r3.h().booleanValue() == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f9, code lost:
        r12 = r3.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        if (r3.h().booleanValue() == false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010a, code lost:
        r13 = r3.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0110, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0119, code lost:
        if (r3.i().booleanValue() == false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011b, code lost:
        r14 = r3.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0121, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012a, code lost:
        if (r3.i().booleanValue() == false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012c, code lost:
        r9 = r3.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        r1.put(r6, new com.apptimize.ApptimizeInstantUpdateOrWinnerInfo(r11, r12, r13, r14, r9, r3.a(), r3.n(), v(), w()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, com.apptimize.ApptimizeInstantUpdateOrWinnerInfo> t() {
        /*
            r20 = this;
            r0 = r20
            java.util.concurrent.atomic.AtomicReference<java.util.Map<java.lang.String, com.apptimize.ApptimizeInstantUpdateOrWinnerInfo>> r1 = r0.I
            java.lang.Object r1 = r1.get()
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x0014
            java.lang.String r2 = f42013a
            java.lang.String r3 = "Returning cached HotfixInfo"
            com.apptimize.bo.d(r2, r3)
            return r1
        L_0x0014:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            com.apptimize.cc r2 = r20.r()
            if (r2 != 0) goto L_0x0024
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r1)
            return r1
        L_0x0024:
            com.apptimize.ed r3 = r20.y()
            if (r3 != 0) goto L_0x002f
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r1)
            return r1
        L_0x002f:
            com.apptimize.by r2 = r2.f()
            boolean r4 = r2 instanceof com.apptimize.cb
            if (r4 != 0) goto L_0x003c
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r1)
            return r1
        L_0x003c:
            com.apptimize.cb r2 = (com.apptimize.cb) r2
            java.util.Map r4 = r3.e()
            java.util.Set r4 = r4.keySet()
            java.util.List r3 = r3.a()
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r3.size()
            r5.<init>(r6)
            java.util.Iterator r3 = r3.iterator()
        L_0x0057:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0078
            java.lang.Object r6 = r3.next()
            com.apptimize.dc r6 = (com.apptimize.dc) r6
            org.json.JSONObject r6 = r6.a()     // Catch:{ Exception -> 0x0057 }
            boolean r7 = r6 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x0057 }
            if (r7 != 0) goto L_0x0070
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0074
        L_0x0070:
            java.lang.String r6 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r6)     // Catch:{ Exception -> 0x0057 }
        L_0x0074:
            r5.add(r6)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0057
        L_0x0078:
            java.util.List r2 = r2.i()
            java.util.Iterator r2 = r2.iterator()
        L_0x0080:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x014a
            java.lang.Object r3 = r2.next()
            com.apptimize.bx r3 = (com.apptimize.bx) r3
            java.util.List r6 = r3.f()
            if (r6 != 0) goto L_0x0093
            goto L_0x0080
        L_0x0093:
            java.util.Iterator r6 = r6.iterator()
        L_0x0097:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0080
            java.lang.Object r7 = r6.next()
            com.apptimize.bt r7 = (com.apptimize.bt) r7
            boolean r8 = r7 instanceof com.apptimize.bt.f
            r9 = 0
            if (r8 == 0) goto L_0x00b5
            com.apptimize.bt$f r7 = (com.apptimize.bt.f) r7
            java.lang.String r7 = r7.j()
            boolean r7 = r4.contains(r7)
            if (r7 != 0) goto L_0x00d9
            goto L_0x0097
        L_0x00b5:
            boolean r8 = r7 instanceof com.apptimize.bt.k
            if (r8 == 0) goto L_0x0097
            com.apptimize.bt$k r7 = (com.apptimize.bt.k) r7     // Catch:{ Exception -> 0x00d1 }
            com.apptimize.dc r7 = r7.g()     // Catch:{ Exception -> 0x00d1 }
            org.json.JSONObject r7 = r7.a()     // Catch:{ Exception -> 0x00d1 }
            boolean r8 = r7 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00d1 }
            if (r8 != 0) goto L_0x00cc
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00d2
        L_0x00cc:
            java.lang.String r7 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r7)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00d2
        L_0x00d1:
            r7 = r9
        L_0x00d2:
            boolean r7 = r5.contains(r7)
            if (r7 != 0) goto L_0x00d9
            goto L_0x0097
        L_0x00d9:
            java.lang.String r6 = r3.j()
            com.apptimize.ApptimizeInstantUpdateOrWinnerInfo r7 = new com.apptimize.ApptimizeInstantUpdateOrWinnerInfo
            java.lang.Boolean r8 = r3.h()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00ec
            com.apptimize.ApptimizeInstantUpdateOrWinnerInfo$Type r8 = com.apptimize.ApptimizeInstantUpdateOrWinnerInfo.Type.INSTANT_UPDATE
            goto L_0x00ee
        L_0x00ec:
            com.apptimize.ApptimizeInstantUpdateOrWinnerInfo$Type r8 = com.apptimize.ApptimizeInstantUpdateOrWinnerInfo.Type.WINNER
        L_0x00ee:
            r11 = r8
            java.lang.Boolean r8 = r3.h()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00ff
            java.lang.Long r8 = r3.l()
            r12 = r8
            goto L_0x0100
        L_0x00ff:
            r12 = r9
        L_0x0100:
            java.lang.Boolean r8 = r3.h()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0110
            java.lang.String r8 = r3.j()
            r13 = r8
            goto L_0x0111
        L_0x0110:
            r13 = r9
        L_0x0111:
            java.lang.Boolean r8 = r3.i()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0121
            java.lang.Long r8 = r3.k()
            r14 = r8
            goto L_0x0122
        L_0x0121:
            r14 = r9
        L_0x0122:
            java.lang.Boolean r8 = r3.i()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0130
            java.lang.String r9 = r3.j()
        L_0x0130:
            r15 = r9
            java.lang.Long r16 = r3.a()
            java.lang.String r17 = r3.n()
            java.lang.String r18 = r20.v()
            java.lang.String r19 = r20.w()
            r10 = r7
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1.put(r6, r7)
            goto L_0x0080
        L_0x014a:
            java.lang.String r2 = f42013a
            java.lang.String r3 = "Caching HotfixInfo"
            com.apptimize.bo.d(r2, r3)
            java.util.concurrent.atomic.AtomicReference<java.util.Map<java.lang.String, com.apptimize.ApptimizeInstantUpdateOrWinnerInfo>> r2 = r0.I
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r1)
            java.lang.Object r1 = com.apptimize.fx.a(r2, r1)
            java.util.Map r1 = (java.util.Map) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.t():java.util.Map");
    }

    public synchronized Map<Long, Map<String, Object>> u() {
        HashMap hashMap = new HashMap();
        cc r11 = r();
        if (r11 == null) {
            return Collections.unmodifiableMap(hashMap);
        }
        by f11 = r11.f();
        if (!(f11 instanceof cb)) {
            return Collections.unmodifiableMap(hashMap);
        }
        cb cbVar = (cb) f11;
        for (cm next : cbVar.k()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, Long.valueOf(next.j()));
            hashMap2.put("variantName", next.m());
            hashMap2.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, next.g());
            hashMap2.put("experimentName", next.f());
            hashMap.put(Long.valueOf(next.j()), Collections.unmodifiableMap(hashMap2));
        }
        for (bx next2 : cbVar.i()) {
            HashMap hashMap3 = new HashMap();
            if (next2.m().booleanValue()) {
                hashMap3.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, next2.a());
                hashMap3.put("variantName", next2.n());
                hashMap3.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, next2.k());
                hashMap3.put("experimentName", next2.j());
                hashMap.put(next2.a(), Collections.unmodifiableMap(hashMap3));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public synchronized String v() {
        return this.f42029o;
    }

    public String w() {
        return this.f42028n;
    }

    public be x() {
        return this.f42030p;
    }

    public ed y() {
        return this.f42018d.a(this.f42017c.e(), true);
    }

    public Map<String, Object> z() {
        return Collections.unmodifiableMap(this.f42022h.f());
    }

    private void b(boolean z11) {
        ed a11 = this.f42018d.a(false, true);
        cc b11 = this.f42017c.b(false);
        if (b11 == null && a11 != null) {
            b11 = a11.c();
            this.f42017c.a(b11, false);
        }
        if (b11 != null) {
            if (a11 != null) {
                cb k11 = a11.k();
                by f11 = b11.f();
                if (!(a11.m() || z11 || k11 == null || f11 == null || k11.f() < f11.f() || this.f42021g.f() == null || this.M == null)) {
                    bo.k(f42013a, "initiateMetadataReprocessIfNeeded simulating processMetaData");
                    Integer valueOf = Integer.valueOf(this.N.incrementAndGet());
                    Map<Integer, Integer> unmodifiableMap = Collections.unmodifiableMap(this.O);
                    if (!this.P.containsKey(valueOf)) {
                        this.P.put(valueOf, EnumSet.of(a.CheckToSlowSchedulePost));
                    }
                    a(valueOf, true);
                    this.M.a(valueOf.intValue(), this.f42021g.f(), a11, unmodifiableMap);
                    return;
                }
            }
            bo.k(f42013a, "initiateMetadataReprocessIfNeeded reprocessMetaData");
            this.Z.set(false);
            a(a.None);
        }
    }

    private void c(boolean z11) {
        String str = f42013a;
        bo.k(str, "scheduleNotifyExperimentsProcessed " + this.f42031q.d().h() + " unconditionally:" + z11);
        ap apVar = this.B;
        if (apVar != null) {
            apVar.b("scheduleNotifyExperimentsProcessed", Boolean.valueOf(z11));
        }
        if (this.f42038x.isEmpty()) {
            return;
        }
        if (z11 || !(y() == null || y().k() == null)) {
            this.f42031q.c().c((fi) new fi() {
                public void run() {
                    dt.this.M();
                }
            });
        }
    }

    private void d(final boolean z11) {
        c.a((fi) new fi() {
            public void run() {
                bs.b("notifyOnApptimizeForegrounded");
                for (Apptimize.MetadataStateChangedListener onApptimizeForegrounded : dt.this.f42039y) {
                    onApptimizeForegrounded.onApptimizeForegrounded(z11);
                }
            }
        });
    }

    public void e() {
        this.f42017c.a(true);
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [com.apptimize.by] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void f() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = f42013a     // Catch:{ all -> 0x006f }
            java.lang.String r1 = "stopUsingWysiwygMetaData"
            com.apptimize.bo.k(r0, r1)     // Catch:{ all -> 0x006f }
            com.apptimize.dv r0 = r11.f42017c     // Catch:{ all -> 0x006f }
            r1 = 0
            r0.a((boolean) r1)     // Catch:{ all -> 0x006f }
            com.apptimize.au r0 = r11.f42031q     // Catch:{ all -> 0x006f }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x006f }
            boolean r0 = r0.c()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0025
            com.apptimize.ag r0 = r11.f42032r     // Catch:{ all -> 0x006f }
            java.lang.String r2 = "stopUsingWysiwygMetadata"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006f }
            r0.b(r2, r1)     // Catch:{ all -> 0x006f }
            monitor-exit(r11)
            return
        L_0x0025:
            com.apptimize.ap r0 = r11.B     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0030
            java.lang.String r2 = "stopUsingWysiwygFromMain"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x006f }
            r0.b(r2, r3)     // Catch:{ all -> 0x006f }
        L_0x0030:
            com.apptimize.dv r0 = r11.f42017c     // Catch:{ all -> 0x006f }
            com.apptimize.cc r0 = r0.b((boolean) r1)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x003d
            com.apptimize.by r1 = r0.f()     // Catch:{ all -> 0x006f }
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            boolean r2 = r1 instanceof com.apptimize.cb     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x005f
            com.apptimize.dt$a r4 = com.apptimize.dt.a.None     // Catch:{ all -> 0x006f }
            com.apptimize.du$j r5 = com.apptimize.du.j.StopUsingWysiwygMetaData     // Catch:{ all -> 0x006f }
            r6 = r1
            com.apptimize.cb r6 = (com.apptimize.cb) r6     // Catch:{ all -> 0x006f }
            java.lang.Boolean r1 = r0.j()     // Catch:{ all -> 0x006f }
            boolean r7 = r1.booleanValue()     // Catch:{ all -> 0x006f }
            java.lang.String r8 = r0.c()     // Catch:{ all -> 0x006f }
            java.lang.String r9 = r0.d()     // Catch:{ all -> 0x006f }
            r10 = 1
            r3 = r11
            r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x006f }
            goto L_0x006d
        L_0x005f:
            com.apptimize.dt$a r2 = com.apptimize.dt.a.None     // Catch:{ all -> 0x006f }
            com.apptimize.du$j r3 = com.apptimize.du.j.StopUsingWysiwygMetaData     // Catch:{ all -> 0x006f }
            r4 = 0
            r5 = 0
            java.lang.String r6 = ""
            r7 = 0
            r8 = 1
            r1 = r11
            r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006f }
        L_0x006d:
            monitor-exit(r11)
            return
        L_0x006f:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.f():void");
    }

    public void g() {
        this.f42017c.a(false);
    }

    public synchronized void h() {
        bo.f(f42013a, "downloadStateChanged");
        c(i());
        ap apVar = this.B;
        if (apVar != null) {
            apVar.b("downloadStateChanged", new Object[0]);
        }
    }

    public synchronized EnumSet<Apptimize.ApptimizeMetadataStateFlags> i() {
        EnumSet<Apptimize.ApptimizeMetadataStateFlags> noneOf;
        EnumSet enumSet = this.X.get();
        noneOf = EnumSet.noneOf(Apptimize.ApptimizeMetadataStateFlags.class);
        if (y() != null) {
            noneOf.add(Apptimize.ApptimizeMetadataStateFlags.AVAILABLE);
        }
        if (enumSet.contains(bz.b.IsDownloading) || enumSet.contains(bz.b.PrefetchInProgress) || enumSet.contains(bz.b.WillDownload) || I()) {
            noneOf.add(Apptimize.ApptimizeMetadataStateFlags.REFRESHING);
        }
        if (!enumSet.contains(bz.b.MetadataIsStale) && !I() && y() != null) {
            noneOf.add(Apptimize.ApptimizeMetadataStateFlags.UP_TO_DATE);
        }
        return noneOf;
    }

    public bz.e j() {
        return new bz.e() {
            public void a(EnumSet<bz.b> enumSet) {
                if ((!i.b.a(dt.this.X, enumSet, enumSet)) && dt.this.B != null) {
                    dt.this.B.b("setDownloaderMetadataStateFlagsFromMain", dt.this.X.get());
                }
            }

            public void a(boolean z11) {
                dt.this.a(z11);
            }
        };
    }

    public bz.c k() {
        return new bz.c() {
            public void a(cb cbVar, String str, String str2) {
                dt.this.a(cbVar, str, str2);
            }

            public void b() {
                dt.this.G();
            }

            public void a() {
                dt.this.n();
            }
        };
    }

    public synchronized void l() {
        if (!this.f42033s.get()) {
            this.A.clear();
            a(a.None);
            this.f42032r.b("clearAllForcedVariantsFromClient", Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
            m();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f42033s     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043
            com.apptimize.au r0 = r3.f42031q     // Catch:{ all -> 0x0045 }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.c()     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0016
            goto L_0x0043
        L_0x0016:
            com.apptimize.dv r0 = r3.f42017c     // Catch:{ all -> 0x0045 }
            r1 = 0
            com.apptimize.cc r0 = r0.b((boolean) r1)     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0028
            java.lang.String r0 = f42013a     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "MetaMetaData should not be null."
            com.apptimize.bo.b(r0, r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            return
        L_0x0028:
            java.util.Set<java.lang.Long> r2 = r3.A     // Catch:{ all -> 0x0045 }
            com.apptimize.cc r0 = r0.a((java.util.Set<java.lang.Long>) r2)     // Catch:{ all -> 0x0045 }
            com.apptimize.dv r2 = r3.f42017c     // Catch:{ all -> 0x0045 }
            r2.a(r0, r1)     // Catch:{ all -> 0x0045 }
            com.apptimize.et r2 = r3.f42018d     // Catch:{ all -> 0x0045 }
            r2.a((com.apptimize.cc) r0, (boolean) r1)     // Catch:{ all -> 0x0045 }
            com.apptimize.au r1 = r3.f42031q     // Catch:{ all -> 0x0045 }
            com.apptimize.bz r1 = r1.f()     // Catch:{ all -> 0x0045 }
            r1.a((com.apptimize.cc) r0)     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            return
        L_0x0043:
            monitor-exit(r3)
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.m():void");
    }

    public synchronized void n() {
        ed a11;
        if (!this.f42033s.get()) {
            cc b11 = this.f42017c.b(false);
            if (b11 == null && (a11 = this.f42018d.a(false, true)) != null) {
                b11 = a11.c();
            }
            if (b11 == null) {
                bo.b(f42013a, "MetaMetaData should not be null.");
                return;
            }
            cc a12 = b11.a(this.f42016b.b(), this.f42016b.c());
            this.f42017c.a(a12, false);
            this.f42018d.a(a12, false);
            this.f42031q.f().a(a12);
        }
    }

    public void o() {
        if (!this.f42033s.get() && this.f42015ab.compareAndSet(false, true)) {
            try {
                cc r11 = r();
                if (r11 == null) {
                    bo.c(f42013a, "MetaMetaData null, so unable to post...");
                } else {
                    List<JSONObject> g11 = this.f42020f.g();
                    c(g11);
                    List<String> g12 = r11.f() != null ? r11.f().g() : null;
                    if (g12 != null) {
                        if (g12.size() != 0) {
                            HttpURLConnection a11 = this.f42019e.a(g12, g11);
                            if (a11 != null) {
                                this.f42021g.h();
                                this.f42020f.a(g11, a11);
                            }
                            this.f42015ab.set(false);
                            return;
                        }
                    }
                    bo.c(f42013a, "MetaDataV4 has not been loaded yet...shouldn't be possible...?");
                }
            } finally {
                this.f42015ab.set(false);
            }
        }
    }

    public synchronized void p() {
        if (this.f42033s.compareAndSet(false, true)) {
            this.f42020f.a();
            this.f42021g.e();
            this.f42019e.a();
        }
    }

    public List<dc> q() {
        if (this.f42033s.get()) {
            return new ArrayList();
        }
        ed y11 = y();
        return y11 == null ? new ArrayList() : y11.a();
    }

    public cc r() {
        ed y11 = y();
        if (y11 != null) {
            return y11.c();
        }
        return this.f42017c.h();
    }

    public Map<String, ApptimizeTestInfo> s() {
        synchronized (this) {
            Map<String, ApptimizeTestInfo> map = this.H.get();
            if (map != null) {
                bo.d(f42013a, "Returning cached TestInfo");
                return map;
            }
            bo.k(f42013a, "Building new TestInfo cache");
            HashMap hashMap = new HashMap();
            cc r11 = r();
            if (r11 == null) {
                Map<String, ApptimizeTestInfo> unmodifiableMap = Collections.unmodifiableMap(hashMap);
                return unmodifiableMap;
            }
            by f11 = r11.f();
            if (!(f11 instanceof cb)) {
                Map<String, ApptimizeTestInfo> unmodifiableMap2 = Collections.unmodifiableMap(hashMap);
                return unmodifiableMap2;
            }
            cb cbVar = (cb) f11;
            for (Long next : P()) {
                cm a11 = cbVar.a(next.longValue());
                if (a11 == null) {
                    String str = f42013a;
                    bo.g(str, "Didn't find active variant ID " + next + " in meta data");
                } else {
                    hashMap.put(a11.f(), c(a11));
                    String str2 = f42013a;
                    bo.k(str2, "Adding active variant ID " + next + " to testInfo");
                }
            }
            bo.d(f42013a, "Caching TestInfo");
            Map<String, ApptimizeTestInfo> map2 = (Map) fx.a(this.H, Collections.unmodifiableMap(hashMap));
            return map2;
        }
    }

    private cm d(long j11) {
        cc r11 = r();
        if (r11 == null) {
            return null;
        }
        by f11 = r11.f();
        if (!(f11 instanceof cb)) {
            return null;
        }
        return ((cb) f11).a(j11);
    }

    private ek e(long j11) {
        cm d11 = d(j11);
        if (d11 == null) {
            return new ek(j11, -1, -1);
        }
        return new ek(d11.j(), (long) d11.k(), (long) d11.l());
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final cb f42101a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f42102b;

        /* renamed from: c  reason: collision with root package name */
        final String f42103c;

        /* renamed from: d  reason: collision with root package name */
        final String f42104d;

        public c() {
            this.f42101a = null;
            this.f42102b = false;
            this.f42103c = "";
            this.f42104d = null;
        }

        public c(cb cbVar, boolean z11, String str, String str2) {
            this.f42101a = cbVar;
            this.f42102b = z11;
            this.f42103c = str;
            this.f42104d = str2;
        }
    }

    public synchronized void e(String str) {
        if (!this.f42033s.get()) {
            HashMap hashMap = new HashMap();
            dp.k kVar = dp.k.Apptimize;
            b(str, kVar, (Map<String, Object>) hashMap);
            this.f42021g.a(str, 1.0d);
            this.f42020f.a(str, kVar, (Map<String, Object>) hashMap);
            J();
        }
    }

    /* access modifiers changed from: private */
    public boolean a(ed edVar) {
        if (edVar == null || edVar.k() == null) {
            return false;
        }
        ed a11 = this.f42018d.a(edVar.m(), true);
        if (a11 == null || a11.k() == null) {
            return true;
        }
        if (a11.k().f() < edVar.k().f()) {
            return true;
        }
        return false;
    }

    public void d(String str) {
        if (!this.f42033s.get()) {
            this.f42021g.a(str, 1.0d);
            HashMap hashMap = new HashMap();
            dr drVar = this.f42020f;
            dp.k kVar = dp.k.Apptimize;
            drVar.a(str, kVar, (Map<String, Object>) hashMap);
            b(str, kVar, (Map<String, Object>) hashMap);
            J();
        }
    }

    private void c(final EnumSet<Apptimize.ApptimizeMetadataStateFlags> enumSet) {
        if (!this.K.getAndSet(enumSet).equals(enumSet)) {
            c.a((fi) new fi() {
                public void run() {
                    bs.b("notifyMetadataStateChanged");
                    for (Apptimize.MetadataStateChangedListener onMetadataStateChanged : dt.this.f42039y) {
                        onMetadataStateChanged.onMetadataStateChanged(enumSet);
                    }
                }
            });
        }
    }

    private void c(long j11) {
        for (b a11 : this.f42040z) {
            a11.a(j11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b8, code lost:
        if (com.apptimize.fx.a((java.lang.Object) r5, (java.lang.Object) r12.h()) == false) goto L_0x00ba;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(int r10, com.apptimize.ee r11, com.apptimize.ed r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.ThreadLocal<java.lang.Boolean> r0 = Y     // Catch:{ all -> 0x00ec }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00ec }
            r0.set(r1)     // Catch:{ all -> 0x00ec }
            java.lang.String r1 = f42013a     // Catch:{ all -> 0x00ec }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r2.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "metaDataProcessed "
            r2.append(r3)     // Catch:{ all -> 0x00ec }
            r2.append(r10)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = " v3:"
            r2.append(r3)     // Catch:{ all -> 0x00ec }
            r3 = 1
            r4 = 0
            if (r11 == 0) goto L_0x0022
            r5 = r3
            goto L_0x0023
        L_0x0022:
            r5 = r4
        L_0x0023:
            r2.append(r5)     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = " md:"
            r2.append(r5)     // Catch:{ all -> 0x00ec }
            if (r12 == 0) goto L_0x002f
            r5 = r3
            goto L_0x0030
        L_0x002f:
            r5 = r4
        L_0x0030:
            r2.append(r5)     // Catch:{ all -> 0x00ec }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00ec }
            com.apptimize.bo.f(r1, r2)     // Catch:{ all -> 0x00ec }
            if (r12 == 0) goto L_0x0041
            boolean r2 = r12.m()     // Catch:{ all -> 0x00ec }
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            r5 = 0
            if (r12 == 0) goto L_0x0060
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r6.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r7 = "metadataChanged "
            r6.append(r7)     // Catch:{ all -> 0x00ec }
            r6.append(r10)     // Catch:{ all -> 0x00ec }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ec }
            com.apptimize.bo.f(r1, r6)     // Catch:{ all -> 0x00ec }
            com.apptimize.et r6 = r9.f42018d     // Catch:{ all -> 0x00ec }
            com.apptimize.ed r6 = r6.a((com.apptimize.ed) r12, (boolean) r2)     // Catch:{ all -> 0x00ec }
            goto L_0x0061
        L_0x0060:
            r6 = r5
        L_0x0061:
            if (r6 == 0) goto L_0x0078
            com.apptimize.cc r7 = r6.c()     // Catch:{ all -> 0x00ec }
            if (r7 == 0) goto L_0x0078
            if (r2 != 0) goto L_0x0078
            com.apptimize.au r7 = r9.f42031q     // Catch:{ all -> 0x00ec }
            com.apptimize.bz r7 = r7.f()     // Catch:{ all -> 0x00ec }
            com.apptimize.cc r8 = r6.c()     // Catch:{ all -> 0x00ec }
            r7.a((com.apptimize.cc) r8)     // Catch:{ all -> 0x00ec }
        L_0x0078:
            r9.h()     // Catch:{ all -> 0x00ec }
            if (r11 == 0) goto L_0x0094
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r7.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r8 = "metadataProcessed "
            r7.append(r8)     // Catch:{ all -> 0x00ec }
            r7.append(r10)     // Catch:{ all -> 0x00ec }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ec }
            com.apptimize.bo.f(r1, r7)     // Catch:{ all -> 0x00ec }
            r9.a((com.apptimize.ee) r11, (boolean) r2)     // Catch:{ all -> 0x00ec }
        L_0x0094:
            if (r12 == 0) goto L_0x00bd
            com.apptimize.a r1 = r9.D     // Catch:{ all -> 0x00ec }
            r1.b()     // Catch:{ all -> 0x00ec }
            com.apptimize.cc r1 = r12.c()     // Catch:{ all -> 0x00ec }
            java.lang.Boolean r1 = r1.j()     // Catch:{ all -> 0x00ec }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ec }
            if (r1 != 0) goto L_0x00ba
            if (r6 != 0) goto L_0x00ac
            goto L_0x00b0
        L_0x00ac:
            java.lang.String r5 = r6.h()     // Catch:{ all -> 0x00ec }
        L_0x00b0:
            java.lang.String r1 = r12.h()     // Catch:{ all -> 0x00ec }
            boolean r1 = com.apptimize.fx.a((java.lang.Object) r5, (java.lang.Object) r1)     // Catch:{ all -> 0x00ec }
            if (r1 != 0) goto L_0x00bd
        L_0x00ba:
            r9.a((com.apptimize.ed) r6, (com.apptimize.ed) r12)     // Catch:{ all -> 0x00ec }
        L_0x00bd:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00ec }
            if (r11 != 0) goto L_0x00c7
            if (r12 == 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            r3 = r4
        L_0x00c7:
            r9.a((java.lang.Integer) r1, (boolean) r3)     // Catch:{ all -> 0x00ec }
            java.util.concurrent.atomic.AtomicInteger r11 = r9.Q     // Catch:{ all -> 0x00ec }
            r11.set(r10)     // Catch:{ all -> 0x00ec }
            r9.K()     // Catch:{ all -> 0x00ec }
            r9.Q()     // Catch:{ all -> 0x00ec }
            java.util.EnumSet r10 = r9.i()     // Catch:{ all -> 0x00ec }
            r9.c((java.util.EnumSet<com.apptimize.Apptimize.ApptimizeMetadataStateFlags>) r10)     // Catch:{ all -> 0x00ec }
            boolean r10 = r9.I()     // Catch:{ all -> 0x00ec }
            if (r10 != 0) goto L_0x00e5
            r9.c((boolean) r4)     // Catch:{ all -> 0x00ec }
        L_0x00e5:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00ec }
            r0.set(r10)     // Catch:{ all -> 0x00ec }
            monitor-exit(r9)
            return
        L_0x00ec:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(int, com.apptimize.ee, com.apptimize.ed):void");
    }

    private List<ep> e(List<String> list) {
        ArrayList arrayList = new ArrayList();
        List<ep> list2 = this.E;
        if (!(list2 == null || list == null)) {
            for (ep next : list2) {
                if (next.a()) {
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().contentEquals(next.b())) {
                                arrayList.add(next);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void c(String str) {
        Long l11;
        cm d11;
        if (!this.f42033s.get()) {
            Q();
            ed y11 = y();
            if (y11 != null && (l11 = y11.g().get(str)) != null && (d11 = d(l11.longValue())) != null && y11.d().containsKey(str)) {
                boolean a11 = this.f42025k.a(l11.longValue(), (long) d11.l());
                if (this.f42014aa.add(l11)) {
                    if (bs.f41454a != null) {
                        bs.b("variantsShown  " + l11 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + d11.f() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + d11.m());
                    }
                    this.f42021g.a(l11.longValue());
                    this.f42020f.a(e(l11.longValue()));
                    a(l11, a11);
                    f(l11.longValue());
                    J();
                }
            }
        }
    }

    public synchronized void d(List<dl.b> list) {
        if (!this.f42033s.get()) {
            for (dl.b a11 : list) {
                this.f42022h.a(a11);
            }
            a(a.RemoveCustomAttributes);
            N();
            this.f42032r.b("removeCustomAttributesFromClient", list, Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
        }
    }

    private void f(long j11) {
        cm d11 = d(j11);
        if (d11 != null && d11.l() != -1) {
            String str = "v" + j11 + JavaConstant.Dynamic.DEFAULT_NAME + d11.k();
            String str2 = "e" + d11.g() + JavaConstant.Dynamic.DEFAULT_NAME + d11.k();
            dm dmVar = this.f42022h;
            dl.b bVar = dl.b.InternalAttribute;
            if (dmVar.a(bVar, str) == null || this.f42022h.a(bVar, str2) == null) {
                bo.i(f42013a, "Setting stickiness attributes " + str + " and " + str2 + " to " + String.valueOf(d11.l()));
                a(bVar, str, (Object) new Integer(d11.l()));
                a(bVar, str2, (Object) new Integer(d11.l()));
                return;
            }
            bo.i(f42013a, "Stickiness attributes already set");
        }
    }

    public void b(EnumSet<bz.b> enumSet) {
        bo.k(f42013a, "setDownloaderMetadataStateFlagsFromMain");
        this.X.set(enumSet);
    }

    /* access modifiers changed from: private */
    public void b(final cm cmVar) {
        final Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener = this.f42036v.get();
        this.f42031q.c().c((fi) new fi() {
            public void run() {
                dt.this.a(onTestEnrollmentChangedListener, cmVar);
            }
        });
    }

    private synchronized bb b(cb cbVar) {
        return new bb(this.f42030p, z(), A(), B(), C(), cbVar != null ? cbVar.m() : this.G.f(), cbVar != null ? cbVar.f() : 0);
    }

    public synchronized void f(String str) {
        if (!fx.a((Object) this.f42029o, (Object) str)) {
            this.f42029o = str;
            this.f42020f.a(str);
            if (this.f42031q.d().c()) {
                d((List<dl.b>) Arrays.asList(new dl.b[]{dl.b.UserAttribute, dl.b.AmplitudeProperty, dl.b.MixpanelSuperProperty, dl.b.FlurryProperty, dl.b.OmnitureProperty}));
            }
            this.F.a(str, w());
            this.f42032r.b("setUserIdFromClient", str, Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
        }
    }

    private static String c(String str, dp.k kVar, Map<String, Object> map) {
        if (kVar != dp.k.GoogleAnalyticsV3 && kVar != dp.k.GoogleAnalyticsV4) {
            return str;
        }
        String str2 = "";
        if (map.containsKey("&cd")) {
            str2 = str2 + map.get("&cd");
        }
        if ("timing".equals(map.get("&t"))) {
            if (map.containsKey("&utc")) {
                if (str2.length() > 0) {
                    str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
                }
                str2 = str2 + map.get("&utc");
            }
        } else if ("event".equals(map.get("&t")) && map.containsKey("&ea")) {
            if (str2.length() > 0) {
                str2 = str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
            }
            str2 = str2 + map.get("&ea");
        }
        if (!map.containsKey("&t")) {
            return str2;
        }
        if (str2.length() > 0) {
            return str2 + " (" + map.get("&t") + ")";
        }
        return str2 + map.get("&t");
    }

    public synchronized void b(Long l11) {
        if (!this.f42033s.get()) {
            this.A.remove(l11);
            a(a.None);
            this.f42032r.b("clearForceVarientFromClient", l11, Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
            m();
            O();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.Integer, java.lang.Integer> r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = f42013a     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = "metadataProcessedFromMain"
            com.apptimize.bo.k(r0, r1)     // Catch:{ all -> 0x00b8 }
            java.util.concurrent.atomic.AtomicBoolean r1 = r3.S     // Catch:{ all -> 0x00b8 }
            r2 = 1
            r1.set(r2)     // Catch:{ all -> 0x00b8 }
            com.apptimize.au r1 = r3.f42031q     // Catch:{ all -> 0x00b8 }
            com.apptimize.ak r1 = r1.d()     // Catch:{ all -> 0x00b8 }
            int r1 = r1.h()     // Catch:{ all -> 0x00b8 }
            if (r6 == 0) goto L_0x0034
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.Object r2 = r6.get(r2)     // Catch:{ all -> 0x00b8 }
            if (r2 != 0) goto L_0x0025
            goto L_0x0034
        L_0x0025:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x00b8 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x00b8 }
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "metadataProcessedFromMain requestId:"
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            r1.append(r6)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = " processMetaDataId:"
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.util.concurrent.atomic.AtomicInteger r2 = r3.N     // Catch:{ all -> 0x00b8 }
            int r2 = r2.get()     // Catch:{ all -> 0x00b8 }
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b8 }
            com.apptimize.bo.k(r0, r1)     // Catch:{ all -> 0x00b8 }
            r1 = 0
            if (r4 == 0) goto L_0x0061
            com.apptimize.au r2 = r3.f42031q     // Catch:{ all -> 0x00b8 }
            com.apptimize.ee r4 = com.apptimize.ee.a((java.lang.String) r4, (com.apptimize.au) r2)     // Catch:{ all -> 0x00b8 }
            goto L_0x0062
        L_0x0061:
            r4 = r1
        L_0x0062:
            if (r5 == 0) goto L_0x0089
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "MD string length "
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            int r2 = r5.length()     // Catch:{ all -> 0x00b8 }
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b8 }
            com.apptimize.bo.k(r0, r1)     // Catch:{ all -> 0x00b8 }
            com.apptimize.au r1 = r3.f42031q     // Catch:{ all -> 0x00b8 }
            com.apptimize.ed r1 = com.apptimize.ed.a((java.lang.String) r5, (com.apptimize.au) r1)     // Catch:{ all -> 0x00b8 }
            if (r1 != 0) goto L_0x0089
            java.lang.String r5 = "metadataProcessedFromMain null after deserialization"
            com.apptimize.bo.k(r0, r5)     // Catch:{ all -> 0x00b8 }
        L_0x0089:
            if (r1 == 0) goto L_0x00b3
            java.lang.String r5 = r3.f42029o     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r1.h()     // Catch:{ all -> 0x00b8 }
            boolean r5 = com.apptimize.fx.a((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x00b8 }
            if (r5 != 0) goto L_0x00ad
            java.lang.String r5 = r1.h()     // Catch:{ all -> 0x00b8 }
            r3.f42029o = r5     // Catch:{ all -> 0x00b8 }
            com.apptimize.dr r0 = r3.f42020f     // Catch:{ all -> 0x00b8 }
            r0.a((java.lang.String) r5)     // Catch:{ all -> 0x00b8 }
            com.apptimize.eo r5 = r3.F     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = r3.f42029o     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = r3.w()     // Catch:{ all -> 0x00b8 }
            r5.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00b8 }
        L_0x00ad:
            java.util.Set r5 = r1.j()     // Catch:{ all -> 0x00b8 }
            r3.A = r5     // Catch:{ all -> 0x00b8 }
        L_0x00b3:
            r3.a((int) r6, (com.apptimize.ee) r4, (com.apptimize.ed) r1)     // Catch:{ all -> 0x00b8 }
            monitor-exit(r3)
            return
        L_0x00b8:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public synchronized void b(Long l11, Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "clearForcedVariantFromClient" + num + " " + num2);
        this.O.put(num, num2);
        b(l11);
        O();
    }

    public void b(List<db> list) {
        if (!this.f42033s.get()) {
            this.f42020f.b(list);
        }
    }

    public synchronized void c(List<JSONObject> list) {
        for (JSONObject optJSONObject : list) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pa");
            if (optJSONObject2 != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    dp.k kVar = dp.f41860a.get(keys.next().substring(0, 1));
                    if (kVar != null && !this.J.contains(kVar)) {
                        keys.remove();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.apptimize.bt.f b(java.lang.String r7) {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f42033s
            boolean r0 = r0.get()
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            com.apptimize.ed r0 = r6.y()     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x008a
            java.util.Map r2 = r0.g()     // Catch:{ all -> 0x008b }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x008b }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x008b }
            java.util.Map r1 = r0.d()     // Catch:{ all -> 0x0087 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0087 }
            com.apptimize.bt$f r1 = (com.apptimize.bt.f) r1     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0030
            if (r2 == 0) goto L_0x002f
            long r2 = r2.longValue()
            r6.c((long) r2)
        L_0x002f:
            return r1
        L_0x0030:
            java.util.Map r0 = r0.e()     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0087 }
            com.apptimize.bt$f r0 = (com.apptimize.bt.f) r0     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x007d
            boolean r1 = r0 instanceof com.apptimize.bt.a     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = " has a modified default."
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = f42013a     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r4.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r5 = "Code block "
            r4.append(r5)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = com.apptimize.bt.a((java.lang.String) r7)     // Catch:{ all -> 0x0087 }
            r4.append(r7)     // Catch:{ all -> 0x0087 }
            r4.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0087 }
            com.apptimize.bo.f(r1, r7)     // Catch:{ all -> 0x0087 }
            goto L_0x007d
        L_0x0060:
            java.lang.String r1 = f42013a     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r4.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r5 = "ApptimizeVar "
            r4.append(r5)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = com.apptimize.bt.a((java.lang.String) r7)     // Catch:{ all -> 0x0087 }
            r4.append(r7)     // Catch:{ all -> 0x0087 }
            r4.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0087 }
            com.apptimize.bo.f(r1, r7)     // Catch:{ all -> 0x0087 }
        L_0x007d:
            if (r2 == 0) goto L_0x0086
            long r1 = r2.longValue()
            r6.c((long) r1)
        L_0x0086:
            return r0
        L_0x0087:
            r7 = move-exception
            r1 = r2
            goto L_0x008c
        L_0x008a:
            return r1
        L_0x008b:
            r7 = move-exception
        L_0x008c:
            if (r1 == 0) goto L_0x0095
            long r0 = r1.longValue()
            r6.c((long) r0)
        L_0x0095:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.b(java.lang.String):com.apptimize.bt$f");
    }

    private void a(ed edVar, ed edVar2) {
        ed.a(edVar, edVar2, new ed.a() {
            public void a(cm cmVar) {
                dt.this.b(cmVar);
            }

            public void a(cm cmVar, Apptimize.UnenrollmentReason unenrollmentReason) {
                dt.this.a(cmVar, unenrollmentReason);
            }
        });
    }

    public void a(cb cbVar, String str, String str2) {
        a(a.ProcessNewPermanentMetaDataComplete, du.j.NewPermanentMetaData, cbVar, true, str, str2, false);
    }

    public synchronized void a(cb cbVar) {
        this.f42017c.a(true);
        if (!this.f42031q.d().c()) {
            try {
                JSONObject a11 = cbVar.a();
                this.f42032r.b("startUsingWysiwygMetadataFromClient", !(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11));
            } catch (JSONException e11) {
                bo.e(f42013a, "conversion error", e11);
            }
        } else {
            ap apVar = this.B;
            if (apVar != null) {
                apVar.b("startUsingWysiwygFromMain", new Object[0]);
            }
            a(a.None, du.j.UseWysiwygMetaData, cbVar, true, "", (String) null, true);
        }
    }

    private synchronized ApptimizeTestInfo c(cm cmVar) {
        ApptimizeTestInfo apptimizeTestInfo;
        synchronized (this) {
            Long valueOf = Long.valueOf(cmVar.j());
            Date date = null;
            Date a11 = cmVar.n() != null ? c.a(cmVar.n()) : null;
            Map<Long, Long> e11 = this.f42025k.e();
            if (e11.containsKey(valueOf)) {
                date = c.a(e11.get(valueOf));
            }
            Date date2 = date;
            Integer num = (Integer) this.f42022h.a(dl.b.InternalAttribute, "v" + valueOf + JavaConstant.Dynamic.DEFAULT_NAME + cmVar.k());
            if (num == null) {
                num = 0;
            }
            apptimizeTestInfo = new ApptimizeTestInfo(cmVar.f(), cmVar.g(), cmVar.h(), cmVar.m(), valueOf.longValue(), a11, date2, this.f42025k.a(valueOf.longValue()), cmVar.k(), cmVar.l(), num.intValue(), v(), w());
        }
        return apptimizeTestInfo;
    }

    private void b(String str, dp.k kVar, Map<String, Object> map) {
        for (b a11 : this.f42040z) {
            a11.a(str, kVar, map);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f42033s     // Catch:{ all -> 0x00b3 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x001f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r0.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r1 = "incrementRunCountForVariant disabled "
            r0.append(r1)     // Catch:{ all -> 0x00b3 }
            r0.append(r5)     // Catch:{ all -> 0x00b3 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00b3 }
            com.apptimize.br.a((java.lang.String) r5)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)
            return
        L_0x001f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r0.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r1 = "incrementRunCountForVariant "
            r0.append(r1)     // Catch:{ all -> 0x00b3 }
            r0.append(r5)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b3 }
            com.apptimize.br.a((java.lang.String) r0)     // Catch:{ all -> 0x00b3 }
            r4.Q()     // Catch:{ all -> 0x00b3 }
            java.util.Set<java.lang.Long> r0 = r4.f42014aa     // Catch:{ all -> 0x00b3 }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00b3 }
            boolean r0 = r0.add(r1)     // Catch:{ all -> 0x00b3 }
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = "incrementRunCountForVariant variantsShown.add"
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00b3 }
            com.apptimize.br.a((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x00b3 }
            java.util.Set r0 = r4.P()     // Catch:{ all -> 0x00b3 }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00b3 }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = "incrementRunCountForVariant active contains"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00b3 }
            com.apptimize.br.a((java.lang.String) r0, (java.lang.Object) r5)     // Catch:{ all -> 0x00b3 }
        L_0x0062:
            monitor-exit(r4)
            return
        L_0x0064:
            com.apptimize.ef r0 = r4.f42021g     // Catch:{ all -> 0x00ae }
            r0.a((long) r5)     // Catch:{ all -> 0x00ae }
            java.util.Set r0 = r4.P()     // Catch:{ all -> 0x00ae }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00ae }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = "incrementRunCountForVariant active contains"
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00ae }
            com.apptimize.br.a((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x00ae }
            com.apptimize.dr r0 = r4.f42020f     // Catch:{ all -> 0x00ae }
            com.apptimize.ek r1 = r4.e((long) r5)     // Catch:{ all -> 0x00ae }
            r0.a((com.apptimize.ek) r1)     // Catch:{ all -> 0x00ae }
            com.apptimize.cm r0 = r4.d((long) r5)     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x009b
            com.apptimize.do r1 = r4.f42025k     // Catch:{ all -> 0x00ae }
            int r0 = r0.l()     // Catch:{ all -> 0x00ae }
            long r2 = (long) r0     // Catch:{ all -> 0x00ae }
            boolean r0 = r1.a((long) r5, (long) r2)     // Catch:{ all -> 0x00ae }
            goto L_0x009c
        L_0x009b:
            r0 = 0
        L_0x009c:
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00ae }
            r4.a((java.lang.Long) r1, (boolean) r0)     // Catch:{ all -> 0x00ae }
            r4.f((long) r5)     // Catch:{ all -> 0x00ae }
        L_0x00a6:
            r4.J()     // Catch:{ all -> 0x00ae }
            r4.c((long) r5)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)
            return
        L_0x00ae:
            r0 = move-exception
            r4.c((long) r5)     // Catch:{ all -> 0x00b3 }
            throw r0     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.b(long):void");
    }

    public void a(String str) {
        bo.k(f42013a, "startUsingWysiwygMetadataFromClient");
        try {
            a(cb.b(new JSONObject(str), this.f42031q));
        } catch (ca | JSONException e11) {
            bo.e(f42013a, "conversion error", e11);
        }
    }

    public synchronized void a(a aVar, du.j jVar, cb cbVar, boolean z11, String str, String str2, boolean z12) {
        a((EnumSet<a>) EnumSet.of(aVar), jVar, new c(cbVar, z11, str, str2), z12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.util.EnumSet<com.apptimize.dt.a> r20, com.apptimize.du.j r21, com.apptimize.dt.c r22, boolean r23) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            monitor-enter(r19)
            java.util.concurrent.atomic.AtomicBoolean r3 = r1.f42033s     // Catch:{ all -> 0x00a9 }
            boolean r3 = r3.get()     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x00a7
            com.apptimize.au r3 = r1.f42031q     // Catch:{ all -> 0x00a9 }
            com.apptimize.ak r3 = r3.d()     // Catch:{ all -> 0x00a9 }
            boolean r3 = r3.c()     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x001d
            goto L_0x00a7
        L_0x001d:
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dt$c> r3 = r1.T     // Catch:{ all -> 0x00a9 }
            r3.set(r2)     // Catch:{ all -> 0x00a9 }
            com.apptimize.cb r7 = r2.f42101a     // Catch:{ all -> 0x00a9 }
            boolean r8 = r2.f42102b     // Catch:{ all -> 0x00a9 }
            java.lang.String r9 = r2.f42103c     // Catch:{ all -> 0x00a9 }
            java.lang.String r10 = r2.f42104d     // Catch:{ all -> 0x00a9 }
            java.util.concurrent.atomic.AtomicInteger r2 = r1.N     // Catch:{ all -> 0x00a9 }
            int r2 = r2.incrementAndGet()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = f42013a     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r3.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = "processMetaDataId.incrementAndGet:"
            r3.append(r4)     // Catch:{ all -> 0x00a9 }
            r3.append(r6)     // Catch:{ all -> 0x00a9 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a9 }
            com.apptimize.bo.f(r2, r3)     // Catch:{ all -> 0x00a9 }
            r3 = 0
            if (r7 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.Z     // Catch:{ all -> 0x00a9 }
            r2.set(r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x005d
        L_0x0053:
            java.lang.String r4 = "null metaData"
            java.lang.Throwable r5 = new java.lang.Throwable     // Catch:{ all -> 0x00a9 }
            r5.<init>()     // Catch:{ all -> 0x00a9 }
            com.apptimize.bo.h(r2, r4, r5)     // Catch:{ all -> 0x00a9 }
        L_0x005d:
            java.util.EnumSet r2 = r19.i()     // Catch:{ all -> 0x00a9 }
            r1.c((java.util.EnumSet<com.apptimize.Apptimize.ApptimizeMetadataStateFlags>) r2)     // Catch:{ all -> 0x00a9 }
            com.apptimize.dt$a r2 = com.apptimize.dt.a.NotifyExperimentsProcessed     // Catch:{ all -> 0x00a9 }
            r0.add(r2)     // Catch:{ all -> 0x00a9 }
            java.util.Map<java.lang.Integer, java.util.EnumSet<com.apptimize.dt$a>> r2 = r1.P     // Catch:{ all -> 0x00a9 }
            r2.put(r6, r0)     // Catch:{ all -> 0x00a9 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r0 = r1.O     // Catch:{ all -> 0x00a9 }
            java.util.Map r18 = java.util.Collections.unmodifiableMap(r0)     // Catch:{ all -> 0x00a9 }
            com.apptimize.du r4 = r1.L     // Catch:{ all -> 0x00a9 }
            com.apptimize.ef r0 = r1.f42021g     // Catch:{ all -> 0x00a9 }
            com.apptimize.ee r12 = r0.f()     // Catch:{ all -> 0x00a9 }
            java.util.Set r13 = r19.P()     // Catch:{ all -> 0x00a9 }
            java.util.Set<java.lang.Long> r14 = r1.A     // Catch:{ all -> 0x00a9 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.C     // Catch:{ all -> 0x00a9 }
            boolean r15 = r0.get()     // Catch:{ all -> 0x00a9 }
            com.apptimize.bb r16 = r1.b((com.apptimize.cb) r7)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r1.f42029o     // Catch:{ all -> 0x00a9 }
            r5 = r21
            r11 = r23
            r17 = r0
            r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00a9 }
            com.apptimize.du$j r0 = com.apptimize.du.j.UseWysiwygMetaData     // Catch:{ all -> 0x00a9 }
            r2 = r21
            if (r2 != r0) goto L_0x00a2
            java.util.concurrent.atomic.AtomicInteger r0 = r1.V     // Catch:{ all -> 0x00a9 }
            r0.set(r3)     // Catch:{ all -> 0x00a9 }
        L_0x00a2:
            r19.Q()     // Catch:{ all -> 0x00a9 }
            monitor-exit(r19)
            return
        L_0x00a7:
            monitor-exit(r19)
            return
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r19)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(java.util.EnumSet, com.apptimize.du$j, com.apptimize.dt$c, boolean):void");
    }

    public synchronized void b(String str, double d11) {
        if (!this.f42033s.get()) {
            this.f42021g.b(str, d11);
            HashMap hashMap = new HashMap();
            hashMap.put("value", Double.valueOf(d11));
            dr drVar = this.f42020f;
            dp.k kVar = dp.k.Apptimize;
            drVar.a(str, kVar, (Map<String, Object>) hashMap);
            b(str, kVar, (Map<String, Object>) hashMap);
            J();
        }
    }

    public synchronized void b(Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "ensureSyncWithMain " + num + " " + num2);
        this.O.put(num, num2);
        O();
    }

    public void a(a aVar) {
        a((EnumSet<a>) EnumSet.of(aVar));
    }

    public void b(Apptimize.OnExperimentsProcessedListener onExperimentsProcessedListener) {
        this.f42038x.remove(onExperimentsProcessedListener);
    }

    public synchronized void a(EnumSet<a> enumSet) {
        enumSet.add(a.CheckToSlowSchedulePost);
        a(enumSet, du.j.ReprocessMetaData, this.T.get(), false);
    }

    public void b(Apptimize.MetadataStateChangedListener metadataStateChangedListener) {
        this.f42039y.remove(metadataStateChangedListener);
    }

    public Map<String, Object> b(dl.b bVar) {
        return this.f42022h.b(bVar);
    }

    private void a(Integer num, boolean z11) {
        String str;
        ArrayList arrayList = new ArrayList();
        EnumSet<E> noneOf = EnumSet.noneOf(a.class);
        synchronized (this) {
            for (Map.Entry next : this.P.entrySet()) {
                if (((Integer) next.getKey()).intValue() <= num.intValue()) {
                    arrayList.add(next.getKey());
                    noneOf.addAll((Collection) next.getValue());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.P.remove((Integer) it.next());
            }
        }
        a aVar = a.SetCustomAttributes;
        if (noneOf.contains(aVar) || noneOf.contains(a.RemoveCustomAttributes)) {
            if (!noneOf.contains(aVar) || !noneOf.contains(a.RemoveCustomAttributes)) {
                str = noneOf.contains(aVar) ? "setting" : "removing";
            } else {
                str = "setting/removing";
            }
            if (z11) {
                String str2 = f42013a;
                bo.a(str2, "Apptimize saving attributes or new userId: " + str + " Custom Attribute");
                LinkedList linkedList = new LinkedList();
                for (Long longValue : P()) {
                    linkedList.add(e(longValue.longValue()));
                }
                this.f42020f.a(P(), (List<ek>) linkedList);
            } else {
                String str3 = f42013a;
                bo.a(str3, "Apptimize failed to process metadata for attributes or new userId: " + str + " Custom Attribute");
            }
        }
        if (noneOf.contains(a.ProcessNewPermanentMetaDataComplete) && this.f42031q.f() != null) {
            this.f42031q.f().a(z11);
        }
        if (noneOf.contains(a.NotifyExperimentsProcessed)) {
            c(true);
        }
        if (!noneOf.contains(a.CheckToSlowSchedulePost)) {
            return;
        }
        if (this.f42021g.f().d() > this.f42021g.g() || this.f42020f.h()) {
            this.f42019e.c();
        }
    }

    private synchronized void a(ee eeVar, boolean z11) {
        int i11;
        Map map;
        Set<dp.k> q11 = this.G.f().q();
        this.J = q11;
        this.f42020f.a(q11);
        this.f42014aa.clear();
        LinkedList linkedList = new LinkedList();
        for (Long longValue : P()) {
            linkedList.add(e(longValue.longValue()));
        }
        if (z11) {
            i11 = -1;
        } else {
            i11 = (r() == null || r().f() == null) ? -2 : r().f().f();
        }
        this.f42020f.a(i11, P(), (List<ek>) linkedList);
        this.f42025k.a(y());
        this.f42021g.a(eeVar.a(), eeVar.c());
        try {
            map = this.f42030p.a();
        } catch (RuntimeException e11) {
            bo.b(f42013a, "Error getting device properties", e11);
            map = new HashMap();
        }
        if (this.f42022h.a(dl.b.DeviceProperty, false, map)) {
            this.f42020f.a(P(), (List<ek>) linkedList);
            N();
        }
        J();
        L();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.await(r0, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r5) {
        /*
            r4 = this;
            java.lang.ThreadLocal<java.lang.Boolean> r0 = Y
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            long r0 = java.lang.System.nanoTime()
            long r0 = com.apptimize.fx.a((long) r0, (long) r5)
        L_0x0017:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0043
            monitor-enter(r4)
            boolean r2 = r4.I()     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0026
            monitor-exit(r4)     // Catch:{ all -> 0x0040 }
            return
        L_0x0026:
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0040 }
            r3 = 1
            r2.<init>(r3)     // Catch:{ all -> 0x0040 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.concurrent.CountDownLatch> r3 = r4.W     // Catch:{ all -> 0x0040 }
            r3.add(r2)     // Catch:{ all -> 0x0040 }
            monitor-exit(r4)     // Catch:{ all -> 0x0040 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0037 }
            r2.await(r0, r3)     // Catch:{ InterruptedException -> 0x0037 }
        L_0x0037:
            long r0 = java.lang.System.nanoTime()
            long r0 = com.apptimize.fx.a((long) r0, (long) r5)
            goto L_0x0017
        L_0x0040:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0040 }
            throw r5
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(long):void");
    }

    public void a(boolean z11) {
        bo.k(f42013a, "downloadManagerForegrounded");
        d(z11);
        ap apVar = this.B;
        if (apVar != null) {
            apVar.b("downloadManagerForegrounded", Boolean.valueOf(z11));
        }
    }

    /* access modifiers changed from: private */
    public void a(final cm cmVar, final Apptimize.UnenrollmentReason unenrollmentReason) {
        final Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener = this.f42036v.get();
        this.f42031q.c().c((fi) new fi() {
            public void run() {
                dt.this.a(onTestEnrollmentChangedListener, cmVar, unenrollmentReason);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener, cm cmVar, final Apptimize.UnenrollmentReason unenrollmentReason) {
        final ApptimizeTestInfo apptimizeTestInfo = s().get(cmVar);
        if (onTestEnrollmentChangedListener != null && apptimizeTestInfo != null) {
            c.a((fi) new fi() {
                public void run() {
                    bs.b("notifyOnUnenrolledInTest");
                    onTestEnrollmentChangedListener.onUnenrolledInTest(apptimizeTestInfo, unenrollmentReason);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener, cm cmVar) {
        final ApptimizeTestInfo apptimizeTestInfo = s().get(cmVar);
        if (onTestEnrollmentChangedListener != null && apptimizeTestInfo != null) {
            c.a((fi) new fi() {
                public void run() {
                    bs.b("notifyOnEnrolledInTest");
                    onTestEnrollmentChangedListener.onEnrolledInTest(apptimizeTestInfo);
                }
            });
        }
    }

    public synchronized void a(Long l11) {
        if (!this.f42033s.get()) {
            this.A.add(l11);
            a(a.None);
            this.f42032r.b("forceVariantFromClient", l11, Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
            m();
        }
    }

    public synchronized void a(Long l11, Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "forceVariantFromClient " + num + " " + num2);
        this.O.put(num, num2);
        a(l11);
        O();
    }

    public synchronized void a(Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "clearAllForcedVariantsFromClient" + num + " " + num2);
        this.O.put(num, num2);
        l();
        O();
    }

    public void a(d dVar) {
        this.f42037w.add(dVar);
    }

    public void a(b bVar) {
        this.f42040z.add(bVar);
    }

    public void a(z zVar) {
        zVar.a(new z.a() {
            public void a() {
                if (!dt.this.f42033s.get()) {
                    dt.this.f42020f.f();
                    dt.this.f42019e.c();
                    dt.this.R();
                }
            }

            public void b(Activity activity) {
                if (!dt.this.f42033s.get()) {
                    dt.this.f42020f.e();
                }
            }

            public void a(Activity activity) {
                if (!dt.this.f42033s.get()) {
                    final boolean z11 = !dt.this.f42026l || c.a(activity);
                    dt.this.f42031q.c().b((fi) new fi() {
                        public void run() {
                            dt.this.f42020f.e();
                            if (z11) {
                                dt.this.a(a.None);
                            }
                        }
                    });
                }
            }
        });
    }

    public void a(List<db> list) {
        if (!this.f42033s.get()) {
            this.f42020f.a(list);
        }
    }

    private void a(Long l11, boolean z11) {
        final Apptimize.OnExperimentRunListener onExperimentRunListener = this.f42034t.get();
        final Apptimize.OnTestRunListener onTestRunListener = this.f42035u.get();
        final Long l12 = l11;
        final boolean z12 = z11;
        this.f42031q.c().c((fi) new fi() {
            public void run() {
                dt.this.a(onExperimentRunListener, onTestRunListener, l12, z12);
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.apptimize.cm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.apptimize.ApptimizeTestInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.apptimize.cm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.apptimize.ApptimizeTestInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.apptimize.cm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.apptimize.ApptimizeTestInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.apptimize.cm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.apptimize.ApptimizeTestInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.apptimize.cm} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.apptimize.Apptimize.OnExperimentRunListener r7, final com.apptimize.Apptimize.OnTestRunListener r8, java.lang.Long r9, final boolean r10) {
        /*
            r6 = this;
            com.apptimize.ed r0 = r6.y()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Map r1 = r6.s()
            com.apptimize.cc r0 = r0.c()
            com.apptimize.by r0 = r0.f()
            boolean r2 = r0 instanceof com.apptimize.cb
            r3 = 0
            if (r2 == 0) goto L_0x0087
            com.apptimize.cb r0 = (com.apptimize.cb) r0
            long r4 = r9.longValue()
            com.apptimize.cm r2 = r0.a((long) r4)
            if (r2 == 0) goto L_0x0069
            java.lang.String r4 = r2.f()
            java.lang.Object r4 = r1.get(r4)
            if (r4 == 0) goto L_0x0069
            java.lang.String r9 = r2.f()
            java.lang.Object r9 = r1.get(r9)
            com.apptimize.ApptimizeTestInfo r9 = (com.apptimize.ApptimizeTestInfo) r9
            if (r10 == 0) goto L_0x0067
            boolean r1 = r6.f42027m
            if (r1 == 0) goto L_0x0041
            r6.a((com.apptimize.cm) r2)
        L_0x0041:
            com.apptimize.cj r0 = r0.m()
            boolean r0 = r6.a((com.apptimize.cj) r0)
            if (r0 == 0) goto L_0x0067
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r1 = com.apptimize.a.a((com.apptimize.ApptimizeTestInfo) r9, (java.lang.Boolean) r1)
            r0.add(r1)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.String r1 = com.apptimize.a.a((com.apptimize.ApptimizeTestInfo) r9, (java.lang.Boolean) r1)
            r0.add(r1)
            com.apptimize.a r1 = r6.D
            r1.b((java.util.Set<java.lang.String>) r0)
        L_0x0067:
            r3 = r9
            goto L_0x0084
        L_0x0069:
            java.lang.String r0 = f42013a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Was unable to find variant ID "
            r1.append(r4)
            r1.append(r9)
            java.lang.String r9 = " in meta data."
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.apptimize.bo.g(r0, r9)
        L_0x0084:
            r9 = r3
            r3 = r2
            goto L_0x0088
        L_0x0087:
            r9 = r3
        L_0x0088:
            if (r3 == 0) goto L_0x00da
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "runOnExperimentListener first:"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " listener:"
            r0.append(r1)
            if (r7 == 0) goto L_0x00a2
            java.lang.String r1 = "yes"
            goto L_0x00a4
        L_0x00a2:
            java.lang.String r1 = "no"
        L_0x00a4:
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            long r1 = r3.j()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            java.lang.String r2 = r3.f()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = r3.m()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.apptimize.bs.b((java.lang.String) r0)
            if (r7 == 0) goto L_0x00da
            com.apptimize.dt$10 r0 = new com.apptimize.dt$10
            r0.<init>(r7, r3, r10)
            com.apptimize.c.a((com.apptimize.fi) r0)
        L_0x00da:
            if (r9 == 0) goto L_0x00e6
            if (r8 == 0) goto L_0x00e6
            com.apptimize.dt$11 r7 = new com.apptimize.dt$11
            r7.<init>(r8, r9, r10)
            com.apptimize.c.a((com.apptimize.fi) r7)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(com.apptimize.Apptimize$OnExperimentRunListener, com.apptimize.Apptimize$OnTestRunListener, java.lang.Long, boolean):void");
    }

    public boolean a(cj cjVar) {
        if (cjVar == null) {
            cjVar = this.G.f();
        }
        List<String> n11 = cjVar.n();
        if (n11 != null) {
            return n11.contains("airship");
        }
        return false;
    }

    public void a(String str, double d11) {
        if (!this.f42033s.get()) {
            this.f42021g.a(str, d11);
            HashMap hashMap = new HashMap();
            hashMap.put("value", Double.valueOf(d11));
            dr drVar = this.f42020f;
            dp.k kVar = dp.k.Apptimize;
            drVar.a(str, kVar, (Map<String, Object>) hashMap);
            b(str, kVar, (Map<String, Object>) hashMap);
            J();
        }
    }

    public synchronized void a(String str, dp.k kVar, Map<String, Object> map) {
        if (!this.f42033s.get()) {
            if (bs.f41454a != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("logEvent ");
                sb2.append(kVar);
                sb2.append(" \"");
                sb2.append(str == null ? "null" : str);
                sb2.append("\"");
                bs.b(sb2.toString());
            }
            if (str != null) {
                Set<dp.k> set = this.J;
                if (set == null) {
                    this.f42020f.d();
                } else if (!set.contains(kVar)) {
                    return;
                }
                b(str, kVar, map);
                if (!(kVar == dp.k.OmnitureV2 || kVar == dp.k.OmnitureV3)) {
                    ef efVar = this.f42021g;
                    efVar.a(kVar.b() + c(str, kVar, map), 1.0d);
                }
                this.f42020f.a(str, kVar, map);
                J();
                return;
            }
            throw new NullPointerException("Apptimize given null event name");
        }
    }

    public synchronized void a(String str, Map<String, Object> map) {
        if (!this.f42033s.get()) {
            this.f42020f.a(str, map);
            J();
        }
    }

    public void a(boolean z11, Map<String, Object> map) {
        a(dl.b.UserAttribute, z11, map);
    }

    public Object a(dl.b bVar, String str) {
        return this.f42022h.a(bVar, str);
    }

    public void a(dl.b bVar, String str, Object obj) {
        a(bVar, false, (Map<String, Object>) new HashMap<String, Object>(str, obj) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f42050a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f42051b;

            {
                this.f42050a = r2;
                this.f42051b = r3;
                put(r2, r3);
            }
        });
    }

    public synchronized void a(dl.b bVar, boolean z11, Map<String, Object> map) {
        if (!this.f42033s.get()) {
            EnumSet<E> noneOf = EnumSet.noneOf(a.class);
            if (z11) {
                noneOf.add(a.RemoveCustomAttributes);
            }
            if (this.f42022h.a(bVar, z11, map)) {
                if (bVar != dl.b.InternalAttribute) {
                    noneOf.add(a.SetCustomAttributes);
                    a((EnumSet<a>) noneOf);
                }
                N();
            }
            this.f42032r.b("setCustomAttributesFromClient", bVar, Boolean.valueOf(z11), map, Integer.valueOf(this.f42031q.d().h()), Integer.valueOf(H()));
        }
    }

    public synchronized void a(dl.b bVar, boolean z11, Map<String, Object> map, Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "setCustomAttributesFromClient " + num + " " + num2);
        this.O.put(num, num2);
        a(bVar, z11, map);
        O();
    }

    public void a(dl.b bVar) {
        d((List<dl.b>) Arrays.asList(new dl.b[]{bVar}));
    }

    public synchronized void a(List<dl.b> list, Integer num, Integer num2) {
        String str = f42013a;
        bo.k(str, "removeCustomAttributesFromClient " + num + " " + num2);
        this.O.put(num, num2);
        d(list);
        O();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.apptimize.cm r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.apptimize.eg r0 = r7.G     // Catch:{ all -> 0x00d1 }
            com.apptimize.cj r0 = r0.f()     // Catch:{ all -> 0x00d1 }
            java.util.List r0 = r0.n()     // Catch:{ all -> 0x00d1 }
            java.util.List r0 = r7.e((java.util.List<java.lang.String>) r0)     // Catch:{ all -> 0x00d1 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r7)
            return
        L_0x0017:
            java.lang.String r1 = r8.f()     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = r8.m()     // Catch:{ all -> 0x00d1 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d1 }
            if (r3 != 0) goto L_0x00cf
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x002d
            goto L_0x00cf
        L_0x002d:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00d1 }
            r3.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = "Name"
            java.lang.String r5 = r8.f()     // Catch:{ all -> 0x00d1 }
            r3.put(r4, r5)     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = "Variation"
            java.lang.String r8 = r8.m()     // Catch:{ all -> 0x00d1 }
            r3.put(r4, r8)     // Catch:{ all -> 0x00d1 }
            java.lang.String r8 = "Name and Variation"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r4.<init>()     // Catch:{ all -> 0x00d1 }
            r4.append(r1)     // Catch:{ all -> 0x00d1 }
            java.lang.String r1 = "-"
            r4.append(r1)     // Catch:{ all -> 0x00d1 }
            r4.append(r2)     // Catch:{ all -> 0x00d1 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00d1 }
            r3.put(r8, r1)     // Catch:{ all -> 0x00d1 }
            java.util.Map r8 = r7.s()     // Catch:{ all -> 0x00d1 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00d1 }
            r1.<init>()     // Catch:{ all -> 0x00d1 }
            java.util.Set r2 = r8.keySet()     // Catch:{ all -> 0x00d1 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d1 }
        L_0x006e:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00d1 }
            if (r4 == 0) goto L_0x00a6
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00d1 }
            java.lang.Object r4 = r8.get(r4)     // Catch:{ all -> 0x00d1 }
            com.apptimize.ApptimizeTestInfo r4 = (com.apptimize.ApptimizeTestInfo) r4     // Catch:{ all -> 0x00d1 }
            boolean r5 = r4.userHasParticipated()     // Catch:{ all -> 0x00d1 }
            if (r5 == 0) goto L_0x006e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r5.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r6 = r4.getTestName()     // Catch:{ all -> 0x00d1 }
            r5.append(r6)     // Catch:{ all -> 0x00d1 }
            java.lang.String r6 = "-"
            r5.append(r6)     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = r4.getEnrolledVariantName()     // Catch:{ all -> 0x00d1 }
            r5.append(r4)     // Catch:{ all -> 0x00d1 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00d1 }
            r1.add(r4)     // Catch:{ all -> 0x00d1 }
            goto L_0x006e
        L_0x00a6:
            int r8 = r1.size()     // Catch:{ all -> 0x00d1 }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x00d1 }
            java.lang.Object[] r8 = r1.toArray(r8)     // Catch:{ all -> 0x00d1 }
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ all -> 0x00d1 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00d1 }
        L_0x00b6:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00cd
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00d1 }
            com.apptimize.ep r1 = (com.apptimize.ep) r1     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "Apptimize experiment"
            r1.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "Apptimize experiment"
            r1.a((java.lang.String) r2, (java.lang.String[]) r8)     // Catch:{ all -> 0x00d1 }
            goto L_0x00b6
        L_0x00cd:
            monitor-exit(r7)
            return
        L_0x00cf:
            monitor-exit(r7)
            return
        L_0x00d1:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(com.apptimize.cm):void");
    }

    public synchronized void a(String str, Integer num, Integer num2) {
        String str2 = f42013a;
        bo.k(str2, "setUserIdFromClient " + num + " " + num2);
        this.O.put(num, num2);
        f(str);
        O();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.Map<java.lang.Integer, java.lang.Integer> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.apptimize.au r0 = r4.f42031q     // Catch:{ all -> 0x0060 }
            com.apptimize.ak r0 = r0.d()     // Catch:{ all -> 0x0060 }
            int r0 = r0.h()     // Catch:{ all -> 0x0060 }
            r1 = 0
            if (r5 == 0) goto L_0x0028
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0060 }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ all -> 0x0060 }
            if (r2 != 0) goto L_0x0019
            goto L_0x0028
        L_0x0019:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0060 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0060 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0060 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0060 }
            goto L_0x0029
        L_0x0028:
            r5 = r1
        L_0x0029:
            java.lang.String r0 = f42013a     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r2.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "syncMetaDataProcessingFromMain requestId:"
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            r2.append(r5)     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = " processMetaDataId:"
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.atomic.AtomicInteger r3 = r4.N     // Catch:{ all -> 0x0060 }
            int r3 = r3.get()     // Catch:{ all -> 0x0060 }
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0060 }
            com.apptimize.bo.k(r0, r2)     // Catch:{ all -> 0x0060 }
            java.util.concurrent.atomic.AtomicInteger r0 = r4.Q     // Catch:{ all -> 0x0060 }
            r0.set(r5)     // Catch:{ all -> 0x0060 }
            r4.K()     // Catch:{ all -> 0x0060 }
            boolean r5 = r4.I()     // Catch:{ all -> 0x0060 }
            if (r5 != 0) goto L_0x005e
            r4.c((boolean) r1)     // Catch:{ all -> 0x0060 }
        L_0x005e:
            monitor-exit(r4)
            return
        L_0x0060:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dt.a(java.util.Map):void");
    }

    public void a(Apptimize.OnExperimentRunListener onExperimentRunListener) {
        this.f42034t.set(onExperimentRunListener);
    }

    public void a(Apptimize.OnTestRunListener onTestRunListener) {
        this.f42035u.set(onTestRunListener);
    }

    public void a(Apptimize.OnTestEnrollmentChangedListener onTestEnrollmentChangedListener) {
        this.f42036v.set(onTestEnrollmentChangedListener);
    }

    public void a(Apptimize.OnExperimentsProcessedListener onExperimentsProcessedListener) {
        this.f42038x.add(onExperimentsProcessedListener);
    }

    public void a(Apptimize.MetadataStateChangedListener metadataStateChangedListener) {
        this.f42039y.add(metadataStateChangedListener);
    }

    public Map<String, Object> a(dl.a aVar) {
        return this.f42022h.a(aVar);
    }

    public static Map<String, Object> a(dm dmVar, dl.b bVar) {
        return dmVar.b(bVar);
    }

    private ag a(au auVar) {
        Class<String> cls = String.class;
        Class<Long> cls2 = Long.class;
        Class<dt> cls3 = dt.class;
        Class<Integer> cls4 = Integer.class;
        try {
            return new ag.a(this).a("applicationSleep", cls3.getDeclaredMethod("R", new Class[0])).a("forceVariantFromClient", cls3.getDeclaredMethod("a", new Class[]{cls2, cls4, cls4})).a("clearForceVarientFromClient", cls3.getDeclaredMethod("b", new Class[]{cls2, cls4, cls4})).a("clearAllForcedVariantsFromClient", cls3.getDeclaredMethod("a", new Class[]{cls4, cls4})).a("setCustomAttributesFromClient", cls3.getDeclaredMethod("a", new Class[]{dl.b.class, Boolean.TYPE, Map.class, cls4, cls4})).a("setUserIdFromClient", cls3.getDeclaredMethod("a", new Class[]{cls, cls4, cls4})).a("removeCustomAttributesFromClient", cls3.getDeclaredMethod("a", new Class[]{List.class, cls4, cls4})).a("startUsingWysiwygMetadataFromClient", cls3.getDeclaredMethod("a", new Class[]{cls})).a("stopUsingWysiwygMetadata", cls3.getDeclaredMethod("f", new Class[0])).a("ensureSyncWithMain", cls3.getDeclaredMethod("b", new Class[]{cls4, cls4})).a(auVar.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42013a, "Error binding", e11);
            return null;
        }
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return 0L;
            }
        };
    }
}
