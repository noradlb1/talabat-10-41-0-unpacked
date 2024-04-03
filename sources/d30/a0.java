package d30;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.execution.DefaultTestInstances;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f61826a;

    public /* synthetic */ a0(Object obj) {
        this.f61826a = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DefaultTestInstances.of((TestInstances) obj, this.f61826a);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
