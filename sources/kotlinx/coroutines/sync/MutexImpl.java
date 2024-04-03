package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26365b = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    @NotNull
    volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class LockCont extends LockWaiter {
        @NotNull
        private final CancellableContinuation<Unit> cont;

        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.cont = cancellableContinuation;
        }

        public void completeResumeLockWaiter() {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @NotNull
        public String toString() {
            return "LockCont[" + this.owner + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.cont + "] for " + MutexImpl.this;
        }

        public boolean tryResumeLockWaiter() {
            if (take() && this.cont.tryResume(Unit.INSTANCE, (Object) null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this)) != null) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BD\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R1\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class LockSelect<R> extends LockWaiter {
        @NotNull
        @JvmField
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        @NotNull
        @JvmField
        public final SelectInstance<R> select;

        public LockSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.select = selectInstance;
            this.block = function2;
        }

        public void completeResumeLockWaiter() {
            CancellableKt.startCoroutineCancellable(this.block, MutexImpl.this, this.select.getCompletion(), new MutexImpl$LockSelect$completeResumeLockWaiter$1(MutexImpl.this, this));
        }

        @NotNull
        public String toString() {
            return "LockSelect[" + this.owner + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.select + "] for " + MutexImpl.this;
        }

        public boolean tryResumeLockWaiter() {
            return take() && this.select.trySelect();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        private static final /* synthetic */ AtomicIntegerFieldUpdater isTaken$FU = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");
        @NotNull
        private volatile /* synthetic */ int isTaken = 0;
        @Nullable
        @JvmField
        public final Object owner;

        public LockWaiter(@Nullable Object obj) {
            this.owner = obj;
        }

        public abstract void completeResumeLockWaiter();

        public final void dispose() {
            remove();
        }

        public final boolean take() {
            return isTaken$FU.compareAndSet(this, 0, 1);
        }

        public abstract boolean tryResumeLockWaiter();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LockedQueue extends LockFreeLinkedListHead {
        @NotNull
        @JvmField
        public volatile Object owner;

        public LockedQueue(@NotNull Object obj) {
            this.owner = obj;
        }

        @NotNull
        public String toString() {
            return "LockedQueue[" + this.owner + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TryLockDesc extends AtomicDesc {
        @NotNull
        @JvmField
        public final MutexImpl mutex;
        @Nullable
        @JvmField
        public final Object owner;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public final class PrepareOp extends OpDescriptor {
            @NotNull
            private final AtomicOp<?> atomicOp;

            public PrepareOp(@NotNull AtomicOp<?> atomicOp2) {
                this.atomicOp = atomicOp2;
            }

            @NotNull
            public AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Nullable
            public Object perform(@Nullable Object obj) {
                Object obj2;
                if (getAtomicOp().isDecided()) {
                    obj2 = MutexKt.EMPTY_UNLOCKED;
                } else {
                    obj2 = getAtomicOp();
                }
                if (obj != null) {
                    a.a(MutexImpl.f26365b, (MutexImpl) obj, this, obj2);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public TryLockDesc(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        public void complete(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            Empty empty;
            if (obj != null) {
                empty = MutexKt.EMPTY_UNLOCKED;
            } else {
                Object obj2 = this.owner;
                if (obj2 == null) {
                    empty = MutexKt.EMPTY_LOCKED;
                } else {
                    empty = new Empty(obj2);
                }
            }
            a.a(MutexImpl.f26365b, this.mutex, atomicOp, empty);
        }

        @Nullable
        public Object prepare(@NotNull AtomicOp<?> atomicOp) {
            PrepareOp prepareOp = new PrepareOp(atomicOp);
            if (!a.a(MutexImpl.f26365b, this.mutex, MutexKt.EMPTY_UNLOCKED, prepareOp)) {
                return MutexKt.LOCK_FAIL;
            }
            return prepareOp.perform(this.mutex);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnlockOp extends AtomicOp<MutexImpl> {
        @NotNull
        @JvmField
        public final LockedQueue queue;

        public UnlockOp(@NotNull LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        public void complete(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            a.a(MutexImpl.f26365b, mutexImpl, this, obj == null ? MutexKt.EMPTY_UNLOCKED : this.queue);
        }

        @Nullable
        public Object prepare(@NotNull MutexImpl mutexImpl) {
            if (this.queue.isEmpty()) {
                return null;
            }
            return MutexKt.UNLOCK_FAIL;
        }
    }

    public MutexImpl(boolean z11) {
        Empty empty;
        if (z11) {
            empty = MutexKt.EMPTY_LOCKED;
        } else {
            empty = MutexKt.EMPTY_UNLOCKED;
        }
        this._state = empty;
    }

    /* access modifiers changed from: private */
    public final Object lockSuspend(Object obj, Continuation<? super Unit> continuation) {
        boolean z11;
        Empty empty;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        LockCont lockCont = new LockCont(obj, orCreateCancellableContinuation);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty2 = (Empty) obj2;
                if (empty2.locked != MutexKt.UNLOCKED) {
                    a.a(f26365b, this, obj2, new LockedQueue(empty2.locked));
                } else {
                    if (obj == null) {
                        empty = MutexKt.EMPTY_LOCKED;
                    } else {
                        empty = new Empty(obj);
                    }
                    if (a.a(f26365b, this, obj2, empty)) {
                        orCreateCancellableContinuation.resume(Unit.INSTANCE, new MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (lockedQueue.owner != obj) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    lockedQueue.addLast(lockCont);
                    if (this._state == obj2 || !lockCont.take()) {
                        CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, lockCont);
                    } else {
                        lockCont = new LockCont(obj, orCreateCancellableContinuation);
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
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
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    public boolean holdsLock(@NotNull Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof Empty) {
            if (((Empty) obj2).locked == obj) {
                return true;
            }
        } else if ((obj2 instanceof LockedQueue) && ((LockedQueue) obj2).owner == obj) {
            return true;
        }
        return false;
    }

    public boolean isLocked() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                if (((Empty) obj).locked != MutexKt.UNLOCKED) {
                    return true;
                }
                return false;
            } else if (obj instanceof LockedQueue) {
                return true;
            } else {
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this);
                } else {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
            }
        }
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if (!(obj instanceof LockedQueue) || !((LockedQueue) obj).isEmpty()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        Object lockSuspend = lockSuspend(obj, continuation);
        if (lockSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return lockSuspend;
        }
        return Unit.INSTANCE;
    }

    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, @Nullable Object obj, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        boolean z11;
        while (!selectInstance.isSelected()) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.locked != MutexKt.UNLOCKED) {
                    a.a(f26365b, this, obj2, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(new TryLockDesc(this, obj));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                        if (!(performAtomicTrySelect == MutexKt.LOCK_FAIL || performAtomicTrySelect == AtomicKt.RETRY_ATOMIC)) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + performAtomicTrySelect).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (lockedQueue.owner != obj) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    LockSelect lockSelect = new LockSelect(obj, selectInstance, function2);
                    lockedQueue.addLast(lockSelect);
                    if (this._state == obj2 || !lockSelect.take()) {
                        selectInstance.disposeOnSelect(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).locked + AbstractJsonLexerKt.END_LIST;
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                return "Mutex[" + ((LockedQueue) obj).owner + AbstractJsonLexerKt.END_LIST;
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }

    public boolean tryLock(@Nullable Object obj) {
        Empty empty;
        while (true) {
            Object obj2 = this._state;
            boolean z11 = true;
            if (obj2 instanceof Empty) {
                if (((Empty) obj2).locked != MutexKt.UNLOCKED) {
                    return false;
                }
                if (obj == null) {
                    empty = MutexKt.EMPTY_LOCKED;
                } else {
                    empty = new Empty(obj);
                }
                if (a.a(f26365b, this, obj2, empty)) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).owner == obj) {
                    z11 = false;
                }
                if (z11) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public void unlock(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z11 = true;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    if (((Empty) obj2).locked == MutexKt.UNLOCKED) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty = (Empty) obj2;
                    if (empty.locked != obj) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException(("Mutex is locked by " + empty.locked + " but expected " + obj).toString());
                    }
                }
                if (a.a(f26365b, this, obj2, MutexKt.EMPTY_UNLOCKED)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (lockedQueue.owner != obj) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (a.a(f26365b, this, obj2, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    if (lockWaiter.tryResumeLockWaiter()) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.completeResumeLockWaiter();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }
}
