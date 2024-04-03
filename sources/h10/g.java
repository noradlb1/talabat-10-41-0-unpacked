package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24336b;

    public /* synthetic */ g(HomePresenter homePresenter) {
        this.f24336b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24336b.lambda$setCartView$3((Throwable) obj);
    }
}
