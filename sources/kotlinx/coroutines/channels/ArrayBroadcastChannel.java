package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001NB\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\bM\u0010BJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u001b\u0010\bJ\u001f\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b!\u0010\"J#\u0010%\u001a\u00020 2\u0006\u0010\u001f\u001a\u00028\u00002\n\u0010$\u001a\u0006\u0012\u0002\b\u00030#H\u0014¢\u0006\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010.\u001a\u00060,j\u0002`-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R6\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f03j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`48\u0002X\u0004¢\u0006\f\n\u0004\b5\u00106\u0012\u0004\b7\u0010\u000bR$\u0010<\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010;R$\u0010?\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010;R$\u0010C\u001a\u00020'2\u0006\u00108\u001a\u00020'8B@BX\u000e¢\u0006\f\u001a\u0004\b@\u0010+\"\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0014\u0010L\u001a\u00020I8TX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "cause", "", "cancelInternal", "(Ljava/lang/Throwable;)Z", "", "checkSubOffers", "()V", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "updateHead", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "computeMinHead", "()J", "index", "elementAt", "(J)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "close", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "j", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "capacity", "I", "getCapacity", "()I", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "buffer", "[Ljava/lang/Object;", "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscribers", "Ljava/util/List;", "getSubscribers$annotations", "value", "getHead", "setHead", "(J)V", "head", "getTail", "setTail", "tail", "getSize", "setSize", "(I)V", "size", "h", "()Z", "isBufferAlwaysFull", "i", "isBufferFull", "", "d", "()Ljava/lang/String;", "bufferDebugString", "<init>", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    @NotNull
    private volatile /* synthetic */ long _head;
    @NotNull
    private volatile /* synthetic */ int _size;
    @NotNull
    private volatile /* synthetic */ long _tail;
    @NotNull
    private final Object[] buffer;
    @NotNull
    private final ReentrantLock bufferLock;
    private final int capacity;
    @NotNull
    private final List<Subscriber<E>> subscribers;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00060\u0017j\u0002`\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0006R\u0014\u0010%\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R\u0014\u0010'\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0014\u0010)\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0006¨\u0006,"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "needsToCheckOfferWithoutLock", "()Z", "", "peekUnderLock", "()Ljava/lang/Object;", "", "cause", "close", "(Ljava/lang/Throwable;)Z", "checkOffer", "v", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "w", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "value", "getSubHead", "()J", "setSubHead", "(J)V", "subHead", "q", "isBufferAlwaysEmpty", "r", "isBufferEmpty", "h", "isBufferAlwaysFull", "i", "isBufferFull", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        @NotNull
        private volatile /* synthetic */ long _subHead = 0;
        @NotNull
        private final ArrayBroadcastChannel<E> broadcastChannel;
        @NotNull
        private final ReentrantLock subLock = new ReentrantLock();

        public Subscriber(@NotNull ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super((Function1) null);
            this.broadcastChannel = arrayBroadcastChannel;
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (e() != null) {
                return false;
            }
            if (!r() || this.broadcastChannel.e() != null) {
                return true;
            }
            return false;
        }

        private final Object peekUnderLock() {
            long subHead = getSubHead();
            Closed<?> e11 = this.broadcastChannel.e();
            if (subHead < this.broadcastChannel.getTail()) {
                Object access$elementAt = this.broadcastChannel.elementAt(subHead);
                Closed<?> e12 = e();
                if (e12 != null) {
                    return e12;
                }
                return access$elementAt;
            } else if (e11 != null) {
                return e11;
            } else {
                Closed<?> e13 = e();
                if (e13 == null) {
                    return AbstractChannelKt.POLL_FAILED;
                }
                return e13;
            }
        }

        public final boolean checkOffer() {
            Closed closed;
            boolean z11 = false;
            while (true) {
                closed = null;
                if (!needsToCheckOfferWithoutLock() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    Object peekUnderLock = peekUnderLock();
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (peekUnderLock instanceof Closed) {
                            closed = (Closed) peekUnderLock;
                            break;
                        }
                        ReceiveOrClosed l11 = l();
                        if (l11 == null) {
                            break;
                        } else if (l11 instanceof Closed) {
                            break;
                        } else if (l11.tryResumeReceive(peekUnderLock, (LockFreeLinkedListNode.PrepareOp) null) != null) {
                            setSubHead(getSubHead() + 1);
                            this.subLock.unlock();
                            l11.completeResumeReceive(peekUnderLock);
                            z11 = true;
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            this.subLock.unlock();
            if (closed != null) {
                close(closed.closeCause);
            }
            return z11;
        }

        public boolean close(@Nullable Throwable th2) {
            boolean close = super.close(th2);
            if (close) {
                ArrayBroadcastChannel.n(this.broadcastChannel, (Subscriber) null, this, 1, (Object) null);
                ReentrantLock reentrantLock = this.subLock;
                reentrantLock.lock();
                try {
                    setSubHead(this.broadcastChannel.getTail());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return close;
        }

        public final long getSubHead() {
            return this._subHead;
        }

        public boolean h() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public boolean i() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public boolean q() {
            return false;
        }

        public boolean r() {
            return getSubHead() >= this.broadcastChannel.getTail();
        }

        public final void setSubHead(long j11) {
            this._subHead = j11;
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public Object v() {
            boolean z11;
            Closed closed;
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z12 = true;
                if ((peekUnderLock instanceof Closed) || peekUnderLock == AbstractChannelKt.POLL_FAILED) {
                    z11 = false;
                } else {
                    setSubHead(getSubHead() + 1);
                    z11 = true;
                }
                reentrantLock.unlock();
                if (peekUnderLock instanceof Closed) {
                    closed = (Closed) peekUnderLock;
                } else {
                    closed = null;
                }
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (!checkOffer()) {
                    z12 = z11;
                }
                if (z12) {
                    ArrayBroadcastChannel.n(this.broadcastChannel, (Subscriber) null, (Subscriber) null, 3, (Object) null);
                }
                return peekUnderLock;
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public Object w(@NotNull SelectInstance<?> selectInstance) {
            Closed closed;
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z11 = true;
                boolean z12 = false;
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (!selectInstance.trySelect()) {
                        peekUnderLock = SelectKt.getALREADY_SELECTED();
                    } else {
                        setSubHead(getSubHead() + 1);
                        z12 = true;
                    }
                }
                reentrantLock.unlock();
                if (peekUnderLock instanceof Closed) {
                    closed = (Closed) peekUnderLock;
                } else {
                    closed = null;
                }
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (!checkOffer()) {
                    z11 = z12;
                }
                if (z11) {
                    ArrayBroadcastChannel.n(this.broadcastChannel, (Subscriber) null, (Subscriber) null, 3, (Object) null);
                }
                return peekUnderLock;
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    public ArrayBroadcastChannel(int i11) {
        super((Function1) null);
        this.capacity = i11;
        if (i11 < 1 ? false : true) {
            this.bufferLock = new ReentrantLock();
            this.buffer = new Object[i11];
            this._head = 0;
            this._tail = 0;
            this._size = 0;
            this.subscribers = ConcurrentKt.subscriberList();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i11 + " was specified").toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelInternal */
    public final boolean cancel(Throwable th2) {
        boolean close = close(th2);
        for (Subscriber<E> cancelInternal$kotlinx_coroutines_core : this.subscribers) {
            cancelInternal$kotlinx_coroutines_core.cancel(th2);
        }
        return close;
    }

    private final void checkSubOffers() {
        boolean z11;
        boolean z12 = false;
        loop0:
        while (true) {
            z11 = z12;
            for (Subscriber<E> checkOffer : this.subscribers) {
                if (checkOffer.checkOffer()) {
                    z12 = true;
                } else {
                    z11 = true;
                }
            }
            break loop0;
        }
        if (z12 || !z11) {
            n(this, (Subscriber) null, (Subscriber) null, 3, (Object) null);
        }
    }

    private final long computeMinHead() {
        long j11 = Long.MAX_VALUE;
        for (Subscriber<E> subHead : this.subscribers) {
            j11 = RangesKt___RangesKt.coerceAtMost(j11, subHead.getSubHead());
        }
        return j11;
    }

    /* access modifiers changed from: private */
    public final E elementAt(long j11) {
        return this.buffer[(int) (j11 % ((long) this.capacity))];
    }

    private final long getHead() {
        return this._head;
    }

    private final int getSize() {
        return this._size;
    }

    private static /* synthetic */ void getSubscribers$annotations() {
    }

    /* access modifiers changed from: private */
    public final long getTail() {
        return this._tail;
    }

    public static /* synthetic */ void n(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriber = null;
        }
        if ((i11 & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    private final void setHead(long j11) {
        this._head = j11;
    }

    private final void setSize(int i11) {
        this._size = i11;
    }

    private final void setTail(long j11) {
        this._tail = j11;
    }

    private final void updateHead(Subscriber<E> subscriber, Subscriber<E> subscriber2) {
        boolean z11;
        Send m11;
        while (true) {
            ReentrantLock reentrantLock = this.bufferLock;
            reentrantLock.lock();
            if (subscriber != null) {
                try {
                    subscriber.setSubHead(getTail());
                    boolean isEmpty = this.subscribers.isEmpty();
                    this.subscribers.add(subscriber);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (subscriber2 != null) {
                this.subscribers.remove(subscriber2);
                if (getHead() != subscriber2.getSubHead()) {
                    reentrantLock.unlock();
                    return;
                }
            }
            long computeMinHead = computeMinHead();
            long tail = getTail();
            long head = getHead();
            long coerceAtMost = RangesKt___RangesKt.coerceAtMost(computeMinHead, tail);
            if (coerceAtMost <= head) {
                reentrantLock.unlock();
                return;
            }
            int size = getSize();
            while (head < coerceAtMost) {
                Object[] objArr = this.buffer;
                int i11 = this.capacity;
                objArr[(int) (head % ((long) i11))] = null;
                if (size >= i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                head++;
                setHead(head);
                size--;
                setSize(size);
                if (z11) {
                    do {
                        m11 = m();
                        if (m11 != null) {
                            if (!(m11 instanceof Closed)) {
                                Intrinsics.checkNotNull(m11);
                            } else {
                                continue;
                            }
                        }
                    } while (m11.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null) == null);
                    this.buffer[(int) (tail % ((long) this.capacity))] = m11.getPollResult();
                    setSize(size + 1);
                    setTail(tail + 1);
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    m11.completeResumeSend();
                    checkSubOffers();
                    subscriber = null;
                    subscriber2 = null;
                }
            }
            reentrantLock.unlock();
            return;
        }
    }

    public boolean close(@Nullable Throwable th2) {
        if (!super.close(th2)) {
            return false;
        }
        checkSubOffers();
        return true;
    }

    @NotNull
    public String d() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + getSize() + ')';
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return getSize() >= this.capacity;
    }

    @NotNull
    public Object j(E e11, @NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> f11 = f();
            if (f11 != null) {
                return f11;
            }
            int size = getSize();
            if (size >= this.capacity) {
                Symbol symbol = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return symbol;
            } else if (!selectInstance.trySelect()) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                reentrantLock.unlock();
                return already_selected;
            } else {
                long tail = getTail();
                this.buffer[(int) (tail % ((long) this.capacity))] = e11;
                setSize(size + 1);
                setTail(tail + 1);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                checkSubOffers();
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public Object offerInternal(E e11) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> f11 = f();
            if (f11 != null) {
                return f11;
            }
            int size = getSize();
            if (size >= this.capacity) {
                Symbol symbol = AbstractChannelKt.OFFER_FAILED;
                reentrantLock.unlock();
                return symbol;
            }
            long tail = getTail();
            this.buffer[(int) (tail % ((long) this.capacity))] = e11;
            setSize(size + 1);
            setTail(tail + 1);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        n(this, subscriber, (Subscriber) null, 2, (Object) null);
        return subscriber;
    }

    public void cancel(@Nullable CancellationException cancellationException) {
        cancel(cancellationException);
    }
}
