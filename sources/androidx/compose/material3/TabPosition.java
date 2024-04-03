package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001a\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "right", "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TabPosition {
    private final float left;
    private final float width;

    private TabPosition(float f11, float f12) {
        this.left = f11;
        this.width = f12;
    }

    public /* synthetic */ TabPosition(float f11, float f12, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        if (Dp.m5483equalsimpl0(this.left, tabPosition.left) && Dp.m5483equalsimpl0(this.width, tabPosition.width)) {
            return true;
        }
        return false;
    }

    /* renamed from: getLeft-D9Ej5fM  reason: not valid java name */
    public final float m1888getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getRight-D9Ej5fM  reason: not valid java name */
    public final float m1889getRightD9Ej5fM() {
        return Dp.m5478constructorimpl(this.left + this.width);
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m1890getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m5484hashCodeimpl(this.left) * 31) + Dp.m5484hashCodeimpl(this.width);
    }

    @NotNull
    public String toString() {
        return "TabPosition(left=" + Dp.m5489toStringimpl(this.left) + ", right=" + Dp.m5489toStringimpl(m1889getRightD9Ej5fM()) + ", width=" + Dp.m5489toStringimpl(this.width) + ')';
    }
}
