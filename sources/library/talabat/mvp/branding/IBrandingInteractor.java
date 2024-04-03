package library.talabat.mvp.branding;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.RestGeoReverseCodingRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface IBrandingInteractor extends IGlobalInteractor {
    void checkIfMigratedVendor(int i11);

    void getBranchIdFromBlockorLatLang(McdBranchRequest mcdBranchRequest);

    void getGrlBranchId(InforMapRequest inforMapRequest);

    void getGroceryMenu(String str);

    void getRestaurantFranchase(int i11, int i12);

    void getRestaurantInfoOnly(String str);

    void getRestaurantMenuOnly(String str, String str2);

    void gpsToAddress(double d11, double d12);

    void reverseGeoCodingBasedRestaurant(RestGeoReverseCodingRequest restGeoReverseCodingRequest);
}
