package d30;

import j$.util.function.Predicate;
import org.junit.jupiter.engine.descriptor.DynamicDescendantFilter;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class l0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicDescendantFilter f61887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UniqueId f61888b;

    public /* synthetic */ l0(DynamicDescendantFilter dynamicDescendantFilter, UniqueId uniqueId) {
        this.f61887a = dynamicDescendantFilter;
        this.f61888b = uniqueId;
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
        return this.f61887a.lambda$isUniqueIdAllowed$0(this.f61888b, (UniqueId) obj);
    }
}
