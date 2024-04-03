package s10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.impl.LoginPresenter2Impl;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter2Impl f28182b;

    public /* synthetic */ b(LoginPresenter2Impl loginPresenter2Impl) {
        this.f28182b = loginPresenter2Impl;
    }

    public final void accept(Object obj) {
        LoginPresenter2Impl.m7908selectSavedAddressIfPossible$lambda1(this.f28182b, (Throwable) obj);
    }
}
