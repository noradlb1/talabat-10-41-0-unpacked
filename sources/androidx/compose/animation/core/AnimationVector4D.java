package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\tH\u0016J\r\u0010\u001f\u001a\u00020\u0000H\u0010¢\u0006\u0002\b J\r\u0010!\u001a\u00020\"H\u0010¢\u0006\u0002\b#J\u001e\u0010$\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0002\b&J\b\u0010'\u001a\u00020(H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006)"}, d2 = {"Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "v4", "(FFFF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "getV3", "setV3$animation_core_release", "getV4", "setV4$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimationVector4D extends AnimationVector {
    public static final int $stable = 8;
    private final int size = 4;

    /* renamed from: v1  reason: collision with root package name */
    private float f1314v1;

    /* renamed from: v2  reason: collision with root package name */
    private float f1315v2;

    /* renamed from: v3  reason: collision with root package name */
    private float f1316v3;

    /* renamed from: v4  reason: collision with root package name */
    private float f1317v4;

    public AnimationVector4D(float f11, float f12, float f13, float f14) {
        super((DefaultConstructorMarker) null);
        this.f1314v1 = f11;
        this.f1315v2 = f12;
        this.f1316v3 = f13;
        this.f1317v4 = f14;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (!(obj instanceof AnimationVector4D)) {
            return false;
        }
        AnimationVector4D animationVector4D = (AnimationVector4D) obj;
        if (animationVector4D.f1314v1 == this.f1314v1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (animationVector4D.f1315v2 == this.f1315v2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        if (animationVector4D.f1316v3 == this.f1316v3) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        if (animationVector4D.f1317v4 == this.f1317v4) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            return true;
        }
        return false;
    }

    public float get$animation_core_release(int i11) {
        if (i11 == 0) {
            return this.f1314v1;
        }
        if (i11 == 1) {
            return this.f1315v2;
        }
        if (i11 == 2) {
            return this.f1316v3;
        }
        if (i11 != 3) {
            return 0.0f;
        }
        return this.f1317v4;
    }

    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f1314v1;
    }

    public final float getV2() {
        return this.f1315v2;
    }

    public final float getV3() {
        return this.f1316v3;
    }

    public final float getV4() {
        return this.f1317v4;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f1314v1) * 31) + Float.floatToIntBits(this.f1315v2)) * 31) + Float.floatToIntBits(this.f1316v3)) * 31) + Float.floatToIntBits(this.f1317v4);
    }

    public void reset$animation_core_release() {
        this.f1314v1 = 0.0f;
        this.f1315v2 = 0.0f;
        this.f1316v3 = 0.0f;
        this.f1317v4 = 0.0f;
    }

    public void set$animation_core_release(int i11, float f11) {
        if (i11 == 0) {
            this.f1314v1 = f11;
        } else if (i11 == 1) {
            this.f1315v2 = f11;
        } else if (i11 == 2) {
            this.f1316v3 = f11;
        } else if (i11 == 3) {
            this.f1317v4 = f11;
        }
    }

    public final void setV1$animation_core_release(float f11) {
        this.f1314v1 = f11;
    }

    public final void setV2$animation_core_release(float f11) {
        this.f1315v2 = f11;
    }

    public final void setV3$animation_core_release(float f11) {
        this.f1316v3 = f11;
    }

    public final void setV4$animation_core_release(float f11) {
        this.f1317v4 = f11;
    }

    @NotNull
    public String toString() {
        return "AnimationVector4D: v1 = " + this.f1314v1 + ", v2 = " + this.f1315v2 + ", v3 = " + this.f1316v3 + ", v4 = " + this.f1317v4;
    }

    @NotNull
    public AnimationVector4D newVector$animation_core_release() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
