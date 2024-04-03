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
public final class GiftVoucherDetailsScreen_MembersInjector implements MembersInjector<GiftVoucherDetailsScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<TermsAndConditionsConfigurationRepository> termsAndConditionsConfigurationRepositoryProvider;

    public GiftVoucherDetailsScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<TermsAndConditionsConfigurationRepository> provider2) {
        this.appVersionProvider = provider;
        this.termsAndConditionsConfigurationRepositoryProvider = provider2;
    }

    public static MembersInjector<GiftVoucherDetailsScreen> create(Provider<AppVersionProvider> provider, Provider<TermsAndConditionsConfigurationRepository> provider2) {
        return new GiftVoucherDetailsScreen_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.GiftVoucherDetailsScreen.appVersionProvider")
    public static void injectAppVersionProvider(GiftVoucherDetailsScreen giftVoucherDetailsScreen, AppVersionProvider appVersionProvider2) {
        giftVoucherDetailsScreen.f54083i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.GiftVoucherDetailsScreen.termsAndConditionsConfigurationRepository")
    public static void injectTermsAndConditionsConfigurationRepository(GiftVoucherDetailsScreen giftVoucherDetailsScreen, TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository) {
        giftVoucherDetailsScreen.f54084j = termsAndConditionsConfigurationRepository;
    }

    public void injectMembers(GiftVoucherDetailsScreen giftVoucherDetailsScreen) {
        injectAppVersionProvider(giftVoucherDetailsScreen, this.appVersionProvider.get());
        injectTermsAndConditionsConfigurationRepository(giftVoucherDetailsScreen, this.termsAndConditionsConfigurationRepositoryProvider.get());
    }
}
