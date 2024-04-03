package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$CorrectValueSideEffect$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5085g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Float> f5086h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5087i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5088j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f5089k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$CorrectValueSideEffect$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super Float, Float> function1, float f11, MutableState<Float> mutableState, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(0);
        this.f5085g = closedFloatingPointRange;
        this.f5086h = function1;
        this.f5087i = f11;
        this.f5088j = mutableState;
        this.f5089k = closedFloatingPointRange2;
    }

    public final void invoke() {
        float floatValue = (this.f5085g.getEndInclusive().floatValue() - this.f5085g.getStart().floatValue()) / ((float) 1000);
        float floatValue2 = this.f5086h.invoke(Float.valueOf(this.f5087i)).floatValue();
        if (Math.abs(floatValue2 - this.f5088j.getValue().floatValue()) > floatValue && this.f5089k.contains(this.f5088j.getValue())) {
            this.f5088j.setValue(Float.valueOf(floatValue2));
        }
    }
}
