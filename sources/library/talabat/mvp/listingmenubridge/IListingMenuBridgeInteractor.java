package library.talabat.mvp.listingmenubridge;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface IListingMenuBridgeInteractor extends IGlobalInteractor {
    void getBranchIdFromBlockorLatLang(McdBranchRequest mcdBranchRequest);

    void getBranchIdFromGrl(InforMapRequest inforMapRequest);

    void getDarkstoreInfo();

    void getGroceryMenu(int i11);

    void getMigratedVendorInfo(int i11);

    void getRestaurantMenu(int i11, String str);
}
