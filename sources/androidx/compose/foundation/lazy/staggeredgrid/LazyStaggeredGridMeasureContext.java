package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001Bh\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u00101\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "resolvedSlotSums", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "mainAxisSpacing", "crossAxisSpacing", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;[IJZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "getBeforeContentPadding", "getConstraints-msEJaDk", "()J", "J", "getContentOffset-nOcc-ac", "getCrossAxisSpacing", "()Z", "getItemProvider", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "getMainAxisAvailableSize", "getMainAxisSpacing", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getResolvedSlotSums", "()[I", "spans", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "getSpans", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpans;", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyStaggeredGridMeasureContext {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final int crossAxisSpacing;
    private final boolean isVertical;
    @NotNull
    private final LazyLayoutItemProvider itemProvider;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    @NotNull
    private final LazyLayoutMeasureScope measureScope;
    @NotNull
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;
    @NotNull
    private final int[] resolvedSlotSums;
    @NotNull
    private final LazyStaggeredGridSpans spans;
    @NotNull
    private final LazyStaggeredGridState state;

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, long j11, boolean z11, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11, long j12, int i12, int i13, int i14, int i15) {
        this.state = lazyStaggeredGridState;
        this.itemProvider = lazyLayoutItemProvider;
        this.resolvedSlotSums = iArr;
        this.constraints = j11;
        this.isVertical = z11;
        this.measureScope = lazyLayoutMeasureScope;
        this.mainAxisAvailableSize = i11;
        this.contentOffset = j12;
        this.beforeContentPadding = i12;
        this.afterContentPadding = i13;
        this.mainAxisSpacing = i14;
        this.crossAxisSpacing = i15;
        this.measuredItemProvider = new LazyStaggeredGridMeasureProvider(z11, lazyLayoutItemProvider, lazyLayoutMeasureScope, iArr, new LazyStaggeredGridMeasureContext$measuredItemProvider$1(this));
        this.spans = lazyStaggeredGridState.getSpans$foundation_release();
    }

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr, long j11, boolean z11, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11, long j12, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, lazyLayoutItemProvider, iArr, j11, z11, lazyLayoutMeasureScope, i11, j12, i12, i13, i14, i15);
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m771getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m772getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getCrossAxisSpacing() {
        return this.crossAxisSpacing;
    }

    @NotNull
    public final LazyLayoutItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    @NotNull
    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    @NotNull
    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    @NotNull
    public final int[] getResolvedSlotSums() {
        return this.resolvedSlotSums;
    }

    @NotNull
    public final LazyStaggeredGridSpans getSpans() {
        return this.spans;
    }

    @NotNull
    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }
}
