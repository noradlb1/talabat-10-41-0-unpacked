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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PaddingValuesModifier extends InspectorValueInfo implements LayoutModifier {
    @NotNull
    private final PaddingValues paddingValues;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaddingValuesModifier(@NotNull PaddingValues paddingValues2, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.paddingValues = paddingValues2;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        PaddingValuesModifier paddingValuesModifier;
        if (obj instanceof PaddingValuesModifier) {
            paddingValuesModifier = (PaddingValuesModifier) obj;
        } else {
            paddingValuesModifier = null;
        }
        if (paddingValuesModifier == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.paddingValues, (Object) paddingValuesModifier.paddingValues);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m520measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        boolean z11 = false;
        float f11 = (float) 0;
        if (Dp.m5477compareTo0680j_4(this.paddingValues.m497calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m5478constructorimpl(f11)) >= 0 && Dp.m5477compareTo0680j_4(this.paddingValues.m499calculateTopPaddingD9Ej5fM(), Dp.m5478constructorimpl(f11)) >= 0 && Dp.m5477compareTo0680j_4(this.paddingValues.m498calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m5478constructorimpl(f11)) >= 0 && Dp.m5477compareTo0680j_4(this.paddingValues.m496calculateBottomPaddingD9Ej5fM(), Dp.m5478constructorimpl(f11)) >= 0) {
            z11 = true;
        }
        if (z11) {
            int r02 = measureScope.m5441roundToPx0680j_4(this.paddingValues.m497calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.m5441roundToPx0680j_4(this.paddingValues.m498calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
            int r12 = measureScope.m5441roundToPx0680j_4(this.paddingValues.m499calculateTopPaddingD9Ej5fM()) + measureScope.m5441roundToPx0680j_4(this.paddingValues.m496calculateBottomPaddingD9Ej5fM());
            Placeable r122 = measurable.m4508measureBRTryo0(ConstraintsKt.m5438offsetNN6EwU(j11, -r02, -r12));
            return MeasureScope.CC.p(measureScope, ConstraintsKt.m5436constrainWidthK40F9xA(j11, r122.getWidth() + r02), ConstraintsKt.m5435constrainHeightK40F9xA(j11, r122.getHeight() + r12), (Map) null, new PaddingValuesModifier$measure$2(r122, measureScope, this), 4, (Object) null);
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
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
