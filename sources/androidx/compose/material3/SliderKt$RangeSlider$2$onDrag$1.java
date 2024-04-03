package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSlider$2$onDrag$1 extends Lambda implements Function2<Boolean, Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f7963g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f7964h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7965i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f7966j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float[] f7967k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f7968l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f7969m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7970n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2$onDrag$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, float[] fArr, Ref.FloatRef floatRef2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(2);
        this.f7963g = mutableState;
        this.f7964h = mutableState2;
        this.f7965i = closedFloatingPointRange;
        this.f7966j = floatRef;
        this.f7967k = fArr;
        this.f7968l = floatRef2;
        this.f7969m = state;
        this.f7970n = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11, float f11) {
        ClosedFloatingPointRange closedFloatingPointRange;
        if (z11) {
            MutableState<Float> mutableState = this.f7963g;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f11));
            this.f7964h.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.f7970n, this.f7966j, this.f7968l, this.f7965i.getEndInclusive().floatValue())));
            float floatValue = this.f7964h.getValue().floatValue();
            closedFloatingPointRange = RangesKt__RangesKt.rangeTo(SliderKt.snapValueToTick(RangesKt___RangesKt.coerceIn(this.f7963g.getValue().floatValue(), this.f7966j.element, floatValue), this.f7967k, this.f7966j.element, this.f7968l.element), floatValue);
        } else {
            MutableState<Float> mutableState2 = this.f7964h;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + f11));
            this.f7963g.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.f7970n, this.f7966j, this.f7968l, this.f7965i.getStart().floatValue())));
            float floatValue2 = this.f7963g.getValue().floatValue();
            closedFloatingPointRange = RangesKt__RangesKt.rangeTo(floatValue2, SliderKt.snapValueToTick(RangesKt___RangesKt.coerceIn(this.f7964h.getValue().floatValue(), floatValue2, this.f7968l.element), this.f7967k, this.f7966j.element, this.f7968l.element));
        }
        this.f7969m.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(this.f7966j, this.f7968l, this.f7970n, closedFloatingPointRange));
    }
}
