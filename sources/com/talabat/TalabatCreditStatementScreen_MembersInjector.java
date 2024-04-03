package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TalabatCreditStatementScreen_MembersInjector implements MembersInjector<TalabatCreditStatementScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public TalabatCreditStatementScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<TalabatCreditStatementScreen> create(Provider<AppVersionProvider> provider) {
        return new TalabatCreditStatementScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.TalabatCreditStatementScreen.appVersionProvider")
    public static void injectAppVersionProvider(TalabatCreditStatementScreen talabatCreditStatementScreen, AppVersionProvider appVersionProvider2) {
        talabatCreditStatementScreen.f55077k = appVersionProvider2;
    }

    public void injectMembers(TalabatCreditStatementScreen talabatCreditStatementScreen) {
        injectAppVersionProvider(talabatCreditStatementScreen, this.appVersionProvider.get());
    }
}
