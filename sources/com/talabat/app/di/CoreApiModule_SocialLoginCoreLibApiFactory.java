package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.social.login.domain.SocialLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_SocialLoginCoreLibApiFactory implements Factory<Api> {
    private final Provider<SocialLoginCoreLibApi> socialLoginCoreLibApiProvider;

    public CoreApiModule_SocialLoginCoreLibApiFactory(Provider<SocialLoginCoreLibApi> provider) {
        this.socialLoginCoreLibApiProvider = provider;
    }

    public static CoreApiModule_SocialLoginCoreLibApiFactory create(Provider<SocialLoginCoreLibApi> provider) {
        return new CoreApiModule_SocialLoginCoreLibApiFactory(provider);
    }

    public static Api socialLoginCoreLibApi(SocialLoginCoreLibApi socialLoginCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.socialLoginCoreLibApi(socialLoginCoreLibApi));
    }

    public Api get() {
        return socialLoginCoreLibApi(this.socialLoginCoreLibApiProvider.get());
    }
}
