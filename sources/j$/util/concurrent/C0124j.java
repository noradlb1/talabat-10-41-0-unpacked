package j$.util.concurrent;

import j$.util.function.BiFunction;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: j$.util.concurrent.j  reason: case insensitive filesystem */
final class C0124j extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f28713j;

    /* renamed from: k  reason: collision with root package name */
    final BiFunction f28714k;

    /* renamed from: l  reason: collision with root package name */
    final Object f28715l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0124j(C0116b bVar, int i11, int i12, int i13, E[] eArr, BiFunction biFunction, Object obj, int i14) {
        super(bVar, i11, i12, i13, eArr);
        this.f28713j = i14;
        this.f28714k = biFunction;
        this.f28715l = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void compute() {
        /*
            r14 = this;
            int r0 = r14.f28713j
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0007;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0053
        L_0x0007:
            j$.util.function.BiFunction r0 = r14.f28714k
            if (r0 == 0) goto L_0x0052
            java.lang.Object r2 = r14.f28715l
            r11 = r2
            j$.util.function.Consumer r11 = (j$.util.function.Consumer) r11
            if (r11 == 0) goto L_0x0052
            int r12 = r14.f28701f
        L_0x0014:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x003b
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x003b
            r14.addToPendingCount(r1)
            j$.util.concurrent.j r13 = new j$.util.concurrent.j
            int r2 = r14.f28704i
            int r4 = r2 >>> 1
            r14.f28704i = r4
            r14.f28702g = r5
            j$.util.concurrent.E[] r7 = r14.f28696a
            r10 = 0
            r2 = r13
            r3 = r14
            r8 = r0
            r9 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r13.fork()
            goto L_0x0014
        L_0x003b:
            j$.util.concurrent.E r1 = r14.a()
            if (r1 == 0) goto L_0x004f
            java.lang.Object r2 = r1.f28632b
            java.lang.Object r1 = r1.f28633c
            java.lang.Object r1 = r0.apply(r2, r1)
            if (r1 == 0) goto L_0x003b
            r11.accept(r1)
            goto L_0x003b
        L_0x004f:
            r14.propagateCompletion()
        L_0x0052:
            return
        L_0x0053:
            j$.util.function.BiFunction r0 = r14.f28714k
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r2 = r14.f28715l
            r11 = r2
            java.util.concurrent.atomic.AtomicReference r11 = (java.util.concurrent.atomic.AtomicReference) r11
            if (r11 == 0) goto L_0x00b1
            int r12 = r14.f28701f
        L_0x0060:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x008e
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x008e
            java.lang.Object r2 = r11.get()
            if (r2 == 0) goto L_0x0073
            goto L_0x00b1
        L_0x0073:
            r14.addToPendingCount(r1)
            j$.util.concurrent.j r13 = new j$.util.concurrent.j
            int r2 = r14.f28704i
            int r4 = r2 >>> 1
            r14.f28704i = r4
            r14.f28702g = r5
            j$.util.concurrent.E[] r7 = r14.f28696a
            r10 = 1
            r2 = r13
            r3 = r14
            r8 = r0
            r9 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r13.fork()
            goto L_0x0060
        L_0x008e:
            java.lang.Object r1 = r11.get()
            if (r1 != 0) goto L_0x00b1
            j$.util.concurrent.E r1 = r14.a()
            if (r1 != 0) goto L_0x009e
            r14.propagateCompletion()
            goto L_0x00b1
        L_0x009e:
            java.lang.Object r2 = r1.f28632b
            java.lang.Object r1 = r1.f28633c
            java.lang.Object r1 = r0.apply(r2, r1)
            if (r1 == 0) goto L_0x008e
            boolean r0 = j$.util.concurrent.J.a(r11, r1)
            if (r0 == 0) goto L_0x00b1
            r14.quietlyCompleteRoot()
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0124j.compute():void");
    }

    public final Object getRawResult() {
        switch (this.f28713j) {
            case 1:
                return ((AtomicReference) this.f28715l).get();
            default:
                return super.getRawResult();
        }
    }
}
