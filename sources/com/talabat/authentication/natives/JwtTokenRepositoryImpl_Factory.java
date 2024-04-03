package com.talabat.authentication.natives;

import com.talabat.authentication.JwtTokenManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class JwtTokenRepositoryImpl_Factory implements Factory<JwtTokenRepositoryImpl> {
    private final Provider<JwtTokenManager> managerProvider;

    public JwtTokenRepositoryImpl_Factory(Provider<JwtTokenManager> provider) {
        this.managerProvider = provider;
    }

    public static JwtTokenRepositoryImpl_Factory create(Provider<JwtTokenManager> provider) {
        return new JwtTokenRepositoryImpl_Factory(provider);
    }

    public static JwtTokenRepositoryImpl newInstance(JwtTokenManager jwtTokenManager) {
        return new JwtTokenRepositoryImpl(jwtTokenManager);
    }

    public JwtTokenRepositoryImpl get() {
        return newInstance(this.managerProvider.get());
    }
}
