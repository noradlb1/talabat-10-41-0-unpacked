package com.talabat.restaurants;

import com.talabat.helpers.CustomDialog;
import io.reactivex.functions.Consumer;

public class PopupLoadingStopper implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        CustomDialog customDialog;
        try {
            if (!restaurantsListScreenRefactor.isDestroyed() && (customDialog = restaurantsListScreenRefactor.E) != null && customDialog.isShowing()) {
                restaurantsListScreenRefactor.E.dismiss();
            }
        } catch (Throwable unused) {
        }
    }
}
