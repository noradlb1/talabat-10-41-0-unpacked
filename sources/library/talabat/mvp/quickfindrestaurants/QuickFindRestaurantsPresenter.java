package library.talabat.mvp.quickfindrestaurants;

import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.QuickRestaurant;
import datamodels.Restaurant;
import java.util.ArrayList;

public class QuickFindRestaurantsPresenter implements IQuickFindRestaurantsPresenter, QuickFindRestaruantsListener {
    private IQuickFindRestaurantsInteractor quickFindRestaurantsInteractor;
    private QuickFindRestaurantsView quickFindRestaurantsView;
    private boolean restaurantLoadingCompleted = false;
    private ArrayList<QuickRestaurant> restaurants;
    private boolean typingStarted = false;

    public QuickFindRestaurantsPresenter(AppVersionProvider appVersionProvider, QuickFindRestaurantsView quickFindRestaurantsView2) {
        this.quickFindRestaurantsInteractor = new QuickFindRestaurantsInteractor(appVersionProvider, this);
        this.quickFindRestaurantsView = quickFindRestaurantsView2;
    }

    public void loadAllRestaurants() {
        this.quickFindRestaurantsInteractor.getAllRestaurantsForCountry(GlobalDataModel.SelectedCountryId);
    }

    public void onDataError() {
        this.quickFindRestaurantsView.onDataError();
    }

    public void onDestroy() {
        this.quickFindRestaurantsView = null;
        IQuickFindRestaurantsInteractor iQuickFindRestaurantsInteractor = this.quickFindRestaurantsInteractor;
        if (iQuickFindRestaurantsInteractor != null) {
            iQuickFindRestaurantsInteractor.unregister();
        }
        this.quickFindRestaurantsInteractor = null;
    }

    public void onNetworkError() {
        this.quickFindRestaurantsView.onNetworkError();
    }

    public void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr) {
        this.quickFindRestaurantsView.onRestaurantDetailsLoaded(restaurant, deliveryAreaArr, cityArr);
    }

    public void onRestaurantListLoaded(ArrayList<QuickRestaurant> arrayList) {
        this.restaurants = arrayList;
        this.restaurantLoadingCompleted = true;
        if (arrayList.size() > 0) {
            this.quickFindRestaurantsView.setQuickFindView(arrayList);
        } else {
            this.quickFindRestaurantsView.setNoRestaurantsView();
        }
        if (this.typingStarted) {
            this.quickFindRestaurantsView.onTypingStarted();
        }
    }

    public void onServerError(VolleyError volleyError) {
        this.quickFindRestaurantsView.onServerError(volleyError);
    }

    public void setRestaurantSelected(QuickRestaurant quickRestaurant) {
        this.quickFindRestaurantsInteractor.getRestaurantDetails(quickRestaurant.f13869id);
    }

    public void typingCancelled() {
    }

    public void typingStarted() {
        if (!this.typingStarted) {
            if (this.restaurantLoadingCompleted) {
                this.quickFindRestaurantsView.onTypingStarted();
            } else {
                this.quickFindRestaurantsView.setLoadingView();
            }
        }
        this.typingStarted = true;
    }
}
