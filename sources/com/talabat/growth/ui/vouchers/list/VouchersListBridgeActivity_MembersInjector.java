package com.talabat.growth.ui.vouchers.list;

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
public final class VouchersListBridgeActivity_MembersInjector implements MembersInjector<VouchersListBridgeActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public VouchersListBridgeActivity_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<Navigator> provider2, Provider<DeepLinkNavigator> provider3, Provider<IObservabilityManager> provider4) {
        this.talabatFeatureFlagProvider = provider;
        this.navigatorProvider = provider2;
        this.deepLinkNavigatorProvider = provider3;
        this.observabilityManagerProvider = provider4;
    }

    public static MembersInjector<VouchersListBridgeActivity> create(Provider<ITalabatFeatureFlag> provider, Provider<Navigator> provider2, Provider<DeepLinkNavigator> provider3, Provider<IObservabilityManager> provider4) {
        return new VouchersListBridgeActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(VouchersListBridgeActivity vouchersListBridgeActivity, DeepLinkNavigator deepLinkNavigator) {
        vouchersListBridgeActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity.navigator")
    public static void injectNavigator(VouchersListBridgeActivity vouchersListBridgeActivity, Navigator navigator) {
        vouchersListBridgeActivity.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity.observabilityManager")
    public static void injectObservabilityManager(VouchersListBridgeActivity vouchersListBridgeActivity, IObservabilityManager iObservabilityManager) {
        vouchersListBridgeActivity.observabilityManager = iObservabilityManager;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(VouchersListBridgeActivity vouchersListBridgeActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        vouchersListBridgeActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(VouchersListBridgeActivity vouchersListBridgeActivity) {
        injectTalabatFeatureFlag(vouchersListBridgeActivity, this.talabatFeatureFlagProvider.get());
        injectNavigator(vouchersListBridgeActivity, this.navigatorProvider.get());
        injectDeepLinkNavigator(vouchersListBridgeActivity, this.deepLinkNavigatorProvider.get());
        injectObservabilityManager(vouchersListBridgeActivity, this.observabilityManagerProvider.get());
    }
}
