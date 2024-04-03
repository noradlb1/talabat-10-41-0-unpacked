package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\u00042\f\b\u0002\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ+\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u001c0\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "lock", "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    @NotNull
    public List<FrameAwaiter<?>> awaiters;
    /* access modifiers changed from: private */
    @Nullable
    public Throwable failureCause;
    /* access modifiers changed from: private */
    @NotNull
    public final Object lock;
    /* access modifiers changed from: private */
    @Nullable
    public final Function0<Unit> onNewAwaiters;
    @NotNull
    private List<FrameAwaiter<?>> spareList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FrameAwaiter<R> {
        @NotNull
        private final Continuation<R> continuation;
        @NotNull
        private final Function1<Long, R> onFrame;

        public FrameAwaiter(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation2) {
            Intrinsics.checkNotNullParameter(function1, "onFrame");
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.onFrame = function1;
            this.continuation = continuation2;
        }

        @NotNull
        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        @NotNull
        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long j11) {
            Object obj;
            Continuation<R> continuation2 = this.continuation;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(this.onFrame.invoke(Long.valueOf(j11)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            continuation2.resumeWith(obj);
        }
    }

    public BroadcastFrameClock() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public BroadcastFrameClock(@Nullable Function0<Unit> function0) {
        this.onNewAwaiters = function0;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    /* access modifiers changed from: private */
    public final void fail(Throwable th2) {
        synchronized (this.lock) {
            if (this.failureCause == null) {
                this.failureCause = th2;
                List<FrameAwaiter<?>> list = this.awaiters;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Continuation continuation = list.get(i11).getContinuation();
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
                }
                this.awaiters.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void cancel(@NotNull CancellationException cancellationException) {
        Intrinsics.checkNotNullParameter(cancellationException, "cancellationException");
        fail(cancellationException);
    }

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return MonotonicFrameClock.DefaultImpls.fold(this, r11, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public final boolean getHasAwaiters() {
        boolean z11;
        synchronized (this.lock) {
            z11 = !this.awaiters.isEmpty();
        }
        return z11;
    }

    public /* synthetic */ CoroutineContext.Key getKey() {
        return c.a(this);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    public final void sendFrame(long j11) {
        synchronized (this.lock) {
            List<FrameAwaiter<?>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                list.get(i11).resume(j11);
            }
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public <R> Object withFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        boolean z11;
        FrameAwaiter frameAwaiter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            Throwable access$getFailureCause$p = this.failureCause;
            if (access$getFailureCause$p != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(access$getFailureCause$p)));
            } else {
                objectRef.element = new FrameAwaiter(function1, cancellableContinuationImpl);
                if (!this.awaiters.isEmpty()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                List access$getAwaiters$p = this.awaiters;
                T t11 = objectRef.element;
                if (t11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (FrameAwaiter) t11;
                }
                access$getAwaiters$p.add(frameAwaiter);
                boolean z12 = !z11;
                cancellableContinuationImpl.invokeOnCancellation(new BroadcastFrameClock$withFrameNanos$2$1(this, objectRef));
                if (z12 && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : function0);
    }
}
