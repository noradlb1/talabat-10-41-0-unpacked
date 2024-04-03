package com.designsystem.ds_stepper;

import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "com.designsystem.ds_stepper.StepperComposablesKt$Stepper$collapseComponentWithDelay$1", f = "StepperComposables.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class StepperComposablesKt$Stepper$collapseComponentWithDelay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f32930h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32931i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$Stepper$collapseComponentWithDelay$1(MutableState<Boolean> mutableState, Continuation<? super StepperComposablesKt$Stepper$collapseComponentWithDelay$1> continuation) {
        super(2, continuation);
        this.f32931i = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StepperComposablesKt$Stepper$collapseComponentWithDelay$1(this.f32931i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StepperComposablesKt$Stepper$collapseComponentWithDelay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f32930h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f32930h = 1;
            if (DelayKt.delay(4000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        StepperComposablesKt.m8600Stepper$lambda5(this.f32931i, true);
        return Unit.INSTANCE;
    }
}
