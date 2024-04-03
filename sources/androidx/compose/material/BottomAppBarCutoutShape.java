package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\"\u001a\u00020 *\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "component1", "component2", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class BottomAppBarCutoutShape implements Shape {
    @NotNull
    private final Shape cutoutShape;
    @NotNull
    private final FabPlacement fabPlacement;

    public BottomAppBarCutoutShape(@NotNull Shape shape, @NotNull FabPlacement fabPlacement2) {
        Intrinsics.checkNotNullParameter(shape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement2, "fabPlacement");
        this.cutoutShape = shape;
        this.fabPlacement = fabPlacement2;
    }

    private final void addCutoutShape(Path path, LayoutDirection layoutDirection, Density density) {
        float r02 = density.m5447toPx0680j_4(AppBarKt.BottomAppBarCutoutOffset);
        float f11 = ((float) 2) * r02;
        long Size = SizeKt.Size(((float) this.fabPlacement.getWidth()) + f11, ((float) this.fabPlacement.getHeight()) + f11);
        float left = ((float) this.fabPlacement.getLeft()) - r02;
        float r72 = left + Size.m2745getWidthimpl(Size);
        float r82 = Size.m2742getHeightimpl(Size) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.m3232createOutlinePq9zytI(Size, layoutDirection, density));
        path.m3154translatek4lQ0M(OffsetKt.Offset(left, -r82));
        if (Intrinsics.areEqual((Object) this.cutoutShape, (Object) RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges(path, left, r72, r82, density.m5447toPx0680j_4(AppBarKt.BottomAppBarRoundedEdgeRadius), 0.0f);
        }
    }

    private final void addRoundedEdges(Path path, float f11, float f12, float f13, float f14, float f15) {
        float f16 = -((float) Math.sqrt((double) ((f13 * f13) - (f15 * f15))));
        float f17 = f13 + f16;
        float f18 = f11 + f17;
        float f19 = f12 - f17;
        Pair<Float, Float> calculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(f16 - 1.0f, f15, f13);
        float floatValue = calculateRoundedEdgeIntercept.component1().floatValue() + f13;
        float floatValue2 = calculateRoundedEdgeIntercept.component2().floatValue() - f15;
        float f21 = f18 - f14;
        path.moveTo(f21, 0.0f);
        path.quadraticBezierTo(f18 - 1.0f, 0.0f, f11 + floatValue, floatValue2);
        path.lineTo(f12 - floatValue, floatValue2);
        path.quadraticBezierTo(f19 + 1.0f, 0.0f, f14 + f19, 0.0f);
        path.close();
    }

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i11 & 2) != 0) {
            fabPlacement2 = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement2);
    }

    @NotNull
    public final Shape component1() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    @NotNull
    public final BottomAppBarCutoutShape copy(@NotNull Shape shape, @NotNull FabPlacement fabPlacement2) {
        Intrinsics.checkNotNullParameter(shape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement2, "fabPlacement");
        return new BottomAppBarCutoutShape(shape, fabPlacement2);
    }

    @NotNull
    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m1105createOutlinePq9zytI(long j11, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect(new Rect(0.0f, 0.0f, Size.m2745getWidthimpl(j11), Size.m2742getHeightimpl(j11)));
        Path Path2 = AndroidPath_androidKt.Path();
        addCutoutShape(Path2, layoutDirection, density);
        Path2.m3152opN5in7k0(Path, Path2, PathOperation.Companion.m3174getDifferenceb3I0S0c());
        return new Outline.Generic(Path2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return Intrinsics.areEqual((Object) this.cutoutShape, (Object) bottomAppBarCutoutShape.cutoutShape) && Intrinsics.areEqual((Object) this.fabPlacement, (Object) bottomAppBarCutoutShape.fabPlacement);
    }

    @NotNull
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    @NotNull
    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }
}
