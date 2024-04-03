package com.talabat.authentication.natives.di.fake;

import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class FakeJwtTokenCoreLibModule_RepositoryFactory implements Factory<JwtTokenRepository> {
    private final Provider<JwtTokenManager> managerProvider;

    public FakeJwtTokenCoreLibModule_RepositoryFactory(Provider<JwtTokenManager> provider) {
        this.managerProvider = provider;
    }

    public static FakeJwtTokenCoreLibModule_RepositoryFactory create(Provider<JwtTokenManager> provider) {
        return new FakeJwtTokenCoreLibModule_RepositoryFactory(provider);
    }

    public static JwtTokenRepository repository(JwtTokenManager jwtTokenManager) {
        return (JwtTokenRepository) Preconditions.checkNotNullFromProvides(FakeJwtTokenCoreLibModule.INSTANCE.repository(jwtTokenManager));
    }

    public JwtTokenRepository get() {
        return repository(this.managerProvider.get());
    }
}
