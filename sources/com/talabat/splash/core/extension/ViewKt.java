package com.talabat.splash.core.extension;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0006"}, d2 = {"invisible", "", "Landroid/view/View;", "isVisible", "", "visible", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewKt {
    public static final void invisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final boolean isVisible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final void visible(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }
}
