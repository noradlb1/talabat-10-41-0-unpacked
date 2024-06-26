package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "initialValue", "visibilityThreshold", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnimatableKt {
    @NotNull
    public static final Animatable<Float, AnimationVector1D> Animatable(float f11, float f12) {
        return new Animatable<>(Float.valueOf(f11), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f12));
    }

    public static /* synthetic */ Animatable Animatable$default(float f11, float f12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 0.01f;
        }
        return Animatable(f11, f12);
    }
}
