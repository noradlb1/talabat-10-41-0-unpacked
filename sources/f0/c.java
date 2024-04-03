package f0;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawTransform;

public final /* synthetic */ class c {
    public static long a(DrawTransform drawTransform) {
        float f11 = (float) 2;
        return OffsetKt.Offset(Size.m2745getWidthimpl(drawTransform.m3477getSizeNHjbRc()) / f11, Size.m2742getHeightimpl(drawTransform.m3477getSizeNHjbRc()) / f11);
    }

    public static /* synthetic */ void c(DrawTransform drawTransform, Path path, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            }
            drawTransform.m3474clipPathmtrdDE(path, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
    }

    public static /* synthetic */ void d(DrawTransform drawTransform, float f11, float f12, float f13, float f14, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                f11 = 0.0f;
            }
            if ((i12 & 2) != 0) {
                f12 = 0.0f;
            }
            if ((i12 & 4) != 0) {
                f13 = Size.m2745getWidthimpl(drawTransform.m3477getSizeNHjbRc());
            }
            if ((i12 & 8) != 0) {
                f14 = Size.m2742getHeightimpl(drawTransform.m3477getSizeNHjbRc());
            }
            if ((i12 & 16) != 0) {
                i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
            }
            drawTransform.m3475clipRectN_I0leg(f11, f12, f13, f14, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
    }

    public static /* synthetic */ void e(DrawTransform drawTransform, float f11, long j11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                j11 = drawTransform.m3476getCenterF1C5BW0();
            }
            drawTransform.m3478rotateUv8p0NA(f11, j11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
    }

    public static /* synthetic */ void f(DrawTransform drawTransform, float f11, float f12, long j11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                j11 = drawTransform.m3476getCenterF1C5BW0();
            }
            drawTransform.m3479scale0AR0LA0(f11, f12, j11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
    }

    public static /* synthetic */ void g(DrawTransform drawTransform, float f11, float f12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = 0.0f;
            }
            if ((i11 & 2) != 0) {
                f12 = 0.0f;
            }
            drawTransform.translate(f11, f12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
    }
}
