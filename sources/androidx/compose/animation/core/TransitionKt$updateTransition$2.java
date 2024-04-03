package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TransitionKt$updateTransition$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1430g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransitionKt$updateTransition$2(Transition<T> transition) {
        super(1);
        this.f1430g = transition;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new TransitionKt$updateTransition$2$invoke$$inlined$onDispose$1(this.f1430g);
    }
}
