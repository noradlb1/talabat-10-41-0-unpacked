package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001ai\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001ak\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\u0014\u001a\u0002H\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0016\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0002*\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\u0014\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "AnimationState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "copy", "value", "velocityVector", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "velocity", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnimationStateKt {
    @NotNull
    public static final AnimationState<Float, AnimationVector1D> AnimationState(float f11, float f12, long j11, long j12, boolean z11) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f11), AnimationVectorsKt.AnimationVector(f12), j11, j12, z11);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f11, float f12, long j11, long j12, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        long j13 = Long.MIN_VALUE;
        long j14 = (i11 & 4) != 0 ? Long.MIN_VALUE : j11;
        if ((i11 & 8) == 0) {
            j13 = j12;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        return AnimationState(f11, f12, j14, j13, z11);
    }

    @NotNull
    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(@NotNull AnimationState<T, V> animationState, T t11, @Nullable V v11, long j11, long j12, boolean z11) {
        AnimationState<T, V> animationState2 = animationState;
        Intrinsics.checkNotNullParameter(animationState, "<this>");
        return new AnimationState(animationState.getTypeConverter(), t11, v11, j11, j12, z11);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j11, long j12, boolean z11, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i11 & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        AnimationVector animationVector2 = animationVector;
        if ((i11 & 4) != 0) {
            j11 = animationState.getLastFrameTimeNanos();
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            j12 = animationState.getFinishedTimeNanos();
        }
        long j14 = j12;
        if ((i11 & 16) != 0) {
            z11 = animationState.isRunning();
        }
        return copy(animationState, obj, animationVector2, j13, j14, z11);
    }

    @NotNull
    public static final <T, V extends AnimationVector> V createZeroVectorFrom(@NotNull TwoWayConverter<T, V> twoWayConverter, T t11) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "<this>");
        return AnimationVectorsKt.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(t11));
    }

    public static final boolean isFinished(@NotNull AnimationState<?, ?> animationState) {
        Intrinsics.checkNotNullParameter(animationState, "<this>");
        if (animationState.getFinishedTimeNanos() != Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j11, long j12, boolean z11, int i11, Object obj3) {
        return AnimationState(twoWayConverter, obj, obj2, (i11 & 8) != 0 ? Long.MIN_VALUE : j11, (i11 & 16) != 0 ? Long.MIN_VALUE : j12, (i11 & 32) != 0 ? false : z11);
    }

    @NotNull
    public static final AnimationState<Float, AnimationVector1D> copy(@NotNull AnimationState<Float, AnimationVector1D> animationState, float f11, float f12, long j11, long j12, boolean z11) {
        AnimationState<Float, AnimationVector1D> animationState2 = animationState;
        Intrinsics.checkNotNullParameter(animationState, "<this>");
        return new AnimationState(animationState.getTypeConverter(), Float.valueOf(f11), AnimationVectorsKt.AnimationVector(f12), j11, j12, z11);
    }

    @NotNull
    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(@NotNull TwoWayConverter<T, V> twoWayConverter, T t11, T t12, long j11, long j12, boolean z11) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        T t13 = t12;
        return new AnimationState(twoWayConverter, t11, (AnimationVector) twoWayConverter.getConvertToVector().invoke(t12), j11, j12, z11);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f11, float f12, long j11, long j12, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = ((Number) animationState.getValue()).floatValue();
        }
        if ((i11 & 2) != 0) {
            f12 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        }
        float f13 = f12;
        if ((i11 & 4) != 0) {
            j11 = animationState.getLastFrameTimeNanos();
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            j12 = animationState.getFinishedTimeNanos();
        }
        long j14 = j12;
        if ((i11 & 16) != 0) {
            z11 = animationState.isRunning();
        }
        return copy((AnimationState<Float, AnimationVector1D>) animationState, f11, f13, j13, j14, z11);
    }
}
