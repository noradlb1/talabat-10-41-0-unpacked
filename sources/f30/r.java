package f30;

import j$.util.function.Predicate;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public final /* synthetic */ class r implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ParameterContext f62051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62052b;

    public /* synthetic */ r(ParameterContext parameterContext, ExtensionContext extensionContext) {
        this.f62051a = parameterContext;
        this.f62052b = extensionContext;
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
        return ((ParameterResolver) obj).supportsParameter(this.f62051a, this.f62052b);
    }
}
