package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m.d;
import m.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "isInfinite", "", "()Z", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VectorizedFiniteAnimationSpec<V extends AnimationVector> extends VectorizedAnimationSpec<V> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        @Deprecated
        public static <V extends AnimationVector> V getEndVelocity(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec, @NotNull V v11, @NotNull V v12, @NotNull V v13) {
            Intrinsics.checkNotNullParameter(v11, "initialValue");
            Intrinsics.checkNotNullParameter(v12, "targetValue");
            Intrinsics.checkNotNullParameter(v13, "initialVelocity");
            return d.a(vectorizedFiniteAnimationSpec, v11, v12, v13);
        }

        @Deprecated
        public static <V extends AnimationVector> boolean isInfinite(@NotNull VectorizedFiniteAnimationSpec<V> vectorizedFiniteAnimationSpec) {
            return f.a(vectorizedFiniteAnimationSpec);
        }
    }

    boolean isInfinite();
}
