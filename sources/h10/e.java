package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24334b;

    public /* synthetic */ e(HomePresenter homePresenter) {
        this.f24334b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24334b.lambda$checkOnboardingFlowExperiement$5((Boolean) obj);
    }
}
