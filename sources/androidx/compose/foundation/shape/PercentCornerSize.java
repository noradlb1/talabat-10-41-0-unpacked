package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import m0.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/shape/PercentCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "percent", "", "(F)V", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PercentCornerSize implements CornerSize, InspectableValue {
    private final float percent;

    public PercentCornerSize(float f11) {
        this.percent = f11;
        if (f11 < 0.0f || f11 > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    private final float component1() {
        return this.percent;
    }

    public static /* synthetic */ PercentCornerSize copy$default(PercentCornerSize percentCornerSize, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = percentCornerSize.percent;
        }
        return percentCornerSize.copy(f11);
    }

    @NotNull
    public final PercentCornerSize copy(float f11) {
        return new PercentCornerSize(f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PercentCornerSize) && Intrinsics.areEqual((Object) Float.valueOf(this.percent), (Object) Float.valueOf(((PercentCornerSize) obj).percent));
    }

    public /* synthetic */ Sequence getInspectableElements() {
        return u.a(this);
    }

    public /* synthetic */ String getNameFallback() {
        return u.b(this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    /* renamed from: toPx-TmRCtEA  reason: not valid java name */
    public float m818toPxTmRCtEA(long j11, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return Size.m2744getMinDimensionimpl(j11) * (this.percent / 100.0f);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }

    @NotNull
    public String getValueOverride() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.percent);
        sb2.append('%');
        return sb2.toString();
    }
}
