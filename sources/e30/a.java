package e30;

import j$.util.function.Predicate;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f61965a;

    public /* synthetic */ a(Class cls) {
        this.f61965a = cls;
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
        return this.f61965a.isInstance((TestDescriptor) obj);
    }
}
