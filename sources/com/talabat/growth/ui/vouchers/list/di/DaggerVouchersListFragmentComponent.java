package com.talabat.growth.ui.vouchers.list.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.growth.ui.vouchers.list.VouchersListFragment;
import com.talabat.growth.ui.vouchers.list.VouchersListFragment_MembersInjector;
import com.talabat.growth.ui.vouchers.list.di.VouchersListFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerVouchersListFragmentComponent {

    public static final class Factory implements VouchersListFragmentComponent.Factory {
        private Factory() {
        }

        public VouchersListFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new VouchersListFragmentComponentImpl(configurationLocalCoreLibApi, observabilityCoreLibApi);
        }
    }

    public static final class VouchersListFragmentComponentImpl implements VouchersListFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final VouchersListFragmentComponentImpl vouchersListFragmentComponentImpl;

        private VouchersListFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.vouchersListFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private VouchersListFragment injectVouchersListFragment(VouchersListFragment vouchersListFragment) {
            VouchersListFragment_MembersInjector.injectConfigurationLocalRepository(vouchersListFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            VouchersListFragment_MembersInjector.injectObservabilityManager(vouchersListFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return vouchersListFragment;
        }

        public void inject(VouchersListFragment vouchersListFragment) {
            injectVouchersListFragment(vouchersListFragment);
        }
    }

    private DaggerVouchersListFragmentComponent() {
    }

    public static VouchersListFragmentComponent.Factory factory() {
        return new Factory();
    }
}
