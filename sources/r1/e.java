package r1;

import androidx.core.util.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f11606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f11607b;

    public /* synthetic */ e(Predicate predicate, Predicate predicate2) {
        this.f11606a = predicate;
        this.f11607b = predicate2;
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
        return j.f(this.f11606a, this.f11607b, obj);
    }
}
