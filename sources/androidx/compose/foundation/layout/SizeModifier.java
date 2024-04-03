package androidx.compose.foundation.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010*\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R!\u0010\u0011\u001a\u00020\u0012*\u00020\u00138BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/SizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "equals", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SizeModifier(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f11, (i11 & 2) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f12, (i11 & 4) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f13, (i11 & 8) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f14, z11, function1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SizeModifier(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11, function1);
    }

    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    private final long m569getTargetConstraintsOenEA2s(Density density) {
        int i11;
        int i12;
        int i13;
        int coerceAtLeast;
        float f11 = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i14 = 0;
        if (!Dp.m5483equalsimpl0(f11, companion.m5498getUnspecifiedD9Ej5fM())) {
            i11 = density.m5441roundToPx0680j_4(((Dp) RangesKt___RangesKt.coerceAtLeast(Dp.m5476boximpl(this.maxWidth), Dp.m5476boximpl(Dp.m5478constructorimpl((float) 0)))).m5492unboximpl());
        } else {
            i11 = Integer.MAX_VALUE;
        }
        if (!Dp.m5483equalsimpl0(this.maxHeight, companion.m5498getUnspecifiedD9Ej5fM())) {
            i12 = density.m5441roundToPx0680j_4(((Dp) RangesKt___RangesKt.coerceAtLeast(Dp.m5476boximpl(this.maxHeight), Dp.m5476boximpl(Dp.m5478constructorimpl((float) 0)))).m5492unboximpl());
        } else {
            i12 = Integer.MAX_VALUE;
        }
        if (Dp.m5483equalsimpl0(this.minWidth, companion.m5498getUnspecifiedD9Ej5fM()) || (i13 = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(density.m5441roundToPx0680j_4(this.minWidth), i11), 0)) == Integer.MAX_VALUE) {
            i13 = 0;
        }
        if (!Dp.m5483equalsimpl0(this.minHeight, companion.m5498getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(density.m5441roundToPx0680j_4(this.minHeight), i12), 0)) != Integer.MAX_VALUE) {
            i14 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i13, i11, i14, i12);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SizeModifier)) {
            return false;
        }
        SizeModifier sizeModifier = (SizeModifier) obj;
        if (!Dp.m5483equalsimpl0(this.minWidth, sizeModifier.minWidth) || !Dp.m5483equalsimpl0(this.minHeight, sizeModifier.minHeight) || !Dp.m5483equalsimpl0(this.maxWidth, sizeModifier.maxWidth) || !Dp.m5483equalsimpl0(this.maxHeight, sizeModifier.maxHeight) || this.enforceIncoming != sizeModifier.enforceIncoming) {
            return false;
        }
        return true;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public int hashCode() {
        return ((((((Dp.m5484hashCodeimpl(this.minWidth) * 31) + Dp.m5484hashCodeimpl(this.minHeight)) * 31) + Dp.m5484hashCodeimpl(this.maxWidth)) * 31) + Dp.m5484hashCodeimpl(this.maxHeight)) * 31;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r02 = m569getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m5419getHasFixedHeightimpl(r02)) {
            return Constraints.m5421getMaxHeightimpl(r02);
        }
        return ConstraintsKt.m5435constrainHeightK40F9xA(r02, intrinsicMeasurable.maxIntrinsicHeight(i11));
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r02 = m569getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m5420getHasFixedWidthimpl(r02)) {
            return Constraints.m5422getMaxWidthimpl(r02);
        }
        return ConstraintsKt.m5436constrainWidthK40F9xA(r02, intrinsicMeasurable.maxIntrinsicWidth(i11));
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m570measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long r02 = m569getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            j12 = ConstraintsKt.m5434constrainN9IONVI(j11, r02);
        } else {
            float f11 = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            if (!Dp.m5483equalsimpl0(f11, companion.m5498getUnspecifiedD9Ej5fM())) {
                i11 = Constraints.m5424getMinWidthimpl(r02);
            } else {
                i11 = RangesKt___RangesKt.coerceAtMost(Constraints.m5424getMinWidthimpl(j11), Constraints.m5422getMaxWidthimpl(r02));
            }
            if (!Dp.m5483equalsimpl0(this.maxWidth, companion.m5498getUnspecifiedD9Ej5fM())) {
                i12 = Constraints.m5422getMaxWidthimpl(r02);
            } else {
                i12 = RangesKt___RangesKt.coerceAtLeast(Constraints.m5422getMaxWidthimpl(j11), Constraints.m5424getMinWidthimpl(r02));
            }
            if (!Dp.m5483equalsimpl0(this.minHeight, companion.m5498getUnspecifiedD9Ej5fM())) {
                i13 = Constraints.m5423getMinHeightimpl(r02);
            } else {
                i13 = RangesKt___RangesKt.coerceAtMost(Constraints.m5423getMinHeightimpl(j11), Constraints.m5421getMaxHeightimpl(r02));
            }
            if (!Dp.m5483equalsimpl0(this.maxHeight, companion.m5498getUnspecifiedD9Ej5fM())) {
                i14 = Constraints.m5421getMaxHeightimpl(r02);
            } else {
                i14 = RangesKt___RangesKt.coerceAtLeast(Constraints.m5421getMaxHeightimpl(j11), Constraints.m5423getMinHeightimpl(r02));
            }
            j12 = ConstraintsKt.Constraints(i11, i12, i13, i14);
        }
        Placeable r92 = measurable.m4508measureBRTryo0(j12);
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new SizeModifier$measure$1(r92), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r02 = m569getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m5419getHasFixedHeightimpl(r02)) {
            return Constraints.m5421getMaxHeightimpl(r02);
        }
        return ConstraintsKt.m5435constrainHeightK40F9xA(r02, intrinsicMeasurable.minIntrinsicHeight(i11));
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long r02 = m569getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m5420getHasFixedWidthimpl(r02)) {
            return Constraints.m5422getMaxWidthimpl(r02);
        }
        return ConstraintsKt.m5436constrainWidthK40F9xA(r02, intrinsicMeasurable.minIntrinsicWidth(i11));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    private SizeModifier(float f11, float f12, float f13, float f14, boolean z11, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f11;
        this.minHeight = f12;
        this.maxWidth = f13;
        this.maxHeight = f14;
        this.enforceIncoming = z11;
    }
}
