package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSlider$onValueChangeState$1$1 extends Lambda implements Function1<ClosedFloatingPointRange<Float>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f7983g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> f7984h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSlider$onValueChangeState$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1) {
        super(1);
        this.f7983g = closedFloatingPointRange;
        this.f7984h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ClosedFloatingPointRange<Float>) (ClosedFloatingPointRange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "it");
        if (!Intrinsics.areEqual((Object) closedFloatingPointRange, (Object) this.f7983g)) {
            this.f7984h.invoke(closedFloatingPointRange);
        }
    }
}
