package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwipeableState$draggableState$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8452g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$draggableState$1(SwipeableState<T> swipeableState) {
        super(1);
        this.f8452g = swipeableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        float floatValue = ((Number) this.f8452g.absoluteOffset.getValue()).floatValue() + f11;
        float coerceIn = RangesKt___RangesKt.coerceIn(floatValue, this.f8452g.getMinBound$material3_release(), this.f8452g.getMaxBound$material3_release());
        float f12 = floatValue - coerceIn;
        ResistanceConfig resistance$material3_release = this.f8452g.getResistance$material3_release();
        this.f8452g.offsetState.setValue(Float.valueOf(coerceIn + (resistance$material3_release != null ? resistance$material3_release.computeResistance(f12) : 0.0f)));
        this.f8452g.overflowState.setValue(Float.valueOf(f12));
        this.f8452g.absoluteOffset.setValue(Float.valueOf(floatValue));
    }
}
