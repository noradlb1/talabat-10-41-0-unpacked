package library.talabat.mvp.menu_cart_item;

import android.content.Context;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IMenuCartItemPresenterBase extends IGlobalPresenter {
    void addItem(Restaurant restaurant, CartMenuItem cartMenuItem, MenuCartItemViewBase menuCartItemViewBase);

    void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem, MenuCartItemViewBase menuCartItemViewBase);
}
