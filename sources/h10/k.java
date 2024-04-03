package h10;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class k implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24340b;

    public /* synthetic */ k(HomePresenter homePresenter) {
        this.f24340b = homePresenter;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f24340b.lambda$showRatingBottomSheet$6((CoroutineScope) obj, (Continuation) obj2);
    }
}
