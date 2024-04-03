package com.designsystem.ds_counter;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_counter.CounterComposablesKt$CounterAnimation$3", f = "CounterComposables.kt", i = {}, l = {194, 196}, m = "invokeSuspend", n = {}, s = {})
public final class CounterComposablesKt$CounterAnimation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30986h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CounterChange f30987i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f30988j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f30989k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterAnimation$3(CounterChange counterChange, float f11, Animatable<Dp, AnimationVector1D> animatable, Continuation<? super CounterComposablesKt$CounterAnimation$3> continuation) {
        super(2, continuation);
        this.f30987i = counterChange;
        this.f30988j = f11;
        this.f30989k = animatable;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CounterComposablesKt$CounterAnimation$3(this.f30987i, this.f30988j, this.f30989k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CounterComposablesKt$CounterAnimation$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30986h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f30987i == CounterChange.INCREASE) {
                f11 = this.f30988j;
            } else {
                f11 = Dp.m5478constructorimpl(-this.f30988j);
            }
            Animatable<Dp, AnimationVector1D> animatable = this.f30989k;
            Dp r12 = Dp.m5476boximpl(f11);
            this.f30986h = 1;
            if (animatable.snapTo(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Animatable<Dp, AnimationVector1D> animatable2 = this.f30989k;
        Dp r42 = Dp.m5476boximpl(Dp.m5478constructorimpl((float) 0));
        TweenSpec access$counterAnimationSpec = CounterComposablesKt.counterAnimationSpec();
        this.f30986h = 2;
        if (Animatable.animateTo$default(animatable2, r42, access$counterAnimationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
