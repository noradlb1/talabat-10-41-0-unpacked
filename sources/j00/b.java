package j00;

import io.reactivex.rxjava3.core.Flowable;
import j$.util.function.Function;

public final /* synthetic */ class b implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Flowable.just(obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
