package l30;

import j$.util.function.Function;
import java.lang.reflect.Field;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class z0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f26514a;

    public /* synthetic */ z0(Object obj) {
        this.f26514a = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionUtils.lambda$getOuterInstance$12(this.f26514a, (Field) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
