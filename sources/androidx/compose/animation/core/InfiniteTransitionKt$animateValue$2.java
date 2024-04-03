package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class InfiniteTransitionKt$animateValue$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ InfiniteTransition f1343g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> f1344h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfiniteTransitionKt$animateValue$2(InfiniteTransition infiniteTransition, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState) {
        super(1);
        this.f1343g = infiniteTransition;
        this.f1344h = transitionAnimationState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f1343g.addAnimation$animation_core_release(this.f1344h);
        return new InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1(this.f1343g, this.f1344h);
    }
}
