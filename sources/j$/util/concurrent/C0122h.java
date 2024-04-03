package j$.util.concurrent;

/* renamed from: j$.util.concurrent.h  reason: case insensitive filesystem */
final class C0122h extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f28708j;

    /* renamed from: k  reason: collision with root package name */
    final Object f28709k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0122h(C0116b bVar, int i11, int i12, int i13, E[] eArr, Object obj, int i14) {
        super(bVar, i11, i12, i13, eArr);
        this.f28708j = i14;
        this.f28709k = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c A[LOOP:1: B:10:0x0036->B:12:0x003c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[LOOP:3: B:22:0x0074->B:24:0x007a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8 A[LOOP:5: B:34:0x00b2->B:36:0x00b8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f4 A[LOOP:7: B:46:0x00ee->B:48:0x00f4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0042 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0080 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void compute() {
        /*
            r12 = this;
            int r0 = r12.f28708j
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0084;
                case 1: goto L_0x0046;
                case 2: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x00c0
        L_0x0008:
            java.lang.Object r0 = r12.f28709k
            j$.util.function.Consumer r0 = (j$.util.function.Consumer) r0
            if (r0 == 0) goto L_0x0045
            int r10 = r12.f28701f
        L_0x0010:
            int r2 = r12.f28704i
            if (r2 <= 0) goto L_0x0036
            int r6 = r12.f28702g
            int r2 = r6 + r10
            int r5 = r2 >>> 1
            if (r5 <= r10) goto L_0x0036
            r12.addToPendingCount(r1)
            j$.util.concurrent.h r11 = new j$.util.concurrent.h
            int r2 = r12.f28704i
            int r4 = r2 >>> 1
            r12.f28704i = r4
            r12.f28702g = r5
            j$.util.concurrent.E[] r7 = r12.f28696a
            r9 = 2
            r2 = r11
            r3 = r12
            r8 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r11.fork()
            goto L_0x0010
        L_0x0036:
            j$.util.concurrent.E r1 = r12.a()
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r1.f28633c
            r0.accept(r1)
            goto L_0x0036
        L_0x0042:
            r12.propagateCompletion()
        L_0x0045:
            return
        L_0x0046:
            java.lang.Object r0 = r12.f28709k
            j$.util.function.Consumer r0 = (j$.util.function.Consumer) r0
            if (r0 == 0) goto L_0x0083
            int r10 = r12.f28701f
        L_0x004e:
            int r2 = r12.f28704i
            if (r2 <= 0) goto L_0x0074
            int r6 = r12.f28702g
            int r2 = r6 + r10
            int r5 = r2 >>> 1
            if (r5 <= r10) goto L_0x0074
            r12.addToPendingCount(r1)
            j$.util.concurrent.h r11 = new j$.util.concurrent.h
            int r2 = r12.f28704i
            int r4 = r2 >>> 1
            r12.f28704i = r4
            r12.f28702g = r5
            j$.util.concurrent.E[] r7 = r12.f28696a
            r9 = 1
            r2 = r11
            r3 = r12
            r8 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r11.fork()
            goto L_0x004e
        L_0x0074:
            j$.util.concurrent.E r1 = r12.a()
            if (r1 == 0) goto L_0x0080
            java.lang.Object r1 = r1.f28632b
            r0.accept(r1)
            goto L_0x0074
        L_0x0080:
            r12.propagateCompletion()
        L_0x0083:
            return
        L_0x0084:
            java.lang.Object r0 = r12.f28709k
            j$.util.function.Consumer r0 = (j$.util.function.Consumer) r0
            if (r0 == 0) goto L_0x00bf
            int r10 = r12.f28701f
        L_0x008c:
            int r2 = r12.f28704i
            if (r2 <= 0) goto L_0x00b2
            int r6 = r12.f28702g
            int r2 = r6 + r10
            int r5 = r2 >>> 1
            if (r5 <= r10) goto L_0x00b2
            r12.addToPendingCount(r1)
            j$.util.concurrent.h r11 = new j$.util.concurrent.h
            int r2 = r12.f28704i
            int r4 = r2 >>> 1
            r12.f28704i = r4
            r12.f28702g = r5
            j$.util.concurrent.E[] r7 = r12.f28696a
            r9 = 0
            r2 = r11
            r3 = r12
            r8 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r11.fork()
            goto L_0x008c
        L_0x00b2:
            j$.util.concurrent.E r1 = r12.a()
            if (r1 == 0) goto L_0x00bc
            r0.accept(r1)
            goto L_0x00b2
        L_0x00bc:
            r12.propagateCompletion()
        L_0x00bf:
            return
        L_0x00c0:
            java.lang.Object r0 = r12.f28709k
            j$.util.function.BiConsumer r0 = (j$.util.function.BiConsumer) r0
            if (r0 == 0) goto L_0x00ff
            int r10 = r12.f28701f
        L_0x00c8:
            int r2 = r12.f28704i
            if (r2 <= 0) goto L_0x00ee
            int r6 = r12.f28702g
            int r2 = r6 + r10
            int r5 = r2 >>> 1
            if (r5 <= r10) goto L_0x00ee
            r12.addToPendingCount(r1)
            j$.util.concurrent.h r11 = new j$.util.concurrent.h
            int r2 = r12.f28704i
            int r4 = r2 >>> 1
            r12.f28704i = r4
            r12.f28702g = r5
            j$.util.concurrent.E[] r7 = r12.f28696a
            r9 = 3
            r2 = r11
            r3 = r12
            r8 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r11.fork()
            goto L_0x00c8
        L_0x00ee:
            j$.util.concurrent.E r1 = r12.a()
            if (r1 == 0) goto L_0x00fc
            java.lang.Object r2 = r1.f28632b
            java.lang.Object r1 = r1.f28633c
            r0.accept(r2, r1)
            goto L_0x00ee
        L_0x00fc:
            r12.propagateCompletion()
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0122h.compute():void");
    }
}
