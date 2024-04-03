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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "getRtlAware", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "equals", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    private PaddingModifier(float f11, float f12, float f13, float f14, boolean z11, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.start = f11;
        this.top = f12;
        this.end = f13;
        this.bottom = f14;
        this.rtlAware = z11;
        if (!((f11 >= 0.0f || Dp.m5483equalsimpl0(f11, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) && (f12 >= 0.0f || Dp.m5483equalsimpl0(f12, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) && ((f13 >= 0.0f || Dp.m5483equalsimpl0(f13, Dp.Companion.m5498getUnspecifiedD9Ej5fM())) && (f14 >= 0.0f || Dp.m5483equalsimpl0(f14, Dp.Companion.m5498getUnspecifiedD9Ej5fM()))))) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    public /* synthetic */ PaddingModifier(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, z11, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        PaddingModifier paddingModifier;
        if (obj instanceof PaddingModifier) {
            paddingModifier = (PaddingModifier) obj;
        } else {
            paddingModifier = null;
        }
        if (paddingModifier != null && Dp.m5483equalsimpl0(this.start, paddingModifier.start) && Dp.m5483equalsimpl0(this.top, paddingModifier.top) && Dp.m5483equalsimpl0(this.end, paddingModifier.end) && Dp.m5483equalsimpl0(this.bottom, paddingModifier.bottom) && this.rtlAware == paddingModifier.rtlAware) {
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

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m491getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m492getEndD9Ej5fM() {
        return this.end;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m493getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m494getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((((Dp.m5484hashCodeimpl(this.start) * 31) + Dp.m5484hashCodeimpl(this.top)) * 31) + Dp.m5484hashCodeimpl(this.end)) * 31) + Dp.m5484hashCodeimpl(this.bottom)) * 31) + e.a(this.rtlAware);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i11) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m495measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int r02 = measureScope.m5441roundToPx0680j_4(this.start) + measureScope.m5441roundToPx0680j_4(this.end);
        int r12 = measureScope.m5441roundToPx0680j_4(this.top) + measureScope.m5441roundToPx0680j_4(this.bottom);
        Placeable r122 = measurable.m4508measureBRTryo0(ConstraintsKt.m5438offsetNN6EwU(j11, -r02, -r12));
        return MeasureScope.CC.p(measureScope, ConstraintsKt.m5436constrainWidthK40F9xA(j11, r122.getWidth() + r02), ConstraintsKt.m5435constrainHeightK40F9xA(j11, r122.getHeight() + r12), (Map) null, new PaddingModifier$measure$1(this, r122, measureScope), 4, (Object) null);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaddingModifier(float f11, float f12, float f13, float f14, boolean z11, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (i11 & 2) != 0 ? Dp.m5478constructorimpl((float) 0) : f12, (i11 & 4) != 0 ? Dp.m5478constructorimpl((float) 0) : f13, (i11 & 8) != 0 ? Dp.m5478constructorimpl((float) 0) : f14, z11, function1, (DefaultConstructorMarker) null);
    }
}
