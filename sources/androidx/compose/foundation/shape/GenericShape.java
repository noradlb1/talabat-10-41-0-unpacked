package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BK\u0012A\u0010\u0002\u001a=\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\rJ-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016RL\u0010\u0002\u001a=\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\fX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/shape/GenericShape;", "Landroidx/compose/ui/graphics/Shape;", "builder", "Lkotlin/Function3;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GenericShape implements Shape {
    public static final int $stable = 0;
    @NotNull
    private final Function3<Path, Size, LayoutDirection, Unit> builder;

    public GenericShape(@NotNull Function3<? super Path, ? super Size, ? super LayoutDirection, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "builder");
        this.builder = function3;
    }

    @NotNull
    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public Outline m817createOutlinePq9zytI(long j11, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Path Path = AndroidPath_androidKt.Path();
        this.builder.invoke(Path, Size.m2733boximpl(j11), layoutDirection);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        Function3<Path, Size, LayoutDirection, Unit> function3 = null;
        GenericShape genericShape = obj instanceof GenericShape ? (GenericShape) obj : null;
        if (genericShape != null) {
            function3 = genericShape.builder;
        }
        return Intrinsics.areEqual((Object) function3, (Object) this.builder);
    }

    public int hashCode() {
        return this.builder.hashCode();
    }
}
