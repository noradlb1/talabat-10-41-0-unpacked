package library.talabat.mvp.listingmenubridge;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IListingMenuBridgePresenter extends IGlobalPresenter {
    void getBranchIdFromGrl(InforMapRequest inforMapRequest);

    void getDarkstoreInfo();

    void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest);

    void getMigratedVendorInfo(int i11);

    void mcdMapDecisionMakerHandler(Restaurant restaurant);

    void setBranchIdForSelectedRestaurant(int i11);

    void setSelectedRestaurant(Restaurant restaurant);

    void userContinuing();
}
