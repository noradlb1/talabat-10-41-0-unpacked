package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"background", "Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BackgroundKt {
    @NotNull
    public static final Modifier background(@NotNull Modifier modifier, @NotNull Brush brush, @NotNull Shape shape, float f11) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BackgroundKt$background$$inlined$debugInspectorInfo$1(f11, brush, shape);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new Background((Color) null, brush, f11, shape, function1, 1, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, Brush brush, Shape shape, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i11 & 4) != 0) {
            f11 = 1.0f;
        }
        return background(modifier, brush, shape, f11);
    }

    @NotNull
    /* renamed from: background-bw27NRU  reason: not valid java name */
    public static final Modifier m176backgroundbw27NRU(@NotNull Modifier modifier, long j11, @NotNull Shape shape) {
        BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1 r62;
        Intrinsics.checkNotNullParameter(modifier, "$this$background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Color r22 = Color.m2909boximpl(j11);
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            r62 = new BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(j11, shape);
        } else {
            r62 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new Background(r22, (Brush) null, 0.0f, shape, r62, 6, (DefaultConstructorMarker) null));
    }

    /* renamed from: background-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ Modifier m177backgroundbw27NRU$default(Modifier modifier, long j11, Shape shape, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m176backgroundbw27NRU(modifier, j11, shape);
    }
}
