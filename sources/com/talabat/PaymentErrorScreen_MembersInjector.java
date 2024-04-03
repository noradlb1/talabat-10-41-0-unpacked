package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PaymentErrorScreen_MembersInjector implements MembersInjector<PaymentErrorScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public PaymentErrorScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<PaymentErrorScreen> create(Provider<AppVersionProvider> provider) {
        return new PaymentErrorScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.PaymentErrorScreen.appVersionProvider")
    public static void injectAppVersionProvider(PaymentErrorScreen paymentErrorScreen, AppVersionProvider appVersionProvider2) {
        paymentErrorScreen.f54525i = appVersionProvider2;
    }

    public void injectMembers(PaymentErrorScreen paymentErrorScreen) {
        injectAppVersionProvider(paymentErrorScreen, this.appVersionProvider.get());
    }
}
