package com.talabat.helpers;

import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"loadingIndicator", "Lcom/talabat/helpers/CustomDialog;", "getLoadingIndicator", "hideLoading", "", "Landroidx/fragment/app/FragmentActivity;", "showLoading", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LoadingIndicatorKt {
    @Nullable
    private static CustomDialog loadingIndicator;

    @VisibleForTesting(otherwise = 2)
    @Nullable
    public static final CustomDialog getLoadingIndicator() {
        return loadingIndicator;
    }

    public static final void hideLoading(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        CustomDialog customDialog = loadingIndicator;
        if (customDialog != null) {
            customDialog.hide();
        }
        loadingIndicator = null;
    }

    public static final void showLoading(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        CustomDialog customDialog = loadingIndicator;
        if (customDialog != null) {
            customDialog.show();
        }
        if (loadingIndicator == null && !fragmentActivity.isFinishing()) {
            loadingIndicator = new CustomDialog(fragmentActivity);
        }
        CustomDialog customDialog2 = loadingIndicator;
        if (customDialog2 != null) {
            customDialog2.show();
        }
        ContextLifecycleEventsKt.withLifecycleEvents(fragmentActivity, new LoadingIndicatorKt$showLoading$1(fragmentActivity));
    }
}
