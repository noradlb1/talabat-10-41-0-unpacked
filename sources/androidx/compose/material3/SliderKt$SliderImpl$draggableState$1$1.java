package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$SliderImpl$draggableState$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f8085g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f8086h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f8087i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f8088j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float[] f8089k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f8090l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8091m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$draggableState$1$1(MutableState<Integer> mutableState, MutableState<Float> mutableState2, MutableState<Float> mutableState3, MutableState<Float> mutableState4, float[] fArr, State<? extends Function1<? super Float, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.f8085g = mutableState;
        this.f8086h = mutableState2;
        this.f8087i = mutableState3;
        this.f8088j = mutableState4;
        this.f8089k = fArr;
        this.f8090l = state;
        this.f8091m = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        float f12 = (float) 2;
        float max = Math.max(this.f8085g.getValue().floatValue() - (this.f8086h.getValue().floatValue() / f12), 0.0f);
        float min = Math.min(this.f8086h.getValue().floatValue() / f12, max);
        MutableState<Float> mutableState = this.f8087i;
        mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + f11 + this.f8088j.getValue().floatValue()));
        this.f8088j.setValue(Float.valueOf(0.0f));
        this.f8090l.getValue().invoke(Float.valueOf(SliderKt.SliderImpl$scaleToUserValue(this.f8091m, min, max, SliderKt.snapValueToTick(this.f8087i.getValue().floatValue(), this.f8089k, min, max))));
    }
}
