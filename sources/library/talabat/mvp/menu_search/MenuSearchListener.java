package library.talabat.mvp.menu_search;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import library.talabat.mvp.IGlobalListener;

public interface MenuSearchListener extends IGlobalListener {
    void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel);

    void onNoChoiceAvailable();

    void onSearchApiCalled(String str);
}
