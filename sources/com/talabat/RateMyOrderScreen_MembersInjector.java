package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RateMyOrderScreen_MembersInjector implements MembersInjector<RateMyOrderScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public RateMyOrderScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<RateMyOrderScreen> create(Provider<AppVersionProvider> provider) {
        return new RateMyOrderScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.RateMyOrderScreen.appVersionProvider")
    public static void injectAppVersionProvider(RateMyOrderScreen rateMyOrderScreen, AppVersionProvider appVersionProvider2) {
        rateMyOrderScreen.f54905t = appVersionProvider2;
    }

    public void injectMembers(RateMyOrderScreen rateMyOrderScreen) {
        injectAppVersionProvider(rateMyOrderScreen, this.appVersionProvider.get());
    }
}
