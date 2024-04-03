package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\n\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/datastore/core/SimpleActor;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onComplete", "Lkotlin/Function1;", "", "", "onUndeliveredElement", "Lkotlin/Function2;", "consumeMessage", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "messageQueue", "Lkotlinx/coroutines/channels/Channel;", "remainingMessages", "Ljava/util/concurrent/atomic/AtomicInteger;", "offer", "msg", "(Ljava/lang/Object;)V", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SimpleActor<T> {
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<T, Continuation<? super Unit>, Object> consumeMessage;
    /* access modifiers changed from: private */
    @NotNull
    public final Channel<T> messageQueue = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public final AtomicInteger remainingMessages = new AtomicInteger(0);
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope scope;

    public SimpleActor(@NotNull CoroutineScope coroutineScope, @NotNull final Function1<? super Throwable, Unit> function1, @NotNull final Function2<? super T, ? super Throwable, Unit> function2, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function22) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        Intrinsics.checkNotNullParameter(function2, "onUndeliveredElement");
        Intrinsics.checkNotNullParameter(function22, "consumeMessage");
        this.scope = coroutineScope;
        this.consumeMessage = function22;
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.invokeOnCompletion(new Function1<Throwable, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Throwable th2) {
                    Unit unit;
                    function1.invoke(th2);
                    this.messageQueue.close(th2);
                    do {
                        Object r02 = ChannelResult.m7804getOrNullimpl(this.messageQueue.m7818tryReceivePtdJZtk());
                        if (r02 == null) {
                            unit = null;
                            continue;
                        } else {
                            function2.invoke(r02, th2);
                            unit = Unit.INSTANCE;
                            continue;
                        }
                    } while (unit != null);
                }
            });
        }
    }

    public final void offer(T t11) {
        Object r72 = this.messageQueue.m7820trySendJP2dKIU(t11);
        if (r72 instanceof ChannelResult.Closed) {
            Throwable r73 = ChannelResult.m7803exceptionOrNullimpl(r72);
            if (r73 == null) {
                r73 = new ClosedSendChannelException("Channel was closed normally");
            }
            throw r73;
        } else if (!ChannelResult.m7809isSuccessimpl(r72)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.remainingMessages.getAndIncrement() == 0) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new SimpleActor$offer$2(this, (Continuation<? super SimpleActor$offer$2>) null), 3, (Object) null);
        }
    }
}
