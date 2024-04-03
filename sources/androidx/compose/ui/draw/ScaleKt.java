package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"scale", "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ScaleKt {
    @NotNull
    @Stable
    public static final Modifier scale(@NotNull Modifier modifier, float f11, float f12) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        boolean z11 = true;
        if (f11 == 1.0f) {
            if (f12 != 1.0f) {
                z11 = false;
            }
            if (z11) {
                return modifier2;
            }
        }
        return GraphicsLayerModifierKt.m3056graphicsLayerpANQ8Wg$default(modifier, f11, f12, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65532, (Object) null);
    }

    @NotNull
    @Stable
    public static final Modifier scale(@NotNull Modifier modifier, float f11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return scale(modifier, f11, f11);
    }
}
