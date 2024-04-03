package library.talabat.mvp.restaurantlist;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import library.talabat.mvp.IGlobalListener;

public interface RestaurantListListener extends IGlobalListener {
    void grlBranchIdFailed();

    void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse);

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onOnlyInfoLoadingCompleted();

    void onOnlyMenuLoadingCompleted(MenuItemRM menuItemRM);

    void onRefreshRestaurantListLoaded();

    void onRequestError();

    void onServerError();
}
