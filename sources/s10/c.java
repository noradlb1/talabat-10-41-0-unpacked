package s10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import library.talabat.mvp.login.impl.LoginPresenter2Impl;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter2Impl f28183b;

    public /* synthetic */ c(LoginPresenter2Impl loginPresenter2Impl) {
        this.f28183b = loginPresenter2Impl;
    }

    public final void accept(Object obj) {
        this.f28183b.onSnapToExistingAddressSuccess((SelectSavedAddressIfCanDeliverToVendorUseCase.Result) obj);
    }
}
