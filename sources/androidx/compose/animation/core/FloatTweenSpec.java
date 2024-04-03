package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.b;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDuration", "clampPlayTime", "", "playTime", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final int duration;
    @NotNull
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null);
    }

    public FloatTweenSpec(int i11, int i12, @NotNull Easing easing2) {
        Intrinsics.checkNotNullParameter(easing2, "easing");
        this.duration = i11;
        this.delay = i12;
        this.easing = easing2;
    }

    private final long clampPlayTime(long j11) {
        return RangesKt___RangesKt.coerceIn(j11 - ((long) this.delay), 0, (long) this.duration);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDuration() {
        return this.duration;
    }

    public long getDurationNanos(float f11, float f12, float f13) {
        return ((long) (this.delay + this.duration)) * 1000000;
    }

    public /* synthetic */ float getEndVelocity(float f11, float f12, float f13) {
        return b.a(this, f11, f12, f13);
    }

    public float getValueFromNanos(long j11, float f11, float f12, float f13) {
        float f14;
        long clampPlayTime = clampPlayTime(j11 / 1000000);
        int i11 = this.duration;
        if (i11 == 0) {
            f14 = 1.0f;
        } else {
            f14 = ((float) clampPlayTime) / ((float) i11);
        }
        return VectorConvertersKt.lerp(f11, f12, this.easing.transform(RangesKt___RangesKt.coerceIn(f14, 0.0f, 1.0f)));
    }

    public float getVelocityFromNanos(long j11, float f11, float f12, float f13) {
        long clampPlayTime = clampPlayTime(j11 / 1000000);
        int i11 = (clampPlayTime > 0 ? 1 : (clampPlayTime == 0 ? 0 : -1));
        if (i11 < 0) {
            return 0.0f;
        }
        if (i11 == 0) {
            return f13;
        }
        return (getValueFromNanos(clampPlayTime * 1000000, f11, f12, f13) - getValueFromNanos((clampPlayTime - 1) * 1000000, f11, f12, f13)) * 1000.0f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatTweenSpec(int i11, int i12, Easing easing2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 300 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing2);
    }
}
