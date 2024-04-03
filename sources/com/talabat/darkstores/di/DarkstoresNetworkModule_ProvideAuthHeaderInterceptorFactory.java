package com.talabat.darkstores.di;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.darkstores.common.helpers.Base64Helper;
import com.talabat.darkstores.data.darkstores.AuthHeaderInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresNetworkModule_ProvideAuthHeaderInterceptorFactory implements Factory<AuthHeaderInterceptor> {
    private final Provider<Base64Helper> base64HelperProvider;
    private final Provider<SecretProvider> secretProvider;

    public DarkstoresNetworkModule_ProvideAuthHeaderInterceptorFactory(Provider<SecretProvider> provider, Provider<Base64Helper> provider2) {
        this.secretProvider = provider;
        this.base64HelperProvider = provider2;
    }

    public static DarkstoresNetworkModule_ProvideAuthHeaderInterceptorFactory create(Provider<SecretProvider> provider, Provider<Base64Helper> provider2) {
        return new DarkstoresNetworkModule_ProvideAuthHeaderInterceptorFactory(provider, provider2);
    }

    public static AuthHeaderInterceptor provideAuthHeaderInterceptor(SecretProvider secretProvider2, Base64Helper base64Helper) {
        return (AuthHeaderInterceptor) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideAuthHeaderInterceptor(secretProvider2, base64Helper));
    }

    public AuthHeaderInterceptor get() {
        return provideAuthHeaderInterceptor(this.secretProvider.get(), this.base64HelperProvider.get());
    }
}
