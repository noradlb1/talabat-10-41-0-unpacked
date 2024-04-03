package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\b\b\u0001\u0010\u0016*\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00160\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/SpringSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)V", "getDampingRatio", "()F", "getStiffness", "getVisibilityThreshold", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpringSpec<T> implements FiniteAnimationSpec<T> {
    private final float dampingRatio;
    private final float stiffness;
    @Nullable
    private final T visibilityThreshold;

    public SpringSpec() {
        this(0.0f, 0.0f, (Object) null, 7, (DefaultConstructorMarker) null);
    }

    public SpringSpec(float f11, float f12, @Nullable T t11) {
        this.dampingRatio = f11;
        this.stiffness = f12;
        this.visibilityThreshold = t11;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (!(obj instanceof SpringSpec)) {
            return false;
        }
        SpringSpec springSpec = (SpringSpec) obj;
        if (springSpec.dampingRatio == this.dampingRatio) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (springSpec.stiffness == this.stiffness) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 || !Intrinsics.areEqual((Object) springSpec.visibilityThreshold, (Object) this.visibilityThreshold)) {
            return false;
        }
        return true;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    @Nullable
    public final T getVisibilityThreshold() {
        return this.visibilityThreshold;
    }

    public int hashCode() {
        T t11 = this.visibilityThreshold;
        return ((((t11 != null ? t11.hashCode() : 0) * 31) + Float.floatToIntBits(this.dampingRatio)) * 31) + Float.floatToIntBits(this.stiffness);
    }

    @NotNull
    public <V extends AnimationVector> VectorizedSpringSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedSpringSpec<>(this.dampingRatio, this.stiffness, AnimationSpecKt.convert(twoWayConverter, this.visibilityThreshold));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpringSpec(float f11, float f12, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 1.0f : f11, (i11 & 2) != 0 ? 1500.0f : f12, (i11 & 4) != 0 ? null : obj);
    }
}
