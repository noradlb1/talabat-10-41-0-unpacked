package com.talabat.di.restaurant;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.QuickFindRestaurantScreen;
import com.talabat.QuickFindRestaurantScreen_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.di.restaurant.QuickFindRestaurantScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerQuickFindRestaurantScreenComponent {

    public static final class Factory implements QuickFindRestaurantScreenComponent.Factory {
        private Factory() {
        }

        public QuickFindRestaurantScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new QuickFindRestaurantScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class QuickFindRestaurantScreenComponentImpl implements QuickFindRestaurantScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final QuickFindRestaurantScreenComponentImpl quickFindRestaurantScreenComponentImpl;

        private QuickFindRestaurantScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.quickFindRestaurantScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private QuickFindRestaurantScreen injectQuickFindRestaurantScreen(QuickFindRestaurantScreen quickFindRestaurantScreen) {
            QuickFindRestaurantScreen_MembersInjector.injectAppVersionProvider(quickFindRestaurantScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            return quickFindRestaurantScreen;
        }

        public void inject(QuickFindRestaurantScreen quickFindRestaurantScreen) {
            injectQuickFindRestaurantScreen(quickFindRestaurantScreen);
        }
    }

    private DaggerQuickFindRestaurantScreenComponent() {
    }

    public static QuickFindRestaurantScreenComponent.Factory factory() {
        return new Factory();
    }
}
