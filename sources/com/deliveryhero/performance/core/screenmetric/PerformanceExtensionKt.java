package com.deliveryhero.performance.core.screenmetric;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"getScreenName", "", "Landroid/app/Activity;", "Landroidx/fragment/app/Fragment;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PerformanceExtensionKt {
    @NotNull
    public static final String getScreenName(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        String simpleName = fragment.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    @NotNull
    public static final String getScreenName(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }
}
