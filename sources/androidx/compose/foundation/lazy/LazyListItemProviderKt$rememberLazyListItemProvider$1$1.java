package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListItemProviderKt$rememberLazyListItemProvider$1$1 implements LazyListItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ State<LazyListItemProviderImpl> f2747a;

    public LazyListItemProviderKt$rememberLazyListItemProvider$1$1(State<LazyListItemProviderImpl> state) {
        this.f2747a = state;
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(state);
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        composer.startReplaceableGroup(1610124706);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610124706, i12, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProvider.<anonymous>.<no name provided>.Item (LazyListItemProvider.kt:-1)");
        }
        this.$$delegate_0.Item(i11, composer, i12 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Nullable
    public Object getContentType(int i11) {
        return this.$$delegate_0.getContentType(i11);
    }

    @NotNull
    public List<Integer> getHeaderIndexes() {
        return this.f2747a.getValue().getHeaderIndexes();
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    @NotNull
    public LazyItemScopeImpl getItemScope() {
        return this.f2747a.getValue().getItemScope();
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
