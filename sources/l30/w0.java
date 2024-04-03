package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class w0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f26506a;

    public /* synthetic */ w0(List list) {
        this.f26506a = list;
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
        return ReflectionUtils.lambda$findAllFieldsInHierarchy$20(this.f26506a, (Field) obj);
    }
}
