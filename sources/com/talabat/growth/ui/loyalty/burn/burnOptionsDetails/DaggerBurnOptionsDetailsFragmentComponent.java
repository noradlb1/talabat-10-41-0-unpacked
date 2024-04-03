package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBurnOptionsDetailsFragmentComponent {

    public static final class BurnOptionsDetailsFragmentComponentImpl implements BurnOptionsDetailsFragmentComponent {
        private final BurnOptionsDetailsFragmentComponentImpl burnOptionsDetailsFragmentComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

        private BurnOptionsDetailsFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.burnOptionsDetailsFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private BurnOptionsDetailsFragment injectBurnOptionsDetailsFragment(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
            BurnOptionsDetailsFragment_MembersInjector.injectConfigurationLocalRepository(burnOptionsDetailsFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return burnOptionsDetailsFragment;
        }

        public void inject(BurnOptionsDetailsFragment burnOptionsDetailsFragment) {
            injectBurnOptionsDetailsFragment(burnOptionsDetailsFragment);
        }
    }

    public static final class Factory implements BurnOptionsDetailsFragmentComponent.Factory {
        private Factory() {
        }

        public BurnOptionsDetailsFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new BurnOptionsDetailsFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    private DaggerBurnOptionsDetailsFragmentComponent() {
    }

    public static BurnOptionsDetailsFragmentComponent.Factory factory() {
        return new Factory();
    }
}
