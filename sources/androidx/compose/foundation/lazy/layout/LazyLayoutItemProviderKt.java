package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001aj\u0010\u0004\u001a\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\n2;\u0010\u000b\u001a7\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u00020\u0010*\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0001¨\u0006\u0019"}, d2 = {"DelegatingLazyLayoutItemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "delegate", "Landroidx/compose/runtime/State;", "LazyLayoutItemProvider", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "itemContent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "interval", "", "index", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "findIndexByKey", "key", "", "lastKnownIndex", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutItemProviderKt {
    @NotNull
    @ExperimentalFoundationApi
    public static final LazyLayoutItemProvider DelegatingLazyLayoutItemProvider(@NotNull State<? extends LazyLayoutItemProvider> state) {
        Intrinsics.checkNotNullParameter(state, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        return new DefaultDelegatingLazyLayoutItemProvider(state);
    }

    @NotNull
    @ExperimentalFoundationApi
    public static final <T extends LazyLayoutIntervalContent> LazyLayoutItemProvider LazyLayoutItemProvider(@NotNull IntervalList<? extends T> intervalList, @NotNull IntRange intRange, @NotNull Function4<? super T, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        return new DefaultLazyLayoutItemsProvider(function4, intervalList, intRange);
    }

    @ExperimentalFoundationApi
    public static final int findIndexByKey(@NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @Nullable Object obj, int i11) {
        Integer num;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        if (obj == null) {
            return i11;
        }
        if ((i11 >= lazyLayoutItemProvider.getItemCount() || !Intrinsics.areEqual(obj, lazyLayoutItemProvider.getKey(i11))) && (num = lazyLayoutItemProvider.getKeyToIndexMap().get(obj)) != null) {
            return num.intValue();
        }
        return i11;
    }
}
