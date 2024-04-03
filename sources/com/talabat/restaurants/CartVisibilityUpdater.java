package com.talabat.restaurants;

import android.app.Activity;
import android.view.View;
import buisnessmodels.Cart;
import io.reactivex.functions.BiConsumer;

class CartVisibilityUpdater implements BiConsumer<Activity, Integer> {
    public void accept(Activity activity, Integer num) {
        View findViewById = activity.findViewById(num.intValue());
        Cart instance = Cart.getInstance();
        if (findViewById != null && instance != null) {
            if (instance.hasItems()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
    }
}
