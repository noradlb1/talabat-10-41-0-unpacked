package com.designsystem.ds_toast;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048@@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_toast/DSToastHostState;", "", "()V", "<set-?>", "Lcom/designsystem/ds_toast/DSToastHostState$ToastData;", "currentToastData", "getCurrentToastData$marshmallow_release", "()Lcom/designsystem/ds_toast/DSToastHostState$ToastData;", "setCurrentToastData", "(Lcom/designsystem/ds_toast/DSToastHostState$ToastData;)V", "currentToastData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "hideDSToast", "", "showDSToast", "model", "Lcom/designsystem/ds_toast/DSToastModel;", "(Lcom/designsystem/ds_toast/DSToastModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ToastData", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Stable
public final class DSToastHostState {
    @NotNull
    private final MutableState currentToastData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Stable
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/designsystem/ds_toast/DSToastHostState$ToastData;", "", "model", "Lcom/designsystem/ds_toast/DSToastModel;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lcom/designsystem/ds_toast/DSToastModel;Lkotlinx/coroutines/CancellableContinuation;)V", "getModel", "()Lcom/designsystem/ds_toast/DSToastModel;", "dismiss", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ToastData {
        @NotNull
        private final CancellableContinuation<Unit> continuation;
        @NotNull
        private final DSToastModel model;

        public ToastData(@NotNull DSToastModel dSToastModel, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(dSToastModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
            this.model = dSToastModel;
            this.continuation = cancellableContinuation;
        }

        public final void dismiss() {
            if (this.continuation.isActive()) {
                this.continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            }
        }

        @NotNull
        public final DSToastModel getModel() {
            return this.model;
        }
    }

    /* access modifiers changed from: private */
    public final void setCurrentToastData(ToastData toastData) {
        this.currentToastData$delegate.setValue(toastData);
    }

    @Nullable
    public final ToastData getCurrentToastData$marshmallow_release() {
        return (ToastData) this.currentToastData$delegate.getValue();
    }

    public final void hideDSToast() {
        ToastData currentToastData$marshmallow_release = getCurrentToastData$marshmallow_release();
        if (currentToastData$marshmallow_release != null) {
            currentToastData$marshmallow_release.dismiss();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showDSToast(@org.jetbrains.annotations.NotNull com.designsystem.ds_toast.DSToastModel r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.designsystem.ds_toast.DSToastHostState$showDSToast$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.designsystem.ds_toast.DSToastHostState$showDSToast$1 r0 = (com.designsystem.ds_toast.DSToastHostState$showDSToast$1) r0
            int r1 = r0.f33184n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33184n = r1
            goto L_0x0018
        L_0x0013:
            com.designsystem.ds_toast.DSToastHostState$showDSToast$1 r0 = new com.designsystem.ds_toast.DSToastHostState$showDSToast$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33182l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f33184n
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005a
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r9 = r0.f33181k
            com.designsystem.ds_toast.DSToastHostState$showDSToast$1 r9 = (com.designsystem.ds_toast.DSToastHostState$showDSToast$1) r9
            java.lang.Object r9 = r0.f33180j
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r1 = r0.f33179i
            com.designsystem.ds_toast.DSToastModel r1 = (com.designsystem.ds_toast.DSToastModel) r1
            java.lang.Object r0 = r0.f33178h
            com.designsystem.ds_toast.DSToastHostState r0 = (com.designsystem.ds_toast.DSToastHostState) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003d }
            goto L_0x009f
        L_0x003d:
            r10 = move-exception
            goto L_0x00ad
        L_0x0040:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0048:
            java.lang.Object r9 = r0.f33180j
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.f33179i
            com.designsystem.ds_toast.DSToastModel r2 = (com.designsystem.ds_toast.DSToastModel) r2
            java.lang.Object r6 = r0.f33178h
            com.designsystem.ds_toast.DSToastHostState r6 = (com.designsystem.ds_toast.DSToastHostState) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L_0x006f
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.f33178h = r8
            r0.f33179i = r9
            r0.f33180j = r10
            r0.f33184n = r4
            java.lang.Object r2 = r10.lock(r5, r0)
            if (r2 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r6 = r8
        L_0x006f:
            r0.f33178h = r6     // Catch:{ all -> 0x00a8 }
            r0.f33179i = r9     // Catch:{ all -> 0x00a8 }
            r0.f33180j = r10     // Catch:{ all -> 0x00a8 }
            r0.f33181k = r0     // Catch:{ all -> 0x00a8 }
            r0.f33184n = r3     // Catch:{ all -> 0x00a8 }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00a8 }
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)     // Catch:{ all -> 0x00a8 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00a8 }
            r2.initCancellability()     // Catch:{ all -> 0x00a8 }
            com.designsystem.ds_toast.DSToastHostState$ToastData r3 = new com.designsystem.ds_toast.DSToastHostState$ToastData     // Catch:{ all -> 0x00a8 }
            r3.<init>(r9, r2)     // Catch:{ all -> 0x00a8 }
            r6.setCurrentToastData(r3)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r9 = r2.getResult()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00a8 }
            if (r9 != r2) goto L_0x009a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00a8 }
        L_0x009a:
            if (r9 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r9 = r10
            r0 = r6
        L_0x009f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            r0.setCurrentToastData(r5)     // Catch:{ all -> 0x00b1 }
            r9.unlock(r5)
            return r10
        L_0x00a8:
            r9 = move-exception
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00ad:
            r0.setCurrentToastData(r5)     // Catch:{ all -> 0x00b1 }
            throw r10     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r10 = move-exception
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.DSToastHostState.showDSToast(com.designsystem.ds_toast.DSToastModel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
