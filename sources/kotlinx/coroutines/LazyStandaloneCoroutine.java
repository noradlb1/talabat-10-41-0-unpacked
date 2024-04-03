package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "", "j", "Lkotlin/coroutines/Continuation;", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    @NotNull
    private final Continuation<Unit> continuation;

    public LazyStandaloneCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.continuation = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    public void j() {
        CancellableKt.startCoroutineCancellable((Continuation<? super Unit>) this.continuation, (Continuation<?>) this);
    }
}
