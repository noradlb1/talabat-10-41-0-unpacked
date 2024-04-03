package l30;

import j$.util.function.Predicate;
import org.junit.platform.commons.util.ClassNamePatternFilterUtils;

public final /* synthetic */ class v implements Predicate {
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
        return ClassNamePatternFilterUtils.lambda$createPredicateFromPatterns$1(obj);
    }
}
