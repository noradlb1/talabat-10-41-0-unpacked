package androidx.compose.foundation.layout;

import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FillModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;FLkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class FillModifier extends InspectorValueInfo implements LayoutModifier {
    @NotNull
    private final Direction direction;
    private final float fraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FillModifier(@NotNull Direction direction2, float f11, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(direction2, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.direction = direction2;
        this.fraction = f11;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FillModifier)) {
            return false;
        }
        FillModifier fillModifier = (FillModifier) obj;
        if (this.direction != fillModifier.direction) {
            return false;
        }
        return (this.fraction > fillModifier.fraction ? 1 : (this.fraction == fillModifier.fraction ? 0 : -1)) == 0;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public int hashCode() {
        return (this.direction.hashCode() * 31) + Float.floatToIntBits(this.fraction);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m453measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        int i11;
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!Constraints.m5418getHasBoundedWidthimpl(j11) || this.direction == Direction.Vertical) {
            i12 = Constraints.m5424getMinWidthimpl(j11);
            i11 = Constraints.m5422getMaxWidthimpl(j11);
        } else {
            i12 = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(((float) Constraints.m5422getMaxWidthimpl(j11)) * this.fraction), Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11));
            i11 = i12;
        }
        if (!Constraints.m5417getHasBoundedHeightimpl(j11) || this.direction == Direction.Horizontal) {
            int r22 = Constraints.m5423getMinHeightimpl(j11);
            i13 = Constraints.m5421getMaxHeightimpl(j11);
            i14 = r22;
        } else {
            i14 = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(((float) Constraints.m5421getMaxHeightimpl(j11)) * this.fraction), Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11));
            i13 = i14;
        }
        Placeable r92 = measurable.m4508measureBRTryo0(ConstraintsKt.Constraints(i12, i11, i14, i13));
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new FillModifier$measure$1(r92), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a0.a.a(this, modifier);
    }
}
