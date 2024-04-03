package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ClassUtils;

public final /* synthetic */ class x implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f26507a;

    public /* synthetic */ x(Function function) {
        this.f26507a = function;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ClassUtils.lambda$nullSafeToString$0(this.f26507a, (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
