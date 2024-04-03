package androidx.compose.foundation;

import a0.a;
import a0.b;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0018H\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u001c\u0010*\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001c\u0010+\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/foundation/OverscrollEffect;)V", "()Z", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ScrollingLayoutModifier implements LayoutModifier {
    private final boolean isReversed;
    private final boolean isVertical;
    @NotNull
    private final OverscrollEffect overscrollEffect;
    @NotNull
    private final ScrollState scrollerState;

    public ScrollingLayoutModifier(@NotNull ScrollState scrollState, boolean z11, boolean z12, @NotNull OverscrollEffect overscrollEffect2) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollerState");
        Intrinsics.checkNotNullParameter(overscrollEffect2, "overscrollEffect");
        this.scrollerState = scrollState;
        this.isReversed = z11;
        this.isVertical = z12;
        this.overscrollEffect = overscrollEffect2;
    }

    public static /* synthetic */ ScrollingLayoutModifier copy$default(ScrollingLayoutModifier scrollingLayoutModifier, ScrollState scrollState, boolean z11, boolean z12, OverscrollEffect overscrollEffect2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            scrollState = scrollingLayoutModifier.scrollerState;
        }
        if ((i11 & 2) != 0) {
            z11 = scrollingLayoutModifier.isReversed;
        }
        if ((i11 & 4) != 0) {
            z12 = scrollingLayoutModifier.isVertical;
        }
        if ((i11 & 8) != 0) {
            overscrollEffect2 = scrollingLayoutModifier.overscrollEffect;
        }
        return scrollingLayoutModifier.copy(scrollState, z11, z12, overscrollEffect2);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    @NotNull
    public final ScrollState component1() {
        return this.scrollerState;
    }

    public final boolean component2() {
        return this.isReversed;
    }

    public final boolean component3() {
        return this.isVertical;
    }

    @NotNull
    public final OverscrollEffect component4() {
        return this.overscrollEffect;
    }

    @NotNull
    public final ScrollingLayoutModifier copy(@NotNull ScrollState scrollState, boolean z11, boolean z12, @NotNull OverscrollEffect overscrollEffect2) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollerState");
        Intrinsics.checkNotNullParameter(overscrollEffect2, "overscrollEffect");
        return new ScrollingLayoutModifier(scrollState, z11, z12, overscrollEffect2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollingLayoutModifier)) {
            return false;
        }
        ScrollingLayoutModifier scrollingLayoutModifier = (ScrollingLayoutModifier) obj;
        return Intrinsics.areEqual((Object) this.scrollerState, (Object) scrollingLayoutModifier.scrollerState) && this.isReversed == scrollingLayoutModifier.isReversed && this.isVertical == scrollingLayoutModifier.isVertical && Intrinsics.areEqual((Object) this.overscrollEffect, (Object) scrollingLayoutModifier.overscrollEffect);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    @NotNull
    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    public int hashCode() {
        int hashCode = this.scrollerState.hashCode() * 31;
        boolean z11 = this.isReversed;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isVertical;
        if (!z13) {
            z12 = z13;
        }
        return ((i11 + (z12 ? 1 : 0)) * 31) + this.overscrollEffect.hashCode();
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicHeight(i11);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m260measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Orientation orientation;
        int i11;
        boolean z11;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j11, orientation);
        int i12 = Integer.MAX_VALUE;
        if (this.isVertical) {
            i11 = Integer.MAX_VALUE;
        } else {
            i11 = Constraints.m5421getMaxHeightimpl(j11);
        }
        if (this.isVertical) {
            i12 = Constraints.m5422getMaxWidthimpl(j11);
        }
        Placeable r12 = measurable.m4508measureBRTryo0(Constraints.m5413copyZbe2FdA$default(j11, 0, i12, 0, i11, 5, (Object) null));
        int coerceAtMost = RangesKt___RangesKt.coerceAtMost(r12.getWidth(), Constraints.m5422getMaxWidthimpl(j11));
        int coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(r12.getHeight(), Constraints.m5421getMaxHeightimpl(j11));
        int height = r12.getHeight() - coerceAtMost2;
        int width = r12.getWidth() - coerceAtMost;
        if (!this.isVertical) {
            height = width;
        }
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (height != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        overscrollEffect2.setEnabled(z11);
        this.scrollerState.setMaxValue$foundation_release(height);
        return MeasureScope.CC.p(measureScope, coerceAtMost, coerceAtMost2, (Map) null, new ScrollingLayoutModifier$measure$1(this, height, r12), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicHeight(i11);
        }
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i11);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "ScrollingLayoutModifier(scrollerState=" + this.scrollerState + ", isReversed=" + this.isReversed + ", isVertical=" + this.isVertical + ", overscrollEffect=" + this.overscrollEffect + ')';
    }
}
