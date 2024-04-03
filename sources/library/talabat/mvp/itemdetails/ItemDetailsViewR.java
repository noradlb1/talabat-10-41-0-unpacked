package library.talabat.mvp.itemdetails;

import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceResponse;
import com.talabat.helpers.Talabat;
import datamodels.CartMenuItem;
import java.util.ArrayList;

public interface ItemDetailsViewR extends Talabat {
    void adjustButtonTransparency();

    String getScreenName();

    String getSpecialRequest();

    void hideChoiceNames();

    void itemAdded(CartMenuItem cartMenuItem);

    void onMandatoryItemsNotSelected(ArrayList<Integer> arrayList);

    void onNoItem();

    void onThirdLevelChoicesReceived(SplitChoiceResponse splitChoiceResponse);

    void priceChanged(float f11);

    void quantityChanged(String str);

    void setChoicesName(String str);

    void setSelectionProgress(int i11);

    void showRestaurantChangePopup(CartMenuItem cartMenuItem);
}
