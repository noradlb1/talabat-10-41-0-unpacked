package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;
import m0.d2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/ViewRootForInspector;", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ViewRootForInspector {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        @Deprecated
        public static AbstractComposeView getSubCompositionView(@NotNull ViewRootForInspector viewRootForInspector) {
            return d2.a(viewRootForInspector);
        }

        @Nullable
        @Deprecated
        public static View getViewRoot(@NotNull ViewRootForInspector viewRootForInspector) {
            return d2.b(viewRootForInspector);
        }
    }

    @Nullable
    AbstractComposeView getSubCompositionView();

    @Nullable
    View getViewRoot();
}
