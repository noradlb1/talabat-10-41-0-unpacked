package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u001a\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002\u001a6\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001bHHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"BROKEN", "Lkotlinx/coroutines/internal/Symbol;", "getBROKEN$annotations", "()V", "CANCELLED", "getCANCELLED$annotations", "MAX_SPIN_CYCLES", "", "getMAX_SPIN_CYCLES$annotations", "PERMIT", "getPERMIT$annotations", "SEGMENT_SIZE", "getSEGMENT_SIZE$annotations", "TAKEN", "getTAKEN$annotations", "Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", "acquiredPermits", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", "", "prev", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SemaphoreKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Symbol BROKEN = new Symbol("BROKEN");
    /* access modifiers changed from: private */
    @NotNull
    public static final Symbol CANCELLED = new Symbol("CANCELLED");
    /* access modifiers changed from: private */
    public static final int MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Symbol PERMIT = new Symbol("PERMIT");
    /* access modifiers changed from: private */
    public static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Symbol TAKEN = new Symbol("TAKEN");

    @NotNull
    public static final Semaphore Semaphore(int i11, int i12) {
        return new SemaphoreImpl(i11, i12);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return Semaphore(i11, i12);
    }

    /* access modifiers changed from: private */
    public static final SemaphoreSegment createSegment(long j11, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j11, semaphoreSegment, 0);
    }

    private static /* synthetic */ void getBROKEN$annotations() {
    }

    private static /* synthetic */ void getCANCELLED$annotations() {
    }

    private static /* synthetic */ void getMAX_SPIN_CYCLES$annotations() {
    }

    private static /* synthetic */ void getPERMIT$annotations() {
    }

    private static /* synthetic */ void getSEGMENT_SIZE$annotations() {
    }

    private static /* synthetic */ void getTAKEN$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withPermit(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Semaphore r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.f26386k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26386k = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f26385j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f26386k
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.f26384i
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f26383h
            kotlinx.coroutines.sync.Semaphore r4 = (kotlinx.coroutines.sync.Semaphore) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f26383h = r4
            r0.f26384i = r5
            r0.f26386k = r3
            java.lang.Object r6 = r4.acquire(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Object r5 = r5.invoke()     // Catch:{ all -> 0x0058 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return r5
        L_0x0058:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.withPermit(kotlinx.coroutines.sync.Semaphore, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object withPermit$$forInline(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        semaphore.acquire(continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.release();
            InlineMarker.finallyEnd(1);
        }
    }
}
