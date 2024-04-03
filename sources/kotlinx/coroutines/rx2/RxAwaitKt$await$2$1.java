package kotlinx.coroutines.rx2;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$await$2$1", "Lio/reactivex/CompletableObserver;", "onComplete", "", "onError", "e", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAwaitKt$await$2$1 implements CompletableObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f26277b;

    public RxAwaitKt$await$2$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f26277b = cancellableContinuation;
    }

    public void onComplete() {
        CancellableContinuation<Unit> cancellableContinuation = this.f26277b;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }

    public void onError(@NotNull Throwable th2) {
        CancellableContinuation<Unit> cancellableContinuation = this.f26277b;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        RxAwaitKt.disposeOnCancellation(this.f26277b, disposable);
    }
}
