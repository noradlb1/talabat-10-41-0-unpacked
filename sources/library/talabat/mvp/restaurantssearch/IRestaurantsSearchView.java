package library.talabat.mvp.restaurantssearch;

import JsonModels.MenuItemsResponseModel;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import datamodels.Restaurant;
import datamodels.RestaurantsSearchWrapperClass;
import java.util.ArrayList;
import java.util.List;

public interface IRestaurantsSearchView extends Talabat {
    void addDishTab();

    void addRestaurantTab();

    void hideDishesSuggestionSearch();

    void hideInstanceSearch();

    void hideList();

    void hideLoading();

    void hideNoResult();

    void hideRecentSearch();

    void hideRestaurantsSuggestionSearch();

    void hideSuggestionSearch();

    void hideTrending();

    void initTabLayout();

    void mcdServerError();

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onRequestError();

    void onServerError();

    void selectDishTab();

    void showAlert(int i11, String str, boolean z11);

    void showDishesSuggestionsSearch(ArrayList<RestaurantsSearchWrapperClass> arrayList, String str, boolean z11);

    void showInforMap(int i11, String str);

    void showInstanceResult(List<Restaurant> list, String str);

    void showList(ArrayList<RestaurantsSearchWrapperClass> arrayList, String str);

    void showLoading();

    void showMcdGoogleMap(int i11, String str, Address address, int i12);

    void showMenuWithGlrID(String str, Restaurant restaurant, int i11);

    void showMenuWithMcdStores(Restaurant restaurant, int i11, Address address);

    void showNoResult();

    void showRecentSearch(ArrayList<String> arrayList);

    void showRestaurantsSuggestionsSearch(String str, ArrayList<Restaurant> arrayList, boolean z11);

    void showSuggestionSearch();

    void showTrending(ArrayList<String> arrayList);

    void startLoadingPopup();
}
