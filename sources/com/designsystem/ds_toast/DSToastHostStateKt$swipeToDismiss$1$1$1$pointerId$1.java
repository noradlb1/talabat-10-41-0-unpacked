package com.designsystem.ds_toast;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_toast.DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1", f = "DSToastHostState.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
public final class DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerId>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f33236h;

    public DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1(Continuation<? super DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1 dSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1 = new DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1(continuation);
        dSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1.L$0 = obj;
        return dSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1;
    }

    @Nullable
    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super PointerId> continuation) {
        return ((DSToastHostStateKt$swipeToDismiss$1$1$1$pointerId$1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f33236h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f33236h = 1;
            obj = TapGestureDetectorKt.awaitFirstDown$default((AwaitPointerEventScope) this.L$0, false, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return PointerId.m4288boximpl(((PointerInputChange) obj).m4305getIdJ3iCeTQ());
    }
}
