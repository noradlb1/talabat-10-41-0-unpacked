package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.function.ThrowingConsumer;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThrowingConsumer f57967a;

    public /* synthetic */ c0(ThrowingConsumer throwingConsumer) {
        this.f57967a = throwingConsumer;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DynamicTest.dynamicTest(((Named) obj).getName(), new b0(this.f57967a, (Named) obj));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
