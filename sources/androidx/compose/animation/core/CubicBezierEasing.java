package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "(FFFF)V", "equals", "", "other", "", "evaluateCubic", "m", "hashCode", "", "transform", "fraction", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CubicBezierEasing implements Easing {

    /* renamed from: a  reason: collision with root package name */
    private final float f1318a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1319b;

    /* renamed from: c  reason: collision with root package name */
    private final float f1320c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1321d;

    public CubicBezierEasing(float f11, float f12, float f13, float f14) {
        this.f1318a = f11;
        this.f1319b = f12;
        this.f1320c = f13;
        this.f1321d = f14;
    }

    private final float evaluateCubic(float f11, float f12, float f13) {
        float f14 = (float) 3;
        float f15 = ((float) 1) - f13;
        return (f11 * f14 * f15 * f15 * f13) + (f14 * f12 * f15 * f13 * f13) + (f13 * f13 * f13);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (!(obj instanceof CubicBezierEasing)) {
            return false;
        }
        CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) obj;
        if (this.f1318a == cubicBezierEasing.f1318a) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (this.f1319b == cubicBezierEasing.f1319b) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (this.f1320c == cubicBezierEasing.f1320c) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        if (this.f1321d == cubicBezierEasing.f1321d) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f1318a) * 31) + Float.floatToIntBits(this.f1319b)) * 31) + Float.floatToIntBits(this.f1320c)) * 31) + Float.floatToIntBits(this.f1321d);
    }

    public float transform(float f11) {
        float f12 = 0.0f;
        if (f11 > 0.0f) {
            float f13 = 1.0f;
            if (f11 < 1.0f) {
                while (true) {
                    float f14 = (f12 + f13) / ((float) 2);
                    float evaluateCubic = evaluateCubic(this.f1318a, this.f1320c, f14);
                    if (Math.abs(f11 - evaluateCubic) < 0.001f) {
                        return evaluateCubic(this.f1319b, this.f1321d, f14);
                    }
                    if (evaluateCubic < f11) {
                        f12 = f14;
                    } else {
                        f13 = f14;
                    }
                }
            }
        }
        return f11;
    }
}
