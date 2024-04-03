package com.talabat.restaurants;

import android.app.Activity;
import android.view.View;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v1.IRestaurantsListPresenterRefactor;
import io.reactivex.functions.BiConsumer;

class ToolbarInitializer implements BiConsumer<RestaurantsListScreenRefactor, IRestaurantsListPresenterRefactor> {
    private final ExitNavigation exitNavigation = new ExitNavigation();

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$accept$0(RestaurantsListScreenRefactor restaurantsListScreenRefactor, View view) {
        this.exitNavigation.accept((Activity) restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.finish();
    }

    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor, IRestaurantsListPresenterRefactor iRestaurantsListPresenterRefactor) {
        restaurantsListScreenRefactor.setSupportActionBar(restaurantsListScreenRefactor.f61207m);
        restaurantsListScreenRefactor.getSupportActionBar().setDisplayShowTitleEnabled(false);
        iRestaurantsListPresenterRefactor.onAreaSelected(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName);
        restaurantsListScreenRefactor.f61216v.setVisibility(0);
        restaurantsListScreenRefactor.f61207m.setNavigationOnClickListener(new a(this, restaurantsListScreenRefactor));
        restaurantsListScreenRefactor.f61207m.setNavigationIcon((int) R.drawable.ds_arrow_back);
    }
}
