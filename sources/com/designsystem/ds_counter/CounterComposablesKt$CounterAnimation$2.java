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
@DebugMetadata(c = "com.designsystem.ds_counter.CounterComposablesKt$CounterAnimation$2", f = "CounterComposables.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
public final class CounterComposablesKt$CounterAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f30982h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f30983i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CounterChange f30984j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f30985k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CounterComposablesKt$CounterAnimation$2(Animatable<Dp, AnimationVector1D> animatable, CounterChange counterChange, float f11, Continuation<? super CounterComposablesKt$CounterAnimation$2> continuation) {
        super(2, continuation);
        this.f30983i = animatable;
        this.f30984j = counterChange;
        this.f30985k = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CounterComposablesKt$CounterAnimation$2(this.f30983i, this.f30984j, this.f30985k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CounterComposablesKt$CounterAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f30982h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Dp, AnimationVector1D> animatable = this.f30983i;
            Dp r102 = Dp.m5476boximpl(CounterComposablesKt.m8332getAnimateOutTargetValue3ABfNKs(this.f30984j, this.f30985k));
            TweenSpec access$counterAnimationSpec = CounterComposablesKt.counterAnimationSpec();
            this.f30982h = 1;
            if (Animatable.animateTo$default(animatable, r102, access$counterAnimationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
