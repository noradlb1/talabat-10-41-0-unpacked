package com.talabat.talabatlife.ui.vendorList;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VendorsListFragment_MembersInjector implements MembersInjector<VendorsListFragment> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;

    public VendorsListFragment_MembersInjector(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        this.configurationLocalCoreLibApiProvider = provider;
        this.featureFlagRepoProvider = provider2;
        this.helpCenterDeeplinkBuilderProvider = provider3;
        this.deepLinkNavigatorProvider = provider4;
    }

    public static MembersInjector<VendorsListFragment> create(Provider<ConfigurationLocalCoreLibApi> provider, Provider<ITalabatFeatureFlag> provider2, Provider<IHelpCenterDeeplinkBuilder> provider3, Provider<DeepLinkNavigator> provider4) {
        return new VendorsListFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.vendorList.VendorsListFragment.configurationLocalCoreLibApi")
    public static void injectConfigurationLocalCoreLibApi(VendorsListFragment vendorsListFragment, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        vendorsListFragment.configurationLocalCoreLibApi = configurationLocalCoreLibApi;
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.vendorList.VendorsListFragment.deepLinkNavigator")
    public static void injectDeepLinkNavigator(VendorsListFragment vendorsListFragment, DeepLinkNavigator deepLinkNavigator) {
        vendorsListFragment.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.vendorList.VendorsListFragment.featureFlagRepo")
    public static void injectFeatureFlagRepo(VendorsListFragment vendorsListFragment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        vendorsListFragment.featureFlagRepo = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.talabatlife.ui.vendorList.VendorsListFragment.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(VendorsListFragment vendorsListFragment, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        vendorsListFragment.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public void injectMembers(VendorsListFragment vendorsListFragment) {
        injectConfigurationLocalCoreLibApi(vendorsListFragment, this.configurationLocalCoreLibApiProvider.get());
        injectFeatureFlagRepo(vendorsListFragment, this.featureFlagRepoProvider.get());
        injectHelpCenterDeeplinkBuilder(vendorsListFragment, this.helpCenterDeeplinkBuilderProvider.get());
        injectDeepLinkNavigator(vendorsListFragment, this.deepLinkNavigatorProvider.get());
    }
}
