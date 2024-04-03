package com.talabat.core.social.login.data.di;

import com.talabat.core.social.login.domain.InitializeFacebookLoginUseCase;
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
public final class SocialLoginCoreLibModule_InitializeFacebookLoginUseCaseFactory implements Factory<InitializeFacebookLoginUseCase> {
    private final SocialLoginCoreLibModule module;
    private final Provider<SocialLoginDomainModule> socialLoginDomainModuleProvider;

    public SocialLoginCoreLibModule_InitializeFacebookLoginUseCaseFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        this.module = socialLoginCoreLibModule;
        this.socialLoginDomainModuleProvider = provider;
    }

    public static SocialLoginCoreLibModule_InitializeFacebookLoginUseCaseFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        return new SocialLoginCoreLibModule_InitializeFacebookLoginUseCaseFactory(socialLoginCoreLibModule, provider);
    }

    public static InitializeFacebookLoginUseCase initializeFacebookLoginUseCase(SocialLoginCoreLibModule socialLoginCoreLibModule, SocialLoginDomainModule socialLoginDomainModule) {
        return (InitializeFacebookLoginUseCase) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.initializeFacebookLoginUseCase(socialLoginDomainModule));
    }

    public InitializeFacebookLoginUseCase get() {
        return initializeFacebookLoginUseCase(this.module, this.socialLoginDomainModuleProvider.get());
    }
}
