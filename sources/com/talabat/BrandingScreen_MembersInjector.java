package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BrandingScreen_MembersInjector implements MembersInjector<BrandingScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<Navigator> navigatorProvider;

    public BrandingScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<Navigator> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<DeepLinkNavigator> provider6) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.locationConfigurationRepositoryProvider = provider3;
        this.navigatorProvider = provider4;
        this.featureFlagProvider = provider5;
        this.deepLinkNavigatorProvider = provider6;
    }

    public static MembersInjector<BrandingScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<LocationConfigurationRepository> provider3, Provider<Navigator> provider4, Provider<ITalabatFeatureFlag> provider5, Provider<DeepLinkNavigator> provider6) {
        return new BrandingScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.appVersionProvider")
    public static void injectAppVersionProvider(BrandingScreen brandingScreen, AppVersionProvider appVersionProvider2) {
        brandingScreen.f53672i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(BrandingScreen brandingScreen, ConfigurationLocalRepository configurationLocalRepository) {
        brandingScreen.f53673j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.deepLinkNavigator")
    public static void injectDeepLinkNavigator(BrandingScreen brandingScreen, DeepLinkNavigator deepLinkNavigator) {
        brandingScreen.f53677n = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.featureFlag")
    public static void injectFeatureFlag(BrandingScreen brandingScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        brandingScreen.f53676m = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(BrandingScreen brandingScreen, LocationConfigurationRepository locationConfigurationRepository) {
        brandingScreen.f53674k = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.BrandingScreen.navigator")
    public static void injectNavigator(BrandingScreen brandingScreen, Navigator navigator) {
        brandingScreen.f53675l = navigator;
    }

    public void injectMembers(BrandingScreen brandingScreen) {
        injectAppVersionProvider(brandingScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(brandingScreen, this.configurationLocalRepositoryProvider.get());
        injectLocationConfigurationRepository(brandingScreen, this.locationConfigurationRepositoryProvider.get());
        injectNavigator(brandingScreen, this.navigatorProvider.get());
        injectFeatureFlag(brandingScreen, this.featureFlagProvider.get());
        injectDeepLinkNavigator(brandingScreen, this.deepLinkNavigatorProvider.get());
    }
}
