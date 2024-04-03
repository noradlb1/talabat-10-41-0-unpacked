package m;

import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorizedFloatAnimationSpec;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class b {
    public static float a(FloatAnimationSpec floatAnimationSpec, float f11, float f12, float f13) {
        return floatAnimationSpec.getVelocityFromNanos(floatAnimationSpec.getDurationNanos(f11, f12, f13), f11, f12, f13);
    }

    @NotNull
    public static VectorizedFloatAnimationSpec c(FloatAnimationSpec floatAnimationSpec, @NotNull TwoWayConverter twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedFloatAnimationSpec(floatAnimationSpec);
    }
}
