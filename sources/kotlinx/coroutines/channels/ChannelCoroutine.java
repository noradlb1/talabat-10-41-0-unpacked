package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010>\u001a\u00020=\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010?\u001a\u00020\u0007\u0012\u0006\u0010@\u001a\u00020\u0007¢\u0006\u0004\bA\u0010BJ\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0001J.\u0010\r\u001a\u00020\u00032#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\tH\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0003J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017HAø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001a\u001a\u0004\u0018\u00018\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u0014J'\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0010\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u0016\u0010\"\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010#j\u0004\u0018\u0001`$J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R#\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170.8\u0016X\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u00100R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000.8VX\u0005¢\u0006\u0006\u001a\u0004\b4\u00100R&\u0010:\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000007068\u0016X\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b;\u0010)\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "", "cause", "", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive-PtdJZtk", "tryReceive", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "_channel", "Lkotlinx/coroutines/channels/Channel;", "n", "()Lkotlinx/coroutines/channels/Channel;", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "getOnReceiveOrNull", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getChannel", "channel", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    @NotNull
    private final Channel<E> _channel;

    public ChannelCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z11, boolean z12) {
        super(coroutineContext, z11, z12);
        this._channel = channel;
    }

    public final void cancel(@Nullable CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(b(), (Throwable) null, this);
            }
            cancelInternal(cancellationException);
        }
    }

    public void cancelInternal(@NotNull Throwable th2) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th2, (String) null, 1, (Object) null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    public boolean close(@Nullable Throwable th2) {
        return this._channel.close(th2);
    }

    @NotNull
    public final Channel<E> getChannel() {
        return this;
    }

    @NotNull
    public SelectClause1<E> getOnReceive() {
        return this._channel.getOnReceive();
    }

    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    @ExperimentalCoroutinesApi
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @NotNull
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @NotNull
    public final Channel<E> n() {
        return this._channel;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e11) {
        return this._channel.offer(e11);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return this._channel.poll();
    }

    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return this._channel.receive(continuation);
    }

    @Nullable
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object m7792receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        Object r22 = this._channel.m7817receiveCatchingJP2dKIU(continuation);
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r22;
    }

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return this._channel.receiveOrNull(continuation);
    }

    @Nullable
    public Object send(E e11, @NotNull Continuation<? super Unit> continuation) {
        return this._channel.send(e11, continuation);
    }

    @NotNull
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object m7793tryReceivePtdJZtk() {
        return this._channel.m7818tryReceivePtdJZtk();
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public Object m7794trySendJP2dKIU(E e11) {
        return this._channel.m7820trySendJP2dKIU(e11);
    }

    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(b(), (Throwable) null, this));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable th2) {
        cancelInternal(new JobCancellationException(b(), (Throwable) null, this));
        return true;
    }
}
