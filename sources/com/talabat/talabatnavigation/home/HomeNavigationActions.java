package com.talabat.talabatnavigation.home;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.pickup.PickupNavigatorActions;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatnavigation/home/HomeNavigationActions;", "", "()V", "VOUCHER_DEEPLINK_BRAND_ID", "", "VOUCHER_DEEPLINK_CODE", "VOUCHER_DEEPLINK_MEDIA_SRC", "VOUCHER_DEEP_LINK", "createNavigationModelToPickupScreen", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "createNavigationModelToVoucherDeepLink", "voucherDeepLink", "createNavigationModelToVoucherDetailsBottomSheet", "code", "src", "brandId", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeNavigationActions {
    @NotNull
    public static final HomeNavigationActions INSTANCE = new HomeNavigationActions();
    @NotNull
    public static final String VOUCHER_DEEPLINK_BRAND_ID = "VOUCHER_DEEPLINK_BRAND_ID";
    @NotNull
    public static final String VOUCHER_DEEPLINK_CODE = "VOUCHER_DEEPLINK_CODE";
    @NotNull
    public static final String VOUCHER_DEEPLINK_MEDIA_SRC = "VOUCHER_DEEPLINK_MEDIA_SRC";
    @NotNull
    public static final String VOUCHER_DEEP_LINK = "VOUCHER_DEEP_LINK";

    private HomeNavigationActions() {
    }

    public static /* synthetic */ NavigatorModel createNavigationModelToVoucherDetailsBottomSheet$default(HomeNavigationActions homeNavigationActions, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        return homeNavigationActions.createNavigationModelToVoucherDetailsBottomSheet(str, str2, str3);
    }

    @NotNull
    public final NavigatorModel createNavigationModelToPickupScreen() {
        return new NavigatorModel(PickupNavigatorActions.ACTION_NEW_PICKUP_MODULE, new Bundle(), (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final NavigatorModel createNavigationModelToVoucherDeepLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "voucherDeepLink");
        Bundle bundle = new Bundle();
        bundle.putString(VOUCHER_DEEP_LINK, str);
        return new NavigatorModel("talabat.action.homeScreen", bundle, HomeNavigationActions$createNavigationModelToVoucherDeepLink$2.INSTANCE);
    }

    @NotNull
    public final NavigatorModel createNavigationModelToVoucherDetailsBottomSheet(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Bundle bundle = new Bundle();
        bundle.putString("VOUCHER_DEEPLINK_CODE", str);
        if (str2 != null) {
            bundle.putString("VOUCHER_DEEPLINK_MEDIA_SRC", str2);
        }
        if (str3 != null) {
            bundle.putString("VOUCHER_DEEPLINK_BRAND_ID", str3);
        }
        return new NavigatorModel("talabat.action.homeScreen", bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
    }
}
