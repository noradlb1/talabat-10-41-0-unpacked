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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f11, boolean z11, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        boolean z12;
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.aspectRatio = f11;
        this.matchHeightConstraintsFirst = z11;
        if (f11 > 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            throw new IllegalArgumentException(("aspectRatio " + f11 + " must be > 0").toString());
        }
    }

    public static /* synthetic */ long a(AspectRatioModifier aspectRatioModifier, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return aspectRatioModifier.m426tryMaxHeightJN0ABg(j11, z11);
    }

    public static /* synthetic */ long b(AspectRatioModifier aspectRatioModifier, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return aspectRatioModifier.m427tryMaxWidthJN0ABg(j11, z11);
    }

    public static /* synthetic */ long c(AspectRatioModifier aspectRatioModifier, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return aspectRatioModifier.m428tryMinHeightJN0ABg(j11, z11);
    }

    public static /* synthetic */ long d(AspectRatioModifier aspectRatioModifier, long j11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return aspectRatioModifier.m429tryMinWidthJN0ABg(j11, z11);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m425findSizeToXhtMw(long j11) {
        if (!this.matchHeightConstraintsFirst) {
            long b11 = b(this, j11, false, 1, (Object) null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m5636equalsimpl0(b11, companion.m5643getZeroYbymL2g())) {
                return b11;
            }
            long a11 = a(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(a11, companion.m5643getZeroYbymL2g())) {
                return a11;
            }
            long d11 = d(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(d11, companion.m5643getZeroYbymL2g())) {
                return d11;
            }
            long c11 = c(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(c11, companion.m5643getZeroYbymL2g())) {
                return c11;
            }
            long r22 = m427tryMaxWidthJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r22, companion.m5643getZeroYbymL2g())) {
                return r22;
            }
            long r23 = m426tryMaxHeightJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r23, companion.m5643getZeroYbymL2g())) {
                return r23;
            }
            long r24 = m429tryMinWidthJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r24, companion.m5643getZeroYbymL2g())) {
                return r24;
            }
            long r12 = m428tryMinHeightJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r12, companion.m5643getZeroYbymL2g())) {
                return r12;
            }
        } else {
            long a12 = a(this, j11, false, 1, (Object) null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m5636equalsimpl0(a12, companion2.m5643getZeroYbymL2g())) {
                return a12;
            }
            long b12 = b(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(b12, companion2.m5643getZeroYbymL2g())) {
                return b12;
            }
            long c12 = c(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(c12, companion2.m5643getZeroYbymL2g())) {
                return c12;
            }
            long d12 = d(this, j11, false, 1, (Object) null);
            if (!IntSize.m5636equalsimpl0(d12, companion2.m5643getZeroYbymL2g())) {
                return d12;
            }
            long r25 = m426tryMaxHeightJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r25, companion2.m5643getZeroYbymL2g())) {
                return r25;
            }
            long r26 = m427tryMaxWidthJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r26, companion2.m5643getZeroYbymL2g())) {
                return r26;
            }
            long r27 = m428tryMinHeightJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r27, companion2.m5643getZeroYbymL2g())) {
                return r27;
            }
            long r122 = m429tryMinWidthJN0ABg(j11, false);
            if (!IntSize.m5636equalsimpl0(r122, companion2.m5643getZeroYbymL2g())) {
                return r122;
            }
        }
        return IntSize.Companion.m5643getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m426tryMaxHeightJN0ABg(long j11, boolean z11) {
        int roundToInt;
        int r02 = Constraints.m5421getMaxHeightimpl(j11);
        if (r02 != Integer.MAX_VALUE && (roundToInt = MathKt__MathJVMKt.roundToInt(((float) r02) * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r02);
            if (!z11 || ConstraintsKt.m5437isSatisfiedBy4WqzIAM(j11, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5643getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m427tryMaxWidthJN0ABg(long j11, boolean z11) {
        int roundToInt;
        int r02 = Constraints.m5422getMaxWidthimpl(j11);
        if (r02 != Integer.MAX_VALUE && (roundToInt = MathKt__MathJVMKt.roundToInt(((float) r02) / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(r02, roundToInt);
            if (!z11 || ConstraintsKt.m5437isSatisfiedBy4WqzIAM(j11, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5643getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m428tryMinHeightJN0ABg(long j11, boolean z11) {
        int r02 = Constraints.m5423getMinHeightimpl(j11);
        int roundToInt = MathKt__MathJVMKt.roundToInt(((float) r02) * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r02);
            if (!z11 || ConstraintsKt.m5437isSatisfiedBy4WqzIAM(j11, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5643getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m429tryMinWidthJN0ABg(long j11, boolean z11) {
        int r02 = Constraints.m5424getMinWidthimpl(j11);
        int roundToInt = MathKt__MathJVMKt.roundToInt(((float) r02) / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(r02, roundToInt);
            if (!z11 || ConstraintsKt.m5437isSatisfiedBy4WqzIAM(j11, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5643getZeroYbymL2g();
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        AspectRatioModifier aspectRatioModifier;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatioModifier) {
            aspectRatioModifier = (AspectRatioModifier) obj;
        } else {
            aspectRatioModifier = null;
        }
        if (aspectRatioModifier == null) {
            return false;
        }
        if (this.aspectRatio == aspectRatioModifier.aspectRatio) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || this.matchHeightConstraintsFirst != ((AspectRatioModifier) obj).matchHeightConstraintsFirst) {
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

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + e.a(this.matchHeightConstraintsFirst);
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i11 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(((float) i11) / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i11);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i11 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(((float) i11) * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m430measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long r02 = m425findSizeToXhtMw(j11);
        if (!IntSize.m5636equalsimpl0(r02, IntSize.Companion.m5643getZeroYbymL2g())) {
            j11 = Constraints.Companion.m5430fixedJhjzzOo(IntSize.m5638getWidthimpl(r02), IntSize.m5637getHeightimpl(r02));
        }
        Placeable r92 = measurable.m4508measureBRTryo0(j11);
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new AspectRatioModifier$measure$1(r92), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i11 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(((float) i11) / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i11);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i11 != Integer.MAX_VALUE) {
            return MathKt__MathJVMKt.roundToInt(((float) i11) * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i11);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
