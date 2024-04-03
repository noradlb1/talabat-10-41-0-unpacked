package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0001J\u0011\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0001R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00168VX\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemProviderImpl;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "headerIndexes", "", "", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;Ljava/util/List;Landroidx/compose/foundation/lazy/LazyItemScopeImpl;)V", "getHeaderIndexes", "()Ljava/util/List;", "itemCount", "getItemCount", "()I", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
final class LazyListItemProviderImpl implements LazyListItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
    @NotNull
    private final List<Integer> headerIndexes;
    @NotNull
    private final LazyItemScopeImpl itemScope;

    public LazyListItemProviderImpl(@NotNull IntervalList<LazyListIntervalContent> intervalList, @NotNull IntRange intRange, @NotNull List<Integer> list, @NotNull final LazyItemScopeImpl lazyItemScopeImpl) {
        Intrinsics.checkNotNullParameter(intervalList, "intervals");
        Intrinsics.checkNotNullParameter(intRange, "nearestItemsRange");
        Intrinsics.checkNotNullParameter(list, "headerIndexes");
        Intrinsics.checkNotNullParameter(lazyItemScopeImpl, "itemScope");
        this.headerIndexes = list;
        this.itemScope = lazyItemScopeImpl;
        this.$$delegate_0 = LazyLayoutItemProviderKt.LazyLayoutItemProvider(intervalList, intRange, ComposableLambdaKt.composableLambdaInstance(-1230121334, true, new Function4<LazyListIntervalContent, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyListIntervalContent) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@NotNull LazyListIntervalContent lazyListIntervalContent, int i11, @Nullable Composer composer, int i12) {
                int i13;
                Intrinsics.checkNotNullParameter(lazyListIntervalContent, SessionsConfigParameter.SYNC_INTERVAL);
                if ((i12 & 14) == 0) {
                    i13 = (composer.changed((Object) lazyListIntervalContent) ? 4 : 2) | i12;
                } else {
                    i13 = i12;
                }
                if ((i12 & 112) == 0) {
                    i13 |= composer.changed(i11) ? 32 : 16;
                }
                if ((i13 & 731) != 146 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1230121334, i13, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.$$delegate_0.<anonymous> (LazyListItemProvider.kt:78)");
                    }
                    lazyListIntervalContent.getItem().invoke(lazyItemScopeImpl, Integer.valueOf(i11), composer, Integer.valueOf(i13 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1645068522);
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
                ComposerKt.traceEventStart(-1645068522, i13, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:-1)");
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
            endRestartGroup.updateScope(new LazyListItemProviderImpl$Item$1(this, i11, i12));
        }
    }

    @Nullable
    public Object getContentType(int i11) {
        return this.$$delegate_0.getContentType(i11);
    }

    @NotNull
    public List<Integer> getHeaderIndexes() {
        return this.headerIndexes;
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    @NotNull
    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @NotNull
    public Object getKey(int i11) {
        return this.$$delegate_0.getKey(i11);
    }

    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }
}
