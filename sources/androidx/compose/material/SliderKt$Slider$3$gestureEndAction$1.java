package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Slider$3$gestureEndAction$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5197g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5198h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5199i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5200j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f5201k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SliderDraggableState f5202l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5203m;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f5204h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(sliderDraggableState, floatValue, access$snapValueToTick, f12, function02, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f5204h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                SliderDraggableState sliderDraggableState = sliderDraggableState;
                float f11 = floatValue;
                float f12 = access$snapValueToTick;
                float f13 = f12;
                this.f5204h = 1;
                if (SliderKt.animateToTarget(sliderDraggableState, f11, f12, f13, this) == coroutine_suspended) {
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
    public SliderKt$Slider$3$gestureEndAction$1(MutableState<Float> mutableState, List<Float> list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, CoroutineScope coroutineScope, SliderDraggableState sliderDraggableState, Function0<Unit> function0) {
        super(1);
        this.f5197g = mutableState;
        this.f5198h = list;
        this.f5199i = floatRef;
        this.f5200j = floatRef2;
        this.f5201k = coroutineScope;
        this.f5202l = sliderDraggableState;
        this.f5203m = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        Function0<Unit> function0;
        final float floatValue = this.f5197g.getValue().floatValue();
        final float access$snapValueToTick = SliderKt.snapValueToTick(floatValue, this.f5198h, this.f5199i.element, this.f5200j.element);
        if (!(floatValue == access$snapValueToTick)) {
            CoroutineScope coroutineScope = this.f5201k;
            final SliderDraggableState sliderDraggableState = this.f5202l;
            final Function0<Unit> function02 = this.f5203m;
            final float f12 = f11;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        } else if (!this.f5202l.isDragging() && (function0 = this.f5203m) != null) {
            function0.invoke();
        }
    }
}
