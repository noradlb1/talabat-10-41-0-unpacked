package library.talabat.mvp.offerslist;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.Offers;
import datamodels.OffersDisplayModel;
import datamodels.OffersItem;
import datamodels.Restaurant;
import java.util.ArrayList;

public class OffersPresenter implements IOffersPresenter, OffersListener {
    private IOffersInteractor interactor;
    private ArrayList<OffersDisplayModel> offersArrayList = new ArrayList<>();
    private OffersDisplayModel offersDisplayModel;
    private OffersView view;

    public OffersPresenter(AppVersionProvider appVersionProvider, OffersView offersView) {
        this.view = offersView;
        this.interactor = new OffersInteractor(appVersionProvider, this);
    }

    public void loadOffersList() {
        this.interactor.loadOffersforCountry(GlobalDataModel.SelectedCountryId);
    }

    public void onDataError() {
        this.view.onDataError();
    }

    public void onDestroy() {
        this.view = null;
        IOffersInteractor iOffersInteractor = this.interactor;
        if (iOffersInteractor != null) {
            iOffersInteractor.unregister();
        }
        this.interactor = null;
    }

    public void onNetworkError() {
        this.view.onNetworkError();
    }

    public void onOffersListLoaded(Offers[] offersArr) {
        this.offersArrayList = new ArrayList<>();
        for (Offers offers : offersArr) {
            for (OffersItem offersItem : offers.offersItem) {
                OffersDisplayModel offersDisplayModel2 = new OffersDisplayModel();
                this.offersDisplayModel = offersDisplayModel2;
                offersDisplayModel2.restaurantId = offers.restaurantId;
                offersDisplayModel2.restaurantName = offers.restaurantName;
                offersDisplayModel2.branchName = offers.branchName;
                offersDisplayModel2.branchId = offers.branchId;
                offersDisplayModel2.restaurantImage = offers.getRestaurantLogo();
                OffersDisplayModel offersDisplayModel3 = this.offersDisplayModel;
                offersDisplayModel3.offerTitle = offersItem.itemName;
                offersDisplayModel3.promotionType = offersItem.promotionType;
                offersDisplayModel3.description = offersItem.description;
                offersDisplayModel3.offerImage = offersItem.thumbnail;
                offersDisplayModel3.price = offersItem.price;
                this.offersArrayList.add(offersDisplayModel3);
            }
        }
        this.view.onOffersLoaded(this.offersArrayList);
    }

    public void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr) {
        this.view.onRestaurantDetailsLoaded(restaurant, deliveryAreaArr, cityArr);
    }

    public void onServerError(VolleyError volleyError) {
        this.view.onServerError(volleyError);
    }

    public void setOffersSelected(int i11) {
        this.interactor.getRestaurantDetails(i11);
    }
}
