package com.google.android.play.integrity.internal;

public final class z implements ac {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f44605a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile ac f44606b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f44607c = f44605a;

    private z(ac acVar) {
        this.f44606b = acVar;
    }

    public static ac b(ac acVar) {
        acVar.getClass();
        if (acVar instanceof z) {
            return acVar;
        }
        return new z(acVar);
    }

    public final Object a() {
        Object obj = this.f44607c;
        Object obj2 = f44605a;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f44607c;
                if (obj == obj2) {
                    obj = this.f44606b.a();
                    Object obj3 = this.f44607c;
                    if (obj3 != obj2) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f44607c = obj;
                    this.f44606b = null;
                }
            }
        }
        return obj;
    }
}
