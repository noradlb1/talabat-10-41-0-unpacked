package j$.util.concurrent;

import j$.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;

final class K extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f28647j;

    /* renamed from: k  reason: collision with root package name */
    final Function f28648k;

    /* renamed from: l  reason: collision with root package name */
    final AtomicReference f28649l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ K(C0116b bVar, int i11, int i12, int i13, E[] eArr, Function function, AtomicReference atomicReference, int i14) {
        super(bVar, i11, i12, i13, eArr);
        this.f28647j = i14;
        this.f28648k = function;
        this.f28649l = atomicReference;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void compute() {
        /*
            r14 = this;
            int r0 = r14.f28647j
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0062;
                case 1: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x00ba
        L_0x0008:
            j$.util.function.Function r0 = r14.f28648k
            if (r0 == 0) goto L_0x0061
            java.util.concurrent.atomic.AtomicReference r11 = r14.f28649l
            if (r11 == 0) goto L_0x0061
            int r12 = r14.f28701f
        L_0x0012:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x0040
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x0040
            java.lang.Object r2 = r11.get()
            if (r2 == 0) goto L_0x0025
            goto L_0x0061
        L_0x0025:
            r14.addToPendingCount(r1)
            j$.util.concurrent.K r13 = new j$.util.concurrent.K
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
            goto L_0x0012
        L_0x0040:
            java.lang.Object r1 = r11.get()
            if (r1 != 0) goto L_0x0061
            j$.util.concurrent.E r1 = r14.a()
            if (r1 != 0) goto L_0x0050
            r14.propagateCompletion()
            goto L_0x0061
        L_0x0050:
            java.lang.Object r1 = r1.f28632b
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x0040
            boolean r0 = j$.util.concurrent.J.a(r11, r1)
            if (r0 == 0) goto L_0x0061
            r14.quietlyCompleteRoot()
        L_0x0061:
            return
        L_0x0062:
            j$.util.function.Function r0 = r14.f28648k
            if (r0 == 0) goto L_0x00b9
            java.util.concurrent.atomic.AtomicReference r11 = r14.f28649l
            if (r11 == 0) goto L_0x00b9
            int r12 = r14.f28701f
        L_0x006c:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x009a
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x009a
            java.lang.Object r2 = r11.get()
            if (r2 == 0) goto L_0x007f
            goto L_0x00b9
        L_0x007f:
            r14.addToPendingCount(r1)
            j$.util.concurrent.K r13 = new j$.util.concurrent.K
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
            goto L_0x006c
        L_0x009a:
            java.lang.Object r1 = r11.get()
            if (r1 != 0) goto L_0x00b9
            j$.util.concurrent.E r1 = r14.a()
            if (r1 != 0) goto L_0x00aa
            r14.propagateCompletion()
            goto L_0x00b9
        L_0x00aa:
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x009a
            boolean r0 = j$.util.concurrent.J.a(r11, r1)
            if (r0 == 0) goto L_0x00b9
            r14.quietlyCompleteRoot()
        L_0x00b9:
            return
        L_0x00ba:
            j$.util.function.Function r0 = r14.f28648k
            if (r0 == 0) goto L_0x0113
            java.util.concurrent.atomic.AtomicReference r11 = r14.f28649l
            if (r11 == 0) goto L_0x0113
            int r12 = r14.f28701f
        L_0x00c4:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x00f2
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x00f2
            java.lang.Object r2 = r11.get()
            if (r2 == 0) goto L_0x00d7
            goto L_0x0113
        L_0x00d7:
            r14.addToPendingCount(r1)
            j$.util.concurrent.K r13 = new j$.util.concurrent.K
            int r2 = r14.f28704i
            int r4 = r2 >>> 1
            r14.f28704i = r4
            r14.f28702g = r5
            j$.util.concurrent.E[] r7 = r14.f28696a
            r10 = 2
            r2 = r13
            r3 = r14
            r8 = r0
            r9 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r13.fork()
            goto L_0x00c4
        L_0x00f2:
            java.lang.Object r1 = r11.get()
            if (r1 != 0) goto L_0x0113
            j$.util.concurrent.E r1 = r14.a()
            if (r1 != 0) goto L_0x0102
            r14.propagateCompletion()
            goto L_0x0113
        L_0x0102:
            java.lang.Object r1 = r1.f28633c
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x00f2
            boolean r0 = j$.util.concurrent.J.a(r11, r1)
            if (r0 == 0) goto L_0x0113
            r14.quietlyCompleteRoot()
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.K.compute():void");
    }

    public final Object getRawResult() {
        switch (this.f28647j) {
            case 0:
                return this.f28649l.get();
            case 1:
                return this.f28649l.get();
            default:
                return this.f28649l.get();
        }
    }
}
