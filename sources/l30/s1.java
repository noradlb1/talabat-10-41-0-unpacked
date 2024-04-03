package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Field;

public final /* synthetic */ class s1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Field f26501a;

    public /* synthetic */ s1(Field field) {
        this.f26501a = field;
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
        return ((Field) obj).getName().equals(this.f26501a.getName());
    }
}
