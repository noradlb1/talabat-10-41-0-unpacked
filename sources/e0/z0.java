package e0;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class z0 {
    public static void a(Canvas canvas, @NotNull Rect rect, int i11) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        canvas.m2885clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), i11);
    }

    public static void b(Canvas canvas, @NotNull Rect rect, float f11, float f12, boolean z11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f11, f12, z11, paint);
    }

    public static void c(Canvas canvas, @NotNull Rect rect, float f11, float f12, boolean z11, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawArc(rect, DegreesKt.degrees(f11), DegreesKt.degrees(f12), z11, paint);
    }

    public static void d(Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public static void e(Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    public static void f(Canvas canvas, float f11, float f12) {
        canvas.skew(DegreesKt.degrees(f11), DegreesKt.degrees(f12));
    }

    public static /* synthetic */ void m(Canvas canvas, Path path, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            }
            canvas.m2884clipPathmtrdDE(path, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
    }

    public static /* synthetic */ void n(Canvas canvas, float f11, float f12, float f13, float f14, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 16) != 0) {
                i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            }
            canvas.m2885clipRectN_I0leg(f11, f12, f13, f14, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
    }

    public static /* synthetic */ void o(Canvas canvas, Rect rect, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            }
            canvas.m2886clipRectmtrdDE(rect, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
    }

    public static /* synthetic */ void p(Canvas canvas, ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, Paint paint, int i11, Object obj) {
        long j15;
        long j16;
        long j17;
        long j18;
        if (obj == null) {
            if ((i11 & 2) != 0) {
                j15 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j15 = j11;
            }
            if ((i11 & 4) != 0) {
                j16 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
            } else {
                j16 = j12;
            }
            if ((i11 & 8) != 0) {
                j17 = IntOffset.Companion.m5606getZeronOccac();
            } else {
                j17 = j13;
            }
            if ((i11 & 16) != 0) {
                j18 = j16;
            } else {
                j18 = j14;
            }
            canvas.m2890drawImageRectHPBpro0(imageBitmap, j15, j16, j17, j18, paint);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
    }

    public static /* synthetic */ void q(Canvas canvas, float f11, float f12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                f12 = f11;
            }
            canvas.scale(f11, f12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
    }
}
