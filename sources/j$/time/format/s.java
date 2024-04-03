package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

final class s extends r {

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap f28378e = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final B f28379c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28380d;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    s(j$.time.format.B r4, boolean r5) {
        /*
            r3 = this;
            j$.time.temporal.s r0 = j$.time.temporal.p.j()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "ZoneText("
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r3.<init>(r0, r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r0 = "textStyle"
            java.util.Objects.requireNonNull(r4, r0)
            r3.f28379c = r4
            r3.f28380d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.s.<init>(j$.time.format.B, boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: j$.util.concurrent.ConcurrentHashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: j$.util.concurrent.ConcurrentHashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        if (r8 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(j$.time.format.v r14, java.lang.StringBuilder r15) {
        /*
            r13 = this;
            j$.time.temporal.s r0 = j$.time.temporal.p.k()
            java.lang.Object r0 = r14.f(r0)
            j$.time.x r0 = (j$.time.x) r0
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r2 = r0.e()
            boolean r3 = r0 instanceof j$.time.ZoneOffset
            r4 = 1
            if (r3 != 0) goto L_0x00fa
            j$.time.temporal.m r3 = r14.d()
            boolean r5 = r13.f28380d
            r6 = 0
            r7 = 2
            if (r5 != 0) goto L_0x0082
            j$.time.temporal.a r5 = j$.time.temporal.a.INSTANT_SECONDS
            boolean r5 = r3.c(r5)
            if (r5 == 0) goto L_0x0036
            j$.time.zone.f r0 = r0.B()
            j$.time.Instant r3 = j$.time.Instant.C(r3)
            boolean r0 = r0.h(r3)
            goto L_0x0083
        L_0x0036:
            j$.time.temporal.a r5 = j$.time.temporal.a.EPOCH_DAY
            boolean r8 = r3.c(r5)
            if (r8 == 0) goto L_0x0082
            j$.time.temporal.a r8 = j$.time.temporal.a.NANO_OF_DAY
            boolean r9 = r3.c(r8)
            if (r9 == 0) goto L_0x0082
            long r9 = r3.s(r5)
            j$.time.h r5 = j$.time.h.O(r9)
            long r8 = r3.s(r8)
            j$.time.k r3 = j$.time.k.J(r8)
            j$.time.LocalDateTime r3 = j$.time.LocalDateTime.J(r5, r3)
            j$.time.zone.f r5 = r0.B()
            j$.time.zone.b r5 = r5.f(r3)
            if (r5 != 0) goto L_0x0082
            j$.time.zone.f r5 = r0.B()
            j$.time.ZonedDateTime r0 = j$.time.ZonedDateTime.D(r3, r0, r6)
            long r8 = j$.time.chrono.C0099b.q(r0)
            j$.time.k r0 = r0.toLocalTime()
            int r0 = r0.G()
            long r10 = (long) r0
            j$.time.Instant r0 = j$.time.Instant.E(r8, r10)
            boolean r0 = r5.h(r0)
            goto L_0x0083
        L_0x0082:
            r0 = r7
        L_0x0083:
            java.util.Locale r14 = r14.c()
            j$.time.format.B r3 = j$.time.format.B.NARROW
            j$.time.format.B r5 = r13.f28379c
            if (r5 != r3) goto L_0x008e
            goto L_0x00f7
        L_0x008e:
            j$.util.concurrent.ConcurrentHashMap r3 = f28378e
            java.lang.Object r8 = r3.get(r2)
            java.lang.ref.SoftReference r8 = (java.lang.ref.SoftReference) r8
            r9 = 5
            r10 = 3
            if (r8 == 0) goto L_0x00aa
            java.lang.Object r6 = r8.get()
            java.util.Map r6 = (java.util.Map) r6
            if (r6 == 0) goto L_0x00aa
            java.lang.Object r8 = r6.get(r14)
            java.lang.String[] r8 = (java.lang.String[]) r8
            if (r8 != 0) goto L_0x00e4
        L_0x00aa:
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r2)
            r11 = 7
            java.lang.String[] r11 = new java.lang.String[r11]
            r11[r1] = r2
            java.lang.String r12 = r8.getDisplayName(r1, r4, r14)
            r11[r4] = r12
            java.lang.String r12 = r8.getDisplayName(r1, r1, r14)
            r11[r7] = r12
            java.lang.String r7 = r8.getDisplayName(r4, r4, r14)
            r11[r10] = r7
            r7 = 4
            java.lang.String r1 = r8.getDisplayName(r4, r1, r14)
            r11[r7] = r1
            r11[r9] = r2
            r1 = 6
            r11[r1] = r2
            if (r6 != 0) goto L_0x00d8
            j$.util.concurrent.ConcurrentHashMap r6 = new j$.util.concurrent.ConcurrentHashMap
            r6.<init>()
        L_0x00d8:
            r6.put(r14, r11)
            java.lang.ref.SoftReference r14 = new java.lang.ref.SoftReference
            r14.<init>(r6)
            r3.put(r2, r14)
            r8 = r11
        L_0x00e4:
            int r14 = r5.f()
            if (r0 == 0) goto L_0x00f4
            if (r0 == r4) goto L_0x00f0
            int r14 = r14 + r9
            r6 = r8[r14]
            goto L_0x00f7
        L_0x00f0:
            int r14 = r14 + r10
            r6 = r8[r14]
            goto L_0x00f7
        L_0x00f4:
            int r14 = r14 + r4
            r6 = r8[r14]
        L_0x00f7:
            if (r6 == 0) goto L_0x00fa
            r2 = r6
        L_0x00fa:
            r15.append(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.s.f(j$.time.format.v, java.lang.StringBuilder):boolean");
    }
}
