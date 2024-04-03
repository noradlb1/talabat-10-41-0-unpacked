package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import m0.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\n\u001a\u00020\u0004HÂ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tJ \u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\u00020\u00048VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    private DpCornerSize(float f11) {
        this.size = f11;
    }

    public /* synthetic */ DpCornerSize(float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    private final float m812component1D9Ej5fM() {
        return this.size;
    }

    /* renamed from: copy-0680j_4$default  reason: not valid java name */
    public static /* synthetic */ DpCornerSize m813copy0680j_4$default(DpCornerSize dpCornerSize, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = dpCornerSize.size;
        }
        return dpCornerSize.m814copy0680j_4(f11);
    }

    @NotNull
    /* renamed from: copy-0680j_4  reason: not valid java name */
    public final DpCornerSize m814copy0680j_4(float f11) {
        return new DpCornerSize(f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DpCornerSize) && Dp.m5483equalsimpl0(this.size, ((DpCornerSize) obj).size);
    }

    public /* synthetic */ Sequence getInspectableElements() {
        return u.a(this);
    }

    public /* synthetic */ String getNameFallback() {
        return u.b(this);
    }

    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return Dp.m5476boximpl(m815getValueOverrideD9Ej5fM());
    }

    /* renamed from: getValueOverride-D9Ej5fM  reason: not valid java name */
    public float m815getValueOverrideD9Ej5fM() {
        return this.size;
    }

    public int hashCode() {
        return Dp.m5484hashCodeimpl(this.size);
    }

    /* renamed from: toPx-TmRCtEA  reason: not valid java name */
    public float m816toPxTmRCtEA(long j11, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return density.m5447toPx0680j_4(this.size);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }
}
