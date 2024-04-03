package com.talabat.talabatnavigation.pickup;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatnavigation/pickup/PickupNavigatorActions;", "", "()V", "ACTION_FLUTTER_SEARCH_ACTIVITY", "", "ACTION_FLUTTER_VENDOR_MENU", "ACTION_NEW_PICKUP_MODULE", "BRANCH_ID_KEY", "CUISINES_ID", "DELIVERY_MODE_KEY", "IS_EXISTING_PICKUP_CUSTOMER", "PICKUP_DEFAULT_VERTICAL_ID", "", "PICKUP_DEFAULT_VERTICAL_NAME", "SHOP_CLICK_KEY", "VERTICAL_ID", "VERTICAL_IDS", "VERTICAL_NAME", "createNavigatorForHomeScreen", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "createNavigatorForSearchScreen", "cuisineId", "isExistingPickupCustomer", "", "createNavigatorForVendorMenuScreen", "branchId", "shopClickOrigin", "deliveryMode", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupNavigatorActions {
    @NotNull
    public static final String ACTION_FLUTTER_SEARCH_ACTIVITY = "com.talabat.VendorListSearchFlutterActivity";
    @NotNull
    public static final String ACTION_FLUTTER_VENDOR_MENU = "talabat.action.flutter.vendorMenu";
    @NotNull
    public static final String ACTION_NEW_PICKUP_MODULE = "com.talabat.feature.pickup.presentation.PickupActivity";
    @NotNull
    private static final String BRANCH_ID_KEY = "branchId";
    @NotNull
    private static final String CUISINES_ID = "cuisineId";
    @NotNull
    private static final String DELIVERY_MODE_KEY = "deliveryMode";
    @NotNull
    public static final PickupNavigatorActions INSTANCE = new PickupNavigatorActions();
    @NotNull
    private static final String IS_EXISTING_PICKUP_CUSTOMER = "isExistingPickupCustomers";
    private static final int PICKUP_DEFAULT_VERTICAL_ID = 11;
    @NotNull
    private static final String PICKUP_DEFAULT_VERTICAL_NAME = "pickup";
    @NotNull
    private static final String SHOP_CLICK_KEY = "shopClickOrigin";
    @NotNull
    private static final String VERTICAL_ID = "verticalId";
    @NotNull
    private static final String VERTICAL_IDS = "verticalIds";
    @NotNull
    private static final String VERTICAL_NAME = "verticalName";

    private PickupNavigatorActions() {
    }

    @NotNull
    public final NavigatorModel createNavigatorForHomeScreen() {
        return new NavigatorModel("talabat.action.homeScreen", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final NavigatorModel createNavigatorForSearchScreen(int i11, boolean z11) {
        return new NavigatorModel("com.talabat.VendorListSearchFlutterActivity", (Bundle) null, new PickupNavigatorActions$createNavigatorForSearchScreen$1(i11, z11), 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final NavigatorModel createNavigatorForVendorMenuScreen(int i11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "shopClickOrigin");
        Intrinsics.checkNotNullParameter(str2, "deliveryMode");
        return new NavigatorModel("talabat.action.flutter.vendorMenu", (Bundle) null, new PickupNavigatorActions$createNavigatorForVendorMenuScreen$1(i11, str, str2), 2, (DefaultConstructorMarker) null);
    }
}
