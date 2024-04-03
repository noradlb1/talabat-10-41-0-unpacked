package io.reactivex.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {

    /* renamed from: a  reason: collision with root package name */
    public final int f18625a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f18626b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f18627c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f18628d;

    /* renamed from: e  reason: collision with root package name */
    public int f18629e;

    public LinkedArrayList(int i11) {
        this.f18625a = i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f18628d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            int r0 = r4.f18625a
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.f18626b = r0
            r4.f18627c = r0
            r0[r1] = r5
            r4.f18629e = r2
            r4.f18628d = r2
            goto L_0x003c
        L_0x0016:
            int r0 = r4.f18629e
            int r3 = r4.f18625a
            if (r0 != r3) goto L_0x0030
            int r0 = r3 + 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.f18627c
            r5[r3] = r0
            r4.f18627c = r0
            r4.f18629e = r2
            int r5 = r4.f18628d
            int r5 = r5 + r2
            r4.f18628d = r5
            goto L_0x003c
        L_0x0030:
            java.lang.Object[] r1 = r4.f18627c
            r1[r0] = r5
            int r0 = r0 + r2
            r4.f18629e = r0
            int r5 = r4.f18628d
            int r5 = r5 + r2
            r4.f18628d = r5
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.LinkedArrayList.add(java.lang.Object):void");
    }

    public Object[] head() {
        return this.f18626b;
    }

    public int size() {
        return this.f18628d;
    }

    public String toString() {
        int i11 = this.f18625a;
        int i12 = this.f18628d;
        ArrayList arrayList = new ArrayList(i12 + 1);
        Object[] head = head();
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            arrayList.add(head[i14]);
            i13++;
            i14++;
            if (i14 == i11) {
                head = (Object[]) head[i11];
                i14 = 0;
            }
        }
        return arrayList.toString();
    }
}
