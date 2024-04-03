package androidx.compose.material;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$drag$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$Slider$3$drag$1$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5188h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ float f5189i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f5190j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$3$drag$1$1(State<? extends Function1<? super Float, Unit>> state, Continuation<? super SliderKt$Slider$3$drag$1$1> continuation) {
        super(3, continuation);
        this.f5190j = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, float f11, @Nullable Continuation<? super Unit> continuation) {
        SliderKt$Slider$3$drag$1$1 sliderKt$Slider$3$drag$1$1 = new SliderKt$Slider$3$drag$1$1(this.f5190j, continuation);
        sliderKt$Slider$3$drag$1$1.f5189i = f11;
        return sliderKt$Slider$3$drag$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f5188h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f5190j.getValue().invoke(Boxing.boxFloat(this.f5189i));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
