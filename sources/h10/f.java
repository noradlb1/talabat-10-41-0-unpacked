package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24335b;

    public /* synthetic */ f(HomePresenter homePresenter) {
        this.f24335b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24335b.lambda$setCartView$2((ActiveCartInfo) obj);
    }
}
