package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import v0.a;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004fghiB)\u0012 \u0010K\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000109j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`I¢\u0006\u0004\be\u0010=J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\n2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JX\u0010\u001b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\b\u001a\u00028\u00002(\u0010\u001a\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00192\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b \u0010!J#\u0010\"\u001a\u00020\u00192\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0014¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0004¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010'2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b(\u0010)J#\u0010,\u001a\u000e\u0012\u0002\b\u00030*j\u0006\u0012\u0002\b\u0003`+2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b.\u0010\fJ\u0017\u00100\u001a\u00020/2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00101J$\u00104\u001a\b\u0012\u0004\u0012\u00020\n022\u0006\u0010\b\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b3\u0010!J\u0019\u00105\u001a\u0004\u0018\u00010\u00192\u0006\u0010.\u001a\u00020$H\u0014¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u00020/2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b7\u00108J)\u0010<\u001a\u00020\n2\u0018\u0010;\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n09j\u0002`:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020>H\u0014¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010'H\u0014¢\u0006\u0004\bA\u0010BJ\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000C2\u0006\u0010\b\u001a\u00028\u0000H\u0004¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bG\u0010HR.\u0010K\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000109j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`I8\u0004X\u0004¢\u0006\u0006\n\u0004\bD\u0010JR\u001a\u0010M\u001a\u00020L8\u0004X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020/8BX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020F8BX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010HR\u0014\u0010V\u001a\u00020/8$X¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010RR\u0014\u0010X\u001a\u00020/8$X¤\u0004¢\u0006\u0006\u001a\u0004\bW\u0010RR\u001a\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u001a\u0010]\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010ZR\u0011\u0010^\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b^\u0010RR#\u0010b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020_8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020F8TX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010H\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "helpCloseAndGetSendException", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "", "sendSuspend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "cause", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "countQueueSize", "()I", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "j", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "m", "()Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "k", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "send", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "c", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "l", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "b", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "g", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "isFullImpl", "()Z", "getQueueDebugStateString", "queueDebugStateString", "h", "isBufferAlwaysFull", "i", "isBufferFull", "f", "()Lkotlinx/coroutines/channels/Closed;", "closedForSend", "e", "closedForReceive", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "d", "bufferDebugString", "<init>", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    @Nullable
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final Function1<E, Unit> f25156b;
    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;
    @NotNull
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SendBuffered<E> extends Send {
        @JvmField
        public final E element;

        public SendBuffered(E e11) {
            this.element = e11;
        }

        public void completeResumeSend() {
        }

        @Nullable
        public Object getPollResult() {
            return this.element;
        }

        public void resumeSendClosed(@NotNull Closed<?> closed) {
        }

        @NotNull
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }

        @Nullable
        public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return symbol;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead, E e11) {
            super(lockFreeLinkedListHead, new SendBuffered(e11));
        }

        @Nullable
        public Object a(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BV\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t\u0012(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016R7\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "channel", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getPollResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "completeResumeSend", "", "dispose", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "undeliveredElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SendSelect<E, R> extends Send implements DisposableHandle {
        @NotNull
        @JvmField
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> block;
        @NotNull
        @JvmField
        public final AbstractSendChannel<E> channel;
        private final E pollResult;
        @NotNull
        @JvmField
        public final SelectInstance<R> select;

        public SendSelect(E e11, @NotNull AbstractSendChannel<E> abstractSendChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.pollResult = e11;
            this.channel = abstractSendChannel;
            this.select = selectInstance;
            this.block = function2;
        }

        public void completeResumeSend() {
            CancellableKt.startCoroutineCancellable$default(this.block, this.channel, this.select.getCompletion(), (Function1) null, 4, (Object) null);
        }

        public void dispose() {
            if (remove()) {
                undeliveredElement();
            }
        }

        public E getPollResult() {
            return this.pollResult;
        }

        public void resumeSendClosed(@NotNull Closed<?> closed) {
            if (this.select.trySelect()) {
                this.select.resumeSelectWithException(closed.getSendException());
            }
        }

        @NotNull
        public String toString() {
            return "SendSelect@" + DebugStringsKt.getHexAddress(this) + '(' + getPollResult() + ")[" + this.channel + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.select + AbstractJsonLexerKt.END_LIST;
        }

        @Nullable
        public Symbol tryResumeSend(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.select.trySelectOther(prepareOp);
        }

        public void undeliveredElement() {
            Function1<E, Unit> function1 = this.channel.f25156b;
            if (function1 != null) {
                OnUndeliveredElementKt.callUndeliveredElement(function1, getPollResult(), this.select.getCompletion().getContext());
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\r\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016R\u0014\u0010\r\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "onPrepare", "element", "Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        @JvmField
        public final E element;

        public TryOfferDesc(E e11, @NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.element = e11;
        }

        @Nullable
        public Object a(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            return null;
        }

        @Nullable
        public Object onPrepare(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol tryResumeReceive = ((ReceiveOrClosed) prepareOp.affected).tryResumeReceive(this.element, prepareOp);
            if (tryResumeReceive == null) {
                return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
            }
            Object obj = AtomicKt.RETRY_ATOMIC;
            if (tryResumeReceive == obj) {
                return obj;
            }
            return null;
        }
    }

    public AbstractSendChannel(@Nullable Function1<? super E, Unit> function1) {
        this.f25156b = function1;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        int i11 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i11++;
            }
        }
        return i11;
    }

    private final String getQueueDebugStateString() {
        String str;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            str = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            str = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + nextNode;
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return str;
        }
        String str2 = str + ",queueSize=" + countQueueSize();
        if (!(prevNode instanceof Closed)) {
            return str2;
        }
        return str2 + ",closedForSend=" + prevNode;
    }

    private final void helpClose(Closed<?> closed) {
        Receive receive;
        Object r22 = InlineList.m7835constructorimpl$default((Object) null, 1, (DefaultConstructorMarker) null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if (prevNode instanceof Receive) {
                receive = (Receive) prevNode;
            } else {
                receive = null;
            }
            if (receive == null) {
                break;
            } else if (!receive.remove()) {
                receive.helpRemove();
            } else {
                r22 = InlineList.m7840plusFjFbRPM(r22, receive);
            }
        }
        if (r22 != null) {
            if (!(r22 instanceof ArrayList)) {
                ((Receive) r22).resumeReceiveClosed(closed);
            } else {
                ArrayList arrayList = (ArrayList) r22;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                }
            }
        }
        onClosedIdempotent(closed);
    }

    private final Throwable helpCloseAndGetSendException(Closed<?> closed) {
        helpClose(closed);
        return closed.getSendException();
    }

    /* access modifiers changed from: private */
    public final void helpCloseAndResumeWithSendException(Continuation<?> continuation, E e11, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        Function1<E, Unit> function1 = this.f25156b;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(sendException)));
            return;
        }
        ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, sendException);
        Result.Companion companion2 = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
    }

    private final void invokeOnCloseHandler(Throwable th2) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.HANDLER_INVOKED) && a.a(onCloseHandler$FU, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th2);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFullImpl() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && i();
    }

    /* access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e11, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (isFullImpl()) {
                SendSelect sendSelect = new SendSelect(e11, this, selectInstance, function2);
                Object c11 = c(sendSelect);
                if (c11 == null) {
                    selectInstance.disposeOnSelect(sendSelect);
                    return;
                } else if (c11 instanceof Closed) {
                    throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(e11, (Closed) c11));
                } else if (c11 != AbstractChannelKt.ENQUEUE_FAILED && !(c11 instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + c11 + ' ').toString());
                }
            }
            Object j11 = j(e11, selectInstance);
            if (j11 != SelectKt.getALREADY_SELECTED()) {
                if (j11 != AbstractChannelKt.OFFER_FAILED && j11 != AtomicKt.RETRY_ATOMIC) {
                    if (j11 == AbstractChannelKt.OFFER_SUCCESS) {
                        UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (j11 instanceof Closed) {
                        throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(e11, (Closed) j11));
                    } else {
                        throw new IllegalStateException(("offerSelectInternal returned " + j11).toString());
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object sendSuspend(E e11, Continuation<? super Unit> continuation) {
        Send send;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (isFullImpl()) {
                if (this.f25156b == null) {
                    send = new SendElement(e11, orCreateCancellableContinuation);
                } else {
                    send = new SendElementWithUndeliveredHandler(e11, orCreateCancellableContinuation, this.f25156b);
                }
                Object c11 = c(send);
                if (c11 == null) {
                    CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, send);
                    break;
                } else if (c11 instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, e11, (Closed) c11);
                    break;
                } else if (c11 != AbstractChannelKt.ENQUEUE_FAILED && !(c11 instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + c11).toString());
                }
            }
            Object offerInternal = offerInternal(e11);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                Result.Companion companion = Result.Companion;
                orCreateCancellableContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
                break;
            } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    helpCloseAndResumeWithSendException(orCreateCancellableContinuation, e11, (Closed) offerInternal);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + offerInternal).toString());
                }
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final LockFreeLinkedListNode.AddLastDesc<?> a(E e11) {
        return new SendBufferedDesc(this.queue, e11);
    }

    @NotNull
    public final TryOfferDesc<E> b(E e11) {
        return new TryOfferDesc<>(e11, this.queue);
    }

    @Nullable
    public Object c(@NotNull Send send) {
        boolean z11;
        LockFreeLinkedListNode prevNode;
        if (h()) {
            LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
            do {
                prevNode = lockFreeLinkedListHead.getPrevNode();
                if (prevNode instanceof ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(send, lockFreeLinkedListHead));
            return null;
        }
        LockFreeLinkedListHead lockFreeLinkedListHead2 = this.queue;
        AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(send, this);
        while (true) {
            LockFreeLinkedListNode prevNode2 = lockFreeLinkedListHead2.getPrevNode();
            if (!(prevNode2 instanceof ReceiveOrClosed)) {
                int tryCondAddNext = prevNode2.tryCondAddNext(send, lockFreeLinkedListHead2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1);
                z11 = true;
                if (tryCondAddNext != 1) {
                    if (tryCondAddNext == 2) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return prevNode2;
            }
        }
        if (!z11) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    public boolean close(@Nullable Throwable th2) {
        boolean z11;
        Closed closed = new Closed(th2);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListHead.getPrevNode();
            z11 = true;
            if (!(prevNode instanceof Closed)) {
                if (prevNode.addNext(closed, lockFreeLinkedListHead)) {
                    break;
                }
            } else {
                z11 = false;
                break;
            }
        }
        if (!z11) {
            closed = (Closed) this.queue.getPrevNode();
        }
        helpClose(closed);
        if (z11) {
            invokeOnCloseHandler(th2);
        }
        return z11;
    }

    @NotNull
    public String d() {
        return "";
    }

    @Nullable
    public final Closed<?> e() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        Closed<?> closed = nextNode instanceof Closed ? (Closed) nextNode : null;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    @Nullable
    public final Closed<?> f() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        Closed<?> closed = prevNode instanceof Closed ? (Closed) prevNode : null;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    @NotNull
    public final LockFreeLinkedListHead g() {
        return this.queue;
    }

    @NotNull
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new AbstractSendChannel$onSend$1(this);
    }

    public abstract boolean h();

    public abstract boolean i();

    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> f11 = f();
        if (f11 != null && a.a(atomicReferenceFieldUpdater, this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            function1.invoke(f11.closeCause);
        }
    }

    public final boolean isClosedForSend() {
        return f() != null;
    }

    @NotNull
    public Object j(E e11, @NotNull SelectInstance<?> selectInstance) {
        TryOfferDesc b11 = b(e11);
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(b11);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) b11.getResult();
        receiveOrClosed.completeResumeReceive(e11);
        return receiveOrClosed.getOfferResult();
    }

    @Nullable
    public final ReceiveOrClosed<?> k(E e11) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(e11);
        do {
            prevNode = lockFreeLinkedListHead.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    @Nullable
    public ReceiveOrClosed<E> l() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    @Nullable
    public final Send m() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode removeOrNext;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.isRemoved()) || (removeOrNext = lockFreeLinkedListNode.removeOrNext()) == null) {
                    break;
                }
                removeOrNext.helpRemovePrev();
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    public boolean offer(E e11) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        try {
            return SendChannel.DefaultImpls.offer(this, e11);
        } catch (Throwable th2) {
            Function1<E, Unit> function1 = this.f25156b;
            if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
                throw th2;
            }
            ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, th2);
            throw callUndeliveredElementCatchingException$default;
        }
    }

    @NotNull
    public Object offerInternal(E e11) {
        ReceiveOrClosed l11;
        do {
            l11 = l();
            if (l11 == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
        } while (l11.tryResumeReceive(e11, (LockFreeLinkedListNode.PrepareOp) null) == null);
        l11.completeResumeReceive(e11);
        return l11.getOfferResult();
    }

    public void onClosedIdempotent(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    @Nullable
    public final Object send(E e11, @NotNull Continuation<? super Unit> continuation) {
        if (offerInternal(e11) == AbstractChannelKt.OFFER_SUCCESS) {
            return Unit.INSTANCE;
        }
        Object sendSuspend = sendSuspend(e11, continuation);
        if (sendSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return sendSuspend;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + AbstractJsonLexerKt.BEGIN_OBJ + getQueueDebugStateString() + AbstractJsonLexerKt.END_OBJ + d();
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    public final Object m7790trySendJP2dKIU(E e11) {
        Object offerInternal = offerInternal(e11);
        if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return ChannelResult.Companion.m7814successJP2dKIU(Unit.INSTANCE);
        }
        if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> f11 = f();
            if (f11 == null) {
                return ChannelResult.Companion.m7813failurePtdJZtk();
            }
            return ChannelResult.Companion.m7812closedJP2dKIU(helpCloseAndGetSendException(f11));
        } else if (offerInternal instanceof Closed) {
            return ChannelResult.Companion.m7812closedJP2dKIU(helpCloseAndGetSendException((Closed) offerInternal));
        } else {
            throw new IllegalStateException(("trySend returned " + offerInternal).toString());
        }
    }

    private final Throwable helpCloseAndGetSendException(E e11, Closed<?> closed) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        helpClose(closed);
        Function1<E, Unit> function1 = this.f25156b;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            return closed.getSendException();
        }
        ExceptionsKt__ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, closed.getSendException());
        throw callUndeliveredElementCatchingException$default;
    }
}
