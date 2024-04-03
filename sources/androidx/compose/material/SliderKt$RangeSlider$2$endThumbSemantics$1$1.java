package androidx.compose.material;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$RangeSlider$2$endThumbSemantics$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> f5113g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f5114h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$2$endThumbSemantics$1$1(State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float f11) {
        super(1);
        this.f5113g = state;
        this.f5114h = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        this.f5113g.getValue().invoke(RangesKt__RangesKt.rangeTo(this.f5114h, f11));
    }
}
