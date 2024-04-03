package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/ui/layout/DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMinMax;Landroidx/compose/ui/layout/IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/IntrinsicMinMax;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWidthHeight", "()Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultIntrinsicMeasurable implements Measurable {
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
    public Placeable m4457measureBRTryo0(long j11) {
        int i11;
        int i12;
        if (this.widthHeight == IntrinsicWidthHeight.Width) {
            if (this.minMax == IntrinsicMinMax.Max) {
                i12 = this.measurable.maxIntrinsicWidth(Constraints.m5421getMaxHeightimpl(j11));
            } else {
                i12 = this.measurable.minIntrinsicWidth(Constraints.m5421getMaxHeightimpl(j11));
            }
            return new FixedSizeIntrinsicsPlaceable(i12, Constraints.m5421getMaxHeightimpl(j11));
        }
        if (this.minMax == IntrinsicMinMax.Max) {
            i11 = this.measurable.maxIntrinsicHeight(Constraints.m5422getMaxWidthimpl(j11));
        } else {
            i11 = this.measurable.minIntrinsicHeight(Constraints.m5422getMaxWidthimpl(j11));
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.m5422getMaxWidthimpl(j11), i11);
    }

    public int minIntrinsicHeight(int i11) {
        return this.measurable.minIntrinsicHeight(i11);
    }

    public int minIntrinsicWidth(int i11) {
        return this.measurable.minIntrinsicWidth(i11);
    }
}
