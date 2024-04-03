package androidx.compose.foundation;

import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ProgressSemanticsKt$progressSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f1783g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f1784h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1785i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressSemanticsKt$progressSemantics$1(float f11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11) {
        super(1);
        this.f1783g = f11;
        this.f1784h = closedFloatingPointRange;
        this.f1785i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) RangesKt___RangesKt.coerceIn(Float.valueOf(this.f1783g), this.f1784h)).floatValue(), this.f1784h, this.f1785i));
    }
}
