package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "S", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Transition$totalDurationNanos$2 extends Lambda implements Function0<Long> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1411g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transition$totalDurationNanos$2(Transition<S> transition) {
        super(0);
        this.f1411g = transition;
    }

    @NotNull
    public final Long invoke() {
        long j11 = 0;
        for (Transition.TransitionAnimationState durationNanos$animation_core_release : this.f1411g._animations) {
            j11 = Math.max(j11, durationNanos$animation_core_release.getDurationNanos$animation_core_release());
        }
        for (Transition totalDurationNanos : this.f1411g._transitions) {
            j11 = Math.max(j11, totalDurationNanos.getTotalDurationNanos());
        }
        return Long.valueOf(j11);
    }
}
