package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Constructor;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class g1 implements Predicate {
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
        return ReflectionUtils.lambda$getDeclaredConstructor$16((Constructor) obj);
    }
}
