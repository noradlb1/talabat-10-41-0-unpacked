package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u0003HÂ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/FixedThreshold;", "Landroidx/compose/material3/ThresholdConfig;", "offset", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "component1", "component1-D9Ej5fM", "()F", "copy", "copy-0680j_4", "(F)Landroidx/compose/material3/FixedThreshold;", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class FixedThreshold implements ThresholdConfig {
    private final float offset;

    private FixedThreshold(float f11) {
        this.offset = f11;
    }

    public /* synthetic */ FixedThreshold(float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    private final float m1695component1D9Ej5fM() {
        return this.offset;
    }

    /* renamed from: copy-0680j_4$default  reason: not valid java name */
    public static /* synthetic */ FixedThreshold m1696copy0680j_4$default(FixedThreshold fixedThreshold, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = fixedThreshold.offset;
        }
        return fixedThreshold.m1697copy0680j_4(f11);
    }

    public float computeThreshold(@NotNull Density density, float f11, float f12) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return f11 + (density.m5447toPx0680j_4(this.offset) * Math.signum(f12 - f11));
    }

    @NotNull
    /* renamed from: copy-0680j_4  reason: not valid java name */
    public final FixedThreshold m1697copy0680j_4(float f11) {
        return new FixedThreshold(f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedThreshold) && Dp.m5483equalsimpl0(this.offset, ((FixedThreshold) obj).offset);
    }

    public int hashCode() {
        return Dp.m5484hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "FixedThreshold(offset=" + Dp.m5489toStringimpl(this.offset) + ')';
    }
}
