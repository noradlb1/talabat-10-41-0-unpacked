package com.talabat.growth.ui.vouchers.list.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity;
import com.talabat.growth.ui.vouchers.list.VouchersListBridgeActivity_MembersInjector;
import com.talabat.growth.ui.vouchers.list.di.VouchersListBridgeActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVouchersListBridgeActivityComponent {

    public static final class Factory implements VouchersListBridgeActivityComponent.Factory {
        private Factory() {
        }

        public VouchersListBridgeActivityComponent create(FeatureFlagCoreLibApi featureFlagCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new VouchersListBridgeActivityComponentImpl(featureFlagCoreLibApi, navigationCoreLibApi, deepLinkCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class VouchersListBridgeActivityComponentImpl implements VouchersListBridgeActivityComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final VouchersListBridgeActivityComponentImpl vouchersListBridgeActivityComponentImpl;

        private VouchersListBridgeActivityComponentImpl(FeatureFlagCoreLibApi featureFlagCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.vouchersListBridgeActivityComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private VouchersListBridgeActivity injectVouchersListBridgeActivity(VouchersListBridgeActivity vouchersListBridgeActivity) {
            VouchersListBridgeActivity_MembersInjector.injectTalabatFeatureFlag(vouchersListBridgeActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            VouchersListBridgeActivity_MembersInjector.injectNavigator(vouchersListBridgeActivity, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            VouchersListBridgeActivity_MembersInjector.injectDeepLinkNavigator(vouchersListBridgeActivity, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            VouchersListBridgeActivity_MembersInjector.injectObservabilityManager(vouchersListBridgeActivity, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return vouchersListBridgeActivity;
        }

        public void inject(VouchersListBridgeActivity vouchersListBridgeActivity) {
            injectVouchersListBridgeActivity(vouchersListBridgeActivity);
        }
    }

    private DaggerVouchersListBridgeActivityComponent() {
    }

    public static VouchersListBridgeActivityComponent.Factory factory() {
        return new Factory();
    }
}
