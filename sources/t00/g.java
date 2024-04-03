package t00;

import io.reactivex.disposables.Disposable;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.rx2.SchedulerCoroutineDispatcher;

public final /* synthetic */ class g implements DisposableHandle {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Disposable f28202b;

    public /* synthetic */ g(Disposable disposable) {
        this.f28202b = disposable;
    }

    public final void dispose() {
        SchedulerCoroutineDispatcher.m7862invokeOnTimeout$lambda2(this.f28202b);
    }
}
