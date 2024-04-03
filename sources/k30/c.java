package k30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;
import org.junit.platform.commons.support.AnnotationSupport;

public final /* synthetic */ class c implements Predicate {
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
        return AnnotationSupport.lambda$findAnnotatedFields$0((Field) obj);
    }
}
