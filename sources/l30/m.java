package l30;

import j$.util.function.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26488a;

    public /* synthetic */ m(Class cls) {
        this.f26488a = cls;
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
        return AnnotationUtils.isAnnotated((AnnotatedElement) (Field) obj, (Class<? extends Annotation>) this.f26488a);
    }
}
