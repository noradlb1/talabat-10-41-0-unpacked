package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R \u0010\u0014\u001a\u00020\u00138\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0019R#\u0010\u001b\u001a\u00020\u001a8\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/graphics/painter/ColorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "d", "", "alpha", "", "a", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "b", "", "other", "equals", "", "hashCode", "", "toString", "Landroidx/compose/ui/graphics/Color;", "color", "J", "getColor-0d7_KjU", "()J", "F", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/geometry/Size;", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public final class ColorPainter extends Painter {
    private float alpha;
    private final long color;
    @Nullable
    private ColorFilter colorFilter;
    private final long intrinsicSize;

    private ColorPainter(long j11) {
        this.color = j11;
        this.alpha = 1.0f;
        this.intrinsicSize = Size.Companion.m2753getUnspecifiedNHjbRc();
    }

    public /* synthetic */ ColorPainter(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    public boolean a(float f11) {
        this.alpha = f11;
        return true;
    }

    public boolean b(@Nullable ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        return true;
    }

    public void d(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        b.K(drawScope, this.color, 0, 0, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ColorPainter) && Color.m2920equalsimpl0(this.color, ((ColorPainter) obj).color)) {
            return true;
        }
        return false;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3512getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3513getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    public int hashCode() {
        return Color.m2926hashCodeimpl(this.color);
    }

    @NotNull
    public String toString() {
        return "ColorPainter(color=" + Color.m2927toStringimpl(this.color) + ')';
    }
}
