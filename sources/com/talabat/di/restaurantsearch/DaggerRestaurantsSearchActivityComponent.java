package com.talabat.di.restaurantsearch;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.RestaurantsSearchActivity;
import com.talabat.RestaurantsSearchActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.restaurantsearch.RestaurantsSearchActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerRestaurantsSearchActivityComponent {

    public static final class Factory implements RestaurantsSearchActivityComponent.Factory {
        private Factory() {
        }

        public RestaurantsSearchActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new RestaurantsSearchActivityComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class RestaurantsSearchActivityComponentImpl implements RestaurantsSearchActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final RestaurantsSearchActivityComponentImpl restaurantsSearchActivityComponentImpl;

        private RestaurantsSearchActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.restaurantsSearchActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private RestaurantsSearchActivity injectRestaurantsSearchActivity(RestaurantsSearchActivity restaurantsSearchActivity) {
            RestaurantsSearchActivity_MembersInjector.injectAppVersionProvider(restaurantsSearchActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return restaurantsSearchActivity;
        }

        public void inject(RestaurantsSearchActivity restaurantsSearchActivity) {
            injectRestaurantsSearchActivity(restaurantsSearchActivity);
        }
    }

    private DaggerRestaurantsSearchActivityComponent() {
    }

    public static RestaurantsSearchActivityComponent.Factory factory() {
        return new Factory();
    }
}
