package s30;

import j$.util.function.Function;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MockSettings f24103a;

    public /* synthetic */ e(MockSettings mockSettings) {
        this.f24103a = mockSettings;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Mockito.lambda$mockConstruction$6(this.f24103a, (MockedConstruction.Context) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
