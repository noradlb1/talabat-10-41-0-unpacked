package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.d;
import m.e;
import m.f;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/core/VectorizedSnapSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "delayMillis", "", "(I)V", "getDelayMillis", "()I", "durationMillis", "getDurationMillis", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedSnapSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 0;
    private final int delayMillis;

    public VectorizedSnapSpec() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public VectorizedSnapSpec(int i11) {
        this.delayMillis = i11;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public int getDurationMillis() {
        return 0;
    }

    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return e.a(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return d.a(this, animationVector, animationVector2, animationVector3);
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        if (j11 < ((long) getDelayMillis()) * 1000000) {
            return v11;
        }
        return v12;
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return v13;
    }

    public /* synthetic */ boolean isInfinite() {
        return f.a(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedSnapSpec(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }
}
