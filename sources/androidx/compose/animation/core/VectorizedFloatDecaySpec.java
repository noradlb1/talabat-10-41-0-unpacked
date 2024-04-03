package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0010\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "targetVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;
    @NotNull
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatDecaySpec(@NotNull FloatDecayAnimationSpec floatDecayAnimationSpec) {
        Intrinsics.checkNotNullParameter(floatDecayAnimationSpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public long getDurationNanos(@NotNull V v11, @NotNull V v12) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v11);
        }
        V v13 = this.velocityVector;
        if (v13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v13 = null;
        }
        int size$animation_core_release = v13.getSize$animation_core_release();
        long j11 = 0;
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            j11 = Math.max(j11, this.floatDecaySpec.getDurationNanos(v11.get$animation_core_release(i11), v12.get$animation_core_release(i11)));
        }
        return j11;
    }

    @NotNull
    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    @NotNull
    public V getTargetValue(@NotNull V v11, @NotNull V v12) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "initialVelocity");
        if (this.targetVector == null) {
            this.targetVector = AnimationVectorsKt.newInstance(v11);
        }
        V v13 = this.targetVector;
        if (v13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            v13 = null;
        }
        int size$animation_core_release = v13.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v14 = this.targetVector;
            if (v14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                v14 = null;
            }
            v14.set$animation_core_release(i11, this.floatDecaySpec.getTargetValue(v11.get$animation_core_release(i11), v12.get$animation_core_release(i11)));
        }
        V v15 = this.targetVector;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "initialVelocity");
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v11);
        }
        V v13 = this.valueVector;
        if (v13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v13 = null;
        }
        int size$animation_core_release = v13.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v14 = this.valueVector;
            if (v14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v14 = null;
            }
            v14.set$animation_core_release(i11, this.floatDecaySpec.getValueFromNanos(j11, v11.get$animation_core_release(i11), v12.get$animation_core_release(i11)));
        }
        V v15 = this.valueVector;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "initialVelocity");
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v11);
        }
        V v13 = this.velocityVector;
        if (v13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v13 = null;
        }
        int size$animation_core_release = v13.getSize$animation_core_release();
        for (int i11 = 0; i11 < size$animation_core_release; i11++) {
            V v14 = this.velocityVector;
            if (v14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v14 = null;
            }
            v14.set$animation_core_release(i11, this.floatDecaySpec.getVelocityFromNanos(j11, v11.get$animation_core_release(i11), v12.get$animation_core_release(i11)));
        }
        V v15 = this.velocityVector;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
