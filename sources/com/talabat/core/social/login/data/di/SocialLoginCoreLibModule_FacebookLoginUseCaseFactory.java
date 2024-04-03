package com.talabat.core.social.login.data.di;

import com.talabat.core.social.login.domain.FacebookLoginUseCase;
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
public final class SocialLoginCoreLibModule_FacebookLoginUseCaseFactory implements Factory<FacebookLoginUseCase> {
    private final SocialLoginCoreLibModule module;
    private final Provider<SocialLoginDomainModule> socialLoginDomainModuleProvider;

    public SocialLoginCoreLibModule_FacebookLoginUseCaseFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        this.module = socialLoginCoreLibModule;
        this.socialLoginDomainModuleProvider = provider;
    }

    public static SocialLoginCoreLibModule_FacebookLoginUseCaseFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<SocialLoginDomainModule> provider) {
        return new SocialLoginCoreLibModule_FacebookLoginUseCaseFactory(socialLoginCoreLibModule, provider);
    }

    public static FacebookLoginUseCase facebookLoginUseCase(SocialLoginCoreLibModule socialLoginCoreLibModule, SocialLoginDomainModule socialLoginDomainModule) {
        return (FacebookLoginUseCase) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.facebookLoginUseCase(socialLoginDomainModule));
    }

    public FacebookLoginUseCase get() {
        return facebookLoginUseCase(this.module, this.socialLoginDomainModuleProvider.get());
    }
}
