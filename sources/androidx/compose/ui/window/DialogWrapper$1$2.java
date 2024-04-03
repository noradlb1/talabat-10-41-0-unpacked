package androidx.compose.ui.window;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/window/DialogWrapper$1$2", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "result", "Landroid/graphics/Outline;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DialogWrapper$1$2 extends ViewOutlineProvider {
    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "result");
        outline.setRect(0, 0, view.getWidth(), view.getHeight());
        outline.setAlpha(0.0f);
    }
}
