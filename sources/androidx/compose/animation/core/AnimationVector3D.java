package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\r\u0010\u001c\u001a\u00020\u0000H\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001fH\u0010¢\u0006\u0002\b J\u001e\u0010!\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0002\b#J\b\u0010$\u001a\u00020%H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006&"}, d2 = {"Landroidx/compose/animation/core/AnimationVector3D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "(FFF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "getV3", "setV3$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimationVector3D extends AnimationVector {
    public static final int $stable = 8;
    private final int size = 3;

    /* renamed from: v1  reason: collision with root package name */
    private float f1311v1;

    /* renamed from: v2  reason: collision with root package name */
    private float f1312v2;

    /* renamed from: v3  reason: collision with root package name */
    private float f1313v3;

    public AnimationVector3D(float f11, float f12, float f13) {
        super((DefaultConstructorMarker) null);
        this.f1311v1 = f11;
        this.f1312v2 = f12;
        this.f1313v3 = f13;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AnimationVector3D)) {
            return false;
        }
        AnimationVector3D animationVector3D = (AnimationVector3D) obj;
        if (!(animationVector3D.f1311v1 == this.f1311v1)) {
            return false;
        }
        if (!(animationVector3D.f1312v2 == this.f1312v2)) {
            return false;
        }
        return (animationVector3D.f1313v3 > this.f1313v3 ? 1 : (animationVector3D.f1313v3 == this.f1313v3 ? 0 : -1)) == 0;
    }

    public float get$animation_core_release(int i11) {
        if (i11 == 0) {
            return this.f1311v1;
        }
        if (i11 == 1) {
            return this.f1312v2;
        }
        if (i11 != 2) {
            return 0.0f;
        }
        return this.f1313v3;
    }

    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f1311v1;
    }

    public final float getV2() {
        return this.f1312v2;
    }

    public final float getV3() {
        return this.f1313v3;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f1311v1) * 31) + Float.floatToIntBits(this.f1312v2)) * 31) + Float.floatToIntBits(this.f1313v3);
    }

    public void reset$animation_core_release() {
        this.f1311v1 = 0.0f;
        this.f1312v2 = 0.0f;
        this.f1313v3 = 0.0f;
    }

    public void set$animation_core_release(int i11, float f11) {
        if (i11 == 0) {
            this.f1311v1 = f11;
        } else if (i11 == 1) {
            this.f1312v2 = f11;
        } else if (i11 == 2) {
            this.f1313v3 = f11;
        }
    }

    public final void setV1$animation_core_release(float f11) {
        this.f1311v1 = f11;
    }

    public final void setV2$animation_core_release(float f11) {
        this.f1312v2 = f11;
    }

    public final void setV3$animation_core_release(float f11) {
        this.f1313v3 = f11;
    }

    @NotNull
    public String toString() {
        return "AnimationVector3D: v1 = " + this.f1311v1 + ", v2 = " + this.f1312v2 + ", v3 = " + this.f1313v3;
    }

    @NotNull
    public AnimationVector3D newVector$animation_core_release() {
        return new AnimationVector3D(0.0f, 0.0f, 0.0f);
    }
}
