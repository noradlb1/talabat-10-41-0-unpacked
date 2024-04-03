package library.talabat.mvp.RestaurantFranchise;

import JsonModels.Request.FranchiseRestRequest;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;

public class FranchisePresenter implements IFranchisePresenter, FranchiseListener {
    public FranchiseView franchiseView;
    private IFranchiseInteractor interactor = new FracnhiseInteractor(this);

    public FranchisePresenter(FranchiseView franchiseView2) {
        this.franchiseView = franchiseView2;
    }

    public void franchiseRestaurantReceived(Restaurant[] restaurantArr) {
        if (restaurantArr.length > 0) {
            this.franchiseView.stopLodingPopup();
            GlobalDataModel.JSON.franchiseRestaurants = restaurantArr;
            this.franchiseView.loadFranchiseList();
            return;
        }
        this.franchiseView.stopLodingPopup();
    }

    public void loadFranchiseRestaurants(int i11, String str) {
        LatLng latLng = new LatLng(0.0d, 0.0d);
        if (!TalabatUtils.isNullOrEmpty(str)) {
            String[] split = str.split(",");
            latLng = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        }
        this.interactor.getFranchiseBasedLoc(new FranchiseRestRequest(GlobalDataModel.SelectedCountryId, latLng.longitude, latLng.latitude, i11));
    }

    public void onDataError() {
        this.franchiseView.onDataError();
    }

    public void onDestroy() {
        this.franchiseView = null;
        IFranchiseInteractor iFranchiseInteractor = this.interactor;
        if (iFranchiseInteractor != null) {
            iFranchiseInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onNetworkError() {
        this.franchiseView.onNetworkError();
    }

    public void onResponseError() {
        this.franchiseView.stopLodingPopup();
    }

    public void onServerError(VolleyError volleyError) {
        this.franchiseView.onServerError(volleyError);
    }
}
