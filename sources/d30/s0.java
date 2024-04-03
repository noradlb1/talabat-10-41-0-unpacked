package d30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class s0 implements Predicate {
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
        return ReflectionUtils.isNotStatic((Member) (Field) obj);
    }
}
