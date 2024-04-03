package lj;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f57016b;

    public /* synthetic */ i(Observer observer) {
        this.f57016b = observer;
    }

    public final void accept(Object obj) {
        this.f57016b.onNext((Pair) obj);
    }
}
