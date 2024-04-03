package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010,\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010*j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`+¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0014R\u0018\u0010\u0018\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010%\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0014\u0010)\u001a\u00020&8TX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006/"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "updateValueLocked", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "j", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "v", "w", "", "wasClosed", "", "t", "Lkotlinx/coroutines/channels/Receive;", "receive", "o", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "Ljava/lang/Object;", "q", "()Z", "isBufferAlwaysEmpty", "r", "isBufferEmpty", "h", "isBufferAlwaysFull", "i", "isBufferFull", "isEmpty", "", "d", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ConflatedChannel<E> extends AbstractChannel<E> {
    @NotNull
    private final ReentrantLock lock = new ReentrantLock();
    @Nullable
    private Object value = AbstractChannelKt.EMPTY;

    public ConflatedChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    private final UndeliveredElementException updateValueLocked(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.value;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == AbstractChannelKt.EMPTY || (function1 = this.f25156b) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj2, (UndeliveredElementException) null, 2, (Object) null);
        }
        this.value = obj;
        return undeliveredElementException;
    }

    @NotNull
    public String d() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return "(value=" + this.value + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return false;
    }

    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return s();
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public Object j(E e11, @NotNull SelectInstance<?> selectInstance) {
        Object performAtomicTrySelect;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Closed<?> f11 = f();
            if (f11 != null) {
                return f11;
            }
            if (this.value == AbstractChannelKt.EMPTY) {
                do {
                    AbstractSendChannel.TryOfferDesc b11 = b(e11);
                    performAtomicTrySelect = selectInstance.performAtomicTrySelect(b11);
                    if (performAtomicTrySelect == null) {
                        Object result = b11.getResult();
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        Intrinsics.checkNotNull(result);
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) result;
                        receiveOrClosed.completeResumeReceive(e11);
                        return receiveOrClosed.getOfferResult();
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                    }
                } while (performAtomicTrySelect == AtomicKt.RETRY_ATOMIC);
                if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                    if (!(performAtomicTrySelect instanceof Closed)) {
                        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                    }
                }
                reentrantLock.unlock();
                return performAtomicTrySelect;
            }
            if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            }
            UndeliveredElementException updateValueLocked = updateValueLocked(e11);
            if (updateValueLocked == null) {
                Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return symbol;
            }
            throw updateValueLocked;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean o(@NotNull Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.o(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public Object offerInternal(E e11) {
        ReceiveOrClosed l11;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Closed<?> f11 = f();
            if (f11 != null) {
                return f11;
            }
            if (this.value == AbstractChannelKt.EMPTY) {
                do {
                    l11 = l();
                    if (l11 != null) {
                        if (l11 instanceof Closed) {
                            reentrantLock.unlock();
                            return l11;
                        }
                        Intrinsics.checkNotNull(l11);
                    }
                } while (l11.tryResumeReceive(e11, (LockFreeLinkedListNode.PrepareOp) null) == null);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                l11.completeResumeReceive(e11);
                return l11.getOfferResult();
            }
            UndeliveredElementException updateValueLocked = updateValueLocked(e11);
            if (updateValueLocked == null) {
                Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
                reentrantLock.unlock();
                return symbol;
            }
            throw updateValueLocked;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean q() {
        return false;
    }

    public final boolean r() {
        boolean z11;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.value == AbstractChannelKt.EMPTY) {
                z11 = true;
            } else {
                z11 = false;
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public void t(boolean z11) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException updateValueLocked = updateValueLocked(AbstractChannelKt.EMPTY);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.t(z11);
            if (updateValueLocked != null) {
                throw updateValueLocked;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Nullable
    public Object v() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object f11 = f();
                if (f11 == null) {
                    f11 = AbstractChannelKt.POLL_FAILED;
                }
                return f11;
            }
            this.value = symbol;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public Object w(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj == symbol) {
                Object f11 = f();
                if (f11 == null) {
                    f11 = AbstractChannelKt.POLL_FAILED;
                }
                return f11;
            } else if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            } else {
                Object obj2 = this.value;
                this.value = symbol;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
