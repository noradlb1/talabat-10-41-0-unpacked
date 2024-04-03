package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/FloatAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "vectorize", "Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FloatAnimationSpec extends AnimationSpec<Float> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static float getEndVelocity(@NotNull FloatAnimationSpec floatAnimationSpec, float f11, float f12, float f13) {
            return b.a(floatAnimationSpec, f11, f12, f13);
        }

        @NotNull
        @Deprecated
        public static <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull FloatAnimationSpec floatAnimationSpec, @NotNull TwoWayConverter<Float, V> twoWayConverter) {
            Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
            return b.c(floatAnimationSpec, twoWayConverter);
        }
    }

    long getDurationNanos(float f11, float f12, float f13);

    float getEndVelocity(float f11, float f12, float f13);

    float getValueFromNanos(long j11, float f11, float f12, float f13);

    float getVelocityFromNanos(long j11, float f11, float f12, float f13);

    /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter);

    @NotNull
    <V extends AnimationVector> VectorizedFloatAnimationSpec<V> vectorize(@NotNull TwoWayConverter<Float, V> twoWayConverter);
}
