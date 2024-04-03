package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class GiftVoucherList_MembersInjector implements MembersInjector<GiftVoucherList> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public GiftVoucherList_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static MembersInjector<GiftVoucherList> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new GiftVoucherList_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.GiftVoucherList.appVersionProvider")
    public static void injectAppVersionProvider(GiftVoucherList giftVoucherList, AppVersionProvider appVersionProvider2) {
        giftVoucherList.f54089i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.GiftVoucherList.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(GiftVoucherList giftVoucherList, ConfigurationLocalRepository configurationLocalRepository) {
        giftVoucherList.f54090j = configurationLocalRepository;
    }

    public void injectMembers(GiftVoucherList giftVoucherList) {
        injectAppVersionProvider(giftVoucherList, this.appVersionProvider.get());
        injectConfigurationLocalRepository(giftVoucherList, this.configurationLocalRepositoryProvider.get());
    }
}
