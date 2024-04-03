package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "", "trySuspend", "()Z", "tryResume", "", "state", "", "a", "(Ljava/lang/Object;)V", "l", "getResult", "()Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    @NotNull
    private volatile /* synthetic */ int _decision = 0;

    public DispatchedCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    private final boolean tryResume() {
        do {
            int i11 = this._decision;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean trySuspend() {
        do {
            int i11 = this._decision;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    public void a(@Nullable Object obj) {
        l(obj);
    }

    @Nullable
    public final Object getResult() {
        if (trySuspend()) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
        if (!(unboxState instanceof CompletedExceptionally)) {
            return unboxState;
        }
        throw ((CompletedExceptionally) unboxState).cause;
    }

    public void l(@Nullable Object obj) {
        if (!tryResume()) {
            DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont), CompletionStateKt.recoverResult(obj, this.uCont), (Function1) null, 2, (Object) null);
        }
    }
}
