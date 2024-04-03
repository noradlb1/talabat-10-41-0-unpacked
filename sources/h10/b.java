package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24331b;

    public /* synthetic */ b(HomePresenter homePresenter) {
        this.f24331b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24331b.handleRatingBottomSheetError((Throwable) obj);
    }
}
