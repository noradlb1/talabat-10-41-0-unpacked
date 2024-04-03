package androidx.compose.ui.draw;

import a0.a;
import a0.b;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BX\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u001d\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010(J\b\u00102\u001a\u000203H\u0016J\f\u00104\u001a\u00020\u0013*\u000205H\u0016J\u0019\u00106\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00108J\u001c\u0010;\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010@\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016J)\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u00100\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010GJ\u001c\u0010H\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010I\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"Landroidx/compose/ui/draw/PainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "equals", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    @NotNull
    private final Alignment alignment;
    private final float alpha;
    @Nullable
    private final ColorFilter colorFilter;
    @NotNull
    private final ContentScale contentScale;
    @NotNull
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PainterModifier(Painter painter2, boolean z11, Alignment alignment2, ContentScale contentScale2, float f11, ColorFilter colorFilter2, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter2, z11, (i11 & 4) != 0 ? Alignment.Companion.getCenter() : alignment2, (i11 & 8) != 0 ? ContentScale.Companion.getInside() : contentScale2, (i11 & 16) != 0 ? 1.0f : f11, (i11 & 32) != 0 ? null : colorFilter2, function1);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m2587calculateScaledSizeE7KxVPU(long j11) {
        float f11;
        float f12;
        boolean z11;
        if (!getUseIntrinsicSize()) {
            return j11;
        }
        if (!m2589hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.m3516getIntrinsicSizeNHjbRc())) {
            f11 = Size.m2745getWidthimpl(j11);
        } else {
            f11 = Size.m2745getWidthimpl(this.painter.m3516getIntrinsicSizeNHjbRc());
        }
        if (!m2588hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.m3516getIntrinsicSizeNHjbRc())) {
            f12 = Size.m2742getHeightimpl(j11);
        } else {
            f12 = Size.m2742getHeightimpl(this.painter.m3516getIntrinsicSizeNHjbRc());
        }
        long Size = SizeKt.Size(f11, f12);
        boolean z12 = true;
        if (Size.m2745getWidthimpl(j11) == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (Size.m2742getHeightimpl(j11) != 0.0f) {
                z12 = false;
            }
            if (!z12) {
                return ScaleFactorKt.m4564timesUQTWf7w(Size, this.contentScale.m4442computeScaleFactorH7hwNQA(Size, j11));
            }
        }
        return Size.Companion.m2754getZeroNHjbRc();
    }

    private final boolean getUseIntrinsicSize() {
        boolean z11;
        if (!this.sizeToIntrinsics) {
            return false;
        }
        if (this.painter.m3516getIntrinsicSizeNHjbRc() != Size.Companion.m2753getUnspecifiedNHjbRc()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m2588hasSpecifiedAndFiniteHeightuvyYCjk(long j11) {
        if (Size.m2741equalsimpl0(j11, Size.Companion.m2753getUnspecifiedNHjbRc())) {
            return false;
        }
        float r32 = Size.m2742getHeightimpl(j11);
        return !Float.isInfinite(r32) && !Float.isNaN(r32);
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m2589hasSpecifiedAndFiniteWidthuvyYCjk(long j11) {
        if (Size.m2741equalsimpl0(j11, Size.Companion.m2753getUnspecifiedNHjbRc())) {
            return false;
        }
        float r32 = Size.m2745getWidthimpl(j11);
        return !Float.isInfinite(r32) && !Float.isNaN(r32);
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m2590modifyConstraintsZezNO4M(long j11) {
        boolean z11;
        int i11;
        int i12;
        boolean z12 = true;
        if (!Constraints.m5418getHasBoundedWidthimpl(j11) || !Constraints.m5417getHasBoundedHeightimpl(j11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!Constraints.m5420getHasFixedWidthimpl(j11) || !Constraints.m5419getHasFixedHeightimpl(j11)) {
            z12 = false;
        }
        if ((getUseIntrinsicSize() || !z11) && !z12) {
            long r02 = this.painter.m3516getIntrinsicSizeNHjbRc();
            if (m2589hasSpecifiedAndFiniteWidthuvyYCjk(r02)) {
                i11 = MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(r02));
            } else {
                i11 = Constraints.m5424getMinWidthimpl(j11);
            }
            if (m2588hasSpecifiedAndFiniteHeightuvyYCjk(r02)) {
                i12 = MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(r02));
            } else {
                i12 = Constraints.m5423getMinHeightimpl(j11);
            }
            long r03 = m2587calculateScaledSizeE7KxVPU(SizeKt.Size((float) ConstraintsKt.m5436constrainWidthK40F9xA(j11, i11), (float) ConstraintsKt.m5435constrainHeightK40F9xA(j11, i12)));
            return Constraints.m5413copyZbe2FdA$default(j11, ConstraintsKt.m5436constrainWidthK40F9xA(j11, MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(r03))), 0, ConstraintsKt.m5435constrainHeightK40F9xA(j11, MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(r03))), 0, 10, (Object) null);
        }
        return Constraints.m5413copyZbe2FdA$default(j11, Constraints.m5422getMaxWidthimpl(j11), 0, Constraints.m5421getMaxHeightimpl(j11), 0, 10, (Object) null);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        float f11;
        float f12;
        boolean z11;
        long j11;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long r02 = this.painter.m3516getIntrinsicSizeNHjbRc();
        if (m2589hasSpecifiedAndFiniteWidthuvyYCjk(r02)) {
            f11 = Size.m2745getWidthimpl(r02);
        } else {
            f11 = Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc());
        }
        if (m2588hasSpecifiedAndFiniteHeightuvyYCjk(r02)) {
            f12 = Size.m2742getHeightimpl(r02);
        } else {
            f12 = Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc());
        }
        long Size = SizeKt.Size(f11, f12);
        boolean z12 = true;
        if (Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()) == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()) != 0.0f) {
                z12 = false;
            }
            if (!z12) {
                j11 = ScaleFactorKt.m4564timesUQTWf7w(Size, this.contentScale.m4442computeScaleFactorH7hwNQA(Size, contentDrawScope.m3425getSizeNHjbRc()));
                long j12 = j11;
                long r03 = this.alignment.m2554alignKFBX0sM(IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(j12)), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(j12))), IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float r82 = (float) IntOffset.m5596getXimpl(r03);
                float r04 = (float) IntOffset.m5597getYimpl(r03);
                contentDrawScope.getDrawContext().getTransform().translate(r82, r04);
                this.painter.m3515drawx_KDEd0(contentDrawScope, j12, this.alpha, this.colorFilter);
                contentDrawScope.getDrawContext().getTransform().translate(-r82, -r04);
                contentDrawScope.drawContent();
            }
        }
        j11 = Size.Companion.m2754getZeroNHjbRc();
        long j122 = j11;
        long r032 = this.alignment.m2554alignKFBX0sM(IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(j122)), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(j122))), IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float r822 = (float) IntOffset.m5596getXimpl(r032);
        float r042 = (float) IntOffset.m5597getYimpl(r032);
        contentDrawScope.getDrawContext().getTransform().translate(r822, r042);
        this.painter.m3515drawx_KDEd0(contentDrawScope, j122, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-r822, -r042);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        PainterModifier painterModifier;
        boolean z11;
        if (obj instanceof PainterModifier) {
            painterModifier = (PainterModifier) obj;
        } else {
            painterModifier = null;
        }
        if (painterModifier == null || !Intrinsics.areEqual((Object) this.painter, (Object) painterModifier.painter) || this.sizeToIntrinsics != painterModifier.sizeToIntrinsics || !Intrinsics.areEqual((Object) this.alignment, (Object) painterModifier.alignment) || !Intrinsics.areEqual((Object) this.contentScale, (Object) painterModifier.contentScale)) {
            return false;
        }
        if (this.alpha == painterModifier.alpha) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !Intrinsics.areEqual((Object) this.colorFilter, (Object) painterModifier.colorFilter)) {
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

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public int hashCode() {
        int i11;
        int hashCode = ((((((((this.painter.hashCode() * 31) + e.a(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter2 = this.colorFilter;
        if (colorFilter2 != null) {
            i11 = colorFilter2.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i11);
        }
        long r02 = m2590modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m5423getMinHeightimpl(r02), intrinsicMeasurable.maxIntrinsicHeight(i11));
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i11);
        }
        long r02 = m2590modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null));
        return Math.max(Constraints.m5424getMinWidthimpl(r02), intrinsicMeasurable.maxIntrinsicWidth(i11));
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2591measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable r92 = measurable.m4508measureBRTryo0(m2590modifyConstraintsZezNO4M(j11));
        return MeasureScope.CC.p(measureScope, r92.getWidth(), r92.getHeight(), (Map) null, new PainterModifier$measure$1(r92), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i11);
        }
        long r02 = m2590modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null));
        return Math.max(Constraints.m5423getMinHeightimpl(r02), intrinsicMeasurable.minIntrinsicHeight(i11));
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i11);
        }
        long r02 = m2590modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null));
        return Math.max(Constraints.m5424getMinWidthimpl(r02), intrinsicMeasurable.minIntrinsicWidth(i11));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PainterModifier(@NotNull Painter painter2, boolean z11, @NotNull Alignment alignment2, @NotNull ContentScale contentScale2, float f11, @Nullable ColorFilter colorFilter2, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(contentScale2, "contentScale");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.painter = painter2;
        this.sizeToIntrinsics = z11;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f11;
        this.colorFilter = colorFilter2;
    }
}
