package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import o.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$animateRotateBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2353h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2354i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f2355j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f2356k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animateRotateBy$2(Ref.FloatRef floatRef, float f11, AnimationSpec<Float> animationSpec, Continuation<? super TransformableStateKt$animateRotateBy$2> continuation) {
        super(2, continuation);
        this.f2354i = floatRef;
        this.f2355j = f11;
        this.f2356k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableStateKt$animateRotateBy$2 transformableStateKt$animateRotateBy$2 = new TransformableStateKt$animateRotateBy$2(this.f2354i, this.f2355j, this.f2356k, continuation);
        transformableStateKt$animateRotateBy$2.L$0 = obj;
        return transformableStateKt$animateRotateBy$2;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animateRotateBy$2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2353h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(this.f2354i.element, 0.0f, 0, 0, false, 30, (Object) null);
            Float boxFloat = Boxing.boxFloat(this.f2355j);
            AnimationSpec<Float> animationSpec = this.f2356k;
            final Ref.FloatRef floatRef = this.f2354i;
            AnonymousClass1 r62 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
                    d.a(transformScope, 0.0f, 0, animationScope.getValue().floatValue() - floatRef.element, 3, (Object) null);
                    floatRef.element = animationScope.getValue().floatValue();
                }
            };
            this.f2353h = 1;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec, false, r62, this, 4, (Object) null) == coroutine_suspended) {
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
