package b1;

import androidx.core.util.Predicate;
import r1.j;

public final /* synthetic */ class o implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f11570a;

    public /* synthetic */ o(String str) {
        this.f11570a = str;
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
        return this.f11570a.equals((String) obj);
    }
}
