package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1 extends Lambda implements Function0<LazyLayoutItemProvider> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<LazyLayoutItemProvider> f3023g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1(State<? extends LazyLayoutItemProvider> state) {
        super(0);
        this.f3023g = state;
    }

    @NotNull
    public final LazyLayoutItemProvider invoke() {
        return this.f3023g.getValue();
    }
}
