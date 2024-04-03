package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ProduceFrameSignal {
    /* access modifiers changed from: private */
    @Nullable
    public Object pendingFrameContinuation;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r0 = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r5), 1);
        r0.initCancellability();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (access$getPendingFrameContinuation$p(r3) != androidx.compose.runtime.RecomposerKt.access$getProduceAnotherFrame$p()) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        access$setPendingFrameContinuation$p(r3, androidx.compose.runtime.RecomposerKt.access$getFramePending$p());
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        access$setPendingFrameContinuation$p(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r1 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        r4 = kotlin.Result.Companion;
        r1.resumeWith(kotlin.Result.m6329constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r4 = r0.getResult();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r4 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (r4 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitFrameRequest(@org.jetbrains.annotations.NotNull java.lang.Object r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r3 = this;
            monitor-enter(r4)
            java.lang.Object r0 = r3.pendingFrameContinuation     // Catch:{ all -> 0x0063 }
            java.lang.Object r1 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0063 }
            if (r0 != r1) goto L_0x0013
            java.lang.Object r5 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0063 }
            r3.pendingFrameContinuation = r5     // Catch:{ all -> 0x0063 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)
            return r5
        L_0x0013:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r5)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            monitor-enter(r4)
            java.lang.Object r1 = r3.pendingFrameContinuation     // Catch:{ all -> 0x0060 }
            java.lang.Object r2 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0060 }
            if (r1 != r2) goto L_0x0037
            java.lang.Object r1 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0060 }
            r3.pendingFrameContinuation = r1     // Catch:{ all -> 0x0060 }
            r1 = r0
            goto L_0x003b
        L_0x0037:
            r3.pendingFrameContinuation = r0     // Catch:{ all -> 0x0060 }
            r1 = 0
        L_0x003b:
            monitor-exit(r4)
            if (r1 == 0) goto L_0x0049
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)
            r1.resumeWith(r4)
        L_0x0049:
            java.lang.Object r4 = r0.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r0) goto L_0x0056
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)
        L_0x0056:
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L_0x005d
            return r4
        L_0x005d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0060:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceFrameSignal.awaitFrameRequest(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Continuation<Unit> requestFrameLocked() {
        boolean z11;
        Object obj = this.pendingFrameContinuation;
        if (obj instanceof Continuation) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (Continuation) obj;
        }
        if (Intrinsics.areEqual(obj, RecomposerKt.ProduceAnotherFrame)) {
            z11 = true;
        } else {
            z11 = Intrinsics.areEqual(obj, RecomposerKt.FramePending);
        }
        if (!z11) {
            if (obj == null) {
                this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
            } else {
                throw new IllegalStateException(("invalid pendingFrameContinuation " + obj).toString());
            }
        }
        return null;
    }

    public final void takeFrameRequestLocked() {
        boolean z11;
        if (this.pendingFrameContinuation == RecomposerKt.FramePending) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.pendingFrameContinuation = null;
            return;
        }
        throw new IllegalStateException("frame not pending".toString());
    }
}
