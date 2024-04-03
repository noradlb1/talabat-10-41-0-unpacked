package library.talabat.mvp.restaurantlistrefactor;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import library.talabat.mvp.IGlobalListener;

public interface MenuApiListener extends IGlobalListener {
    void grlBranchIdFailed();

    void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse);

    void logNetworkError(String str);

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onRequestError();

    void onServerError();
}
