package com.talabat.core.social.login.data.di;

import com.talabat.core.social.login.domain.GoogleLoginUseCase;
import com.talabat.core.social.login.domain.di.SocialLoginDomainModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class SocialLoginCoreLibModule_GoogleLoginUseCaseFactory implements Factory<GoogleLoginUseCase> {
    private final SocialLoginCoreLibModule module;
    private final Provider<SocialLoginDomainModule> socialLoginDomainModuleProvider;

    public SocialLoginCoreLibModule_GoogleLoginUseCaseFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        this.module = socialLoginCoreLibModule;
        this.socialLoginDomainModuleProvider = provider;
    }

    public static SocialLoginCoreLibModule_GoogleLoginUseCaseFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        return new SocialLoginCoreLibModule_GoogleLoginUseCaseFactory(socialLoginCoreLibModule, provider);
    }

    public static GoogleLoginUseCase googleLoginUseCase(SocialLoginCoreLibModule socialLoginCoreLibModule, SocialLoginDomainModule socialLoginDomainModule) {
        return (GoogleLoginUseCase) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.googleLoginUseCase(socialLoginDomainModule));
    }

    public GoogleLoginUseCase get() {
        return googleLoginUseCase(this.module, this.socialLoginDomainModuleProvider.get());
    }
}
