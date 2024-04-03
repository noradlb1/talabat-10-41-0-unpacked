package h10;

import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import io.reactivex.functions.Function;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24337b;

    public /* synthetic */ h(HomePresenter homePresenter) {
        this.f24337b = homePresenter;
    }

    public final Object apply(Object obj) {
        return this.f24337b.lambda$getBnplOverdue$0((OverdueAcknowledgeState) obj);
    }
}
