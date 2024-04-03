package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J9\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class SnackbarHostState {
    @NotNull
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "dismiss", "", "equals", "", "other", "", "hashCode", "", "performAction", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SnackbarDataImpl implements SnackbarData {
        @NotNull
        private final CancellableContinuation<SnackbarResult> continuation;
        @NotNull
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(@NotNull SnackbarVisuals snackbarVisuals, @NotNull CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(snackbarVisuals, "visuals");
            Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
            this.visuals = snackbarVisuals;
            this.continuation = cancellableContinuation;
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(SnackbarDataImpl.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            if (Intrinsics.areEqual((Object) getVisuals(), (Object) snackbarDataImpl.getVisuals()) && Intrinsics.areEqual((Object) this.continuation, (Object) snackbarDataImpl.continuation)) {
                return true;
            }
            return false;
        }

        @NotNull
        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                CancellableContinuation<SnackbarResult> cancellableContinuation = this.continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(SnackbarResult.ActionPerformed));
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SnackbarVisualsImpl implements SnackbarVisuals {
        @Nullable
        private final String actionLabel;
        @NotNull
        private final SnackbarDuration duration;
        @NotNull
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(@NotNull String str, @Nullable String str2, boolean z11, @NotNull SnackbarDuration snackbarDuration) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(snackbarDuration, "duration");
            this.message = str;
            this.actionLabel = str2;
            this.withDismissAction = z11;
            this.duration = snackbarDuration;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(SnackbarVisualsImpl.class), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            if (Intrinsics.areEqual((Object) getMessage(), (Object) snackbarVisualsImpl.getMessage()) && Intrinsics.areEqual((Object) getActionLabel(), (Object) snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration()) {
                return true;
            }
            return false;
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

        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public int hashCode() {
            int i11;
            int hashCode = getMessage().hashCode() * 31;
            String actionLabel2 = getActionLabel();
            if (actionLabel2 != null) {
                i11 = actionLabel2.hashCode();
            } else {
                i11 = 0;
            }
            return ((((hashCode + i11) * 31) + e.a(getWithDismissAction())) * 31) + getDuration().hashCode();
        }
    }

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z11, SnackbarDuration snackbarDuration, Continuation continuation, int i11, Object obj) {
        SnackbarDuration snackbarDuration2;
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            if (str3 == null) {
                snackbarDuration2 = SnackbarDuration.Short;
            } else {
                snackbarDuration2 = SnackbarDuration.Indefinite;
            }
            snackbarDuration = snackbarDuration2;
        }
        return snackbarHostState.showSnackbar(str, str3, z12, snackbarDuration, continuation);
    }

    @Nullable
    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    @Nullable
    public final Object showSnackbar(@NotNull String str, @Nullable String str2, boolean z11, @NotNull SnackbarDuration snackbarDuration, @NotNull Continuation<? super SnackbarResult> continuation) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z11, snackbarDuration), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x00a1=Splitter:B:28:0x00a1, B:34:0x00ad=Splitter:B:34:0x00ad} */
    @org.jetbrains.annotations.Nullable
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(@org.jetbrains.annotations.NotNull androidx.compose.material3.SnackbarVisuals r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.SnackbarHostState$showSnackbar$2
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r0
            int r1 = r0.f8256n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8256n = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = new androidx.compose.material3.SnackbarHostState$showSnackbar$2
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f8254l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f8256n
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005a
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r9 = r0.f8253k
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r9 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r9
            java.lang.Object r9 = r0.f8252j
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r1 = r0.f8251i
            androidx.compose.material3.SnackbarVisuals r1 = (androidx.compose.material3.SnackbarVisuals) r1
            java.lang.Object r0 = r0.f8250h
            androidx.compose.material3.SnackbarHostState r0 = (androidx.compose.material3.SnackbarHostState) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003d }
            goto L_0x00a1
        L_0x003d:
            r10 = move-exception
            goto L_0x00ad
        L_0x0040:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0048:
            java.lang.Object r9 = r0.f8252j
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.f8251i
            androidx.compose.material3.SnackbarVisuals r2 = (androidx.compose.material3.SnackbarVisuals) r2
            java.lang.Object r6 = r0.f8250h
            androidx.compose.material3.SnackbarHostState r6 = (androidx.compose.material3.SnackbarHostState) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L_0x006f
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.f8250h = r8
            r0.f8251i = r9
            r0.f8252j = r10
            r0.f8256n = r4
            java.lang.Object r2 = r10.lock(r5, r0)
            if (r2 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r6 = r8
        L_0x006f:
            r0.f8250h = r6     // Catch:{ all -> 0x00a8 }
            r0.f8251i = r9     // Catch:{ all -> 0x00a8 }
            r0.f8252j = r10     // Catch:{ all -> 0x00a8 }
            r0.f8253k = r0     // Catch:{ all -> 0x00a8 }
            r0.f8256n = r3     // Catch:{ all -> 0x00a8 }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00a8 }
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch:{ all -> 0x00a8 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00a8 }
            r2.initCancellability()     // Catch:{ all -> 0x00a8 }
            androidx.compose.material3.SnackbarHostState$SnackbarDataImpl r3 = new androidx.compose.material3.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x00a8 }
            r3.<init>(r9, r2)     // Catch:{ all -> 0x00a8 }
            r6.setCurrentSnackbarData(r3)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r9 = r2.getResult()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00a8 }
            if (r9 != r2) goto L_0x009a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00a8 }
        L_0x009a:
            if (r9 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00a1:
            r0.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00b1 }
            r9.unlock(r5)
            return r10
        L_0x00a8:
            r9 = move-exception
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00ad:
            r0.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00b1 }
            throw r10     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r10 = move-exception
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostState.showSnackbar(androidx.compose.material3.SnackbarVisuals, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
