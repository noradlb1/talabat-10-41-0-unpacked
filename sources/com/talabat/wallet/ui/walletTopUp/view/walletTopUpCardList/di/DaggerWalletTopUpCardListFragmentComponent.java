package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.WalletTopUpCardListFragment_MembersInjector;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.di.WalletTopUpCardListFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerWalletTopUpCardListFragmentComponent {

    public static final class Factory implements WalletTopUpCardListFragmentComponent.Factory {
        private Factory() {
        }

        public WalletTopUpCardListFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new WalletTopUpCardListFragmentComponentImpl(configurationLocalCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class WalletTopUpCardListFragmentComponentImpl implements WalletTopUpCardListFragmentComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private final TrackingCoreLibApi trackingCoreLibApi;
        private final WalletTopUpCardListFragmentComponentImpl walletTopUpCardListFragmentComponentImpl;

        private WalletTopUpCardListFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2) {
            this.walletTopUpCardListFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
        }

        private WalletTopUpCardListFragment injectWalletTopUpCardListFragment(WalletTopUpCardListFragment walletTopUpCardListFragment) {
            WalletTopUpCardListFragment_MembersInjector.injectConfigurationLocalRepository(walletTopUpCardListFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            WalletTopUpCardListFragment_MembersInjector.injectFeatureFlag(walletTopUpCardListFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            WalletTopUpCardListFragment_MembersInjector.injectObservabilityManager(walletTopUpCardListFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            WalletTopUpCardListFragment_MembersInjector.injectTalabatTracker(walletTopUpCardListFragment, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            return walletTopUpCardListFragment;
        }

        public void inject(WalletTopUpCardListFragment walletTopUpCardListFragment) {
            injectWalletTopUpCardListFragment(walletTopUpCardListFragment);
        }
    }

    private DaggerWalletTopUpCardListFragmentComponent() {
    }

    public static WalletTopUpCardListFragmentComponent.Factory factory() {
        return new Factory();
    }
}
