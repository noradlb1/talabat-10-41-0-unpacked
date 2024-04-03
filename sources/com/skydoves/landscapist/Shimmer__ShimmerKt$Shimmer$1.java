package com.skydoves.landscapist;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$1", f = "Shimmer.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class Shimmer__ShimmerKt$Shimmer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f52972h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f52973i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f52974j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Shimmer__ShimmerKt$Shimmer$1(Animatable<Float, AnimationVector1D> animatable, int i11, Continuation<? super Shimmer__ShimmerKt$Shimmer$1> continuation) {
        super(2, continuation);
        this.f52973i = animatable;
        this.f52974j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new Shimmer__ShimmerKt$Shimmer$1(this.f52973i, this.f52974j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Shimmer__ShimmerKt$Shimmer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f52972h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.f52973i;
            Float boxFloat = Boxing.boxFloat(1.0f);
            InfiniteRepeatableSpec infiniteRepeatable$default = AnimationSpecKt.infiniteRepeatable$default(AnimationSpecKt.tween$default(this.f52974j, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 2, (Object) null);
            this.f52972h = 1;
            if (Animatable.animateTo$default(animatable, boxFloat, infiniteRepeatable$default, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
