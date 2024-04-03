package a10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.cart.CartPresenter;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartPresenter f24270b;

    public /* synthetic */ b(CartPresenter cartPresenter) {
        this.f24270b = cartPresenter;
    }

    public final void accept(Object obj) {
        this.f24270b.handleResultFromSelectSavedAddress((SelectSavedAddressIfCanDeliverToVendorUseCase.Result) obj);
    }
}
