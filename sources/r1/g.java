package r1;

import androidx.core.util.Predicate;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f11608a;

    public /* synthetic */ g(Object obj) {
        this.f11608a = obj;
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
        return this.f11608a.equals(obj);
    }
}
