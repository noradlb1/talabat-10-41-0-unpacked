package library.talabat.mvp.listingmenubridge;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalListener;

public interface ListingMenuBridgeListener extends IGlobalListener {
    void grlBranchIdFailed();

    void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse);

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onDarkStoresEntrySuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    void onDarkstoreError();

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMigratedVendorInfoReceived(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    void onRequestError();

    void onServerError();
}
