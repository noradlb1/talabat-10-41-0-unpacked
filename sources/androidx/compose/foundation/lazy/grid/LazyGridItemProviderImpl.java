package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000eH\u0001J\u0011\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000eH\u0001J$\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u00128VX\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "hasCustomSpans", "", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;ZLkotlin/ranges/IntRange;)V", "getHasCustomSpans", "()Z", "itemCount", "", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "getSpan", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "getSpan-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
final class LazyGridItemProviderImpl implements LazyGridItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
    private final boolean hasCustomSpans;
    @NotNull
    private final IntervalList<LazyGridIntervalContent> intervals;
    @NotNull
    private final LazyGridSpanLayoutProvider spanLayoutProvider = new LazyGridSpanLayoutProvider(this);

    public LazyGridItemProviderImpl(@NotNull IntervalList<LazyGridIntervalContent> intervalList, boolean z11, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        this.intervals = intervalList;
        this.hasCustomSpans = z11;
        this.$$delegate_0 = LazyLayoutItemProviderKt.LazyLayoutItemProvider(intervalList, intRange, ComposableSingletons$LazyGridItemProviderKt.INSTANCE.m654getLambda1$foundation_release());
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1355196996);
        if ((i12 & 14) == 0) {
            i13 = (startRestartGroup.changed(i11) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) this) ? 32 : 16;
        }
        if ((i13 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1355196996, i13, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:-1)");
            }
            this.$$delegate_0.Item(i11, startRestartGroup, i13 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridItemProviderImpl$Item$1(this, i11, i12));
        }
    }

    @Nullable
    public Object getContentType(int i11) {
        return this.$$delegate_0.getContentType(i11);
    }

    public boolean getHasCustomSpans() {
        return this.hasCustomSpans;
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    @NotNull
    public Object getKey(int i11) {
        return this.$$delegate_0.getKey(i11);
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }

    /* renamed from: getSpan-_-orMbw  reason: not valid java name */
    public long m692getSpan_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i11) {
        Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$getSpan");
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i11);
        return interval.getValue().getSpan().invoke(lazyGridItemSpanScope, Integer.valueOf(i11 - interval.getStartIndex())).m663unboximpl();
    }

    @NotNull
    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.spanLayoutProvider;
    }
}
