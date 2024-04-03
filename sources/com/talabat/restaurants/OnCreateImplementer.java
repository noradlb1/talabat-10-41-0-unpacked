package com.talabat.restaurants;

import android.content.Context;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.v1.RestaurantListViewRefactor;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Country;
import io.reactivex.functions.Consumer;

class OnCreateImplementer implements Consumer<RestaurantsListScreenRefactor> {
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public OnCreateImplementer(ITalabatFeatureFlag iTalabatFeatureFlag, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2) {
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        LogManager.debug("[ALOVvl]: OnCreateImplementer #01");
        restaurantsListScreenRefactor.setContentView((int) R.layout.activity_restaurants_list_refactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #02");
        GlobalDataModel.backFromMenuToList = false;
        new KuwaitViewInitializer().accept((Context) restaurantsListScreenRefactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #03");
        new ViewsInitializer().accept(restaurantsListScreenRefactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #04");
        new CuisinesBinder().accept(restaurantsListScreenRefactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #05");
        new RestaurantsFiltersBinder().accept(restaurantsListScreenRefactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #06");
        restaurantsListScreenRefactor.mPresenter = new PresenterInitializer(this.talabatFeatureFlag, this.locationConfigurationRepository).apply((RestaurantListViewRefactor) restaurantsListScreenRefactor, restaurantsListScreenRefactor.I);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #07");
        new ToolbarInitializer().accept(restaurantsListScreenRefactor, restaurantsListScreenRefactor.mPresenter);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #08");
        Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
        if (selectedCountry != null) {
            restaurantsListScreenRefactor.D = selectedCountry.canShowCollectionWidget;
        }
        LogManager.debug("[ALOVvl]: OnCreateImplementer #09");
        new CollectionsViewInitializer().accept(restaurantsListScreenRefactor);
        LogManager.debug("[ALOVvl]: OnCreateImplementer #1");
        restaurantsListScreenRefactor.mPresenter.getRestuarnts();
        LogManager.debug("[ALOVvl]: OnCreateImplementer #10");
    }
}
