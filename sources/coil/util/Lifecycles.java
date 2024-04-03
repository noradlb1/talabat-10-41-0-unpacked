package coil.util;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeStarted", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Lifecycles")
/* renamed from: coil.util.-Lifecycles  reason: invalid class name */
public final class Lifecycles {
    @Nullable
    @MainThread
    public static final Object awaitStarted(@NotNull Lifecycle lifecycle, @NotNull Continuation<? super Unit> continuation) {
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return Unit.INSTANCE;
        }
        Object observeStarted = observeStarted(lifecycle, continuation);
        if (observeStarted == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return observeStarted;
        }
        return Unit.INSTANCE;
    }

    @MainThread
    private static final Object awaitStarted$$forInline(Lifecycle lifecycle, Continuation<? super Unit> continuation) {
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            return Unit.INSTANCE;
        }
        InlineMarker.mark(0);
        observeStarted(lifecycle, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object observeStarted(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof coil.util.Lifecycles$observeStarted$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            coil.util.-Lifecycles$observeStarted$1 r0 = (coil.util.Lifecycles$observeStarted$1) r0
            int r1 = r0.f39822k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39822k = r1
            goto L_0x0018
        L_0x0013:
            coil.util.-Lifecycles$observeStarted$1 r0 = new coil.util.-Lifecycles$observeStarted$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f39821j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39822k
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.f39820i
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f39819h
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0031 }
            goto L_0x0076
        L_0x0031:
            r7 = move-exception
            goto L_0x0088
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.f39819h = r6     // Catch:{ all -> 0x0083 }
            r0.f39820i = r7     // Catch:{ all -> 0x0083 }
            r0.f39822k = r3     // Catch:{ all -> 0x0083 }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0083 }
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch:{ all -> 0x0083 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0083 }
            r2.initCancellability()     // Catch:{ all -> 0x0083 }
            coil.util.-Lifecycles$observeStarted$2$1 r3 = new coil.util.-Lifecycles$observeStarted$2$1     // Catch:{ all -> 0x0083 }
            r3.<init>(r2)     // Catch:{ all -> 0x0083 }
            r7.element = r3     // Catch:{ all -> 0x0083 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0083 }
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3     // Catch:{ all -> 0x0083 }
            r6.addObserver(r3)     // Catch:{ all -> 0x0083 }
            java.lang.Object r2 = r2.getResult()     // Catch:{ all -> 0x0083 }
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0083 }
            if (r2 != r3) goto L_0x0071
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0083 }
        L_0x0071:
            if (r2 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r0 = r6
            r6 = r7
        L_0x0076:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 != 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r0.removeObserver(r6)
        L_0x0080:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0083:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x0088:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 != 0) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r0.removeObserver(r6)
        L_0x0092:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Lifecycles.observeStarted(androidx.lifecycle.Lifecycle, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
