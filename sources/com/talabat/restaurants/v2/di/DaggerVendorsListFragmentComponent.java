package com.talabat.restaurants.v2.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v2.di.VendorsListFragmentComponent;
import com.talabat.restaurants.v2.ui.fragments.VendorsListFragment;
import com.talabat.restaurants.v2.ui.fragments.VendorsListFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVendorsListFragmentComponent {

    public static final class Factory implements VendorsListFragmentComponent.Factory {
        private Factory() {
        }

        public VendorsListFragmentComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new VendorsListFragmentComponentImpl(configurationRemoteCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class VendorsListFragmentComponentImpl implements VendorsListFragmentComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final VendorsListFragmentComponentImpl vendorsListFragmentComponentImpl;

        private VendorsListFragmentComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.vendorsListFragmentComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private VendorsListFragment injectVendorsListFragment(VendorsListFragment vendorsListFragment) {
            VendorsListFragment_MembersInjector.injectTalabatFeatureFlag(vendorsListFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            VendorsListFragment_MembersInjector.injectLocationConfigurationRepository(vendorsListFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
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
