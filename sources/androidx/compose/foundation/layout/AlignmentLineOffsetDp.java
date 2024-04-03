package androidx.compose.foundation.layout;

import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J)\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDp;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", "F", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AlignmentLineOffsetDp extends InspectorValueInfo implements LayoutModifier {
    private final float after;
    @NotNull
    private final AlignmentLine alignmentLine;
    private final float before;

    private AlignmentLineOffsetDp(AlignmentLine alignmentLine2, float f11, float f12, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        boolean z11;
        this.alignmentLine = alignmentLine2;
        this.before = f11;
        this.after = f12;
        if ((f11 >= 0.0f || Dp.m5483equalsimpl0(f11, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) && (f12 >= 0.0f || Dp.m5483equalsimpl0(f12, Dp.Companion.m5498getUnspecifiedD9Ej5fM()))) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number".toString());
        }
    }

    public /* synthetic */ AlignmentLineOffsetDp(AlignmentLine alignmentLine2, float f11, float f12, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine2, f11, f12, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        AlignmentLineOffsetDp alignmentLineOffsetDp;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AlignmentLineOffsetDp) {
            alignmentLineOffsetDp = (AlignmentLineOffsetDp) obj;
        } else {
            alignmentLineOffsetDp = null;
        }
        if (alignmentLineOffsetDp == null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.alignmentLine, (Object) alignmentLineOffsetDp.alignmentLine) || !Dp.m5483equalsimpl0(this.before, alignmentLineOffsetDp.before) || !Dp.m5483equalsimpl0(this.after, alignmentLineOffsetDp.after)) {
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

    /* renamed from: getAfter-D9Ej5fM  reason: not valid java name */
    public final float m378getAfterD9Ej5fM() {
        return this.after;
    }

    @NotNull
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    /* renamed from: getBefore-D9Ej5fM  reason: not valid java name */
    public final float m379getBeforeD9Ej5fM() {
        return this.before;
    }

    public int hashCode() {
        return (((this.alignmentLine.hashCode() * 31) + Dp.m5484hashCodeimpl(this.before)) * 31) + Dp.m5484hashCodeimpl(this.after);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m380measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return AlignmentLineKt.m369alignmentLineOffsetMeasuretjqqzMA(measureScope, this.alignmentLine, this.before, this.after, measurable, j11);
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

    @NotNull
    public String toString() {
        return "AlignmentLineOffset(alignmentLine=" + this.alignmentLine + ", before=" + Dp.m5489toStringimpl(this.before) + ", after=" + Dp.m5489toStringimpl(this.after) + ')';
    }
}
