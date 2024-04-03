package library.talabat.choiceLoader;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import library.talabat.mvp.IGlobalListener;

public interface ChoiceLoaderListener extends IGlobalListener {
    void onChoiceReceived(SplitChoiceItemModel[] splitChoiceItemModelArr);

    void onNoChoiceAvailable();
}
