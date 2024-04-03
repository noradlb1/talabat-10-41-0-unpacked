package androidx.compose.animation;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/FlingCalculator;", "", "friction", "", "density", "Landroidx/compose/ui/unit/Density;", "(FLandroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "computeDeceleration", "flingDistance", "velocity", "flingDuration", "", "flingInfo", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "getSplineDeceleration", "", "FlingInfo", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlingCalculator {
    @NotNull
    private final Density density;
    private final float friction;
    private final float magicPhysicalCoefficient;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/FlingCalculator$FlingInfo;", "", "initialVelocity", "", "distance", "duration", "", "(FFJ)V", "getDistance", "()F", "getDuration", "()J", "getInitialVelocity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "position", "time", "toString", "", "velocity", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FlingInfo {
        public static final int $stable = 0;
        private final float distance;
        private final long duration;
        private final float initialVelocity;

        public FlingInfo(float f11, float f12, long j11) {
            this.initialVelocity = f11;
            this.distance = f12;
            this.duration = j11;
        }

        public static /* synthetic */ FlingInfo copy$default(FlingInfo flingInfo, float f11, float f12, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = flingInfo.initialVelocity;
            }
            if ((i11 & 2) != 0) {
                f12 = flingInfo.distance;
            }
            if ((i11 & 4) != 0) {
                j11 = flingInfo.duration;
            }
            return flingInfo.copy(f11, f12, j11);
        }

        public final float component1() {
            return this.initialVelocity;
        }

        public final float component2() {
            return this.distance;
        }

        public final long component3() {
            return this.duration;
        }

        @NotNull
        public final FlingInfo copy(float f11, float f12, long j11) {
            return new FlingInfo(f11, f12, j11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingInfo)) {
                return false;
            }
            FlingInfo flingInfo = (FlingInfo) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.initialVelocity), (Object) Float.valueOf(flingInfo.initialVelocity)) && Intrinsics.areEqual((Object) Float.valueOf(this.distance), (Object) Float.valueOf(flingInfo.distance)) && this.duration == flingInfo.duration;
        }

        public final float getDistance() {
            return this.distance;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getInitialVelocity() {
            return this.initialVelocity;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.initialVelocity) * 31) + Float.floatToIntBits(this.distance)) * 31) + a.a(this.duration);
        }

        public final float position(long j11) {
            float f11;
            long j12 = this.duration;
            if (j12 > 0) {
                f11 = ((float) j11) / ((float) j12);
            } else {
                f11 = 1.0f;
            }
            return this.distance * Math.signum(this.initialVelocity) * AndroidFlingSpline.INSTANCE.flingPosition(f11).getDistanceCoefficient();
        }

        @NotNull
        public String toString() {
            return "FlingInfo(initialVelocity=" + this.initialVelocity + ", distance=" + this.distance + ", duration=" + this.duration + ')';
        }

        public final float velocity(long j11) {
            float f11;
            long j12 = this.duration;
            if (j12 > 0) {
                f11 = ((float) j11) / ((float) j12);
            } else {
                f11 = 1.0f;
            }
            return (((AndroidFlingSpline.INSTANCE.flingPosition(f11).getVelocityCoefficient() * Math.signum(this.initialVelocity)) * this.distance) / ((float) this.duration)) * 1000.0f;
        }
    }

    public FlingCalculator(float f11, @NotNull Density density2) {
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        this.friction = f11;
        this.density = density2;
        this.magicPhysicalCoefficient = computeDeceleration(density2);
    }

    private final float computeDeceleration(Density density2) {
        return FlingCalculatorKt.computeDeceleration(0.84f, density2.getDensity());
    }

    private final double getSplineDeceleration(float f11) {
        return AndroidFlingSpline.INSTANCE.deceleration(f11, this.friction * this.magicPhysicalCoefficient);
    }

    public final float flingDistance(float f11) {
        double splineDeceleration = getSplineDeceleration(f11);
        return (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.DecelerationRate) / (((double) FlingCalculatorKt.DecelerationRate) - 1.0d)) * splineDeceleration));
    }

    public final long flingDuration(float f11) {
        return (long) (Math.exp(getSplineDeceleration(f11) / (((double) FlingCalculatorKt.DecelerationRate) - 1.0d)) * 1000.0d);
    }

    @NotNull
    public final FlingInfo flingInfo(float f11) {
        double splineDeceleration = getSplineDeceleration(f11);
        double access$getDecelerationRate$p = ((double) FlingCalculatorKt.DecelerationRate) - 1.0d;
        return new FlingInfo(f11, (float) (((double) (this.friction * this.magicPhysicalCoefficient)) * Math.exp((((double) FlingCalculatorKt.DecelerationRate) / access$getDecelerationRate$p) * splineDeceleration)), (long) (Math.exp(splineDeceleration / access$getDecelerationRate$p) * 1000.0d));
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }
}
