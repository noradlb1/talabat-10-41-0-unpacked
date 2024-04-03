package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1 extends Lambda implements Function0<LazySaveableStateHolder> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f3077g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1(SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.f3077g = saveableStateRegistry;
    }

    @NotNull
    public final LazySaveableStateHolder invoke() {
        return new LazySaveableStateHolder(this.f3077g, MapsKt__MapsKt.emptyMap());
    }
}
