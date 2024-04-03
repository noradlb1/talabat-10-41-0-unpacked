package x20;

import j$.util.function.Function;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.function.ThrowingConsumer;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f57962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowingConsumer f57963b;

    public /* synthetic */ a0(Function function, ThrowingConsumer throwingConsumer) {
        this.f57962a = function;
        this.f57963b = throwingConsumer;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DynamicTest.dynamicTest((String) this.f57962a.apply(obj), new z(this.f57963b, obj));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
