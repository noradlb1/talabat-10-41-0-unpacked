package com.talabat.talabatcommon.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/utils/ProgressBarLoading;", "", "()V", "hideProgress", "", "view", "Landroid/view/View;", "showProgress", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProgressBarLoading {
    @NotNull
    public static final ProgressBarLoading INSTANCE = new ProgressBarLoading();

    private ProgressBarLoading() {
    }

    public final void hideProgress(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(8);
    }

    public final void showProgress(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(0);
    }
}
