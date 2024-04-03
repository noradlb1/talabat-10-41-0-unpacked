package com.talabat.talabatlife.ui.onBoarding.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.talabatlife.ui.onBoarding.di.VendorsListFragmentComponent;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVendorsListFragmentComponent {

    public static final class Factory implements VendorsListFragmentComponent.Factory {
        private Factory() {
        }

        public VendorsListFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, HelpCenterFeatureApi helpCenterFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(helpCenterFeatureApi);
            return new VendorsListFragmentComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi, deepLinkCoreLibApi, helpCenterFeatureApi);
        }
    }

    public static final class VendorsListFragmentComponentImpl implements VendorsListFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final HelpCenterFeatureApi helpCenterFeatureApi;
        private final VendorsListFragmentComponentImpl vendorsListFragmentComponentImpl;

        private VendorsListFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, HelpCenterFeatureApi helpCenterFeatureApi2) {
            this.vendorsListFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.helpCenterFeatureApi = helpCenterFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private VendorsListFragment injectVendorsListFragment(VendorsListFragment vendorsListFragment) {
            VendorsListFragment_MembersInjector.injectConfigurationLocalCoreLibApi(vendorsListFragment, this.configurationLocalCoreLibApi);
            VendorsListFragment_MembersInjector.injectFeatureFlagRepo(vendorsListFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            VendorsListFragment_MembersInjector.injectHelpCenterDeeplinkBuilder(vendorsListFragment, (IHelpCenterDeeplinkBuilder) Preconditions.checkNotNullFromComponent(this.helpCenterFeatureApi.getHelpCenterDeeplinkNavigator()));
            VendorsListFragment_MembersInjector.injectDeepLinkNavigator(vendorsListFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return vendorsListFragment;
        }

        public void inject(VendorsListFragment vendorsListFragment) {
            injectVendorsListFragment(vendorsListFragment);
        }
    }

    private DaggerVendorsListFragmentComponent() {
    }

    public static VendorsListFragmentComponent.Factory factory() {
        return new Factory();
    }
}
