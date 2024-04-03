package library.talabat.mvp.restaurantmenu;

import JsonModels.Response.BinTokenRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import library.talabat.mvp.IGlobalListener;

public interface RestaurantMenuListener extends IGlobalListener {
    void onBinResponseReceived(BinTokenRM binTokenRM, String str);

    void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel);

    void onNoChoiceAvailable();

    void onParallelBinAvailable();
}
