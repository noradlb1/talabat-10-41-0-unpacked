package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$RangeSlider$2$gestureEndAction$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5115g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5116h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5117i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5118j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5119k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5120l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f5121m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f5122n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5123o;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f5124h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(floatValue, access$snapValueToTick, function02, z12, mutableState, mutableState2, state, floatRef, floatRef2, closedFloatingPointRange, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f5124h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable Animatable$default = AnimatableKt.Animatable$default(floatValue, 0.0f, 2, (Object) null);
                Float boxFloat = Boxing.boxFloat(access$snapValueToTick);
                TweenSpec access$getSliderToTickAnimation$p = SliderKt.SliderToTickAnimation;
                Float boxFloat2 = Boxing.boxFloat(0.0f);
                final boolean z11 = z12;
                final MutableState<Float> mutableState = mutableState;
                final MutableState<Float> mutableState2 = mutableState2;
                final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = state;
                final Ref.FloatRef floatRef = floatRef;
                final Ref.FloatRef floatRef2 = floatRef2;
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = closedFloatingPointRange;
                AnonymousClass1 r82 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
                        Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
                        (z11 ? mutableState : mutableState2).setValue(animatable.getValue());
                        state.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt__RangesKt.rangeTo(mutableState.getValue().floatValue(), mutableState2.getValue().floatValue())));
                    }
                };
                this.f5124h = 1;
                if (Animatable$default.animateTo(boxFloat, access$getSliderToTickAnimation$p, boxFloat2, r82, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function0<Unit> function0 = function02;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2$gestureEndAction$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, List<Float> list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0<Unit> function0, CoroutineScope coroutineScope, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.f5115g = mutableState;
        this.f5116h = mutableState2;
        this.f5117i = list;
        this.f5118j = floatRef;
        this.f5119k = floatRef2;
        this.f5120l = function0;
        this.f5121m = coroutineScope;
        this.f5122n = state;
        this.f5123o = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        final float floatValue = (z11 ? this.f5115g : this.f5116h).getValue().floatValue();
        final float access$snapValueToTick = SliderKt.snapValueToTick(floatValue, this.f5117i, this.f5118j.element, this.f5119k.element);
        if (floatValue == access$snapValueToTick) {
            Function0<Unit> function0 = this.f5120l;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        CoroutineScope coroutineScope = this.f5121m;
        final Function0<Unit> function02 = this.f5120l;
        final MutableState<Float> mutableState = this.f5115g;
        final MutableState<Float> mutableState2 = this.f5116h;
        final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.f5122n;
        final Ref.FloatRef floatRef = this.f5118j;
        final Ref.FloatRef floatRef2 = this.f5119k;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.f5123o;
        final boolean z12 = z11;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
