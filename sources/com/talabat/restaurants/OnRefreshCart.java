package com.talabat.restaurants;

import androidx.core.content.ContextCompat;
import buisnessmodels.Cart;
import com.talabat.R;
import io.reactivex.functions.Consumer;
import java.util.Locale;

class OnRefreshCart implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        if (restaurantsListScreenRefactor.f61204j != null && restaurantsListScreenRefactor.f61203i != null) {
            Cart instance = Cart.getInstance();
            if (instance.hasItems()) {
                restaurantsListScreenRefactor.f61204j.setVisibility(0);
                restaurantsListScreenRefactor.f61203i.setVisibility(0);
                restaurantsListScreenRefactor.f61204j.setText(String.format(Locale.US, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(instance.getCartCount())}));
                restaurantsListScreenRefactor.f61204j.setTextColor(restaurantsListScreenRefactor.getResources().getColor(R.color.white));
                restaurantsListScreenRefactor.f61203i.setImageResource(R.drawable.ds_bag_filled);
                restaurantsListScreenRefactor.f61203i.setColorFilter(ContextCompat.getColor(restaurantsListScreenRefactor, R.color.ds_primary_100));
                return;
            }
            restaurantsListScreenRefactor.f61204j.setVisibility(8);
            restaurantsListScreenRefactor.f61203i.setVisibility(8);
            restaurantsListScreenRefactor.f61203i.setImageResource(R.drawable.ds_bag);
        }
    }
}
