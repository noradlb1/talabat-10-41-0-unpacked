package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u00103\u001a\u000202\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u00104\u001a\u00020\u000e¢\u0006\u0004\b5\u00106J.\u0010\f\u001a\u00020\u00032#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0006H\u0001J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0001J\u001b\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\r\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010\u0019\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bJ\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000eH\u0014J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016R \u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u000e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R&\u0010-\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000*0)8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010(R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000*8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "handler", "invokeOnClose", "element", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "value", "o", "(Lkotlin/Unit;)V", "handled", "m", "close", "_channel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "n", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "isActive", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    @NotNull
    private final BroadcastChannel<E> _channel;

    public BroadcastCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull BroadcastChannel<E> broadcastChannel, boolean z11) {
        super(coroutineContext, false, z11);
        this._channel = broadcastChannel;
        f((Job) coroutineContext.get(Job.Key));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable th2) {
        if (th2 == null) {
            th2 = new JobCancellationException(b(), (Throwable) null, this);
        }
        cancelInternal(th2);
        return true;
    }

    public void cancelInternal(@NotNull Throwable th2) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th2, (String) null, 1, (Object) null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    public boolean close(@Nullable Throwable th2) {
        boolean close = this._channel.close(th2);
        start();
        return close;
    }

    @NotNull
    public SendChannel<E> getChannel() {
        return this;
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @ExperimentalCoroutinesApi
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    public void m(@NotNull Throwable th2, boolean z11) {
        if (!this._channel.close(th2) && !z11) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th2);
        }
    }

    @NotNull
    public final BroadcastChannel<E> n() {
        return this._channel;
    }

    /* renamed from: o */
    public void onCompleted(@NotNull Unit unit) {
        SendChannel.DefaultImpls.close$default(this._channel, (Throwable) null, 1, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e11) {
        return this._channel.offer(e11);
    }

    @NotNull
    public ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    @Nullable
    public Object send(E e11, @NotNull Continuation<? super Unit> continuation) {
        return this._channel.send(e11, continuation);
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m7791trySendJP2dKIU(E e11) {
        return this._channel.m7820trySendJP2dKIU(e11);
    }

    public final void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b(), (Throwable) null, this);
        }
        cancelInternal(cancellationException);
    }
}
