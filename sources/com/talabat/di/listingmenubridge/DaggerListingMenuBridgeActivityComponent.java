package com.talabat.di.listingmenubridge;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.ListingMenuBridgeActivity;
import com.talabat.ListingMenuBridgeActivity_MembersInjector;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.di.listingmenubridge.ListingMenuBridgeActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerListingMenuBridgeActivityComponent {

    public static final class Factory implements ListingMenuBridgeActivityComponent.Factory {
        private Factory() {
        }

        public ListingMenuBridgeActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new ListingMenuBridgeActivityComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, observabilityCoreLibApi, navigationCoreLibApi, featureFlagCoreLibApi, deepLinkCoreLibApi);
        }
    }

    public static final class ListingMenuBridgeActivityComponentImpl implements ListingMenuBridgeActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final ListingMenuBridgeActivityComponentImpl listingMenuBridgeActivityComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private ListingMenuBridgeActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.listingMenuBridgeActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private ListingMenuBridgeActivity injectListingMenuBridgeActivity(ListingMenuBridgeActivity listingMenuBridgeActivity) {
            ListingMenuBridgeActivity_MembersInjector.injectAppVersionProvider(listingMenuBridgeActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            ListingMenuBridgeActivity_MembersInjector.injectObservabilityManager(listingMenuBridgeActivity, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            ListingMenuBridgeActivity_MembersInjector.injectNavigator(listingMenuBridgeActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            ListingMenuBridgeActivity_MembersInjector.injectFeatureFlag(listingMenuBridgeActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            ListingMenuBridgeActivity_MembersInjector.injectDeepLinkNavigator(listingMenuBridgeActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return listingMenuBridgeActivity;
        }

        public void inject(ListingMenuBridgeActivity listingMenuBridgeActivity) {
            injectListingMenuBridgeActivity(listingMenuBridgeActivity);
        }
    }

    private DaggerListingMenuBridgeActivityComponent() {
    }

    public static ListingMenuBridgeActivityComponent.Factory factory() {
        return new Factory();
    }
}
