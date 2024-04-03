package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"androidx/compose/ui/graphics/RectangleShapeKt$RectangleShape$1", "Landroidx/compose/ui/graphics/Shape;", "createOutline", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline$Rectangle;", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RectangleShapeKt$RectangleShape$1 implements Shape {
    @NotNull
    public String toString() {
        return "RectangleShape";
    }

    @NotNull
    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline.Rectangle m3193createOutlinePq9zytI(long j11, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return new Outline.Rectangle(SizeKt.m2766toRectuvyYCjk(j11));
    }
}
