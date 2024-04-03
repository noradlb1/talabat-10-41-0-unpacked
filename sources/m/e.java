package m;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class e<V extends AnimationVector> {
    public static long a(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, @NotNull AnimationVector animationVector, @NotNull AnimationVector animationVector2, @NotNull AnimationVector animationVector3) {
        Intrinsics.checkNotNullParameter(animationVector, "initialValue");
        Intrinsics.checkNotNullParameter(animationVector2, "targetValue");
        Intrinsics.checkNotNullParameter(animationVector3, "initialVelocity");
        return ((long) (vectorizedDurationBasedAnimationSpec.getDelayMillis() + vectorizedDurationBasedAnimationSpec.getDurationMillis())) * 1000000;
    }
}
