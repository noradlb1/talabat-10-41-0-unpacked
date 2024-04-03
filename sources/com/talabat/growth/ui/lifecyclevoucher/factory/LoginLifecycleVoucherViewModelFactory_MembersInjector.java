package com.talabat.growth.ui.lifecyclevoucher.factory;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class LoginLifecycleVoucherViewModelFactory_MembersInjector implements MembersInjector<LoginLifecycleVoucherViewModelFactory> {
    private final Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;

    public LoginLifecycleVoucherViewModelFactory_MembersInjector(Provider<ConfigurationLocalCoreLibApi> provider) {
        this.configurationLocalCoreLibApiProvider = provider;
    }

    public static MembersInjector<LoginLifecycleVoucherViewModelFactory> create(Provider<ConfigurationLocalCoreLibApi> provider) {
        return new LoginLifecycleVoucherViewModelFactory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.lifecyclevoucher.factory.LoginLifecycleVoucherViewModelFactory.configurationLocalCoreLibApi")
    public static void injectConfigurationLocalCoreLibApi(LoginLifecycleVoucherViewModelFactory loginLifecycleVoucherViewModelFactory, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        loginLifecycleVoucherViewModelFactory.configurationLocalCoreLibApi = configurationLocalCoreLibApi;
    }

    public void injectMembers(LoginLifecycleVoucherViewModelFactory loginLifecycleVoucherViewModelFactory) {
        injectConfigurationLocalCoreLibApi(loginLifecycleVoucherViewModelFactory, this.configurationLocalCoreLibApiProvider.get());
    }
}
