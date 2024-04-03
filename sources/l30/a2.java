package l30;

import j$.util.function.Function;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class a2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26462a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26463b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f26464c;

    public /* synthetic */ a2(String str, String str2, Class cls) {
        this.f26462a = str;
        this.f26463b = str2;
        this.f26464c = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ReflectionUtils.lambda$loadRequiredParameterType$24(this.f26462a, this.f26463b, this.f26464c, (Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
