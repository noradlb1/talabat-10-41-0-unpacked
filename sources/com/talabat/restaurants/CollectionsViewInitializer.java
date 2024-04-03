package com.talabat.restaurants;

import com.google.android.material.appbar.AppBarLayout;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import io.reactivex.functions.Consumer;

class CollectionsViewInitializer implements Consumer<RestaurantsListScreenRefactor> {
    private final CollectionsRecyclerViewInitializer collectionsRecyclerViewInitializer = new CollectionsRecyclerViewInitializer();

    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) restaurantsListScreenRefactor.f61213s.getLayoutParams();
        layoutParams.setScrollFlags(1);
        restaurantsListScreenRefactor.f61213s.setLayoutParams(layoutParams);
        if (!restaurantsListScreenRefactor.D) {
            return;
        }
        if (restaurantsListScreenRefactor.I == 0 || TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.GROCERY_COLLECTION, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.collectionsRecyclerViewInitializer.accept(restaurantsListScreenRefactor);
        }
    }
}
