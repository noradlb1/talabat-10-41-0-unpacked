package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24339b;

    public /* synthetic */ j(HomePresenter homePresenter) {
        this.f24339b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24339b.trackUnExpectedScenario((Throwable) obj);
    }
}
