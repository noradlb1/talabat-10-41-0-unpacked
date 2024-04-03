package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollState$scrollableState$1 extends Lambda implements Function1<Float, Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScrollState f1812g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollState$scrollableState$1(ScrollState scrollState) {
        super(1);
        this.f1812g = scrollState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    @NotNull
    public final Float invoke(float f11) {
        float value = ((float) this.f1812g.getValue()) + f11 + this.f1812g.accumulator;
        float coerceIn = RangesKt___RangesKt.coerceIn(value, 0.0f, (float) this.f1812g.getMaxValue());
        boolean z11 = !(value == coerceIn);
        float value2 = coerceIn - ((float) this.f1812g.getValue());
        int roundToInt = MathKt__MathJVMKt.roundToInt(value2);
        ScrollState scrollState = this.f1812g;
        scrollState.setValue(scrollState.getValue() + roundToInt);
        this.f1812g.accumulator = value2 - ((float) roundToInt);
        if (z11) {
            f11 = value2;
        }
        return Float.valueOf(f11);
    }
}
