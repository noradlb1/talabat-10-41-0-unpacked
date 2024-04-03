package curtains;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcurtains/OnRootViewAddedListener;", "Lcurtains/OnRootViewsChangedListener;", "onRootViewAdded", "", "view", "Landroid/view/View;", "onRootViewsChanged", "added", "", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface OnRootViewAddedListener extends OnRootViewsChangedListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        public static void onRootViewsChanged(@NotNull OnRootViewAddedListener onRootViewAddedListener, @NotNull View view, boolean z11) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (z11) {
                onRootViewAddedListener.onRootViewAdded(view);
            }
        }
    }

    void onRootViewAdded(@NotNull View view);

    void onRootViewsChanged(@NotNull View view, boolean z11);
}
