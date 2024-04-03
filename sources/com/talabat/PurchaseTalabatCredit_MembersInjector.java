package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PurchaseTalabatCredit_MembersInjector implements MembersInjector<PurchaseTalabatCredit> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public PurchaseTalabatCredit_MembersInjector(Provider<AppVersionProvider> provider, Provider<TermsAndConditionsConfigurationRepository> provider2) {
        this.appVersionProvider = provider;
        this.termsAndConditionsConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<PurchaseTalabatCredit> create(Provider<AppVersionProvider> provider, Provider<TermsAndConditionsConfigurationRepository> provider2) {
        return new PurchaseTalabatCredit_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.PurchaseTalabatCredit.appVersionProvider")
    public static void injectAppVersionProvider(PurchaseTalabatCredit purchaseTalabatCredit, AppVersionProvider appVersionProvider2) {
        purchaseTalabatCredit.f54552j = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.PurchaseTalabatCredit.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(PurchaseTalabatCredit purchaseTalabatCredit, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        purchaseTalabatCredit.f54553k = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(PurchaseTalabatCredit purchaseTalabatCredit) {
        injectAppVersionProvider(purchaseTalabatCredit, this.appVersionProvider.get());
        injectTermsAndConditionsConfigurationRepository(purchaseTalabatCredit, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
