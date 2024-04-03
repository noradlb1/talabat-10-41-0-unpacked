package library.talabat.mvp.branding;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.InforMapAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.RestGeoAddressResult;
import com.talabat.domain.address.Address;
import datamodels.Area;
import datamodels.City;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalListener;

public interface BrandingListener extends IGlobalListener {
    void checkSelectedAddressDeliverable(Address[] addressArr);

    void gpsToAddressResult(String str, Address address, Area area, City city);

    void grlBranchIdReceived(InforMapAddressResponse inforMapAddressResponse);

    void grlBranchIdfailed();

    void mcdBranchFailed();

    void mcdBranchReceived(McdStoresResponse mcdStoresResponse);

    void onEmptyMenuReceived(String str);

    void onFrachaseLoadingCompleted(Restaurant[] restaurantArr);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted();

    void onMigratedInfoSuccess(Restaurant restaurant);

    void onNotMigratedVendor(int i11);

    void onRequestError();

    void onResCompleted();

    void onResponseError();

    void onServerError();

    void resBasereverseGeocodingResult(RestGeoAddressResult restGeoAddressResult);
}
