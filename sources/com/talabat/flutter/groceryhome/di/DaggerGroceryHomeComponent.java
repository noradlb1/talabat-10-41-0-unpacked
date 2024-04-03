package com.talabat.flutter.groceryhome.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandler;
import com.talabat.feature.activecarts.domain.di.ActiveCartsApi;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.flutter.groceryhome.data.repository.GroceryHomeVendorRepositoryImpl;
import com.talabat.flutter.groceryhome.di.GroceryHomeComponent;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCaseImpl;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCaseImpl;
import com.talabat.flutter.groceryhome.domain.usecase.GetUserLocationUseCaseImpl;
import com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity;
import com.talabat.flutter.groceryhome.presentation.activity.GroceryHomeFlutterActivity_MembersInjector;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerFactoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerGroceryHomeComponent {

    public static final class Factory implements GroceryHomeComponent.Factory {
        private Factory() {
        }

        public GroceryHomeComponent create(DarkstoresFeatureApi darkstoresFeatureApi, ActiveCartsApi activeCartsApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NavigationCoreLibApi navigationCoreLibApi) {
            Preconditions.checkNotNull(darkstoresFeatureApi);
            Preconditions.checkNotNull(activeCartsApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            return new GroceryHomeComponentImpl(new GroceryHomeApiModule(), darkstoresFeatureApi, activeCartsApi, featureFlagCoreLibApi, experimentCoreLibApi, dispatcherCoreLibApi, configurationLocalCoreLibApi, navigationCoreLibApi);
        }
    }

    public static final class GroceryHomeComponentImpl implements GroceryHomeComponent {
        private final ActiveCartsApi activeCartsApi;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final DarkstoresFeatureApi darkstoresFeatureApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final GroceryHomeApiModule groceryHomeApiModule;
        private final GroceryHomeComponentImpl groceryHomeComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;

        private GroceryHomeComponentImpl(GroceryHomeApiModule groceryHomeApiModule2, DarkstoresFeatureApi darkstoresFeatureApi2, ActiveCartsApi activeCartsApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2) {
            this.groceryHomeComponentImpl = this;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.groceryHomeApiModule = groceryHomeApiModule2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.activeCartsApi = activeCartsApi2;
            this.darkstoresFeatureApi = darkstoresFeatureApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
        }

        private GetClosestDarkstoreInfoUseCaseImpl getClosestDarkstoreInfoUseCaseImpl() {
            return new GetClosestDarkstoreInfoUseCaseImpl(groceryHomeVendorRepositoryImpl(), getUserLocationUseCaseImpl());
        }

        private GetMigratedVendorInfoUseCaseImpl getMigratedVendorInfoUseCaseImpl() {
            return new GetMigratedVendorInfoUseCaseImpl(groceryHomeVendorRepositoryImpl(), getUserLocationUseCaseImpl());
        }

        private GetUserLocationUseCaseImpl getUserLocationUseCaseImpl() {
            return new GetUserLocationUseCaseImpl((ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private GroceryHomeMethodHandlerFactoryImpl groceryHomeMethodHandlerFactoryImpl() {
            return new GroceryHomeMethodHandlerFactoryImpl((RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()), (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), getClosestDarkstoreInfoUseCaseImpl(), getMigratedVendorInfoUseCaseImpl());
        }

        private GroceryHomeVendorRepositoryImpl groceryHomeVendorRepositoryImpl() {
            return new GroceryHomeVendorRepositoryImpl(GroceryHomeApiModule_ProvideApiHandlerFactory.provideApiHandler(this.groceryHomeApiModule), (RxSchedulersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getRxSchedulersFactory()));
        }

        @CanIgnoreReturnValue
        private GroceryHomeFlutterActivity injectGroceryHomeFlutterActivity(GroceryHomeFlutterActivity groceryHomeFlutterActivity) {
            GroceryHomeFlutterActivity_MembersInjector.injectGroceryHomeMethodHandlerFactory(groceryHomeFlutterActivity, groceryHomeMethodHandlerFactoryImpl());
            GroceryHomeFlutterActivity_MembersInjector.injectActiveCartsMethodCallHandler(groceryHomeFlutterActivity, (ActiveCartsMethodCallHandler) Preconditions.checkNotNullFromComponent(this.activeCartsApi.activeCartsMethodCallHandler()));
            GroceryHomeFlutterActivity_MembersInjector.injectDarkstoresNavigator(groceryHomeFlutterActivity, (DarkstoresNavigator) Preconditions.checkNotNullFromComponent(this.darkstoresFeatureApi.darkstoresNavigator()));
            GroceryHomeFlutterActivity_MembersInjector.injectNavigator(groceryHomeFlutterActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return groceryHomeFlutterActivity;
        }

        public void inject(GroceryHomeFlutterActivity groceryHomeFlutterActivity) {
            injectGroceryHomeFlutterActivity(groceryHomeFlutterActivity);
        }
    }

    private DaggerGroceryHomeComponent() {
    }

    public static GroceryHomeComponent.Factory factory() {
        return new Factory();
    }
}
