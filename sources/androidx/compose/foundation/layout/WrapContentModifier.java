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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J)\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "equals", "other", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class WrapContentModifier extends InspectorValueInfo implements LayoutModifier {
    @NotNull
    private final Object align;
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    @NotNull
    private final Direction direction;
    private final boolean unbounded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapContentModifier(@NotNull Direction direction2, boolean z11, @NotNull Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2, @NotNull Object obj, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(direction2, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(function2, "alignmentCallback");
        Intrinsics.checkNotNullParameter(obj, "align");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.direction = direction2;
        this.unbounded = z11;
        this.alignmentCallback = function2;
        this.align = obj;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof WrapContentModifier)) {
            return false;
        }
        WrapContentModifier wrapContentModifier = (WrapContentModifier) obj;
        if (this.direction == wrapContentModifier.direction && this.unbounded == wrapContentModifier.unbounded && Intrinsics.areEqual(this.align, wrapContentModifier.align)) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + e.a(this.unbounded)) * 31) + this.align.hashCode();
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m609measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        int i11;
        int i12;
        Measurable measurable2 = measurable;
        MeasureScope measureScope2 = measureScope;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        Direction direction2 = this.direction;
        Direction direction3 = Direction.Vertical;
        int i13 = 0;
        if (direction2 != direction3) {
            i11 = 0;
        } else {
            i11 = Constraints.m5424getMinWidthimpl(j11);
        }
        Direction direction4 = this.direction;
        Direction direction5 = Direction.Horizontal;
        if (direction4 == direction5) {
            i13 = Constraints.m5423getMinHeightimpl(j11);
        }
        int i14 = Integer.MAX_VALUE;
        if (this.direction == direction3 || !this.unbounded) {
            i12 = Constraints.m5422getMaxWidthimpl(j11);
        } else {
            i12 = Integer.MAX_VALUE;
        }
        if (this.direction == direction5 || !this.unbounded) {
            i14 = Constraints.m5421getMaxHeightimpl(j11);
        }
        Placeable r32 = measurable2.m4508measureBRTryo0(ConstraintsKt.Constraints(i11, i12, i13, i14));
        int coerceIn = RangesKt___RangesKt.coerceIn(r32.getWidth(), Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(j11));
        int coerceIn2 = RangesKt___RangesKt.coerceIn(r32.getHeight(), Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(j11));
        return MeasureScope.CC.p(measureScope, coerceIn, coerceIn2, (Map) null, new WrapContentModifier$measure$1(this, coerceIn, r32, coerceIn2, measureScope), 4, (Object) null);
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
