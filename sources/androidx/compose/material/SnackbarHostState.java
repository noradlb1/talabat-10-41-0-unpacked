package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
public final class SnackbarHostState {
    @NotNull
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Stable
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        @Nullable
        private final String actionLabel;
        @NotNull
        private final CancellableContinuation<SnackbarResult> continuation;
        @NotNull
        private final SnackbarDuration duration;
        @NotNull
        private final String message;

        public SnackbarDataImpl(@NotNull String str, @Nullable String str2, @NotNull SnackbarDuration snackbarDuration, @NotNull CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(snackbarDuration, "duration");
            Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
            this.message = str;
            this.actionLabel = str2;
            this.duration = snackbarDuration;
            this.continuation = cancellableContinuation;
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(SnackbarResult.Dismissed));
            }
        }

        @Nullable
        public String getActionLabel() {
            return this.actionLabel;
        }

        @NotNull
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @NotNull
        public String getMessage() {
            return this.message;
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(SnackbarResult.ActionPerformed));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, continuation);
    }

    @Nullable
    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.material.SnackbarDuration} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6 A[Catch:{ all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00c8=Splitter:B:34:0x00c8, B:28:0x00bf=Splitter:B:28:0x00bf} */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarDuration r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.material.SnackbarResult> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof androidx.compose.material.SnackbarHostState$showSnackbar$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r0 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r0
            int r1 = r0.f5398p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5398p = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r0 = new androidx.compose.material.SnackbarHostState$showSnackbar$1
            r0.<init>(r8, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f5396n
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f5398p
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x006f
            if (r2 == r4) goto L_0x0051
            if (r2 != r3) goto L_0x0049
            java.lang.Object r9 = r0.f5395m
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r9 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r9
            java.lang.Object r9 = r0.f5394l
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.f5393k
            androidx.compose.material.SnackbarDuration r10 = (androidx.compose.material.SnackbarDuration) r10
            java.lang.Object r10 = r0.f5392j
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.f5391i
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.f5390h
            androidx.compose.material.SnackbarHostState r10 = (androidx.compose.material.SnackbarHostState) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0046 }
            goto L_0x00bf
        L_0x0046:
            r11 = move-exception
            goto L_0x00c8
        L_0x0049:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0051:
            java.lang.Object r9 = r0.f5394l
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.f5393k
            r11 = r10
            androidx.compose.material.SnackbarDuration r11 = (androidx.compose.material.SnackbarDuration) r11
            java.lang.Object r10 = r0.f5392j
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.f5391i
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.f5390h
            androidx.compose.material.SnackbarHostState r6 = (androidx.compose.material.SnackbarHostState) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r9
            r9 = r2
            r2 = r11
            r11 = r10
            r10 = r6
            goto L_0x008a
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r8.mutex
            r0.f5390h = r8
            r0.f5391i = r9
            r0.f5392j = r10
            r0.f5393k = r11
            r0.f5394l = r12
            r0.f5398p = r4
            java.lang.Object r2 = r12.lock(r5, r0)
            if (r2 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r2 = r11
            r11 = r10
            r10 = r8
        L_0x008a:
            r0.f5390h = r10     // Catch:{ all -> 0x00c6 }
            r0.f5391i = r9     // Catch:{ all -> 0x00c6 }
            r0.f5392j = r11     // Catch:{ all -> 0x00c6 }
            r0.f5393k = r2     // Catch:{ all -> 0x00c6 }
            r0.f5394l = r12     // Catch:{ all -> 0x00c6 }
            r0.f5395m = r0     // Catch:{ all -> 0x00c6 }
            r0.f5398p = r3     // Catch:{ all -> 0x00c6 }
            kotlinx.coroutines.CancellableContinuationImpl r3 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00c6 }
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch:{ all -> 0x00c6 }
            r3.<init>(r6, r4)     // Catch:{ all -> 0x00c6 }
            r3.initCancellability()     // Catch:{ all -> 0x00c6 }
            androidx.compose.material.SnackbarHostState$SnackbarDataImpl r4 = new androidx.compose.material.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x00c6 }
            r4.<init>(r9, r11, r2, r3)     // Catch:{ all -> 0x00c6 }
            r10.setCurrentSnackbarData(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.Object r9 = r3.getResult()     // Catch:{ all -> 0x00c6 }
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00c6 }
            if (r9 != r11) goto L_0x00b9
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00c6 }
        L_0x00b9:
            if (r9 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            r7 = r12
            r12 = r9
            r9 = r7
        L_0x00bf:
            r10.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00cc }
            r9.unlock(r5)
            return r12
        L_0x00c6:
            r11 = move-exception
            r9 = r12
        L_0x00c8:
            r10.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00cc }
            throw r11     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r10 = move-exception
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.showSnackbar(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
