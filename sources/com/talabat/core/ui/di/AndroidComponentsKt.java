package com.talabat.core.ui.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.di.ApiContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0006"}, d2 = {"apiContainer", "Lcom/talabat/core/di/ApiContainer;", "Landroid/app/Activity;", "Landroid/content/Context;", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "com_talabat_core_ui_ui"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidComponentsKt {
    @NotNull
    public static final ApiContainer apiContainer(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Application application = activity.getApplication();
        if (application != null) {
            return (ApiContainer) application;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    @NotNull
    public static final ApiContainer apiContainer(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return apiContainer((Activity) requireActivity);
    }

    @NotNull
    public static final ApiContainer apiContainer(@NotNull Context context) {
        ApiContainer apiContainer;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (apiContainer = apiContainer(activity)) != null) {
            return apiContainer;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return (ApiContainer) applicationContext;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    @NotNull
    public static final ApiContainer apiContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return apiContainer(context);
    }
}
