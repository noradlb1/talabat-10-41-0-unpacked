package kotlinx.coroutines.reactive;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0019"}, d2 = {"kotlinx/coroutines/reactive/AwaitKt$awaitOne$2$1", "Lorg/reactivestreams/Subscriber;", "inTerminalState", "", "seenValue", "subscription", "Lorg/reactivestreams/Subscription;", "value", "Ljava/lang/Object;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onSubscribe", "sub", "tryEnterTerminalState", "signalName", "", "withSubscriptionLock", "block", "Lkotlin/Function0;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AwaitKt$awaitOne$2$1 implements Subscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f26206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Mode f26207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ T f26208d;
    private boolean inTerminalState;
    private boolean seenValue;
    @Nullable
    private Subscription subscription;
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
            iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AwaitKt$awaitOne$2$1(CancellableContinuation<? super T> cancellableContinuation, Mode mode, T t11) {
        this.f26206b = cancellableContinuation;
        this.f26207c = mode;
        this.f26208d = t11;
    }

    private final boolean tryEnterTerminalState(String str) {
        if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(this.f26206b.getContext(), str);
            return false;
        }
        this.inTerminalState = true;
        return true;
    }

    /* access modifiers changed from: private */
    public final synchronized void withSubscriptionLock(Function0<Unit> function0) {
        function0.invoke();
    }

    public void onComplete() {
        if (tryEnterTerminalState("onComplete")) {
            if (this.seenValue) {
                Mode mode = this.f26207c;
                if (mode != Mode.FIRST_OR_DEFAULT && mode != Mode.FIRST && this.f26206b.isActive()) {
                    CancellableContinuation<T> cancellableContinuation = this.f26206b;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m6329constructorimpl(this.value));
                    return;
                }
                return;
            }
            Mode mode2 = this.f26207c;
            if (mode2 == Mode.FIRST_OR_DEFAULT || mode2 == Mode.SINGLE_OR_DEFAULT) {
                CancellableContinuation<T> cancellableContinuation2 = this.f26206b;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m6329constructorimpl(this.f26208d));
            } else if (this.f26206b.isActive()) {
                CancellableContinuation<T> cancellableContinuation3 = this.f26206b;
                Result.Companion companion3 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.f26207c))));
            }
        }
    }

    public void onError(@NotNull Throwable th2) {
        if (tryEnterTerminalState("onError")) {
            CancellableContinuation<T> cancellableContinuation = this.f26206b;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
        }
    }

    public void onNext(T t11) {
        Subscription subscription2 = this.subscription;
        CancellableContinuation<T> cancellableContinuation = this.f26206b;
        if (subscription2 == null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
        } else if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(cancellableContinuation.getContext(), "onNext");
        } else {
            int i11 = WhenMappings.$EnumSwitchMapping$0[this.f26207c.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (this.seenValue) {
                    AwaitKt.moreThanOneValueProvidedException(this.f26206b.getContext(), this.f26207c);
                    return;
                }
                this.seenValue = true;
                withSubscriptionLock(new AwaitKt$awaitOne$2$1$onNext$1(subscription2));
                this.f26206b.resumeWith(Result.m6329constructorimpl(t11));
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                Mode mode = this.f26207c;
                if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.seenValue) {
                    withSubscriptionLock(new AwaitKt$awaitOne$2$1$onNext$2(subscription2));
                    if (this.f26206b.isActive()) {
                        CancellableContinuation<T> cancellableContinuation2 = this.f26206b;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation2.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.f26207c))));
                        return;
                    }
                    return;
                }
                this.value = t11;
                this.seenValue = true;
            }
        }
    }

    public void onSubscribe(@NotNull Subscription subscription2) {
        if (this.subscription != null) {
            withSubscriptionLock(new AwaitKt$awaitOne$2$1$onSubscribe$1(subscription2));
            return;
        }
        this.subscription = subscription2;
        this.f26206b.invokeOnCancellation(new AwaitKt$awaitOne$2$1$onSubscribe$2(this, subscription2));
        withSubscriptionLock(new AwaitKt$awaitOne$2$1$onSubscribe$3(subscription2, this.f26207c));
    }
}
