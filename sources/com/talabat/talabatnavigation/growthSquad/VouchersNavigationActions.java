package com.talabat.talabatnavigation.growthSquad;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatnavigation/growthSquad/VouchersNavigationActions;", "", "()V", "IS_OPEN_BOTTOM_SHEET", "", "OPEN_VOUCHERS_LIST", "VOUCHER_DEEPLINK_BRAND_ID", "VOUCHER_DEEPLINK_CODE", "VOUCHER_DEEPLINK_MEDIA_SRC", "VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON", "navigationModel", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "code", "src", "brandId", "disableOpeningHomeForBackButton", "", "isOpenBottomSheet", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersNavigationActions {
    @NotNull
    public static final VouchersNavigationActions INSTANCE = new VouchersNavigationActions();
    @NotNull
    public static final String IS_OPEN_BOTTOM_SHEET = "IS_OPEN_BOTTOM_SHEET";
    @NotNull
    public static final String OPEN_VOUCHERS_LIST = "talabat.action.Growth.vouchers.list.bridge";
    @NotNull
    public static final String VOUCHER_DEEPLINK_BRAND_ID = "VOUCHER_DEEPLINK_BRAND_ID";
    @NotNull
    public static final String VOUCHER_DEEPLINK_CODE = "VOUCHER_DEEPLINK_CODE";
    @NotNull
    public static final String VOUCHER_DEEPLINK_MEDIA_SRC = "VOUCHER_DEEPLINK_MEDIA_SRC";
    @NotNull
    public static final String VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON = "VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON";

    private VouchersNavigationActions() {
    }

    @JvmStatic
    @NotNull
    public static final NavigatorModel navigationModel(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        Bundle bundle = new Bundle();
        boolean z15 = false;
        if (str == null || !(!StringsKt__StringsJVMKt.isBlank(str))) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            bundle.putString("VOUCHER_DEEPLINK_CODE", str);
        }
        if (str2 == null || !(!StringsKt__StringsJVMKt.isBlank(str2))) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z14) {
            bundle.putString("VOUCHER_DEEPLINK_MEDIA_SRC", str2);
        }
        if (str3 != null && (!StringsKt__StringsJVMKt.isBlank(str3))) {
            z15 = true;
        }
        if (z15) {
            bundle.putString("VOUCHER_DEEPLINK_BRAND_ID", str3);
        }
        bundle.putBoolean(VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON, z11);
        if (z12) {
            bundle.putBoolean(IS_OPEN_BOTTOM_SHEET, z12);
        }
        return new NavigatorModel(OPEN_VOUCHERS_LIST, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NavigatorModel navigationModel$default(String str, String str2, String str3, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            str3 = "";
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        if ((i11 & 16) != 0) {
            z12 = false;
        }
        return navigationModel(str, str2, str3, z11, z12);
    }
}
