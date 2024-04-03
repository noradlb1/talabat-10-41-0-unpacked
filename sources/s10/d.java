package s10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.impl.LoginPresenter2Impl;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter2Impl f28184b;

    public /* synthetic */ d(LoginPresenter2Impl loginPresenter2Impl) {
        this.f28184b = loginPresenter2Impl;
    }

    public final void accept(Object obj) {
        LoginPresenter2Impl.m7909selectSavedAddressIfPossible$lambda2(this.f28184b, (Throwable) obj);
    }
}
