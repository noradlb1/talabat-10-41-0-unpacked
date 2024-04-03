package r1;

import androidx.core.util.Predicate;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f11611a;

    public /* synthetic */ i(Predicate predicate) {
        this.f11611a = predicate;
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
        return j.e(this.f11611a, obj);
    }
}
