package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0001\u0010\u000f*\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/core/SnapSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "delay", "", "(I)V", "getDelay", "()I", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SnapSpec<T> implements DurationBasedAnimationSpec<T> {
    private final int delay;

    public SnapSpec() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public SnapSpec(int i11) {
        this.delay = i11;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SnapSpec) || ((SnapSpec) obj).delay != this.delay) {
            return false;
        }
        return true;
    }

    public final int getDelay() {
        return this.delay;
    }

    public int hashCode() {
        return this.delay;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapSpec(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    @NotNull
    public <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedSnapSpec(this.delay);
    }
}
