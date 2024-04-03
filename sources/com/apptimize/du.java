package com.apptimize;

import com.apptimize.bg;
import com.apptimize.bq;
import com.apptimize.bt;
import com.apptimize.cj;
import com.apptimize.eh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class du {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42105a = "du";

    /* renamed from: b  reason: collision with root package name */
    private final au f42106b;

    /* renamed from: c  reason: collision with root package name */
    private final ea f42107c;

    /* renamed from: d  reason: collision with root package name */
    private final List<bg> f42108d;

    /* renamed from: e  reason: collision with root package name */
    private final eg f42109e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42110f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42111g;

    /* renamed from: h  reason: collision with root package name */
    private final eh.c f42112h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<ed> f42113i = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final List<f> f42114j = new CopyOnWriteArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final AtomicReference<dv> f42115k;

    /* renamed from: l  reason: collision with root package name */
    private final ConcurrentLinkedQueue<h> f42116l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicBoolean f42117m;

    /* renamed from: com.apptimize.du$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42127a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.apptimize.du$j[] r0 = com.apptimize.du.j.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42127a = r0
                com.apptimize.du$j r1 = com.apptimize.du.j.NewPermanentMetaData     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42127a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.du$j r1 = com.apptimize.du.j.UseWysiwygMetaData     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42127a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.apptimize.du$j r1 = com.apptimize.du.j.StopUsingWysiwygMetaData     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42127a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.apptimize.du$j r1 = com.apptimize.du.j.ProcessMetaData     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42127a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.apptimize.du$j r1 = com.apptimize.du.j.ReprocessMetaData     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f42127a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.apptimize.du$j r1 = com.apptimize.du.j.StateChangeOnly     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.AnonymousClass6.<clinit>():void");
        }
    }

    public static class c extends ct<bx, bx> {
        public c() {
            super(bx.class, null);
        }

        public bx a(bx bxVar) {
            return bxVar;
        }
    }

    public static class d extends ct<cm, cm> {
        public d() {
            super(cm.class, null);
        }

        public cm a(cm cmVar) {
            return cmVar;
        }
    }

    public interface f {
        void a(int i11, ee eeVar, ed edVar, Map<Integer, Integer> map);
    }

    public class i {

        /* renamed from: a  reason: collision with root package name */
        public final ee f42160a;

        /* renamed from: b  reason: collision with root package name */
        public final ed f42161b;

        public i(ee eeVar, ed edVar) {
            this.f42160a = eeVar;
            this.f42161b = edVar;
        }
    }

    public enum j {
        NewPermanentMetaData,
        UseWysiwygMetaData,
        StopUsingWysiwygMetaData,
        ProcessMetaData,
        ReprocessMetaData,
        StateChangeOnly
    }

    public static class l extends cy {

        /* renamed from: a  reason: collision with root package name */
        private final String f42171a;

        /* renamed from: b  reason: collision with root package name */
        private final String f42172b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Integer f42173c = null;

        public l(String str, String str2, co coVar) {
            super(coVar);
            this.f42171a = str;
            this.f42172b = str2;
        }

        public boolean a(bx bxVar) {
            return true;
        }

        public boolean a(cn cnVar) {
            return true;
        }

        public boolean a(cl clVar) {
            Integer num = this.f42173c;
            try {
                num = clVar.a(this.f42171a, this.f42172b);
                if (num == null) {
                    bo.f(du.f42105a, "Could not generate a seed; excluding this seed group.");
                    this.f42173c = num;
                    return false;
                }
                super.a(clVar);
                this.f42173c = num;
                return true;
            } finally {
                this.f42173c = num;
            }
        }
    }

    public static class m extends cr {

        /* renamed from: a  reason: collision with root package name */
        private final cj.a f42174a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public a f42175b;

        public m(cj.a aVar) {
            this.f42174a = aVar;
        }

        public boolean a(ch chVar) {
            if (!((Boolean) this.f42175b.a()).booleanValue()) {
                return true;
            }
            this.f42174a.a(chVar.h());
            return true;
        }
    }

    public du(au auVar, dv dvVar, List<bg> list, eg egVar, ea eaVar, String str, String str2, eh.c cVar) {
        AtomicReference<dv> atomicReference = new AtomicReference<>();
        this.f42115k = atomicReference;
        this.f42116l = new ConcurrentLinkedQueue<>();
        this.f42117m = new AtomicBoolean(false);
        atomicReference.set(dvVar);
        this.f42108d = list;
        this.f42109e = egVar;
        this.f42107c = eaVar;
        this.f42110f = str;
        this.f42111g = str2;
        this.f42106b = auVar;
        this.f42112h = cVar;
    }

    private i c(h hVar) {
        dv dvVar = this.f42115k.get();
        cc h11 = dvVar.h();
        if (h11 == null) {
            bo.f(f42105a, "MetaMetaData was null");
            return null;
        }
        by f11 = h11.f();
        if (!(f11 instanceof cb)) {
            bo.f(f42105a, "MetaData had incorrect version");
            return null;
        } else if (!a(bg.a.REPROCESS, f11, hVar.f42154k)) {
            bo.a(f42105a, "Apptimize subprocessors failed reprocessing metadata");
            return null;
        } else {
            bo.a(f42105a, "Apptimize subprocessors finished reprocessing metadata");
            cc h12 = dvVar.h();
            if (h12 == null || h12.f() == null || h11.f().f() > f11.f()) {
                return null;
            }
            return a((cb) f11, hVar.f42150g, h11, hVar.f42152i, hVar.f42153j, hVar.f42154k, hVar.f42155l);
        }
    }

    public static class e extends cr {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public cu f42134a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public c f42135b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, bt.f> f42136c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Long> f42137d;

        /* renamed from: e  reason: collision with root package name */
        private final List<dc> f42138e;

        /* renamed from: f  reason: collision with root package name */
        private final Set<Long> f42139f;

        /* renamed from: g  reason: collision with root package name */
        private final au f42140g;

        public e(Map<String, bt.f> map, Set<Long> set, Map<String, Long> map2, List<dc> list, au auVar) {
            this.f42136c = map;
            this.f42139f = set;
            this.f42137d = map2;
            this.f42138e = list;
            this.f42140g = auVar;
        }

        private boolean b(bx bxVar) {
            if (!bxVar.m().booleanValue()) {
                return false;
            }
            return this.f42139f.contains(bxVar.a());
        }

        public boolean a(bx bxVar) {
            if (!this.f42134a.d() && !this.f42134a.c()) {
                String a11 = du.f42105a;
                bo.i(a11, "Winner or instant update does not match filters: " + bxVar.j());
            }
            if (this.f42134a.b()) {
                return true;
            }
            String a12 = du.f42105a;
            bo.i(a12, "Applying winner or instant update: " + bxVar.j());
            return true;
        }

        public boolean a(bt btVar) {
            if (this.f42135b.a() == null) {
                return true;
            }
            a((bx) this.f42135b.a(), btVar);
            return true;
        }

        private void a(bx bxVar, bt btVar) {
            if (this.f42134a.b() && !b(bxVar)) {
                return;
            }
            if (!this.f42134a.d() && !this.f42134a.c()) {
                String a11 = du.f42105a;
                bo.i(a11, "Alteration of winner or instant update does not match filters: " + bxVar.j());
            } else if (!this.f42139f.isEmpty() && bxVar.i().booleanValue() && !b(bxVar)) {
                String a12 = du.f42105a;
                bo.i(a12, "Alteration of winner or instant update is not in forced variants: " + bxVar.j());
            } else if (btVar instanceof bt.f) {
                bt.f fVar = (bt.f) btVar;
                String j11 = fVar.j();
                if (this.f42136c.containsKey(j11)) {
                    if (fVar instanceof bt.a) {
                        String a13 = du.f42105a;
                        bo.f(a13, "Code block " + bt.a(j11) + " has multiple new default values assigned; using the last one.");
                    } else {
                        String a14 = du.f42105a;
                        bo.f(a14, "ApptimizeVar " + bt.a(j11) + " has multiple new default values assigned; using the last one.");
                    }
                }
                this.f42136c.put(j11, fVar);
                this.f42137d.put(j11, bxVar.a());
            } else if (btVar instanceof bt.k) {
                this.f42138e.add(((bt.k) btVar).g());
            }
        }
    }

    public static class k extends ct<ch, Boolean> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public l f42170a;

        public k() {
            super(ch.class, Boolean.TRUE);
        }

        public Boolean a(ch chVar) {
            boolean booleanValue = ((Boolean) a()).booleanValue();
            for (cg next : chVar.d().c()) {
                if (booleanValue && this.f42170a.f42173c.intValue() >= next.b() && this.f42170a.f42173c.intValue() < next.c()) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public static class n extends cr {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Long, el> f42176a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Long, el> f42177b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Long> f42178c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, bt.f> f42179d;

        /* renamed from: e  reason: collision with root package name */
        private final Map<String, Long> f42180e;

        /* renamed from: f  reason: collision with root package name */
        private final List<dc> f42181f;

        /* renamed from: g  reason: collision with root package name */
        private final au f42182g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public d f42183h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public a f42184i;

        public n(Map<Long, el> map, Map<Long, el> map2, Set<Long> set, Map<String, bt.f> map3, Map<String, Long> map4, List<dc> list, au auVar) {
            this.f42176a = map;
            this.f42177b = map2;
            this.f42178c = set;
            this.f42179d = map3;
            this.f42180e = map4;
            this.f42181f = list;
            this.f42182g = auVar;
        }

        private void b(cm cmVar) {
            el elVar;
            el elVar2 = this.f42176a.get(Long.valueOf(cmVar.j()));
            if (elVar2 != null) {
                elVar = el.a(cmVar, elVar2);
            } else {
                elVar = el.a(cmVar);
            }
            this.f42177b.put(Long.valueOf(cmVar.j()), elVar);
            this.f42178c.add(Long.valueOf(cmVar.j()));
        }

        public boolean a(cm cmVar) {
            if (!((Boolean) this.f42184i.a()).booleanValue()) {
                return true;
            }
            b(cmVar);
            return true;
        }

        private void a(cm cmVar, bt btVar) {
            if (btVar instanceof bt.f) {
                bt.f fVar = (bt.f) btVar;
                String j11 = fVar.j();
                if (this.f42179d.containsKey(j11)) {
                    if (fVar instanceof bt.a) {
                        String a11 = du.f42105a;
                        bo.j(a11, "This device is enrolled in multiple variants of the same code block experiment: " + bt.a(j11));
                    } else {
                        String a12 = du.f42105a;
                        bo.j(a12, "This device is enrolled in multiple experiments that affect the same ApptimizeVar: " + bt.a(j11));
                    }
                    this.f42182g.a().a(bq.b.MultipleValuesForVariable);
                } else if (this.f42180e.containsKey(j11)) {
                    if (fVar instanceof bt.a) {
                        String a13 = du.f42105a;
                        bo.h(a13, "Code block " + bt.a(j11) + " has a modified default, which is further overwritten by an A/B experiment.");
                    } else {
                        String a14 = du.f42105a;
                        bo.h(a14, "ApptimizeVar " + bt.a(j11) + " has a modified default, which is further overwritten by an A/B experiment.");
                    }
                }
                this.f42179d.put(j11, fVar);
                this.f42180e.put(j11, Long.valueOf(cmVar.j()));
            } else if (btVar instanceof bt.k) {
                this.f42181f.add(((bt.k) btVar).g());
            }
        }

        public boolean a(bt btVar) {
            if (this.f42183h.a() != null && ((Boolean) this.f42184i.a()).booleanValue()) {
                a((cm) this.f42183h.a(), btVar);
            }
            return super.a(btVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1 = a(new com.apptimize.du.h(r8), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r8.f42116l.peek() != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (com.apptimize.fx.a(r0.f42158o, java.lang.System.nanoTime()) >= 100000) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r8.f42116l.peek() == null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r0 = r8.f42116l.poll();
        r1 = a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r2 = com.apptimize.fx.a(r0.f42158o, java.lang.System.nanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r2 <= 0) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        r6 = r2 / 1000000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        java.lang.Long.signum(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        java.lang.Thread.sleep(r6, (int) (r2 - (1000000 * r6)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r8 = this;
        L_0x0000:
            monitor-enter(r8)     // Catch:{ RuntimeException -> 0x0072 }
            java.util.concurrent.ConcurrentLinkedQueue<com.apptimize.du$h> r0 = r8.f42116l     // Catch:{ all -> 0x006f }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x006f }
            com.apptimize.du$h r0 = (com.apptimize.du.h) r0     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0013
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.f42117m     // Catch:{ all -> 0x006f }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x006f }
            monitor-exit(r8)     // Catch:{ all -> 0x006f }
            return
        L_0x0013:
            monitor-exit(r8)     // Catch:{ all -> 0x006f }
            com.apptimize.du$h r1 = new com.apptimize.du$h     // Catch:{ RuntimeException -> 0x0072 }
            r1.<init>()     // Catch:{ RuntimeException -> 0x0072 }
            com.apptimize.du$h r1 = r8.a((com.apptimize.du.h) r1, (com.apptimize.du.h) r0)     // Catch:{ RuntimeException -> 0x0072 }
        L_0x001d:
            java.util.concurrent.ConcurrentLinkedQueue<com.apptimize.du$h> r2 = r8.f42116l     // Catch:{ RuntimeException -> 0x0072 }
            java.lang.Object r2 = r2.peek()     // Catch:{ RuntimeException -> 0x0072 }
            if (r2 != 0) goto L_0x003b
            long r2 = r0.f42158o     // Catch:{ RuntimeException -> 0x0072 }
            long r4 = java.lang.System.nanoTime()     // Catch:{ RuntimeException -> 0x0072 }
            long r2 = com.apptimize.fx.a((long) r2, (long) r4)     // Catch:{ RuntimeException -> 0x0072 }
            r4 = 100000(0x186a0, double:4.94066E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            r8.a((com.apptimize.du.h) r1)     // Catch:{ RuntimeException -> 0x0072 }
            goto L_0x0000
        L_0x003b:
            java.util.concurrent.ConcurrentLinkedQueue<com.apptimize.du$h> r2 = r8.f42116l     // Catch:{ RuntimeException -> 0x0072 }
            java.lang.Object r2 = r2.peek()     // Catch:{ RuntimeException -> 0x0072 }
            if (r2 == 0) goto L_0x0050
            java.util.concurrent.ConcurrentLinkedQueue<com.apptimize.du$h> r0 = r8.f42116l     // Catch:{ RuntimeException -> 0x0072 }
            java.lang.Object r0 = r0.poll()     // Catch:{ RuntimeException -> 0x0072 }
            com.apptimize.du$h r0 = (com.apptimize.du.h) r0     // Catch:{ RuntimeException -> 0x0072 }
            com.apptimize.du$h r1 = r8.a((com.apptimize.du.h) r1, (com.apptimize.du.h) r0)     // Catch:{ RuntimeException -> 0x0072 }
            goto L_0x003b
        L_0x0050:
            long r2 = r0.f42158o     // Catch:{ RuntimeException -> 0x0072 }
            long r4 = java.lang.System.nanoTime()     // Catch:{ RuntimeException -> 0x0072 }
            long r2 = com.apptimize.fx.a((long) r2, (long) r4)     // Catch:{ RuntimeException -> 0x0072 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x001d
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r2 / r4
            java.lang.Long.signum(r6)
            long r4 = r4 * r6
            long r2 = r2 - r4
            int r2 = (int) r2
            java.lang.Thread.sleep(r6, r2)     // Catch:{ InterruptedException -> 0x001d }
            goto L_0x001d
        L_0x006f:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x006f }
            throw r0     // Catch:{ RuntimeException -> 0x0072 }
        L_0x0072:
            r0 = move-exception
            java.lang.String r1 = f42105a
            java.lang.String r2 = "Apptimize threw an exception which wasn't caught; this should not have happened"
            com.apptimize.bo.g(r1, r2, r0)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.b():void");
    }

    public static class b extends cr {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public cu f42131a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public cw f42132b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final Set<String> f42133c = new HashSet();

        public boolean a(cm cmVar) {
            if (this.f42132b.c()) {
                if (!this.f42132b.b()) {
                    return true;
                }
                this.f42133c.add(cmVar.f());
                return true;
            } else if (this.f42131a.b()) {
                return true;
            } else {
                this.f42133c.add(cmVar.f());
                return true;
            }
        }
    }

    public static class g extends cr {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public cu f42141a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public cw f42142b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public a f42143c;

        private g() {
        }

        public boolean a(ch chVar) {
            if (this.f42141a.d() || this.f42141a.c()) {
                return true;
            }
            bo.i(du.f42105a, "Range Group does not match filters.");
            return true;
        }

        public boolean a(cm cmVar) {
            if (!this.f42141a.d() && !this.f42141a.c()) {
                String a11 = du.f42105a;
                bo.i(a11, "Variant does not match filters: Experiment: " + cmVar.f() + "; Variant: " + cmVar.m());
                if (this.f42142b.b()) {
                    bo.j(du.f42105a, "Forcing variant despite not matching filter.");
                }
            }
            if (this.f42142b.b()) {
                String a12 = du.f42105a;
                bo.i(a12, "Forcing variant " + cmVar.m() + " of experiment " + cmVar.f());
                return true;
            } else if (!((Boolean) this.f42143c.a()).booleanValue()) {
                return true;
            } else {
                String a13 = du.f42105a;
                bo.i(a13, "Allocated to variant " + cmVar.m() + " of experiment " + cmVar.f());
                return true;
            }
        }
    }

    public void a(f fVar) {
        this.f42114j.add(fVar);
    }

    public static class a extends ct<bw, Boolean> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public cu f42128a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public k f42129b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public cw f42130c;

        public a() {
            super(bw.class, Boolean.TRUE);
        }

        public Boolean a(bw bwVar) {
            if (this.f42130c.c() && (bwVar instanceof cm)) {
                return Boolean.valueOf(this.f42130c.b());
            }
            boolean booleanValue = ((Boolean) a()).booleanValue();
            boolean z11 = false;
            if (!this.f42128a.c()) {
                booleanValue = false;
            }
            if (!(bwVar instanceof ch) || ((Boolean) this.f42129b.a()).booleanValue()) {
                z11 = booleanValue;
            }
            boolean z12 = true;
            if (this.f42128a.d()) {
                z11 = true;
            }
            if (!((Boolean) this.f42130c.a()).booleanValue()) {
                z12 = z11;
            }
            return Boolean.valueOf(z12);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.apptimize.du.j r18, java.lang.Integer r19, com.apptimize.cb r20, boolean r21, java.lang.String r22, java.lang.String r23, boolean r24, com.apptimize.ee r25, java.util.Set<java.lang.Long> r26, java.util.Set<java.lang.Long> r27, boolean r28, com.apptimize.bb r29, java.lang.String r30, java.util.Map<java.lang.Integer, java.lang.Integer> r31) {
        /*
            r17 = this;
            r15 = r17
            monitor-enter(r17)
            com.apptimize.du$h r0 = new com.apptimize.du$h     // Catch:{ all -> 0x004a }
            r1 = r0
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r27
            r13 = r28
            r14 = r29
            r15 = r30
            r16 = r31
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x0046 }
            r1 = r17
            java.util.concurrent.ConcurrentLinkedQueue<com.apptimize.du$h> r2 = r1.f42116l     // Catch:{ all -> 0x0044 }
            r2.add(r0)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f42117m     // Catch:{ all -> 0x0044 }
            r2 = 0
            r3 = 1
            boolean r0 = r0.compareAndSet(r2, r3)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            java.util.concurrent.ThreadPoolExecutor r0 = com.apptimize.fg.f42429d     // Catch:{ all -> 0x0044 }
            com.apptimize.du$1 r2 = new com.apptimize.du$1     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            r0.execute(r2)     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r17)
            return
        L_0x0044:
            r0 = move-exception
            goto L_0x004c
        L_0x0046:
            r0 = move-exception
            r1 = r17
            goto L_0x004c
        L_0x004a:
            r0 = move-exception
            r1 = r15
        L_0x004c:
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.a(com.apptimize.du$j, java.lang.Integer, com.apptimize.cb, boolean, java.lang.String, java.lang.String, boolean, com.apptimize.ee, java.util.Set, java.util.Set, boolean, com.apptimize.bb, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: type inference failed for: r7v17, types: [com.apptimize.by] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.apptimize.du.h a(com.apptimize.du.h r32, com.apptimize.du.h r33) {
        /*
            r31 = this;
            r15 = r31
            r0 = r32
            r1 = r33
            java.lang.String r2 = f42105a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "doStateChange "
            r3.append(r4)
            java.lang.Integer r4 = r1.f42145b
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.apptimize.bo.k(r2, r3)
            com.apptimize.du$j r3 = r1.f42144a
            boolean r4 = r1.f42156m
            java.util.Set<java.lang.Long> r5 = r1.f42151h
            java.util.Set<java.lang.Long> r6 = r1.f42152i
            int[] r7 = com.apptimize.du.AnonymousClass6.f42127a
            int r8 = r3.ordinal()
            r7 = r7[r8]
            r8 = 1
            r9 = 0
            r10 = 0
            switch(r7) {
                case 1: goto L_0x00a9;
                case 2: goto L_0x0090;
                case 3: goto L_0x004f;
                case 4: goto L_0x003d;
                case 5: goto L_0x003d;
                case 6: goto L_0x003d;
                default: goto L_0x0034;
            }
        L_0x0034:
            r11 = r6
            r30 = r5
            r5 = r4
            r4 = r10
            r10 = r30
            goto L_0x010a
        L_0x003d:
            com.apptimize.du$j r3 = r0.f42144a
            com.apptimize.du$j r7 = com.apptimize.du.j.ProcessMetaData
            if (r3 != r7) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            com.apptimize.du$j r7 = r1.f42144a
        L_0x0046:
            com.apptimize.cb r3 = r1.f42146c
            r10 = r5
            r11 = r6
            r5 = r4
            r4 = r3
            r3 = r7
            goto L_0x010a
        L_0x004f:
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r3 = r15.f42115k
            java.lang.Object r3 = r3.get()
            com.apptimize.dv r3 = (com.apptimize.dv) r3
            r3.a((boolean) r9)
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r3 = r15.f42115k
            java.lang.Object r3 = r3.get()
            com.apptimize.dv r3 = (com.apptimize.dv) r3
            com.apptimize.cc r3 = r3.h()
            com.apptimize.du$j r4 = com.apptimize.du.j.ProcessMetaData
            if (r3 == 0) goto L_0x0071
            com.apptimize.by r7 = r3.f()
            r10 = r7
            com.apptimize.cb r10 = (com.apptimize.cb) r10
        L_0x0071:
            if (r3 == 0) goto L_0x007c
            java.lang.Boolean r7 = r3.j()
            boolean r7 = r7.booleanValue()
            goto L_0x007d
        L_0x007c:
            r7 = r9
        L_0x007d:
            if (r3 == 0) goto L_0x0083
            java.util.Set r5 = r3.g()
        L_0x0083:
            if (r3 == 0) goto L_0x0089
            java.util.Set r6 = r3.h()
        L_0x0089:
            r3 = r4
            r11 = r6
            r4 = r10
            r10 = r5
            r5 = r7
            goto L_0x010a
        L_0x0090:
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r3 = r15.f42115k
            java.lang.Object r3 = r3.get()
            com.apptimize.dv r3 = (com.apptimize.dv) r3
            r3.a((boolean) r8)
            java.lang.String r3 = "Initializing wysiwyg metaData"
            com.apptimize.bo.c(r2, r3)
            com.apptimize.du$j r3 = com.apptimize.du.j.ProcessMetaData
            com.apptimize.cb r7 = r1.f42146c
        L_0x00a4:
            r10 = r5
            r11 = r6
            r5 = r4
            r4 = r7
            goto L_0x010a
        L_0x00a9:
            com.apptimize.cc r3 = new com.apptimize.cc
            java.lang.String r7 = r15.f42111g
            java.lang.String r10 = r1.f42147d
            java.lang.String r11 = r1.f42148e
            com.apptimize.au r12 = r15.f42106b
            com.apptimize.fv r12 = r12.b()
            long r20 = r12.b()
            com.apptimize.au r12 = r15.f42106b
            com.apptimize.fv r12 = r12.b()
            long r22 = r12.c()
            com.apptimize.cb r12 = r1.f42146c
            java.util.Set<java.lang.Long> r13 = r1.f42151h
            java.util.Set<java.lang.Long> r14 = r1.f42152i
            java.lang.String r27 = com.apptimize.fx.a()
            boolean r8 = r1.f42156m
            java.lang.Boolean r28 = java.lang.Boolean.valueOf(r8)
            r16 = r3
            r17 = r7
            r18 = r10
            r19 = r11
            r24 = r12
            r25 = r13
            r26 = r14
            r16.<init>(r17, r18, r19, r20, r22, r24, r25, r26, r27, r28)
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r7 = r15.f42115k
            java.lang.Object r7 = r7.get()
            com.apptimize.dv r7 = (com.apptimize.dv) r7
            r7.a(r3, r9)
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r3 = r15.f42115k
            java.lang.Object r3 = r3.get()
            com.apptimize.dv r3 = (com.apptimize.dv) r3
            boolean r3 = r3.e()
            if (r3 == 0) goto L_0x0105
            java.lang.String r1 = "doStateChange updated permanent metaData for later processing"
            com.apptimize.bo.k(r2, r1)
            return r0
        L_0x0105:
            com.apptimize.du$j r3 = com.apptimize.du.j.ProcessMetaData
            com.apptimize.cb r7 = r1.f42146c
            goto L_0x00a4
        L_0x010a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "doStateChange processingType:"
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            com.apptimize.bo.k(r2, r6)
            java.lang.Integer r6 = r1.f42145b
            java.lang.String r2 = r1.f42147d
            if (r2 == 0) goto L_0x0129
            java.lang.String r7 = ""
            if (r2 == r7) goto L_0x0129
            goto L_0x012b
        L_0x0129:
            java.lang.String r2 = r0.f42147d
        L_0x012b:
            r7 = r2
            java.lang.String r8 = r1.f42148e
            boolean r2 = r0.f42149f
            if (r2 != 0) goto L_0x013a
            boolean r2 = r1.f42149f
            if (r2 == 0) goto L_0x0137
            goto L_0x013a
        L_0x0137:
            r29 = r9
            goto L_0x013c
        L_0x013a:
            r29 = 1
        L_0x013c:
            com.apptimize.ee r2 = r1.f42150g
            if (r2 == 0) goto L_0x0142
            r9 = r2
            goto L_0x0145
        L_0x0142:
            com.apptimize.ee r0 = r0.f42150g
            r9 = r0
        L_0x0145:
            boolean r12 = r1.f42153j
            com.apptimize.bb r13 = r1.f42154k
            java.lang.String r14 = r1.f42155l
            com.apptimize.du$h r16 = new com.apptimize.du$h
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = r1.f42157n
            r0 = r16
            r1 = r31
            r17 = r2
            r2 = r3
            r3 = r6
            r6 = r7
            r7 = r8
            r8 = r29
            r15 = r17
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.a(com.apptimize.du$h, com.apptimize.du$h):com.apptimize.du$h");
    }

    public class h {

        /* renamed from: a  reason: collision with root package name */
        final j f42144a;

        /* renamed from: b  reason: collision with root package name */
        final Integer f42145b;

        /* renamed from: c  reason: collision with root package name */
        final cb f42146c;

        /* renamed from: d  reason: collision with root package name */
        final String f42147d;

        /* renamed from: e  reason: collision with root package name */
        String f42148e;

        /* renamed from: f  reason: collision with root package name */
        boolean f42149f;

        /* renamed from: g  reason: collision with root package name */
        final ee f42150g;

        /* renamed from: h  reason: collision with root package name */
        final Set<Long> f42151h;

        /* renamed from: i  reason: collision with root package name */
        final Set<Long> f42152i;

        /* renamed from: j  reason: collision with root package name */
        final boolean f42153j;

        /* renamed from: k  reason: collision with root package name */
        final bb f42154k;

        /* renamed from: l  reason: collision with root package name */
        final String f42155l;

        /* renamed from: m  reason: collision with root package name */
        final boolean f42156m;

        /* renamed from: n  reason: collision with root package name */
        final Map<Integer, Integer> f42157n;

        /* renamed from: o  reason: collision with root package name */
        final long f42158o;

        public h() {
            this.f42144a = j.StateChangeOnly;
            this.f42145b = 0;
            this.f42146c = null;
            this.f42147d = null;
            this.f42148e = null;
            this.f42149f = false;
            this.f42150g = null;
            this.f42151h = null;
            this.f42152i = null;
            this.f42153j = false;
            this.f42154k = null;
            this.f42155l = null;
            this.f42156m = false;
            this.f42157n = null;
            this.f42158o = System.nanoTime();
        }

        public h(j jVar, Integer num, cb cbVar, boolean z11, String str, String str2, boolean z12, ee eeVar, Set<Long> set, Set<Long> set2, boolean z13, bb bbVar, String str3, Map<Integer, Integer> map) {
            HashSet hashSet;
            this.f42144a = jVar;
            this.f42145b = num;
            this.f42146c = cbVar;
            this.f42156m = z11;
            this.f42147d = str;
            this.f42148e = str2;
            this.f42149f = z12;
            this.f42150g = eeVar;
            this.f42151h = set;
            if (set2 == null) {
                hashSet = null;
            } else {
                hashSet = new HashSet(set2);
            }
            this.f42152i = hashSet;
            this.f42153j = z13;
            this.f42154k = bbVar;
            this.f42155l = str3;
            this.f42157n = map;
            this.f42158o = System.nanoTime();
        }
    }

    private i b(h hVar) {
        cb cbVar;
        h hVar2 = hVar;
        if (hVar2.f42146c == null) {
            bo.a(f42105a, "Null meta-data");
            return null;
        }
        dv dvVar = this.f42115k.get();
        cb cbVar2 = hVar2.f42146c;
        String str = this.f42111g;
        String str2 = hVar2.f42147d;
        String str3 = hVar2.f42148e;
        long b11 = this.f42106b.b().b();
        long c11 = this.f42106b.b().c();
        Set<Long> set = hVar2.f42151h;
        cc ccVar = new cc(str, str2, str3, b11, c11, cbVar2, set, hVar2.f42152i, fx.a(), Boolean.valueOf(hVar2.f42156m));
        int f11 = cbVar2.f();
        cc h11 = dvVar.h();
        if (hVar2.f42149f || h11 == null || h11.f() == null || (f11 >= h11.f().f() && (f11 != h11.f().f() || !fx.a((Object) ccVar.c(), (Object) h11.c()) || !fx.a((Object) ccVar.b(), (Object) h11.b())))) {
            bo.k(f42105a, "updating metaData");
            dvVar.a(ccVar);
            cbVar = cbVar2;
        } else {
            bo.k(f42105a, "not updating metadata");
            cbVar = (cb) h11.f();
        }
        if (!a(bg.a.NEW_METADATA, (by) hVar2.f42146c, hVar2.f42154k)) {
            bo.a(f42105a, "Apptimize subprocessors failed processing metadata");
            return null;
        }
        return a(cbVar, hVar2.f42150g, ccVar, hVar2.f42152i, hVar2.f42153j, hVar2.f42154k.a(f11), hVar2.f42155l);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(java.util.List<com.apptimize.az> r2, com.apptimize.bb r3) {
        /*
            r0 = 1
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Iterator r2 = r2.iterator()
        L_0x0008:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r2.next()
            com.apptimize.az r1 = (com.apptimize.az) r1
            java.lang.Boolean r1 = r1.b((com.apptimize.bb) r3)
            if (r1 == 0) goto L_0x0020
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0008
        L_0x0020:
            r2 = 0
            return r2
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.b(java.util.List, com.apptimize.bb):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.apptimize.du.h r12) {
        /*
            r11 = this;
            java.lang.String r0 = f42105a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "doProcessing "
            r1.append(r2)
            java.lang.Integer r2 = r12.f42145b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.apptimize.bo.k(r0, r1)
            int[] r1 = com.apptimize.du.AnonymousClass6.f42127a
            com.apptimize.du$j r2 = r12.f42144a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L_0x003d
            r2 = 2
            if (r1 == r2) goto L_0x003d
            r2 = 3
            if (r1 == r2) goto L_0x003d
            r2 = 4
            if (r1 == r2) goto L_0x0038
            r2 = 5
            if (r1 == r2) goto L_0x0033
            goto L_0x0053
        L_0x0033:
            com.apptimize.du$i r1 = r11.c(r12)
            goto L_0x0054
        L_0x0038:
            com.apptimize.du$i r1 = r11.b((com.apptimize.du.h) r12)
            goto L_0x0054
        L_0x003d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected metaData processing request "
            r1.append(r2)
            com.apptimize.du$j r2 = r12.f42144a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.apptimize.bo.c(r0, r1)
        L_0x0053:
            r1 = r3
        L_0x0054:
            if (r1 == 0) goto L_0x00a7
            java.util.concurrent.atomic.AtomicReference<com.apptimize.ed> r2 = r11.f42113i
            com.apptimize.ed r4 = r1.f42161b
            java.lang.Object r2 = r2.getAndSet(r4)
            com.apptimize.ed r2 = (com.apptimize.ed) r2
            java.lang.Integer r4 = r12.f42145b
            int r6 = r4.intValue()
            com.apptimize.ee r7 = r1.f42160a
            java.util.concurrent.atomic.AtomicReference<com.apptimize.ed> r4 = r11.f42113i
            java.lang.Object r4 = r4.get()
            com.apptimize.ed r4 = (com.apptimize.ed) r4
            boolean r8 = r4.m()
            com.apptimize.ed r1 = r1.f42161b
            if (r1 != r2) goto L_0x007a
            r9 = r3
            goto L_0x007b
        L_0x007a:
            r9 = r1
        L_0x007b:
            java.util.Map<java.lang.Integer, java.lang.Integer> r10 = r12.f42157n
            r5 = r11
            r5.a(r6, r7, r8, r9, r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "The applicable tests are: "
            r12.append(r1)
            java.util.concurrent.atomic.AtomicReference<com.apptimize.ed> r1 = r11.f42113i
            java.lang.Object r1 = r1.get()
            com.apptimize.ed r1 = (com.apptimize.ed) r1
            java.util.Set r1 = r1.f()
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.apptimize.bo.i(r0, r12)
            java.lang.String r12 = "Updated meta-data"
            com.apptimize.bo.h(r0, r12)
            goto L_0x00c1
        L_0x00a7:
            java.lang.Integer r0 = r12.f42145b
            int r2 = r0.intValue()
            r3 = 0
            java.util.concurrent.atomic.AtomicReference<com.apptimize.dv> r0 = r11.f42115k
            java.lang.Object r0 = r0.get()
            com.apptimize.dv r0 = (com.apptimize.dv) r0
            boolean r4 = r0.e()
            r5 = 0
            java.util.Map<java.lang.Integer, java.lang.Integer> r6 = r12.f42157n
            r1 = r11
            r1.a(r2, r3, r4, r5, r6)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.du.a(com.apptimize.du$h):void");
    }

    private i a(cb cbVar, ee eeVar, cc ccVar, Set<Long> set, boolean z11, bb bbVar, String str) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(eeVar.c());
        Map<Long, el> a11 = eeVar.a();
        bb a12 = bbVar.a(cbVar.f());
        this.f42107c.a(cbVar.h(), a12);
        bb a13 = a12.a(this.f42107c.e()).a(this.f42112h.a());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashSet hashSet = new HashSet();
        new HashSet();
        ArrayList arrayList3 = new ArrayList();
        cj.a a14 = cj.a.a();
        boolean z12 = !b(cbVar.b(), a13);
        if (set.isEmpty() || z11) {
            a(cbVar, set, (Map<String, bt.f>) hashMap2, (Map<String, Long>) hashMap3, (List<dc>) arrayList3, a13, this.f42106b);
        }
        Set<String> a15 = a(cbVar, set, a13);
        String str2 = this.f42110f;
        au auVar = this.f42106b;
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = arrayList2;
        HashMap hashMap5 = hashMap4;
        bb bbVar2 = a13;
        a(cbVar, a11, hashMap4, hashMap, hashSet, hashMap3, arrayList3, a14, set, a13, str2, str, auVar);
        for (cn next : cbVar.j()) {
            if (a(next.c(), bbVar2) || (b(next.b(), bbVar2) && !z12)) {
                arrayList4.add(next.d());
            }
        }
        for (Map.Entry next2 : a11.entrySet()) {
            HashMap hashMap6 = hashMap5;
            if (!hashMap6.containsKey((Long) next2.getKey())) {
                arrayList = arrayList5;
                arrayList.add(next2.getValue());
            } else {
                arrayList = arrayList5;
            }
            arrayList5 = arrayList;
            hashMap5 = hashMap6;
        }
        ArrayList arrayList6 = arrayList4;
        this.f42109e.a(a14.b());
        return new i(new ee(hashMap5, arrayList5, -1), new ed(ccVar, hashMap, hashMap2, hashMap3, hashSet, set, a15, arrayList6, str, this.f42115k.get().e(), cbVar.f()));
    }

    private boolean a(bg.a aVar, by byVar, bb bbVar) {
        final CountDownLatch countDownLatch = new CountDownLatch(this.f42108d.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        for (bg a11 : this.f42108d) {
            a11.a(aVar, byVar, bbVar, new ez() {
                public void a() {
                    countDownLatch.countDown();
                }

                public void b() {
                    atomicBoolean.set(false);
                    countDownLatch.countDown();
                }
            });
        }
        while (countDownLatch.getCount() > 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        return atomicBoolean.get();
    }

    private static boolean a(List<az> list, bb bbVar) {
        for (az b11 : list) {
            Boolean b12 = b11.b(bbVar);
            if (b12 != null && b12.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> a(cb cbVar, Set<Long> set, bb bbVar) {
        b bVar = new b();
        cw cwVar = new cw(set);
        cw unused = bVar.f42132b = cwVar;
        cu cuVar = new cu(bbVar);
        cu unused2 = bVar.f42131a = cuVar;
        AnonymousClass3 r42 = new cy(bVar) {
            public boolean a(bx bxVar) {
                return true;
            }

            public boolean a(ce ceVar) {
                return true;
            }

            public boolean a(cn cnVar) {
                return true;
            }
        };
        r42.a((ct<?, ?>) cwVar);
        r42.a((ct<?, ?>) cuVar);
        cbVar.a((co) r42);
        return bVar.f42133c;
    }

    private static void a(cb cbVar, Map<Long, el> map, Map<Long, el> map2, Map<String, bt.f> map3, Set<Long> set, Map<String, Long> map4, List<dc> list, cj.a aVar, Set<Long> set2, bb bbVar, String str, String str2, au auVar) {
        n nVar = new n(map, map2, set, map3, map4, list, auVar);
        g gVar = new g();
        m mVar = new m(aVar);
        cx cxVar = new cx(gVar, new cx(nVar, mVar));
        cu cuVar = new cu(bbVar);
        k kVar = new k();
        a aVar2 = new a();
        cw cwVar = new cw(set2);
        d dVar = new d();
        l lVar = new l(str, str2, cxVar);
        lVar.a((ct<?, ?>) cuVar);
        lVar.a((ct<?, ?>) cwVar);
        lVar.a((ct<?, ?>) kVar);
        lVar.a((ct<?, ?>) aVar2);
        lVar.a((ct<?, ?>) dVar);
        k unused = aVar2.f42129b = kVar;
        cu unused2 = aVar2.f42128a = cuVar;
        cw unused3 = aVar2.f42130c = cwVar;
        l unused4 = kVar.f42170a = lVar;
        cu unused5 = gVar.f42141a = cuVar;
        cw unused6 = gVar.f42142b = cwVar;
        a unused7 = gVar.f42143c = aVar2;
        a unused8 = mVar.f42175b = aVar2;
        d unused9 = nVar.f42183h = dVar;
        a unused10 = nVar.f42184i = aVar2;
        cb cbVar2 = cbVar;
        cbVar.a((co) lVar);
    }

    private static void a(cb cbVar, Set<Long> set, Map<String, bt.f> map, Map<String, Long> map2, List<dc> list, bb bbVar, au auVar) {
        e eVar = new e(map, set, map2, list, auVar);
        c cVar = new c();
        c unused = eVar.f42135b = cVar;
        cu cuVar = new cu(bbVar);
        cu unused2 = eVar.f42134a = cuVar;
        cbVar.a((co) new cy(eVar) {
            public boolean a(ce ceVar) {
                return true;
            }

            public boolean a(ch chVar) {
                return true;
            }

            public boolean a(cl clVar) {
                return true;
            }
        }.a((ct<?, ?>) cuVar).a((ct<?, ?>) cVar));
    }

    private void a(int i11, ee eeVar, boolean z11, ed edVar, Map<Integer, Integer> map) {
        String str = f42105a;
        bo.k(str, "notifyMetaDataProcessed " + i11 + " new PMD " + edVar);
        final int i12 = i11;
        final ee eeVar2 = eeVar;
        final ed edVar2 = edVar;
        final Map<Integer, Integer> map2 = map;
        fe.a(str, new fi() {
            public void run() {
                for (f a11 : du.this.f42114j) {
                    a11.a(i12, eeVar2, edVar2, map2);
                }
            }
        });
    }
}
