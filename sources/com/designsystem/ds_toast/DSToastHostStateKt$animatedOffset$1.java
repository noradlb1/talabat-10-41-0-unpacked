package com.designsystem.ds_toast;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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
@DebugMetadata(c = "com.designsystem.ds_toast.DSToastHostStateKt$animatedOffset$1", f = "DSToastHostState.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
public final class DSToastHostStateKt$animatedOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f33211h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f33212i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f33213j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f33214k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f33215l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$animatedOffset$1(Animatable<Float, AnimationVector1D> animatable, boolean z11, float f11, AnimationSpec<Float> animationSpec, Continuation<? super DSToastHostStateKt$animatedOffset$1> continuation) {
        super(2, continuation);
        this.f33212i = animatable;
        this.f33213j = z11;
        this.f33214k = f11;
        this.f33215l = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DSToastHostStateKt$animatedOffset$1(this.f33212i, this.f33213j, this.f33214k, this.f33215l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSToastHostStateKt$animatedOffset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f33211h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.f33212i;
            if (this.f33213j) {
                f11 = 0.0f;
            } else {
                f11 = this.f33214k;
            }
            Float boxFloat = Boxing.boxFloat(f11);
            AnimationSpec<Float> animationSpec = this.f33215l;
            this.f33211h = 1;
            if (Animatable.animateTo$default(animatable, boxFloat, animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
