package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Slider$3$draggableState$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5191g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5192h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5193i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5194j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f5195k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5196l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$3$draggableState$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State<? extends Function1<? super Float, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.f5191g = mutableState;
        this.f5192h = mutableState2;
        this.f5193i = floatRef;
        this.f5194j = floatRef2;
        this.f5195k = state;
        this.f5196l = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        MutableState<Float> mutableState = this.f5191g;
        mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f11 + this.f5192h.getValue().floatValue()));
        this.f5192h.setValue(Float.valueOf(0.0f));
        this.f5195k.getValue().invoke(Float.valueOf(SliderKt$Slider$3.invoke$scaleToUserValue(this.f5193i, this.f5194j, this.f5196l, RangesKt___RangesKt.coerceIn(this.f5191g.getValue().floatValue(), this.f5193i.element, this.f5194j.element))));
    }
}
