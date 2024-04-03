package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.time.b;
import j$.time.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* renamed from: j$.time.chrono.a  reason: case insensitive filesystem */
public abstract class C0098a implements n {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap f28285a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap f28286b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f28287c = 0;

    static {
        new Locale("ja", "JP", "JP");
    }

    protected C0098a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static j$.time.chrono.n g(java.lang.String r4) {
        /*
            java.lang.String r0 = "id"
            java.util.Objects.requireNonNull(r4, r0)
        L_0x0005:
            j$.util.concurrent.ConcurrentHashMap r0 = f28285a
            java.lang.Object r1 = r0.get(r4)
            j$.time.chrono.n r1 = (j$.time.chrono.n) r1
            if (r1 != 0) goto L_0x0017
            j$.util.concurrent.ConcurrentHashMap r1 = f28286b
            java.lang.Object r1 = r1.get(r4)
            j$.time.chrono.n r1 = (j$.time.chrono.n) r1
        L_0x0017:
            if (r1 == 0) goto L_0x001a
            return r1
        L_0x001a:
            java.lang.String r1 = "ISO"
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L_0x007a
            j$.time.chrono.q r0 = j$.time.chrono.q.f28303o
            java.lang.String r2 = r0.e()
            h(r0, r2)
            j$.time.chrono.x r0 = j$.time.chrono.x.f28324d
            java.lang.String r2 = r0.e()
            h(r0, r2)
            j$.time.chrono.C r0 = j$.time.chrono.C.f28274d
            java.lang.String r2 = r0.e()
            h(r0, r2)
            j$.time.chrono.I r0 = j$.time.chrono.I.f28281d
            java.lang.String r2 = r0.e()
            h(r0, r2)
            java.lang.Class<j$.time.chrono.a> r0 = j$.time.chrono.C0098a.class
            r2 = 0
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0, r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x0051:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r0.next()
            j$.time.chrono.a r2 = (j$.time.chrono.C0098a) r2
            java.lang.String r3 = r2.e()
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0051
            java.lang.String r3 = r2.e()
            h(r2, r3)
            goto L_0x0051
        L_0x006f:
            j$.time.chrono.u r0 = j$.time.chrono.u.f28321d
            java.lang.String r1 = r0.e()
            h(r0, r1)
            r0 = 1
            goto L_0x007b
        L_0x007a:
            r0 = 0
        L_0x007b:
            if (r0 != 0) goto L_0x0005
            java.lang.Class<j$.time.chrono.n> r0 = j$.time.chrono.n.class
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0087:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r1 = r0.next()
            j$.time.chrono.n r1 = (j$.time.chrono.n) r1
            java.lang.String r2 = r1.e()
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00a7
            java.lang.String r2 = r1.j()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0087
        L_0x00a7:
            return r1
        L_0x00a8:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Unknown chronology: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C0098a.g(java.lang.String):j$.time.chrono.n");
    }

    static n h(C0098a aVar, String str) {
        String j11;
        n nVar = (n) f28285a.putIfAbsent(str, aVar);
        if (nVar == null && (j11 = aVar.j()) != null) {
            f28286b.putIfAbsent(j11, aVar);
        }
        return nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0098a) {
            return compareTo((C0098a) obj) == 0;
        }
        return false;
    }

    /* renamed from: f */
    public final int compareTo(n nVar) {
        return e().compareTo(nVar.e());
    }

    public final int hashCode() {
        return getClass().hashCode() ^ e().hashCode();
    }

    public C0103f r(LocalDateTime localDateTime) {
        try {
            return q(localDateTime).u(k.D(localDateTime));
        } catch (b e11) {
            throw new b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e11);
        }
    }

    public final String toString() {
        return e();
    }
}
