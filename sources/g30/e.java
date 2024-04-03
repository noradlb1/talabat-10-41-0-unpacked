package g30;

import j$.util.function.Predicate;
import org.junit.jupiter.api.extension.Extension;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62081a;

    public /* synthetic */ e(Class cls) {
        this.f62081a = cls;
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
        return this.f62081a.isInstance((Extension) obj);
    }
}
