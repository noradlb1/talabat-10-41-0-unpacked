package com.talabat.feature.helpcenter;

import android.app.Activity;
import android.content.Intent;
import buisnessmodels.Customer;
import com.talabat.helpcenter.presentation.activity.GuestMessageForGhcWithLoginAction;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bJ0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/helpcenter/HelpCenterNavigator;", "", "()V", "navigateToHelpCenter", "", "context", "Landroid/app/Activity;", "entryPoint", "", "appVersion", "currentOrderId", "caseId", "showGlobalHelpCenter", "showGuestMessageForGhcWithLoginAction", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterNavigator {
    @NotNull
    public static final HelpCenterNavigator INSTANCE = new HelpCenterNavigator();

    private HelpCenterNavigator() {
    }

    public static /* synthetic */ void navigateToHelpCenter$default(HelpCenterNavigator helpCenterNavigator, Activity activity, String str, String str2, String str3, String str4, int i11, Object obj) {
        String str5;
        String str6;
        if ((i11 & 8) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i11 & 16) != 0) {
            str6 = "";
        } else {
            str6 = str4;
        }
        helpCenterNavigator.navigateToHelpCenter(activity, str, str2, str5, str6);
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

    public final void navigateToHelpCenter(@NotNull Activity activity, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "currentOrderId");
        Intrinsics.checkNotNullParameter(str4, "caseId");
        if (Customer.getInstance().isLoggedIn(activity)) {
            showGlobalHelpCenter(activity, str3, str2, str, str4);
        } else {
            showGuestMessageForGhcWithLoginAction(activity);
        }
    }
}
