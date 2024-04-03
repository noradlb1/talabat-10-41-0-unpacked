package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {

    /* renamed from: a  reason: collision with root package name */
    public final int f23186a;

    /* renamed from: b  reason: collision with root package name */
    public Object[] f23187b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f23188c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f23189d;

    /* renamed from: e  reason: collision with root package name */
    public int f23190e;

    public LinkedArrayList(int i11) {
        this.f23186a = i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f23189d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            int r0 = r4.f23186a
            int r0 = r0 + r2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4.f23187b = r0
            r4.f23188c = r0
            r0[r1] = r5
            r4.f23190e = r2
            r4.f23189d = r2
            goto L_0x003c
        L_0x0016:
            int r0 = r4.f23190e
            int r3 = r4.f23186a
            if (r0 != r3) goto L_0x0030
            int r0 = r3 + 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Object[] r5 = r4.f23188c
            r5[r3] = r0
            r4.f23188c = r0
            r4.f23190e = r2
            int r5 = r4.f23189d
            int r5 = r5 + r2
            r4.f23189d = r5
            goto L_0x003c
        L_0x0030:
            java.lang.Object[] r1 = r4.f23188c
            r1[r0] = r5
            int r0 = r0 + r2
            r4.f23190e = r0
            int r5 = r4.f23189d
            int r5 = r5 + r2
            r4.f23189d = r5
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.LinkedArrayList.add(java.lang.Object):void");
    }

    public Object[] head() {
        return this.f23187b;
    }

    public int size() {
        return this.f23189d;
    }

    public String toString() {
        int i11 = this.f23186a;
        int i12 = this.f23189d;
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
