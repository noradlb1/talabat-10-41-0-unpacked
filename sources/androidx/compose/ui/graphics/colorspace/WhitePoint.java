package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B'\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", "z", "(FFF)V", "sum", "(FFFF)V", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "toXyz", "", "toXyz$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WhitePoint {

    /* renamed from: x  reason: collision with root package name */
    private final float f9653x;

    /* renamed from: y  reason: collision with root package name */
    private final float f9654y;

    public WhitePoint(float f11, float f12) {
        this.f9653x = f11;
        this.f9654y = f12;
    }

    public static /* synthetic */ WhitePoint copy$default(WhitePoint whitePoint, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = whitePoint.f9653x;
        }
        if ((i11 & 2) != 0) {
            f12 = whitePoint.f9654y;
        }
        return whitePoint.copy(f11, f12);
    }

    public final float component1() {
        return this.f9653x;
    }

    public final float component2() {
        return this.f9654y;
    }

    @NotNull
    public final WhitePoint copy(float f11, float f12) {
        return new WhitePoint(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.f9653x), (Object) Float.valueOf(whitePoint.f9653x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f9654y), (Object) Float.valueOf(whitePoint.f9654y));
    }

    public final float getX() {
        return this.f9653x;
    }

    public final float getY() {
        return this.f9654y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f9653x) * 31) + Float.floatToIntBits(this.f9654y);
    }

    @NotNull
    public String toString() {
        return "WhitePoint(x=" + this.f9653x + ", y=" + this.f9654y + ')';
    }

    @NotNull
    public final float[] toXyz$ui_graphics_release() {
        float f11 = this.f9653x;
        float f12 = this.f9654y;
        return new float[]{f11 / f12, 1.0f, ((1.0f - f11) - f12) / f12};
    }

    public WhitePoint(float f11, float f12, float f13) {
        this(f11, f12, f13, f11 + f12 + f13);
    }

    private WhitePoint(float f11, float f12, float f13, float f14) {
        this(f11 / f14, f12 / f14);
    }
}
