package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\u0017\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001lB\u001f\u0012\u0006\u0010K\u001a\u00020\u001e\u0012\u0006\u0010M\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\bj\u0010kJ!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001d\u001a\u00020\u0003H\u0014J\u001f\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\u0010H\u0016J&\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0016J\u0017\u0010*\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b*\u0010\u000fJ\u0017\u0010+\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b+\u0010\u000fJ\b\u0010,\u001a\u00020\u0010H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0012\u00101\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010/H\u0002J9\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00182\u0010\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010\u00182\u0006\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u001eH\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\u00102\u0006\u0010\f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b7\u0010\u0012J\u0010\u0010:\u001a\u00020\u00102\u0006\u00109\u001a\u000208H\u0002J(\u0010?\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u0013H\u0002J\b\u0010@\u001a\u00020\u0010H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010/2\u0006\u0010A\u001a\u00020\u0003H\u0002J\u0010\u0010C\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u0003H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010/2\u0006\u0010D\u001a\u00020\u0013H\u0002J\u001b\u0010F\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ3\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00190\u00182\u0014\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00190\u0018H\u0002¢\u0006\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010LR\u0014\u0010'\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010NR \u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010LR\u0016\u0010U\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010LR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000V8VX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001a\u0010^\u001a\u00028\u00008DX\u0004¢\u0006\f\u0012\u0004\b\\\u0010]\u001a\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0015R\u0014\u0010c\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010bR\u0014\u0010g\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u0015R\u0014\u0010i\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "tryEmit", "(Ljava/lang/Object;)Z", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "oldIndex", "", "Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "f", "", "size", "g", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "tryEmitLocked", "tryEmitNoCollectorsLocked", "dropOldestLocked", "newHead", "correctCollectorIndexesOnDropOldest", "", "item", "enqueueLocked", "curBuffer", "curSize", "newSize", "growBuffer", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "cancelEmitter", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateBufferLocked", "cleanupTailLocked", "slot", "tryTakeValue", "tryPeekLocked", "index", "getPeekedValueLockedAt", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumesIn", "findSlotsToResumeLocked", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "replay", "I", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "buffer", "[Ljava/lang/Object;", "replayIndex", "J", "minCollectorIndex", "bufferSize", "queueSize", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "i", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "()V", "lastReplayedLocked", "getHead", "head", "getReplaySize", "()I", "replaySize", "getTotalSize", "totalSize", "getBufferEndIndex", "bufferEndIndex", "getQueueEndIndex", "queueEndIndex", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    @Nullable
    private Object[] buffer;
    /* access modifiers changed from: private */
    public final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    @NotNull
    private final BufferOverflow onBufferOverflow;
    /* access modifiers changed from: private */
    public int queueSize;
    private final int replay;
    private long replayIndex;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Emitter implements DisposableHandle {
        @NotNull
        @JvmField
        public final Continuation<Unit> cont;
        @NotNull
        @JvmField
        public final SharedFlowImpl<?> flow;
        @JvmField
        public long index;
        @Nullable
        @JvmField
        public final Object value;

        public Emitter(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j11, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j11;
            this.value = obj;
            this.cont = continuation;
        }

        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

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

    public SharedFlowImpl(int i11, int i12, @NotNull BufferOverflow bufferOverflow) {
        this.replay = i11;
        this.bufferCapacity = i12;
        this.onBufferOverflow = bufferOverflow;
    }

    /* access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index >= getHead()) {
                Object[] objArr = this.buffer;
                Intrinsics.checkNotNull(objArr);
                if (SharedFlowKt.getBufferAt(objArr, emitter.index) == emitter) {
                    SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
                    cleanupTailLocked();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0 && SharedFlowKt.getBufferAt(objArr, (getHead() + ((long) getTotalSize())) - 1) == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + ((long) getTotalSize()), (Object) null);
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long j11) {
        AbstractSharedFlowSlot[] access$getSlots;
        if (!(this.nCollectors == 0 || (access$getSlots = this.slots) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j12 = sharedFlowSlot.index;
                    if (j12 >= 0 && j12 < j11) {
                        sharedFlowSlot.index = j11;
                    }
                }
            }
        }
        this.minCollectorIndex = j11;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), (Object) null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlinx.coroutines.flow.SharedFlowSlot} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object e(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.f26045n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26045n = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f26043l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26045n
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0075
            if (r2 == r5) goto L_0x005e
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r8 = r0.f26042k
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.f26041j
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.f26040i
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.f26039h
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            goto L_0x0054
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            java.lang.Object r8 = r0.f26042k
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.f26041j
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.f26040i
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.f26039h
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x005b }
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00a3
        L_0x005b:
            r8 = move-exception
            goto L_0x00da
        L_0x005e:
            java.lang.Object r8 = r0.f26041j
            r9 = r8
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r8 = r0.f26040i
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r2 = r0.f26039h
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0071 }
            r10 = r8
            r8 = r2
            goto L_0x0097
        L_0x0071:
            r8 = move-exception
            r5 = r2
            goto L_0x00da
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.a()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x0094
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00d6 }
            r0.f26039h = r8     // Catch:{ all -> 0x00d6 }
            r0.f26040i = r9     // Catch:{ all -> 0x00d6 }
            r0.f26041j = r10     // Catch:{ all -> 0x00d6 }
            r0.f26045n = r5     // Catch:{ all -> 0x00d6 }
            java.lang.Object r2 = r2.onSubscription(r0)     // Catch:{ all -> 0x00d6 }
            if (r2 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0097:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00d2 }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.get(r5)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2     // Catch:{ all -> 0x00d2 }
        L_0x00a3:
            java.lang.Object r5 = r8.tryTakeValue(r9)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.SharedFlowKt.NO_VALUE     // Catch:{ all -> 0x00d2 }
            if (r5 != r6) goto L_0x00bc
            r0.f26039h = r8     // Catch:{ all -> 0x00d2 }
            r0.f26040i = r10     // Catch:{ all -> 0x00d2 }
            r0.f26041j = r9     // Catch:{ all -> 0x00d2 }
            r0.f26042k = r2     // Catch:{ all -> 0x00d2 }
            r0.f26045n = r4     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r8.awaitValue(r9, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00bc:
            if (r2 == 0) goto L_0x00c1
            kotlinx.coroutines.JobKt.ensureActive((kotlinx.coroutines.Job) r2)     // Catch:{ all -> 0x00d2 }
        L_0x00c1:
            r0.f26039h = r8     // Catch:{ all -> 0x00d2 }
            r0.f26040i = r10     // Catch:{ all -> 0x00d2 }
            r0.f26041j = r9     // Catch:{ all -> 0x00d2 }
            r0.f26042k = r2     // Catch:{ all -> 0x00d2 }
            r0.f26045n = r3     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r10.emit(r5, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00d2:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00da
        L_0x00d6:
            r9 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
        L_0x00da:
            r5.b(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.e(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object emitSuspend(T t11, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t11)) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
                continuationArr = findSlotsToResumeLocked(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, ((long) getTotalSize()) + getHead(), t11, cancellableContinuationImpl);
                enqueueLocked(emitter2);
                this.queueSize = this.queueSize + 1;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void enqueueLocked(Object obj) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer((Object[]) null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.setBufferAt(objArr, getHead() + ((long) totalSize), obj);
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] findSlotsToResumeLocked(kotlin.coroutines.Continuation<kotlin.Unit>[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.nCollectors
            if (r1 == 0) goto L_0x0047
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r10.slots
            if (r1 == 0) goto L_0x0047
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0047
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0044
            kotlinx.coroutines.flow.SharedFlowSlot r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4
            kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = r4.cont
            if (r5 != 0) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            long r6 = r10.tryPeekLocked(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            int r6 = r11.length
            if (r0 < r6) goto L_0x0039
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r6)
        L_0x0039:
            r6 = r11
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.cont = r0
            r0 = r7
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0047:
            kotlin.coroutines.Continuation[] r11 = (kotlin.coroutines.Continuation[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.findSlotsToResumeLocked(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    private final long getBufferEndIndex() {
        return getHead() + ((long) this.bufferSize);
    }

    /* access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object getPeekedValueLockedAt(long j11) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object access$getBufferAt = SharedFlowKt.getBufferAt(objArr, j11);
        if (access$getBufferAt instanceof Emitter) {
            return ((Emitter) access$getBufferAt).value;
        }
        return access$getBufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + ((long) this.bufferSize) + ((long) this.queueSize);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex);
    }

    /* access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] objArr, int i11, int i12) {
        boolean z11;
        if (i12 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Object[] objArr2 = new Object[i12];
            this.buffer = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long head = getHead();
            for (int i13 = 0; i13 < i11; i13++) {
                long j11 = ((long) i13) + head;
                SharedFlowKt.setBufferAt(objArr2, j11, SharedFlowKt.getBufferAt(objArr, j11));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public static /* synthetic */ Object h(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        if (sharedFlowImpl.tryEmit(obj)) {
            return Unit.INSTANCE;
        }
        Object emitSuspend = sharedFlowImpl.emitSuspend(obj, continuation);
        if (emitSuspend == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitSuspend;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final boolean tryEmitLocked(T t11) {
        if (c() == 0) {
            return tryEmitNoCollectorsLocked(t11);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 == 2) {
                return true;
            }
        }
        enqueueLocked(t11);
        int i12 = this.bufferSize + 1;
        this.bufferSize = i12;
        if (i12 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T t11) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(t11);
        int i11 = this.bufferSize + 1;
        this.bufferSize = i11;
        if (i11 > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + ((long) this.bufferSize);
        return true;
    }

    /* access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j11 = sharedFlowSlot.index;
        if (j11 < getBufferEndIndex()) {
            return j11;
        }
        if (this.bufferCapacity <= 0 && j11 <= getHead() && this.queueSize != 0) {
            return j11;
        }
        return -1;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long tryPeekLocked = tryPeekLocked(sharedFlowSlot);
            if (tryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j11 = sharedFlowSlot.index;
                Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                sharedFlowSlot.index = tryPeekLocked + 1;
                Object obj2 = peekedValueLockedAt;
                continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j11);
                obj = obj2;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long j11, long j12, long j13, long j14) {
        long min = Math.min(j12, j11);
        for (long head = getHead(); head < min; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, head, (Object) null);
        }
        this.replayIndex = j11;
        this.minCollectorIndex = j12;
        this.bufferSize = (int) (j13 - min);
        this.queueSize = (int) (j14 - j13);
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<?> continuation) {
        return e(this, flowCollector, continuation);
    }

    @Nullable
    public Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
        return h(this, t11, continuation);
    }

    @NotNull
    /* renamed from: f */
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i11, bufferOverflow);
    }

    @NotNull
    /* renamed from: g */
    public SharedFlowSlot[] createSlotArray(int i11) {
        return new SharedFlowSlot[i11];
    }

    @NotNull
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                List<T> emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            for (int i11 = 0; i11 < replaySize; i11++) {
                arrayList.add(SharedFlowKt.getBufferAt(objArr, this.replayIndex + ((long) i11)));
            }
            return arrayList;
        }
    }

    public final T i() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return SharedFlowKt.getBufferAt(objArr, (this.replayIndex + ((long) getReplaySize())) - 1);
    }

    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean tryEmit(T t11) {
        int i11;
        boolean z11;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t11)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z11 = true;
            } else {
                z11 = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }
        return z11;
    }

    @NotNull
    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j11) {
        int i11;
        long j12;
        long j13;
        long j14;
        boolean z11;
        long j15;
        AbstractSharedFlowSlot[] access$getSlots;
        if (j11 > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j16 = ((long) this.bufferSize) + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j16++;
        }
        if (!(this.nCollectors == 0 || (access$getSlots = this.slots) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    long j17 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j17 >= 0 && j17 < j16) {
                        j16 = j17;
                    }
                }
            }
        }
        if (j16 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (c() > 0) {
            i11 = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j16)));
        } else {
            i11 = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j18 = ((long) this.queueSize) + bufferEndIndex;
        if (i11 > 0) {
            continuationArr = new Continuation[i11];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j19 = bufferEndIndex;
            int i12 = 0;
            while (true) {
                if (bufferEndIndex >= j18) {
                    j13 = j16;
                    j12 = j18;
                    break;
                }
                Object access$getBufferAt = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j13 = j16;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (access$getBufferAt == symbol) {
                    j12 = j18;
                    j15 = 1;
                } else if (access$getBufferAt != null) {
                    Emitter emitter = (Emitter) access$getBufferAt;
                    int i13 = i12 + 1;
                    j12 = j18;
                    continuationArr[i12] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                    SharedFlowKt.setBufferAt(objArr, j19, emitter.value);
                    j15 = 1;
                    j19++;
                    if (i13 >= i11) {
                        break;
                    }
                    i12 = i13;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                }
                bufferEndIndex += j15;
                j16 = j13;
                j18 = j12;
            }
            bufferEndIndex = j19;
        } else {
            j13 = j16;
            j12 = j18;
        }
        int i14 = (int) (bufferEndIndex - head);
        if (c() == 0) {
            j14 = bufferEndIndex;
        } else {
            j14 = j13;
        }
        long max = Math.max(this.replayIndex, bufferEndIndex - ((long) Math.min(this.replay, i14)));
        if (this.bufferCapacity == 0 && max < j12) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.getBufferAt(objArr2, max), (Object) SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                max++;
            }
        }
        updateBufferLocked(max, j14, bufferEndIndex, j12);
        cleanupTailLocked();
        if (continuationArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return findSlotsToResumeLocked(continuationArr);
        }
        return continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j11 = this.replayIndex;
        if (j11 < this.minCollectorIndex) {
            this.minCollectorIndex = j11;
        }
        return j11;
    }
}
