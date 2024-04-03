package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public final /* synthetic */ class y1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61930a;

    public /* synthetic */ y1(ExtensionContext extensionContext) {
        this.f61930a = extensionContext;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestTemplateInvocationContextProvider) obj).provideTestTemplateInvocationContexts(this.f61930a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
