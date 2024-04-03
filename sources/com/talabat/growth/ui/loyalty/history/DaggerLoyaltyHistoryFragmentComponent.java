package com.talabat.growth.ui.loyalty.history;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.growth.ui.loyalty.history.LoyaltyHistoryFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerLoyaltyHistoryFragmentComponent {

    public static final class Factory implements LoyaltyHistoryFragmentComponent.Factory {
        private Factory() {
        }

        public LoyaltyHistoryFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new LoyaltyHistoryFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    public static final class LoyaltyHistoryFragmentComponentImpl implements LoyaltyHistoryFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final LoyaltyHistoryFragmentComponentImpl loyaltyHistoryFragmentComponentImpl;

        private LoyaltyHistoryFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.loyaltyHistoryFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private LoyaltyHistoryFragment injectLoyaltyHistoryFragment(LoyaltyHistoryFragment loyaltyHistoryFragment) {
            LoyaltyHistoryFragment_MembersInjector.injectConfigurationLocalRepository(loyaltyHistoryFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return loyaltyHistoryFragment;
        }

        public void inject(LoyaltyHistoryFragment loyaltyHistoryFragment) {
            injectLoyaltyHistoryFragment(loyaltyHistoryFragment);
        }
    }

    private DaggerLoyaltyHistoryFragmentComponent() {
    }

    public static LoyaltyHistoryFragmentComponent.Factory factory() {
        return new Factory();
    }
}
