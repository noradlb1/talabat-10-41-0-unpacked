package com.talabat.core.social.login.data.di;

import com.talabat.core.facebook.login.domain.integration.FacebookLoginActivityIntegration;
import com.talabat.core.facebook.login.domain.repository.FacebookLoginRepository;
import com.talabat.core.google.login.domain.repository.GoogleLoginRepository;
import com.talabat.core.social.login.domain.AaaAuthenticationForSocialLoginRepository;
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
public final class SocialLoginCoreLibModule_ProvideSocialLoginDomainModuleFactory implements Factory<SocialLoginDomainModule> {
    private final Provider<AaaAuthenticationForSocialLoginRepository> aaaAuthenticationRepositoryProvider;
    private final Provider<FacebookLoginActivityIntegration> facebookLoginActivityIntegrationProvider;
    private final Provider<FacebookLoginRepository> facebookLoginRepositoryProvider;
    private final Provider<GoogleLoginRepository> googleLoginRepositoryProvider;
    private final SocialLoginCoreLibModule module;

    public SocialLoginCoreLibModule_ProvideSocialLoginDomainModuleFactory(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<GoogleLoginRepository> provider, Provider<FacebookLoginRepository> provider2, Provider<AaaAuthenticationForSocialLoginRepository> provider3, Provider<FacebookLoginActivityIntegration> provider4) {
        this.module = socialLoginCoreLibModule;
        this.googleLoginRepositoryProvider = provider;
        this.facebookLoginRepositoryProvider = provider2;
        this.aaaAuthenticationRepositoryProvider = provider3;
        this.facebookLoginActivityIntegrationProvider = provider4;
    }

    public static SocialLoginCoreLibModule_ProvideSocialLoginDomainModuleFactory create(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<GoogleLoginRepository> provider, Provider<FacebookLoginRepository> provider2, Provider<AaaAuthenticationForSocialLoginRepository> provider3, Provider<FacebookLoginActivityIntegration> provider4) {
        return new SocialLoginCoreLibModule_ProvideSocialLoginDomainModuleFactory(socialLoginCoreLibModule, provider, provider2, provider3, provider4);
    }

    public static SocialLoginDomainModule provideSocialLoginDomainModule(SocialLoginCoreLibModule socialLoginCoreLibModule, Provider<GoogleLoginRepository> provider, Provider<FacebookLoginRepository> provider2, Provider<AaaAuthenticationForSocialLoginRepository> provider3, Provider<FacebookLoginActivityIntegration> provider4) {
        return (SocialLoginDomainModule) Preconditions.checkNotNullFromProvides(socialLoginCoreLibModule.provideSocialLoginDomainModule(provider, provider2, provider3, provider4));
    }

    public SocialLoginDomainModule get() {
        return provideSocialLoginDomainModule(this.module, this.googleLoginRepositoryProvider, this.facebookLoginRepositoryProvider, this.aaaAuthenticationRepositoryProvider, this.facebookLoginActivityIntegrationProvider);
    }
}
