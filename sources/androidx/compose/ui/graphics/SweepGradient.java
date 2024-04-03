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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SweepGradient extends ShaderBrush {
    private final long center;
    @NotNull
    private final List<Color> colors;
    @Nullable
    private final List<Float> stops;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SweepGradient(long j11, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, list, (i11 & 4) != 0 ? null : list2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ SweepGradient(long j11, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, list, list2);
    }

    @NotNull
    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3266createShaderuvyYCjk(long j11) {
        long j12;
        boolean z11;
        float f11;
        float f12;
        if (OffsetKt.m2697isUnspecifiedk4lQ0M(this.center)) {
            j12 = SizeKt.m2755getCenteruvyYCjk(j11);
        } else {
            boolean z12 = true;
            if (Offset.m2676getXimpl(this.center) == Float.POSITIVE_INFINITY) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                f11 = Size.m2745getWidthimpl(j11);
            } else {
                f11 = Offset.m2676getXimpl(this.center);
            }
            if (Offset.m2677getYimpl(this.center) != Float.POSITIVE_INFINITY) {
                z12 = false;
            }
            if (z12) {
                f12 = Size.m2742getHeightimpl(j11);
            } else {
                f12 = Offset.m2677getYimpl(this.center);
            }
            j12 = OffsetKt.Offset(f11, f12);
        }
        return ShaderKt.m3224SweepGradientShader9KIMszo(j12, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        if (Offset.m2673equalsimpl0(this.center, sweepGradient.center) && Intrinsics.areEqual((Object) this.colors, (Object) sweepGradient.colors) && Intrinsics.areEqual((Object) this.stops, (Object) sweepGradient.stops)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int r02 = ((Offset.m2678hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        if (list != null) {
            i11 = list.hashCode();
        } else {
            i11 = 0;
        }
        return r02 + i11;
    }

    @NotNull
    public String toString() {
        String str;
        if (OffsetKt.m2695isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + Offset.m2684toStringimpl(this.center) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }

    private SweepGradient(long j11, List<Color> list, List<Float> list2) {
        this.center = j11;
        this.colors = list;
        this.stops = list2;
    }
}
