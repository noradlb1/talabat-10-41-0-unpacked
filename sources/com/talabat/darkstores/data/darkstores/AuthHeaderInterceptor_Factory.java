package com.talabat.darkstores.data.darkstores;

import com.talabat.darkstores.common.helpers.Base64Helper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AuthHeaderInterceptor_Factory implements Factory<AuthHeaderInterceptor> {
    private final Provider<String> apiKeyProvider;
    private final Provider<Base64Helper> base64HelperProvider;

    public AuthHeaderInterceptor_Factory(Provider<String> provider, Provider<Base64Helper> provider2) {
        this.apiKeyProvider = provider;
        this.base64HelperProvider = provider2;
    }

    public static AuthHeaderInterceptor_Factory create(Provider<String> provider, Provider<Base64Helper> provider2) {
        return new AuthHeaderInterceptor_Factory(provider, provider2);
    }

    public static AuthHeaderInterceptor newInstance(String str, Base64Helper base64Helper) {
        return new AuthHeaderInterceptor(str, base64Helper);
    }

    public AuthHeaderInterceptor get() {
        return newInstance(this.apiKeyProvider.get(), this.base64HelperProvider.get());
    }
}
