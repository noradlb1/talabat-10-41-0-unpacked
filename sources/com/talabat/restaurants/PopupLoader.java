package com.talabat.restaurants;

import com.talabat.helpers.CustomDialog;
import io.reactivex.functions.Consumer;

public class PopupLoader implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        try {
            if (!restaurantsListScreenRefactor.isDestroyed()) {
                if (restaurantsListScreenRefactor.E == null && !restaurantsListScreenRefactor.isFinishing()) {
                    restaurantsListScreenRefactor.E = new CustomDialog(restaurantsListScreenRefactor);
                }
                restaurantsListScreenRefactor.E.show();
            }
        } catch (Exception unused) {
        }
    }
}
