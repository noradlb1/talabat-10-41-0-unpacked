package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J]\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019¢\u0006\u0002\b\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001d¢\u0006\u0002\b\bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ¶\u0001\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00062#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00192\u001f\u0010\u0018\u001a\u001b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\b\b2#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001921\u0010$\u001a-\u0012\u0004\u0012\u00020\u001c\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00150\u0004¢\u0006\u0002\b\u001d¢\u0006\u0002\b\bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010%R(\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "()V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "hasCustomSpans", "", "getHasCustomSpans$foundation_release", "()Z", "setHasCustomSpans$foundation_release", "(Z)V", "intervals", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "getIntervals$foundation_release", "()Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "item", "", "key", "", "span", "Lkotlin/Function1;", "contentType", "content", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "index", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridScopeImpl implements LazyGridScope {
    @NotNull
    private final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan = LazyGridScopeImpl$DefaultSpan$1.INSTANCE;
    private boolean hasCustomSpans;
    @NotNull
    private final MutableIntervalList<LazyGridIntervalContent> intervals = new MutableIntervalList<>();

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    @NotNull
    public final MutableIntervalList<LazyGridIntervalContent> getIntervals$foundation_release() {
        return this.intervals;
    }

    public void item(@Nullable Object obj, @Nullable Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, @Nullable Object obj2, @NotNull Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function3) {
        LazyGridScopeImpl$item$1$1 lazyGridScopeImpl$item$1$1;
        Function2 function2;
        Intrinsics.checkNotNullParameter(function3, "content");
        MutableIntervalList<LazyGridIntervalContent> mutableIntervalList = this.intervals;
        if (obj != null) {
            lazyGridScopeImpl$item$1$1 = new LazyGridScopeImpl$item$1$1(obj);
        } else {
            lazyGridScopeImpl$item$1$1 = null;
        }
        if (function1 != null) {
            function2 = new LazyGridScopeImpl$item$2$1(function1);
        } else {
            function2 = this.DefaultSpan;
        }
        mutableIntervalList.addInterval(1, new LazyGridIntervalContent(lazyGridScopeImpl$item$1$1, function2, new LazyGridScopeImpl$item$3(obj2), ComposableLambdaKt.composableLambdaInstance(-1504808184, true, new LazyGridScopeImpl$item$4(function3))));
        if (function1 != null) {
            this.hasCustomSpans = true;
        }
    }

    public void items(int i11, @Nullable Function1<? super Integer, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function2, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Function2 function22;
        Intrinsics.checkNotNullParameter(function12, AnalyticsAttribute.CONTENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        MutableIntervalList<LazyGridIntervalContent> mutableIntervalList = this.intervals;
        if (function2 == null) {
            function22 = this.DefaultSpan;
        } else {
            function22 = function2;
        }
        mutableIntervalList.addInterval(i11, new LazyGridIntervalContent(function1, function22, function12, function4));
        if (function2 != null) {
            this.hasCustomSpans = true;
        }
    }

    public final void setHasCustomSpans$foundation_release(boolean z11) {
        this.hasCustomSpans = z11;
    }
}
