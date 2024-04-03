package a10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.cart.CartPresenter;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartPresenter f24273b;

    public /* synthetic */ f(CartPresenter cartPresenter) {
        this.f24273b = cartPresenter;
    }

    public final void accept(Object obj) {
        this.f24273b.logError((Throwable) obj);
    }
}
