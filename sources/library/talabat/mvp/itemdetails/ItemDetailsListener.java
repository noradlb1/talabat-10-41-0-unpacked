package library.talabat.mvp.itemdetails;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceResponse;
import library.talabat.mvp.IGlobalListener;

public interface ItemDetailsListener extends IGlobalListener {
    void onThirdLevelChoicesReceived(SplitChoiceResponse splitChoiceResponse);
}
