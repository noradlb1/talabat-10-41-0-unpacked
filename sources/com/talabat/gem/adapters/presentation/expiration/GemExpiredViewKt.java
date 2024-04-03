package com.talabat.gem.adapters.presentation.expiration;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n\u001a$\u0010\u000b\u001a\u00020\b*\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0007\u001a6\u0010\f\u001a\u00020\b*\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"EXPIRY_DIALOG_FRAGMENT_TAG", "", "buildAlertDialog", "Landroidx/fragment/app/DialogFragment;", "context", "Landroid/content/Context;", "onCloseView", "Lkotlin/Function0;", "", "isCollectionGemRestaurant", "", "displayAlert", "showGemExpiredView", "triggerFlag", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemExpiredViewKt {
    @NotNull
    public static final String EXPIRY_DIALOG_FRAGMENT_TAG = "ExpiryDialogFragment";

    @NotNull
    public static final DialogFragment buildAlertDialog(@NotNull Context context, @Nullable Function0<Unit> function0, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        ExpiryDialogFragment expiryDialogFragment = new ExpiryDialogFragment(function0, z11);
        expiryDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager().beginTransaction(), EXPIRY_DIALOG_FRAGMENT_TAG);
        return expiryDialogFragment;
    }

    @VisibleForTesting
    public static final void displayAlert(@NotNull Context context, @Nullable Function0<Unit> function0, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        CoroutinesKt.runHandling(new GemExpiredViewKt$displayAlert$1(IntegrationKt.getLogger()), new GemExpiredViewKt$displayAlert$2(context, function0, z11));
    }

    @GemViewsDsl
    public static final void showGemExpiredView(@NotNull Context context, @NotNull Function0<Boolean> function0, @Nullable Function0<Unit> function02, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(function0, "triggerFlag");
        ContextLifecycleEventsKt.withLifecycleEvents(context, new GemExpiredViewKt$showGemExpiredView$1(function0, context, function02, z11));
    }

    public static /* synthetic */ void showGemExpiredView$default(Context context, Function0 function0, Function0 function02, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function02 = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        showGemExpiredView(context, function0, function02, z11);
    }
}
