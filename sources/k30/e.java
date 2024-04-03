package k30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;
import org.junit.platform.commons.support.AnnotationSupport;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f24355a;

    public /* synthetic */ e(Class cls) {
        this.f24355a = cls;
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
        return AnnotationSupport.lambda$findAnnotatedFieldValues$2(this.f24355a, (Field) obj);
    }
}
