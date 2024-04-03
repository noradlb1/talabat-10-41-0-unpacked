package com.talabat.growth.ui.util;

import android.app.Activity;
import android.content.Context;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.home.HomeNavigationActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/util/DeepLinkUtilNavigator;", "Lcom/talabat/growth/ui/util/DeepLinkNavigator;", "()V", "startHomeScreenWithDeepLink", "", "activity", "Landroid/app/Activity;", "voucherDeepLink", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeepLinkUtilNavigator implements DeepLinkNavigator {
    @NotNull
    public static final DeepLinkUtilNavigator INSTANCE = new DeepLinkUtilNavigator();

    private DeepLinkUtilNavigator() {
    }

    public void startHomeScreenWithDeepLink(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "voucherDeepLink");
        Navigator.Companion.navigate((Context) activity, HomeNavigationActions.INSTANCE.createNavigationModelToVoucherDeepLink(str));
        activity.finish();
    }
}
