package kotlinx.coroutines.rx2;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$await$5$1", "Lio/reactivex/SingleObserver;", "onError", "", "error", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "t", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAwaitKt$await$5$1 implements SingleObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f26278b;

    public RxAwaitKt$await$5$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.f26278b = cancellableContinuation;
    }

    public void onError(@NotNull Throwable th2) {
        CancellableContinuation<T> cancellableContinuation = this.f26278b;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        RxAwaitKt.disposeOnCancellation(this.f26278b, disposable);
    }

    public void onSuccess(T t11) {
        this.f26278b.resumeWith(Result.m6329constructorimpl(t11));
    }
}
