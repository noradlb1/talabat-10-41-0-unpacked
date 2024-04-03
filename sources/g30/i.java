package g30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62085a;

    public /* synthetic */ i(ExtensionContext extensionContext) {
        this.f62085a = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62085a.getConfigurationParameter((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
