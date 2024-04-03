package h10;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.home.HomePresenter;

public final /* synthetic */ class d implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f24333b;

    public /* synthetic */ d(HomePresenter homePresenter) {
        this.f24333b = homePresenter;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f24333b.lambda$checkOnboardingFlowExperiement$4((CoroutineScope) obj, (Continuation) obj2);
    }
}
