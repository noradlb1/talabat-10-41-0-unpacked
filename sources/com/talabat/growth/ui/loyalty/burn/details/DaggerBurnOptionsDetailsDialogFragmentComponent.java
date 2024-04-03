package com.talabat.growth.ui.loyalty.burn.details;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.growth.ui.loyalty.burn.details.BurnOptionsDetailsDialogFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBurnOptionsDetailsDialogFragmentComponent {

    public static final class BurnOptionsDetailsDialogFragmentComponentImpl implements BurnOptionsDetailsDialogFragmentComponent {
        private final BurnOptionsDetailsDialogFragmentComponentImpl burnOptionsDetailsDialogFragmentComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

        private BurnOptionsDetailsDialogFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.burnOptionsDetailsDialogFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private BurnOptionsDetailsDialogFragment injectBurnOptionsDetailsDialogFragment(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
            BurnOptionsDetailsDialogFragment_MembersInjector.injectConfigurationLocalRepository(burnOptionsDetailsDialogFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return burnOptionsDetailsDialogFragment;
        }

        public void inject(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
            injectBurnOptionsDetailsDialogFragment(burnOptionsDetailsDialogFragment);
        }
    }

    public static final class Factory implements BurnOptionsDetailsDialogFragmentComponent.Factory {
        private Factory() {
        }

        public BurnOptionsDetailsDialogFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new BurnOptionsDetailsDialogFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    private DaggerBurnOptionsDetailsDialogFragmentComponent() {
    }

    public static BurnOptionsDetailsDialogFragmentComponent.Factory factory() {
        return new Factory();
    }
}
