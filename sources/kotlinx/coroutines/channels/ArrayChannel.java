package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020'\u0012 \u0010C\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Aj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`B¢\u0006\u0004\bD\u0010EJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001fH\u0014¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u00060*j\u0002`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010&R\u0014\u00104\u001a\u00020\u001f8DX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u001f8DX\u0004¢\u0006\u0006\u001a\u0004\b5\u00103R\u0014\u00108\u001a\u00020\u001f8DX\u0004¢\u0006\u0006\u001a\u0004\b7\u00103R\u0014\u0010:\u001a\u00020\u001f8DX\u0004¢\u0006\u0006\u001a\u0004\b9\u00103R\u0014\u0010;\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u00103R\u0014\u0010<\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b<\u00103R\u0014\u0010@\u001a\u00020=8TX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "currentSize", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", "element", "", "enqueueElement", "(ILjava/lang/Object;)V", "ensureCapacity", "(I)V", "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "j", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "send", "c", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "v", "()Ljava/lang/Object;", "w", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "o", "(Lkotlinx/coroutines/channels/Receive;)Z", "wasClosed", "t", "(Z)V", "capacity", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "buffer", "[Ljava/lang/Object;", "head", "q", "()Z", "isBufferAlwaysEmpty", "r", "isBufferEmpty", "h", "isBufferAlwaysFull", "i", "isBufferFull", "isEmpty", "isClosedForReceive", "", "d", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ArrayChannel<E> extends AbstractChannel<E> {
    @NotNull
    private Object[] buffer;
    private final int capacity;
    private int head;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final BufferOverflow onBufferOverflow;
    @NotNull
    private volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArrayChannel(int i11, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i11;
        this.onBufferOverflow = bufferOverflow;
        if (i11 < 1 ? false : true) {
            this.lock = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i11, 8)];
            ArraysKt___ArraysJvmKt.fill$default(objArr, (Object) AbstractChannelKt.EMPTY, 0, 0, 6, (Object) null);
            this.buffer = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i11 + " was specified").toString());
    }

    private final void enqueueElement(int i11, E e11) {
        if (i11 < this.capacity) {
            ensureCapacity(i11);
            Object[] objArr = this.buffer;
            objArr[(this.head + i11) % objArr.length] = e11;
            return;
        }
        Object[] objArr2 = this.buffer;
        int i12 = this.head;
        objArr2[i12 % objArr2.length] = null;
        objArr2[(i11 + i12) % objArr2.length] = e11;
        this.head = (i12 + 1) % objArr2.length;
    }

    private final void ensureCapacity(int i11) {
        Object[] objArr = this.buffer;
        if (i11 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[min];
            for (int i12 = 0; i12 < i11; i12++) {
                Object[] objArr3 = this.buffer;
                objArr2[i12] = objArr3[(this.head + i12) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.fill((T[]) objArr2, AbstractChannelKt.EMPTY, i11, min);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    private final Symbol updateBufferSize(int i11) {
        if (i11 < this.capacity) {
            this.size = i11 + 1;
            return null;
        }
        int i12 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i12 == 1) {
            return AbstractChannelKt.OFFER_FAILED;
        }
        if (i12 == 2) {
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        if (i12 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Nullable
    public Object c(@NotNull Send send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.c(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public String d() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
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
        int i11 = this.size;
        Closed<?> f11 = f();
        if (f11 != null) {
            reentrantLock.unlock();
            return f11;
        }
        Symbol updateBufferSize = updateBufferSize(i11);
        if (updateBufferSize != null) {
            reentrantLock.unlock();
            return updateBufferSize;
        }
        if (i11 == 0) {
            do {
                try {
                    AbstractSendChannel.TryOfferDesc b11 = b(e11);
                    performAtomicTrySelect = selectInstance.performAtomicTrySelect(b11);
                    if (performAtomicTrySelect == null) {
                        this.size = i11;
                        Object result = b11.getResult();
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        Intrinsics.checkNotNull(result);
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) result;
                        receiveOrClosed.completeResumeReceive(e11);
                        return receiveOrClosed.getOfferResult();
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } while (performAtomicTrySelect == AtomicKt.RETRY_ATOMIC);
            if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                if (!(performAtomicTrySelect instanceof Closed)) {
                    throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                }
            }
            this.size = i11;
            return performAtomicTrySelect;
        }
        if (!selectInstance.trySelect()) {
            this.size = i11;
            Object already_selected = SelectKt.getALREADY_SELECTED();
            reentrantLock.unlock();
            return already_selected;
        }
        enqueueElement(i11, e11);
        Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
        reentrantLock.unlock();
        return symbol;
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

    /* JADX INFO: finally extract failed */
    @NotNull
    public Object offerInternal(E e11) {
        ReceiveOrClosed l11;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        int i11 = this.size;
        Closed<?> f11 = f();
        if (f11 != null) {
            reentrantLock.unlock();
            return f11;
        }
        Symbol updateBufferSize = updateBufferSize(i11);
        if (updateBufferSize != null) {
            reentrantLock.unlock();
            return updateBufferSize;
        }
        if (i11 == 0) {
            do {
                try {
                    l11 = l();
                    if (l11 != null) {
                        if (l11 instanceof Closed) {
                            this.size = i11;
                            reentrantLock.unlock();
                            return l11;
                        }
                        Intrinsics.checkNotNull(l11);
                    }
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } while (l11.tryResumeReceive(e11, (LockFreeLinkedListNode.PrepareOp) null) == null);
            this.size = i11;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            l11.completeResumeReceive(e11);
            return l11.getOfferResult();
        }
        enqueueElement(i11, e11);
        Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
        reentrantLock.unlock();
        return symbol;
    }

    public final boolean q() {
        return false;
    }

    public final boolean r() {
        return this.size == 0;
    }

    /* JADX INFO: finally extract failed */
    public void t(boolean z11) {
        Function1<E, Unit> function1 = this.f25156b;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i11 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i12 = 0; i12 < i11; i12++) {
                Object obj = this.buffer[this.head];
                if (!(function1 == null || obj == AbstractChannelKt.EMPTY)) {
                    undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.buffer;
                int i13 = this.head;
                objArr[i13] = AbstractChannelKt.EMPTY;
                this.head = (i13 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.t(z11);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
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
            int i11 = this.size;
            if (i11 == 0) {
                Object f11 = f();
                if (f11 == null) {
                    f11 = AbstractChannelKt.POLL_FAILED;
                }
                return f11;
            }
            Object[] objArr = this.buffer;
            int i12 = this.head;
            Object obj = objArr[i12];
            Send send = null;
            objArr[i12] = null;
            this.size = i11 - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z11 = false;
            if (i11 == this.capacity) {
                Send send2 = null;
                while (true) {
                    Send m11 = m();
                    if (m11 == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.checkNotNull(m11);
                    if (m11.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null) != null) {
                        obj2 = m11.getPollResult();
                        z11 = true;
                        send = m11;
                        break;
                    }
                    m11.undeliveredElement();
                    send2 = m11;
                }
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i11;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i11) % objArr2.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (z11) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r7 != kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r8.size = r1;
        r8.buffer[r8.head] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        if ((r7 instanceof kotlinx.coroutines.channels.Closed) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r3 = true;
        r2 = r7;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0089 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object w(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.lock
            r0.lock()
            int r1 = r8.size     // Catch:{ all -> 0x00c4 }
            if (r1 != 0) goto L_0x0015
            kotlinx.coroutines.channels.Closed r9 = r8.f()     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x0011
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00c4 }
        L_0x0011:
            r0.unlock()
            return r9
        L_0x0015:
            java.lang.Object[] r2 = r8.buffer     // Catch:{ all -> 0x00c4 }
            int r3 = r8.head     // Catch:{ all -> 0x00c4 }
            r4 = r2[r3]     // Catch:{ all -> 0x00c4 }
            r5 = 0
            r2[r3] = r5     // Catch:{ all -> 0x00c4 }
            int r2 = r1 + -1
            r8.size = r2     // Catch:{ all -> 0x00c4 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00c4 }
            int r3 = r8.capacity     // Catch:{ all -> 0x00c4 }
            r6 = 1
            if (r1 != r3) goto L_0x0080
        L_0x0029:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r3 = r8.n()     // Catch:{ all -> 0x00c4 }
            java.lang.Object r7 = r9.performAtomicTrySelect(r3)     // Catch:{ all -> 0x00c4 }
            if (r7 != 0) goto L_0x0043
            java.lang.Object r5 = r3.getResult()     // Catch:{ all -> 0x00c4 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x00c4 }
            r2 = r5
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2     // Catch:{ all -> 0x00c4 }
            java.lang.Object r2 = r2.getPollResult()     // Catch:{ all -> 0x00c4 }
            r3 = r6
            goto L_0x0081
        L_0x0043:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00c4 }
            if (r7 == r3) goto L_0x0080
            java.lang.Object r3 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC     // Catch:{ all -> 0x00c4 }
            if (r7 == r3) goto L_0x0029
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00c4 }
            if (r7 != r2) goto L_0x005d
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00c4 }
            int r1 = r8.head     // Catch:{ all -> 0x00c4 }
            r9[r1] = r4     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            return r7
        L_0x005d:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x0065
            r3 = r6
            r2 = r7
            r5 = r2
            goto L_0x0081
        L_0x0065:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c4 }
            r1.<init>()     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "performAtomicTrySelect(describeTryOffer) returned "
            r1.append(r2)     // Catch:{ all -> 0x00c4 }
            r1.append(r7)     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c4 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c4 }
            r9.<init>(r1)     // Catch:{ all -> 0x00c4 }
            throw r9     // Catch:{ all -> 0x00c4 }
        L_0x0080:
            r3 = 0
        L_0x0081:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00c4 }
            if (r2 == r7) goto L_0x0095
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00c4 }
            if (r7 != 0) goto L_0x0095
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00c4 }
            int r7 = r8.head     // Catch:{ all -> 0x00c4 }
            int r7 = r7 + r1
            int r1 = r9.length     // Catch:{ all -> 0x00c4 }
            int r7 = r7 % r1
            r9[r7] = r2     // Catch:{ all -> 0x00c4 }
            goto L_0x00ab
        L_0x0095:
            boolean r9 = r9.trySelect()     // Catch:{ all -> 0x00c4 }
            if (r9 != 0) goto L_0x00ab
            r8.size = r1     // Catch:{ all -> 0x00c4 }
            java.lang.Object[] r9 = r8.buffer     // Catch:{ all -> 0x00c4 }
            int r1 = r8.head     // Catch:{ all -> 0x00c4 }
            r9[r1] = r4     // Catch:{ all -> 0x00c4 }
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            return r9
        L_0x00ab:
            int r9 = r8.head     // Catch:{ all -> 0x00c4 }
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.buffer     // Catch:{ all -> 0x00c4 }
            int r1 = r1.length     // Catch:{ all -> 0x00c4 }
            int r9 = r9 % r1
            r8.head = r9     // Catch:{ all -> 0x00c4 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c4 }
            r0.unlock()
            if (r3 == 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlinx.coroutines.channels.Send r5 = (kotlinx.coroutines.channels.Send) r5
            r5.completeResumeSend()
        L_0x00c3:
            return r4
        L_0x00c4:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.w(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }
}
