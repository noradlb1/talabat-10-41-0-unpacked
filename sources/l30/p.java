package l30;

import j$.util.function.Predicate;
import java.util.regex.Pattern;

public final /* synthetic */ class p implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f26495a;

    public /* synthetic */ p(Object obj) {
        this.f26495a = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return ((Pattern) obj).matcher(this.f26495a.getClass().getName()).matches();
    }
}
