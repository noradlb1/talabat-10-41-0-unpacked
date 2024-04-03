package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J+\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\b0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "choreographer", "Landroid/view/Choreographer;", "(Landroid/view/Choreographer;)V", "getChoreographer", "()Landroid/view/Choreographer;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    @NotNull
    private final Choreographer choreographer;

    public AndroidUiFrameClock(@NotNull Choreographer choreographer2) {
        Intrinsics.checkNotNullParameter(choreographer2, "choreographer");
        this.choreographer = choreographer2;
    }

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return MonotonicFrameClock.DefaultImpls.fold(this, r11, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @NotNull
    public final Choreographer getChoreographer() {
        return this.choreographer;
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

    @Nullable
    public <R> Object withFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        AndroidUiDispatcher androidUiDispatcher;
        CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.Key);
        if (element instanceof AndroidUiDispatcher) {
            androidUiDispatcher = (AndroidUiDispatcher) element;
        } else {
            androidUiDispatcher = null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AndroidUiFrameClock$withFrameNanos$2$callback$1 androidUiFrameClock$withFrameNanos$2$callback$1 = new AndroidUiFrameClock$withFrameNanos$2$callback$1(cancellableContinuationImpl, this, function1);
        if (androidUiDispatcher == null || !Intrinsics.areEqual((Object) androidUiDispatcher.getChoreographer(), (Object) getChoreographer())) {
            getChoreographer().postFrameCallback(androidUiFrameClock$withFrameNanos$2$callback$1);
            cancellableContinuationImpl.invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$2(this, androidUiFrameClock$withFrameNanos$2$callback$1));
        } else {
            androidUiDispatcher.postFrameCallback$ui_release(androidUiFrameClock$withFrameNanos$2$callback$1);
            cancellableContinuationImpl.invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$1(androidUiDispatcher, androidUiFrameClock$withFrameNanos$2$callback$1));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
