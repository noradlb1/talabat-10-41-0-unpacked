package com.talabat.di.menu;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.MenuSearchActivity;
import com.talabat.MenuSearchActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.di.cart.CartUtilityModule_ProvideCartUtilityFactory;
import com.talabat.di.menu.MenuSearchActivityComponent;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import library.talabat.mvp.cart.CartUtility;

@DaggerGenerated
public final class DaggerMenuSearchActivityComponent {

    public static final class Factory implements MenuSearchActivityComponent.Factory {
        private Factory() {
        }

        public MenuSearchActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FoodCartFeatureApi foodCartFeatureApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(foodCartFeatureApi);
            return new MenuSearchActivityComponentImpl(configurationRemoteCoreLibApi, experimentCoreLibApi, foodCartFeatureApi);
        }
    }

    public static final class MenuSearchActivityComponentImpl implements MenuSearchActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FoodCartFeatureApi foodCartFeatureApi;
        private final MenuSearchActivityComponentImpl menuSearchActivityComponentImpl;

        private MenuSearchActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FoodCartFeatureApi foodCartFeatureApi2) {
            this.menuSearchActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.foodCartFeatureApi = foodCartFeatureApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
        }

        private CartUtility cartUtility() {
            return CartUtilityModule_ProvideCartUtilityFactory.provideCartUtility((IFoodCartRepository) Preconditions.checkNotNullFromComponent(this.foodCartFeatureApi.getRepository()));
        }

        @CanIgnoreReturnValue
        private MenuSearchActivity injectMenuSearchActivity(MenuSearchActivity menuSearchActivity) {
            MenuSearchActivity_MembersInjector.injectAppVersionProvider(menuSearchActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            MenuSearchActivity_MembersInjector.injectCartUtility(menuSearchActivity, cartUtility());
            MenuSearchActivity_MembersInjector.injectTalabatExperiment(menuSearchActivity, (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()));
            return menuSearchActivity;
        }

        public void inject(MenuSearchActivity menuSearchActivity) {
            injectMenuSearchActivity(menuSearchActivity);
        }
    }

    private DaggerMenuSearchActivityComponent() {
    }

    public static MenuSearchActivityComponent.Factory factory() {
        return new Factory();
    }
}
