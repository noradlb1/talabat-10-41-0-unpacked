package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$RangeSlider$2$onDrag$1$1 extends Lambda implements Function2<Boolean, Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5142g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5143h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5144i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5145j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5146k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f5147l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5148m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2$onDrag$1$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(2);
        this.f5142g = mutableState;
        this.f5143h = mutableState2;
        this.f5144i = closedFloatingPointRange;
        this.f5145j = floatRef;
        this.f5146k = floatRef2;
        this.f5147l = state;
        this.f5148m = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11, float f11) {
        ClosedFloatingPointRange closedFloatingPointRange;
        if (z11) {
            MutableState<Float> mutableState = this.f5142g;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f11));
            this.f5143h.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.f5148m, this.f5145j, this.f5146k, this.f5144i.getEndInclusive().floatValue())));
            float floatValue = this.f5143h.getValue().floatValue();
            closedFloatingPointRange = RangesKt__RangesKt.rangeTo(RangesKt___RangesKt.coerceIn(this.f5142g.getValue().floatValue(), this.f5145j.element, floatValue), floatValue);
        } else {
            MutableState<Float> mutableState2 = this.f5143h;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + f11));
            this.f5142g.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.f5148m, this.f5145j, this.f5146k, this.f5144i.getStart().floatValue())));
            float floatValue2 = this.f5142g.getValue().floatValue();
            closedFloatingPointRange = RangesKt__RangesKt.rangeTo(floatValue2, RangesKt___RangesKt.coerceIn(this.f5143h.getValue().floatValue(), floatValue2, this.f5146k.element));
        }
        this.f5147l.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(this.f5145j, this.f5146k, this.f5148m, closedFloatingPointRange));
    }
}
