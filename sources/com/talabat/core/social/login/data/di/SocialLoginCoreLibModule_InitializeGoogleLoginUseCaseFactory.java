package com.talabat.core.social.login.data.di;

import com.talabat.core.social.login.domain.InitializeGoogleLoginUseCase;
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
public final class SocialLoginCoreLibModule_InitializeGoogleLoginUseCaseFactory implements Factory<InitializeGoogleLoginUseCase> {
    private final SocialLoginCoreLibModule module;
    private final Provider<SocialLoginDomainModule> socialLoginDomainModuleProvider;

    public SocialLoginCoreLibModule_InitializeGoogleLoginUseCaseFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        this.module = socialLoginCoreLibModule;
        this.socialLoginDomainModuleProvider = provider;
    }

    public static SocialLoginCoreLibModule_InitializeGoogleLoginUseCaseFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        return new SocialLoginCoreLibModule_InitializeGoogleLoginUseCaseFactory(socialLoginCoreLibModule, provider);
    }

    public static InitializeGoogleLoginUseCase initializeGoogleLoginUseCase(SocialLoginCoreLibModule socialLoginCoreLibModule, SocialLoginDomainModule socialLoginDomainModule) {
        return (InitializeGoogleLoginUseCase) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.initializeGoogleLoginUseCase(socialLoginDomainModule));
    }

    public InitializeGoogleLoginUseCase get() {
        return initializeGoogleLoginUseCase(this.module, this.socialLoginDomainModuleProvider.get());
    }
}
