package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "", "cause", "", "h", "exception", "", "e", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    public ActorCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z11) {
        super(coroutineContext, channel, false, z11);
        f((Job) coroutineContext.get(Job.Key));
    }

    public boolean e(@NotNull Throwable th2) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th2);
        return true;
    }

    public void h(@Nullable Throwable th2) {
        Channel n11 = n();
        CancellationException cancellationException = null;
        if (th2 != null) {
            if (th2 instanceof CancellationException) {
                cancellationException = (CancellationException) th2;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", th2);
            }
        }
        n11.cancel(cancellationException);
    }
}
