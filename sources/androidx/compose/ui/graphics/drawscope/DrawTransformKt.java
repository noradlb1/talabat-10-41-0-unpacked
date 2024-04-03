package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003H\b\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\b\u001a,\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "horizontal", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "scale", "scale-0AR0LA0", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DrawTransformKt {
    public static final void inset(@NotNull DrawTransform drawTransform, float f11, float f12) {
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f11, f12, f11, f12);
    }

    public static /* synthetic */ void inset$default(DrawTransform drawTransform, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f11, f12, f11, f12);
    }

    /* renamed from: rotateRad-0AR0LA0  reason: not valid java name */
    public static final void m3486rotateRad0AR0LA0(@NotNull DrawTransform drawTransform, float f11, long j11) {
        Intrinsics.checkNotNullParameter(drawTransform, "$this$rotateRad");
        drawTransform.m3478rotateUv8p0NA(DegreesKt.degrees(f11), j11);
    }

    /* renamed from: rotateRad-0AR0LA0$default  reason: not valid java name */
    public static /* synthetic */ void m3487rotateRad0AR0LA0$default(DrawTransform drawTransform, float f11, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = drawTransform.m3476getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawTransform, "$this$rotateRad");
        drawTransform.m3478rotateUv8p0NA(DegreesKt.degrees(f11), j11);
    }

    /* renamed from: scale-0AR0LA0  reason: not valid java name */
    public static final void m3488scale0AR0LA0(@NotNull DrawTransform drawTransform, float f11, long j11) {
        Intrinsics.checkNotNullParameter(drawTransform, "$this$scale");
        drawTransform.m3479scale0AR0LA0(f11, f11, j11);
    }

    /* renamed from: scale-0AR0LA0$default  reason: not valid java name */
    public static /* synthetic */ void m3489scale0AR0LA0$default(DrawTransform drawTransform, float f11, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = drawTransform.m3476getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawTransform, "$this$scale");
        drawTransform.m3479scale0AR0LA0(f11, f11, j11);
    }

    public static final void inset(@NotNull DrawTransform drawTransform, float f11) {
        Intrinsics.checkNotNullParameter(drawTransform, "<this>");
        drawTransform.inset(f11, f11, f11, f11);
    }
}
