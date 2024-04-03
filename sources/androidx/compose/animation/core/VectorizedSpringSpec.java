package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bB\u001f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLandroidx/compose/animation/core/AnimationVector;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(FFLandroidx/compose/animation/core/Animations;)V", "getDampingRatio", "()F", "isInfinite", "", "()Z", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedSpringSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final /* synthetic */ VectorizedFloatAnimationSpec<V> $$delegate_0;
    private final float dampingRatio;
    private final float stiffness;

    private VectorizedSpringSpec(float f11, float f12, Animations animations) {
        this.dampingRatio = f11;
        this.stiffness = f12;
        this.$$delegate_0 = new VectorizedFloatAnimationSpec<>(animations);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public long getDurationNanos(@NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.$$delegate_0.getDurationNanos(v11, v12, v13);
    }

    @NotNull
    public V getEndVelocity(@NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.$$delegate_0.getEndVelocity(v11, v12, v13);
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.$$delegate_0.getValueFromNanos(j11, v11, v12, v13);
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.$$delegate_0.getVelocityFromNanos(j11, v11, v12, v13);
    }

    public boolean isInfinite() {
        return this.$$delegate_0.isInfinite();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedSpringSpec(float f11, float f12, AnimationVector animationVector, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? null : animationVector);
    }

    public VectorizedSpringSpec(float f11, float f12, @Nullable V v11) {
        this(f11, f12, VectorizedAnimationSpecKt.createSpringAnimations(v11, f11, f12));
    }
}
