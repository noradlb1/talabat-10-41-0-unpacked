package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DefaultDensity", "Landroidx/compose/ui/unit/Density;", "asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CanvasDrawScopeKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(DrawContext drawContext) {
        return new CanvasDrawScopeKt$asDrawTransform$1(drawContext);
    }
}
