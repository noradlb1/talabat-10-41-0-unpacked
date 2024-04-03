package a10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.cart.CartPresenter;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartPresenter f24271b;

    public /* synthetic */ c(CartPresenter cartPresenter) {
        this.f24271b = cartPresenter;
    }

    public final void accept(Object obj) {
        this.f24271b.handleErrorFromSelectSavedAddress((Throwable) obj);
    }
}
