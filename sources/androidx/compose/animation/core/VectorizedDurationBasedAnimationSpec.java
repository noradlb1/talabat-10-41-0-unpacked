package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m.d;
import m.e;
import m.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "delayMillis", "", "getDelayMillis", "()I", "durationMillis", "getDurationMillis", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VectorizedDurationBasedAnimationSpec<V extends AnimationVector> extends VectorizedFiniteAnimationSpec<V> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <V extends AnimationVector> long getDurationNanos(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
            Intrinsics.checkNotNullParameter(v11, "initialValue");
            Intrinsics.checkNotNullParameter(v12, "targetValue");
            Intrinsics.checkNotNullParameter(v13, "initialVelocity");
            return e.a(vectorizedDurationBasedAnimationSpec, v11, v12, v13);
        }

        @NotNull
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
            Intrinsics.checkNotNullParameter(v11, "initialValue");
            Intrinsics.checkNotNullParameter(v12, "targetValue");
            Intrinsics.checkNotNullParameter(v13, "initialVelocity");
            return d.a(vectorizedDurationBasedAnimationSpec, v11, v12, v13);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec) {
            return f.a(vectorizedDurationBasedAnimationSpec);
        }
    }

    int getDelayMillis();

    int getDurationMillis();

    long getDurationNanos(@NotNull V v11, @NotNull V v12, @NotNull V v13);
}
