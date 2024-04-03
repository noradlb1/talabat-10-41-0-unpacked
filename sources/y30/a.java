package y30;

import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.handler.MockHandlerFactory;
import org.mockito.mock.MockCreationSettings;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f63585a;

    public /* synthetic */ a(Function function) {
        this.f63585a = function;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MockHandlerFactory.createMockHandler((MockCreationSettings) this.f63585a.apply((MockedConstruction.Context) obj));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
