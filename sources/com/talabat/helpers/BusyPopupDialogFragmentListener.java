package com.talabat.helpers;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.talabat.busypopup.BusyPopupDialogFragmentCallbacks;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/helpers/BusyPopupDialogFragmentListener;", "Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "onBusyPopupClosed", "", "onShopClicked", "restaurant", "Ldatamodels/Restaurant;", "position", "", "viewAllRestaurantsClicked", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BusyPopupDialogFragmentListener implements BusyPopupDialogFragmentCallbacks {
    @NotNull
    private final FragmentActivity activity;

    public BusyPopupDialogFragmentListener(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    @NotNull
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public void onBusyPopupClosed() {
        AppTracker.onBusyBottomSheetClosed(this.activity, GlobalDataModel.SELECTED.getRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
    }

    public void onShopClicked(@Nullable Restaurant restaurant, int i11) {
        if (restaurant != null) {
            AppTracker.onBusyBottomSheetRecommendedRestaurantClicked(this.activity, GlobalDataModel.SELECTED.getRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            Navigator.Companion.navigate((Context) this.activity, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
        }
        this.activity.finish();
    }

    public void viewAllRestaurantsClicked() {
        String str;
        AppTracker.onBusyBottomSheetViewAllClicked(this.activity, GlobalDataModel.SELECTED.getRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
        Navigator.Companion companion = Navigator.Companion;
        FragmentActivity fragmentActivity = this.activity;
        SdSquadActions.Companion companion2 = SdSquadActions.Companion;
        double d11 = GlobalDataModel.RECENT_LATLONG.latitude;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d11);
        String sb3 = sb2.toString();
        double d12 = GlobalDataModel.RECENT_LATLONG.longitude;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(d12);
        String sb5 = sb4.toString();
        int i11 = GlobalDataModel.SelectedAreaId;
        int i12 = GlobalDataModel.SelectedCityId;
        int i13 = GlobalDataModel.SelectedCountryId;
        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
            str = GlobalDataModel.SelectedAreaName;
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (!TalabatUtils.isNull….SelectedAreaName else \"\"");
        companion.navigate((Context) fragmentActivity, companion2.createNavigatorModelForListingScreen(sb3, sb5, i11, i12, i13, str));
    }
}
