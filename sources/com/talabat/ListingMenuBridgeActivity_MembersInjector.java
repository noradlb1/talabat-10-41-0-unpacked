package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ListingMenuBridgeActivity_MembersInjector implements MembersInjector<ListingMenuBridgeActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public ListingMenuBridgeActivity_MembersInjector(Provider<AppVersionProvider> provider, Provider<IObservabilityManager> provider2, Provider<Navigator> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5) {
        this.appVersionProvider = provider;
        this.observabilityManagerProvider = provider2;
        this.navigatorProvider = provider3;
        this.featureFlagProvider = provider4;
        this.deepLinkNavigatorProvider = provider5;
    }

    public static MembersInjector<ListingMenuBridgeActivity> create(Provider<AppVersionProvider> provider, Provider<IObservabilityManager> provider2, Provider<Navigator> provider3, Provider<ITalabatFeatureFlag> provider4, Provider<DeepLinkNavigator> provider5) {
        return new ListingMenuBridgeActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.ListingMenuBridgeActivity.appVersionProvider")
    public static void injectAppVersionProvider(ListingMenuBridgeActivity listingMenuBridgeActivity, AppVersionProvider appVersionProvider2) {
        listingMenuBridgeActivity.f54276l = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.ListingMenuBridgeActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(ListingMenuBridgeActivity listingMenuBridgeActivity, DeepLinkNavigator deepLinkNavigator) {
        listingMenuBridgeActivity.f54280p = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.ListingMenuBridgeActivity.featureFlag")
    public static void injectFeatureFlag(ListingMenuBridgeActivity listingMenuBridgeActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        listingMenuBridgeActivity.f54279o = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.ListingMenuBridgeActivity.navigator")
    public static void injectNavigator(ListingMenuBridgeActivity listingMenuBridgeActivity, Navigator navigator) {
        listingMenuBridgeActivity.f54278n = navigator;
    }

    @InjectedFieldSignature("com.talabat.ListingMenuBridgeActivity.observabilityManager")
    public static void injectObservabilityManager(ListingMenuBridgeActivity listingMenuBridgeActivity, IObservabilityManager iObservabilityManager) {
        listingMenuBridgeActivity.f54277m = iObservabilityManager;
    }

    public void injectMembers(ListingMenuBridgeActivity listingMenuBridgeActivity) {
        injectAppVersionProvider(listingMenuBridgeActivity, this.appVersionProvider.get());
        injectObservabilityManager(listingMenuBridgeActivity, this.observabilityManagerProvider.get());
        injectNavigator(listingMenuBridgeActivity, this.navigatorProvider.get());
        injectFeatureFlag(listingMenuBridgeActivity, this.featureFlagProvider.get());
        injectDeepLinkNavigator(listingMenuBridgeActivity, this.deepLinkNavigatorProvider.get());
    }
}
