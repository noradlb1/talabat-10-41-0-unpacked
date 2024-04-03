package j00;

import io.reactivex.rxjava3.core.Observable;
import j$.util.function.Function;

public final /* synthetic */ class f implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Observable.just(obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
