package d30;

import j$.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public final /* synthetic */ class w1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61926a;

    public /* synthetic */ w1(ExtensionContext extensionContext) {
        this.f61926a = extensionContext;
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
        return ((TestTemplateInvocationContextProvider) obj).supportsTestTemplate(this.f61926a);
    }
}
