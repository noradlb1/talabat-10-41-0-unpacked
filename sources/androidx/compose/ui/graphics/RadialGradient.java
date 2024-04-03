package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RadialGradient extends ShaderBrush {
    private final long center;
    @NotNull
    private final List<Color> colors;
    private final float radius;
    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RadialGradient(List list, List list2, long j11, float f11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i12 & 2) != 0 ? null : list2, j11, f11, (i12 & 16) != 0 ? TileMode.Companion.m3274getClamp3opZhB0() : i11, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j11, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j11, f11, i11);
    }

    @NotNull
    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3190createShaderuvyYCjk(long j11) {
        float f11;
        float f12;
        float f13;
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (OffsetKt.m2697isUnspecifiedk4lQ0M(this.center)) {
            long r42 = SizeKt.m2755getCenteruvyYCjk(j11);
            f12 = Offset.m2676getXimpl(r42);
            f11 = Offset.m2677getYimpl(r42);
        } else {
            if (Offset.m2676getXimpl(this.center) == Float.POSITIVE_INFINITY) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                f12 = Size.m2745getWidthimpl(j11);
            } else {
                f12 = Offset.m2676getXimpl(this.center);
            }
            if (Offset.m2677getYimpl(this.center) == Float.POSITIVE_INFINITY) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                f11 = Size.m2742getHeightimpl(j11);
            } else {
                f11 = Offset.m2677getYimpl(this.center);
            }
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long Offset = OffsetKt.Offset(f12, f11);
        float f14 = this.radius;
        if (f14 != Float.POSITIVE_INFINITY) {
            z13 = false;
        }
        if (z13) {
            f13 = Size.m2744getMinDimensionimpl(j11) / ((float) 2);
        } else {
            f13 = f14;
        }
        return ShaderKt.m3222RadialGradientShader8uybcMk(Offset, f13, list, list2, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        if (!Intrinsics.areEqual((Object) this.colors, (Object) radialGradient.colors) || !Intrinsics.areEqual((Object) this.stops, (Object) radialGradient.stops) || !Offset.m2673equalsimpl0(this.center, radialGradient.center)) {
            return false;
        }
        if (this.radius == radialGradient.radius) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && TileMode.m3270equalsimpl0(this.tileMode, radialGradient.tileMode)) {
            return true;
        }
        return false;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3191getIntrinsicSizeNHjbRc() {
        float f11 = this.radius;
        if (!(!Float.isInfinite(f11) && !Float.isNaN(f11))) {
            return Size.Companion.m2753getUnspecifiedNHjbRc();
        }
        float f12 = this.radius;
        float f13 = (float) 2;
        return SizeKt.Size(f12 * f13, f12 * f13);
    }

    public int hashCode() {
        int i11;
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        if (list != null) {
            i11 = list.hashCode();
        } else {
            i11 = 0;
        }
        return ((((((hashCode + i11) * 31) + Offset.m2678hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m3271hashCodeimpl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        boolean z11;
        String str2 = "";
        if (OffsetKt.m2695isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + Offset.m2684toStringimpl(this.center) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        } else {
            str = str2;
        }
        float f11 = this.radius;
        if (Float.isInfinite(f11) || Float.isNaN(f11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            str2 = "radius=" + this.radius + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str + str2 + "tileMode=" + TileMode.m3272toStringimpl(this.tileMode) + ')';
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j11, float f11, int i11) {
        this.colors = list;
        this.stops = list2;
        this.center = j11;
        this.radius = f11;
        this.tileMode = i11;
    }
}
