package com.talabat.wallet.bnplmanager.ui.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragment_MembersInjector;
import com.talabat.wallet.bnplmanager.ui.di.BNPLInitiatePlaceOrderFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBNPLInitiatePlaceOrderFragmentComponent {

    public static final class BNPLInitiatePlaceOrderFragmentComponentImpl implements BNPLInitiatePlaceOrderFragmentComponent {
        private final BNPLInitiatePlaceOrderFragmentComponentImpl bNPLInitiatePlaceOrderFragmentComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private BNPLInitiatePlaceOrderFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.bNPLInitiatePlaceOrderFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        private BNPLInitiatePlaceOrderFragment injectBNPLInitiatePlaceOrderFragment(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
            BNPLInitiatePlaceOrderFragment_MembersInjector.injectConfigurationLocalRepository(bNPLInitiatePlaceOrderFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            BNPLInitiatePlaceOrderFragment_MembersInjector.injectLocationConfigurationRepository(bNPLInitiatePlaceOrderFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            BNPLInitiatePlaceOrderFragment_MembersInjector.injectFeatureFlagRepository(bNPLInitiatePlaceOrderFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            BNPLInitiatePlaceOrderFragment_MembersInjector.injectObservabilityManager(bNPLInitiatePlaceOrderFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            BNPLInitiatePlaceOrderFragment_MembersInjector.injectTermsAndConditionsConfigurationRepository(bNPLInitiatePlaceOrderFragment, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return bNPLInitiatePlaceOrderFragment;
        }

        public void inject(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
            injectBNPLInitiatePlaceOrderFragment(bNPLInitiatePlaceOrderFragment);
        }
    }

    public static final class Factory implements BNPLInitiatePlaceOrderFragmentComponent.Factory {
        private Factory() {
        }

        public BNPLInitiatePlaceOrderFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new BNPLInitiatePlaceOrderFragmentComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi);
        }
    }

    private DaggerBNPLInitiatePlaceOrderFragmentComponent() {
    }

    public static BNPLInitiatePlaceOrderFragmentComponent.Factory factory() {
        return new Factory();
    }
}
