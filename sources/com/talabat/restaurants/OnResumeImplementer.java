package com.talabat.restaurants;

import android.app.Activity;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.functions.Consumer;

class OnResumeImplementer implements Consumer<RestaurantsListScreenRefactor> {
    private final CartVisibilityUpdater cartVisibilityUpdater = new CartVisibilityUpdater();

    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        restaurantsListScreenRefactor.C.refreshFloatingButtonVisibility();
        if (GlobalDataModel.backFromMenuToList) {
            GlobalDataModel.backFromMenuToList = false;
            restaurantsListScreenRefactor.GaOnRestaurantListUpdated("");
        }
        this.cartVisibilityUpdater.accept((Activity) restaurantsListScreenRefactor, Integer.valueOf(R.id.frameLayout_cartContainer));
        if (GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea) {
            GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = false;
            restaurantsListScreenRefactor.mPresenter.onAreaSelected(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName);
            LogManager.debug("[ALOVvl]: OnResumeImplementer #1");
            restaurantsListScreenRefactor.mPresenter.getRestuarnts();
        }
    }
}
