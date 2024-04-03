package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.DragScope;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/DragScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {927}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$animateToTarget$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f5259h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5260i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5261j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5262k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$animateToTarget$2(float f11, float f12, float f13, Continuation<? super SliderKt$animateToTarget$2> continuation) {
        super(2, continuation);
        this.f5260i = f11;
        this.f5261j = f12;
        this.f5262k = f13;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SliderKt$animateToTarget$2 sliderKt$animateToTarget$2 = new SliderKt$animateToTarget$2(this.f5260i, this.f5261j, this.f5262k, continuation);
        sliderKt$animateToTarget$2.L$0 = obj;
        return sliderKt$animateToTarget$2;
    }

    @Nullable
    public final Object invoke(@NotNull DragScope dragScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SliderKt$animateToTarget$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f5259h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final DragScope dragScope = (DragScope) this.L$0;
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            float f11 = this.f5260i;
            floatRef.element = f11;
            Animatable Animatable$default = AnimatableKt.Animatable$default(f11, 0.0f, 2, (Object) null);
            Float boxFloat = Boxing.boxFloat(this.f5261j);
            TweenSpec access$getSliderToTickAnimation$p = SliderKt.SliderToTickAnimation;
            Float boxFloat2 = Boxing.boxFloat(this.f5262k);
            AnonymousClass1 r11 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
                    Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
                    dragScope.dragBy(animatable.getValue().floatValue() - floatRef.element);
                    floatRef.element = animatable.getValue().floatValue();
                }
            };
            this.f5259h = 1;
            if (Animatable$default.animateTo(boxFloat, access$getSliderToTickAnimation$p, boxFloat2, r11, this) == coroutine_suspended) {
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
