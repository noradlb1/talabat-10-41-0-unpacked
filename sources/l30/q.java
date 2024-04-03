package l30;

import j$.util.function.Predicate;
import org.junit.platform.commons.util.StringUtils;

public final /* synthetic */ class q implements Predicate {
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
        return StringUtils.isNotBlank((String) obj);
    }
}
