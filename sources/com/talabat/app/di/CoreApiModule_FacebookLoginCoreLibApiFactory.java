package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.facebook.login.domain.FacebookLoginCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_FacebookLoginCoreLibApiFactory implements Factory<Api> {
    private final Provider<FacebookLoginCoreLibApi> facebookLoginCoreLibApiProvider;

    public CoreApiModule_FacebookLoginCoreLibApiFactory(Provider<FacebookLoginCoreLibApi> provider) {
        this.facebookLoginCoreLibApiProvider = provider;
    }

    public static CoreApiModule_FacebookLoginCoreLibApiFactory create(Provider<FacebookLoginCoreLibApi> provider) {
        return new CoreApiModule_FacebookLoginCoreLibApiFactory(provider);
    }

    public static Api facebookLoginCoreLibApi(FacebookLoginCoreLibApi facebookLoginCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.facebookLoginCoreLibApi(facebookLoginCoreLibApi));
    }

    public Api get() {
        return facebookLoginCoreLibApi(this.facebookLoginCoreLibApiProvider.get());
    }
}
