package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScope$drawContext$1", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "value", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "transform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "getTransform", "()Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CanvasDrawScope$drawContext$1 implements DrawContext {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CanvasDrawScope f9655a;
    @NotNull
    private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

    public CanvasDrawScope$drawContext$1(CanvasDrawScope canvasDrawScope) {
        this.f9655a = canvasDrawScope;
    }

    @NotNull
    public Canvas getCanvas() {
        return this.f9655a.getDrawParams().getCanvas();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m3379getSizeNHjbRc() {
        return this.f9655a.getDrawParams().m3377getSizeNHjbRc();
    }

    @NotNull
    public DrawTransform getTransform() {
        return this.transform;
    }

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    public void m3380setSizeuvyYCjk(long j11) {
        this.f9655a.getDrawParams().m3378setSizeuvyYCjk(j11);
    }
}
