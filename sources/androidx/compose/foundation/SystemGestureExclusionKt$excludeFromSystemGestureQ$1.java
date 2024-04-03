package androidx.compose.foundation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SystemGestureExclusionKt$excludeFromSystemGestureQ$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExcludeFromSystemGestureModifier f1818g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SystemGestureExclusionKt$excludeFromSystemGestureQ$1(ExcludeFromSystemGestureModifier excludeFromSystemGestureModifier) {
        super(1);
        this.f1818g = excludeFromSystemGestureModifier;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new SystemGestureExclusionKt$excludeFromSystemGestureQ$1$invoke$$inlined$onDispose$1(this.f1818g);
    }
}
