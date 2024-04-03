package p10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28139b;

    public /* synthetic */ h(LoginInteractor loginInteractor) {
        this.f28139b = loginInteractor;
    }

    public final void accept(Object obj) {
        this.f28139b.lambda$requestOtp$3((Throwable) obj);
    }
}
