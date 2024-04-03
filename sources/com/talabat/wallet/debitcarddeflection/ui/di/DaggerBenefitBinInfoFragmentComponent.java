package com.talabat.wallet.debitcarddeflection.ui.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.wallet.debitcarddeflection.ui.BenefitBinInfoFragment;
import com.talabat.wallet.debitcarddeflection.ui.BenefitBinInfoFragment_MembersInjector;
import com.talabat.wallet.debitcarddeflection.ui.di.BenefitBinInfoFragmentComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerBenefitBinInfoFragmentComponent {

    public static final class BenefitBinInfoFragmentComponentImpl implements BenefitBinInfoFragmentComponent {
        private final BenefitBinInfoFragmentComponentImpl benefitBinInfoFragmentComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

        private BenefitBinInfoFragmentComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
            this.benefitBinInfoFragmentComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        }

        private BenefitBinInfoFragment injectBenefitBinInfoFragment(BenefitBinInfoFragment benefitBinInfoFragment) {
            BenefitBinInfoFragment_MembersInjector.injectConfigurationLocalRepository(benefitBinInfoFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            return benefitBinInfoFragment;
        }

        public void inject(BenefitBinInfoFragment benefitBinInfoFragment) {
            injectBenefitBinInfoFragment(benefitBinInfoFragment);
        }
    }

    public static final class Factory implements BenefitBinInfoFragmentComponent.Factory {
        private Factory() {
        }

        public BenefitBinInfoFragmentComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            return new BenefitBinInfoFragmentComponentImpl(configurationLocalCoreLibApi);
        }
    }

    private DaggerBenefitBinInfoFragmentComponent() {
    }

    public static BenefitBinInfoFragmentComponent.Factory factory() {
        return new Factory();
    }
}
