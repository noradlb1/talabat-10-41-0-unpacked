package l30;

import j$.util.function.Function;
import java.lang.reflect.Field;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class t0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f26502a;

    public /* synthetic */ t0(Object obj) {
        this.f26502a = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionUtils.tryToReadFieldValue((Field) obj, this.f26502a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
