package t30;

import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.internal.MockitoCore;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f63505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f63506b;

    public /* synthetic */ a(Function function, Class cls) {
        this.f63505a = function;
        this.f63506b = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MockitoCore.lambda$mockConstruction$0(this.f63505a, this.f63506b, (MockedConstruction.Context) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
