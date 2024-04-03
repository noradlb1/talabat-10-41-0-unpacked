package j$.util.concurrent;

import j$.util.function.Consumer;
import j$.util.function.Function;

/* renamed from: j$.util.concurrent.i  reason: case insensitive filesystem */
final class C0123i extends C0116b {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f28710j;

    /* renamed from: k  reason: collision with root package name */
    final Function f28711k;

    /* renamed from: l  reason: collision with root package name */
    final Consumer f28712l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0123i(C0116b bVar, int i11, int i12, int i13, E[] eArr, Function function, Consumer consumer, int i14) {
        super(bVar, i11, i12, i13, eArr);
        this.f28710j = i14;
        this.f28711k = function;
        this.f28712l = consumer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x004b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0090 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void compute() {
        /*
            r14 = this;
            int r0 = r14.f28710j
            r1 = 1
            switch(r0) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0094
        L_0x0008:
            j$.util.function.Function r0 = r14.f28711k
            if (r0 == 0) goto L_0x004e
            j$.util.function.Consumer r11 = r14.f28712l
            if (r11 == 0) goto L_0x004e
            int r12 = r14.f28701f
        L_0x0012:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x0039
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x0039
            r14.addToPendingCount(r1)
            j$.util.concurrent.i r13 = new j$.util.concurrent.i
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
        L_0x0039:
            j$.util.concurrent.E r1 = r14.a()
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r1.f28632b
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x0039
            r11.accept(r1)
            goto L_0x0039
        L_0x004b:
            r14.propagateCompletion()
        L_0x004e:
            return
        L_0x004f:
            j$.util.function.Function r0 = r14.f28711k
            if (r0 == 0) goto L_0x0093
            j$.util.function.Consumer r11 = r14.f28712l
            if (r11 == 0) goto L_0x0093
            int r12 = r14.f28701f
        L_0x0059:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x0080
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x0080
            r14.addToPendingCount(r1)
            j$.util.concurrent.i r13 = new j$.util.concurrent.i
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
            goto L_0x0059
        L_0x0080:
            j$.util.concurrent.E r1 = r14.a()
            if (r1 == 0) goto L_0x0090
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x0080
            r11.accept(r1)
            goto L_0x0080
        L_0x0090:
            r14.propagateCompletion()
        L_0x0093:
            return
        L_0x0094:
            j$.util.function.Function r0 = r14.f28711k
            if (r0 == 0) goto L_0x00da
            j$.util.function.Consumer r11 = r14.f28712l
            if (r11 == 0) goto L_0x00da
            int r12 = r14.f28701f
        L_0x009e:
            int r2 = r14.f28704i
            if (r2 <= 0) goto L_0x00c5
            int r6 = r14.f28702g
            int r2 = r6 + r12
            int r5 = r2 >>> 1
            if (r5 <= r12) goto L_0x00c5
            r14.addToPendingCount(r1)
            j$.util.concurrent.i r13 = new j$.util.concurrent.i
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
            goto L_0x009e
        L_0x00c5:
            j$.util.concurrent.E r1 = r14.a()
            if (r1 == 0) goto L_0x00d7
            java.lang.Object r1 = r1.f28633c
            java.lang.Object r1 = r0.apply(r1)
            if (r1 == 0) goto L_0x00c5
            r11.accept(r1)
            goto L_0x00c5
        L_0x00d7:
            r14.propagateCompletion()
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.C0123i.compute():void");
    }
}
