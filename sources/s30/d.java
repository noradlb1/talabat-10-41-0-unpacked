package s30;

import j$.util.function.Function;
import org.mockito.MockSettings;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MockSettings f24102a;

    public /* synthetic */ d(MockSettings mockSettings) {
        this.f24102a = mockSettings;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Mockito.lambda$mockConstruction$4(this.f24102a, (MockedConstruction.Context) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
