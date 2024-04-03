package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;
import org.junit.platform.commons.util.AnnotationUtils;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26485a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f26486b;

    public /* synthetic */ l(Class cls, Class cls2) {
        this.f26485a = cls;
        this.f26486b = cls2;
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
        return AnnotationUtils.lambda$findPublicAnnotatedFields$5(this.f26485a, this.f26486b, (Field) obj);
    }
}
