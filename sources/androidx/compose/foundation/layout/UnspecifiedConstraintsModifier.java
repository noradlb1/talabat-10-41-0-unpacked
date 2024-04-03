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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010&\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnspecifiedConstraintsModifier(float f11, float f12, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f11, (i11 & 2) != 0 ? Dp.Companion.m5498getUnspecifiedD9Ej5fM() : f12, function1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f11, float f12, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsModifier)) {
            return false;
        }
        UnspecifiedConstraintsModifier unspecifiedConstraintsModifier = (UnspecifiedConstraintsModifier) obj;
        if (!Dp.m5483equalsimpl0(this.minWidth, unspecifiedConstraintsModifier.minWidth) || !Dp.m5483equalsimpl0(this.minHeight, unspecifiedConstraintsModifier.minHeight)) {
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

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m572getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m573getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    public int hashCode() {
        return (Dp.m5484hashCodeimpl(this.minWidth) * 31) + Dp.m5484hashCodeimpl(this.minHeight);
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i11);
        if (!Dp.m5483equalsimpl0(this.minHeight, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
            i12 = intrinsicMeasureScope.m5441roundToPx0680j_4(this.minHeight);
        } else {
            i12 = 0;
        }
        return RangesKt___RangesKt.coerceAtLeast(maxIntrinsicHeight, i12);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i11);
        if (!Dp.m5483equalsimpl0(this.minWidth, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
            i12 = intrinsicMeasureScope.m5441roundToPx0680j_4(this.minWidth);
        } else {
            i12 = 0;
        }
        return RangesKt___RangesKt.coerceAtLeast(maxIntrinsicWidth, i12);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m574measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float f11 = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        if (Dp.m5483equalsimpl0(f11, companion.m5498getUnspecifiedD9Ej5fM()) || Constraints.m5424getMinWidthimpl(j11) != 0) {
            i11 = Constraints.m5424getMinWidthimpl(j11);
        } else {
            i11 = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(measureScope.m5441roundToPx0680j_4(this.minWidth), Constraints.m5422getMaxWidthimpl(j11)), 0);
        }
        int r32 = Constraints.m5422getMaxWidthimpl(j11);
        if (Dp.m5483equalsimpl0(this.minHeight, companion.m5498getUnspecifiedD9Ej5fM()) || Constraints.m5423getMinHeightimpl(j11) != 0) {
            i12 = Constraints.m5423getMinHeightimpl(j11);
        } else {
            i12 = RangesKt___RangesKt.coerceAtLeast(RangesKt___RangesKt.coerceAtMost(measureScope.m5441roundToPx0680j_4(this.minHeight), Constraints.m5421getMaxHeightimpl(j11)), 0);
        }
        Placeable r92 = measurable.m4508measureBRTryo0(ConstraintsKt.Constraints(i11, r32, i12, Constraints.m5421getMaxHeightimpl(j11)));
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new UnspecifiedConstraintsModifier$measure$1(r92), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(i11);
        if (!Dp.m5483equalsimpl0(this.minHeight, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
            i12 = intrinsicMeasureScope.m5441roundToPx0680j_4(this.minHeight);
        } else {
            i12 = 0;
        }
        return RangesKt___RangesKt.coerceAtLeast(minIntrinsicHeight, i12);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(i11);
        if (!Dp.m5483equalsimpl0(this.minWidth, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) {
            i12 = intrinsicMeasureScope.m5441roundToPx0680j_4(this.minWidth);
        } else {
            i12 = 0;
        }
        return RangesKt___RangesKt.coerceAtLeast(minIntrinsicWidth, i12);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    private UnspecifiedConstraintsModifier(float f11, float f12, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f11;
        this.minHeight = f12;
    }
}
