package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RotateKt {
    @NotNull
    @Stable
    public static final Modifier rotate(@NotNull Modifier modifier, float f11) {
        boolean z11;
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return GraphicsLayerModifierKt.m3056graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f11, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65279, (Object) null);
        }
        return modifier2;
    }
}
