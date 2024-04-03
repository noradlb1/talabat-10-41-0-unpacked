package com.talabat.core.social.login.data.di;

import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class SocialLoginCoreLibModule_ProvideAaaAuthenticatorForSocialLoginFactory implements Factory<AaaAuthenticationForSocialLoginRepository> {
    private final Provider<SocialAuthenticationRepository> authenticationRepositoryProvider;
    private final SocialLoginCoreLibModule module;

    public SocialLoginCoreLibModule_ProvideAaaAuthenticatorForSocialLoginFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialAuthenticationRepository> provider) {
        this.module = socialLoginCoreLibModule;
        this.authenticationRepositoryProvider = provider;
    }

    public static SocialLoginCoreLibModule_ProvideAaaAuthenticatorForSocialLoginFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialAuthenticationRepository> provider) {
        return new SocialLoginCoreLibModule_ProvideAaaAuthenticatorForSocialLoginFactory(socialLoginCoreLibModule, provider);
    }

    public static AaaAuthenticationForSocialLoginRepository provideAaaAuthenticatorForSocialLogin(SocialLoginCoreLibModule socialLoginCoreLibModule, SocialAuthenticationRepository socialAuthenticationRepository) {
        return (AaaAuthenticationForSocialLoginRepository) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.provideAaaAuthenticatorForSocialLogin(socialAuthenticationRepository));
    }

    public AaaAuthenticationForSocialLoginRepository get() {
        return provideAaaAuthenticatorForSocialLogin(this.module, this.authenticationRepositoryProvider.get());
    }
}
