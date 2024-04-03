package com.talabat.app.di;

import com.talabat.authentication.authenticate.domain.AuthenticationCoreLibApi;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import com.talabat.core.google.login.domain.GoogleLoginCoreLibApi;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_SocialLoginCoreLibApiFactory implements Factory<SocialLoginCoreLibApi> {
    private final Provider<AuthenticationCoreLibApi> authenticationCoreLibApiProvider;
    private final Provider<FacebookLoginCoreLibApi> facebookLoginCoreLibApiProvider;
    private final Provider<GoogleLoginCoreLibApi> googleLoginCoreLibApiProvider;
    private final CoreLibsModule module;

    public CoreLibsModule_SocialLoginCoreLibApiFactory(CoreLibsModule coreLibsModule, Provider<AuthenticationCoreLibApi> provider, Provider<GoogleLoginCoreLibApi> provider2, Provider<FacebookLoginCoreLibApi> provider3) {
        this.module = coreLibsModule;
        this.authenticationCoreLibApiProvider = provider;
        this.googleLoginCoreLibApiProvider = provider2;
        this.facebookLoginCoreLibApiProvider = provider3;
    }

    public static CoreLibsModule_SocialLoginCoreLibApiFactory create(CoreLibsModule coreLibsModule, Provider<AuthenticationCoreLibApi> provider, Provider<GoogleLoginCoreLibApi> provider2, Provider<FacebookLoginCoreLibApi> provider3) {
        return new CoreLibsModule_SocialLoginCoreLibApiFactory(coreLibsModule, provider, provider2, provider3);
    }

    public static SocialLoginCoreLibApi socialLoginCoreLibApi(CoreLibsModule coreLibsModule, AuthenticationCoreLibApi authenticationCoreLibApi, GoogleLoginCoreLibApi googleLoginCoreLibApi, FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
        return (SocialLoginCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.socialLoginCoreLibApi(authenticationCoreLibApi, googleLoginCoreLibApi, facebookLoginCoreLibApi));
    }

    public SocialLoginCoreLibApi get() {
        return socialLoginCoreLibApi(this.module, this.authenticationCoreLibApiProvider.get(), this.googleLoginCoreLibApiProvider.get(), this.facebookLoginCoreLibApiProvider.get());
    }
}
