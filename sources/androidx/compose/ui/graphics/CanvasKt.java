package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a,\u0010\f\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a\u001e\u0010\u000f\u001a\u00020\u0005*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\bø\u0001\u0000\u001a.\u0010\u0012\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"Canvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "rotate", "", "degrees", "", "pivotX", "pivotY", "rotateRad", "radians", "scale", "sx", "sy", "withSave", "block", "Lkotlin/Function0;", "withSaveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CanvasKt {
    @NotNull
    public static final Canvas Canvas(@NotNull ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return AndroidCanvas_androidKt.ActualCanvas(imageBitmap);
    }

    public static final void rotate(@NotNull Canvas canvas, float f11, float f12, float f13) {
        boolean z11;
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            canvas.translate(f12, f13);
            canvas.rotate(f11);
            canvas.translate(-f12, -f13);
        }
    }

    public static final void rotateRad(@NotNull Canvas canvas, float f11, float f12, float f13) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        rotate(canvas, DegreesKt.degrees(f11), f12, f13);
    }

    public static /* synthetic */ void rotateRad$default(Canvas canvas, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 0.0f;
        }
        rotateRad(canvas, f11, f12, f13);
    }

    public static final void scale(@NotNull Canvas canvas, float f11, float f12, float f13, float f14) {
        boolean z11;
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        boolean z12 = true;
        if (f11 == 1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (f12 != 1.0f) {
                z12 = false;
            }
            if (z12) {
                return;
            }
        }
        canvas.translate(f13, f14);
        canvas.scale(f11, f12);
        canvas.translate(-f13, -f14);
    }

    public static /* synthetic */ void scale$default(Canvas canvas, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f12 = f11;
        }
        scale(canvas, f11, f12, f13, f14);
    }

    public static final void withSave(@NotNull Canvas canvas, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            canvas.save();
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSaveLayer(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            canvas.saveLayer(rect, paint);
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            InlineMarker.finallyEnd(1);
        }
    }
}
