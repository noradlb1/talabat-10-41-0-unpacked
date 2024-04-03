package r1;

import androidx.core.util.Predicate;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f11609a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f11610b;

    public /* synthetic */ h(Predicate predicate, Predicate predicate2) {
        this.f11609a = predicate;
        this.f11610b = predicate2;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return j.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return j.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return j.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return j.d(this.f11609a, this.f11610b, obj);
    }
}
