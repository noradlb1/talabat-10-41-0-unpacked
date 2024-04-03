package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolder$SaveableStateProvider$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazySaveableStateHolder f3066g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f3067h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolder$SaveableStateProvider$1(LazySaveableStateHolder lazySaveableStateHolder, Object obj) {
        super(1);
        this.f3066g = lazySaveableStateHolder;
        this.f3067h = obj;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f3066g.previouslyComposedKeys.remove(this.f3067h);
        return new LazySaveableStateHolder$SaveableStateProvider$1$invoke$$inlined$onDispose$1(this.f3066g, this.f3067h);
    }
}
