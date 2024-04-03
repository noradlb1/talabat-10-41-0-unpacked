package library.talabat.mvp.restaurantssearch;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.ItemSearchResponse;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurantssearch.RestaurantsSearchPresenter;

public interface IRestaurantsSearchPresenter extends IGlobalPresenter {
    void cancelSearch();

    void clearRecentSearch();

    void getBranchIdFromGrl(InforMapRequest inforMapRequest);

    int getDishesHeaderPosition();

    void getItemPosition(ItemSearchResponse itemSearchResponse);

    int getItemsCount();

    void getMcdBranchIdFromBlockorLatLng(McdBranchRequest mcdBranchRequest);

    void getRecentSearch();

    int getRestaurantsCount();

    void hideAllViews();

    void mcdMapDecisionMakerHandler(Restaurant restaurant);

    void performInstanceSearch(String str);

    void performSuggestionsSearch(String str, String str2);

    void saveSearchTerm(String str);

    void searchBySearchTerm(String str, String str2, boolean z11);

    void setBranchIdForSelectedRestaurant(int i11);

    void setFrom(RestaurantsSearchPresenter.FromScreen fromScreen);

    void setSelectedRestaurant(Restaurant restaurant);

    void userContinuing();
}
