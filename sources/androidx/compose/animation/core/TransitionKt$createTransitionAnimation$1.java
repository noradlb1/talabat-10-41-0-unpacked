package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TransitionKt$createTransitionAnimation$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1427g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> f1428h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransitionKt$createTransitionAnimation$1(Transition<S> transition, Transition<S>.TransitionAnimationState<T, V> transitionAnimationState) {
        super(1);
        this.f1427g = transition;
        this.f1428h = transitionAnimationState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f1427g.addAnimation$animation_core_release(this.f1428h);
        return new TransitionKt$createTransitionAnimation$1$invoke$$inlined$onDispose$1(this.f1427g, this.f1428h);
    }
}
