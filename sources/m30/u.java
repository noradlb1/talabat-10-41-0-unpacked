package m30;

import j$.util.function.Predicate;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class u implements Predicate {
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
        return ((UniqueId.Segment) obj).getType().equals(UniqueId.ENGINE_SEGMENT_TYPE);
    }
}
