package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\"\u0010\u0007\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\f\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J/\u0010\r\u001a\u00020\u000e*\u00020\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u0016\u001a\u00020\u0003*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"androidx/compose/ui/viewinterop/AndroidViewHolder$layoutNode$1$5", "Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicHeight", "", "width", "intrinsicWidth", "height", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$layoutNode$1$5 implements MeasurePolicy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10293a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f10294b;

    public AndroidViewHolder$layoutNode$1$5(AndroidViewHolder androidViewHolder, LayoutNode layoutNode) {
        this.f10293a = androidViewHolder;
        this.f10294b = layoutNode;
    }

    private final int intrinsicHeight(int i11) {
        AndroidViewHolder androidViewHolder = this.f10293a;
        ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, i11, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
        return this.f10293a.getMeasuredHeight();
    }

    private final int intrinsicWidth(int i11) {
        AndroidViewHolder androidViewHolder = this.f10293a;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        AndroidViewHolder androidViewHolder2 = this.f10293a;
        ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        androidViewHolder.measure(makeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, i11, layoutParams.height));
        return this.f10293a.getMeasuredWidth();
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(i11);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m5715measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (Constraints.m5424getMinWidthimpl(j11) != 0) {
            this.f10293a.getChildAt(0).setMinimumWidth(Constraints.m5424getMinWidthimpl(j11));
        }
        if (Constraints.m5423getMinHeightimpl(j11) != 0) {
            this.f10293a.getChildAt(0).setMinimumHeight(Constraints.m5423getMinHeightimpl(j11));
        }
        AndroidViewHolder androidViewHolder = this.f10293a;
        int r02 = Constraints.m5424getMinWidthimpl(j11);
        int r12 = Constraints.m5422getMaxWidthimpl(j11);
        ViewGroup.LayoutParams layoutParams = this.f10293a.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams);
        int access$obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(r02, r12, layoutParams.width);
        AndroidViewHolder androidViewHolder2 = this.f10293a;
        int r22 = Constraints.m5423getMinHeightimpl(j11);
        int r102 = Constraints.m5421getMaxHeightimpl(j11);
        ViewGroup.LayoutParams layoutParams2 = this.f10293a.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2);
        androidViewHolder.measure(access$obtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(r22, r102, layoutParams2.height));
        return MeasureScope.CC.p(measureScope, this.f10293a.getMeasuredWidth(), this.f10293a.getMeasuredHeight(), (Map) null, new AndroidViewHolder$layoutNode$1$5$measure$1(this.f10293a, this.f10294b), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicHeight(i11);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return intrinsicWidth(i11);
    }
}
