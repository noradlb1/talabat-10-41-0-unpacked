package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridItemProviderKt$rememberLazyGridItemProvider$1$1 implements LazyGridItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ State<LazyGridItemProvider> f2901a;

    public LazyGridItemProviderKt$rememberLazyGridItemProvider$1$1(State<? extends LazyGridItemProvider> state) {
        this.f2901a = state;
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(state);
    }

    @Composable
    public void Item(int i11, @Nullable Composer composer, int i12) {
        composer.startReplaceableGroup(125380152);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(125380152, i12, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProvider.<anonymous>.<no name provided>.Item (LazyGridItemProvider.kt:-1)");
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

    public boolean getHasCustomSpans() {
        return this.f2901a.getValue().getHasCustomSpans();
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
    public long m693getSpan_orMbw(@NotNull LazyGridItemSpanScope lazyGridItemSpanScope, int i11) {
        Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$getSpan");
        return this.f2901a.getValue().m691getSpan_orMbw(lazyGridItemSpanScope, i11);
    }

    @NotNull
    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.f2901a.getValue().getSpanLayoutProvider();
    }
}
