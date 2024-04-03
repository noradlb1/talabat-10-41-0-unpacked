package s30;

import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Answer[] f24104a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Answer f24105b;

    public /* synthetic */ g(Answer[] answerArr, Answer answer) {
        this.f24104a = answerArr;
        this.f24105b = answer;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Mockito.lambda$mockConstructionWithAnswer$0(this.f24104a, this.f24105b, (MockedConstruction.Context) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
