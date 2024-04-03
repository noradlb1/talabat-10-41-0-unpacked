package android.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"windowAttachCount", "", "view", "Landroid/view/View;", "curtains_release"}, k = 2, mv = {1, 4, 1})
public final class ViewSpyInternalKt {
    public static final int windowAttachCount(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return JavaViewSpy.a(view);
    }
}
