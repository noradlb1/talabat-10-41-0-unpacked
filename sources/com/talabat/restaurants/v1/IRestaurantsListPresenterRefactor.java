package com.talabat.restaurants.v1;

import com.talabat.restaurants.v2.domain.exceptions.CollectionCategoryException;
import datamodels.QuickFilter;
import io.reactivex.Single;
import java.util.HashMap;
import library.talabat.mvp.IGlobalPresenter;
import tracking.ShopClickedEvent;

public interface IRestaurantsListPresenterRefactor extends IGlobalPresenter {
    boolean canShowCollectionsTitle();

    void clearFilterEngine();

    String getChannelIndex();

    int getRestaurantIdFromDeepLink(String str);

    void getRestuarnts();

    Single<HashMap<String, String>> getSwimlanesGa();

    String getTMartCategoryId(String str) throws CollectionCategoryException;

    String getTMartScreenTitle(String str) throws CollectionCategoryException;

    int getTMartScreenType(String str) throws CollectionCategoryException;

    String getVerticalTypeForAnalytics(String str);

    boolean isCategoryCollection(QuickFilter quickFilter);

    void onAreaSelected(int i11, String str);

    void selectedAreaDropDown();

    void sendCollectionClickEvent(QuickFilter quickFilter);

    void sendGaOnRestaurantListLoaded(String str, Boolean bool, String str2, String str3, ShopClickedEvent.EventOriginSource eventOriginSource);

    boolean showTmartBanner(int i11);
}
