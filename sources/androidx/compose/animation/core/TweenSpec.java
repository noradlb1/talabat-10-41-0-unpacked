package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0001\u0010\u0015*\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0018H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/compose/animation/core/TweenSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "durationMillis", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TweenSpec<T> implements DurationBasedAnimationSpec<T> {
    private final int delay;
    private final int durationMillis;
    @NotNull
    private final Easing easing;

    public TweenSpec() {
        this(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null);
    }

    public TweenSpec(int i11, int i12, @NotNull Easing easing2) {
        Intrinsics.checkNotNullParameter(easing2, "easing");
        this.durationMillis = i11;
        this.delay = i12;
        this.easing = easing2;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TweenSpec)) {
            return false;
        }
        TweenSpec tweenSpec = (TweenSpec) obj;
        if (tweenSpec.durationMillis == this.durationMillis && tweenSpec.delay == this.delay && Intrinsics.areEqual((Object) tweenSpec.easing, (Object) this.easing)) {
            return true;
        }
        return false;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @NotNull
    public final Easing getEasing() {
        return this.easing;
    }

    public int hashCode() {
        return (((this.durationMillis * 31) + this.easing.hashCode()) * 31) + this.delay;
    }

    @NotNull
    public <V extends AnimationVector> VectorizedTweenSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedTweenSpec<>(this.durationMillis, this.delay, this.easing);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TweenSpec(int i11, int i12, Easing easing2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 300 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing2);
    }
}
