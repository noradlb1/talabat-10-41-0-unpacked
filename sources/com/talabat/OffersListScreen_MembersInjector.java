package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class OffersListScreen_MembersInjector implements MembersInjector<OffersListScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public OffersListScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<OffersListScreen> create(Provider<AppVersionProvider> provider) {
        return new OffersListScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.OffersListScreen.appVersionProvider")
    public static void injectAppVersionProvider(OffersListScreen offersListScreen, AppVersionProvider appVersionProvider2) {
        offersListScreen.f54440j = appVersionProvider2;
    }

    public void injectMembers(OffersListScreen offersListScreen) {
        injectAppVersionProvider(offersListScreen, this.appVersionProvider.get());
    }
}
