package com.talabat.di.purchase;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.PurchaseTalabatCredit;
import com.talabat.PurchaseTalabatCredit_MembersInjector;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.di.purchase.PurchaseTalabatCreditScreenComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerPurchaseTalabatCreditScreenComponent {

    public static final class Factory implements PurchaseTalabatCreditScreenComponent.Factory {
        private Factory() {
        }

        public PurchaseTalabatCreditScreenComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            return new PurchaseTalabatCreditScreenComponentImpl(configurationRemoteCoreLibApi);
        }
    }

    public static final class PurchaseTalabatCreditScreenComponentImpl implements PurchaseTalabatCreditScreenComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final PurchaseTalabatCreditScreenComponentImpl purchaseTalabatCreditScreenComponentImpl;

        private PurchaseTalabatCreditScreenComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
            this.purchaseTalabatCreditScreenComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private PurchaseTalabatCredit injectPurchaseTalabatCredit(PurchaseTalabatCredit purchaseTalabatCredit) {
            PurchaseTalabatCredit_MembersInjector.injectAppVersionProvider(purchaseTalabatCredit, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            PurchaseTalabatCredit_MembersInjector.injectTermsAndConditionsConfigurationRepository(purchaseTalabatCredit, (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()));
            return purchaseTalabatCredit;
        }

        public void inject(PurchaseTalabatCredit purchaseTalabatCredit) {
            injectPurchaseTalabatCredit(purchaseTalabatCredit);
        }
    }

    private DaggerPurchaseTalabatCreditScreenComponent() {
    }

    public static PurchaseTalabatCreditScreenComponent.Factory factory() {
        return new Factory();
    }
}
