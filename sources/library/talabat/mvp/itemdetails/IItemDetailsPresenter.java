package library.talabat.mvp.itemdetails;

import android.content.Context;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;
import library.talabat.mvp.IGlobalPresenter;

public interface IItemDetailsPresenter extends IGlobalPresenter {
    void addSelectedChoiceSection(ChoiceSection choiceSection);

    void addToCart(Context context);

    void changeRestaurantAndAddItemToCart(Context context, CartMenuItem cartMenuItem);

    void decreaseQuantity();

    void freeItemChoiceSelected();

    void increaseQuantity();

    void setCartMenuItem(CartMenuItem cartMenuItem);

    void setItemDetails();
}
