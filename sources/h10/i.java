package h10;

import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import io.reactivex.functions.Consumer;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24338b;

    public /* synthetic */ i(HomePresenter homePresenter) {
        this.f24338b = homePresenter;
    }

    public final void accept(Object obj) {
        this.f24338b.lambda$getBnplOverdue$1((GetOverdueUseCase.OverdueResult) obj);
    }
}
