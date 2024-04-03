package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24341b;

    public /* synthetic */ l(HomePresenter homePresenter) {
        this.f24341b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24341b.lambda$showRatingBottomSheet$7((String) obj);
    }
}
