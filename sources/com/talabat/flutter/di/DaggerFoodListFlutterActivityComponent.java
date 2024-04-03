package com.talabat.flutter.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.flutter.FoodListFlutterActivity;
import com.talabat.flutter.FoodListFlutterActivity_MembersInjector;
import com.talabat.flutter.di.FoodListFlutterActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineScope;

@DaggerGenerated
public final class DaggerFoodListFlutterActivityComponent {

    public static final class Factory implements FoodListFlutterActivityComponent.Factory {
        private Factory() {
        }

        public FoodListFlutterActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, CoroutineScope coroutineScope, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(coroutineScope);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new FoodListFlutterActivityComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, navigationCoreLibApi, observabilityCoreLibApi, deepLinkCoreLibApi, coroutineScope);
        }
    }

    public static final class FoodListFlutterActivityComponentImpl implements FoodListFlutterActivityComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FoodListFlutterActivityComponentImpl foodListFlutterActivityComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;

        private FoodListFlutterActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi2, CoroutineScope coroutineScope) {
            this.foodListFlutterActivityComponentImpl = this;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private FoodListFlutterActivity injectFoodListFlutterActivity(FoodListFlutterActivity foodListFlutterActivity) {
            FoodListFlutterActivity_MembersInjector.injectNavigator(foodListFlutterActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            FoodListFlutterActivity_MembersInjector.injectDeepLinkNavigator(foodListFlutterActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return foodListFlutterActivity;
        }

        public void inject(FoodListFlutterActivity foodListFlutterActivity) {
            injectFoodListFlutterActivity(foodListFlutterActivity);
        }
    }

    private DaggerFoodListFlutterActivityComponent() {
    }

    public static FoodListFlutterActivityComponent.Factory factory() {
        return new Factory();
    }
}
