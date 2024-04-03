package j$.util.concurrent;

import java.util.Map;

class E implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final int f28631a;

    /* renamed from: b  reason: collision with root package name */
    final Object f28632b;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f28633c;

    /* renamed from: d  reason: collision with root package name */
    volatile E f28634d;

    E(int i11, Object obj, Object obj2) {
        this.f28631a = i11;
        this.f28632b = obj;
        this.f28633c = obj2;
    }

    E(int i11, Object obj, Object obj2, E e11) {
        this(i11, obj, obj2);
        this.f28634d = e11;
    }

    /* access modifiers changed from: package-private */
    public E a(int i11, Object obj) {
        Object obj2;
        if (obj == null) {
            return null;
        }
        E e11 = this;
        do {
            if (e11.f28631a == i11 && ((obj2 = e11.f28632b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return e11;
            }
            e11 = e11.f28634d;
        } while (e11 != null);
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r2.f28633c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (java.util.Map.Entry) r3;
        r0 = r3.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r3 = r3.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r1 = r2.f28632b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Map.Entry
            if (r0 == 0) goto L_0x0028
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getKey()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r3 = r3.getValue()
            if (r3 == 0) goto L_0x0028
            java.lang.Object r1 = r2.f28632b
            if (r0 == r1) goto L_0x001c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
        L_0x001c:
            java.lang.Object r0 = r2.f28633c
            if (r3 == r0) goto L_0x0026
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0028
        L_0x0026:
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.E.equals(java.lang.Object):boolean");
    }

    public final Object getKey() {
        return this.f28632b;
    }

    public final Object getValue() {
        return this.f28633c;
    }

    public final int hashCode() {
        return this.f28632b.hashCode() ^ this.f28633c.hashCode();
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return J.b(this.f28632b, this.f28633c);
    }
}
