package kotlinx.coroutines.rx2;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$awaitSingleOrNull$2$1", "Lio/reactivex/MaybeObserver;", "onComplete", "", "onError", "error", "", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onSuccess", "t", "(Ljava/lang/Object;)V", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAwaitKt$awaitSingleOrNull$2$1 implements MaybeObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f26291b;

    public RxAwaitKt$awaitSingleOrNull$2$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.f26291b = cancellableContinuation;
    }

    public void onComplete() {
        this.f26291b.resumeWith(Result.m6329constructorimpl((Object) null));
    }

    public void onError(@NotNull Throwable th2) {
        CancellableContinuation<T> cancellableContinuation = this.f26291b;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        RxAwaitKt.disposeOnCancellation(this.f26291b, disposable);
    }

    public void onSuccess(T t11) {
        this.f26291b.resumeWith(Result.m6329constructorimpl(t11));
    }
}
