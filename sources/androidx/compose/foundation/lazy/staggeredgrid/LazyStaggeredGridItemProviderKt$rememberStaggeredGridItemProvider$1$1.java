package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1 implements LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

    public LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$1(State<? extends LazyLayoutItemProvider> state) {
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(state);
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        composer.startReplaceableGroup(-1058165788);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1058165788, i12, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<no name provided>.Item (LazyStaggeredGridItemProvider.kt:-1)");
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
}
