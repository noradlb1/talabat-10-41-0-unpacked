package p10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.login.LoginInteractor;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginInteractor f28132b;

    public /* synthetic */ b(LoginInteractor loginInteractor) {
        this.f28132b = loginInteractor;
    }

    public final void accept(Object obj) {
        this.f28132b.lambda$loadCustomerDetailsFromMicroservice$7((Throwable) obj);
    }
}
