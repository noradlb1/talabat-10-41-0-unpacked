package com.talabat.helpers;

import android.app.Activity;
import android.content.Intent;
import buisnessmodels.Customer;
import com.talabat.helpcenter.presentation.activity.GuestMessageForGhcWithLoginAction;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0007J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, d2 = {"Lcom/talabat/helpers/HelpCenterNavigator;", "", "()V", "navigateToHelpCenter", "", "context", "Landroid/app/Activity;", "entryPoint", "", "flags", "", "appVersion", "currentOrderId", "caseId", "navigateToHelpCenterQuestion", "showGlobalHelpCenter", "showGuestMessageForGhcWithLoginAction", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterNavigator {
    @NotNull
    public static final HelpCenterNavigator INSTANCE = new HelpCenterNavigator();

    private HelpCenterNavigator() {
    }

    @JvmStatic
    public static final void navigateToHelpCenter(@NotNull Activity activity, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        INSTANCE.navigateToHelpCenter(activity, "", str, str2, "", 0);
    }

    @JvmStatic
    public static final void navigateToHelpCenterQuestion(@NotNull Activity activity, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "currentOrderId");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        INSTANCE.navigateToHelpCenter(activity, str, GlobalHelpCenterWebViewActivity.ORDER_TRACKING, str2, "", 0);
    }

    private final void showGlobalHelpCenter(Activity activity, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, GlobalHelpCenterWebViewActivity.class);
        intent.putExtra("current_order_id", str);
        intent.putExtra("app_version", str2);
        intent.putExtra("help_center_entryPoint", str3);
        intent.putExtra("case_id", str4);
        activity.startActivity(intent);
    }

    private final void showGuestMessageForGhcWithLoginAction(Activity activity) {
        activity.startActivity(new Intent(activity, GuestMessageForGhcWithLoginAction.class));
    }

    @JvmStatic
    public static final void navigateToHelpCenter(@NotNull Activity activity, @NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        INSTANCE.navigateToHelpCenter(activity, "", str, str2, "", i11);
    }

    @JvmStatic
    public static final void navigateToHelpCenter(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "currentOrderId");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "entryPoint");
        Intrinsics.checkNotNullParameter(str4, "caseId");
        INSTANCE.navigateToHelpCenter(activity, str, str3, str2, str4, 0);
    }

    private final void navigateToHelpCenter(Activity activity, String str, String str2, String str3, String str4, int i11) {
        if (Customer.getInstance().isLoggedIn()) {
            showGlobalHelpCenter(activity, str, str3, str2, str4);
        } else {
            showGuestMessageForGhcWithLoginAction(activity);
        }
    }
}
