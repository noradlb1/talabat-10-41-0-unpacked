package h10;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;
import library.talabat.mvp.home.domain.ShouldShowLocationSelectionInHomeUseCase;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24330b;

    public /* synthetic */ a(HomePresenter homePresenter) {
        this.f24330b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24330b.lambda$showLocationSelectionScreen$8((ShouldShowLocationSelectionInHomeUseCase.Result) obj);
    }
}
