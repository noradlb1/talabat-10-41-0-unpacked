package a10;

import io.reactivex.functions.Action;
import library.talabat.mvp.cart.CartPresenter;

public final /* synthetic */ class h implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartPresenter f24274b;

    public /* synthetic */ h(CartPresenter cartPresenter) {
        this.f24274b = cartPresenter;
    }

    public final void run() {
        this.f24274b.stopProgress();
    }
}
