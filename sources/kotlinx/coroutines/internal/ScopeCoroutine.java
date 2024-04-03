package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0012\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "", "state", "", "a", "l", "Lkotlin/coroutines/Continuation;", "uCont", "Lkotlin/coroutines/Continuation;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "", "g", "()Z", "isScopedCoroutine", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "parent", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {
    @NotNull
    @JvmField
    public final Continuation<T> uCont;

    public ScopeCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.uCont = continuation;
    }

    public void a(@Nullable Object obj) {
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont), CompletionStateKt.recoverResult(obj, this.uCont), (Function1) null, 2, (Object) null);
    }

    public final boolean g() {
        return true;
    }

    @Nullable
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public final Job getParent$kotlinx_coroutines_core() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public void l(@Nullable Object obj) {
        Continuation<T> continuation = this.uCont;
        continuation.resumeWith(CompletionStateKt.recoverResult(obj, continuation));
    }
}
