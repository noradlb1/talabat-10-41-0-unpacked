package com.talabat.restaurants;

import android.content.Intent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v1.IRestaurantsListPresenterRefactor;
import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.functions.BiConsumer;

class OnActivityResultImplementer implements BiConsumer<ActivityResult, IRestaurantsListPresenterRefactor> {
    public void accept(ActivityResult activityResult, IRestaurantsListPresenterRefactor iRestaurantsListPresenterRefactor) {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = activityResult.f61194a;
        int i11 = activityResult.f61195b;
        int i12 = activityResult.f61196c;
        Intent intent = activityResult.f61197d;
        if (i11 == 30) {
            if (i12 == -1) {
                restaurantsListScreenRefactor.GaOnCuisineChanged(intent.getStringExtra(GlobalConstants.ExtraNames.SLUG_NAME));
                restaurantsListScreenRefactor.A.updateVendorList();
                restaurantsListScreenRefactor.GaOnRestaurantListUpdated("category_applied");
            }
        } else if (i11 == 600) {
            if (i12 == -1) {
                LogManager.debug("[ALOVvl]: OnActivityResultImplementer #1");
                iRestaurantsListPresenterRefactor.getRestuarnts();
            }
        } else if ((i11 == 43 || i11 == 44) && i12 == -1) {
            iRestaurantsListPresenterRefactor.clearFilterEngine();
            restaurantsListScreenRefactor.C.hideGemDialogAndFloatingButton();
            restaurantsListScreenRefactor.updateDarkStores();
            iRestaurantsListPresenterRefactor.onAreaSelected(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName);
            LogManager.debug("[ALOVvl]: OnActivityResultImplementer #2");
            iRestaurantsListPresenterRefactor.getRestuarnts();
        }
    }
}
