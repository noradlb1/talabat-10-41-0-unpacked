package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SuspendAnimationKt$animate$7 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimationState<T, V> f1393g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendAnimationKt$animate$7(AnimationState<T, V> animationState) {
        super(0);
        this.f1393g = animationState;
    }

    public final void invoke() {
        this.f1393g.setRunning$animation_core_release(false);
    }
}
