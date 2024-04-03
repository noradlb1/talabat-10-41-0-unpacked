package s10;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.impl.LoginPresenter2Impl;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter2Impl f28181b;

    public /* synthetic */ a(LoginPresenter2Impl loginPresenter2Impl) {
        this.f28181b = loginPresenter2Impl;
    }

    public final void accept(Object obj) {
        LoginPresenter2Impl.m7907selectSavedAddressIfPossible$lambda0(this.f28181b, (Disposable) obj);
    }
}
