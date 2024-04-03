package library.talabat.mvp.itemdetails;

import android.content.Context;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface IItemDetailsPresenterR extends IGlobalPresenter {
    ArrayList<ChoiceSection> addSectionToTheList(int i11, int i12);

    void addSelectedChoiceSection(ChoiceSection choiceSection);

    void addToCart(Context context);

    void callThirdLevelChoice(String str);

    void changeRestaurantAndAddItem(Context context, CartMenuItem cartMenuItem);

    void decreaseQuantity();

    boolean disableSpecialRequest(Restaurant restaurant);

    boolean enableAddToCartButton();

    ArrayList<ChoiceSection> getBaseAdapterList();

    ArrayList<ChoiceSection> getChoiceSections();

    String getItemDescription();

    String getItemImageUrl();

    String getItemImageUrlWithSize(int i11);

    String getItemName();

    String getItemOldPrice();

    String getItemPrice();

    String getItemStartPrice();

    ChoiceSection getSelectedChoice(int i11);

    boolean hasChoiceSections();

    void increaseQuantity();

    boolean isChoiceItemSelectedOrNot(int i11, int i12);

    boolean isChoiceSelected();

    boolean isItemHasDiscount();

    boolean isItemHasStartPrice();

    void itemSelectionChanged(ChoiceItem choiceItem, boolean z11);

    void itemSelectionChanged(ArrayList<ChoiceItem> arrayList, boolean z11);

    void onToolBarVisible(boolean z11);
}
