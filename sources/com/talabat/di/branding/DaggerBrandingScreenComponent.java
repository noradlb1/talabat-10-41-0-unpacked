package com.talabat.di.branding;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.BrandingScreen;
import com.talabat.BrandingScreen_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.di.branding.BrandingScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBrandingScreenComponent {

    public static final class BrandingScreenComponentImpl implements BrandingScreenComponent {
        private final BrandingScreenComponentImpl brandingScreenComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;

        private BrandingScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.brandingScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private BrandingScreen injectBrandingScreen(BrandingScreen brandingScreen) {
            BrandingScreen_MembersInjector.injectAppVersionProvider(brandingScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            BrandingScreen_MembersInjector.injectConfigurationLocalRepository(brandingScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            BrandingScreen_MembersInjector.injectLocationConfigurationRepository(brandingScreen, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            BrandingScreen_MembersInjector.injectNavigator(brandingScreen, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            BrandingScreen_MembersInjector.injectFeatureFlag(brandingScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            BrandingScreen_MembersInjector.injectDeepLinkNavigator(brandingScreen, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return brandingScreen;
        }

        public void inject(BrandingScreen brandingScreen) {
            injectBrandingScreen(brandingScreen);
        }
    }

    public static final class Factory implements BrandingScreenComponent.Factory {
        private Factory() {
        }

        public BrandingScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new BrandingScreenComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, navigationCoreLibApi, featureFlagCoreLibApi, deepLinkCoreLibApi);
        }
    }

    private DaggerBrandingScreenComponent() {
    }

    public static BrandingScreenComponent.Factory factory() {
        return new Factory();
    }
}
