package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.d;
import m.f;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB2\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ%\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J-\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/VectorizedRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialOffsetNanos", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedRepeatableSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    @NotNull
    private final VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final int iterations;
    @NotNull
    private final RepeatMode repeatMode;

    private VectorizedRepeatableSpec(int i11, VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j11) {
        this.iterations = i11;
        this.animation = vectorizedDurationBasedAnimationSpec;
        this.repeatMode = repeatMode2;
        if (i11 >= 1) {
            this.durationNanos = ((long) (vectorizedDurationBasedAnimationSpec.getDelayMillis() + vectorizedDurationBasedAnimationSpec.getDurationMillis())) * 1000000;
            this.initialOffsetNanos = j11 * 1000000;
            return;
        }
        throw new IllegalArgumentException("Iterations count can't be less than 1");
    }

    public /* synthetic */ VectorizedRepeatableSpec(int i11, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, vectorizedDurationBasedAnimationSpec, repeatMode2, j11);
    }

    private final long repetitionPlayTimeNanos(long j11) {
        long j12 = this.initialOffsetNanos;
        if (j11 + j12 <= 0) {
            return 0;
        }
        long j13 = j11 + j12;
        long min = Math.min(j13 / this.durationNanos, ((long) this.iterations) - 1);
        if (this.repeatMode == RepeatMode.Restart || min % ((long) 2) == 0) {
            return j13 - (min * this.durationNanos);
        }
        return ((min + 1) * this.durationNanos) - j13;
    }

    private final V repetitionStartVelocity(long j11, V v11, V v12, V v13) {
        long j12 = this.initialOffsetNanos;
        long j13 = this.durationNanos;
        if (j11 + j12 <= j13) {
            return v12;
        }
        return getVelocityFromNanos(j13 - j12, v11, v12, v13);
    }

    public long getDurationNanos(@NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return (((long) this.iterations) * this.durationNanos) - this.initialOffsetNanos;
    }

    public final long getDurationNanos$animation_core_release() {
        return this.durationNanos;
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return d.a(this, animationVector, animationVector2, animationVector3);
    }

    @NotNull
    public V getValueFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(j11), v11, v12, repetitionStartVelocity(j11, v11, v13, v12));
    }

    @NotNull
    public V getVelocityFromNanos(long j11, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
        Intrinsics.checkNotNullParameter(v11, "initialValue");
        Intrinsics.checkNotNullParameter(v12, "targetValue");
        Intrinsics.checkNotNullParameter(v13, "initialVelocity");
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(j11), v11, v12, repetitionStartVelocity(j11, v11, v13, v12));
    }

    public /* synthetic */ boolean isInfinite() {
        return f.a(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedRepeatableSpec(int i11, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, vectorizedDurationBasedAnimationSpec, (i12 & 4) != 0 ? RepeatMode.Restart : repeatMode2, (i12 & 8) != 0 ? StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null) : j11, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedRepeatableSpec(int i11, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, vectorizedDurationBasedAnimationSpec, (i12 & 4) != 0 ? RepeatMode.Restart : repeatMode2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public /* synthetic */ VectorizedRepeatableSpec(int i11, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2) {
        this(i11, vectorizedDurationBasedAnimationSpec, repeatMode2, StartOffset.m131constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(vectorizedDurationBasedAnimationSpec, Param.ANIMATION);
        Intrinsics.checkNotNullParameter(repeatMode2, Param.REPEAT_MODE);
    }
}
