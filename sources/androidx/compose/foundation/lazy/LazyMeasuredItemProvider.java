package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B2\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemFactory", "Landroidx/compose/foundation/lazy/MeasuredItemFactory;", "(JZLandroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/MeasuredItemFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "getAndMeasure", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/DataIndex;", "getAndMeasure-ZjPyQlc", "(I)Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredItemProvider {
    private final long childConstraints;
    @NotNull
    private final LazyListItemProvider itemProvider;
    @NotNull
    private final LazyLayoutMeasureScope measureScope;
    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    private LazyMeasuredItemProvider(long j11, boolean z11, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, MeasuredItemFactory measuredItemFactory2) {
        int i11;
        this.itemProvider = lazyListItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.measuredItemFactory = measuredItemFactory2;
        int i12 = Integer.MAX_VALUE;
        if (z11) {
            i11 = Constraints.m5422getMaxWidthimpl(j11);
        } else {
            i11 = Integer.MAX_VALUE;
        }
        this.childConstraints = ConstraintsKt.Constraints$default(0, i11, 0, !z11 ? Constraints.m5421getMaxHeightimpl(j11) : i12, 5, (Object) null);
    }

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItemProvider(long j11, boolean z11, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, MeasuredItemFactory measuredItemFactory2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, z11, lazyListItemProvider, lazyLayoutMeasureScope, measuredItemFactory2);
    }

    @NotNull
    /* renamed from: getAndMeasure-ZjPyQlc  reason: not valid java name */
    public final LazyMeasuredItem m648getAndMeasureZjPyQlc(int i11) {
        return this.measuredItemFactory.m650createItemHK0c1C0(i11, this.itemProvider.getKey(i11), this.measureScope.m738measure0kLqBqw(i11, this.childConstraints));
    }

    /* renamed from: getChildConstraints-msEJaDk  reason: not valid java name */
    public final long m649getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemProvider.getKeyToIndexMap();
    }
}
