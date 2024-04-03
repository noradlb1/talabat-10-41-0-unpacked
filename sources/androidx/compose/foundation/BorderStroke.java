package androidx.compose.foundation;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/BorderStroke;", "", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "(FLandroidx/compose/ui/graphics/Brush;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getWidth-D9Ej5fM", "()F", "F", "copy", "copy-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)Landroidx/compose/foundation/BorderStroke;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BorderStroke {
    @NotNull
    private final Brush brush;
    private final float width;

    private BorderStroke(float f11, Brush brush2) {
        this.width = f11;
        this.brush = brush2;
    }

    public /* synthetic */ BorderStroke(float f11, Brush brush2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, brush2);
    }

    /* renamed from: copy-D5KLDUw$default  reason: not valid java name */
    public static /* synthetic */ BorderStroke m188copyD5KLDUw$default(BorderStroke borderStroke, float f11, Brush brush2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = borderStroke.width;
        }
        if ((i11 & 2) != 0) {
            brush2 = borderStroke.brush;
        }
        return borderStroke.m189copyD5KLDUw(f11, brush2);
    }

    @NotNull
    /* renamed from: copy-D5KLDUw  reason: not valid java name */
    public final BorderStroke m189copyD5KLDUw(float f11, @NotNull Brush brush2) {
        Intrinsics.checkNotNullParameter(brush2, "brush");
        return new BorderStroke(f11, brush2, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        if (Dp.m5483equalsimpl0(this.width, borderStroke.width) && Intrinsics.areEqual((Object) this.brush, (Object) borderStroke.brush)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m190getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m5484hashCodeimpl(this.width) * 31) + this.brush.hashCode();
    }

    @NotNull
    public String toString() {
        return "BorderStroke(width=" + Dp.m5489toStringimpl(this.width) + ", brush=" + this.brush + ')';
    }
}
