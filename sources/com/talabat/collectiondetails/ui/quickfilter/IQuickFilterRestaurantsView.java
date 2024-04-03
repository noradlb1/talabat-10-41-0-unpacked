package com.talabat.collectiondetails.ui.quickfilter;

import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0017\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;", "", "darkstoreFailure", "", "darkstoreSuccess", "darkStoreInfo", "Ldatamodels/Restaurant;", "hideDailyTalabatLoading", "hideVendorsLoading", "navigateToRestaurantsSearchActivity", "navigateToVendorSeachActivity", "cuisineId", "", "(Ljava/lang/Integer;)V", "setIsSearchEnabled", "enabled", "", "showDailyTalabatLoading", "showNoRestaurantsFound", "showRestaurantsFound", "showVendorsLoading", "termsResponseSuccess", "terms", "", "updateRestaurantList", "restaurantListModel", "Ldatamodels/RestaurantListModel;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IQuickFilterRestaurantsView {
    void darkstoreFailure();

    void darkstoreSuccess(@Nullable Restaurant restaurant);

    void hideDailyTalabatLoading();

    void hideVendorsLoading();

    void navigateToRestaurantsSearchActivity();

    void navigateToVendorSeachActivity(@Nullable Integer num);

    void setIsSearchEnabled(boolean z11);

    void showDailyTalabatLoading();

    void showNoRestaurantsFound();

    void showRestaurantsFound();

    void showVendorsLoading();

    void termsResponseSuccess(@Nullable String str);

    void updateRestaurantList(@Nullable RestaurantListModel restaurantListModel);
}
