package p005if;

import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

/* renamed from: if.f  reason: invalid package */
public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f56902b;

    public /* synthetic */ f(SingleEmitter singleEmitter) {
        this.f56902b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f56902b.onError((Throwable) obj);
    }
}
