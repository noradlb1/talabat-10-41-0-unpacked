package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ-\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics;", "", "()V", "maxHeight", "", "modifier", "Landroidx/compose/ui/layout/LayoutModifier;", "instrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "w", "maxHeight$ui_release", "maxWidth", "h", "maxWidth$ui_release", "minHeight", "minHeight$ui_release", "minWidth", "minWidth$ui_release", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MeasuringIntrinsics {
    @NotNull
    public static final MeasuringIntrinsics INSTANCE = new MeasuringIntrinsics();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWidthHeight", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultIntrinsicMeasurable implements Measurable {
        @NotNull
        private final IntrinsicMeasurable measurable;
        @NotNull
        private final IntrinsicMinMax minMax;
        @NotNull
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull IntrinsicMinMax intrinsicMinMax, @NotNull IntrinsicWidthHeight intrinsicWidthHeight) {
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            Intrinsics.checkNotNullParameter(intrinsicMinMax, "minMax");
            Intrinsics.checkNotNullParameter(intrinsicWidthHeight, "widthHeight");
            this.measurable = intrinsicMeasurable;
            this.minMax = intrinsicMinMax;
            this.widthHeight = intrinsicWidthHeight;
        }

        @NotNull
        public final IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        @NotNull
        public final IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        @Nullable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @NotNull
        public final IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        public int maxIntrinsicHeight(int i11) {
            return this.measurable.maxIntrinsicHeight(i11);
        }

        public int maxIntrinsicWidth(int i11) {
            return this.measurable.maxIntrinsicWidth(i11);
        }

        @NotNull
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m4522measureBRTryo0(long j11) {
            int i11;
            int i12;
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                if (this.minMax == IntrinsicMinMax.Max) {
                    i12 = this.measurable.maxIntrinsicWidth(Constraints.m5421getMaxHeightimpl(j11));
                } else {
                    i12 = this.measurable.minIntrinsicWidth(Constraints.m5421getMaxHeightimpl(j11));
                }
                return new EmptyPlaceable(i12, Constraints.m5421getMaxHeightimpl(j11));
            }
            if (this.minMax == IntrinsicMinMax.Max) {
                i11 = this.measurable.maxIntrinsicHeight(Constraints.m5422getMaxWidthimpl(j11));
            } else {
                i11 = this.measurable.minIntrinsicHeight(Constraints.m5422getMaxWidthimpl(j11));
            }
            return new EmptyPlaceable(Constraints.m5422getMaxWidthimpl(j11), i11);
        }

        public int minIntrinsicHeight(int i11) {
            return this.measurable.minIntrinsicHeight(i11);
        }

        public int minIntrinsicWidth(int i11) {
            return this.measurable.minIntrinsicWidth(i11);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0002\b\rH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "get", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "width", "height", "<init>", "(II)V", "ui_release"}, k = 1, mv = {1, 7, 1})
    public static final class EmptyPlaceable extends Placeable {
        public EmptyPlaceable(int i11, int i12) {
            e(IntSizeKt.IntSize(i11, i12));
        }

        public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        }

        public int get(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            return Integer.MIN_VALUE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum IntrinsicMinMax {
        Min,
        Max
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "", "(Ljava/lang/String;I)V", "Width", "Height", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum IntrinsicWidthHeight {
        Width,
        Height
    }

    private MeasuringIntrinsics() {
    }

    public final int maxHeight$ui_release(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(layoutModifier, "modifier");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifier.m4481measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public final int maxWidth$ui_release(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(layoutModifier, "modifier");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifier.m4481measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }

    public final int minHeight$ui_release(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(layoutModifier, "modifier");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifier.m4481measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i11, 0, 0, 13, (Object) null)).getHeight();
    }

    public final int minWidth$ui_release(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(layoutModifier, "modifier");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifier.m4481measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i11, 7, (Object) null)).getWidth();
    }
}
