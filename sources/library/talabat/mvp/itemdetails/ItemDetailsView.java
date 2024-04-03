package library.talabat.mvp.itemdetails;

import android.content.Context;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;

public interface ItemDetailsView {
    Context getContext();

    String getScreenName();

    String getSpecialRequest();

    void itemAdded(CartMenuItem cartMenuItem);

    void setChoiceLayout(ChoiceSection[] choiceSectionArr);

    void setDescription(String str);

    void setImage(boolean z11, String str);

    void setPrice(String str);

    void setQuantity(String str);

    void setStrikeoutPrice(String str);

    void setTitle(String str);

    void showChoiceNotSelectedPopup(int[] iArr);

    void showRestaurantChangePopup(CartMenuItem cartMenuItem);
}
