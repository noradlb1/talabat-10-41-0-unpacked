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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$animateZoomBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2359h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2360i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f2361j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f2362k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animateZoomBy$3(Ref.FloatRef floatRef, float f11, AnimationSpec<Float> animationSpec, Continuation<? super TransformableStateKt$animateZoomBy$3> continuation) {
        super(2, continuation);
        this.f2360i = floatRef;
        this.f2361j = f11;
        this.f2362k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableStateKt$animateZoomBy$3 transformableStateKt$animateZoomBy$3 = new TransformableStateKt$animateZoomBy$3(this.f2360i, this.f2361j, this.f2362k, continuation);
        transformableStateKt$animateZoomBy$3.L$0 = obj;
        return transformableStateKt$animateZoomBy$3;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animateZoomBy$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2359h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(this.f2360i.element, 0.0f, 0, 0, false, 30, (Object) null);
            Float boxFloat = Boxing.boxFloat(this.f2361j);
            AnimationSpec<Float> animationSpec = this.f2362k;
            final Ref.FloatRef floatRef = this.f2360i;
            AnonymousClass1 r62 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AnimationScope<Float, AnimationVector1D> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$animateTo");
                    d.a(transformScope, (floatRef.element > 0.0f ? 1 : (floatRef.element == 0.0f ? 0 : -1)) == 0 ? 1.0f : animationScope.getValue().floatValue() / floatRef.element, 0, 0.0f, 6, (Object) null);
                    floatRef.element = animationScope.getValue().floatValue();
                }
            };
            this.f2359h = 1;
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
