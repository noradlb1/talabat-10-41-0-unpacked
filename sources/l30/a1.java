package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class a1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f26460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26461b;

    public /* synthetic */ a1(Class cls, String str) {
        this.f26460a = cls;
        this.f26461b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionUtils.loadRequiredParameterType(this.f26460a, this.f26461b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
