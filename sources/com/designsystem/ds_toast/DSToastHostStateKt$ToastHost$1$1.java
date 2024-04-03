package com.designsystem.ds_toast;

import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_toast.DSToastHostStateKt$ToastHost$1$1", f = "DSToastHostState.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class DSToastHostStateKt$ToastHost$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f33204h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33205i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$ToastHost$1$1(DSToastHostState.ToastData toastData, Continuation<? super DSToastHostStateKt$ToastHost$1$1> continuation) {
        super(2, continuation);
        this.f33205i = toastData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DSToastHostStateKt$ToastHost$1$1(this.f33205i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSToastHostStateKt$ToastHost$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f33204h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DSToastHostState.ToastData toastData = this.f33205i;
            if (toastData != null) {
                if (toastData.getModel().hasAction$marshmallow_release()) {
                    j11 = 5000;
                } else {
                    j11 = 4000;
                }
                this.f33204h = 1;
                if (DelayKt.delay(j11, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f33205i.dismiss();
        return Unit.INSTANCE;
    }
}
