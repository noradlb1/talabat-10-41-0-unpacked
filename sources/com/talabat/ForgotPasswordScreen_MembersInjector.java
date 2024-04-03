package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ForgotPasswordScreen_MembersInjector implements MembersInjector<ForgotPasswordScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public ForgotPasswordScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<ForgotPasswordScreen> create(Provider<AppVersionProvider> provider) {
        return new ForgotPasswordScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.ForgotPasswordScreen.appVersionProvider")
    public static void injectAppVersionProvider(ForgotPasswordScreen forgotPasswordScreen, AppVersionProvider appVersionProvider2) {
        forgotPasswordScreen.f54016i = appVersionProvider2;
    }

    public void injectMembers(ForgotPasswordScreen forgotPasswordScreen) {
        injectAppVersionProvider(forgotPasswordScreen, this.appVersionProvider.get());
    }
}
