package kotlinx.coroutines.rx2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$awaitOne$2$1", "Lio/reactivex/Observer;", "seenValue", "", "subscription", "Lio/reactivex/disposables/Disposable;", "value", "Ljava/lang/Object;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onSubscribe", "sub", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxAwaitKt$awaitOne$2$1 implements Observer<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f26282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Mode f26283c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ T f26284d;
    private boolean seenValue;
    private Disposable subscription;
    @Nullable
    private T value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            iArr[Mode.FIRST.ordinal()] = 1;
            iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
            iArr[Mode.LAST.ordinal()] = 3;
            iArr[Mode.SINGLE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RxAwaitKt$awaitOne$2$1(CancellableContinuation<? super T> cancellableContinuation, Mode mode, T t11) {
        this.f26282b = cancellableContinuation;
        this.f26283c = mode;
        this.f26284d = t11;
    }

    public void onComplete() {
        if (this.seenValue) {
            if (this.f26282b.isActive()) {
                CancellableContinuation<T> cancellableContinuation = this.f26282b;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(this.value));
            }
        } else if (this.f26283c == Mode.FIRST_OR_DEFAULT) {
            CancellableContinuation<T> cancellableContinuation2 = this.f26282b;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m6329constructorimpl(this.f26284d));
        } else if (this.f26282b.isActive()) {
            CancellableContinuation<T> cancellableContinuation3 = this.f26282b;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation3.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.f26283c))));
        }
    }

    public void onError(@NotNull Throwable th2) {
        CancellableContinuation<T> cancellableContinuation = this.f26282b;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }

    public void onNext(T t11) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.f26283c.ordinal()];
        Disposable disposable = null;
        if (i11 == 1 || i11 == 2) {
            if (!this.seenValue) {
                this.seenValue = true;
                this.f26282b.resumeWith(Result.m6329constructorimpl(t11));
                Disposable disposable2 = this.subscription;
                if (disposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscription");
                } else {
                    disposable = disposable2;
                }
                disposable.dispose();
            }
        } else if (i11 != 3 && i11 != 4) {
        } else {
            if (this.f26283c != Mode.SINGLE || !this.seenValue) {
                this.value = t11;
                this.seenValue = true;
                return;
            }
            if (this.f26282b.isActive()) {
                CancellableContinuation<T> cancellableContinuation = this.f26282b;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.f26283c))));
            }
            Disposable disposable3 = this.subscription;
            if (disposable3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscription");
            } else {
                disposable = disposable3;
            }
            disposable.dispose();
        }
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        this.subscription = disposable;
        this.f26282b.invokeOnCancellation(new RxAwaitKt$awaitOne$2$1$onSubscribe$1(disposable));
    }
}
