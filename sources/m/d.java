package m;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class d<V extends AnimationVector> {
    @NotNull
    public static AnimationVector a(VectorizedAnimationSpec vectorizedAnimationSpec, @NotNull AnimationVector animationVector, @NotNull AnimationVector animationVector2, @NotNull AnimationVector animationVector3) {
        Intrinsics.checkNotNullParameter(animationVector, "initialValue");
        Intrinsics.checkNotNullParameter(animationVector2, "targetValue");
        Intrinsics.checkNotNullParameter(animationVector3, "initialVelocity");
        return vectorizedAnimationSpec.getVelocityFromNanos(vectorizedAnimationSpec.getDurationNanos(animationVector, animationVector2, animationVector3), animationVector, animationVector2, animationVector3);
    }
}
