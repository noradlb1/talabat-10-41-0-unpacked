package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007WXYZ[\\]B)\u0012 \u0010T\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0018\u00010Rj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`S¢\u0006\u0004\bU\u0010VJ!\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002JT\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JZ\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u0004* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u0019\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2$\u0010\u0012\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\u00132\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0014J\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00102\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014J\u0013\u0010\n\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010 J\u0016\u0010!\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014J\"\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\"H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010 J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010*\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0007J\u0016\u0010*\u001a\u00020\u00132\u000e\u0010)\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,J\u0019\u0010/\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0004\b-\u0010.J\u0010\u00101\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u000bH\u0014J/\u00107\u001a\u00020\u00132\f\u00104\u001a\b\u0012\u0004\u0012\u000203022\n\u00106\u001a\u0006\u0012\u0002\b\u000305H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0004J\u0010\u0010>\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010=H\u0014J\b\u0010?\u001a\u00020\u0013H\u0014J\b\u0010@\u001a\u00020\u0013H\u0014R\u0014\u0010C\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0014\u0010G\u001a\u00020\u000b8DX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0014\u0010H\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010BR\u0014\u0010I\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010BR\u0014\u0010K\u001a\u00020\u000b8DX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010BR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0L8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\bP\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006^"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "R", "", "receiveMode", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "enqueueReceive", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "value", "tryStartBlockUnintercepted", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "enqueueReceiveSelect", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "removeReceiveOnCancel", "v", "w", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "o", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "", "cause", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "cancelInternal", "wasClosed", "t", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "u", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "n", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "l", "onReceiveEnqueued", "onReceiveDequeued", "q", "()Z", "isBufferAlwaysEmpty", "r", "isBufferEmpty", "p", "hasReceiveOrClosed", "isClosedForReceive", "isEmpty", "s", "isEmptyImpl", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\rHBø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u0010\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Itr<E> implements ChannelIterator<E> {
        @NotNull
        @JvmField
        public final AbstractChannel<E> channel;
        @Nullable
        private Object result = AbstractChannelKt.POLL_FAILED;

        public Itr(@NotNull AbstractChannel<E> abstractChannel) {
            this.channel = abstractChannel;
        }

        private final boolean hasNextResult(Object obj) {
            if (!(obj instanceof Closed)) {
                return true;
            }
            Closed closed = (Closed) obj;
            if (closed.closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
        }

        /* access modifiers changed from: private */
        public final Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            Function1<Throwable, Unit> function1;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, orCreateCancellableContinuation);
            while (true) {
                if (this.channel.enqueueReceive(receiveHasNext)) {
                    this.channel.removeReceiveOnCancel(orCreateCancellableContinuation, receiveHasNext);
                    break;
                }
                Object v11 = this.channel.v();
                setResult(v11);
                if (v11 instanceof Closed) {
                    Closed closed = (Closed) v11;
                    if (closed.closeCause == null) {
                        Result.Companion companion = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m6329constructorimpl(Boxing.boxBoolean(false)));
                    } else {
                        Result.Companion companion2 = Result.Companion;
                        orCreateCancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
                    }
                } else if (v11 != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean = Boxing.boxBoolean(true);
                    Function1<E, Unit> function12 = this.channel.f25156b;
                    if (function12 != null) {
                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, v11, orCreateCancellableContinuation.getContext());
                    } else {
                        function1 = null;
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, function1);
                }
            }
            Object result2 = orCreateCancellableContinuation.getResult();
            if (result2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result2;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            Object obj = this.result;
            Symbol symbol = AbstractChannelKt.POLL_FAILED;
            if (obj != symbol) {
                return Boxing.boxBoolean(hasNextResult(obj));
            }
            Object v11 = this.channel.v();
            this.result = v11;
            if (v11 != symbol) {
                return Boxing.boxBoolean(hasNextResult(v11));
            }
            return hasNextSuspend(continuation);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final void setResult(@Nullable Object obj) {
            this.result = obj;
        }

        public E next() {
            E e11 = this.result;
            if (!(e11 instanceof Closed)) {
                E e12 = AbstractChannelKt.POLL_FAILED;
                if (e11 != e12) {
                    this.result = e12;
                    return e11;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) e11).getReceiveException());
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class ReceiveElement<E> extends Receive<E> {
        @NotNull
        @JvmField
        public final CancellableContinuation<Object> cont;
        @JvmField
        public final int receiveMode;

        public ReceiveElement(@NotNull CancellableContinuation<Object> cancellableContinuation, int i11) {
            this.cont = cancellableContinuation;
            this.receiveMode = i11;
        }

        public void completeResumeReceive(E e11) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            if (this.receiveMode == 1) {
                this.cont.resumeWith(Result.m6329constructorimpl(ChannelResult.m7799boximpl(ChannelResult.Companion.m7812closedJP2dKIU(closed.closeCause))));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation = this.cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(closed.getReceiveException())));
        }

        @Nullable
        public final Object resumeValue(E e11) {
            if (this.receiveMode == 1) {
                return ChannelResult.m7799boximpl(ChannelResult.Companion.m7814successJP2dKIU(e11));
            }
            return e11;
        }

        @NotNull
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + AbstractJsonLexerKt.END_LIST;
        }

        @Nullable
        public Symbol tryResumeReceive(E e11, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Object> cancellableContinuation = this.cont;
            Object resumeValue = resumeValue(e11);
            if (prepareOp != null) {
                abstractAtomicDesc = prepareOp.desc;
            } else {
                abstractAtomicDesc = null;
            }
            if (cancellableContinuation.tryResume(resumeValue, abstractAtomicDesc, resumeOnCancellationFun(e11)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", "", "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        @NotNull
        @JvmField
        public final Function1<E, Unit> onUndeliveredElement;

        public ReceiveElementWithUndeliveredHandler(@NotNull CancellableContinuation<Object> cancellableContinuation, int i11, @NotNull Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i11);
            this.onUndeliveredElement = function1;
        }

        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e11) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, e11, this.cont.getContext());
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class ReceiveHasNext<E> extends Receive<E> {
        @NotNull
        @JvmField
        public final CancellableContinuation<Boolean> cont;
        @NotNull
        @JvmField
        public final Itr<E> iterator;

        public ReceiveHasNext(@NotNull Itr<E> itr, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.iterator = itr;
            this.cont = cancellableContinuation;
        }

        public void completeResumeReceive(E e11) {
            this.iterator.setResult(e11);
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e11) {
            Function1<E, Unit> function1 = this.iterator.channel.f25156b;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, e11, this.cont.getContext());
            }
            return null;
        }

        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            Object obj;
            if (closed.closeCause == null) {
                obj = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Boolean.FALSE, (Object) null, 2, (Object) null);
            } else {
                obj = this.cont.tryResumeWithException(closed.getReceiveException());
            }
            if (obj != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(obj);
            }
        }

        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + DebugStringsKt.getHexAddress(this);
        }

        @Nullable
        public Symbol tryResumeReceive(E e11, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
            CancellableContinuation<Boolean> cancellableContinuation = this.cont;
            Boolean bool = Boolean.TRUE;
            if (prepareOp != null) {
                abstractAtomicDesc = prepareOp.desc;
            } else {
                abstractAtomicDesc = null;
            }
            if (cancellableContinuation.tryResume(bool, abstractAtomicDesc, resumeOnCancellationFun(e11)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u00122\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00028\u00022\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#R3\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "value", "(Ljava/lang/Object;)V", "dispose", "resumeOnCancellationFun", "Lkotlin/Function1;", "", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        @NotNull
        @JvmField
        public final Function2<Object, Continuation<? super R>, Object> block;
        @NotNull
        @JvmField
        public final AbstractChannel<E> channel;
        @JvmField
        public final int receiveMode;
        @NotNull
        @JvmField
        public final SelectInstance<R> select;

        public ReceiveSelect(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i11) {
            this.channel = abstractChannel;
            this.select = selectInstance;
            this.block = function2;
            this.receiveMode = i11;
        }

        public void completeResumeReceive(E e11) {
            E e12;
            Function2<Object, Continuation<? super R>, Object> function2 = this.block;
            if (this.receiveMode == 1) {
                e12 = ChannelResult.m7799boximpl(ChannelResult.Companion.m7814successJP2dKIU(e11));
            } else {
                e12 = e11;
            }
            CancellableKt.startCoroutineCancellable(function2, e12, this.select.getCompletion(), resumeOnCancellationFun(e11));
        }

        public void dispose() {
            if (remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Nullable
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e11) {
            Function1<E, Unit> function1 = this.channel.f25156b;
            if (function1 != null) {
                return OnUndeliveredElementKt.bindCancellationFun(function1, e11, this.select.getCompletion().getContext());
            }
            return null;
        }

        public void resumeReceiveClosed(@NotNull Closed<?> closed) {
            if (this.select.trySelect()) {
                int i11 = this.receiveMode;
                if (i11 == 0) {
                    this.select.resumeSelectWithException(closed.getReceiveException());
                } else if (i11 == 1) {
                    CancellableKt.startCoroutineCancellable$default(this.block, ChannelResult.m7799boximpl(ChannelResult.Companion.m7812closedJP2dKIU(closed.closeCause)), this.select.getCompletion(), (Function1) null, 4, (Object) null);
                }
            }
        }

        @NotNull
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.getHexAddress(this) + '[' + this.select + ",receiveMode=" + this.receiveMode + AbstractJsonLexerKt.END_LIST;
        }

        @Nullable
        public Symbol tryResumeReceive(E e11, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.select.trySelectOther(prepareOp);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        @NotNull
        private final Receive<?> receive;

        public RemoveReceiveOnCancel(@NotNull Receive<?> receive2) {
            this.receive = receive2;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + AbstractJsonLexerKt.END_LIST;
        }

        public void invoke(@Nullable Throwable th2) {
            if (this.receive.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "", "onRemoved", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        @Nullable
        public Object a(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof Send)) {
                return AbstractChannelKt.POLL_FAILED;
            }
            return null;
        }

        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeSend = ((Send) prepareOp.affected).tryResumeSend(prepareOp);
            if (tryResumeSend == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeSend == obj) {
                return obj;
            }
            return null;
        }

        public void onRemoved(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((Send) lockFreeLinkedListNode).undeliveredElement();
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean o11 = o(receive);
        if (o11) {
            onReceiveEnqueued();
        }
        return o11;
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i11) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i11);
        boolean enqueueReceive = enqueueReceive(receiveSelect);
        if (enqueueReceive) {
            selectInstance.disposeOnSelect(receiveSelect);
        }
        return enqueueReceive;
    }

    /* access modifiers changed from: private */
    public final <R> Object receiveSuspend(int i11, Continuation<? super R> continuation) {
        ReceiveElement receiveElement;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (this.f25156b == null) {
            receiveElement = new ReceiveElement(orCreateCancellableContinuation, i11);
        } else {
            receiveElement = new ReceiveElementWithUndeliveredHandler(orCreateCancellableContinuation, i11, this.f25156b);
        }
        while (true) {
            if (!enqueueReceive(receiveElement)) {
                Object v11 = v();
                if (!(v11 instanceof Closed)) {
                    if (v11 != AbstractChannelKt.POLL_FAILED) {
                        orCreateCancellableContinuation.resume(receiveElement.resumeValue(v11), receiveElement.resumeOnCancellationFun(v11));
                        break;
                    }
                } else {
                    receiveElement.resumeReceiveClosed((Closed) v11);
                    break;
                }
            } else {
                removeReceiveOnCancel(orCreateCancellableContinuation, receiveElement);
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectReceiveMode(SelectInstance<? super R> selectInstance, int i11, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!s()) {
                Object w11 = w(selectInstance);
                if (w11 != SelectKt.getALREADY_SELECTED()) {
                    if (!(w11 == AbstractChannelKt.POLL_FAILED || w11 == AtomicKt.RETRY_ATOMIC)) {
                        tryStartBlockUnintercepted(function2, selectInstance, i11, w11);
                    }
                } else {
                    return;
                }
            } else if (enqueueReceiveSelect(selectInstance, function2, i11)) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    private final <R> void tryStartBlockUnintercepted(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i11, Object obj) {
        Object obj2;
        boolean z11 = obj instanceof Closed;
        if (z11) {
            if (i11 == 0) {
                throw StackTraceRecoveryKt.recoverStackTrace(((Closed) obj).getReceiveException());
            } else if (i11 == 1 && selectInstance.trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m7799boximpl(ChannelResult.Companion.m7812closedJP2dKIU(((Closed) obj).closeCause)), selectInstance.getCompletion());
            }
        } else if (i11 == 1) {
            ChannelResult.Companion companion = ChannelResult.Companion;
            if (z11) {
                obj2 = companion.m7812closedJP2dKIU(((Closed) obj).closeCause);
            } else {
                obj2 = companion.m7814successJP2dKIU(obj);
            }
            UndispatchedKt.startCoroutineUnintercepted(function2, ChannelResult.m7799boximpl(obj2), selectInstance.getCompletion());
        } else {
            UndispatchedKt.startCoroutineUnintercepted(function2, obj, selectInstance.getCompletion());
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    /* renamed from: cancelInternal$kotlinx_coroutines_core */
    public final boolean cancel(@Nullable Throwable th2) {
        boolean close = close(th2);
        t(close);
        return close;
    }

    @NotNull
    public final SelectClause1<E> getOnReceive() {
        return new AbstractChannel$onReceive$1(this);
    }

    @NotNull
    public final SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return new AbstractChannel$onReceiveCatching$1(this);
    }

    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return Channel.DefaultImpls.getOnReceiveOrNull(this);
    }

    public boolean isClosedForReceive() {
        return e() != null && r();
    }

    public boolean isEmpty() {
        return s();
    }

    @NotNull
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    @Nullable
    public ReceiveOrClosed<E> l() {
        ReceiveOrClosed<E> l11 = super.l();
        if (l11 != null && !(l11 instanceof Closed)) {
            onReceiveDequeued();
        }
        return l11;
    }

    @NotNull
    public final TryPollDesc<E> n() {
        return new TryPollDesc<>(g());
    }

    public boolean o(@NotNull Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (q()) {
            LockFreeLinkedListHead g11 = g();
            do {
                prevNode = g11.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, g11));
        } else {
            LockFreeLinkedListHead g12 = g();
            AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 = new AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(receive, this);
            do {
                LockFreeLinkedListNode prevNode2 = g12.getPrevNode();
                if (!(!(prevNode2 instanceof Send))) {
                    return false;
                }
                tryCondAddNext = prevNode2.tryCondAddNext(receive, g12, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1);
                if (tryCondAddNext != 1) {
                }
            } while (tryCondAddNext != 2);
            return false;
        }
        return true;
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    public final boolean p() {
        return g().getNextNode() instanceof ReceiveOrClosed;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    public abstract boolean q();

    public abstract boolean r();

    @Nullable
    public final Object receive(@NotNull Continuation<? super E> continuation) {
        Object v11 = v();
        if (v11 == AbstractChannelKt.POLL_FAILED || (v11 instanceof Closed)) {
            return receiveSuspend(0, continuation);
        }
        return v11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m7788receiveCatchingJP2dKIU(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.f25155j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25155j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f25153h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25155j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.v()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r5 == r2) goto L_0x0052
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.closeCause
            java.lang.Object r5 = r0.m7812closedJP2dKIU(r5)
            goto L_0x0051
        L_0x004b:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r5 = r0.m7814successJP2dKIU(r5)
        L_0x0051:
            return r5
        L_0x0052:
            r0.f25155j = r3
            java.lang.Object r5 = r4.receiveSuspend(r3, r0)
            if (r5 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.m7811unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.m7788receiveCatchingJP2dKIU(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final boolean s() {
        return !(g().getNextNode() instanceof Send) && r();
    }

    public void t(boolean z11) {
        Closed<?> f11 = f();
        if (f11 != null) {
            Object r02 = InlineList.m7835constructorimpl$default((Object) null, 1, (DefaultConstructorMarker) null);
            while (true) {
                LockFreeLinkedListNode prevNode = f11.getPrevNode();
                if (prevNode instanceof LockFreeLinkedListHead) {
                    u(r02, f11);
                    return;
                } else if (!prevNode.remove()) {
                    prevNode.helpRemove();
                } else {
                    r02 = InlineList.m7840plusFjFbRPM(r02, (Send) prevNode);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    @NotNull
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public final Object m7789tryReceivePtdJZtk() {
        Object v11 = v();
        if (v11 == AbstractChannelKt.POLL_FAILED) {
            return ChannelResult.Companion.m7813failurePtdJZtk();
        }
        if (v11 instanceof Closed) {
            return ChannelResult.Companion.m7812closedJP2dKIU(((Closed) v11).closeCause);
        }
        return ChannelResult.Companion.m7814successJP2dKIU(v11);
    }

    public void u(@NotNull Object obj, @NotNull Closed<?> closed) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((Send) obj).resumeSendClosed(closed);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 < size) {
                ((Send) arrayList.get(size)).resumeSendClosed(closed);
            } else {
                return;
            }
        }
    }

    @Nullable
    public Object v() {
        while (true) {
            Send m11 = m();
            if (m11 == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            if (m11.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null) != null) {
                m11.completeResumeSend();
                return m11.getPollResult();
            }
            m11.undeliveredElement();
        }
    }

    @Nullable
    public Object w(@NotNull SelectInstance<?> selectInstance) {
        TryPollDesc n11 = n();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(n11);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ((Send) n11.getResult()).completeResumeSend();
        return ((Send) n11.getResult()).getPollResult();
    }

    public final void cancel(@Nullable CancellationException cancellationException) {
        if (!isClosedForReceive()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
            }
            cancel(cancellationException);
        }
    }
}
