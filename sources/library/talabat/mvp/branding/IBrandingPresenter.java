package library.talabat.mvp.branding;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import android.location.Location;
import datamodels.DeliveryArea;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IBrandingPresenter extends IGlobalPresenter {
    void ShowMcdBhMenu(int i11);

    void areaButtonClicked();

    void areaSelected();

    void branchButtionClicked(int i11);

    void branchDeslected(boolean z11);

    void branchSelected();

    boolean checkIsFranchiseRes();

    void cityButtonClicked();

    void citySelected();

    int getBranchId(int i11);

    int getBranchId(Restaurant restaurant);

    void getGrlBasedBrach(InforMapRequest inforMapRequest);

    void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest);

    void loadFranchiseRestBasedLocation(int i11);

    void loadMenuScreenFromMap(int i11);

    void locationRecieved(Location location);

    void onDeselectFranchise(boolean z11);

    void onFrnachisebranchSelected();

    void setFrachiseBranchName();

    void setUpViews(DeliveryArea[] deliveryAreaArr);

    void setUplocationView(boolean z11, boolean z12);

    void showGrlMenu(int i11);

    void showMenu();

    void showMenuMf();

    void updateIsAreaDeliverable();
}
