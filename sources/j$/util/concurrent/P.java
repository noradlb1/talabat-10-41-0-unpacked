package j$.util.concurrent;

final class P extends E {

    /* renamed from: e  reason: collision with root package name */
    P f28667e;

    /* renamed from: f  reason: collision with root package name */
    P f28668f;

    /* renamed from: g  reason: collision with root package name */
    P f28669g;

    /* renamed from: h  reason: collision with root package name */
    P f28670h;

    /* renamed from: i  reason: collision with root package name */
    boolean f28671i;

    P(int i11, Object obj, Object obj2, P p11, P p12) {
        super(i11, obj, obj2, p11);
        this.f28667e = p12;
    }

    /* access modifiers changed from: package-private */
    public final E a(int i11, Object obj) {
        return b(i11, obj, (Class) null);
    }

    /* access modifiers changed from: package-private */
    public final P b(int i11, Object obj, Class<?> cls) {
        int compareComparables;
        if (obj == null) {
            return null;
        }
        P p11 = this;
        do {
            P p12 = p11.f28668f;
            P p13 = p11.f28669g;
            int i12 = p11.f28631a;
            if (i12 <= i11) {
                if (i12 >= i11) {
                    Object obj2 = p11.f28632b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return p11;
                    }
                    if (p12 != null) {
                        if (p13 != null) {
                            if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                P b11 = p13.b(i11, obj, cls);
                                if (b11 != null) {
                                    return b11;
                                }
                            } else if (compareComparables >= 0) {
                                p12 = p13;
                            }
                        }
                    }
                }
                p11 = p13;
                continue;
            }
            p11 = p12;
            continue;
        } while (p11 != null);
        return null;
    }
}
