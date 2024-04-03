package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class y1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26511a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class[] f26512b;

    public /* synthetic */ y1(String str, Class[] clsArr) {
        this.f26511a = str;
        this.f26512b = clsArr;
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
        return ReflectionUtils.hasCompatibleSignature((Method) obj, this.f26511a, this.f26512b);
    }
}
