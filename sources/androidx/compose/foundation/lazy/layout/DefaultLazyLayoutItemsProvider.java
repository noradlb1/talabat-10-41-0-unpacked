package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BN\u00121\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010 J*\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\"\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u0006H\u0016JT\u0010&\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010\t\u001a\u00020\u000626\u0010(\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b()\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H'0\u0005H\b¢\u0006\u0002\u0010+R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R>\u0010\u0004\u001a-\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyLayoutItemsProvider;", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemContentProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getItemContentProvider", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "itemCount", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "(ILandroidx/compose/runtime/Composer;I)V", "generateKeyToIndexMap", "range", "list", "getContentType", "getKey", "withLocalIntervalIndex", "T", "block", "localIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {
    @NotNull
    private final IntervalList<IntervalContent> intervals;
    @NotNull
    private final Function4<IntervalContent, Integer, Composer, Integer, Unit> itemContentProvider;
    @NotNull
    private final Map<Object, Integer> keyToIndexMap;

    public DefaultLazyLayoutItemsProvider(@NotNull Function4<? super IntervalContent, ? super Integer, ? super Composer, ? super Integer, Unit> function4, @NotNull IntervalList<? extends IntervalContent> intervalList, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(function4, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        this.itemContentProvider = function4;
        this.intervals = intervalList;
        this.keyToIndexMap = generateKeyToIndexMap(intRange, intervalList);
    }

    @ExperimentalFoundationApi
    private final Map<Object, Integer> generateKeyToIndexMap(IntRange intRange, IntervalList<? extends LazyLayoutIntervalContent> intervalList) {
        boolean z11;
        int first = intRange.getFirst();
        if (first >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int min = Math.min(intRange.getLast(), intervalList.getSize() - 1);
            if (min < first) {
                return MapsKt__MapsKt.emptyMap();
            }
            HashMap hashMap = new HashMap();
            intervalList.forEach(first, min, new DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(first, min, hashMap));
            return hashMap;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final <T> T withLocalIntervalIndex(int i11, Function2<? super Integer, ? super IntervalContent, ? extends T> function2) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i11);
        return function2.invoke(Integer.valueOf(i11 - interval.getStartIndex()), interval.getValue());
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1877726744);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if ((i13 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877726744, i12, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:115)");
            }
            IntervalList.Interval<IntervalContent> interval = this.intervals.get(i11);
            this.itemContentProvider.invoke((LazyLayoutIntervalContent) interval.getValue(), Integer.valueOf(i11 - interval.getStartIndex()), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DefaultLazyLayoutItemsProvider$Item$2(this, i11, i12));
        }
    }

    @Nullable
    public Object getContentType(int i11) {
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i11);
        return ((LazyLayoutIntervalContent) interval.getValue()).getType().invoke(Integer.valueOf(i11 - interval.getStartIndex()));
    }

    @NotNull
    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    @NotNull
    public final Function4<IntervalContent, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public int getItemCount() {
        return this.intervals.getSize();
    }

    @NotNull
    public Object getKey(int i11) {
        Object invoke;
        IntervalList.Interval<IntervalContent> interval = this.intervals.get(i11);
        int startIndex = i11 - interval.getStartIndex();
        Function1<Integer, Object> key = ((LazyLayoutIntervalContent) interval.getValue()).getKey();
        if (key == null || (invoke = key.invoke(Integer.valueOf(startIndex))) == null) {
            return Lazy_androidKt.getDefaultLazyLayoutKey(i11);
        }
        return invoke;
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }
}
