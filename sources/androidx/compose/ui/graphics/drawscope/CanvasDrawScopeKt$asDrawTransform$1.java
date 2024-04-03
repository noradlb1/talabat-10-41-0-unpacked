package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J%\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScopeKt$asDrawTransform$1", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CanvasDrawScopeKt$asDrawTransform$1 implements DrawTransform {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawContext f9656a;

    public CanvasDrawScopeKt$asDrawTransform$1(DrawContext drawContext) {
        this.f9656a = drawContext;
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m3381clipPathmtrdDE(@NotNull Path path, int i11) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f9656a.getCanvas().m2884clipPathmtrdDE(path, i11);
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m3382clipRectN_I0leg(float f11, float f12, float f13, float f14, int i11) {
        this.f9656a.getCanvas().m2885clipRectN_I0leg(f11, f12, f13, f14, i11);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m3383getCenterF1C5BW0() {
        return SizeKt.m2755getCenteruvyYCjk(m3384getSizeNHjbRc());
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m3384getSizeNHjbRc() {
        return this.f9656a.m3403getSizeNHjbRc();
    }

    public void inset(float f11, float f12, float f13, float f14) {
        boolean z11;
        Canvas canvas = this.f9656a.getCanvas();
        DrawContext drawContext = this.f9656a;
        long Size = SizeKt.Size(Size.m2745getWidthimpl(m3384getSizeNHjbRc()) - (f13 + f11), Size.m2742getHeightimpl(m3384getSizeNHjbRc()) - (f14 + f12));
        if (Size.m2745getWidthimpl(Size) < 0.0f || Size.m2742getHeightimpl(Size) < 0.0f) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            drawContext.m3404setSizeuvyYCjk(Size);
            canvas.translate(f11, f12);
            return;
        }
        throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
    }

    /* renamed from: rotate-Uv8p0NA  reason: not valid java name */
    public void m3385rotateUv8p0NA(float f11, long j11) {
        Canvas canvas = this.f9656a.getCanvas();
        canvas.translate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        canvas.rotate(f11);
        canvas.translate(-Offset.m2676getXimpl(j11), -Offset.m2677getYimpl(j11));
    }

    /* renamed from: scale-0AR0LA0  reason: not valid java name */
    public void m3386scale0AR0LA0(float f11, float f12, long j11) {
        Canvas canvas = this.f9656a.getCanvas();
        canvas.translate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        canvas.scale(f11, f12);
        canvas.translate(-Offset.m2676getXimpl(j11), -Offset.m2677getYimpl(j11));
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m3387transform58bKbWc(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        this.f9656a.getCanvas().m2887concat58bKbWc(fArr);
    }

    public void translate(float f11, float f12) {
        this.f9656a.getCanvas().translate(f11, f12);
    }
}
