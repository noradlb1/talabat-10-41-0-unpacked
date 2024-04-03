package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/Scale;", "", "scale", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getScale", "()F", "getTransformOrigin-SzJe1aQ", "()J", "J", "component1", "component2", "component2-SzJe1aQ", "component3", "copy", "copy-bnNdC4k", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;)Landroidx/compose/animation/Scale;", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Scale {
    @NotNull
    private final FiniteAnimationSpec<Float> animationSpec;
    private final float scale;
    private final long transformOrigin;

    private Scale(float f11, long j11, FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.scale = f11;
        this.transformOrigin = j11;
        this.animationSpec = finiteAnimationSpec;
    }

    public /* synthetic */ Scale(float f11, long j11, FiniteAnimationSpec finiteAnimationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, j11, finiteAnimationSpec);
    }

    /* renamed from: copy-bnNdC4k$default  reason: not valid java name */
    public static /* synthetic */ Scale m81copybnNdC4k$default(Scale scale2, float f11, long j11, FiniteAnimationSpec<Float> finiteAnimationSpec, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = scale2.scale;
        }
        if ((i11 & 2) != 0) {
            j11 = scale2.transformOrigin;
        }
        if ((i11 & 4) != 0) {
            finiteAnimationSpec = scale2.animationSpec;
        }
        return scale2.m83copybnNdC4k(f11, j11, finiteAnimationSpec);
    }

    public final float component1() {
        return this.scale;
    }

    /* renamed from: component2-SzJe1aQ  reason: not valid java name */
    public final long m82component2SzJe1aQ() {
        return this.transformOrigin;
    }

    @NotNull
    public final FiniteAnimationSpec<Float> component3() {
        return this.animationSpec;
    }

    @NotNull
    /* renamed from: copy-bnNdC4k  reason: not valid java name */
    public final Scale m83copybnNdC4k(float f11, long j11, @NotNull FiniteAnimationSpec<Float> finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new Scale(f11, j11, finiteAnimationSpec, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scale)) {
            return false;
        }
        Scale scale2 = (Scale) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.scale), (Object) Float.valueOf(scale2.scale)) && TransformOrigin.m3286equalsimpl0(this.transformOrigin, scale2.transformOrigin) && Intrinsics.areEqual((Object) this.animationSpec, (Object) scale2.animationSpec);
    }

    @NotNull
    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final float getScale() {
        return this.scale;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public final long m84getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.scale) * 31) + TransformOrigin.m3289hashCodeimpl(this.transformOrigin)) * 31) + this.animationSpec.hashCode();
    }

    @NotNull
    public String toString() {
        return "Scale(scale=" + this.scale + ", transformOrigin=" + TransformOrigin.m3290toStringimpl(this.transformOrigin) + ", animationSpec=" + this.animationSpec + ')';
    }
}
